% -*- prolog -*-
realizuje(advp(pron), tak, pewny).
realizuje(advp(pron), jak, pewny).
realizuje(advp(pron), owak, pewny).
realizuje(advp(pron), nijak, pewny).
realizuje(advp(pron), siak, pewny).
realizuje(advp(mod), _, default).
realizuje(advp(misc), _, default).
% tymczasowa łata na compary:
realizuje(xp(mod), prepnp(jak,nom), pewny).    
realizuje(xp(mod), prepnp(niczym,nom), pewny).    
%realizuje(advp(pred), _, default).
%
realizuje(advp(abl), skąd, pewny).
realizuje(advp(abl), skądkolwiek, pewny).
realizuje(advp(abl), skądś, pewny).
realizuje(advp(abl), skądże, pewny).
realizuje(advp(abl), stamtąd, pewny).
realizuje(advp(abl), stąd, pewny).
realizuje(advp(abl), zewsząd, pewny).
realizuje(advp(abl), znikąd, pewny).
realizuje(advp(abl), skądinąd, archaiczny).
realizuje(advp(abl), skądciś, potoczny).
realizuje(advp(abl), skądsiś, potoczny).
realizuje(advp(adl), blisko, pewny).
realizuje(advp(adl), daleko, pewny).
realizuje(advp(adl), dokąd, pewny).
realizuje(advp(adl), dokądkolwiek, pewny).
realizuje(advp(adl), donikąd, pewny).
realizuje(advp(adl), gdzie, pewny).
realizuje(advp(adl), gdziekolwiek, pewny).
realizuje(advp(adl), gdzieś, pewny).
realizuje(advp(adl), gdzież, pewny).
realizuje(advp(adl), naprzód, pewny).
realizuje(advp(adl), niedaleko, pewny).
realizuje(advp(adl), tam, pewny).
realizuje(advp(adl), tamże, pewny).
realizuje(advp(adl), tu, pewny).
realizuje(advp(adl), tutaj, pewny).
realizuje(advp(adl), wstecz, pewny).
realizuje(advp(dur), długo, pewny).
realizuje(advp(dur), ile, pewny).
realizuje(advp(dur), ilekolwiek, pewny).
realizuje(advp(dur), jeszcze, pewny).
realizuje(advp(dur), już, pewny).
realizuje(advp(dur), krótko, pewny).
realizuje(advp(dur), nadal, pewny).
realizuje(advp(dur), trochę, pewny).
realizuje(advp(dur), tyle, pewny).
realizuje(advp(dur), wciąż, pewny).
realizuje(advp(dur), ciągle, wątpliwy).
realizuje(advp(locat), blisko, pewny).
realizuje(advp(locat), daleko, pewny).
realizuje(advp(locat), dokoła, pewny).
realizuje(advp(locat), dookoła, pewny).
realizuje(advp(locat), gdzie, pewny).
realizuje(advp(locat), gdziekolwiek, pewny).
realizuje(advp(locat), gdzieniegdzie, pewny).
realizuje(advp(locat), gdzieś, pewny).
realizuje(advp(locat), gdzież, pewny).
realizuje(advp(locat), naokoło, pewny).
realizuje(advp(locat), niedaleko, pewny).
realizuje(advp(locat), nieopodal, pewny).
realizuje(advp(locat), nigdzie, pewny).
realizuje(advp(locat), nisko, pewny).
realizuje(advp(locat), obok, pewny).
realizuje(advp(locat), opodal, pewny).
realizuje(advp(locat), ówdzie, pewny).
realizuje(advp(locat), poniżej, pewny).
realizuje(advp(locat), pośrodku, pewny).
realizuje(advp(locat), powyżej, pewny).
realizuje(advp(locat), tam, pewny).
realizuje(advp(locat), tamże, pewny).
realizuje(advp(locat), tu, pewny).
realizuje(advp(locat), tutaj, pewny).
realizuje(advp(locat), wewnątrz, pewny).
realizuje(advp(locat), wkoło, pewny).
realizuje(advp(locat), wokoło, pewny).
realizuje(advp(locat), wokół, pewny).
realizuje(advp(locat), wszędzie, pewny).
realizuje(advp(locat), wysoko, pewny).
realizuje(advp(locat), naokół, archaiczny).
realizuje(advp(locat), wszędy, archaiczny).
realizuje(advp(perl), dokoła, pewny).
realizuje(advp(perl), dookoła, pewny).
realizuje(advp(perl), którędy, pewny).
realizuje(advp(perl), którędykolwiek, pewny).
realizuje(advp(perl), którędyś, pewny).
realizuje(advp(perl), którędyż, pewny).
realizuje(advp(perl), naokoło, pewny).
realizuje(advp(perl), tamtędy, pewny).
realizuje(advp(perl), tędy, pewny).
realizuje(advp(perl), wokoło, pewny).
realizuje(advp(perl), wokół, pewny).
realizuje(advp(perl), owędy, wątpliwy).
realizuje(advp(perl), kędy, archaiczny).
realizuje(advp(perl), kędykolwiek, archaiczny).
realizuje(advp(temp), często, pewny).
realizuje(advp(temp), częstokroć, pewny).
realizuje(advp(temp), dawno, pewny).
realizuje(advp(temp), dotąd, pewny).
realizuje(advp(temp), dotychczas, pewny).
realizuje(advp(temp), dzisiaj, pewny).
realizuje(advp(temp), dziś, pewny).
realizuje(advp(temp), jutro, pewny).
realizuje(advp(temp), kiedy, pewny).
realizuje(advp(temp), kiedykolwiek, pewny).
realizuje(advp(temp), kiedyś, pewny).
realizuje(advp(temp), nieczęsto, pewny).
realizuje(advp(temp), niedawno, pewny).
realizuje(advp(temp), niedługo, pewny).
realizuje(advp(temp), niegdyś, pewny).
realizuje(advp(temp), niekiedy, pewny).
realizuje(advp(temp), nieraz, pewny).
realizuje(advp(temp), nieregularnie, pewny).
realizuje(advp(temp), nierzadko, pewny).
realizuje(advp(temp), obecnie, pewny).
realizuje(advp(temp), ówcześnie, pewny).
realizuje(advp(temp), podówczas, pewny).
realizuje(advp(temp), pojutrze, pewny).
realizuje(advp(temp), popojutrze, pewny).
realizuje(advp(temp), potem, pewny).
realizuje(advp(temp), późno, pewny).
realizuje(advp(temp), przedwczoraj, pewny).
realizuje(advp(temp), przenigdy, pewny).
realizuje(advp(temp), regularnie, pewny).
realizuje(advp(temp), rzadko, pewny).
realizuje(advp(temp), sporadycznie, pewny).
realizuje(advp(temp), teraz, pewny).
realizuje(advp(temp), wcześnie, pewny).
realizuje(advp(temp), wczoraj, pewny).
realizuje(advp(temp), wkrótce, pewny).
realizuje(advp(temp), wnet, pewny).
realizuje(advp(temp), wówczas, pewny).
realizuje(advp(temp), wtedy, pewny).
realizuje(advp(temp), wtenczas, pewny).
realizuje(advp(temp), zaraz, pewny).
realizuje(advp(temp), zawsze, pewny).
realizuje(advp(temp), drzewiej, archaiczny).
realizuje(advp(temp), latoś, archaiczny).
realizuje(advp(temp), naonczas, archaiczny).
realizuje(advp(temp), naówczas, archaiczny).
realizuje(advp(temp), natenczas, archaiczny).
realizuje(advp(temp), nikędy, archaiczny).
realizuje(advp(temp), ninie, archaiczny).
realizuje(advp(temp), onegdaj, archaiczny).
realizuje(advp(temp), ongi, archaiczny).
realizuje(advp(temp), ongiś, archaiczny).
realizuje(advp(temp), wczas, archaiczny).
realizuje(advp(temp), wonczas, archaiczny).
realizuje(comprepnp('bez względu na'), lex(prepnp(bez, gen), [sg, wzgląd], atr(obl, 1, [[prepnp(na, acc), prepncp(na, acc, int), prepncp(na, acc, że)]])), pewny).
realizuje(comprepnp('do roli'), lex(prepnp(w, loc), [sg, rola], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('do spółki z'), lex(prepnp(do, gen), [sg, spółka], atr(obl, 1, [[prepnp(z, inst)]])), pewny).
realizuje(comprepnp('do spraw'), lex(prepnp(do, gen), [pl, sprawa], atr(obl, 1, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('łącznie z'), lex(advp(misc), [pos, łącznie], atr(obl, 1, [[prepnp(z, inst), prepncp(z, inst, int), prepncp(z, inst, że), prepncp(z, inst, żeby)]])), pewny).
realizuje(comprepnp('na bazie'), lex(prepnp(na, loc), [sg, baza], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [lex(adjp(agr), [agr, [agr], pos, [inny, taki, ten]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na czas'), lex(prepnp(na, acc), [sg, czas], atr(obl, 1, [[lex(adjp(agr), [agr, [agr], pos, ten], natr)]])), pewny).
realizuje(comprepnp('na czas'), lex(prepnp(na, acc), [sg, czas], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [cały, sam]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na drodze'), lex(prepnp(na, loc), [sg, droga], atr(obl, 1, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [inny, ten]^ (xor)], atr(fac, n, [[adjp(agr)]]))]])), pewny).
realizuje(comprepnp('na gruncie'), lex(prepnp(na, loc), [sg, grunt], atr(obl, n, [[np(gen), ncp(gen, że)]])), pewny).
realizuje(comprepnp('na kanwie'), lex(prepnp(na, loc), [sg, kanwa], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na koniec'), lex(prepnp(na, acc), [sg, koniec], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na końcu'), lex(prepnp(na, loc), [sg, koniec], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na korzyść'), lex(prepnp(na, acc), [sg, [korzyść, niekorzyść]^orcoor], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [possp]])), pewny).
realizuje(comprepnp('na kształt'), lex(prepnp(na, acc), [sg, kształt], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('na łamach'), lex(prepnp(na, loc), [pl, łam], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('na miarę'), lex(prepnp(na, acc), [sg, miara], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('na modłę'), lex(prepnp(na, acc), [sg, modła], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na myśl'), lex(prepnp(na, acc), [sg, myśl], atr(obl, n, [[adjp(agr)], [prepnp(na, loc), cp(int), cp(rel), cp(że), cp(żeby), prepncp(na, loc, int), prepncp(na, loc, że)]])), pewny).
realizuje(comprepnp('na niekorzyść'), lex(prepnp(na, acc), [sg, [korzyść, niekorzyść]^orcoor], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [possp]])), pewny).
realizuje(comprepnp('na niwie'), lex(prepnp(na, loc), [sg, niwa], atr(obl, 1, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na okoliczność'), lex(prepnp(na, acc), [sg, okoliczność], atr(obl, 1, [[np(gen), cp(int), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na okres'), lex(prepnp(na, acc), [sg, okres], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, cały], natr)]])), pewny).
realizuje(comprepnp('na początek'), lex(prepnp(na, acc), [sg, początek], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na początku'), lex(prepnp(na, loc), [sg, początek], atr(obl, 1, [[np(gen)], [ncp(gen, rel)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki, zupełny]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na poczet'), lex(prepnp(na, acc), [sg, poczet], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [lex(adjp(agr), [agr, [agr], pos, [swój, ten]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na podobieństwo'), lex(prepnp(na, acc), [sg, podobieństwo], atr(obl, 1, [[possp], [ncp(gen, int)]])), pewny).
realizuje(comprepnp('na podstawie'), lex(prepnp(na, loc), [sg, podstawa], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na polu'), lex(prepnp(na, loc), [sg, pole], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na poziomie'), lex(prepnp(na, loc), [sg, poziom], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na progu'), lex(prepnp(na, loc), [sg, próg], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('na przeciąg'), lex(prepnp(na, acc), [sg, przeciąg], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('na przekór'), lex(prepnp(na, acc), [sg, przekór], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)]])), pewny).
realizuje(comprepnp('na przełomie'), lex(prepnp(na, loc), [sg, przełom], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na przodzie'), lex(prepnp(na, loc), [sg, przód], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na przód'), lex(prepnp(na, acc), [sg, przód], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na punkcie'), lex(prepnp(na, loc), [sg, punkt], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [lex(adjp(agr), [agr, [agr], pos, [czyj, czyjkolwiek, czyjś, jakikolwiek, jakiś, mój, nasz, niczyj, pański, swój, ten, twój, wasz, własny]^ (xor)], atr(fac, 1, [[adjp(agr)], [advp(misc)]]))]])), pewny).
realizuje(comprepnp('na równi z'), lex(prepnp(na, loc), [sg, rówień], atr(obl, 1, [[prepnp(z, inst), prepncp(z, inst, int), prepncp(z, inst, że)]])), pewny).
realizuje(comprepnp('na rzecz'), lex(prepnp(na, acc), [sg, rzecz], atr(obl, 1, [[np(gen), ncp(gen, że), ncp(gen, żeby)], [lex(adjp(agr), [agr, [agr], pos, [czyjś, mój, nasz, swój, twój, wasz, własny]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na skalę'), lex(prepnp(na, acc), [sg, skala], atr(obl, n, [[np(gen), ncp(gen, że)]])), pewny).
realizuje(comprepnp('na skutek'), lex(prepnp(na, acc), [sg, skutek], atr(obl, 1, [[np(gen), ncp(gen, że)]])), pewny).
realizuje(comprepnp('na sposób'), lex(prepnp(na, acc), [sg, sposób], atr(obl, 1, [[possp]])), pewny).
realizuje(comprepnp('na sposób'), lex(prepnp(na, acc), [_, sposób], atr(obl, 1, [[adjp(agr)]])), pewny).
realizuje(comprepnp('na spółkę z'), lex(prepnp(na, acc), [sg, spółka], atr(obl, 1, [[prepnp(z, inst)]])), pewny).
realizuje(comprepnp('na stanowisku'), lex(prepnp(na, loc), [sg, stanowisko], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na szkodę'), lex(prepnp(na, acc), [sg, szkoda], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('na środek'), lex(prepnp(na, acc), [sg, środek], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na środku'), lex(prepnp(na, loc), [sg, środek], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na temat'), lex(prepnp(na, acc), [_, temat], atr(fac, n, [[np(gen), cp(int), cp(że), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na tle'), lex(prepnp(na, loc), [sg, tło], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na tyle'), lex(prepnp(na, loc), [sg, tył], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na tył'), lex(prepnp(na, acc), [sg, tył], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na widok'), lex(prepnp(na, acc), [sg, widok], atr(obl, 1, [[np(gen), cp(int), cp(że), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('na wniosek'), lex(prepnp(na, acc), [sg, wniosek], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('na wstępie'), lex(prepnp(na, loc), [sg, wstęp], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na wypadek'), lex(prepnp(na, acc), [sg, wypadek], atr(obl, 1, [[np(gen), ncp(gen, gdy), ncp(gen, rel), ncp(gen, że)], [lex(adjp(agr), [agr, [agr], pos, [każdy, taki, ten, wszelki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na wzór'), lex(prepnp(na, acc), [sg, wzór], atr(obl, 1, [[possp]])), pewny).
realizuje(comprepnp('na zakończenie'), lex(prepnp(na, acc), [sg, zakończenie], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('na zasadzie'), lex(prepnp(na, loc), [sg, zasada], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('niezależnie od'), lex(advp(misc), [pos, niezależnie], atr(obl, 1, [[prepnp(od, gen), prepncp(od, gen, int), prepncp(od, gen, że)]])), pewny).
realizuje(comprepnp('niezgodnie z'), lex(advp(misc), [pos, niezgodnie], atr(obl, 1, [[prepnp(z, inst), prepncp(z, inst, int)]])), pewny).
realizuje(comprepnp('od strony'), lex(prepnp(od, gen), [sg, strona], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('od tyłu'), lex(prepnp(od, gen), [sg, tył], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('pod adresem'), lex(prepnp(pod, inst), [sg, adres], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [lex(adjp(agr), [agr, [agr], pos, [czyj, czyjkolwiek, czyjś, dobry, mój, nasz, niczyj, niewłaściwy, pański, swój, twój, wasz, własny, właściwy, zły]^ (xor)], atr(fac, 1, [[adjp(agr)], [advp(misc)]]))]])), pewny).
realizuje(comprepnp('pod ciężarem'), lex(prepnp(pod, inst), [sg, ciężar], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod dowództwem'), lex(prepnp(pod, inst), [sg, dowództwo], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod egidą'), lex(prepnp(pod, inst), [sg, egida], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('pod kątem'), lex(prepnp(pod, inst), [sg, kąt], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod kierunkiem'), lex(prepnp(pod, inst), [sg, kierunek], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('pod koniec'), lex(prepnp(pod, acc), [sg, koniec], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('pod maską'), lex(prepnp(pod, inst), [sg, maska], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod okiem'), lex(prepnp(pod, inst), [sg, oko], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('pod osłoną'), lex(prepnp(pod, inst), [sg, osłona], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('pod płaszczykiem'), lex(prepnp(pod, inst), [sg, płaszczyk], atr(obl, n, [[np(gen), cp(że), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod postacią'), lex(prepnp(pod, inst), [sg, postać], atr(obl, n, [[np(gen), ncp(gen, int)]])), pewny).
realizuje(comprepnp('pod pozorem'), lex(prepnp(pod, inst), [sg, pozór], atr(obl, n, [[np(gen), cp(że), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod pretekstem'), lex(prepnp(pod, inst), [sg, pretekst], atr(obl, n, [[np(gen), cp(że), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod przywództwem'), lex(prepnp(pod, inst), [sg, przywództwo], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod rygorem'), lex(prepnp(pod, inst), [sg, rygor], atr(obl, n, [[np(gen), cp(że), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod warunkiem'), lex(prepnp(pod, inst), [sg, warunek], atr(obl, n, [[adjp(agr)], [cp(że)]])), pewny).
realizuje(comprepnp('pod warunkiem'), lex(prepnp(pod, inst), [sg, warunek], atr(obl, n, [[np(gen), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod warunkiem'), lex(prepnp(pod, inst), [_, warunek], atr(obl, n, [[adjp(agr)], [or]])), pewny).
realizuje(comprepnp('pod wodzą'), lex(prepnp(pod, inst), [sg, wodza], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod wpływem'), lex(prepnp(pod, inst), [_, wpływ], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('pod względem'), lex(prepnp(pod, inst), [_, wzgląd], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('po bokach'), lex(prepnp(po, loc), [pl, bok], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('po bokach'), lex(prepnump(po, loc), [[cztery, dwa, oba, obydwa]^ (xor), bok], atr(fac, n, [[np(gen)]])), pewny).
realizuje(comprepnp('po stronie'), lex(prepnp(po, loc), [_, strona], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('po stronie'), lex(prepnump(po, loc), [[dwa, oba, obydwa]^ (xor), strona], atr(fac, n, [[np(gen)]])), pewny).
realizuje(comprepnp('przy okazji'), lex(prepnp(przy, loc), [sg, okazja], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('przy pomocy'), lex(prepnp(przy, loc), [sg, pomoc], atr(obl, n, [[np(gen), ncp(gen, rel)], [adjp(agr)]])), pewny).
realizuje(comprepnp('przy użyciu'), lex(prepnp(przy, loc), [sg, użycie], atr(obl, n, [[np(gen), ncp(gen, rel)], [adjp(agr)]])), pewny).
realizuje(comprepnp('razem z'), lex(advp(misc), [pos, razem], atr(obl, 1, [[prepnp(z, inst)]])), pewny).
realizuje(comprepnp('u boku'), lex(prepnp(u, gen), [sg, bok], atr(obl, n, [[possp], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('u dołu'), lex(prepnp(u, gen), [sg, dół], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('u góry'), lex(prepnp(u, gen), [sg, góra], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('u podnóża'), lex(prepnp(u, gen), [sg, podnóże], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('u podstaw'), lex(prepnp(u, gen), [_, podstawa], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('u progu'), lex(prepnp(u, gen), [sg, próg], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('u schyłku'), lex(prepnp(u, gen), [sg, schyłek], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('u stóp'), lex(prepnp(u, gen), [pl, stopa], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('wspólnie z'), lex(advp(misc), [pos, wspólnie], atr(obl, 1, [[prepnp(z, inst)]])), pewny).
realizuje(comprepnp('w celu'), lex(prepnp(w, loc), [sg, cel], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w charakterze'), lex(prepnp(w, loc), [sg, charakter], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w ciągu'), lex(prepnp(w, loc), [sg, ciąg], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], com, daleki], natr)]])), pewny).
realizuje(comprepnp('w czasie'), lex(prepnp(w, loc), [sg, czas], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w dole'), lex(prepnp(w, loc), [sg, dół], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('w dół'), lex(prepnp(w, acc), [sg, dół], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('w drodze'), lex(prepnp(w, loc), [sg, droga], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('w duchu'), lex(prepnp(w, loc), [sg, duch], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w dziedzinie'), lex(prepnp(w, loc), [sg, dziedzina], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w efekcie'), lex(prepnp(w, loc), [sg, efekt], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w głąb'), lex(prepnp(w, acc), [sg, głąb], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w głębi'), lex(prepnp(w, loc), [sg, głąb], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w górę'), lex(prepnp(w, acc), [sg, góra], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('w górze'), lex(prepnp(w, acc), [sg, góra], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('w imieniu'), lex(prepnp(w, loc), [sg, imię], atr(obl, n, [[possp]])), pewny).
realizuje(comprepnp('w imię'), lex(prepnp(w, acc), [sg, imię], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)]])), pewny).
realizuje(comprepnp('w intencji'), lex(prepnp(w, loc), [sg, intencja], atr(obl, n, [[np(gen), possp, ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w kierunku'), lex(prepnp(w, loc), [pl, kierunek], atr(obl, n, [[adjp(agr)]])), pewny).
realizuje(comprepnp('w kierunku'), lex(prepnp(w, loc), [sg, kierunek], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w końcu'), lex(prepnp(w, loc), [sg, koniec], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w kwestii'), lex(prepnp(w, loc), [_, kwestia], atr(obl, n, [[adjp(agr)], [cp(int), cp(że)]])), pewny).
realizuje(comprepnp('w kwestii'), lex(prepnp(w, loc), [_, kwestia], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w miarę'), lex(prepnp(w, acc), [sg, miara], atr(obl, 1, [[np(gen), ncp(gen, int)]])), pewny).
realizuje(comprepnp('w miejsce'), lex(prepnp(w, acc), [sg, miejsce], atr(obl, 1, [[np(gen), ncp(gen, int)]])), pewny).
realizuje(comprepnp('w myśl'), lex(prepnp(w, acc), [sg, myśl], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)]])), pewny).
realizuje(comprepnp('w następstwie'), lex(prepnp(w, loc), [sg, następstwo], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w nawiązaniu do'), lex(prepnp(w, loc), [sg, nawiązanie], atr(obl, 1, [[prepnp(do, gen), prepncp(do, gen, int), prepncp(do, gen, że)]])), pewny).
realizuje(comprepnp('w obliczu'), lex(prepnp(w, loc), [sg, oblicze], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w obrębie'), lex(prepnp(w, loc), [sg, obręb], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w obszarze'), lex(prepnp(w, loc), [sg, obszar], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w oderwaniu od'), lex(prepnp(w, loc), [sg, oderwanie], atr(obl, 1, [[prepnp(od, gen), prepncp(od, gen, int), prepncp(od, gen, że)]])), pewny).
realizuje(comprepnp('w odniesieniu do'), lex(prepnp(w, loc), [sg, odniesienie], atr(obl, 1, [[prepnp(do, gen), prepncp(do, gen, int), prepncp(do, gen, że)]])), pewny).
realizuje(comprepnp('w odróżnieniu od'), lex(prepnp(w, loc), [sg, odróżnienie], atr(obl, 1, [[prepnp(od, gen), prepncp(od, gen, int), prepncp(od, gen, że)]])), pewny).
realizuje(comprepnp('w okolicach'), lex(prepnp(w, loc), [_, okolica], atr(obl, n, [[np(gen)]])), pewny).
realizuje(comprepnp('w okresie'), lex(prepnp(w, loc), [sg, okres], ratr), pewny).
realizuje(comprepnp('w oparciu o'), lex(prepnp(w, loc), [sg, oparcie], atr(obl, 1, [[prepnp(o, acc), prepncp(o, acc, int), prepncp(o, acc, że)]])), pewny).
realizuje(comprepnp('w opozycji do'), lex(prepnp(w, loc), [sg, opozycja], atr(obl, n, [[adjp(agr)], [prepnp(do, gen), prepncp(do, gen, int), prepncp(do, gen, że)]])), pewny).
realizuje(comprepnp('w pobliże'), lex(prepnp(w, acc), [sg, pobliże], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w pobliżu'), lex(prepnp(w, loc), [sg, pobliże], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w porównaniu do'), lex(prepnp(w, loc), [sg, porównanie], atr(obl, 1, [[prepnp(do, gen), prepncp(do, gen, int), prepncp(do, gen, że)]])), wątpliwy).
realizuje(comprepnp('w porównaniu z'), lex(prepnp(w, loc), [sg, porównanie], atr(obl, 1, [[prepnp(z, inst), prepncp(z, inst, int), prepncp(z, inst, że)]])), pewny).
realizuje(comprepnp('w postaci'), lex(prepnp(w, loc), [sg, postać], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w przeciągu'), lex(prepnp(w, loc), [sg, przeciąg], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w przeciwieństwie do'), lex(prepnp(w, loc), [sg, przeciwieństwo], atr(obl, n, [[adjp(agr)], [prepnp(do, gen), prepncp(do, gen, int), prepncp(do, gen, że)]])), pewny).
realizuje(comprepnp('w przeddzień'), lex(prepnp(w, acc), [sg, przeddzień], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('w przededniu'), lex(prepnp(w, loc), [sg, przeddzień], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('w przypadku'), lex(prepnp(w, loc), [sg, przypadek], atr(obl, 1, [[np(gen), cp(gdy), cp(int), ncp(gen, rel)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w przypadku'), lex(prepnp(w, loc), [sg, przypadek], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, każdy], natr)]])), pewny).
realizuje(comprepnp('w ramach'), lex(prepnp(w, loc), [pl, rama], atr(obl, n, [[np(gen), ncp(gen, rel), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w razie'), lex(prepnp(w, loc), [pl, raz], atr(obl, 1, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [każdy, przeciwny, taki, żaden]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('w rezultacie'), lex(prepnp(w, loc), [sg, rezultat], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w rodzaju'), lex(prepnp(w, loc), [sg, rodzaj], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w roli'), lex(prepnp(w, loc), [sg, rola], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w sferze'), lex(prepnp(w, loc), [sg, sfera], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w sprawie'), lex(prepnp(w, loc), [_, sprawa], atr(obl, n, [[adjp(agr)], [cp(int), cp(że)]])), pewny).
realizuje(comprepnp('w sprawie'), lex(prepnp(w, loc), [_, sprawa], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w stosunku do'), lex(prepnp(w, loc), [sg, stosunek], atr(obl, 1, [[prepnp(do, gen), prepncp(do, gen, int), prepncp(do, gen, że), prepncp(do, gen, żeby)]])), pewny).
realizuje(comprepnp('w stronę'), lex(prepnp(w, acc), [sg, strona], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w ślad za'), lex(prepnp(w, acc), [sg, ślad], atr(obl, 1, [[prepnp(za, inst), prepncp(za, inst, int), prepncp(za, inst, że)]])), pewny).
realizuje(comprepnp('w środku'), lex(prepnp(w, loc), [sg, środek], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('w świetle'), lex(prepnp(w, loc), [sg, światło], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)]])), pewny).
realizuje(comprepnp('w temacie'), lex(prepnp(w, loc), [sg, temat], atr(obl, n, [[adjp(agr)], [cp(że)]])), pewny).
realizuje(comprepnp('w temacie'), lex(prepnp(w, loc), [sg, temat], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w toku'), lex(prepnp(w, loc), [sg, tok], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w towarzystwie'), lex(prepnp(w, loc), [sg, towarzystwo], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w trakcie'), lex(prepnp(w, loc), [sg, trakt], atr(obl, n, [[np(gen), ncp(gen, int)]])), pewny).
realizuje(comprepnp('w wydaniu'), lex(prepnp(w, loc), [sg, wydanie], atr(obl, n, [[adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('w wyniku'), lex(prepnp(w, loc), [sg, wynik], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w wypadku'), lex(prepnp(w, loc), [sg, wypadek], atr(obl, 1, [[np(gen), cp(gdy), cp(int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w wysokości'), lex(prepnp(w, loc), [sg, wysokość], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w zakresie'), lex(prepnp(w, loc), [sg, zakres], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('w zależności od'), lex(prepnp(w, loc), [sg, zależność], atr(obl, 1, [[prepnp(od, gen), prepncp(od, gen, int)]])), pewny).
realizuje(comprepnp('w zamian za'), lex(prepnp(w, acc), [sg, zamian], atr(obl, 1, [[prepnp(za, acc), prepncp(za, acc, int), prepncp(za, acc, że), prepncp(za, acc, żeby)]])), pewny).
realizuje(comprepnp('w zastępstwie'), lex(prepnp(w, loc), [sg, zastępstwo], atr(obl, 1, [[np(gen)]])), pewny).
realizuje(comprepnp('w związku z'), lex(prepnp(w, loc), [sg, związek], atr(obl, 1, [[prepnp(z, inst), prepncp(z, inst, int), prepncp(z, inst, że)]])), pewny).
realizuje(comprepnp('zależnie od'), lex(advp(misc), [pos, zależnie], atr(obl, 1, [[prepnp(od, gen), prepncp(od, gen, int)]])), pewny).
realizuje(comprepnp('za cenę'), lex(prepnp(za, acc), [sg, cena], atr(obl, 1, [[np(gen), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('za pomocą'), lex(prepnp(za, inst), [sg, pomoc], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('za pośrednictwem'), lex(prepnp(za, inst), [sg, pośrednictwo], atr(obl, n, [[np(gen), possp, ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('za przyczyną'), lex(prepnp(za, inst), [sg, przyczyna], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('za sprawą'), lex(prepnp(za, inst), [sg, sprawa], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('za wyjątkiem'), lex(prepnp(za, inst), [sg, wyjątek], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('ze strony'), lex(prepnp(z, gen), [sg, strona], atr(obl, n, [[possp, ncp(gen, rel)]])), pewny).
realizuje(comprepnp('ze względu na'), lex(prepnp(z, gen), [sg, wzgląd], atr(obl, 1, [[prepnp(na, acc), prepncp(na, acc, int), prepncp(na, acc, że), prepncp(na, acc, żeby)]])), pewny).
realizuje(comprepnp('ze względu na'), lex(prepnp(z, gen), [_, wzgląd], atr(obl, n, [[adjp(agr)], [cp(że)], [lex(adjp(agr), [agr, [agr], pos, [taki, ten, tenże]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('zgodnie z'), lex(advp(misc), [pos, zgodnie], atr(obl, 1, [[prepnp(z, inst), prepncp(z, inst, int), prepncp(z, inst, że)]])), pewny).
realizuje(comprepnp('z dziedziny'), lex(prepnp(z, gen), [_, dziedzina], atr(obl, n, [[np(gen)], [adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('z głębi'), lex(prepnp(z, gen), [_, głąb], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(comprepnp('z końcem'), lex(prepnp(z, inst), [sg, koniec], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('z okazji'), lex(prepnp(z, gen), [_, okazja], atr(obl, n, [[adjp(agr)], [cp(że)]])), pewny).
realizuje(comprepnp('z okazji'), lex(prepnp(z, gen), [_, okazja], atr(obl, n, [[np(gen), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('z perspektywy'), lex(prepnp(z, gen), [_, perspektywa], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)], [possp]])), pewny).
realizuje(comprepnp('z początkiem'), lex(prepnp(z, inst), [sg, początek], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('z pomocą'), lex(prepnp(z, inst), [sg, pomoc], atr(obl, 1, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('z powodu'), lex(prepnp(z, gen), [_, powód], atr(obl, n, [[np(gen), cp(int), cp(że), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('z przodu'), lex(prepnp(z, gen), [sg, przód], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('z przyczyny'), lex(prepnp(z, gen), [_, przyczyna], atr(obl, n, [[np(gen), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('z punktu widzenia'), lex(prepnp(z, gen), [sg, punkt], atr(obl, 1, [[adjp(agr)], [possp], [lex(np(gen), [sg, widzenie], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)]]))]])), pewny).
realizuje(comprepnp('z racji'), lex(prepnp(z, gen), [_, racja], atr(obl, n, [[adjp(agr)], [cp(że)]])), pewny).
realizuje(comprepnp('z racji'), lex(prepnp(z, gen), [sg, racja], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [lex(adjp(agr), [agr, [agr], pos, sam], natr)]])), pewny).
realizuje(comprepnp('z ramienia'), lex(prepnp(z, gen), [sg, ramię], atr(obl, n, [[possp], [lex(adjp(agr), [agr, [agr], pos, jaki], natr)]])), pewny).
realizuje(comprepnp('z tyłu'), lex(prepnp(z, gen), [sg, tył], atr(obl, n, [[np(gen)], [lex(adjp(agr), [agr, [agr], pos, [sam, samiuśki, samiuteńki, samiutki]^ (xor)], natr)]])), pewny).
realizuje(comprepnp('z tytułu'), lex(prepnp(z, gen), [sg, tytuł], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że)], [adjp(agr)]])), pewny).
realizuje(comprepnp('z uwagi na'), lex(prepnp(z, gen), [sg, uwaga], atr(obl, 1, [[prepnp(na, acc), prepncp(na, acc, int), prepncp(na, acc, że), prepncp(na, acc, żeby)]])), pewny).
realizuje(comprepnp('z wyjątkiem'), lex(prepnp(z, inst), [sg, wyjątek], atr(obl, n, [[np(gen), ncp(gen, int), ncp(gen, że), ncp(gen, żeby)], [adjp(agr)]])), pewny).
realizuje(comprepnp('z zakresu'), lex(prepnp(z, gen), [sg, zakres], atr(obl, n, [[np(gen), ncp(gen, int)], [adjp(agr)]])), pewny).
realizuje(distrp, prepnp(po, loc), pewny).
realizuje(distrp, prepnump(po, acc), pewny).
realizuje(xp(abl), advp(abl), pewny).
realizuje(xp(abl), comprepnp('od strony'), pewny).
realizuje(xp(abl), comprepnp('od tyłu'), pewny).
realizuje(xp(abl), cp(int), pewny).
realizuje(xp(abl), prepadjp(z, gen), pewny).
realizuje(xp(abl), prepnp(od, gen), pewny).
realizuje(xp(abl), prepnp(spod, gen), pewny).
realizuje(xp(abl), prepnp(spomiędzy, gen), pewny).
realizuje(xp(abl), prepnp(sponad, gen), pewny).
realizuje(xp(abl), prepnp(spopod, gen), pewny).
realizuje(xp(abl), prepnp(spośród, gen), pewny).
realizuje(xp(abl), prepnp(spoza, gen), pewny).
realizuje(xp(abl), prepnp(sprzed, gen), pewny).
realizuje(xp(abl), prepnp(z, gen), pewny).
realizuje(xp(abl), prepnp(znad, gen), pewny).
realizuje(xp(abl), prepnp(zza, gen), pewny).
realizuje(xp(abl), comprepnp('z głębi'), wątpliwy).
realizuje(xp(adl), advp(adl), pewny).
realizuje(xp(adl), comprepnp('na koniec'), pewny).
realizuje(xp(adl), comprepnp('na początek'), pewny).
realizuje(xp(adl), comprepnp('na przód'), pewny).
realizuje(xp(adl), comprepnp('na środek'), pewny).
realizuje(xp(adl), comprepnp('na tył'), pewny).
realizuje(xp(adl), comprepnp('w dół'), pewny).
realizuje(xp(adl), comprepnp('w górę'), pewny).
realizuje(xp(adl), comprepnp('w kierunku'), pewny).
realizuje(xp(adl), comprepnp('w pobliże'), pewny).
realizuje(xp(adl), comprepnp('w stronę'), pewny).
realizuje(xp(adl), lex(prepnp(z, inst), [sg, powrót], natr), pewny).
realizuje(xp(adl), prepnp(do, gen), pewny).
realizuje(xp(adl), prepnp(ku, dat), pewny).
realizuje(xp(adl), prepnp(między, acc), pewny).
realizuje(xp(adl), prepnp(na, acc), pewny).
realizuje(xp(adl), prepnp(nad, acc), pewny).
realizuje(xp(adl), prepnp(nieopodal, gen), pewny).
realizuje(xp(adl), prepnp(opodal, gen), pewny).
realizuje(xp(adl), prepnp(pod, acc), pewny).
realizuje(xp(adl), prepnp(pomiędzy, acc), pewny).
realizuje(xp(adl), prepnp(poza, acc), pewny).
realizuje(xp(adl), prepnp(przed, acc), pewny).
realizuje(xp(adl), prepnp(w, acc), pewny).
realizuje(xp(adl), prepnp(za, acc), pewny).
realizuje(xp(caus), advp(caus), pewny).
realizuje(xp(caus), comprepnp('na myśl'), pewny).
realizuje(xp(caus), comprepnp('na skutek'), pewny).
realizuje(xp(caus), comprepnp('na widok'), pewny).
realizuje(xp(caus), comprepnp('pod wpływem'), pewny).
realizuje(xp(caus), comprepnp('w wyniku'), pewny).
realizuje(xp(caus), comprepnp('z powodu'), pewny).
realizuje(xp(caus), cp(bo), pewny).
realizuje(xp(caus), cp(gdy), pewny).
realizuje(xp(caus), cp(jak), pewny).
realizuje(xp(caus), cp(kiedy), pewny).
realizuje(xp(caus), prepncp(dzięki, dat, że), pewny).
realizuje(xp(caus), prepncp(na, acc, że), pewny).
realizuje(xp(caus), prepncp(od, gen, że), pewny).
realizuje(xp(caus), prepncp(przez, acc, że), pewny).
realizuje(xp(caus), prepncp(wskutek, gen, że), pewny).
realizuje(xp(caus), prepnp(dzięki, dat), pewny).
realizuje(xp(caus), prepnp(na, acc), pewny).
realizuje(xp(caus), prepnp(od, gen), pewny).
realizuje(xp(caus), prepnp(przez, acc), pewny).
realizuje(xp(caus), prepnp(wskutek, gen), pewny).
realizuje(xp(caus), prepnp(z, gen), pewny).
realizuje(xp(dest), advp(dest), pewny).
realizuje(xp(dest), comprepnp('na rzecz'), pewny).
realizuje(xp(dest), comprepnp('w celu'), pewny).
realizuje(xp(dest), comprepnp('w intencji'), pewny).
realizuje(xp(dest), comprepnp('w kierunku'), pewny).
realizuje(xp(dest), comprepnp('w stronę'), pewny).
realizuje(xp(dest), cp(żeby), pewny).
realizuje(xp(dest), prepncp(do, gen, żeby), pewny).
realizuje(xp(dest), prepncp(ku, dat, żeby), pewny).
realizuje(xp(dest), prepncp(na, acc, int), pewny).
realizuje(xp(dest), prepncp(na, acc, że), pewny).
realizuje(xp(dest), prepncp(na, acc, żeby), pewny).
realizuje(xp(dest), prepncp(po, acc, żeby), pewny).
realizuje(xp(dest), prepnp(dla, gen), pewny).
realizuje(xp(dest), prepnp(do, gen), pewny).
realizuje(xp(dest), prepnp(ku, dat), pewny).
realizuje(xp(dest), prepnp(na, acc), pewny).
realizuje(xp(dest), prepnp(po, acc), pewny).
realizuje(xp(dur), advp(dur), pewny).
realizuje(xp(dur), comprepnp('na czas'), pewny).
realizuje(xp(dur), comprepnp('na okres'), pewny).
realizuje(xp(dur), comprepnp('na przeciąg'), pewny).
realizuje(xp(dur), comprepnp('w ciągu'), pewny).
realizuje(xp(dur), cp(aż), pewny).
realizuje(xp(dur), cp(dopóki), pewny).
realizuje(xp(dur), np(inst), pewny).
realizuje(xp(dur), np(accgen), pewny).
realizuje(xp(dur), prepnp(do, gen), pewny).
realizuje(xp(dur), prepnp(od, gen), pewny).
realizuje(xp(dur), prepnp(przez, acc), pewny).
realizuje(xp(instr), comprepnp('przy pomocy'), pewny).
realizuje(xp(instr), comprepnp('przy użyciu'), pewny).
realizuje(xp(instr), comprepnp('za pomocą'), pewny).
realizuje(xp(instr), np(inst), pewny).
realizuje(xp(locat), advp(locat), pewny).
realizuje(xp(locat), comprepnp('na końcu'), pewny).
realizuje(xp(locat), comprepnp('na początku'), pewny).
realizuje(xp(locat), comprepnp('na przodzie'), pewny).
realizuje(xp(locat), comprepnp('na środku'), pewny).
realizuje(xp(locat), comprepnp('na tyle'), pewny).
realizuje(xp(locat), comprepnp('od strony'), pewny).
realizuje(xp(locat), comprepnp('po bokach'), pewny).
realizuje(xp(locat), comprepnp('po stronie'), pewny).
realizuje(xp(locat), comprepnp('u dołu'), pewny).
realizuje(xp(locat), comprepnp('u góry'), pewny).
realizuje(xp(locat), comprepnp('u podnóża'), pewny).
realizuje(xp(locat), comprepnp('u stóp'), pewny).
realizuje(xp(locat), comprepnp('w dole'), pewny).
realizuje(xp(locat), comprepnp('w głębi'), pewny).
realizuje(xp(locat), comprepnp('w górze'), pewny).
realizuje(xp(locat), comprepnp('w końcu'), pewny).
realizuje(xp(locat), comprepnp('w pobliżu'), pewny).
realizuje(xp(locat), comprepnp('w środku'), pewny).
realizuje(xp(locat), comprepnp('z przodu'), pewny).
realizuje(xp(locat), comprepnp('z tyłu'), pewny).
realizuje(xp(locat), cp(rel), pewny).
realizuje(xp(locat), lex(prepnp(od, gen), [sg, [front, podwórze, ulica]^ (xor)], natr), pewny).
realizuje(xp(locat), lex(prepnp(z, gen), [sg, [przód, tył]^orconc], natr), pewny).
realizuje(xp(locat), lex(prepnp(z, gen), [sg, strona], atr(obl, n, [[np(gen)], [adjp(agr)]])), pewny).
realizuje(xp(locat), prepadjp(po, loc), pewny).
realizuje(xp(locat), prepnp(dokoła, gen), pewny).
realizuje(xp(locat), prepnp(dookoła, gen), pewny).
realizuje(xp(locat), prepnp(koło, gen), pewny).
realizuje(xp(locat), prepnp(między, inst), pewny).
realizuje(xp(locat), prepnp(nad, inst), pewny).
realizuje(xp(locat), prepnp(na, loc), pewny).
realizuje(xp(locat), prepnp(naokoło, gen), pewny).
realizuje(xp(locat), prepnp(naprzeciw, gen), pewny).
realizuje(xp(locat), prepnp(niedaleko, gen), pewny).
realizuje(xp(locat), prepnp('niedaleko od', gen), pewny).
realizuje(xp(locat), prepnp(nieopodal, gen), pewny).
realizuje(xp(locat), prepnp(obok, gen), pewny).
realizuje(xp(locat), prepnp(od, gen), pewny).
realizuje(xp(locat), prepnp(opodal, gen), pewny).
realizuje(xp(locat), prepnp(pod, inst), pewny).
realizuje(xp(locat), prepnp(po, loc), pewny).
realizuje(xp(locat), prepnp(pomiędzy, inst), pewny).
realizuje(xp(locat), prepnp(ponad, inst), pewny).
realizuje(xp(locat), prepnp(poniżej, gen), pewny).
realizuje(xp(locat), prepnp(popod, inst), pewny).
realizuje(xp(locat), prepnp(pośrodku, gen), pewny).
realizuje(xp(locat), prepnp(pośród, gen), pewny).
realizuje(xp(locat), prepnp(powyżej, gen), pewny).
realizuje(xp(locat), prepnp(poza, inst), pewny).
realizuje(xp(locat), prepnp(przed, inst), pewny).
realizuje(xp(locat), prepnp(przy, loc), pewny).
realizuje(xp(locat), prepnp(u, gen), pewny).
realizuje(xp(locat), prepnp('vis-à-vis', gen), pewny).
realizuje(xp(locat), prepnp(wewnątrz, gen), pewny).
realizuje(xp(locat), prepnp(wkoło, gen), pewny).
realizuje(xp(locat), prepnp(w, loc), pewny).
realizuje(xp(locat), prepnp(wokół, gen), pewny).
realizuje(xp(locat), prepnp(wśród, gen), pewny).
realizuje(xp(locat), prepnp(wzdłuż, gen), pewny).
realizuje(xp(locat), prepnp(za, inst), pewny).
realizuje(xp(locat), prepnp('z dala od', gen), pewny).
realizuje(xp(locat), prepnp('z daleka od', gen), pewny).
realizuje(xp(locat), comprepnp('u progu'), wątpliwy).
realizuje(xp(locat), prepnp(naokół, gen), archaiczny).
realizuje(xp(locat), prepnp(pobocz, gen), archaiczny).
realizuje(xp(locat), prepnp(pobok, gen), archaiczny).
realizuje(xp(locat), prepnp(podal, gen), archaiczny).
realizuje(xp(locat), prepnp(podle, gen), archaiczny).
realizuje(xp(locat), prepnp(śród, gen), archaiczny).
realizuje(xp(locat), prepnp(wedle, gen), archaiczny).
realizuje(xp(locat), prepnp(wpośród, gen), archaiczny).
realizuje(xp(locat), prepnp(wśrzód, gen), archaiczny).
realizuje(xp(mod), advp(mod), pewny).
realizuje(xp(mod), compar(jak), pewny).
realizuje(xp(mod), comprepnp('na sposób'), pewny).
realizuje(xp(mod), cp(rel), pewny).
realizuje(xp(mod), lex(prepnp(w, acc), [sg, sposób], atr(fac, n, [[adjp(agr)]])), pewny).
realizuje(xp(mod), prepadjp(jako, nom), pewny).
realizuje(xp(mod), prepadjp(po, postp), pewny).
realizuje(xp(mod), prepnp(bez, gen), pewny).
realizuje(xp(mod), prepnp(jako, nom), pewny).
realizuje(xp(mod), prepnp(pod, acc), pewny).
realizuje(xp(mod), prepnp(z, inst), pewny).
realizuje(xp(mod), comprepnp('na modłę'), archaiczny).
realizuje(xp(mod), cp(rel), archaiczny).
realizuje(xp(perl), advp(perl), pewny).
realizuje(xp(perl), comprepnp('w poprzek'), pewny).
realizuje(xp(perl), comprepnp('w ślad za'), pewny).
realizuje(xp(perl), cp(int), pewny).
realizuje(xp(perl), np(inst), pewny).
realizuje(xp(perl), prepnp(dokoła, gen), pewny).
realizuje(xp(perl), prepnp(dookoła, gen), pewny).
realizuje(xp(perl), prepnp(koło, gen), pewny).
realizuje(xp(perl), prepnp(między, inst), pewny).
realizuje(xp(perl), prepnp(nad, inst), pewny).
realizuje(xp(perl), prepnp(naokoło, gen), pewny).
realizuje(xp(perl), prepnp(obok, gen), pewny).
realizuje(xp(perl), prepnp(pod, inst), pewny).
realizuje(xp(perl), prepnp(po, loc), pewny).
realizuje(xp(perl), prepnp(pomiędzy, inst), pewny).
realizuje(xp(perl), prepnp(ponad, inst), pewny).
realizuje(xp(perl), prepnp(poprzez, acc), pewny).
realizuje(xp(perl), prepnp(przez, acc), pewny).
realizuje(xp(perl), prepnp(via, nom), pewny).
realizuje(xp(perl), prepnp(wokoło, gen), pewny).
realizuje(xp(perl), prepnp(wokół, gen), pewny).
realizuje(xp(perl), prepnp(wzdłuż, gen), pewny).
realizuje(xp(perl), prepnp(naokół, gen), archaiczny).
realizuje(xp(perl), prepnp(około, gen), archaiczny).
realizuje(xp(perl), prepnp(skroś, gen), archaiczny).
realizuje(xp(perl), prepnp(wskroś, gen), archaiczny).
realizuje(xp(perl), prepnp(wskróś, gen), archaiczny).
realizuje(xp(perl), comprepnp('w pobliżu'), pewny).
realizuje(xp(temp), advp(temp), pewny).
realizuje(xp(temp), comprepnp('na czas'), pewny).
realizuje(xp(temp), comprepnp('na koniec'), pewny).
realizuje(xp(temp), comprepnp('na początku'), pewny).
realizuje(xp(temp), comprepnp('na progu'), pewny).
realizuje(xp(temp), comprepnp('na przełomie'), pewny).
realizuje(xp(temp), comprepnp('na wstępie'), pewny).
realizuje(xp(temp), comprepnp('na zakończenie'), pewny).
realizuje(xp(temp), comprepnp('pod koniec'), pewny).
realizuje(xp(temp), comprepnp('u progu'), pewny).
realizuje(xp(temp), comprepnp('u schyłku'), pewny).
realizuje(xp(temp), comprepnp('w ciągu'), pewny).
realizuje(xp(temp), comprepnp('w czasie'), pewny).
realizuje(xp(temp), comprepnp('w końcu'), pewny).
realizuje(xp(temp), comprepnp('w okolicach'), pewny).
realizuje(xp(temp), comprepnp('w okresie'), pewny).
realizuje(xp(temp), comprepnp('w przeddzień'), pewny).
realizuje(xp(temp), comprepnp('w przededniu'), pewny).
realizuje(xp(temp), comprepnp('w toku'), pewny).
realizuje(xp(temp), comprepnp('w trakcie'), pewny).
realizuje(xp(temp), comprepnp('z końcem'), pewny).
realizuje(xp(temp), comprepnp('z początkiem'), pewny).
realizuje(xp(temp), cp(gdy), pewny).
realizuje(xp(temp), cp(jak), pewny).
realizuje(xp(temp), cp(kiedy), pewny).
realizuje(xp(temp), cp(zanim), pewny).
realizuje(xp(temp), np(gen), pewny).
realizuje(xp(temp), prepncp(po, loc, gdy), pewny).
realizuje(xp(temp), prepncp(po, loc, jak), pewny).
realizuje(xp(temp), prepncp(po, loc, kiedy), pewny).
realizuje(xp(temp), prepncp(przed, inst, gdy), pewny).
realizuje(xp(temp), prepncp(przed, inst, jak), pewny).
realizuje(xp(temp), prepncp(przed, inst, kiedy), pewny).
realizuje(xp(temp), prepnp(koło, gen), pewny).
realizuje(xp(temp), prepnp(lada, nom), pewny).
realizuje(xp(temp), prepnp(między, inst), pewny).
realizuje(xp(temp), prepnp(około, gen), pewny).
realizuje(xp(temp), prepnp(o, loc), pewny).
realizuje(xp(temp), prepnp(podczas, gen), pewny).
realizuje(xp(temp), prepnp(po, loc), pewny).
realizuje(xp(temp), prepnp(pomiędzy, inst), pewny).
realizuje(xp(temp), prepnp(przed, inst), pewny).
realizuje(xp(temp), prepnp(w, acc), pewny).
realizuje(xp(temp), prepnp(w, loc), pewny).
realizuje(xp(temp), prepnp(do, gen), wątpliwy).
realizuje(xp(temp), prepnp(od, gen), wątpliwy).
