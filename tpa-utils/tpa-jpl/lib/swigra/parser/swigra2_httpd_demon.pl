% -*- prolog -*-
%
% swipl --traditional swigra2_httpd_demon.pl --port=3333 --workers=1

% To ze wzgledu na Windows, gdzie UTF-8 nie wydaje sie byc domyslny:
:-encoding(utf8).
:-set_prolog_flag(encoding,utf8).


:- use_module(library(http/http_unix_daemon)).
:- initialization http_daemon.
%:-use_module(library(http/xpce_httpd)).
%:-use_module(library(http/thread_httpd)).
:-use_module(library(http/http_dispatch)).
:-use_module(library(http/http_parameters)).
:-use_module(library(http/html_write)).
:-use_module(library(http/http_server_files)). % pliki statyczne

:-html_set_options([dialect(xhtml)]).

% Potrzebne moduły Birnama i Świgry:
:-[
   birnam_run,
   birnam_dumpedges,
   forest2xml,
   gfjp2_morfologia,
   gfjp_slowskr,
   gfjp_slowpart,
   slowczas, slowrzecz, slowprzym, slowwykrz, walenty_realizacje,
   gfjp_analiza,
   gfjp2_wymagania,
   birnam_sequences,
   gfjp2_warunki,
   gfjp2,
   gfjp2_arnoscint,
   gfjp_swidzinskify
].

% moduł dumpedges pisze do pliku, potrzebujemy to zmienić, żeby od
% razu poddać wynik transformacji do XML-a:

:-abolish(dumpterm/1).
dumpterm(porazka) :- !.
dumpterm(T) :-
	assertz(T).
:-abolish(initdump/0).
initdump.


% zaszłość ze Świgry 1, której już nie potrzebujemy:
:-abolish(dodajprzec/3).
dodajprzec(_Od, _Do, _Add).


% Predykat odpowiadający na przychodzące do serwera żądanie /swigra :
run_świgra(Request) :-
	http_parameters(Request,
			[q(Query, [default(''), length =< 200]),
			dis(Disambiguator, [default(maxent)])]
		       ),
	check_default(Query,Text,IsDefault),
	catch(świgruj(Text,Disambiguator,IsDefault),morf(nieznane,Ign), generuj_przeprosiny_morf(Text,Ign,Disambiguator)),
	retractall(known_identifier(_,_,_,_)),
	abolish(edge/6),
	abolish(info/2).

check_default('','Czytali ciekawe książki z obrazkami.',default) :- !.
check_default(Text, Text, non_default).

świgruj(Text,Disambiguator,IsDefault) :-
    analiza(Text),
    statprint(sent_id,no_id), % forest2xml wymaga identyfikatora zdania
    random_between(0,99999,Rand),
    format(atom(ForestId),'~|~`0t~d~5+',Rand), %  integer zero padded to 5 positions
    format(atom(ForestFile),'./httpd/forests/~a.xml', ForestId),
    open(ForestFile,write,XMLStream,[encoding(utf8)]),
    forest2xml(XMLStream),
    close(XMLStream),
    dezambiguj(Disambiguator,ForestId),
    generate_the_page(Text,Disambiguator,ForestId,IsDefault).

dezambiguj(pcfg,ForestId) :- !,
  format(atom(Cmd),
	 'cd ../disambiguator-pcfg; python disamb-tree.py ../parser/httpd/forests/~a.xml',
	 [ForestId]),
  shell(Cmd).

dezambiguj(maxent,ForestId) :- !,
  format(atom(Cmd),
	 'cd ../disambiguator-maxent; python disamb-tree.py ../parser/httpd/forests/~a.xml',
	 [ForestId]),
  shell(Cmd).

dezambiguj(none,ForestId) :-
    format(atom(Cmd),
	   'cp httpd/forests/~a.xml httpd/forests/~a-disamb.xml',
	   [ForestId,ForestId]),
    shell(Cmd).

generuj_przeprosiny_morf(Text,Ign,Disambiguator) :-
    length(Ign, Ilu),
    (Ilu > 1 *->
	     format(atom(Przepro), 'Niestety nie znam ~p słów: ~p.', [Ilu, Ign])
     ;
	     format(atom(Przepro), 'Niestety nie znam słowa „~a”.', Ign)
    ),
    reply_html_page(
	    [title('Świgra: ~p' - [Text]),
	     link([ href('swigra.css'), rel(stylesheet), type('text/css')], [])
	    ],
        body([],
	     [ center(table([width('98%'), border(0 ),
		      cellpadding(0 ), cellspacing(2 )],
		     [tr(td([bgcolor('#26264f'),height(14)],
			    [])),
		      tr(td([bgcolor('#c3d0e4'),height(24)],
			    [p(class(tytul),
			       ['Analizator składniowy ', em('Świgra 2')])])),
		      tr(td([bgcolor('#26264f'),height(7)], [])),
		      tr(td([ 
%% p('W poniższym polu prosimy wpisać kompletne zdanie do analizy (z uwzględnieniem znaków interpunkcyjnych).'),
			      \generate_query_form(Text,Disambiguator)
			      ])),
		      tr(td([bgcolor('#26264f'),height(5)],
			    [])),
		      p([],Przepro),
		      p([],'W sumie mógłbym zgadywać, ale wyniki będą pewnie lepsze, jeśli użyjesz innego słowa o tej samej charakterystyce.'),
		      tr(td([bgcolor('#778899'),height(24),align(right)],
		      'Copyright © 2007–2019 by Instytut Podstaw Informatyki PAN')),
		      tr(td([bgcolor('#26264f'),height(7)],
			    []))
		     ]))
    ])).    


% Generowanie szkieletu strony WWW:

generate_the_page(Text,Disambiguator,ForestId,IsDefault) :-
    format(atom(Viewer_location),
	   '	viewer.set_location("forests/~a-disamb.xml");
',
	   [ForestId]),
	reply_html_page(
	[title('Świgra: ~p' - [Text]),
	 link([ href('swigra.css'), rel(stylesheet), type('text/css')], []),
	 script([ type('application/javascript'), src('viewer.js') ],[]),
	 script([ type('application/javascript'), src('viewer_helpers.js') ],[]),
	 script([ type('application/javascript')], \ ['<![CDATA[
function init() {
','
	var viewer = new forestviewer(document.getElementById("viewer"));
','
	viewer.helper = tree_helpers;
	viewer.style = "simple";
	viewer.variablewidth = true;
	viewer.nativescroll = true;
',Viewer_location,'
	viewer.display.height=500;
        viewer.display.style.position = "relative";
}]]>']),
	 link([ href('viewer.css'), rel(stylesheet), 
	        type('text/css')], [])
        ],
        body([onload('init()')],
	     [ center(table([width('98%'), border(0 ),
		      cellpadding(0 ), cellspacing(2 )],
		     [tr(td([bgcolor('#26264f'),height(14)],
			    [])),
		      tr(td([bgcolor('#c3d0e4'),height(24)],
			    [p(class(tytul),
			       ['Analizator składniowy ', em('Świgra 2')])])),
		      tr(td([bgcolor('#26264f'),height(7)], [])),
		      \generate_wprowadzenie(IsDefault),
		      tr(td([ 
			      \generate_query_form(Text,Disambiguator)
			      ])),
		      tr(td([bgcolor('#26264f'),height(5)],
			    [])),
		      div([id(viewer)],[]),
		      div([id(generalinfo)],[]),
		      \generate_statistics,
		      tr(td([bgcolor('#778899'),height(24),align(right)],
		      'Copyright © 2007–2019 by Instytut Podstaw Informatyki PAN')),
		      tr(td([bgcolor('#26264f'),height(7)],
			    []))
		     ]))
    ])).

%% To jest za nowe (można kiedyś spróbować przywrócić, wtedy będzie
%% można użyć normalnego reply_html_page powyżej):
%% (Ale właściwie nie ma powodu, bo okazało się, że atrybut da się dodać. Zob.wyż.)
%% :- multifile
%%         user:body//2.
%%
%% user:body(_, Body) -->
%%         html(body([onload('init()')], div(Body))).


generate_wprowadzenie(default) -->
    !,
    html([tr(td([p(['Niniejszy serwis prezentuje możliwości składnikowego analizatora składniowego ',
		    a([href('http://zil.ipipan.waw.pl/Świgra')],'Świgra 2'),
		    '. Stosowany jest analizator fleksyjny ',
		    a([href('http://morfeusz.sgjp.pl')],'Morfeusz 2 SGJP'),
		    ' i słownik walencyjny ',
		    a([href('http://walenty.ipipan.waw.pl/')],'Walenty'),
		    ', dzięki czemu dostępny jest obszerny zasób leksykalny. ',
		    'Wyniki analizy fleksyjnej nie są ujednoznaczniane (nie jest używany tager), nie ma też mechanizmu zgadującego interpretacje dla nieznanych słów. ',
		    'Parser generuje las składniowy reprezentujący wszystkie drzewa odpowiadające niejednoznacznościom fleksyjnym i składniowym. ',
		    'Program jest uruchamiany z pełną wersją gramatyki Świgra 2.  '
		   ]),
		 p(['Wyniki analizy składniowej mogą być ujednoznacznione za pomocą metody wykorzystującej modelowanie maksimum entropii albo metody wzorowanej na PCFG. ',
		    'Domyślnie wyświetlane jest drzewo wybrane przez moduł ujednoznaczniający. ',
		    'W niejednoznacznych wierzchołkach wyświetlane są strzałki pozwalające przełączać wizualizację między możliwymi realizacjami danego wierzchołka. ',
		    'Pozwala to w szczególności odnaleźć poprawne drzewo wśród wyników parsera w wypadku błędnego wyboru dokonanego przez moduł ujednoznaczniający. '
		      ]),
    		 p(['W poniższym polu należy wpisać kompletne zdanie do analizy (z uwzględnieniem znaków interpunkcyjnych). ',
		    'Serwis ma charakter demonstracyjny, ze względu na obciążenie serwera prosimy o ograniczenie użycia do niezbyt długich zdań. ',
		    'Do przetwarzania większej ilości tekstu sugerujemy ',
		    a([href('http://zil.ipipan.waw.pl/Świgra')],'instalację programu na własnym komputerze'),
		    '. '
])
		] )),
    	  tr(td([bgcolor('#26264f'),height(7)], []))
    	 ]).
generate_wprowadzenie(_) --> [].

% Formularz pozwalający wpisać zdanie:

generate_query_form(Text,Disambiguator) -->
	html( form( ['accept-charset'('UTF-8'),
		     action('swigra'), method('get')],
		    [p([ input( [size( 80 ),
				 name(q),
				 value(Text)],
				[]),
			 ' ',
			 \generate_select_dis(Disambiguator),
			 ' ',
			 input( [type(submit),
				 value('Analizuj')],
				[])
			])
		     ])
	      ).


generate_select_dis(none) --> !,
    html( select([name(dis)],[
		     option([value(pcfg)],['ujedn. PCFG']),
		     option([value(maxent)],['ujedn. Maxent']),
		     option([value(none),
			     selected(selected)],['bez ujednoznacznienia'])
		 ])).

generate_select_dis(pcfg) --> !,
    html( select([name(dis)],[
		     option([value(pcfg),
			     selected(selected)],['ujedn. PCFG']),
		     option([value(maxent)],['ujedn. Maxent']),
		     option([value(none)],['bez ujednoznacznienia'])
		 ])).

generate_select_dis(_) --> !,
    html( select([name(dis)],[
		     option([value(pcfg)],['ujedn. PCFG']),
		     option([value(maxent),
			     selected(selected)],['ujedn. Maxent']),
		     option([value(none)],['bez ujednoznacznienia'])
		 ])).

% Część statystyczna strony:

generate_statistics -->
	{ info(parse_inferences, Infer),
	info(parse_cputime, CPU),
	info(trees, Trees),
	info(edges,Edges),
	(info(useful_edges,Useful)-> true; Useful=0) },
	html(table([tr([td('Drzew:'),td(Trees)]),
  	      tr([td('Czas analizy (s):'),td(CPU)]),
  	      tr([td('Krawędzi:'),td(Edges)]),
  	      tr([td('Użytecznych krawędzi:'),td(Useful)]),
	      tr([td('Kroków wywodu:'),td(Infer)])
	  ])
      ).

:- http_handler('/', run_świgra, []).
:- http_handler('/index.html', run_świgra, []).
:- http_handler('/swigra', run_świgra, [prefix]).

:- http_handler('/swigra.css', http_reply_file('httpd/swigra.css',[]), []).

%:- http_handler('/forest.xml', http_reply_file('httpd/forest.xml',[]), []).
%:- http_handler('/forest-disamb.xml', http_reply_file('httpd/forest-disamb.xml',[]), []).
:- http_handler('/viewer.xhtml', http_reply_file('httpd/viewer.xhtml',[]),[]).
:- http_handler('/viewer.css', http_reply_file('httpd/viewer.css',[]), []).
:- http_handler('/viewer.js', http_reply_file('httpd/viewer.js',[]), []).
:- http_handler('/viewer_helpers.js',
	http_reply_file('httpd/viewer_helpers.js',[]), []).
:- http_handler('/img/gtk-right.png',
	http_reply_file('httpd/gtk-right.png',[]), []).
:- http_handler('/img/gtk-left.png',
	http_reply_file('httpd/gtk-left.png',[]), []).
:- http_handler('/img/pinned.png',
	http_reply_file('httpd/pinned.png',[]), []).
:- http_handler('/img/unpinned.png',
	http_reply_file('httpd/unpinned.png',[]), []).

http:location(forests, root(forests), []).
user:file_search_path(forestdir, 'httpd/forests').

:- http_handler(forests(.), serve_files_in_directory(forestdir), [prefix]).

%% :- Port = 3333,
%% 	http_server(http_dispatch, [ port(Port) ]),
%% 	format(
%% "~N************************************************************************

%%                  Świgra 2 gotowa do pracy pod adresem:

%% 	                  http://localhost:~a/swigra

%% 		      Skieruj tam swojego Firefoksa.", [Port]),
%% 	format("

%% ************************************************************************
%% ").
