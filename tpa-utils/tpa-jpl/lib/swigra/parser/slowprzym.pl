% This is a generated file. Do not modify.
% Modifications should be applied to the file '20171027/adjs/walenty_20171027_adjs_all.txt' instead.
%
% Walenty: a valence dictionary of Polish
% http://zil.ipipan.waw.pl/Walenty
% version: October 27, 2017
%
% © Copyright 2012–2017 by the Institute of Computer Science, Polish
% Academy of Sciences (IPI PAN)
%
% This work is distributed under a CC BY-SA license:
% http://creativecommons.org/licenses/by-sa/4.0/
%
% Walenty is a valence dictionary of Polish developed at the Institute
% of Computer Science, Polish Academy of Sciences (IPI PAN). It currently
% contains 97293 schemata and 21997 frames for 17820 lemmata.
%
% The original formalism of Walenty was established by Filip Skwarski,
% Elżbieta Hajnicz, Agnieszka Patejuk, Adam Przepiórkowski, Marcin
% Woliński, Marek Świdziński, and Magdalena Zawisławska. It has been
% further developed by Elżbieta Hajnicz, Agnieszka Patejuk, Adam
% Przepiórkowski, and Marcin Woliński. The semantic layer has been
% developed by Elżbieta Hajnicz and Anna Andrzejczuk.
%
% The original seed of Walenty was provided by the automatic
% conversion, manually reviewed by Filip Skwarski, of the verbal valence
% dictionary used by the Świgra2 parser (6396 schemata for 1462 lemmata),
% which was in turn based on SDPV, the Syntactic Dictionary of Polish
% Verbs by Marek Świdziński (4148 schemata for 1064 lemmata). Afterwards,
% Walenty has been developed independently by adding new entries, 
% syntactic schemata, in particular phraseological ones, and semantic
% frames.
%
% Walenty has been edited and compiled using the Slowal tool
% (http://zil.ipipan.waw.pl/Slowal) created by Bartłomiej Nitoń and
% Tomasz Bartosiak.
%
% Parameters:
%     Schema opinions: pewny, wątpliwy, zły, archaiczny, potoczny, wulgarny
%     Lemma statuses: gotowe, zalążkowe, sprawdzone, (F) w obróbce, (F) gotowe, (F) sprawdzone, (S) w obróbce, (S) gotowe, (S) sprawdzone
%     Part of speech: adj
%     Opinions added: True
%
slowprzym(pełny,[[[np(gen)]]]).
slowprzym(pewien,[[[np(gen),cp(int),cp(że),ncp(gen,int),ncp(gen,że)]]]).
slowprzym(absurdalny,[[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(adekwatny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen),prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że),prepncp(do,gen,żeby)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]]]).
slowprzym(akceptowalny,[[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[xp(caus)]],[[prepnp(przez,acc)]],[[xp(locat)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(akuratny,[[[cp(żeby)]],[[prepnp('co do',gen)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]]]).
slowprzym(alternatywny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen),prepncp(dla,gen,int)]],[[prepnp(do,gen),prepncp(do,gen,int)]],[[prepnp(wobec,gen),prepncp(wobec,gen,int)]],[[prepnp(względem,gen)]]]).
slowprzym(analogiczny,[[[compar(jak)]],[[comprepnp('w stosunku do')]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,inst,int)]]]).
slowprzym(baczny,[[[cp(że)]],[[np(gen),ncp(gen,że)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]],[[prepnp(w,loc)]]]).
slowprzym(bezbłędny,[[[comprepnp('pod względem')]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(bezbronny,[[[comprepnp('w stosunku do')]],[[prepnp(przed,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(bezcenny,[[[prepnp(dla,gen)],[prepnp(przy,loc)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(bezdyskusyjny,[[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(bezkrytyczny,[[[prepnp(dla,gen)]],[[prepnp(do,gen),comprepnp('w stosunku do')]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(bezlitosny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(bezpieczny,[[[prepnp(dla,gen)],[prepnp(przy,loc)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[xp(locat)]]]).
slowprzym(bezpośredni,[[[prepnp(w,loc)]]]).
slowprzym(bezradny,[[[comprepnp('na polu')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen),prepncp(wobec,gen,int),prepncp(wobec,gen,że)]],[[prepnp(względem,gen)]]]).
slowprzym(bezsensowny,[[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(bezsilny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen),prepncp(wobec,gen,int),prepncp(wobec,gen,że)]],[[prepnp(względem,gen)]]]).
slowprzym(bezsporny,[[[cp(że)]]]).
slowprzym(bezwzględny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(biegły,[[[prepnp(w,loc)]]]).
slowprzym(bierny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[comprepnp('w zakresie')]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(bliski,[[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,int),ncp(dat,że),ncp(dat,żeby)]],[[np(gen),ncp(gen,int),ncp(gen,że),ncp(gen,żeby)]],[[prepnp(do,gen)]],[[prepnp(od,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(bliskoznaczny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(bogaty,[[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepnp(o,acc),prepncp(o,acc,że)]],[[prepnp(w,acc)]],[[prepnp(w,loc)]]]).
slowprzym(bolesny,[[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(brzemienny,[[[np(inst)]],[[prepnp(w,acc)]],[[prepnp(w,loc)]]]).
slowprzym(budujący,[[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(bywały,[[[xp(locat)]]]).
slowprzym(całkowalny,[[[prepnp(na,loc)],[prepnp(z,inst)]],[[prepnp(po,loc)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)],[prepnp(z,inst)]],[[prepnp(względem,gen)]],[[xp(mod)]]]).
slowprzym(cały,[[[adjp(agr)]],[[prepnp(w,loc)]]]).
slowprzym(celowy,[[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(cenny,[[[prepnp(dla,gen)],[prepnp(przy,loc)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(charakterystyczny,[[[np(inst),ncp(inst,że)]],[[prepnp(dla,gen),prepnp(u,gen)],[comprepnp('pod względem')]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(chciwy,[[[comprepnp('w stosunku do')]],[[np(gen),ncp(gen,żeby)]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(chętny,[[[cp(żeby)]],[head,[infp(_G1638)]],[[np(dat)]],[[prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[prepnp(ku,dat)]],[[xp(adl)]]]).
slowprzym(chory,[[[prepnp(na,acc),prepncp(na,acc,że)],[xp(caus)]],[[cp(gdy)]],[[cp(jak)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(chwalebny,[[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(chytry,[[[np(gen)]],[[prepnp(na,acc)]]]).
slowprzym(ciasny,[[[prepnp(dla,gen)]]]).
slowprzym(ciekawy,[[[comprepnp('na temat')]],[[np(gen),ncp(gen,int),ncp(gen,że)]],[[prepnp('co do',gen),prepncp('co do',gen,int)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(ciężarny,[[[np(inst)]]]).
slowprzym(ciężki,[[[prepnp(dla,gen)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(cudowny,[[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]]]).
slowprzym(czołobitny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(czujny,[[[comprepnp('w stosunku do')]],[[cp(int)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,żeby)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(czuły,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(czynny,[[[prepnp(w,loc)]],[[xp(temp)]]]).
slowprzym(daleki,[[[np(dat),ncp(dat,żeby)]],[[prepnp(dla,gen)]],[[prepnp(od,gen),prepncp(od,gen,int),prepncp(od,gen,że),prepncp(od,gen,żeby)]]]).
slowprzym(dbały,[[[prepnp(o,acc),prepncp(o,loc,żeby)]]]).
slowprzym(deficytowy,[[[prepnp(w,acc)]]]).
slowprzym(dłużny,[[[comprepnp('w stosunku do')]],[[np(acc)],[np(dat)],[comprepnp('z tytułu')]],[[np(acc)],[np(dat)],[prepnp(za,acc),prepncp(za,acc,że)]],[[np(dat)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(dobry,[[[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[prepnp(o,acc)],[prepnp(w,loc),prepncp(w,loc,że)]],[[xp(locat),xp(temp)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(dogodny,[[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat),prepncp(ku,dat,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(dojrzały,[[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(żeby)]]]).
slowprzym(dopuszczalny,[[[comprepnp('na gruncie')]],[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[np(inst)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(dosłyszalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(locat)]]]).
slowprzym(dostateczny,[[[cp(żeby)]],[[prepnp(dla,gen),prepnp(do,gen),prepncp(dla,gen,żeby),prepncp(do,gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]]]).
slowprzym(dostępny,[[[np(dat)],[xp(locat)],[xp(perl)]],[[prepnp(dla,gen),lex(prepnp(dla,gen),[_G1594,kieszeń],atr(fac,n,[[adjp(agr)],[possp]]))],[xp(locat)],[xp(perl)]],[[prepnp(do,gen)]]]).
slowprzym(dostrzegalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(dur)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(doświadczalny,[[[prepnp(przez,acc)],[xp(instr)]]]).
slowprzym(dotykalny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]]]).
slowprzym(dozwolony,[[[np(dat)]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[xp(locat)]],[[xp(mod)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(drogi,[[[np(dat)]],[[prepnp(dla,gen),prepnp(w,loc)]]]).
slowprzym(drugi,[[[prepnp(na,acc),prepnp(w,loc),xp(locat)]],[[prepnp(od,gen)]],[[prepnp(po,loc)]],[[prepnp(z,gen)]],[[cp(że)]]]).
slowprzym(dufny,[[[cp(że)]],[[prepnp(w,acc),prepncp(w,loc,że)]]]).
slowprzym(dumny,[[[cp(że)]],[[np(inst)]],[[prepnp(z,gen),prepncp(z,gen,int),prepncp(z,gen,że)]]]).
slowprzym(dyskusyjny,[[[prepnp(dla,gen)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(dziwny,[[[prepnp(w,loc),prepncp(w,loc,że)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(ekwiwalentny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]],[[xp(mod)]]]).
slowprzym(ewidentny,[[[prepnp(dla,gen)]],[[cp(że)]]]).
slowprzym(fajny,[[[prepnp(dla,gen)]],[[prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[prepnp(w,loc)]],[[cp(gdy)]],[[cp(jak),cp(że)]],[[cp(jeśli)]],[[cp(kiedy)]]]).
slowprzym(fantastyczny,[[[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[prepnp(w,loc),prepncp(w,loc,że)]],[[xp(locat),xp(temp)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(fatalny,[[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]],[[prepnp(w,loc),prepncp(w,loc,żeby)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(genialny,[[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]]]).
slowprzym(gładki,[[[prepnp(w,loc)]]]).
slowprzym(głodny,[[[np(gen),ncp(gen,żeby)]]]).
slowprzym(głośny,[[[prepnp(z,gen),prepncp(z,gen,że)]]]).
slowprzym(głuchy,[[[prepnp(na,acc),prepncp(na,acc,że)]],[[prepnp(od,gen)]]]).
slowprzym(głupi,[[[advp(misc)]],[[comprepnp('na temat')]],[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(w,loc),prepncp(w,loc,int),prepncp(w,loc,że)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(gniewny,[[[cp(że)]],[[prepnp(na,acc)],[prepnp(o,acc),prepncp(o,acc,że)]],[[prepnp(na,acc)],[xp(caus)]]]).
slowprzym(godny,[[head,[infp(_G1661)]],[[np(gen),ncp(gen,że),ncp(gen,żeby)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(gorliwy,[[[comprepnp('na rzecz')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(o,acc)]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(gotowy,[[head,[cp(żeby)]],[head,[infp(_G1636)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat),prepncp(ku,dat,żeby)]],[[prepnp(na,acc),prepncp(na,acc,że),prepncp(na,acc,żeby)]]]).
slowprzym(groźny,[[[prepnp(dla,gen)],[prepnp(w,loc),prepncp(w,loc,że)]],[[prepnp(dla,gen)],[xp(locat)]],[[prepnp(dla,gen)],[xp(temp)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(grzeczny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(hojny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(identyczny,[[[np(dat)],[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)]],[[prepnp(do,gen)],[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)]],[[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)],[compar(co)]],[[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)],[compar(jak)]],[[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)],[prepnp(z,inst)]]]).
slowprzym(indyferentny,[[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen),prepncp(względem,gen,int)]],[[xp(mod)]]]).
slowprzym(istotny,[[[comprepnp('w stosunku do')],[advp(misc)]],[[prepnp(dla,gen)],[advp(misc)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(przy,loc),prepnp(w,loc)]],[[prepnp(u,gen)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(jasny,[[[prepnp('co do',gen),prepncp('co do',gen,int)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(jednoznaczny,[[[prepnp('co do',gen),prepncp('co do',gen,że)]],[[prepnp(w,loc)]],[[prepnp(z,inst),prepncp(z,inst,że)]],[[cp(że)]],[[or]]]).
slowprzym(kapitalny,[[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[xp(locat),xp(temp)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(karalny,[[[np(inst)],[xp(locat)],[xp(temp)]],[[prepnp(przez,acc)],[xp(locat)],[xp(temp)]],[[prepnp(za,acc)]],[[xp(locat)],[xp(mod)],[xp(temp)]]]).
slowprzym(kierunkowy,[[[np(gen)]],[[prepnp(do,gen)]]]).
slowprzym(klarowny,[[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(kompatybilny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(w,acc)],[prepnp(z,inst)]],[[prepnp(w,loc)],[prepnp(z,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(kompetentny,[[[comprepnp('w stosunku do')]],[[cp(żeby)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc),prepncp(w,loc,żeby)]]]).
slowprzym(komplementarny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(komunikowalny,[[[comprepnp('za pomocą')]],[[xp(mod)]]]).
slowprzym(konieczny,[[[advp(misc)]],[[np(dat)],[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepnp(w,loc),cp(żeby),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[np(dat)],[prepnp(przy,loc)]]]).
slowprzym(konkurencyjny,[[[comprepnp('na tle')],[comprepnp('pod wpływem')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(konsekwentny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen),prepnp(wobec,gen)]],[[prepnp(w,loc)]],[[prepnp(względem,gen)]]]).
slowprzym(konstytutywny,[[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]]]).
slowprzym(kontent,[[[cp(że)]],[[prepnp(z,gen),prepncp(z,gen,że)]]]).
slowprzym(korzystny,[[[prepnp(dla,gen)],[advp(misc)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(krewny,[[[np(dat)],[np(part)],[prepnp(za,acc)]]]).
slowprzym(krępujący,[[[prepnp(dla,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(krzywdzący,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(legły,[[[xp(locat)]]]).
slowprzym(lepki,[[[prepnp(od,gen)]],[[prepnp(z,gen)]]]).
slowprzym(litościwy,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(logiczny,[[[comprepnp('w kwestii')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(lojalny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen),comprepnp('w stosunku do')]],[[prepnp(względem,gen)]]]).
slowprzym(ludzki,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(łagodny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(łakomy,[[[np(gen)]],[[prepnp(na,acc)]]]).
slowprzym(łapczywy,[[[np(gen)]],[[prepnp(na,acc)]]]).
slowprzym(łaskawy,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(łasy,[[[np(gen)]],[[prepnp(na,acc)]]]).
slowprzym(łatwy,[[[np(dat)],[prepnp(do,gen)]],[[prepnp(dla,gen)],[prepnp(do,gen),prepnp(w,loc),prepncp(do,gen,żeby)]]]).
slowprzym(mały,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(o,acc)]],[[cp(int)]],[[cp(że)]],[[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że)]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]]]).
slowprzym(mierzalny,[[[comprepnp('pod względem')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(z,inst)]],[[xp(mod)]]]).
slowprzym(mieszalny,[[[prepnp(z,inst)]]]).
slowprzym(milutki,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(miłosierny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen),prepnp(wobec,gen)]],[[prepnp(w,loc)]],[[prepnp(względem,gen)]]]).
slowprzym(miłościwy,[[[np(dat)]],[[prepnp(dla,gen)]]]).
slowprzym(miły,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(młody,[[[np(inst)]],[[prepnp(o,acc)]]]).
slowprzym(mocny,[[[comprepnp('w stosunku do')]],[[prepnp(o,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,gen)]]]).
slowprzym(możliwy,[[[prepnp(dla,gen)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(przez,acc),prepncp(przez,acc,że),xp(mod)]],[[prepnp(wskutek,gen)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nabiegły,[[[np(inst)]],[[xp(mod)]]]).
slowprzym(nadąsany,[[[cp(że)]],[[prepnp(na,acc)],[prepnp(za,acc),prepncp(za,acc,że)]],[[prepnp(na,acc)],[xp(caus)]],[[prepnp(o,acc)]]]).
slowprzym(nadrzędny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(nad,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nadwrażliwy,[[[comprepnp('na punkcie')]],[[comprepnp('na temat')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]]]).
slowprzym(nadzwyczajny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(naganny,[[[prepnp('co do',gen)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(naiwny,[[[comprepnp('na temat')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,że)]],[[prepnp(w,loc),prepncp(w,loc,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(należny,[[[np(dat)],[prepnp(za,acc),prepncp(za,acc,że)]],[[prepnp(do,gen)]],[[prepnp(od,gen)]]]).
slowprzym(namokły,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(napęczniały,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(napity,[[[np(inst)]],[[prepnp(dla,gen)]]]).
slowprzym(naprzykrzony,[[[np(dat)]]]).
slowprzym(napuchły,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(nasiąkły,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(naturalny,[[[prepnp(dla,gen)]],[[prepnp(w,loc),prepncp(w,loc,int)]],[[xp(locat)]],[[xp(temp)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(nawykły,[[[cp(żeby)]],[head,[infp(imperf)]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że),prepncp(do,gen,żeby)]]]).
slowprzym(neutralny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(mod)]]]).
slowprzym(nieadekwatny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen),prepnp(do,gen),prepncp(do,gen,int)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,inst,int)]]]).
slowprzym(nieakceptowalny,[[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[xp(caus)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[xp(locat)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niebaczny,[[[cp(że)]],[[np(gen),ncp(gen,że)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]],[[prepnp(w,loc)]]]).
slowprzym(niebezpieczny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)],[prepnp(przez,acc),prepncp(przez,acc,że)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niechętny,[[[comprepnp('w stosunku do')]],[[cp(żeby)]],[head,[infp(_G1680)]],[[np(dat),ncp(dat,żeby)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieczuły,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]],[[prepnp(względem,gen)]]]).
slowprzym(niedaleki,[[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(od,gen),prepncp(od,gen,int),prepncp(od,gen,żeby)]]]).
slowprzym(niedbały,[[[prepnp(na,acc)]],[[prepnp(o,acc)]]]).
slowprzym(niedobry,[[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niedojrzały,[[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(żeby)]]]).
slowprzym(niedopuszczalny,[[[comprepnp('na gruncie')]],[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[np(inst)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[cp(gdy)]],[[cp(int)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niedorosły,[[[prepnp(do,gen),prepncp(do,gen,żeby)],[xp(mod)]],[[prepnp(w,loc)]]]).
slowprzym(niedorzeczny,[[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niedosięgalny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]]]).
slowprzym(niedosięgły,[[[np(inst)]],[[prepnp(dla,gen)]]]).
slowprzym(niedosłyszalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(locat)]]]).
slowprzym(niedostępny,[[[lex(prepnp(dla,gen),[_G1665,kieszeń],atr(fac,n,[[np(gen)],[adjp(agr)]]))]],[[np(dat)],[xp(locat)],[xp(perl)]],[[prepnp(dla,gen),xp(locat),xp(perl)]],[[prepnp(dla,gen)],[xp(locat)],[xp(perl)]],[[prepnp(do,gen)]]]).
slowprzym(niedostrzegalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(dur)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(niedotykalny,[[[prepnp(dla,gen)]],[[xp(mod)]]]).
slowprzym(niedozwolony,[[[np(dat)]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(przez,acc)]],[[xp(locat)]],[[xp(mod)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niefortunny,[[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niegodny,[[[np(gen),ncp(gen,że),ncp(gen,żeby)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niegodziwy,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(gdy)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niegotowy,[[[cp(żeby)]],[head,[infp(_G1617)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,żeby)]]]).
slowprzym(niegrzeczny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieistotny,[[[comprepnp('w stosunku do')],[advp(misc)]],[[prepnp(dla,gen)],[advp(misc)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niejasny,[[[prepnp('co do',gen),prepncp('co do',gen,int)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(niekaralny,[[[np(inst)],[xp(locat)],[xp(temp)]],[[prepnp(przez,acc)],[xp(locat)],[xp(temp)]],[[prepnp(za,acc)]],[[xp(locat)],[xp(mod)],[xp(temp)]]]).
slowprzym(niekompetentny,[[[cp(żeby)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc),prepncp(w,loc,żeby)]]]).
slowprzym(niekonsekwentny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(niekorzystny,[[[prepnp(dla,gen)],[advp(misc)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc)]],[[xp(locat)]],[[xp(temp)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niekwestionowalny,[[[comprepnp('pod względem')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(nielojalny,[[[np(dat)]],[[prepnp(wobec,gen),comprepnp('w stosunku do')]],[[prepnp(względem,gen)]]]).
slowprzym(niełatwy,[[[prepnp(dla,gen)],[prepnp(do,gen)]],[[prepnp(dla,gen)],[prepnp(w,loc)]]]).
slowprzym(niemądry,[[[advp(misc)]],[[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[cp(gdy)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niemierzalny,[[[comprepnp('pod względem')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(niemiły,[[[comprepnp('w stosunku do')]],[[np(dat)],[prepnp(dla,gen),comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc)],[xp(caus)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niemoralny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen),xp(locat),xp(temp)]],[[prepnp(względem,gen)]],[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niemożliwy,[[[prepnp(dla,gen)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(przez,acc),prepncp(przez,acc,że)]],[[prepnp(wskutek,gen)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nienaruszalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(locat)]]]).
slowprzym(nienawistny,[[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),comprepnp('w stosunku do')]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nienawracalny,[[[comprepnp('w kwestii')]],[[prepnp(na,acc)]],[[xp(mod)]]]).
slowprzym(nienawykły,[[[cp(żeby)]],[head,[infp(imperf)]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że),prepncp(do,gen,żeby)]]]).
slowprzym(nienazywalny,[[[np(inst)],[prepnp(dla,gen)]]]).
slowprzym(nienormalny,[[[advp(misc)]],[[comprepnp('pod względem')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[xp(locat),xp(temp)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(żeby)]],[[cp(że)],[xp(locat)]]]).
slowprzym(nieobcy,[[[np(dat)]],[[prepnp(dla,gen)]],[[np(dat)],[cp(int)]],[[np(dat)],[cp(że)]]]).
slowprzym(nieobecny,[[[np(inst)],[xp(locat)]]]).
slowprzym(nieobliczalny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)],[xp(mod)]],[[xp(locat)],[xp(temp)]]]).
slowprzym(nieobojętny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[np(dat)],[comprepnp('pod względem')]],[[np(dat)],[xp(mod)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(na,acc),prepnp(wobec,gen),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(wobec,gen,int),prepncp(wobec,gen,że)]],[[prepnp(względem,gen),prepncp(względem,gen,int)]],[[np(dat)],[cp(int)]],[[np(dat)],[cp(że)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(nieobserwowalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(abl)]],[[xp(dur)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(nieobyty,[[[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[prepnp(z,inst)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(nieoczytany,[[[comprepnp('na temat')]],[[comprepnp('w temacie')]],[[np(inst)]],[[prepnp(w,loc)]],[[prepnp(z,inst)]]]).
slowprzym(nieodczuwalny,[[[np(inst)],[prepnp(przez,acc)]],[[prepnp(dla,gen)],[xp(locat)]],[[prepnp(przez,acc)],[xp(mod)]],[[prepnp(przy,loc)]]]).
slowprzym(nieodkształcalny,[[[comprepnp('pod wpływem')]],[[comprepnp('za pomocą')]],[[prepnp(przez,acc)]],[[xp(mod)]]]).
slowprzym(nieodłączny,[[[prepnp(dla,gen)]],[[prepnp(od,gen)]],[[prepnp(w,loc)]]]).
slowprzym(nieodmienny,[[[prepnp('co do',gen)]],[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen),prepncp(od,gen,int)],[xp(mod)]],[[prepnp(od,gen)],[prepnp(w,loc)]],[[prepnp(przez,acc)]]]).
slowprzym(nieodnawialny,[[[prepnp(przez,acc)]],[[xp(mod)]]]).
slowprzym(nieodporny,[[[comprepnp('w stosunku do')]],[[prepnp(na,acc),prepncp(na,acc,że)],[xp(mod)]],[[prepnp(na,acc)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieodpowiedni,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)],[cp(żeby)]],[[prepnp(dla,gen)],[prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[xp(locat)]],[[xp(temp)]],[[cp(że)]]]).
slowprzym(nieodpowiedzialny,[[[prepnp(przed,inst)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(za,acc),prepncp(za,acc,że)],[xp(locat)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nieodróżnialny,[[[np(inst)],[prepnp(od,gen)]],[[prepnp(dla,gen)],[prepnp(od,gen)]],[[prepnp(od,gen)],[comprepnp('na gruncie')]],[[prepnp(od,gen)],[comprepnp('na podstawie')]],[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen)],[comprepnp('za pomocą')]],[[prepnp(od,gen)],[comprepnp('ze względu na')]],[[prepnp(od,gen)],[prepnp(po,loc)]],[[prepnp(od,gen)],[prepnp(przez,acc)]],[[prepnp(od,gen)],[prepnp(w,loc)]],[[prepnp(od,gen)],[xp(mod)]]]).
slowprzym(nieodtwarzalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(z,gen)]],[[xp(locat)]]]).
slowprzym(nieodwołalny,[[[prepnp(przez,acc)],[xp(abl)],[xp(caus)]],[[cp(że)]]]).
slowprzym(nieodwoływalny,[[[prepnp(przez,acc)],[comprepnp('z powodu')],[xp(abl)]]]).
slowprzym(nieodwracalny,[[[comprepnp('pod wpływem'),xp(mod)]],[[comprepnp('pod względem')]],[[prepnp(do,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]]]).
slowprzym(nieodzowny,[[[advp(misc)]],[[np(dat)],[prepnp(do,gen),prepnp(w,loc),prepncp(do,gen,żeby)]],[[np(dat)],[prepnp(przy,loc)]],[[prepnp(dla,gen)],[prepnp(do,gen),prepnp(w,loc),prepncp(do,gen,żeby)]],[[prepnp(dla,gen)],[cp(gdy),cp(jeśli)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(nieokrzepły,[[[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(nieopłacalny,[[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(caus)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(nieosiadły,[[[xp(locat)],[xp(temp)]]]).
slowprzym(nieosiągalny,[[[np(inst)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('za pomocą')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(dla,gen)],[xp(locat)],[xp(temp)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(nieoswajalny,[[[xp(mod)]]]).
slowprzym(niepodobny,[[[np(dat)],[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)]],[[prepnp(do,gen)],[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)]],[[cp(żeby)]]]).
slowprzym(niepodważalny,[[[comprepnp('pod względem')]],[[prepnp('co do',gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[cp(że)]]]).
slowprzym(niepodzielny,[[[advp(misc)]],[[prepnp(na,acc)]],[[prepnp(przez,acc)]]]).
slowprzym(niepojęty,[[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(locat)]],[[prepnp(dla,gen)],[xp(temp)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(int),cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niepokonalny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]]]).
slowprzym(niepoliczalny,[[[prepnp(dla,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]]]).
slowprzym(niepomijalny,[[[prepnp(dla,gen)]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[xp(caus)]],[[xp(locat)]]]).
slowprzym(niepomny,[[[cp(że)]],[[cp(żeby)]],[[np(dat)]],[[np(gen),cp(int),ncp(gen,int),ncp(gen,że)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że)]]]).
slowprzym(nieporadny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(nieporównywalny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]]]).
slowprzym(nieposłuszny,[[[comprepnp('w stosunku do')]],[[np(dat)],[prepnp(w,loc)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(niepostrzegalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)],[xp(mod)]],[[xp(instr)]]]).
slowprzym(niepotrzebny,[[[np(dat)],[cp(żeby)]],[[np(dat)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[np(dat)],[prepnp(na,acc),prepncp(do,gen,żeby)]],[[np(dat)],[prepnp(w,loc)]],[[np(dat)],[xp(locat)]],[[np(dat)],[xp(temp)]],[[prepnp(dla,gen)]]]).
slowprzym(niepoważny,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)],[advp(misc)]],[[prepnp(w,loc),prepncp(w,loc,int)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niepowątpiewalny,[[[prepnp('co do',gen)]]]).
slowprzym(niepowtarzalny,[[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)],[xp(mod)]],[[xp(caus)]],[[xp(locat)]]]).
slowprzym(niepozbywalny,[[[prepnp(dla,gen)]],[[xp(abl)]]]).
slowprzym(niepoznawalny,[[[prepnp(dla,gen)],[prepnp(przez,acc),xp(mod)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(dla,gen)],[xp(instr)]]]).
slowprzym(nieprawdopodobny,[[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[xp(locat)]],[[cp(int)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nieproporcjonalny,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieprzeczuwalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]]]).
slowprzym(nieprzejezdny,[[[comprepnp('ze względu na')]],[[np(inst)]],[[prepnp(dla,gen)],[xp(caus)]],[[xp(adl)]],[[xp(locat)]],[[xp(perl)]]]).
slowprzym(nieprzekazywalny,[[[np(dat)],[xp(instr)]],[[np(dat)],[xp(mod)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(w,loc)]],[[xp(abl)],[xp(adl)],[xp(perl)]]]).
slowprzym(nieprzekładalny,[[[np(inst)],[prepnp(na,acc)],[prepnp(z,gen)],[xp(mod)]],[[prepnp(z,inst)]]]).
slowprzym(nieprzekraczalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(nieprzemakalny,[[[prepnp(dla,gen)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]]]).
slowprzym(nieprzenikalny,[[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(na,acc)]]]).
slowprzym(nieprzepuszczalny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)],[xp(abl)],[xp(adl)],[xp(mod)]]]).
slowprzym(nieprzerywalny,[[[np(inst)]]]).
slowprzym(nieprzetłumaczalny,[[[prepadjp(po,postp)]],[[prepnp(dla,gen)]],[[prepnp(na,acc)],[prepnp(z,gen)]],[[xp(mod)]]]).
slowprzym(nieprzewidywalny,[[[comprepnp('na gruncie')]],[[comprepnp('pod kątem')]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[comprepnp('z powodu')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(przez,acc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(nieprzewidzialny,[[[prepnp(w,loc)]]]).
slowprzym(nieprzezwyciężalny,[[[comprepnp('w ramach')]],[[np(inst)]],[[prepnp(dla,gen)]],[[xp(mod)]]]).
slowprzym(nieprzychylny,[[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,że)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(ku,dat)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieprzydatny,[[[np(dat)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[np(dat)],[prepnp(na,acc)]],[[np(dat)],[prepnp(w,loc),xp(locat)]],[[prepnp(dla,gen)],[prepnp(w,loc)]]]).
slowprzym(nieprzyjazny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(ku,dat)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieprzyjemny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)],[prepnp(w,loc)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc)],[comprepnp('z powodu')]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(nieprzystawalny,[[[prepnp(do,gen)],[xp(mod)]]]).
slowprzym(nieprzystępny,[[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]]]).
slowprzym(nieprzyswajalny,[[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(nieprzywykły,[[[cp(żeby)]],[head,[infp(imperf)]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że),prepncp(do,gen,żeby)]]]).
slowprzym(nierad,[[[cp(że)]],[[cp(żeby)]],[[np(dat),ncp(dat,że),ncp(dat,żeby)]],[[prepnp(z,gen),prepncp(z,gen,że)]]]).
slowprzym(nieredukowalny,[[[prepnp(do,gen)],[xp(mod)]]]).
slowprzym(niereformowalny,[[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(nierozbieralny,[[[prepnp(na,acc)],[xp(instr)]]]).
slowprzym(nierozerwalny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)]],[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[prepnp(z,inst)]],[[xp(instr)]]]).
slowprzym(nierozkładalny,[[[prepnp(dla,gen)],[prepnp(na,acc)]],[[prepnp(do,gen)],[xp(instr)]],[[prepnp(na,acc)],[prepnp(przez,acc)]],[[prepnp(na,acc)],[prepnp(w,loc)]],[[prepnp(na,acc)],[xp(instr)]],[[prepnp(na,acc)],[xp(mod)]]]).
slowprzym(nierozpoznawalny,[[[prepnp(dla,gen)]],[[prepnp(po,loc)]],[[prepnp(przez,acc)],[prepnp(z,gen)]],[[xp(abl)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(nierozpuszczalny,[[[comprepnp('pod wpływem')]],[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(w,loc)]]]).
slowprzym(nierozróżnialny,[[[comprepnp('na podstawie')]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)],[prepnp(od,gen)]],[[prepnp(dla,gen)]],[[prepnp(między,inst)]],[[prepnp(od,gen)],[xp(mod)]],[[prepnp(po,loc)]],[[prepnp(przez,acc)]],[[prepnp(według,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]],[[xp(abl)]],[[xp(instr)]]]).
slowprzym(nierozsądny,[[[prepnp(w,loc)]],[[cp(gdy)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nierozstrzygalny,[[[comprepnp('na gruncie')]],[[comprepnp('w ramach')]],[[comprepnp('z pomocą')]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(int)]]]).
slowprzym(nieroztropny,[[[prepnp(w,loc)]],[[xp(mod)]],[[cp(gdy)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nierozwiązalny,[[[comprepnp('na gruncie')]],[[comprepnp('w ramach')]],[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(mod)]]]).
slowprzym(nierozwiązywalny,[[[comprepnp('na gruncie')]],[[comprepnp('w ramach')]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(instr)]],[[xp(mod)]]]).
slowprzym(nierówny,[[[comprepnp('w stosunku do')]],[[np(dat)],[advp(misc)]],[[np(dat)],[np(inst)]],[[np(dat)],[prepnp('co do',gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(niesamowity,[[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc)]],[[prepnp(w,loc),prepncp(w,loc,że)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(nieskory,[[[cp(żeby)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat)]],[[prepnp(na,acc)]]]).
slowprzym(niesłuszny,[[[comprepnp('pod względem')]],[[xp(mod)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niesłyszalny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(locat)]]]).
slowprzym(niespełnialny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(locat)]]]).
slowprzym(niespłacalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(z,gen)]]]).
slowprzym(niespodziewany,[[[prepnp(po,loc)]],[[prepnp(przez,acc)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(niespokojny,[[[cp(że)]],[[prepnp('co do',gen)]],[[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że)]]]).
slowprzym(niespokrewniony,[[[prepnp(z,inst)]]]).
slowprzym(niesporny,[[[comprepnp('pod względem')]],[[prepnp('co do',gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(niespójny,[[[comprepnp('w kwestii')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(w,loc)],[advp(misc)]],[[prepnp(z,inst)],[advp(misc)]]]).
slowprzym(niesprawdzalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(z,inst)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(niesprawiedliwy,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen),prepnp(względem,gen)]],[[xp(mod)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niesprowadzalny,[[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że)]]]).
slowprzym(niesterowalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]]]).
slowprzym(niestosowalny,[[[comprepnp('na gruncie')]],[[prepnp(do,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]]]).
slowprzym(niestosowny,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze strony')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(mod)]],[[cp(gdy)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niestrawny,[[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('z powodu')]],[[prepnp(dla,gen)],[prepnp(przez,acc)]],[[prepnp(dla,gen)],[xp(mod)]]]).
slowprzym(niesystematyczny,[[[prepnp(w,loc)]]]).
slowprzym(nieszczery,[[[comprepnp('w sprawie')]],[[prepnp(w,loc)],[prepnp(wobec,gen),comprepnp('w stosunku do')]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(nieszczęśliwy,[[[cp(że)]],[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepnp(z,gen),prepncp(z,gen,int),prepncp(z,gen,że)]]]).
slowprzym(nieszkodliwy,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(że)]]]).
slowprzym(nieściągalny,[[[comprepnp('na podstawie')],[xp(abl)]],[[comprepnp('na skutek')],[xp(abl)]],[[comprepnp('ze względu na')],[xp(abl)]],[[comprepnp('z powodu')],[xp(abl)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(przez,acc)],[xp(abl)]],[[prepnp(wskutek,gen)],[xp(abl)]],[[xp(locat)]]]).
slowprzym(nieścieralny,[[[np(inst)],[xp(abl)],[xp(mod)]],[[prepnp(na,loc)]],[[prepnp(przez,acc)]]]).
slowprzym(nieświadomy,[[[np(gen),cp(int),cp(że),ncp(gen,int),ncp(gen,że)]]]).
slowprzym(nietolerancyjny,[[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen),comprepnp('w stosunku do'),prepncp(wobec,gen,że)]],[[prepnp(względem,gen)]]]).
slowprzym(nietykalny,[[[comprepnp('pod względem')]],[[comprepnp('ze strony')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[xp(mod)]]]).
slowprzym(nietypowy,[[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)]],[[prepnp(w,loc)]],[[xp(locat),xp(temp)]],[[xp(mod)]],[[cp(że)],[xp(locat)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(nieubłagalny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(w,loc)],[prepnp(wobec,gen)]]]).
slowprzym(nieuczęszczany,[[[prepnp(przez,acc)]]]).
slowprzym(nieufny,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen),prepncp('co do',gen,int)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieuległy,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(nieulękły,[[[prepnp(przed,inst)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]]]).
slowprzym(nieuprzejmy,[[[comprepnp('pod adresem')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nieusuwalny,[[[comprepnp('za pomocą')],[xp(abl)]],[[np(inst)],[xp(abl)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(przez,acc)],[xp(abl)]],[[prepnp(w,loc)],[xp(abl)]],[[xp(abl)],[xp(mod)]]]).
slowprzym(nieużyteczny,[[[comprepnp('na gruncie')]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(nieważny,[[[comprepnp('ze względu na')]],[[prepnp(dla,gen),prepnp(przy,loc),prepnp(w,loc)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(u,gen)]],[[xp(caus)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(int),cp(że)]]]).
slowprzym(niewątpliwy,[[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(niewdzięczny,[[[cp(że)]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(za,acc),prepncp(za,acc,że)]]]).
slowprzym(niewiarygodny,[[[compar(jako)]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[cp(int)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niewidzialny,[[[prepnp(dla,gen)]]]).
slowprzym(niewierny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(niewłaściwy,[[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[cp(żeby)]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc)]],[[prepnp(przy,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[xp(mod)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niewrażliwy,[[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(niewskazany,[[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp(w,loc)],[comprepnp('ze względu na')]],[[prepnp(w,loc)],[xp(caus)]],[[prepnp(wobec,gen)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niewspółmierny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen),prepncp(do,gen,int)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,inst,int)]]]).
slowprzym(niewybaczalny,[[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(przy,loc)]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[xp(mod)]],[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niewybieralny,[[[prepnp(do,gen)]],[[prepnp(na,acc)],[prepnp(przez,acc)],[prepnp(w,loc)],[xp(dur)],[xp(mod)]]]).
slowprzym(niewybredny,[[[advp(misc)]],[[comprepnp('pod względem')]],[[prepnp('co do',gen)]],[[prepnp(w,loc)]]]).
slowprzym(niewyczerpalny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)],[xp(caus)]]]).
slowprzym(niewyczerpywalny,[[[np(inst)]],[[prepnp(w,loc)]]]).
slowprzym(niewyczuwalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(abl)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(niewydarzony,[[[comprepnp('pod względem')]],[[xp(mod)]]]).
slowprzym(niewygasły,[[[xp(locat)],[xp(temp)]]]).
slowprzym(niewygodny,[[[np(dat)]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[comprepnp('z powodu')]],[[prepnp(dla,gen)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(dla,gen)],[prepnp(przy,loc),prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niewykluczony,[[[cp(że)]],[[cp(żeby)]]]).
slowprzym(niewykonalny,[[[comprepnp('na gruncie')]],[[comprepnp('na podstawie')]],[[comprepnp('pod względem')]],[[comprepnp('w ramach')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(caus)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(niewykrywalny,[[[prepnp(dla,gen)]],[[prepnp(na,loc)]],[[prepnp(przez,acc)]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[xp(abl)]],[[xp(dur)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(niewyleczalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(przez,acc)]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[prepnp(z,gen)]],[[xp(mod)]]]).
slowprzym(niewymagalny,[[[prepnp(od,gen)]]]).
slowprzym(niewymawialny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(niewymazywalny,[[[np(inst)],[xp(adl)]],[[xp(adl)],[xp(mod)]]]).
slowprzym(niewymienialny,[[[prepnp(między,inst)]],[[prepnp(na,acc)],[prepnp(po,loc)]],[[prepnp(z,inst)]]]).
slowprzym(niewymierzalny,[[[prepnp(w,loc)]]]).
slowprzym(niewyobrażalny,[[[prepnp(dla,gen)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niewypowiadalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(mod)]]]).
slowprzym(niewypowiedzialny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(mod)]]]).
slowprzym(niewyrażalny,[[[compar(jako)]],[[comprepnp('na gruncie')]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(mod)]]]).
slowprzym(niewyspany,[[[prepnp(po,loc)]],[[xp(caus)]]]).
slowprzym(niewystarczalny,[[[cp(żeby)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[xp(mod)]]]).
slowprzym(niewytłumaczalny,[[[comprepnp('na gruncie')]],[[comprepnp('od strony')]],[[comprepnp('pod kątem')]],[[comprepnp('pod względem')]],[[comprepnp('w ramach')]],[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(według,gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(niewyznaczalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(przez,acc)]],[[xp(mod)]]]).
slowprzym(niewyżyty,[[[comprepnp('na punkcie')]],[[xp(mod)]]]).
slowprzym(niewzruszalny,[[[comprepnp('pod względem')]],[[prepnp(na,acc)]],[[prepnp(w,loc)],[xp(caus)]],[[xp(mod)]]]).
slowprzym(niezadowolony,[[[cp(że)]],[[prepnp(z,inst),prepncp(z,gen,int),prepncp(z,gen,że)]]]).
slowprzym(niezakrzepły,[[[prepnp(w,loc)],[xp(locat)]]]).
slowprzym(niezależny,[[[prepnp(od,gen)],[advp(misc)]],[[prepnp(od,gen),prepncp(od,gen,int)],[prepnp(w,loc)]]]).
slowprzym(niezaprzeczalny,[[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(niezarośnięty,[[[np(inst)],[xp(locat)],[xp(mod)]],[[prepnp(przez,acc)]]]).
slowprzym(niezasłużony,[[[np(inst)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('na polu')]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(niezastępowalny,[[[np(inst)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(locat)]]]).
slowprzym(niezastygły,[[[prepnp(w,loc)],[xp(locat)]]]).
slowprzym(niezatapialny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]]]).
slowprzym(niezauważalny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(locat)]]]).
slowprzym(niezawisły,[[[comprepnp('w stosunku do')]],[[prepnp(od,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[xp(mod)]]]).
slowprzym(niezbędny,[[[advp(misc)]],[[np(dat)],[cp(żeby)]],[[np(dat)],[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepnp(w,loc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[np(dat)],[xp(locat)]],[[np(dat)],[xp(temp)]],[[prepnp(dla,gen)],[cp(żeby)]],[[prepnp(dla,gen)],[prepnp(do,gen)]],[[prepnp(dla,gen)],[prepnp(na,acc)]]]).
slowprzym(niezbywalny,[[[comprepnp('na rzecz')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[xp(locat)]]]).
slowprzym(niezdatny,[[[cp(żeby)]],[[np(dat)],[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]]]).
slowprzym(niezdecydowany,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[comprepnp('w temacie')]],[[cp(int)]],[[cp(żeby)]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,żeby)]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,żeby)]],[[prepnp(między,inst)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,żeby)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(niezdolny,[[[cp(żeby)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]]]).
slowprzym(niezgasły,[[[np(inst)]]]).
slowprzym(niezgodny,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen),prepncp('co do',gen,int)],[prepnp(z,inst)]],[[prepnp(przy,loc)],[prepnp(z,inst)]],[[prepnp(w,loc),prepncp(w,loc,int)],[prepnp(z,inst)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)],[comprepnp('na temat')]],[[prepnp(z,inst)],[comprepnp('pod względem')]],[[prepnp(z,inst)],[comprepnp('w dziedzinie')]],[[prepnp(z,inst)],[comprepnp('w kwestii')]],[[prepnp(z,inst)],[comprepnp('w sprawie')]],[[prepnp(z,inst)],[comprepnp('w temacie')]],[[prepnp(z,inst)],[comprepnp('w zakresie')]],[[prepnp(z,inst)],[cp(int)]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]],[[prepnp(z,inst)],[xp(mod)]],[[prepnp(z,inst)],[cp(że)]],[[prepnp(z,inst)],[cp(żeby)]]]).
slowprzym(nieziszczalny,[[[prepnp(dla,gen)]],[[xp(locat)]]]).
slowprzym(niezmywalny,[[[comprepnp('za pomocą')],[xp(abl)]],[[np(inst)],[xp(abl)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(w,loc)],[xp(abl)]]]).
slowprzym(nieznajomy,[[[np(dat)]],[[prepnp(dla,gen)]]]).
slowprzym(nieznany,[[[compar(jako)],[xp(locat)]],[[comprepnp('od strony')],[xp(locat)]],[[comprepnp('ze strony')],[xp(locat)]],[[comprepnp('ze względu na')],[xp(locat)]],[[np(dat)],[compar(jako)]],[[np(dat)],[comprepnp('od strony')]],[[np(dat)],[comprepnp('pod względem')]],[[np(dat)],[comprepnp('ze strony')]],[[np(dat)],[comprepnp('ze względu na')]],[[np(dat)],[prepnp(z,gen)]],[[np(dat)],[xp(abl)]],[[np(dat)],[xp(caus)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(z,gen)],[xp(locat)]],[[xp(abl)],[xp(locat)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(niezniszczalny,[[[prepnp(dla,gen)],[prepnp(przez,acc)]],[[prepnp(dla,gen)],[xp(instr)]],[[prepnp(w,loc)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(niezręczny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niezrozumiały,[[[np(dat)]],[[prepnp('co do',gen)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(caus)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(niezwykły,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc),prepncp(w,loc,int),prepncp(w,loc,że)]],[[prepnp(dla,gen)],[xp(caus)]],[[xp(locat)]],[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(nieżyczliwy,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(ku,dat)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(normalny,[[[advp(misc)]],[[comprepnp('pod względem')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[xp(locat),xp(temp)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(żeby)]],[[cp(że)],[xp(locat)]]]).
slowprzym(obcy,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[np(dat)],[cp(że)]]]).
slowprzym(obecny,[[[np(inst)],[xp(locat)]],[[prepnp(przez,acc)]]]).
slowprzym(obeschły,[[[prepnp(z,gen)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(obeschnięty,[[[prepnp(z,gen)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(obieralny,[[[prepnp(przez,acc)],[prepnp(w,loc)]],[[prepnp(przez,acc)],[xp(locat)]],[[prepnp(z,gen)]],[[xp(abl)]]]).
slowprzym(oblazły,[[[np(inst)]],[[prepnp(z,gen)],[xp(locat)]]]).
slowprzym(obliczalny,[[[comprepnp('na podstawie')]],[[comprepnp('pod względem')]],[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(na,loc)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)],[xp(mod)]],[[prepnp(z,gen)]]]).
slowprzym(obmierzły,[[[np(dat)]],[[prepnp(dla,gen)]]]).
slowprzym(obojętny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[comprepnp('w zakresie')]],[[np(dat)],[comprepnp('pod względem')]],[[np(dat)],[xp(mod)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(na,acc),prepnp(wobec,gen),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(wobec,gen,int),prepncp(wobec,gen,że)]],[[prepnp(w,loc)]],[[prepnp(względem,gen),prepncp(względem,gen,int)]],[[np(dat)],[cp(int)]],[[np(dat)],[cp(że)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(obracalny,[[[comprepnp('za pomocą')]],[[prepnp(o,acc)],[prepnp(w,loc)]],[[prepnp(wokół,gen)]]]).
slowprzym(obrosły,[[[np(inst)],[xp(locat)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(w,acc)]]]).
slowprzym(obrzękły,[[[np(inst)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(obrzmiały,[[[np(inst)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(obrzydły,[[[np(dat)]],[[prepnp(dla,gen)]]]).
slowprzym(obserwowalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(abl)]],[[xp(dur)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(obumarły,[[[xp(caus)]]]).
slowprzym(obwisły,[[[prepnp(na,acc)]],[[prepnp(na,loc)]],[[prepnp(pod,inst)]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(obyty,[[[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[prepnp(z,inst)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(ocalały,[[[prepnp(od,gen)]],[[prepnp(po,loc),prepncp(po,loc,jak)]],[[prepnp(przed,inst)]],[[prepnp(z,gen)]],[[xp(mod)]]]).
slowprzym(ochoczy,[[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat)]],[[prepnp(w,loc)]]]).
slowprzym(ochrypły,[[[xp(caus)]]]).
slowprzym(ociekły,[[[np(inst)]],[[prepnp(z,gen)]],[[xp(abl)]]]).
slowprzym(oczytany,[[[comprepnp('na temat')]],[[comprepnp('w temacie')]],[[np(inst)]],[[prepnp(w,loc)]],[[prepnp(z,inst)]]]).
slowprzym(oczywisty,[[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(odczuwalny,[[[np(inst)],[prepnp(przez,acc)]],[[prepnp(dla,gen)],[xp(locat)]],[[prepnp(przez,acc)],[xp(mod)]],[[prepnp(przy,loc)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(oddzielny,[[[compar(niż)]],[[prepnp(od,gen),prepncp(od,gen,int)]]]).
slowprzym(odkształcalny,[[[comprepnp('pod wpływem')]],[[comprepnp('za pomocą')]],[[prepnp(przez,acc)]],[[xp(mod)]]]).
slowprzym(odległy,[[[prepnp(o,acc)],[prepnp(od,gen)]],[[prepnp(od,gen)],[comprepnp('pod względem'),xp(mod)]]]).
slowprzym(odmienny,[[[compar(jak)]],[[prepnp('co do',gen)]],[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen),prepncp(od,gen,int),prepncp(od,gen,że)],[prepnp(w,loc)]],[[prepnp(od,gen)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)],[compar(niż)]]]).
slowprzym(odnawialny,[[[prepnp(przez,acc)]],[[xp(mod)]]]).
slowprzym(odporny,[[[comprepnp('w stosunku do')]],[[prepnp(na,acc),prepncp(na,acc,że),prepncp(na,acc,żeby)],[xp(mod)]],[[prepnp(na,acc)],[prepnp(w,loc)]],[[prepnp(przeciw,dat)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(odpowiedni,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[cp(żeby)]],[[prepnp(dla,gen)],[prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[prepnp(wobec,gen)]],[[xp(locat)]],[[xp(temp)]],[[cp(że)]]]).
slowprzym(odpowiedzialny,[[[cp(że)]],[[prepnp(przed,inst)],[cp(żeby)]],[[prepnp(przed,inst),prepnp(wobec,gen),xp(locat)],[prepnp(przez,acc),prepncp(przez,acc,że)],[prepnp(za,acc),prepncp(za,acc,int),prepncp(za,acc,że),prepncp(za,acc,żeby)]],[[prepnp(wobec,gen)],[cp(żeby)]],[[prepnp(względem,gen)],[prepnp(za,acc)]]]).
slowprzym(odrębny,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)],[prepnp(od,gen)]],[[prepnp(od,gen)],[comprepnp('na gruncie')]],[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen)],[comprepnp('w zakresie')]],[[prepnp(od,gen)],[comprepnp('ze względu na')]],[[prepnp(od,gen)],[prepnp(w,loc)]],[[prepnp(od,gen)],[xp(mod)]],[[prepnp(wobec,gen)]],[[prepnp(wśród,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(odrętwiały,[[[comprepnp('pod względem')]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]],[[xp(mod)]]]).
slowprzym(odrosły,[[[prepnp(od,gen)]]]).
slowprzym(odróżnialny,[[[np(inst)],[prepnp(od,gen)]],[[prepnp(dla,gen)],[prepnp(od,gen)]],[[prepnp(od,gen)],[comprepnp('na gruncie')]],[[prepnp(od,gen)],[comprepnp('na podstawie')]],[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen)],[comprepnp('za pomocą')]],[[prepnp(od,gen)],[comprepnp('ze względu na')]],[[prepnp(od,gen)],[prepnp(po,loc)]],[[prepnp(od,gen)],[prepnp(przez,acc)]],[[prepnp(od,gen)],[prepnp(w,loc)]],[[prepnp(od,gen)],[xp(mod)]]]).
slowprzym(odtajały,[[[prepnp(z,gen)]]]).
slowprzym(odtwarzalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(z,gen)]],[[xp(locat)]]]).
slowprzym(odwołalny,[[[prepnp(przez,acc)]]]).
slowprzym(odwoływalny,[[[prepnp(przez,acc)],[comprepnp('z powodu')],[xp(abl)]]]).
slowprzym(odwracalny,[[[comprepnp('pod wpływem'),xp(mod)]],[[comprepnp('pod względem')]],[[prepnp(do,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]]]).
slowprzym(odwrotny,[[[compar(jak)]],[[compar(niż)]],[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(do,gen)]],[[prepnp(od,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(odwykły,[[[prepnp(od,gen)]]]).
slowprzym(oględny,[[[prepnp(w,loc)]],[[prepnp(wobec,gen)]]]).
slowprzym(ogłuchły,[[[xp(caus)]],[[xp(mod)]]]).
slowprzym(ogłupiały,[[[comprepnp('na punkcie')]],[[comprepnp('z powodu')]],[[np(inst)]],[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[prepnp(z,gen)]]]).
slowprzym(ogorzały,[[[np(inst)]],[[prepnp(od,gen)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(oklapły,[[[xp(caus)]]]).
slowprzym(okropny,[[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(okrutny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(okrzepły,[[[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(omdlały,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(oniemiały,[[[comprepnp('na widok')]],[[prepnp(od,gen)]],[[prepnp(z,gen)]]]).
slowprzym(oporny,[[[comprepnp('w stosunku do')]],[[prepnp(na,acc),prepncp(na,acc,żeby)]],[[prepnp(w,loc),prepncp(w,loc,żeby)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(opozycyjny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(oprawny,[[[prepnp(w,acc)]]]).
slowprzym(oprzytomniały,[[[prepnp(z,gen)]]]).
slowprzym(optymistyczny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[cp(że)]]]).
slowprzym(opuchły,[[[np(inst)]],[[prepnp(po,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(opuchnięty,[[[np(inst)]],[[prepnp(po,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(osiadły,[[[xp(locat)],[xp(temp)]]]).
slowprzym(osiągalny,[[[np(inst)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('za pomocą')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(dla,gen)],[xp(locat)],[xp(temp)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(osiwiały,[[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(osłabły,[[[np(inst)]],[[prepnp(w,loc)]],[[xp(caus)],[xp(mod)]]]).
slowprzym(osłupiały,[[[comprepnp('na widok')]],[[cp(że)]],[[np(inst)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[xp(caus)]]]).
slowprzym(osobliwy,[[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[prepnp(wśród,gen)]],[[cp(int)]],[[cp(że)]]]).
slowprzym(osowiały,[[[xp(caus)]]]).
slowprzym(ostygły,[[[prepnp(w,acc)],[xp(caus)]]]).
slowprzym(oszalały,[[[comprepnp('na punkcie')]],[[xp(caus)]]]).
slowprzym(oszczędny,[[[prepnp(w,acc)]],[[prepnp(w,loc)]],[[xp(locat)]]]).
slowprzym(oślepły,[[[np(inst)]],[[prepnp(na,acc)]],[[xp(caus)]]]).
slowprzym(otępiały,[[[comprepnp('pod względem')]],[[np(inst)]],[[prepnp(po,loc)]],[[prepnp(w,loc)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(owdowiały,[[[xp(mod)]]]).
slowprzym(ozdrowiały,[[[prepnp(z,gen)]]]).
slowprzym(oziębły,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[xp(locat)]]]).
slowprzym(padły,[[[comprepnp('na widok')]],[[comprepnp('ze względu na')]],[[prepnp(pod,inst)]],[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(pamiętny,[[[cp(że)]],[[np(gen),ncp(gen,int),ncp(gen,że)]],[[np(inst),ncp(inst,że)]],[[prepnp(dla,gen)]],[[prepnp(na,acc),prepncp(na,acc,że)]]]).
slowprzym(paradoksalny,[[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[xp(caus)]],[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(paralelny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(paskudny,[[[cp(że)]]]).
slowprzym(pazerny,[[[comprepnp('w stosunku do')]],[[np(gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(pełnomocny,[[head,[infp(_G1584)]],[[prepnp(do,gen)]]]).
slowprzym(perfekcyjny,[[[prepnp(w,loc),prepncp(w,loc,int)]]]).
slowprzym(pewny,[[[advp(misc)]],[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[cp(jakoby)]],[[np(gen),cp(int),cp(że),ncp(gen,int),ncp(gen,że)]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,że),prepncp('co do',gen,żeby)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(w,loc),prepncp(w,loc,int)],[lex(np(gen),[sg,siebie],natr)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(int),cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(pęknięty,[[[prepnp(na,acc)]],[[xp(caus)],[xp(locat)],[xp(mod)]]]).
slowprzym(pierwotny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(pierwszy,[[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(między,inst)]],[[prepnp(po,loc)]],[[prepnp(spośród,gen),prepnp(wśród,gen),prepnp(z,inst)],[xp(locat)]]]).
slowprzym(piękny,[[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(w,loc),prepncp(w,loc,że)]],[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]]]).
slowprzym(pijalny,[[[prepnp(dla,gen)]]]).
slowprzym(płatny,[[[advp(misc)]],[[comprepnp('na rzecz')]],[[comprepnp('w wysokości')]],[[np(acc)]],[[np(inst)],[xp(temp)]]]).
slowprzym(pływalny,[[[prepnp(dla,gen)]],[[xp(mod)]]]).
slowprzym(pobielały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(pobłażliwy,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(pochodny,[[[comprepnp('w stosunku do')]],[[prepnp(od,gen)],[xp(mod)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(pociemniały,[[[np(inst)]],[[xp(caus)],[xp(mod)]],[[xp(locat)]]]).
slowprzym(poczerniały,[[[np(inst)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(poczerwieniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(podatny,[[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]]]).
slowprzym(podbiegły,[[[np(inst)]]]).
slowprzym(podchmielony,[[[np(inst)]]]).
slowprzym(podejrzliwy,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,że)]],[[prepnp(do,gen)]],[[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że)]],[[prepnp(wobec,gen),prepncp(wobec,gen,że)]],[[prepnp(względem,gen)]]]).
slowprzym(podeschły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(podległy,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(pod,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(podmarznięty,[[[xp(locat)]]]).
slowprzym(podobny,[[[np(dat)],[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)]],[[prepnp(do,gen)],[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)]],[[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)],[compar(co)]],[[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)],[compar(jak)]],[[prepnp(w,loc),prepnp(z,gen),comprepnp('pod względem'),xp(mod)],[prepnp(z,inst)]]]).
slowprzym(podpity,[[[np(inst)]]]).
slowprzym(podpuchły,[[[prepnp(od,gen)]],[[prepnp(z,gen)]]]).
slowprzym(podpuchnięty,[[[xp(caus)]],[[xp(locat)]]]).
slowprzym(podrosły,[[[prepnp(o,acc)],[xp(locat)]]]).
slowprzym(podrzędny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(pod,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(podupadły,[[[prepnp(na,loc)]],[[prepnp(z,gen)]]]).
slowprzym(podzielny,[[[prepnp(na,acc)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(w,acc)]],[[prepnp(w,loc)]]]).
slowprzym(pogasły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(poirytowany,[[[comprepnp('w stosunku do')]],[[cp(że)]],[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepnp(na,acc),prepncp(na,acc,że)]],[[prepnp(przez,acc),prepncp(przez,acc,że)]]]).
slowprzym(pojaśniały,[[[comprepnp('na widok')]],[[xp(caus)],[xp(locat)]]]).
slowprzym(pokorny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(przed,inst)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(pokrewny,[[[comprepnp('w stosunku do')]],[[np(dat)],[advp(misc)]],[[np(dat)],[np(inst)]],[[np(dat)],[prepnp(w,loc)]],[[np(dat)],[prepnp(z,gen)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(poległy,[[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)],[prepnp(za,acc)],[xp(locat)],[xp(mod)]]]).
slowprzym(polemiczny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(policzalny,[[[prepnp(dla,gen)]],[[prepnp(na,loc)]],[[prepnp(w,loc)]]]).
slowprzym(pomny,[[[cp(int)]],[[cp(że)]],[[cp(żeby)]],[[np(dat)]],[[np(gen),ncp(gen,int),ncp(gen,że),ncp(gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]]]).
slowprzym(pomocny,[[[np(dat)],[prepnp(dla,gen),prepnp(na,acc),prepnp(w,loc),prepncp(w,loc,że)]],[[np(dat)],[xp(locat),xp(temp)]],[[prepnp(dla,gen)],[prepnp(w,loc)]]]).
slowprzym(pomyślany,[[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc)]],[[prepnp(pod,acc)]],[[prepnp(przez,acc)],[compar(jako)]],[[prepnp(według,gen)]],[[prepnp(w,loc)],[compar(jako)]],[[xp(mod)]]]).
slowprzym(ponury,[[[cp(gdy)]],[[cp(jeśli)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(popróchniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(pordzewiały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(porosły,[[[np(inst)],[xp(locat)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(w,acc)]]]).
slowprzym(porośnięty,[[[np(inst)],[xp(locat)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(w,acc)]]]).
slowprzym(porównywalny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]]]).
slowprzym(poróżowiały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(posiniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(posiwiały,[[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(posłuszny,[[[comprepnp('w stosunku do')]],[[np(dat)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(posmutniały,[[[cp(że)]],[[xp(caus)]]]).
slowprzym(postarzały,[[[prepnp(o,acc)]]]).
slowprzym(postrzegalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)],[xp(mod)]],[[xp(instr)]]]).
slowprzym(poszarzały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(pośredni,[[[prepnp(między,inst)]]]).
slowprzym(potrącalny,[[[prepnp(od,gen)]],[[prepnp(przy,loc)]],[[prepnp(z,gen)]]]).
slowprzym(potrzebny,[[[advp(misc)]],[[np(dat)],[comprepnp('pod względem')]],[[np(dat)],[comprepnp('ze względu na')]],[[np(dat)],[cp(żeby)]],[[np(dat)],[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepnp(w,loc),prepncp(do,gen,żeby),prepncp(na,acc,żeby),xp(locat),xp(temp)]],[[np(dat)],[prepnp(wobec,gen)]]]).
slowprzym(poufały,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(powolny,[[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(powołany,[[[cp(żeby)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]]]).
slowprzym(powstały,[[[comprepnp('na kanwie')]],[[prepnp(przeciw,dat)]],[[prepnp(z,gen)]],[[xp(caus)],[xp(locat)],[xp(temp)]]]).
slowprzym(powściągliwy,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(powtarzalny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)],[xp(mod)]],[[xp(locat)]]]).
slowprzym(pozieleniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(poznawalny,[[[prepnp(dla,gen)],[comprepnp('na podstawie')]],[[prepnp(dla,gen)],[prepnp(dzięki,dat),prepnp(w,loc)]],[[prepnp(dla,gen)],[prepnp(po,loc)]],[[prepnp(dla,gen)],[prepnp(przez,acc),xp(mod)]],[[prepnp(dla,gen)],[prepnp(z,gen)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(dla,gen)],[xp(instr)]]]).
slowprzym(pozostały,[[[np(dat)],[prepnp(do,gen)]],[[np(dat)],[prepnp(po,loc)],[xp(locat)]],[[np(dat)],[prepnp(z,gen)],[xp(locat)]],[[prepnp(przy,loc)]]]).
slowprzym(pożądany,[[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(pożółkły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(pożyteczny,[[[np(dat)]],[[prepnp(dla,gen),prepnp(w,loc)]],[[prepnp(do,gen)]],[[prepnp(ku,dat)]]]).
slowprzym(prawdopodobny,[[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[xp(locat)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(prędki,[[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat)]],[[prepnp(w,loc)]]]).
slowprzym(programowalny,[[[comprepnp('za pomocą')],[xp(mod)]],[[np(inst)],[xp(mod)]],[[prepnp(na,acc)],[prepnp(w,loc)]],[[prepnp(z,gen)],[xp(mod)]]]).
slowprzym(proporcjonalny,[[[comprepnp('w stosunku do')],[advp(misc)]],[[prepnp(do,gen),prepncp(do,gen,int)],[prepnp(w,loc)],[advp(misc)]],[[prepnp(wobec,gen)],[advp(misc)]],[[prepnp(względem,gen)],[advp(misc)]],[[prepnp(z,inst)],[advp(misc)]]]).
slowprzym(prostopadły,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(prosty,[[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[prepnp(dla,gen)],[prepnp(do,gen)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(przebrzmiały,[[[comprepnp('pod względem')]],[[xp(mod)]]]).
slowprzym(przeciwny,[[[compar(jak)]],[[compar(niż)]],[[comprepnp('w stosunku do')]],[[cp(żeby)]],[[np(dat),ncp(dat,int),ncp(dat,że),ncp(dat,żeby)]],[[prepnp(do,gen)]],[[prepnp(od,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(przeciwstawny,[[[compar(niż)]],[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,int)]],[[prepnp(do,gen)]],[[prepnp(od,gen)]],[[prepnp(wobec,gen),prepncp(wobec,gen,int)]],[[prepnp(względem,gen),prepncp(względem,gen,int)]]]).
slowprzym(przejezdny,[[[np(inst)]],[[prepnp(dla,gen)]],[[xp(adl)]],[[xp(locat)]],[[xp(perl)]]]).
slowprzym(przejrzały,[[[xp(caus)]]]).
slowprzym(przejściowy,[[[prepnp(między,inst)]]]).
slowprzym(przekazywalny,[[[np(dat)],[xp(instr)]],[[np(dat)],[xp(mod)]],[[prepnp(w,loc)]],[[xp(abl)],[xp(adl)],[xp(perl)]]]).
slowprzym(przekładalny,[[[np(inst)],[prepnp(na,acc)],[prepnp(z,gen)],[xp(mod)]],[[prepnp(z,inst)]]]).
slowprzym(przekraczalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(przekwitły,[[[xp(temp)]]]).
slowprzym(przelękły,[[[np(inst),ncp(inst,int)]]]).
slowprzym(przeliczalny,[[[comprepnp('za pomocą')]],[[prepnp(na,acc)]],[[prepnp(z,inst)]]]).
slowprzym(przemarzły,[[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(przemarznięty,[[[xp(caus)]],[[xp(locat)]]]).
slowprzym(przemokły,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(przenikalny,[[[prepnp(dla,gen)],[xp(mod)]]]).
slowprzym(przepuszczalny,[[[prepnp(dla,gen)],[xp(abl)],[xp(adl)],[xp(mod)]]]).
slowprzym(przerosły,[[[np(inst)]],[[prepnp(w,acc)]]]).
slowprzym(przesiąkły,[[[np(inst)]]]).
slowprzym(przesuwalny,[[[comprepnp('w stosunku do')]],[[prepnp(o,acc)],[xp(abl)],[xp(adl)],[xp(instr)],[xp(perl)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]]]).
slowprzym(przeświadczony,[[[cp(że)]],[[prepnp(o,loc),prepncp(o,loc,że)]]]).
slowprzym(przetłumaczalny,[[[prepnp(dla,gen)]],[[prepnp(na,acc)],[prepnp(z,gen)]],[[xp(mod)]]]).
slowprzym(przewidywalny,[[[comprepnp('na gruncie')]],[[comprepnp('pod kątem')]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[comprepnp('z powodu')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(przez,acc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(przyblakły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(przybłąkany,[[[xp(abl)],[xp(adl)]]]).
slowprzym(przybyły,[[[np(inst)],[xp(abl)],[xp(adl)]],[[prepnp(na,loc)],[xp(abl)],[xp(adl)]],[[prepnp(w,loc)],[xp(abl)],[xp(adl)]],[[prepnp(z,inst)],[xp(adl)]],[[xp(abl)],[xp(adl)],[xp(dest)]]]).
slowprzym(przychylny,[[[comprepnp('w stosunku do')]],[[np(dat),prepnp(dla,gen),ncp(dat,że),ncp(dat,żeby)]],[[prepnp(do,gen),prepncp(do,gen,że),prepncp(do,gen,żeby)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(przycichły,[[[xp(caus)]],[[xp(locat)],[xp(temp)]]]).
slowprzym(przyczajony,[[[cp(żeby)]],[[prepnp(do,gen)]],[[prepnp(na,acc)],[prepnp(z,inst)],[xp(locat)]]]).
slowprzym(przyczepny,[[[prepnp(do,gen)]],[[prepnp(na,loc)]]]).
slowprzym(przydatny,[[[advp(misc)]],[[np(dat)],[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepnp(przy,loc),prepncp(do,gen,żeby),xp(locat),xp(temp)]],[[prepnp(dla,gen)],[prepnp(do,gen)]],[[prepnp(dla,gen)],[prepnp(na,acc)]],[[prepnp(dla,gen)],[prepnp(przy,loc)]]]).
slowprzym(przygasły,[[[xp(caus)]]]).
slowprzym(przyjazny,[[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,żeby)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(przykry,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(przyległy,[[[prepnp(do,gen)],[xp(abl)]]]).
slowprzym(przymilny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(przypadły,[[[np(dat)],[prepnp(po,loc)]],[[np(dat)],[prepnp(w,loc)]],[[prepnp(do,gen)]]]).
slowprzym(przyrosły,[[[np(dat)],[prepnp(do,gen)]]]).
slowprzym(przyschły,[[[prepnp(do,gen)],[xp(caus)],[xp(locat)]],[[prepnp(w,loc)]]]).
slowprzym(przyswajalny,[[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(przywykły,[[[cp(żeby)]],[head,[infp(imperf)]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że),prepncp(do,gen,żeby)]]]).
slowprzym(rad,[[[cp(że)]],[[cp(żeby)]],[[np(dat),ncp(dat,że),ncp(dat,żeby)]],[[prepnp(z,gen),prepncp(z,gen,że)]]]).
slowprzym(realny,[[[prepnp(dla,gen)],[prepnp(do,gen)]],[[xp(mod)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(redukowalny,[[[prepnp(do,gen)],[xp(mod)]]]).
slowprzym(reformowalny,[[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(reprezentatywny,[[[comprepnp('w kwestii')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(rodzinny,[[[prepnp(u,gen)],[cp(że)]]]).
slowprzym(rozbieralny,[[[prepnp(na,acc)],[xp(instr)]]]).
slowprzym(rozbieżny,[[[compar(niż)]],[[prepnp('co do',gen),prepncp('co do',gen,int)]],[[prepnp(od,gen)]],[[prepnp(z,inst),prepncp(z,inst,int)]]]).
slowprzym(rozbolały,[[[xp(caus)]]]).
slowprzym(rozchichotany,[[[comprepnp('z powodu')]],[[prepnp(przez,acc)]],[[prepnp(z,gen)]]]).
slowprzym(rozeschły,[[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(roześmiany,[[[comprepnp('z powodu')]],[[np(inst)]],[[prepnp(z,gen)]]]).
slowprzym(rozgorzały,[[[np(inst)]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(rozkładalny,[[[prepnp(dla,gen)],[prepnp(na,acc)]],[[prepnp(do,gen)],[xp(instr)]],[[prepnp(na,acc)],[prepnp(przez,acc)]],[[prepnp(na,acc)],[prepnp(w,loc)]],[[prepnp(na,acc)],[xp(instr)]],[[prepnp(na,acc)],[xp(mod)]]]).
slowprzym(rozkwitły,[[[comprepnp('za sprawą')]],[[np(inst)],[xp(locat)],[xp(temp)]],[[prepnp(z,gen)]]]).
slowprzym(rozlazły,[[[prepnp(w,loc)]],[[xp(adl)]],[[xp(caus)],[xp(locat)]],[[xp(caus)],[xp(mod)]]]).
slowprzym(rozmiękły,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(rozpadły,[[[prepnp(na,acc)]],[[prepnp(przez,acc)]],[[prepnp(w,acc)]]]).
slowprzym(rozpadnięty,[[[prepnp(na,acc)],[xp(caus)]],[[prepnp(w,acc)],[xp(caus)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(rozpełzły,[[[prepnp(w,acc)],[xp(adl)]],[[prepnp(w,acc)],[xp(locat)]]]).
slowprzym(rozpierzchły,[[[xp(adl)]],[[xp(locat)]]]).
slowprzym(rozpłakany,[[[cp(że)]],[[np(inst)]],[[xp(caus)]]]).
slowprzym(rozporządzalny,[[[prepnp(przez,acc)],[xp(temp)]]]).
slowprzym(rozpoznawalny,[[[prepnp(dla,gen)]],[[prepnp(po,loc)]],[[prepnp(przez,acc)],[prepnp(z,gen)]],[[xp(abl)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(rozpuszczalny,[[[comprepnp('pod wpływem')]],[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(w,loc)]]]).
slowprzym(rozrosły,[[[np(inst)]],[[prepnp(do,gen)]],[[prepnp(w,acc)]],[[xp(adl)]],[[xp(locat)]]]).
slowprzym(rozrośnięty,[[[np(inst)]],[[prepnp(do,gen)]],[[prepnp(w,acc)]],[[xp(adl)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(rozróżnialny,[[[comprepnp('na podstawie')]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)],[prepnp(od,gen)]],[[prepnp(dla,gen)]],[[prepnp(między,inst)]],[[prepnp(od,gen)],[xp(mod)]],[[prepnp(po,loc)]],[[prepnp(przez,acc)]],[[prepnp(według,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]],[[xp(abl)]],[[xp(instr)]]]).
slowprzym(rozsądny,[[[comprepnp('pod względem')]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[comprepnp('ze strony')],[cp(że)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(żeby)]]]).
slowprzym(rozstrzygalny,[[[comprepnp('na gruncie')]],[[comprepnp('w ramach')]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(mod)]]]).
slowprzym(rozszalały,[[[comprepnp('na punkcie')]],[[np(inst)]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(rozszczepialny,[[[prepnp(na,acc)],[xp(caus)]]]).
slowprzym(rozszerzalny,[[[prepnp(do,gen)],[prepnp(przez,acc)]],[[prepnp(do,gen)],[xp(instr)]],[[prepnp(na,acc)],[xp(instr)]],[[prepnp(o,acc)],[xp(instr)]],[[prepnp(w,acc)],[xp(instr)]]]).
slowprzym(roztropny,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[xp(mod)]],[[comprepnp('ze strony')],[cp(że)]],[[comprepnp('ze strony')],[cp(żeby)]]]).
slowprzym(roztyty,[[[prepnp(do,gen)],[prepnp(po,loc)],[xp(locat)]]]).
slowprzym(rozwścieczony,[[[comprepnp('z powodu')]],[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepncp(na,acc,że)]],[[prepnp(na,acc)],[cp(że)]],[[prepnp(na,acc)],[prepnp(za,acc),prepncp(za,acc,że)]],[[prepnp(z,gen)]]]).
slowprzym(równoczesny,[[[prepnp(z,inst)]]]).
slowprzym(równoległy,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(równoprawny,[[[comprepnp('w stosunku do')]],[[comprepnp('w zakresie')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)],[prepnp(z,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(równorzędny,[[[comprepnp('w stosunku do')]],[[np(dat)],[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)],[prepnp(z,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(równoważny,[[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,int),ncp(dat,że)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,int)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]]]).
slowprzym(równoznaczny,[[[np(dat),ncp(dat,że)]],[[prepnp('co do',gen)],[prepnp(z,inst)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)],[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że),prepncp(z,inst,żeby)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)],[comprepnp('pod względem')]],[[cp(że)]]]).
slowprzym(równy,[[[comprepnp('w stosunku do')]],[[np(dat)],[np(inst)]],[[np(dat)],[prepnp(w,loc)]],[[np(dat)],[prepnp(z,gen)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(różny,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)],[prepnp(od,gen)]],[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen)],[comprepnp('ze względu na')]],[[prepnp(od,gen)],[xp(mod)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(rycerski,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(sceptyczny,[[[comprepnp('na temat')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[cp(int)]],[[cp(jakoby)]],[[cp(że)]],[[cp(żeby)]],[[np(dat)]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,jakoby),prepncp('co do',gen,że),prepncp('co do',gen,żeby)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen),prepncp(wobec,gen,int),prepncp(wobec,gen,jakoby),prepncp(wobec,gen,że),prepncp(wobec,gen,żeby)]],[[prepnp(względem,gen),prepncp(względem,gen,int),prepncp(względem,gen,że)]]]).
slowprzym(serdeczny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(sfermentowany,[[[comprepnp('pod wpływem')]],[[prepnp(na,loc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(locat)]]]).
slowprzym(sflaczały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(skalowalny,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(względem,gen)]],[[xp(mod)]]]).
slowprzym(skarlały,[[[comprepnp('pod względem')]],[[np(inst)]],[[prepnp(do,gen)],[xp(caus)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(skąpy,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(w,acc)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(skłonny,[[[cp(żeby)]],[head,[infp(_G1646)]],[[np(dat),ncp(dat,żeby)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat),prepncp(ku,dat,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]]]).
slowprzym(skonany,[[[comprepnp('z powodu')]],[[np(inst)]],[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[prepnp(z,gen)]]]).
slowprzym(skorodowany,[[[np(inst)]],[[xp(caus)],[xp(locat)]],[[xp(mod)]]]).
slowprzym(skory,[[[cp(żeby)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(ku,dat),prepncp(ku,dat,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]]]).
slowprzym(skromny,[[[np(inst)]],[[prepnp(w,acc)]],[[prepnp(w,loc)]]]).
slowprzym(skruszały,[[[prepnp(na,acc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(skrzepły,[[[prepnp(w,acc)],[xp(locat)]],[[xp(caus)]]]).
slowprzym(skwaśniały,[[[prepnp(na,acc)],[xp(caus)]],[[prepnp(w,loc)]]]).
slowprzym(słaby,[[[comprepnp('w stosunku do')]],[[prepnp(o,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,gen)]]]).
slowprzym(sławny,[[[comprepnp('z powodu'),comprepnp('ze względu na')]],[[np(inst),ncp(inst,że)]],[[prepnp(z,gen),prepncp(z,gen,int),prepncp(z,gen,że)]]]).
slowprzym(słodki,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(słuszny,[[[comprepnp('pod względem')]],[[xp(mod)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(służalczy,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(służebny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(słynny,[[[comprepnp('ze względu na')]],[[comprepnp('z powodu')]],[[np(inst),ncp(inst,że)]],[[prepnp(z,gen),prepncp(z,gen,int),prepncp(z,gen,że)]]]).
slowprzym(słyszalny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(locat)]]]).
slowprzym(smutny,[[[prepnp(dla,gen)],[prepnp(w,loc)]],[[xp(caus)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(solidarny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(między,inst)]],[[prepnp(w,loc),prepncp(w,loc,że)],[prepnp(z,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(spadły,[[[prepnp(na,acc)]],[[xp(abl)],[xp(adl)]]]).
slowprzym(spanikowany,[[[cp(int)]],[[cp(że)]],[[np(inst),ncp(inst,że)]],[[prepnp(przed,inst)]],[[xp(caus)]]]).
slowprzym(spąsowiały,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(specyficzny,[[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(spełzły,[[[lex(prepnp(na,loc),[_G1614,nic],natr)]],[[xp(abl)],[xp(adl)],[xp(perl)]],[[xp(caus)]]]).
slowprzym(spęczniały,[[[np(inst)]],[[prepnp(w,acc)]],[[xp(caus)]],[[xp(locat)]]]).
slowprzym(spękany,[[[np(inst)],[xp(caus)],[xp(locat)],[xp(mod)]]]).
slowprzym(spiekły,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(spierzchły,[[[np(inst)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(spierzchnięty,[[[np(inst)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(spleśniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(spłacalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(z,gen)]]]).
slowprzym(spłowiały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(spocony,[[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(spodziewany,[[[prepnp(od,gen)]],[[prepnp(po,loc)]],[[prepnp(przez,acc)]],[[xp(locat)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(spokojny,[[[cp(że)]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,że)]],[[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że)]]]).
slowprzym(spokorniały,[[[prepnp(przed,inst)]],[[prepnp(wobec,gen)]],[[xp(caus)]]]).
slowprzym(spolegliwy,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(mod)]]]).
slowprzym(sporny,[[[comprepnp('pod względem')]],[[prepnp('co do',gen)]],[[prepnp(z,inst)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(sposępniały,[[[xp(caus)]]]).
slowprzym(spotniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(spoważniały,[[[xp(caus)]]]).
slowprzym(spowszedniały,[[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(od,gen)]]]).
slowprzym(spójny,[[[comprepnp('w stosunku do')]],[[prepnp(w,loc)],[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(spóźniony,[[[np(acc)],[prepnp(na,acc)]],[[np(acc)],[prepnp(z,inst)]],[[np(acc)],[xp(adl)]],[[prepnp(dla,gen)],[prepnp(o,acc)]],[[prepnp(na,acc)],[prepnp(o,acc)]],[[prepnp(o,acc)],[comprepnp('pod względem')]],[[prepnp(o,acc)],[comprepnp('w stosunku do')]],[[prepnp(o,acc)],[prepnp(w,loc)]],[[prepnp(o,acc)],[prepnp(wobec,gen)]],[[prepnp(o,acc)],[prepnp(względem,gen)]],[[prepnp(o,acc)],[prepnp(z,inst)]],[[prepnp(o,acc)],[xp(adl)]],[[prepnp(o,acc)],[xp(caus)]],[[prepnp(o,acc)],[xp(locat)]]]).
slowprzym(sprawdzalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(po,loc)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(z,inst)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(sprawiedliwy,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen),prepnp(względem,gen)]],[[xp(mod)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(sprawny,[[[prepnp(w,loc)],[xp(mod)]]]).
slowprzym(sprowadzalny,[[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,że)]]]).
slowprzym(spróchniały,[[[xp(caus)],[xp(locat)]],[[xp(mod)]]]).
slowprzym(sprzeczny,[[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[prepnp(w,loc)],[prepnp(z,inst)]],[[prepnp(wobec,gen)]],[[prepnp(z,inst)],[comprepnp('pod względem')]],[[prepnp(z,inst)],[xp(mod)]]]).
slowprzym(sprzymierzony,[[[prepnp(przeciw,dat)],[prepnp(z,inst)],[xp(mod)]],[[prepnp(w,loc)]]]).
slowprzym(spuchły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(stały,[[[advp(misc)]],[[prepnp(w,loc)]]]).
slowprzym(stary,[[[np(inst)]],[[prepnp(o,acc)]]]).
slowprzym(sterowalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(adl)]]]).
slowprzym(stępiały,[[[prepnp(na,acc)],[xp(caus)]]]).
slowprzym(stężały,[[[np(inst)]],[[prepnp(na,acc)],[xp(caus)]],[[prepnp(w,acc)],[xp(caus)]],[[prepnp(w,loc)]]]).
slowprzym(stopniały,[[[prepnp(do,gen)],[prepnp(o,acc)],[prepnp(z,gen)],[xp(caus)]],[[prepnp(w,loc)],[xp(temp)]]]).
slowprzym(stosowalny,[[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(stosowny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(mod)]],[[cp(gdy)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(straszny,[[[prepnp(dla,gen)],[prepnp(do,gen)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(strojny,[[[np(inst)]],[[prepnp(w,acc)]]]).
slowprzym(struchlały,[[[comprepnp('na widok')]],[[prepnp(wobec,gen)]],[[xp(caus)]]]).
slowprzym(stwardniały,[[[prepnp(na,acc)],[xp(caus)]],[[prepnp(na,loc)]],[[prepnp(w,loc)]]]).
slowprzym(stwierdzalny,[[[comprepnp('na podstawie')]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(styczny,[[[prepnp(do,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)],[xp(locat)]]]).
slowprzym(surowy,[[[prepnp(dla,gen),comprepnp('w stosunku do')]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(swoisty,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(symetryczny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(sympatyczny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(symptomatyczny,[[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(synonimiczny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(systematyczny,[[[prepnp(w,loc)]]]).
slowprzym(syty,[[[np(gen)]],[[np(inst),ncp(inst,że)]],[[prepnp(od,gen)]]]).
slowprzym(szczery,[[[comprepnp('na temat')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen),comprepnp('w stosunku do')]],[[prepnp(względem,gen)]],[[prepnp(z,inst)]]]).
slowprzym(szczęśliwy,[[[cp(że)]],[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepnp(dla,gen)]],[[prepnp(z,gen),prepncp(z,gen,int),prepncp(z,gen,że)]]]).
slowprzym(szczodry,[[[comprepnp('w stosunku do')]],[[np(inst)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(szkodliwy,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(przez,acc)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(na,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(że)]]]).
slowprzym(ściągalny,[[[comprepnp('na podstawie')],[xp(abl)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(przez,acc)],[xp(abl)]],[[prepnp(w,loc)]],[[xp(locat)]]]).
slowprzym(ściemniały,[[[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(ścieralny,[[[np(inst)],[xp(abl)],[xp(mod)]]]).
slowprzym(ścierpły,[[[prepnp(przy,loc)]],[[xp(caus)]]]).
slowprzym(ślepy,[[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że)]],[[prepnp(wobec,gen)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(śmieszny,[[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc),prepncp(w,loc,int),prepncp(w,loc,że)]],[[prepnp(dla,gen)],[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]],[[prepnp(dla,gen)],[xp(caus)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(świadomy,[[[np(gen),cp(int),cp(że),ncp(gen,int),ncp(gen,że)]]]).
slowprzym(tęgi,[[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(z,gen)]]]).
slowprzym(tępy,[[[comprepnp('na temat')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[prepnp('co do',gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(z,gen)]]]).
slowprzym(tolerancyjny,[[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen),comprepnp('w stosunku do'),prepncp(wobec,gen,że)]],[[prepnp(względem,gen)]]]).
slowprzym(tożsamy,[[[np(dat),ncp(dat,że)]],[[prepnp('co do',gen)],[prepnp(z,inst)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(w,loc)],[prepnp(z,inst)]],[[prepnp(z,inst)],[comprepnp('pod względem')]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]],[[prepnp(z,inst)],[xp(mod)]]]).
slowprzym(tragiczny,[[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(trefny,[[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[xp(locat)]]]).
slowprzym(trudny,[[[np(dat)],[prepnp(do,gen)]],[[prepnp(dla,gen)],[prepnp(do,gen),prepnp(w,loc),prepncp(do,gen,żeby)]]]).
slowprzym(trwożliwy,[[[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że),prepncp(o,acc,żeby)]]]).
slowprzym(typowy,[[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)]],[[prepnp(w,loc)]],[[xp(locat),xp(temp)]],[[xp(mod)]],[[cp(że)],[xp(locat)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(ubieralny,[[[prepnp(na,acc)]],[[prepnp(w,acc)]]]).
slowprzym(ubogi,[[[np(inst)]],[[prepnp(o,acc),prepncp(o,acc,że)]],[[prepnp(w,acc)]],[[prepnp(w,loc)]]]).
slowprzym(ucichły,[[[prepnp(w,loc)]],[[xp(locat)],[xp(temp)]]]).
slowprzym(uczęszczany,[[[prepnp(przez,acc)]]]).
slowprzym(ufny,[[[comprepnp('w stosunku do')]],[[cp(że)]],[[np(dat),ncp(dat,że)]],[[prepnp('co do',gen),prepncp('co do',gen,że)]],[[prepnp(dla,gen)]],[[prepnp(w,acc),prepncp(w,acc,że)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(uległy,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(umarzalny,[[[prepnp(za,acc)]]]).
slowprzym(umilkły,[[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(uprzejmy,[[[comprepnp('pod adresem')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[cp(gdy)]],[[cp(jak)]],[[cp(że)]]]).
slowprzym(uschły,[[[xp(caus)]]]).
slowprzym(usługowy,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(usłużny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(ustały,[[[xp(temp)]]]).
slowprzym(usuwalny,[[[comprepnp('za pomocą')],[xp(abl)]],[[np(inst)],[xp(abl)]],[[prepnp(dla,gen)],[xp(abl)]],[[prepnp(przez,acc)],[xp(abl)]],[[prepnp(w,loc)],[xp(abl)]],[[xp(abl)],[xp(mod)]]]).
slowprzym(uwięzły,[[[xp(locat)]]]).
slowprzym(użyteczny,[[[comprepnp('na gruncie')]],[[comprepnp('pod kątem')]],[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(wart,[[[np(acc)],[prepnp(dla,gen)],[xp(locat)],[xp(temp)]],[[np(gen),ncp(gen,że),ncp(gen,żeby)]]]).
slowprzym(ważny,[[[comprepnp('ze względu na')]],[[prepnp(dla,gen),prepnp(przy,loc),prepnp(w,loc)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(u,gen)]],[[xp(caus)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(int),cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(wątpliwy,[[[comprepnp('od strony')]],[[prepnp('co do',gen)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(wdzięczny,[[[np(dat)],[prepnp(za,acc),cp(że),prepncp(za,acc,int),prepncp(za,acc,że)]],[[prepnp(do,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)],[prepnp(za,acc)]],[[prepnp(względem,gen)]]]).
slowprzym(wezbrany,[[[xp(caus)],[xp(locat)]]]).
slowprzym(wiadomy,[[[np(dat)]],[[prepnp(dla,gen)]],[[np(dat)],[cp(int)]],[[np(dat)],[cp(jakoby)]],[[np(dat)],[cp(że)]],[[np(dat)],[cp(żeby2)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(widoczny,[[[prepnp(dla,gen)]],[[xp(abl)]],[[xp(locat)]],[[xp(temp)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(widzialny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(abl)]],[[xp(instr)]],[[xp(locat)]]]).
slowprzym(wielkoduszny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(wierny,[[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,int),ncp(dat,że),ncp(dat,żeby)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(winny,[[[cp(że)]],[[np(acc)],[np(dat)],[comprepnp('z tytułu')]],[[np(acc)],[np(dat)],[prepnp(za,acc),prepncp(za,acc,że)]],[[np(dat),ncp(dat,int),ncp(dat,że),ncp(dat,żeby)]],[[np(gen),ncp(gen,int),ncp(gen,że),ncp(gen,żeby)]]]).
slowprzym(władny,[[[cp(żeby)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc)]]]).
slowprzym(właściwy,[[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[cp(żeby)]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc)]],[[prepnp(przy,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[xp(mod)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(włączalny,[[[prepnp(na,acc)]],[[prepnp(przez,acc)]],[[prepnp(z,gen)]],[[xp(adl)]],[[xp(instr)],[xp(mod)]],[[xp(locat)]]]).
slowprzym(wolny,[[[prepnp(od,gen),prepncp(od,gen,że),prepncp(od,gen,żeby)]]]).
slowprzym(wpatrzony,[[[prepnp(w,acc),prepncp(w,acc,jak)]]]).
slowprzym(wprawny,[[[prepnp(do,gen)]],[[prepnp(w,acc)]],[[prepnp(w,loc)]]]).
slowprzym(wrażliwy,[[[comprepnp('pod względem')]],[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(wrogi,[[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,int),ncp(dat,żeby)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(ku,dat)]],[[prepnp(przeciw,dat)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(wrosły,[[[np(inst)],[xp(adl)]],[[np(inst)],[xp(locat)]]]).
slowprzym(wsiąkły,[[[np(inst)],[xp(adl)]]]).
slowprzym(wskazany,[[[comprepnp('pod względem')]],[[prepnp(w,loc)],[comprepnp('ze względu na')]],[[prepnp(w,loc)],[xp(caus)]],[[prepnp(wobec,gen)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(wspaniałomyślny,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(wspaniały,[[[comprepnp('pod względem')]],[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]]]).
slowprzym(wspólny,[[[np(dat)]],[[prepnp(dla,gen)]]]).
slowprzym(współczesny,[[[np(dat)]],[[prepnp(dla,gen)]]]).
slowprzym(współmierny,[[[comprepnp('w stosunku do')]],[[prepnp(do,gen),prepncp(do,gen,int)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,inst),prepncp(z,gen,int)]]]).
slowprzym(współodpowiedzialny,[[[comprepnp('w stosunku do')]],[[np(dat),ncp(dat,że)]],[[np(gen),ncp(gen,że)]],[[prepnp(przed,inst)],[prepnp(przez,acc),prepncp(przez,acc,że)],[prepnp(za,acc),prepncp(za,acc,int),prepncp(za,acc,że)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(za,acc)],[advp(misc)]]]).
slowprzym(wstrętny,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(wstrzemięźliwy,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp(od,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(wszczepialny,[[[xp(adl)]]]).
slowprzym(wściekły,[[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepnp(na,acc)],[comprepnp('z powodu')]],[[prepnp(na,acc)],[cp(że)]],[[prepnp(na,acc)],[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że)]],[[prepnp(na,acc)],[prepnp(za,acc),prepncp(za,acc,int),prepncp(za,acc,że)]]]).
slowprzym(wybaczalny,[[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(przy,loc)]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[xp(mod)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(wybieralny,[[[np(inst)]],[[prepnp(do,gen)]],[[prepnp(na,acc)],[prepnp(przez,acc)],[prepnp(spośród,gen)],[prepnp(w,loc)],[xp(dur)],[xp(mod)]]]).
slowprzym(wyblakły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(wychudły,[[[xp(caus)]]]).
slowprzym(wyciekły,[[[xp(abl)],[xp(adl)],[xp(perl)]]]).
slowprzym(wyczerpywalny,[[[np(inst)]]]).
slowprzym(wyczuwalny,[[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(abl)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(wydolny,[[[comprepnp('pod względem')]],[[prepnp(dla,gen)]],[[xp(mod)]]]).
slowprzym(wygasły,[[[comprepnp('na podstawie')]],[[prepnp(na,loc)]],[[xp(abl)]],[[xp(caus)]],[[xp(locat)],[xp(temp)]]]).
slowprzym(wygłodniały,[[[advp(misc)]],[[np(gen)]]]).
slowprzym(wygodny,[[[np(dat)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(dla,gen)],[prepnp(przy,loc),prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(wykonalny,[[[comprepnp('na gruncie')]],[[comprepnp('na podstawie')]],[[comprepnp('pod względem')]],[[comprepnp('w ramach')]],[[comprepnp('w stosunku do')]],[[comprepnp('ze względu na')]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(wykrywalny,[[[prepnp(dla,gen)]],[[prepnp(na,loc)]],[[prepnp(przez,acc)]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[xp(abl)]],[[xp(dur)]],[[xp(instr)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(wyleczalny,[[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp(przez,acc)]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[prepnp(z,gen)]],[[xp(mod)]]]).
slowprzym(wyległy,[[[xp(abl)],[xp(adl)]]]).
slowprzym(wyłysiały,[[[prepnp(po,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(wymagalny,[[[prepnp(od,gen)]]]).
slowprzym(wymarły,[[[comprepnp('pod względem')]],[[prepnp(na,acc)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(wymarzły,[[[xp(caus)],[xp(locat)],[xp(mod)]]]).
slowprzym(wymienialny,[[[prepnp(między,inst)]],[[prepnp(na,acc)],[prepnp(po,loc)]],[[prepnp(z,inst)]]]).
slowprzym(wynikły,[[[comprepnp('na gruncie')]],[[comprepnp('na kanwie')]],[[comprepnp('na podstawie')]],[[comprepnp('na tle')]],[[comprepnp('za sprawą')]],[[prepnp(z,gen),prepncp(z,gen,że)]],[[xp(caus)]],[[xp(locat)],[xp(temp)]]]).
slowprzym(wyobrażalny,[[[prepnp(dla,gen)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(wypadły,[[[np(dat)],[xp(abl)],[xp(adl)]]]).
slowprzym(wypłacalny,[[[comprepnp('w stosunku do')]],[[comprepnp('w zakresie')]],[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(mod)]]]).
slowprzym(wypłowiały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(wypowiadalny,[[[prepnp(w,loc)]],[[xp(instr)]],[[xp(mod)]]]).
slowprzym(wyrażalny,[[[compar(jako)]],[[comprepnp('na gruncie')]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(mod)]]]).
slowprzym(wyrosły,[[[comprepnp('na gruncie')]],[[prepnp(na,loc)]],[[prepnp(w,loc)]],[[prepnp(z,gen)],[xp(mod)]],[[xp(abl)]],[[xp(locat)],[xp(mod)]]]).
slowprzym(wyrozumiały,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen),prepnp(wobec,gen),prepncp(wobec,gen,że)]],[[prepnp(do,gen)]],[[prepnp(przy,loc)]],[[prepnp(w,loc)]],[[prepnp(względem,gen)]]]).
slowprzym(wyróżnialny,[[[comprepnp('na podstawie')]],[[comprepnp('ze względu na')]],[[prepnp(z,gen)]],[[xp(locat)]]]).
slowprzym(wyspany,[[[xp(locat)],[xp(temp)]]]).
slowprzym(wystarczalny,[[[cp(żeby)]],[[np(dat)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[xp(mod)]]]).
slowprzym(wystygły,[[[prepnp(po,loc)]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(wytłumaczalny,[[[comprepnp('na gruncie')]],[[comprepnp('od strony')]],[[comprepnp('pod kątem')]],[[comprepnp('pod względem')]],[[comprepnp('w ramach')]],[[comprepnp('za pomocą')]],[[np(inst)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(według,gen)]],[[prepnp(w,loc)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(wytrwały,[[[prepnp(w,loc),prepncp(w,loc,że),prepncp(w,loc,żeby)]]]).
slowprzym(wytrzymały,[[[advp(misc)]],[[prepnp(na,acc)]],[[prepnp(przy,loc)]]]).
slowprzym(wywietrzały,[[[prepnp(z,gen)],[xp(caus)]]]).
slowprzym(wyżyty,[[[xp(mod)]]]).
slowprzym(wzrosły,[[[comprepnp('na gruncie')]],[[prepnp(o,acc)]],[[prepnp(z,gen)],[xp(locat)]]]).
slowprzym(zabawny,[[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc),prepncp(w,loc,int),prepncp(w,loc,że)]],[[prepnp(dla,gen)],[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]],[[prepnp(dla,gen)],[xp(caus)]],[[xp(mod)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(zachłanny,[[[np(gen),ncp(gen,żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]],[[prepnp(w,loc)]]]).
slowprzym(zachrypły,[[[xp(caus)]]]).
slowprzym(zacietrzewiony,[[[comprepnp('w stosunku do')]],[[cp(że)]],[[np(inst)]],[[prepnp(do,gen)]],[[prepnp(na,acc)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[prepnp(z,gen)]],[[xp(mod)]]]).
slowprzym(zaczadziały,[[[np(inst)]],[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]],[[xp(mod)]]]).
slowprzym(zadowolony,[[[cp(że)]],[[prepnp(z,gen),comprepnp('z powodu'),prepncp(z,gen,int),prepncp(z,gen,że)]]]).
slowprzym(zadumany,[[[comprepnp('na temat')]],[[np(inst),ncp(inst,że)]],[[prepnp(nad,inst),prepncp(nad,inst,int),prepncp(nad,inst,że)]],[[prepnp(o,loc)]]]).
slowprzym(zadurzony,[[[prepnp(w,loc)]]]).
slowprzym(zadyszany,[[[xp(caus)]]]).
slowprzym(zagrożony,[[[comprepnp('od strony')]],[[comprepnp('pod względem')]],[[comprepnp('ze strony')]],[[np(inst),ncp(inst,że)],[xp(locat)]],[[prepnp('co do',gen)]],[[prepnp(na,loc)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(z,gen)]],[[xp(abl)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(zaistniały,[[[compar(jako)],[xp(locat)],[xp(temp)]],[[comprepnp('na gruncie')],[xp(temp)]],[[comprepnp('za sprawą')],[xp(locat)],[xp(temp)]],[[prepnp(dla,gen)]],[[xp(caus)],[xp(locat)],[xp(temp)]]]).
slowprzym(zakłopotany,[[[cp(że)]],[[np(inst),ncp(inst,int),ncp(inst,że),ncp(inst,żeby)]]]).
slowprzym(zakochany,[[[prepnp(w,loc),prepncp(w,loc,int)]]]).
slowprzym(zakrzepły,[[[prepnp(w,acc)],[xp(caus)]],[[prepnp(w,loc)],[xp(locat)]]]).
slowprzym(zaległy,[[[prepnp(od,gen)]],[[prepnp(wobec,gen)]],[[prepnp(za,acc)]],[[xp(locat)]]]).
slowprzym(zależny,[[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen),prepncp(od,gen,int),prepncp(od,gen,że)],[prepnp(w,loc)]],[[prepnp(od,gen)],[xp(mod)]]]).
slowprzym(zalęgły,[[[xp(locat)]]]).
slowprzym(zamarły,[[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(zamarzły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zamężny,[[[prepnp(za,inst)]],[[prepnp(z,inst)]]]).
slowprzym(zamieszkały,[[[prepnp(przez,acc)]],[[xp(locat)]]]).
slowprzym(zamokły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zanikły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zanurzalny,[[[prepnp(w,loc)]]]).
slowprzym(zapadły,[[[comprepnp('w stosunku do')],[xp(locat)]],[[prepnp(na,acc)]],[[prepnp(w,acc)]],[[xp(adl)]]]).
slowprzym(zapamiętały,[[[prepnp(w,loc)]]]).
slowprzym(zapatrzony,[[[cp(że)],[xp(mod)]],[[np(inst)],[prepnp(w,acc),prepncp(w,loc,int),prepncp(w,loc,że)]],[[prepnp(na,acc),prepncp(na,loc,int)]],[[xp(adl)],[xp(perl)]]]).
slowprzym(zaperzony,[[[np(inst)]],[[prepnp(na,acc)],[cp(że)]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(zapłakany,[[[prepnp(nad,inst)]],[[prepnp(po,loc)]],[[prepnp(za,inst)]],[[xp(caus)]]]).
slowprzym(zaprzyjaźniony,[[[prepnp(z,inst)]]]).
slowprzym(zapuchły,[[[prepnp(od,gen)]],[[prepnp(z,gen)]]]).
slowprzym(zardzewiały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zarosły,[[[np(inst)],[xp(locat)],[xp(mod)]],[[prepnp(przez,acc)]],[[prepnp(w,acc)]]]).
slowprzym(zarośnięty,[[[np(inst)],[xp(locat)],[xp(mod)]],[[prepnp(przez,acc)]]]).
slowprzym(zasadny,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[comprepnp('w zakresie')]],[[comprepnp('ze względu na')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(wobec,gen)]],[[xp(mod)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(zasapany,[[[np(inst)]],[[prepnp(przy,loc)]],[[xp(caus)]]]).
slowprzym(zaschły,[[[prepnp(od,gen)]],[[xp(locat)]]]).
slowprzym(zasiedziały,[[[prepnp(nad,inst)]],[[xp(locat)]]]).
slowprzym(zasłabły,[[[xp(caus)]]]).
slowprzym(zasłuchany,[[[prepnp(w,acc),prepncp(w,acc,int)]],[[prepnp(w,loc)]]]).
slowprzym(zasłużony,[[[comprepnp('na rzecz')]],[[np(inst)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('na gruncie')]],[[prepnp(dla,gen)],[comprepnp('na polu')]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('w dziedzinie')]],[[prepnp(dla,gen)],[comprepnp('w zakresie')]],[[prepnp(dla,gen)],[prepnp(przy,loc)]],[[prepnp(dla,gen),prepnp(przy,loc),comprepnp('na polu')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[prepnp(za,acc)]],[[prepnp(dla,gen)],[xp(locat)]],[[prepnp(dla,gen)],[xp(mod)]],[[prepnp(dla,gen)],[xp(temp)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(zasobny,[[[prepnp(o,acc)]],[[prepnp(w,acc)]]]).
slowprzym(zastępowalny,[[[np(inst)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(locat)]]]).
slowprzym(zastygły,[[[prepnp(w,acc)],[xp(caus)]],[[prepnp(w,loc)],[xp(locat)]]]).
slowprzym(zatroskany,[[[cp(int)]],[[cp(że)]],[[cp(żeby)]],[[np(inst),ncp(inst,int),ncp(inst,że),ncp(inst,żeby)]],[[prepnp(na,acc)]],[[prepnp(nad,inst)]],[[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że),prepncp(o,acc,żeby)]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(zatrważający,[[[cp(gdy)]],[[cp(int)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(zauważalny,[[[np(inst)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[xp(abl)]],[[xp(locat)]]]).
slowprzym(zawisły,[[[prepnp(od,gen)],[comprepnp('pod względem')]],[[prepnp(od,gen),prepncp(od,gen,int),prepncp(od,gen,że)],[prepnp(w,loc)]],[[prepnp(od,gen)],[xp(mod)]],[[xp(locat)]]]).
slowprzym(zawzięty,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[cp(że)]],[[cp(żeby)]],[[prepnp(na,acc),prepncp(na,acc,żeby)]],[[prepnp(przeciw,dat)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(locat)]],[[xp(mod)]]]).
slowprzym(zazdrosny,[[[comprepnp('w stosunku do')]],[[cp(int)]],[[cp(że)]],[[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(zażenowany,[[[cp(że)]],[[np(inst),ncp(inst,int),ncp(inst,że)]]]).
slowprzym(zbaraniały,[[[comprepnp('na widok')]],[[xp(caus)]]]).
slowprzym(zbędny,[[[np(dat)],[cp(żeby)]],[[np(dat)],[prepnp(do,gen),prepncp(do,gen,żeby)]],[[np(dat)],[prepnp(w,loc)]],[[np(dat)],[xp(locat)]],[[np(dat)],[xp(temp)]],[[prepnp(dla,gen)]]]).
slowprzym(zbiedniały,[[[prepnp(o,acc)],[xp(caus)]]]).
slowprzym(zbiegły,[[[xp(abl)],[xp(adl)],[xp(perl)]]]).
slowprzym(zbielały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zbieżny,[[[prepnp('co do',gen)],[prepnp(z,inst)]],[[prepnp(do,gen)]],[[prepnp(ku,dat)]],[[prepnp(w,loc)],[prepnp(z,inst)]],[[prepnp(z,inst)],[comprepnp('pod względem')]],[[prepnp(z,inst)],[xp(mod)]]]).
slowprzym(zbladły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zblakły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zbrojny,[[[np(inst)]],[[prepnp(w,acc)]]]).
slowprzym(zbutwiały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zbywalny,[[[comprepnp('na rzecz')]],[[comprepnp('w zakresie')]],[[np(inst)]],[[prepnp(między,inst)]],[[prepnp(przez,acc)]],[[xp(locat)]]]).
slowprzym(zdatny,[[[cp(żeby)]],[[np(dat)],[prepnp(dla,gen),prepnp(do,gen),prepnp(na,acc),prepncp(do,gen,żeby),prepncp(na,acc,żeby)]],[[prepnp(ku,dat)]]]).
slowprzym(zdecydowany,[[[comprepnp('w kwestii')]],[[comprepnp('w sprawie')]],[[comprepnp('w stosunku do')]],[[comprepnp('w temacie')]],[[cp(int)]],[[cp(że)]],[[cp(żeby)]],[head,[infp(_G1712)]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,że),prepncp('co do',gen,żeby)]],[[prepnp(do,gen),prepncp(do,gen,int),prepncp(do,gen,żeby)]],[[prepnp(między,inst)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że),prepncp(na,acc,żeby)]],[[prepnp(w,loc)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(zdeterminowany,[[[cp(żeby)]],[head,[infp(_G1610)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc),prepncp(w,loc,żeby)]]]).
slowprzym(zdębiały,[[[comprepnp('na widok')]],[[cp(że)]],[[xp(caus)]]]).
slowprzym(zdobny,[[[np(inst)]],[[prepnp(w,acc)]]]).
slowprzym(zdolny,[[[cp(żeby)]],[head,[infp(_G1603)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(w,loc)]]]).
slowprzym(zdrętwiały,[[[np(inst)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(zdurniały,[[[comprepnp('na punkcie')]],[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(zdziczały,[[[comprepnp('pod względem')]],[[prepnp(w,loc)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(zdziecinniały,[[[xp(caus)]]]).
slowprzym(zeschły,[[[prepnp(na,acc)],[xp(caus)],[xp(locat)]]]).
slowprzym(zeschnięty,[[[prepnp(na,acc)],[xp(caus)],[xp(locat)]]]).
slowprzym(zestarzały,[[[prepnp(o,acc)],[xp(caus)],[xp(locat)]]]).
slowprzym(zesztywniały,[[[prepnp(na,acc)],[xp(caus)]],[[prepnp(w,loc)]]]).
slowprzym(zgasły,[[[xp(caus)]]]).
slowprzym(zgęstniały,[[[prepnp(w,acc)]],[[prepnp(w,loc)]],[[xp(caus)],[xp(locat)]]]).
slowprzym(zgłodniały,[[[np(gen),ncp(gen,żeby)]],[[np(inst)]],[[xp(caus)]]]).
slowprzym(zgłupiały,[[[np(inst)]],[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[prepnp(z,gen)]]]).
slowprzym(zgniły,[[[comprepnp('pod względem')]],[[xp(caus)],[xp(locat)]],[[xp(mod)]]]).
slowprzym(zgnuśniały,[[[prepnp(w,loc)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(zgodny,[[[comprepnp('w stosunku do')]],[[prepnp('co do',gen),prepncp('co do',gen,int),prepncp('co do',gen,że),prepncp('co do',gen,żeby)],[prepnp(z,inst)]],[[prepnp(przy,loc)],[prepnp(z,inst)]],[[prepnp(w,loc),prepncp(w,loc,int),prepncp(w,loc,że),prepncp(w,loc,żeby)],[prepnp(z,inst)]],[[prepnp(względem,gen)]],[[prepnp(z,inst)],[comprepnp('na temat')]],[[prepnp(z,inst)],[comprepnp('pod względem')]],[[prepnp(z,inst)],[comprepnp('w dziedzinie')]],[[prepnp(z,inst)],[comprepnp('w kwestii')]],[[prepnp(z,inst)],[comprepnp('w sprawie')]],[[prepnp(z,inst)],[comprepnp('w temacie')]],[[prepnp(z,inst)],[comprepnp('w zakresie')]],[[prepnp(z,inst)],[cp(int)]],[[prepnp(z,inst)],[cp(że)]],[[prepnp(z,inst)],[cp(żeby)]],[[prepnp(z,inst),prepncp(z,inst,int),prepncp(z,inst,że)]],[[prepnp(z,inst)],[xp(mod)]]]).
slowprzym(zgorzkniały,[[[xp(caus)],[xp(mod)]]]).
slowprzym(zgrabny,[[[prepnp(do,gen)]],[[prepnp(w,loc)]]]).
slowprzym(zgrubiały,[[[prepnp(w,loc)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(zgrzybiały,[[[prepnp(w,loc)]],[[xp(caus)],[xp(mod)]]]).
slowprzym(zidiociały,[[[xp(caus)]]]).
slowprzym(ziszczalny,[[[prepnp(dla,gen)]],[[xp(locat)]]]).
slowprzym(zleniwiały,[[[np(inst)]],[[xp(caus)]]]).
slowprzym(zlodowaciały,[[[np(inst)]],[[prepnp(na,acc)],[xp(caus)]],[[prepnp(w,loc)]]]).
slowprzym(złagodniały,[[[xp(caus)]]]).
slowprzym(zły,[[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepnp(dla,gen)]],[[prepnp(do,gen),prepncp(do,gen,żeby)]],[[prepnp(na,acc)],[comprepnp('z powodu')]],[[prepnp(na,acc)],[cp(że)]],[[prepnp(na,acc),prepncp(na,acc,że)]],[[prepnp(na,acc)],[prepnp(o,acc),prepncp(o,acc,int),prepncp(o,acc,że)]],[[prepnp(na,acc)],[prepnp(za,acc),prepncp(za,acc,int),prepncp(za,acc,że)]],[[prepnp(o,acc)],[prepnp(w,loc)]],[[xp(locat),xp(temp)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(zmalały,[[[np(inst)]],[[prepnp(do,gen)],[prepnp(o,acc)],[prepnp(z,gen)],[xp(caus)]]]).
slowprzym(zmarły,[[[comprepnp('na skutek')]],[[comprepnp('w wyniku')]],[[comprepnp('z powodu')]],[[prepnp(na,acc)]],[[prepnp(od,gen)]],[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[prepnp(wskutek,gen)]],[[prepnp(za,acc)]],[[prepnp(z,gen)]],[[xp(locat)],[xp(temp)]],[[xp(mod)]]]).
slowprzym(zmarniały,[[[prepnp(w,loc)]],[[xp(caus)],[xp(mod)]]]).
slowprzym(zmartwiały,[[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(zmarznięty,[[[prepnp(od,gen)]]]).
slowprzym(zmatowiały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zmądrzały,[[[xp(caus)]]]).
slowprzym(zmienny,[[[advp(misc)]],[[prepnp(w,loc)]]]).
slowprzym(zmiękły,[[[prepnp(w,loc)]],[[xp(caus)]]]).
slowprzym(zmizerniały,[[[np(inst)]],[[prepnp(z,gen)]]]).
slowprzym(zmokły,[[[np(inst)]],[[prepnp(od,gen)]]]).
slowprzym(znamienny,[[[np(inst),ncp(inst,że)]],[[prepnp(dla,gen)],[advp(misc)]],[[prepnp(dla,gen)],[comprepnp('pod wpływem')]],[[prepnp(u,gen)]],[[prepnp(w,loc)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(że)]]]).
slowprzym(znany,[[[compar(jako)],[xp(locat)]],[[comprepnp('od strony')],[xp(locat)]],[[comprepnp('za sprawą')],[xp(locat)]],[[comprepnp('ze strony')],[xp(locat)]],[[comprepnp('ze względu na')],[xp(locat)]],[[np(dat)],[compar(jako)]],[[np(dat)],[comprepnp('od strony')]],[[np(dat)],[comprepnp('pod względem')]],[[np(dat)],[comprepnp('za sprawą')]],[[np(dat)],[comprepnp('ze strony')]],[[np(dat)],[comprepnp('ze względu na')]],[[np(dat)],[prepnp(z,gen),prepncp(z,gen,int),prepncp(z,gen,że)]],[[np(dat)],[xp(abl)]],[[np(dat)],[xp(caus)]],[[prepnp(dla,gen)]],[[prepnp(przez,acc)]],[[prepnp(z,gen),prepncp(z,gen,int),prepncp(z,gen,że)],[xp(locat)]],[[xp(abl)],[xp(locat)]],[[xp(caus)],[xp(locat)]],[[np(dat)],[cp(że)]]]).
slowprzym(znieruchomiały,[[[prepnp(w,loc)]],[[xp(caus)]],[[xp(locat)]]]).
slowprzym(znikły,[[[xp(locat)],[xp(temp)]]]).
slowprzym(zniszczalny,[[[prepnp(przez,acc)]],[[prepnp(w,loc)]],[[xp(instr)]],[[xp(locat)]]]).
slowprzym(zobojętniały,[[[comprepnp('pod względem')]],[[comprepnp('w stosunku do')]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(na,acc),prepncp(na,acc,int),prepncp(na,acc,że)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]],[[xp(mod)]]]).
slowprzym(zręczny,[[[prepnp(do,gen)]],[[prepnp(w,loc)]]]).
slowprzym(zrogowaciały,[[[xp(caus)]]]).
slowprzym(zrosły,[[[np(inst)],[prepnp(w,acc)],[prepnp(z,inst)]]]).
slowprzym(zrośnięty,[[[np(inst)],[prepnp(w,acc)],[prepnp(z,inst)]]]).
slowprzym(zrozpaczony,[[[comprepnp('z powodu')]],[[cp(że)]],[[np(inst),ncp(inst,int),ncp(inst,że)]],[[prepnp(przez,acc),prepncp(przez,acc,że)]]]).
slowprzym(zrozumiały,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp('co do',gen)],[prepnp(dla,gen)]],[[prepnp(dla,gen)],[comprepnp('pod względem')]],[[prepnp(dla,gen)],[comprepnp('ze względu na')]],[[prepnp(dla,gen)],[prepnp(w,loc)]],[[prepnp(dla,gen)],[xp(caus)]],[[prepnp(przez,acc)]],[[prepnp(wobec,gen)]],[[xp(locat)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(żeby2)]]]).
slowprzym(zsiniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zszarzały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zubożały,[[[comprepnp('pod względem')]],[[prepnp(o,acc)],[xp(caus)]],[[prepnp(w,loc)]],[[xp(mod)]]]).
slowprzym(zwierzchni,[[[comprepnp('w stosunku do')]],[[prepnp(dla,gen)]],[[prepnp(nad,inst)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
slowprzym(zwilgotniały,[[[np(inst)]],[[prepnp(od,gen)]],[[xp(caus)]]]).
slowprzym(zwiotczały,[[[prepnp(po,loc)]],[[xp(caus)]]]).
slowprzym(zwyrodniały,[[[comprepnp('pod względem')]],[[prepnp(w,acc)]],[[prepnp(w,loc)]],[[xp(caus)]],[[xp(mod)]]]).
slowprzym(zziajany,[[[prepnp(po,loc)]],[[xp(caus)]]]).
slowprzym(zzieleniały,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zziębły,[[[prepnp(od,gen)]]]).
slowprzym(zziębnięty,[[[prepnp(od,gen)]]]).
slowprzym(zżółkły,[[[xp(caus)],[xp(locat)]]]).
slowprzym(zżyty,[[[prepnp(z,inst)]]]).
slowprzym(żałosny,[[[prepnp(w,loc),prepncp(w,loc,int),prepncp(w,loc,że)]],[[cp(gdy)]],[[cp(jak)]],[[cp(jeśli)]],[[cp(kiedy)]],[[cp(że)]],[[cp(żeby)]]]).
slowprzym(żądny,[[[cp(żeby)]],[[np(gen),ncp(gen,żeby)]]]).
slowprzym(żenujący,[[[prepnp(dla,gen)],[prepnp(w,loc),prepncp(w,loc,int)]],[[prepnp(wobec,gen)]],[[prepnp(dla,gen)],[cp(gdy)]],[[prepnp(dla,gen)],[cp(int)]],[[prepnp(dla,gen)],[cp(jak)]],[[prepnp(dla,gen)],[cp(jeśli)]],[[prepnp(dla,gen)],[cp(kiedy)]],[[prepnp(dla,gen)],[cp(że)]],[[prepnp(dla,gen)],[cp(żeby)]]]).
slowprzym(żonaty,[[[prepnp(z,inst)],[xp(dur)]]]).
slowprzym(życzliwy,[[[comprepnp('w stosunku do')]],[[np(dat)]],[[prepnp('co do',gen)]],[[prepnp(dla,gen)]],[[prepnp(do,gen)]],[[prepnp(wobec,gen)]],[[prepnp(względem,gen)]]]).
%%% Local Variables:
%%% coding: utf-8
%%% mode: prolog
%%% End:
