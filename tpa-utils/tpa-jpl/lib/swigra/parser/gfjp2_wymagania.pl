%
% Predykat obsługujący wysycanie wymagań czasownikowych 
% w gramatyce Świdzińskiego.
%
%
% Copyright © 1997-2007,2010 Marcin Woliński
%
% This program is free software; you can redistribute it and/or modify
% it under the terms of the GNU General Public License version 3 as
% published by the Free Software Foundation.
%
% This program is distributed in the hope that it will be useful,
% but WITHOUT ANY WARRANTY; without even the implied warranty of
% MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
% GNU General Public License for more details.
%
% You should have received a copy of the GNU General Public License
% along with this program; if not, write to the Free Software
% Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
% MA 02110-1301, USA 
%
% In addition, as a special exception, the copyright holder gives
% permission to link the code of this program with the Morfeusz library
% (see http://www.nlp.ipipan.waw.pl/~wolinski/morfeusz), and distribute
% linked combinations including the two. You must obey the GNU General
% Public License in all respects for all of the code used other than
% Morfeusz. If you modify this file, you may extend this exception to
% your version of the file, but you are not obligated to do so. If you
% do not wish to do so, delete this exception statement from your
% version.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% REPREZENTACJA WYMAGAŃ:
%
% Atrybut Wym ma postać wym(SwW, Uż, Ramki) gdzie
%
% • SwW jest listą wysyconych wymagań do pokazania w drzewie.
%
% • Uż reprezentuje dziewiczość: użyte oznacza, że wymagania zostały
%   częściowo wysycone, czyste(_) — że nie.  Argumentem tego termu
%   jest ‹proste›, jeśli to pojedynczy czasownik, oraz oznaczenie typu
%   koordynacji poziomu o jeden niżej wpp.
%
% • Ramki albo jest listą schematów, albo ma postać koord([Ramki…]) —
% ta ostatnia postać potrzebna gdy mamy frazę werbalną ze
% skoordynowanymi kilkoma czasownikami.  Pojedynczy schemat jest listą
% pozycji, które są listami (typów) argumentów (które mogą się
% koordynować na tej pozycji).  Przy realizacji argumentu A znajduje
% się wszystkie ramki, które zawierają pozycje, które go zawierają;
% wynikiem staje się lista tych ramek, ale z pozycją wypełnioną przez
% A wyjętą.  W wypadku koord(…) A musi się dać wyjąć co najmniej z
% jednego schematu na każdej liście schematów (czyli musi się dać
% zrealizować przy każdym z koordynowanych czasowników).
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


% Procedura wyjmująca wymaganie typu E (wywoływana z gramatyki)
% Rozkapsułkowuje termy wym/3 i przekazuje listę schematów do wyjmijwymaganie2

wyjmijwymaganie(E/Lex, wym([E|S],U,W), wym(S,U,NW)) :-
	wyjmijwymaganie2(E, Lex, W, NW),
	NW = [_|_].
wyjmijwymaganie(E/Lex, wym([E|S],U,koord(W)), wym(S,U,koord(NW))) :-
	wyjmij_skoordynowane_wymaganie(E/Lex, W, NW).


% Poniższe wywoływane zarówno przez wyjmijwymaganie jak i oblwym_iter.
% Argumenty: typ wymagania, lista schematów, wynikowa lista z wyjętym

wyjmijwymaganie2(_, _, [], []).
wyjmijwymaganie2(E, Lex, [W|WW], [NW|NWW]) :-
	wyjmij(E, Lex, W, NW), !,
	wyjmijwymaganie2(E, Lex, WW, NWW).
wyjmijwymaganie2(E, Lex, [_|WW], NW) :-
	wyjmijwymaganie2(E,Lex,WW,NW).


% Wersja dla list wymagań fraz skoordynowanych
% Wymaganie E musi dać się wyjąć z każdego ze skoordynowanych członów:
wyjmij_skoordynowane_wymaganie(_, [], []).
wyjmij_skoordynowane_wymaganie(E/Lex, [W|WW], [NW|NWW]) :-
	wyjmijwymaganie2(E, Lex, W, NW),
	NW = [_|_],
	wyjmij_skoordynowane_wymaganie(E/Lex, WW, NWW).

% Sprawdza, czy E jest jednym z typów wymagań dla schematu będącego drugim argumentem:
% Uwaga: zdeterminizowany za pomocą czerwonego odcięcia!
wyjmij( subj(E), Lex, [subj(EW)|L], L ) :- sprawdź_wymaganie(E,Lex,EW), !.
wyjmij( E, Lex, [EW|L], L ) :- sprawdź_wymaganie(E,Lex,EW), !.
wyjmij( E, Lex, [F|L], [F|K] ) :- wyjmij( E, Lex, L, K ).

% czy wymaganie E jest elementem pozycji EW?:
% E jest listą, czyli jest to kooordynacja wewnątrz pozycji:
sprawdź_wymaganie(E,Lex,EW) :- E = [_|_], !,
			   sprawdź_wymaganie_koord(E,EW).
sprawdź_wymaganie(E,_Lex,EW) :- member(E,EW).
sprawdź_wymaganie(E,Lex,EW) :- member(lex(E,Lex1,_),EW),
			       deorify_lex(Lex1, Lex).

% Wydłubywarka specyfikacji leksów z zapisów typu
% [sg,[broń,oręż]^ (xor)]
% [[dwa,kilka]^ (xor),sroka]
% [_G314,[twarz,usta,warga]^or]
% (UWAGA: na razie ignorujemy rozróżnienie między OR i XOR).
deorify_lex([],[]).
deorify_lex([P | OtherParams ], [P1 | OtherParamsDeorified]) :- var(P), !, P=P1,
    deorify_lex(OtherParams, OtherParamsDeorified).
deorify_lex([Lemmas^OR|OtherParams],[Lemma|OtherParamsDeorified]) :- !,
    member(Lemma,Lemmas), member(OR,[or,xor]),
    deorify_lex(OtherParams, OtherParamsDeorified).
deorify_lex([P | OtherParams ], [P | OtherParamsDeorified]) :-
    deorify_lex(OtherParams, OtherParamsDeorified).

%%%% Zawód odmalował się na twarzy Feliksa.
%%%% Zawód odmalował się na gębie Feliksa.
%%%% Zawód odmalował się na buzi Feliksa.


% Koordynacja wewnątrz pozycji:
% wszystkie typy fraz z pierwszego argumentu muszą dać się wyjąć z opisu tej pozycji
sprawdź_wymaganie_koord([E|EE], EW) :-
    member(E,EW),
    sprawdź_wymaganie_koord(EE, EW).
sprawdź_wymaganie_koord([], _).

% Wyjmuje wszystkie typy wymagań wymienione w pierwszym argumentu z
% listy schematów będącej drugim (wywoływane z gramatyki):
wyjmijl( [], L, L ) :- !.
wyjmijl( [E|EE], L, K ) :- wyjmijwymaganie(E, L, LL), wyjmijl(EE,LL,K).


% Warunek iterowany wysycający kolejne wymaganie E:
oblwym_iter(wym([E|S],U,koord(W)), E/Lex, wym(S,U,koord(NW))) :- !,
	wyjmij_skoordynowane_wymaganie(E/Lex, W, NW).
oblwym_iter(wym([E|S],U,W), E/Lex, wym(S,U,NW)) :- !,
	wyjmijwymaganie2(E, Lex, W, NW),
	NW = [_|_].


% wersja z argumentem pożyczonym od jednej z fraz wymaganych:
%
% W1/H1 jest charakterystyką argumentu pożyczonego, który musi zostać
% zrealizowany przy frazie wymaganej
oblwym_ξ_iter(wym([E|S],U,koord(W))/Wymξ, E/Lex, wym(S,U,koord(NW))/Wymξ) :- !,
    wyjmij_skoordynowane_wymaganie(E/Lex, W, NW).
oblwym_ξ_iter(wym([E|S],U,W)/(W1/H1), (E/WymW)/Lex, wym(S,U,NW)/nil) :- !,
    wyjmijwymaganie2(E, Lex, W, NW),
    NW = [_|_],
    oblwym_iter(WymW, W1/H1, WymW2),
    wymagania_zamknij(WymW2).
oblwym_ξ_iter(wym([E|S],U,W)/Wymξ, E/Lex, wym(S,U,NW)/Wymξ) :- !,
	wyjmijwymaganie2(E, Lex, W, NW),
	NW = [_|_].

% Warunek iterowany dla frazy odłączonej (obcej).  
% wywoływany ^[wykryjξ, nil, W/H, Wymξ]
% Dopuszcza tylko jedno wystąpienie.
% Jeśli było, to Wymξ=W/H tego wystąpienia, jeśli nie było, to
% =nil, co będzie potem wykryte przez oblwym_ξ_iter
% Definicja warunku jest zaskakująco krótka w porównaniu z powyższym opisem:
wykryjξ(nil, W/H, W/H).

% Wariant zbierania wymagań w listę dopuszczający frazę z dziurą
% (która ma coś w rodzaju Tfw=[subj(np(nom))]/[cp(int)])
% Jeżeli wystąpiła fraza z dziurą, to /Wym stanie się różne od nil
zróblistę_ξ_iter(WW/Wym0, W1/Wym1/H1, [W1/H1|WW]/Wym1) :- !, Wym0=nil.
zróblistę_ξ_iter(WW/Wym, W, [W|WW]/Wym).

% Warunek iterowany dla frazy odłączonej w postpozycji.
% wywoływany ^[zrealizujξ, Wym, W/H, nil]
% Dopuszcza tylko jedno wystąpienie.
% Wym jest opisem wymagań frazy z dziurą (stojącej wcześniej, więc wartość znana).
zrealizujξ(Wym, W/H, nil) :-
    oblwym_iter(Wym, W/H, Wym2),
    wymagania_zamknij(Wym2).


% OBLICZENIE WYMAGAŃ FRAZY SKOORDYNOWANEJ:
% Teraz mi się wydaje, że z koordynacji zawsze powinno wychodzić
% ‹czyste(_)›. Zobaczmy, jak to będzie działać:
oblwym_koord(wym(SwW,czyste(Oz),koord(Dowyp)), Oz, WymL) :-
	oblwym_koord(SwW,Dowyp,Oz,WymL).

oblwym_koord(_SwW, [], _, []) :- !.
oblwym_koord(SwW, Wym, Oz, [wym(SwW, _U1, koord(Wym1)) | WymL]) :- !,
	append(Wym1, Dowyp, Wym),
	oblwym_koord(SwW, Dowyp, Oz, WymL).
oblwym_koord(SwW, [Wym1 | Dowyp], Oz, [wym(SwW, _U1, Wym1) | WymL]) :-
	is_list(Wym1),
	oblwym_koord(SwW, Dowyp, Oz, WymL).

% oblwym_koord(_SwW, czyste(_), [], []).
% oblwym_koord(SwW, U, Wym, [wym(SwW, U1, koord(Wym1)) | WymL]) :- !,
% 	append(Wym1, Dowyp, Wym),
% 	oblwym_koord(SwW, U2, Dowyp, WymL),
% 	obl_użytość(U,U1,U2).
% oblwym_koord(SwW, U, [Wym1 | Dowyp], [wym(SwW, U1, Wym1) | WymL]) :-
% 	is_list(Wym1),
% 	oblwym_koord(SwW, U2, Dowyp, WymL),
% 	obl_użytość(U,U1,U2).

% obl_użytość(użyte,użyte,_) :- !.
% obl_użytość(użyte,_,użyte) :- !.
% obl_użytość(czyste(_),_,_).


% Predykat skutkuje, o ile jego drugi argument reprezentuje dziewicze,
% niezrealizowane wymagania (tylko takie wymagania mogą być we frazie
% finitywnej):
% Dodatkowo ujawnia oznaczenie typu czystości:

wymagania_czyste(Oz,wym(_,czyste(Oz),_)).

% Oznacza wymagania jako częściowo wysycone:
wymagania_oznacz_użyte(wym(SwW,_,W),wym(SwW,użyte,W)).

% Predykat skutkuje, o ile jego argument reprezentuje wymagania
% skoordynowane:

wymagania_skoordynowane(wym(_,_,koord(_))).

wyklucz_przecinkowość_w_szeregu([]) :- !.
wyklucz_przecinkowość_w_szeregu([_]) :- !.
wyklucz_przecinkowość_w_szeregu([Wym1 | WymL]) :-
	Wym1 \= wym(_,czyste(sz:przec),_),
	wyklucz_przecinkowość_w_szeregu(WymL).


% wersja z uwolnionym ‘się’: nie ma prawa zostać niewykorzystane ‘sie’
resztawym(W) :-
%	format(user_error,"~NReszta wymagań: ~p~n",[W]),
    odfiltrujsie(W,BEZSIE),
%	format(user_error,"~NReszta bez się: ~p~n",[BEZSIE]),
    odfiltrujlex(BEZSIE,BEZLEX),
%	format(user_error,"~NReszta bez lex: ~p~n",[BEZLEX]),
    BEZLEX \= [].

% Sygnalizuje zakończenie procesu wysycania danego zestawu wymagań i
% sprawdza, czy nie zostały niewysycone elementy obowiązkowe (na razie
% ‹się›, ale dodamy fixy z Walentego):
wymagania_zamknij(wym([],_U,bw)) :- !. % dodane na okoliczność domykania fno w w7
wymagania_zamknij(wym([],_U,koord(OWW))) :- !, sprawdz_wszystkie_reszty(OWW).
wymagania_zamknij(wym([],_U,OW)) :- !, resztawym(OW).

% To jest tymczasowe rozwiązanie dla problemu gerundiów zwrotnych,
% przy których puszczamy „się” na żywioł.  Trzeba zrobić porządniej,
% jak wprowadzimy lexy z Walentego.
wymagania_zamknij_nieuważnie(wym([],_U,_)).

% Na razie wprowadzam to na okoliczność objęcia frazy w cudzysłowy:
% ‹atakowany „nurt realistyczny”› — normalnie fno powinno przyjąć
% podrzędniki w jednym rzucie, ale jak ujmiemy w cudzysłów, to możliwe
% przyłączenie kolejnych.  Na dobrą sprawę należałoby zapewnić
% faktyczne wysycanie wymagań po odemknięciu, ale to by wymagało
% reorganizacji ich reprezentacji, więc na razie dopuszczam luźne.
wymagania_odemknij(wym(SwW,U,bw), wym(SwW,U,[[]])) :- !.
wymagania_odemknij(wym(SwW,użyte,W), wym(SwW,czyste(proste),W)) :- !.
wymagania_odemknij(wym(SwW,U,W), wym(SwW,U,W)).

% Analogiczna operacja na potrzeby fwe, gdzie usuwamy znacznik użycia:
wymagania_oznacz_czyste(wym(SwW,użyte,W), wym(SwW,czyste(proste),W)) :- !.
wymagania_oznacz_czyste(wym(SwW,U,W), wym(SwW,U,W)).
%%%% Piotr „czyta książkę”.


sprawdz_wszystkie_reszty([]).
sprawdz_wszystkie_reszty([R|RR]) :- resztawym(R), sprawdz_wszystkie_reszty(RR).

odfiltrujsie([],[]).
odfiltrujsie([R|RR], W) :-
	(%member(sie,R),
	 wyjmij(sie, sie,R,_)
	-> W = WW
	; W=[R|WW]),
	odfiltrujsie(RR,WW).


odfiltrujlex([],[]).
odfiltrujlex([R|RR], W) :-
	(wyjmij(lex(_,_,_),lex,R,_)
	-> W = WW
	; W=[R|WW]),
	odfiltrujlex(RR,WW).



% Poniższy predykat jest używany do podmiany wybranych argumentów w
% ramkach.  A1 jest argumentem, a A2 — listą argumentów, na którą
% należy zamienić A1, w szczególności pustą, jeśli argument A1 ma być
% pominięty.

zamień_argument(_, _, koord(A), _) :- throw(koord_in_zamień_argument(A)).
zamień_argument(_, _, [], []) :- !.
zamień_argument(A1, A2, [W|WW], [NW|NWW]) :-
	zamień_argument_pom(A1, A2, W, NW),
	zamień_argument(A1, A2, WW, NWW).

% przy zamienianiu trzeba uwzględnić, że typ argumentu może siedzieć pod leksem:
pasujący_argument(A,A).
pasujący_argument(A,lex(A,_,_)).

zamień_argument_pom(_, _, [], []) :- !.
%zamień_argument_pom(A1, A2, [subj(P)|W], NW) :- 
zamień_argument_pom(A1, A2, [P|W], NW) :-
    % sprawdzamy, że 3. arg niepusty, czyli były pasujące elementy:
    partition(pasujący_argument(A1), P, [_|_], P1), !,
    append(A2,P1,P2),
    (P2 = [] *-> NW=WW; NW = [P2|WW]),
    zamień_argument_pom(A1,A2, W, WW).
zamień_argument_pom(A1, A2, [A|W], [A|NW]) :-
	zamień_argument_pom(A1, A2, W, NW).

% Poniższe zamienia zawartość pozycji subj(…) na listę pozycji Poz
% (np. [[np(gen)]]).  Lista może być pusta — oznacza to usunięcie
% pozycji podmiotowej.

zamień_subj(Poz, koord([Sch|SS]), koord([SchBezSubj|SSBS])) :-
    !,
    zamień_subj(Poz, Sch, SchBezSubj),
    zamień_subj(Poz, koord(SS), koord(SSBS)).
zamień_subj(_Poz, koord([]), koord([])) :- !.
zamień_subj(_Poz, [], []) :- !.
zamień_subj(Poz, [Sch|SS], [SchBezSubj|SSBS]) :-
    select(subj(_), Sch, Sch2), !,
    append(Sch2, Poz, SchBezSubj),
    zamień_subj(Poz, SS, SSBS).
zamień_subj(Poz, [S|SS], [S|NSS]) :-
    zamień_subj(Poz, SS, NSS).


% Pobieranie wymagań czasownikowych ze słownika.  Tutaj, bo
% dostosowuje format wymagań do wersji procedury obsługującej wymagania

rekcja_finitywna(H, wym(_,czyste(proste),
% domyślna ramka używana, gdy nie mamy czasownika w słowniku:
	       [
		[subj([np(nom)]),[np(accgen)],[np(dat)]],
		[subj([np(nom)]),[np(accgen)],[np(inst)]],
		[subj([np(nom)]),[np(accgen)],[np(gen)]],
		[subj([np(nom)]),[np(accgen)],[xp(_)]],
		[subj([np(nom)]),[np(accgen)],[cp(_)]],
		[subj([np(nom)]),[np(accgen)],[infp(_)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(bez,gen)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(dla,gen)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(do,gen)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(na,acc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(na,loc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(o,acc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(o,loc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(od,gen)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(po,acc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(po,loc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(przed,inst)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(przez,acc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(przy,loc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(u,gen)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(w,acc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(w,loc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(wobec,gen)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(z,gen)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(z,inst)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(za,acc)]],
		[subj([np(nom)]),[np(accgen)],[prepnp(za,inst)]],
		[subj([np(nom)]),[np(dat)],[infp(_)]],
		[subj([np(nom)]),[np(dat)],[cp(_)]],
% musimy dopuszczać możliwość, że czasownik jest sięiczny:
		[subj([np(nom)]),[sie],[np(inst)]],
		[subj([np(nom)]),[sie],[np(gen)]],
		[subj([np(nom)]),[sie],[xp(_)]],
		[subj([np(nom)]),[sie],[prepnp(bez,gen)]],
		[subj([np(nom)]),[sie],[prepnp(dla,gen)]],
		[subj([np(nom)]),[sie],[prepnp(do,gen)]],
		[subj([np(nom)]),[sie],[prepnp(na,acc)]],
		[subj([np(nom)]),[sie],[prepnp(na,loc)]],
		[subj([np(nom)]),[sie],[prepnp(o,acc)]],
		[subj([np(nom)]),[sie],[prepnp(o,loc)]],
		[subj([np(nom)]),[sie],[prepnp(od,gen)]],
		[subj([np(nom)]),[sie],[prepnp(po,acc)]],
		[subj([np(nom)]),[sie],[prepnp(po,loc)]],
		[subj([np(nom)]),[sie],[prepnp(przed,inst)]],
		[subj([np(nom)]),[sie],[prepnp(przez,acc)]],
		[subj([np(nom)]),[sie],[prepnp(przy,loc)]],
		[subj([np(nom)]),[sie],[prepnp(u,gen)]],
		[subj([np(nom)]),[sie],[prepnp(w,acc)]],
		[subj([np(nom)]),[sie],[prepnp(w,loc)]],
		[subj([np(nom)]),[sie],[prepnp(wobec,gen)]],
		[subj([np(nom)]),[sie],[prepnp(z,gen)]],
		[subj([np(nom)]),[sie],[prepnp(z,inst)]],
		[subj([np(nom)]),[sie],[prepnp(za,acc)]],
		[subj([np(nom)]),[sie],[prepnp(za,inst)]],
		[subj([np(nom)]),[sie],[np(dat)],[infp(_)]],
		[subj([np(nom)]),[sie],[np(dat)],[cp(_)]]
	       ])) :-
	\+ slowczas(H,_), !.
%rekcja(H,_,_) :-
%	\+ slowczas(H,_),
%	!, throw(morf(wymagania, H)).
rekcja_finitywna(H,wym(_SwWym,czyste(proste),Wym)) :-
	slowczas(H,Wym).

rekcja_niefinitywna(H, wym(_,U,NWym)) :-
	rekcja_finitywna(H, wym(_,U,Wym)),
	zamień_subj([], Wym, NWym).

%% Wymagania gerundiów:

rekcja_gerundialna(H, wym(_SwWym, czyste(proste), Wym)) :-
	slowczas(H, WymC), !,
	zamień_subj([[np(gen),prepnp(przez,acc)]], WymC,WymC1),
	zamień_argument(np(accgen), [np(gen)], WymC1, WymC2),
	zamień_argument(ncp(accgen,Sp), [ncp(gen,Sp)], WymC2, WymC3),
	zamień_argument(np(part), [np(gen)], WymC3, Wym).
rekcja_gerundialna(_H, wym(_SwWym,czyste(proste),[[[prepnp(przez,acc),np(gen)]]])).

%% Wymagania rzeczowników:

rekcja_nominalna(H, wym(_SwWym,czyste(proste), Wym)) :-
	slowrzecz(H, Wym), !.
rekcja_nominalna(_H, wym(_SwWym,czyste(proste),[[]])).

%% Wymagania przymiotników:

rekcja_przymiotnikowa(H, wym(_SwWym,czyste(proste), Wym)) :-
	slowprzym(H, Wym), !.
rekcja_przymiotnikowa(_H, wym(_SwWym,czyste(proste),[[]])).

%% Wymagania wykrzykników:

rekcja_wykrzyknikowa(H, wym(_SwWym,czyste(proste), Wym)) :-
	s_wykrz(H, Wym), !.
rekcja_wykrzyknikowa(_H, wym(_SwWym,czyste(proste),[[]])).

%% Wymagania imiesłowów:

rekcja_ppas(H, wym(_SwWym,czyste(proste), Wym)) :-
	slowczas(H, WymC), !,
	zamień_subj([[prepnp(przez,acc)]], WymC, WymC1),
	zamień_argument(np(accgen), [], WymC1, WymC2),
	zamień_argument(np(part), [], WymC2, Wym).
rekcja_ppas(_H, wym(_SwWym,czyste(proste),[[[prepnp(przez,acc)]]])).

rekcja_pact(H, wym(_SwWym,czyste(proste), Wym)) :-
	slowczas(H, WymC), !,
	zamień_subj([], WymC, Wym).
rekcja_pact(_H, wym(_SwWym,czyste(proste),[[]])).

rekcja_zdanioidowa(wym(_,czyste,
		       [
			   [[adjp(_)]],
			   [subj([np(nom)]),[adjp(nom)]], % „Wstęp wzbroniony.”
			   [subj([np(nom)]),[xp(_)]], % „Pod drzwiami pikieta.”
			   [subj([np(nom)]),[np(accgen)],[np(dat)]],
			   [subj([np(nom)]),[np(accgen)],[np(inst)]],
			   [subj([np(nom)]),[np(accgen)],[np(gen)]],
			   [subj([np(nom)]),[np(accgen)],[xp(_)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(bez,gen)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(dla,gen)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(do,gen)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(na,acc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(na,loc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(o,acc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(o,loc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(od,gen)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(po,acc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(po,loc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(przed,inst)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(przez,acc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(przy,loc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(u,gen)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(w,acc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(w,loc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(wobec,gen)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(z,gen)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(z,inst)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(za,acc)]],
			   [subj([np(nom)]),[np(accgen)],[prepnp(za,inst)]]
		  ])).



%% Wymagania puste (używane do inicjowania atrybutu Wym gdy nie
%% pobieramy ze słownika):

rekcja_pusta(wym(_SwW, czyste(proste), [[]])).

%% Wymagania blokujące wejście w wysycanie wymagań:

rekcja_zablokowana(wym(_SwW, czyste(proste), bw)).

% predykat używany w GFJP1:

rekcja(H,_S,W) :- rekcja_finitywna(H,W).


wykluczpodmiot(wym(SwW,U,W), wym(SwW,U,NW)) :-
    zamień_subj([], W, NW).

% Poniższy predykat jest używany w zdaniu elementarnym do wykluczenia
% realizacji podmiotu, jeżeli wyróżnik fleksyjny ma wartość
% bezokolicznika.  Odbywa się to po zgromadzeniu wszystkich
% argumentów, ponieważ posiłk przekształcający bok w os może wystąpić
% zarówno przed jak i za ff.  Tak więc najpierw wymagania są
% realizowane cokolwiek optymistycznie dopuszczając podmiot, ale jeśli
% końcową wartością Wf pozostanie bok, to taka realizacja z podmiotem
% jest odrzucana.
wyklucz_podmiot_bezokolicznika(Wf,_Wym) :- Wf \= bok, !.
wyklucz_podmiot_bezokolicznika(bok,wym(SwW,_Wym,_)) :-
	\+ member(subj(_), SwW).


% LEKSYKALIZACJA

% Poniższe służą do obliczenia charakterystyk centrów leksykalnych
% pojawiających się w Walentym przy frazach poszczególnych typów. Na
% przykład dla np jest to liczba i lemat.

typ_dla_np(subj(Wym), subj(Tfw), H, RL) :- !, typ_dla_np(Wym, Tfw, H, RL).
typ_dla_np(Tfw, Tfw, _H, _RL).
typ_dla_np(lex(Tfw, [Num,H], _), Tfw, H, _R/L) :- num2licz(Num,L).


lex_dla_np([Num,H], H, _R/L) :- var(H), !, H='', num2licz(Num,L).
lex_dla_np([Num,H], H, _R/L) :- num2licz(Num,L).

% niestety w sgjp2_morfologia musi być jeszcze sg.pl i nie da się tamtego użyć. :-(
num2licz(sg,poj).
num2licz(pl,mno).

lex_dla_advp([Deg,H], H, St) :- var(H), !, H='', stopien(Deg,St).
lex_dla_advp([Deg,H], H, St) :- stopien(Deg,St).

%%% Local Variables: 
%%% coding: utf-8
%%% mode: prolog
%%% End: 
