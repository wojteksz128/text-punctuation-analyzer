package net.wojteksz128.tpa.utils.morfeusz

object MorfeuszTagConverter {
    /*
    —   Liczba:
            pojedyncza sg,
            mnoga pl
     */
    val wordNumber = WordProperty("liczba", listOf(
            WordPropertyValue("sg", "pojedyncza"),
            WordPropertyValue("pl", "mnoga")
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
    val wordCase = WordProperty("przypadek", listOf(
            WordPropertyValue("nom", "mianownik"),
            WordPropertyValue("gen", "dopełniacz"),
            WordPropertyValue("dat", "celownik"),
            WordPropertyValue("acc", "biernik"),
            WordPropertyValue("inst", "narzędnik"),
            WordPropertyValue("loc", "miejscownik"),
            WordPropertyValue("voc", "wołacz")
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
    val wordType = WordProperty("rodzaj", listOf(
            WordPropertyValue("m1", "męski osobowy"),
            WordPropertyValue("m2", "męski zwierzęcy"),
            WordPropertyValue("m3", "męski rzeczowy"),
            WordPropertyValue("f", "żeński"),
            WordPropertyValue("n1", "nijaki zbiorowy"),
            WordPropertyValue("n2", "nijaki zwykły"),
            WordPropertyValue("p1", "przymnogi osobowy"),
            WordPropertyValue("p2", "przymnogi zwykły"),
            WordPropertyValue("p3", "przymnogi opisowy")
    ))

    /*
    —   Osoba:
            pierwsza pri
            druga sec
            trzecia ter
     */
    val wordPerson = WordProperty("osoba", listOf(WordPropertyValue("pri", "pierwsza"),
            WordPropertyValue("sec", "druga"),
            WordPropertyValue("ter", "trzecia")
    ))

    /*
    —   Stopień:
            równy pos
            wyższy comp
            najwyższy sup
     */
    val wordGrade = WordProperty("stopień", listOf(
            WordPropertyValue("pos", "równy"),
            WordPropertyValue("comp", "wyższy"),
            WordPropertyValue("sup", "najwyższy")
    ))

    /*
    —   Aspekt:
            niedokonany imperf
            dokonany perf
     */
    val wordAspect = WordProperty("aspekt", listOf(
            WordPropertyValue("imperf", "niedokonany"),
            WordPropertyValue("perf", "dokonany")
    ))

    /*
    —   Zanegowanie:
            niezanegowana aff
            zanegowana neg
     */
    val wordDenial = WordProperty("zanegowanie", listOf(
            WordPropertyValue("aff", "niezanegowana"),
            WordPropertyValue("neg", "zanegowana")
    ))

    /*
    —   Akcentowość:
            akcentowana akc
            nieakcentowana nakc
     */
    val wordAccented = WordProperty("akcentowość", listOf(
            WordPropertyValue("akc", "akcentowana"),
            WordPropertyValue("nakc", "nieakcentowana")
    ))

    /*
    —   Poprzyimkowość:
            poprzyimkowa praep,
            niepoprzyimkowa npraep
     */
    val wordPostPreposition = WordProperty("poprzyimkowość", listOf(
            WordPropertyValue("praep", "poprzyimkowa"),
            WordPropertyValue("npraep", "niepoprzyimkowa")
    ))

    /*
    —   Akomodacyjność:
            uzgadniająca congr
            rządząca rec
     */
    val wordAccommodability = WordProperty("akomodacyjność", listOf(
            WordPropertyValue("congr", "uzgadniająca"),
            WordPropertyValue("rec", "rządząca")
    ))

    /*
    —   Aglutynacyjność:
            aglutynacyjna agl
            nieaglutynacyjna nagl
     */
    val wordAgglutination = WordProperty("aglutynacyjność", listOf(
            WordPropertyValue("agl", "aglutynacyjna"),
            WordPropertyValue("nagl", "nieaglutynacyjna")
    ))

    /*
    —   Wokaliczność:
            wokaliczna wok
            niewokaliczna nwok
    */
    val wordVocalicity = WordProperty("wokaliczność", listOf(
            WordPropertyValue("wok", "wokaliczna"),
            WordPropertyValue("nwok", "niewokaliczna")
    ))
}

class WordProperty(val name: String, val values: List<WordPropertyValue>)

class WordPropertyValue(val shortcut: String, val valueName: String) {
    lateinit var property: WordProperty

    val displayName: String
        get() = "${property.name}: $valueName"
}