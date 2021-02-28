@file:Suppress("MemberVisibilityCanBePrivate")

package net.wojteksz128.tpa.utils.dag.grammar

import net.wojteksz128.tpa.utils.dag.grammar.PartOfSpeech.*

object Klasa {
    val RZECZOWNIK = GrammarClass("subst", "rzeczownik", NOUN, listOf(Liczba.group, Przypadek.group, Rodzaj.group))
    val RZECZOWNIK_DEPRECJATYWNY = GrammarClass("depr", "rzeczownik deprecjatywny", NOUN, listOf(Liczba.group, Przypadek.group, Rodzaj.group))
    val LICZEBNIK_GLOWNY = GrammarClass("num", "liczebnik główny", NUMERAL, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Akomodacyjnosc.group))
    val LICZEBNIK_ZBIOROWY = GrammarClass("numcol", "liczebnik zbiorowy", NUMERAL, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Akomodacyjnosc.group))
    val PRZYMIOTNIK = GrammarClass("adj", "przymiotnik", ADJECTIVE, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Stopien.group))
    val PRZYMIOTNIK_PRZYPRZYM = GrammarClass("adja", "przymiotnik przyprzym.", ADJECTIVE, listOf())
    val PRZYMIOTNIK_POPRZYIMKOWY = GrammarClass("adjp", "przymiotnik poprzyimkowy", ADJECTIVE, listOf())
    val PRZYMIOTNIK_PREDYKATYWNY = GrammarClass("adjc", "przymiotnik predykatywny", ADJECTIVE, listOf())
    val PRZYSLOWEK = GrammarClass("adv", "przysłówek", ADVERB, listOf(Stopien.group))
    val ZAIMEK_NIETRZECIOOSOBOWY = GrammarClass("ppron12", "zaimek nietrzecioosobowy", PRONOUN, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Osoba.group, Akcentowosc.group))
    val ZAIMEK_TRZECIOOSOBOWY = GrammarClass("ppron3", "zaimek trzecioosobowy", PRONOUN, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Osoba.group, Akcentowosc.group, Poprzyimkowosc.group))
    val ZAIMEK_SIBIE = GrammarClass("siebie", "zaimek siebie", PRONOUN, listOf(Przypadek.group))
    val FORMA_NIEPRZESZLA = GrammarClass("fin", "forma nieprzeszła", VERB, listOf(Liczba.group, Osoba.group, Aspekt.group))
    val FORMA_PRZYSZLA_BYC = GrammarClass("bedzie", "forma przyszła być", VERB, listOf(Liczba.group, Osoba.group, Aspekt.group))
    val AGLUTYNANT_BYC = GrammarClass("aglt", "aglutynant być", VERB, listOf(Liczba.group, Osoba.group, Aspekt.group, Wokalicznosc.group))
    val PSEUDOIMIESLOW = GrammarClass("praet", "pseudoimiesłów", VERB, listOf(Liczba.group, Rodzaj.group, Aspekt.group, Aglutynacyjnosc.group))
    val ROZKAZNIK = GrammarClass("impt", "rozkaźnik", VERB, listOf(Liczba.group, Osoba.group, Aspekt.group))
    val BEZOSOBNIK = GrammarClass("imps", "bezosobnik", VERB, listOf(Aspekt.group))
    val BEZOKOLICZNIK = GrammarClass("inf", "bezokolicznik", VERB, listOf(Aspekt.group))
    val IM_PRZYS_WSPOLCZESNY = GrammarClass("pcon", "im. przys. współczesny", VERB, listOf(Aspekt.group))
    val IM_PRZYS_UPRZEDNI = GrammarClass("pant", "im. przys. uprzedni", VERB, listOf(Aspekt.group))
    val ODSLOWNIK = GrammarClass("ger", "odsłownik", VERB, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Aspekt.group, Zanegowanie.group))
    val IM_PRZYM_CZYNNY = GrammarClass("pact", "im. przym. czynny", VERB, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Aspekt.group, Zanegowanie.group))
    val IM_PRZYM_BIERNY = GrammarClass("ppas", "im. przym. bierny", VERB, listOf(Liczba.group, Przypadek.group, Rodzaj.group, Aspekt.group, Zanegowanie.group))
    val WINIEN = GrammarClass("winien", "winien", VERB, listOf(Liczba.group, Rodzaj.group, Aspekt.group))
    val PREDYKATYW = GrammarClass("pred", "predykatyw", OTHER, listOf())
    val PRZYIMEK = GrammarClass("prep", "przyimek", PREPOSITION, listOf(Przypadek.group))
    val SPOJNIK_WSPOLCZESNY = GrammarClass("conj", "spójnik współrzędny", CONJUNCTION, listOf())
    val SPOJNIK_PODRZEDNY = GrammarClass("comp", "spójnik podrzędny", CONJUNCTION, listOf())
    val KUBLIK = GrammarClass("qub", "kublik", OTHER, listOf())
    val SKROT = GrammarClass("brev", "skrót", OTHER, listOf())
    val BURKINOSTKA = GrammarClass("burk", "burkinostka", OTHER, listOf())
    val WYKRZYKNIK = GrammarClass("interj", "wykrzyknik", EXCLAMATION_MARK, listOf())
    val INTERPUNKCJA = GrammarClass("interp", "interpunkcja", OTHER, listOf())
    val PARTYKULA = GrammarClass("part", "partykuła", PARTICLE, listOf())
    val CIALO_OBCE = GrammarClass("xxx", "ciało obce", OTHER, listOf())
    val FORMA_NIEROZPOZNANA = GrammarClass("ign", "forma nierozpoznana", OTHER, listOf())

    val categories = listOf(RZECZOWNIK, RZECZOWNIK_DEPRECJATYWNY, LICZEBNIK_GLOWNY, LICZEBNIK_ZBIOROWY, PRZYMIOTNIK,
            PRZYMIOTNIK_PRZYPRZYM, PRZYMIOTNIK_POPRZYIMKOWY, PRZYMIOTNIK_PREDYKATYWNY, PRZYSLOWEK,
            ZAIMEK_NIETRZECIOOSOBOWY, ZAIMEK_TRZECIOOSOBOWY, ZAIMEK_SIBIE, FORMA_NIEPRZESZLA, FORMA_PRZYSZLA_BYC,
            AGLUTYNANT_BYC, PSEUDOIMIESLOW, ROZKAZNIK, BEZOSOBNIK, BEZOKOLICZNIK, IM_PRZYS_WSPOLCZESNY,
            IM_PRZYS_UPRZEDNI, ODSLOWNIK, IM_PRZYM_CZYNNY, IM_PRZYM_BIERNY, WINIEN, PREDYKATYW, PRZYIMEK,
            SPOJNIK_WSPOLCZESNY, SPOJNIK_PODRZEDNY, KUBLIK, SKROT, BURKINOSTKA, WYKRZYKNIK, INTERPUNKCJA, PARTYKULA,
            CIALO_OBCE, FORMA_NIEROZPOZNANA)
    val classesMap: Map<String, GrammarClass> = categories.map { it.shortcut to it }.toMap()
}

/*
—   Liczba:
        pojedyncza sg,
        mnoga pl
 */
object Liczba {
    val POJEDYNCZA = GrammarCategory("sg", "pojedyncza")
    val MNOGA = GrammarCategory("pl", "mnoga")

    val categories = listOf(POJEDYNCZA, MNOGA)

    val group = GrammarCategoryGroup("liczba", categories)
}

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
object Przypadek {
    val MIANOWNIK = GrammarCategory("nom", "mianownik")
    val DOPELNIACZ = GrammarCategory("gen", "dopełniacz")
    val CELOWNIK = GrammarCategory("dat", "celownik")
    val BIERNIK = GrammarCategory("acc", "biernik")
    val NARZEDNIK = GrammarCategory("inst", "narzędnik")
    val MIEJSCOWNIK = GrammarCategory("loc", "miejscownik")
    val WOLACZ = GrammarCategory("voc", "wołacz")

    val categories = listOf(MIANOWNIK, DOPELNIACZ, CELOWNIK, BIERNIK, NARZEDNIK, MIEJSCOWNIK, WOLACZ)

    val group = GrammarCategoryGroup("przypadek", categories)
}

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
object Rodzaj {
    val MESKI_OSOBOWY = GrammarCategory("m1", "męski osobowy")
    val MESKI_ZWIERZECY = GrammarCategory("m2", "męski zwierzęcy")
    val MESKI_RZECZOWY = GrammarCategory("m3", "męski rzeczowy")
    val ZENSKI = GrammarCategory("f", "żeński")
    val NIJAKI = GrammarCategory("n", "nijaki")
    val NIJAKI_ZBIOROWY = GrammarCategory("n1", "nijaki zbiorowy")
    val NIJAKI_ZWYKLY = GrammarCategory("n2", "nijaki zwykły")
    val PRZYMNOGI_OSOBOWY = GrammarCategory("p1", "przymnogi osobowy")
    val PRZYMNOGI_ZWYKLY = GrammarCategory("p2", "przymnogi zwykły")
    val PRZYMNOGI_OPISOWY = GrammarCategory("p3", "przymnogi opisowy")

    val categories = listOf(MESKI_OSOBOWY, MESKI_ZWIERZECY, MESKI_RZECZOWY, ZENSKI, NIJAKI, NIJAKI_ZBIOROWY, NIJAKI_ZWYKLY,
            PRZYMNOGI_OSOBOWY, PRZYMNOGI_ZWYKLY, PRZYMNOGI_OPISOWY)

    val group = GrammarCategoryGroup("rodzaj", categories)
}

/*
—   Osoba:
        pierwsza pri
        druga sec
        trzecia ter
 */
object Osoba {
    val PIERWSZA = GrammarCategory("pri", "pierwsza")
    val DRUGA = GrammarCategory("sec", "druga")
    val TRZECIA = GrammarCategory("ter", "trzecia")

    val categories = listOf(PIERWSZA, DRUGA, TRZECIA)

    val group = GrammarCategoryGroup("osoba", categories)
}

/*
—   Stopień:
        równy pos
        wyższy comp
        najwyższy sup
 */
object Stopien {
    val ROWNY = GrammarCategory("pos", "równy")
    val WYZSZY = GrammarCategory("comp", "wyższy")
    val NAJWYZSZY = GrammarCategory("sup", "najwyższy")

    val categories = listOf(ROWNY, WYZSZY, NAJWYZSZY)

    val group = GrammarCategoryGroup("stopień", categories)
}

/*
—   Aspekt:
        niedokonany imperf
        dokonany perf
 */
object Aspekt {
    val NIEDOKONANY = GrammarCategory("imperf", "niedokonany")
    val DOKONANY = GrammarCategory("perf", "dokonany")

    val categories = listOf(NIEDOKONANY, DOKONANY)

    val group = GrammarCategoryGroup("aspekt", categories)
}

/*
—   Zanegowanie:
        niezanegowana aff
        zanegowana neg
 */
object Zanegowanie {
    val NIEZANEGOWANA = GrammarCategory("aff", "niezanegowana")
    val ZANEGOWANA = GrammarCategory("neg", "zanegowana")

    val categories = listOf(NIEZANEGOWANA, ZANEGOWANA)

    val group = GrammarCategoryGroup("zanegowanie", categories)
}

/*
—   Akcentowość:
        akcentowana akc
        nieakcentowana nakc
 */
object Akcentowosc {
    val AKCENTOWANA = GrammarCategory("akc", "akcentowana")
    val NIEAKCENTOWANA = GrammarCategory("nakc", "nieakcentowana")

    val categories = listOf(AKCENTOWANA, NIEAKCENTOWANA)

    val group = GrammarCategoryGroup("akcentowość", categories)
}

/*
—   Poprzyimkowość:
        poprzyimkowa praep,
        niepoprzyimkowa npraep
 */
object Poprzyimkowosc {
    val POPRZYIMKOWA = GrammarCategory("praep", "poprzyimkowa")
    val NIEPOPRZYIMKOWA = GrammarCategory("npraep", "niepoprzyimkowa")

    val categories = listOf(POPRZYIMKOWA, NIEPOPRZYIMKOWA)

    val group = GrammarCategoryGroup("poprzyimkowość", categories)
}

/*
—   Akomodacyjność:
        uzgadniająca congr
        rządząca rec
 */
object Akomodacyjnosc {
    val UZGADNIAJACA = GrammarCategory("congr", "uzgadniająca")
    val RZADZACA = GrammarCategory("rec", "rządząca")

    val categories = listOf(UZGADNIAJACA, RZADZACA)

    val group = GrammarCategoryGroup("akomodacyjność", categories)
}

/*
—   Aglutynacyjność:
        aglutynacyjna agl
        nieaglutynacyjna nagl
 */
object Aglutynacyjnosc {
    val AGLUTYNACYJNA = GrammarCategory("agl", "aglutynacyjna")
    val NIEAGLUTYNACYJNA = GrammarCategory("nagl", "nieaglutynacyjna")

    val categories = listOf(AGLUTYNACYJNA, NIEAGLUTYNACYJNA)

    val group = GrammarCategoryGroup("aglutynacyjność", categories)
}

/*
—   Wokaliczność:
        wokaliczna wok
        niewokaliczna nwok
*/
object Wokalicznosc {
    val WOKALICZNA = GrammarCategory("wok", "wokaliczna")
    val NIEWOKALICZNA = GrammarCategory("nwok", "niewokaliczna")

    val categories = listOf(WOKALICZNA, NIEWOKALICZNA)

    val group = GrammarCategoryGroup("wokaliczność", categories)
}