package net.wojteksz128.tpa.utils.morfeusz

import net.wojteksz128.tpa.utils.morfeusz.PartOfSpeech.*

object MorfeuszWordTags {

    /*
    —   Liczba:
            pojedyncza sg,
            mnoga pl
     */
    private val wordNumber = GrammarCategoryGroup("liczba", listOf(
            GrammarCategory("sg", "pojedyncza"),
            GrammarCategory("pl", "mnoga")
    ))

    /*
    —   Przypadek:
            mianownik nom
            dopełniacz gen
            celownik dat
            biernik acc
            narzędnik inst
            miejscownik loc
            wołacz voc
     */
    private val wordCase = GrammarCategoryGroup("przypadek", listOf(
            GrammarCategory("nom", "mianownik"),
            GrammarCategory("gen", "dopełniacz"),
            GrammarCategory("dat", "celownik"),
            GrammarCategory("acc", "biernik"),
            GrammarCategory("inst", "narzędnik"),
            GrammarCategory("loc", "miejscownik"),
            GrammarCategory("voc", "wołacz")
    ))

    /*
    —   Rodzaj:
            męski osobowy m1
            męski zwierzęcy m2
            męski rzeczowy m3
            żeński f
            nijaki zbiorowy n1
            nijaki zwykły n2
            przymnogi osobowy p1
            przymnogi zwykły p2
            przymnogi opisowy p3
     */
    private val wordType = GrammarCategoryGroup("rodzaj", listOf(
            GrammarCategory("m1", "męski osobowy"),
            GrammarCategory("m2", "męski zwierzęcy"),
            GrammarCategory("m3", "męski rzeczowy"),
            GrammarCategory("f", "żeński"),
            GrammarCategory("n1", "nijaki zbiorowy"),
            GrammarCategory("n2", "nijaki zwykły"),
            GrammarCategory("p1", "przymnogi osobowy"),
            GrammarCategory("p2", "przymnogi zwykły"),
            GrammarCategory("p3", "przymnogi opisowy")
    ))

    /*
    —   Osoba:
            pierwsza pri
            druga sec
            trzecia ter
     */
    private val wordPerson = GrammarCategoryGroup("osoba", listOf(GrammarCategory("pri", "pierwsza"),
            GrammarCategory("sec", "druga"),
            GrammarCategory("ter", "trzecia")
    ))

    /*
    —   Stopień:
            równy pos
            wyższy comp
            najwyższy sup
     */
    private val wordGrade = GrammarCategoryGroup("stopień", listOf(
            GrammarCategory("pos", "równy"),
            GrammarCategory("comp", "wyższy"),
            GrammarCategory("sup", "najwyższy")
    ))

    /*
    —   Aspekt:
            niedokonany imperf
            dokonany perf
     */
    private val wordAspect = GrammarCategoryGroup("aspekt", listOf(
            GrammarCategory("imperf", "niedokonany"),
            GrammarCategory("perf", "dokonany")
    ))

    /*
    —   Zanegowanie:
            niezanegowana aff
            zanegowana neg
     */
    private val wordDenial = GrammarCategoryGroup("zanegowanie", listOf(
            GrammarCategory("aff", "niezanegowana"),
            GrammarCategory("neg", "zanegowana")
    ))

    /*
    —   Akcentowość:
            akcentowana akc
            nieakcentowana nakc
     */
    private val wordAccented = GrammarCategoryGroup("akcentowość", listOf(
            GrammarCategory("akc", "akcentowana"),
            GrammarCategory("nakc", "nieakcentowana")
    ))

    /*
    —   Poprzyimkowość:
            poprzyimkowa praep,
            niepoprzyimkowa npraep
     */
    private val wordPostPreposition = GrammarCategoryGroup("poprzyimkowość", listOf(
            GrammarCategory("praep", "poprzyimkowa"),
            GrammarCategory("npraep", "niepoprzyimkowa")
    ))

    /*
    —   Akomodacyjność:
            uzgadniająca congr
            rządząca rec
     */
    private val wordAccommodability = GrammarCategoryGroup("akomodacyjność", listOf(
            GrammarCategory("congr", "uzgadniająca"),
            GrammarCategory("rec", "rządząca")
    ))

    /*
    —   Aglutynacyjność:
            aglutynacyjna agl
            nieaglutynacyjna nagl
     */
    private val wordAgglutination = GrammarCategoryGroup("aglutynacyjność", listOf(
            GrammarCategory("agl", "aglutynacyjna"),
            GrammarCategory("nagl", "nieaglutynacyjna")
    ))

    /*
    —   Wokaliczność:
            wokaliczna wok
            niewokaliczna nwok
    */
    private val wordVocalicity = GrammarCategoryGroup("wokaliczność", listOf(
            GrammarCategory("wok", "wokaliczna"),
            GrammarCategory("nwok", "niewokaliczna")
    ))

    val classes = listOf(
            GrammarClass("subst", "rzeczownik", NOUN, listOf(wordNumber, wordCase, wordType)),
            GrammarClass("depr", "rzeczownik deprecjatywny", NOUN, listOf(wordNumber, wordCase, wordType)),
            GrammarClass("num", "liczebnik główny", NUMERAL, listOf(wordNumber, wordCase, wordType, wordAccommodability)),
            GrammarClass("numcol", "liczebnik zbiorowy", NUMERAL, listOf(wordNumber, wordCase, wordType, wordAccommodability)),
            GrammarClass("adj", "przymiotnik", ADJECTIVE, listOf(wordNumber, wordCase, wordType, wordGrade)),
            GrammarClass("adja", "przymiotnik przyprzym.", ADJECTIVE, listOf()),
            GrammarClass("adjp", "przymiotnik poprzyimkowy", ADJECTIVE, listOf()),
            GrammarClass("adjc", "przymiotnik predykatywny", ADJECTIVE, listOf()),
            GrammarClass("adv", "przysłówek", ADVERB, listOf(wordGrade)),
            GrammarClass("ppron12", "zaimek nietrzecioosobowy", PRONOUN, listOf(wordNumber, wordCase, wordType, wordPerson, wordAccented)),
            GrammarClass("ppron3", "zaimek trzecioosobowy", PRONOUN, listOf(wordNumber, wordCase, wordType, wordPerson, wordAccented, wordPostPreposition)),
            GrammarClass("siebie", "zaimek siebie", PRONOUN, listOf(wordCase)),
            GrammarClass("fin", "forma nieprzeszła", VERB, listOf(wordNumber, wordPerson, wordAspect)),
            GrammarClass("bedzie", "forma przyszła być", VERB, listOf(wordNumber, wordPerson, wordAspect)),
            GrammarClass("aglt", "aglutynant być", VERB, listOf(wordNumber, wordPerson, wordAspect, wordVocalicity)),
            GrammarClass("praet", "pseudoimiesłów", VERB, listOf(wordNumber, wordType, wordAspect, wordAgglutination)),
            GrammarClass("impt", "rozkaźnik", VERB, listOf(wordNumber, wordPerson, wordAspect)),
            GrammarClass("imps", "bezosobnik", VERB, listOf(wordAspect)),
            GrammarClass("inf", "bezokolicznik", VERB, listOf(wordAspect)),
            GrammarClass("pcon", "im. przys. współczesny", VERB, listOf(wordAspect)),
            GrammarClass("pant", "im. przys. uprzedni", VERB, listOf(wordAspect)),
            GrammarClass("ger", "odsłownik", VERB, listOf(wordNumber, wordCase, wordType, wordAspect, wordDenial)),
            GrammarClass("pact", "im. przym. czynny", VERB, listOf(wordNumber, wordCase, wordType, wordAspect, wordDenial)),
            GrammarClass("ppas", "im. przym. bierny", VERB, listOf(wordNumber, wordCase, wordType, wordAspect, wordDenial)),
            GrammarClass("winien", "winien", VERB, listOf(wordNumber, wordType, wordAspect)),
            GrammarClass("pred", "predykatyw", OTHER, listOf()),
            GrammarClass("prep", "przyimek", PREPOSITION, listOf(wordCase)),
            GrammarClass("conj", "spójnik współrzędny", CONJUNCTION, listOf()),
            GrammarClass("comp", "spójnik podrzędny", CONJUNCTION, listOf()),
            GrammarClass("qub", "kublik", OTHER, listOf()),
            GrammarClass("brev", "skrót", OTHER, listOf()),
            GrammarClass("burk", "burkinostka", OTHER, listOf()),
            GrammarClass("interj", "wykrzyknik", EXCLAMATION_MARK, listOf()),
            GrammarClass("interp", "interpunkcja", OTHER, listOf()),
            GrammarClass("xxx", "ciało obce", OTHER, listOf()),
            GrammarClass("ign", "forma nierozpoznana", OTHER, listOf())
    )
}

