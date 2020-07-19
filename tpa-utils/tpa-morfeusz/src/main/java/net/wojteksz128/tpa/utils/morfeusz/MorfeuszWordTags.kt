package net.wojteksz128.tpa.utils.morfeusz

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
            GrammarClass("subst", "rzeczownik", listOf(wordNumber, wordCase, wordType)),
            GrammarClass("depr", "rzeczownik deprecjatywny", listOf(wordNumber, wordCase, wordType)),
            GrammarClass("num", "liczebnik główny", listOf(wordNumber, wordCase, wordType, wordAccommodability)),
            GrammarClass("numcol", "liczebnik zbiorowy", listOf(wordNumber, wordCase, wordType, wordAccommodability)),
            GrammarClass("adj", "przymiotnik", listOf(wordNumber, wordCase, wordType, wordGrade)),
            GrammarClass("adja", "przymiotnik przyprzym.", listOf()),
            GrammarClass("adjp", "przymiotnik poprzyimkowy", listOf()),
            GrammarClass("adjc", "przymiotnik predykatywny", listOf()),
            GrammarClass("adv", "przysłówek", listOf(wordGrade)),
            GrammarClass("ppron12", "zaimek nietrzecioosobowy", listOf(wordNumber, wordCase, wordType, wordPerson, wordAccented)),
            GrammarClass("ppron3", "zaimek trzecioosobowy", listOf(wordNumber, wordCase, wordType, wordPerson, wordAccented, wordPostPreposition)),
            GrammarClass("siebie", "zaimek siebie", listOf(wordCase)),
            GrammarClass("fin", "forma nieprzeszła", listOf(wordNumber, wordPerson, wordAspect)),
            GrammarClass("bedzie", "forma przyszła być", listOf(wordNumber, wordPerson, wordAspect)),
            GrammarClass("aglt", "aglutynant być", listOf(wordNumber, wordPerson, wordAspect, wordVocalicity)),
            GrammarClass("praet", "pseudoimiesłów", listOf(wordNumber, wordType, wordAspect, wordAgglutination)),
            GrammarClass("impt", "rozkaźnik", listOf(wordNumber, wordPerson, wordAspect)),
            GrammarClass("imps", "bezosobnik", listOf(wordAspect)),
            GrammarClass("inf", "bezokolicznik", listOf(wordAspect)),
            GrammarClass("pcon", "im. przys. współczesny", listOf(wordAspect)),
            GrammarClass("pant", "im. przys. uprzedni", listOf(wordAspect)),
            GrammarClass("ger", "odsłownik", listOf(wordNumber, wordCase, wordType, wordAspect, wordDenial)),
            GrammarClass("pact", "im. przym. czynny", listOf(wordNumber, wordCase, wordType, wordAspect, wordDenial)),
            GrammarClass("ppas", "im. przym. bierny", listOf(wordNumber, wordCase, wordType, wordAspect, wordDenial)),
            GrammarClass("winien", "winien", listOf(wordNumber, wordType, wordAspect)),
            GrammarClass("pred", "predykatyw", listOf()),
            GrammarClass("prep", "przyimek", listOf(wordCase)),
            GrammarClass("conj", "spójnik współrzędny", listOf()),
            GrammarClass("comp", "spójnik podrzędny", listOf()),
            GrammarClass("qub", "kublik", listOf()),
            GrammarClass("brev", "skrót", listOf()),
            GrammarClass("burk", "burkinostka", listOf()),
            GrammarClass("interj", "wykrzyknik", listOf()),
            GrammarClass("interp", "interpunkcja", listOf()),
            GrammarClass("xxx", "ciało obce", listOf()),
            GrammarClass("ign", "forma nierozpoznana", listOf())
    )
}

