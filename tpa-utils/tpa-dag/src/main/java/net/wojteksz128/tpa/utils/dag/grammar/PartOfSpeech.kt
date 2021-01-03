package net.wojteksz128.tpa.utils.dag.grammar

// FIXME: 02.01.2021 Czy dependsOfSpeech ma łączyć się tylko z następnym słowem?
enum class PartOfSpeech(val dependsOfSpeech: List<PartOfSpeech> = listOf()) {
	/**
	 * Rzeczownik
	 * @see <a href="https://sjp.pwn.pl/sjp/rzeczownik;2518575.html">Hasło "Rzeczownik" na sjp.pwn.pl</a>
	 */
	NOUN,

	/**
	 * Przymiotnik
	 * @see <a href="https://sjp.pwn.pl/sjp/przymiotnik;2512282.html">Hasło "Przymiotnik" na sjp.pwn.pl</a>
	 */
	ADJECTIVE(listOf(NOUN)),

	/**
	 * Czasownik
	 * @see <a href="https://sjp.pwn.pl/sjp/czasownik;2450295.html">Hasło "Czasownik" na sjp.pwn.pl</a>
	 */
	VERB,

	/**
	 * Liczebnik
	 * @see <a href="https://sjp.pwn.pl/sjp/liczebnik;2478357.html">Hasło "Liczebnik" na sjp.pwn.pl</a>
	 */
	NUMERAL(listOf(NOUN)),

	/**
	 * Zaimek
	 * @see <a href="https://sjp.pwn.pl/sjp/zaimek;2542453.html">Hasło "Zaimek" na sjp.pwn.pl</a>
	 */
	PRONOUN,

	/**
	 * Przysłówek
	 * @see <a href="https://sjp.pwn.pl/sjp/przyslowek;2512578.html">Hasło "Przysłówek" na sjp.pwn.pl</a>
	 */
	ADVERB(listOf(VERB, ADJECTIVE)),

	/**
	 * Przyimek
	 * @see <a href="https://sjp.pwn.pl/sjp/przyimek;2512083.html">Hasło "Przyimek" na sjp.pwn.pl</a>
	 */
	PREPOSITION(listOf(NOUN, ADJECTIVE, NUMERAL, PREPOSITION)),

	/**
	 * Spójnik
	 * @see <a href="https://sjp.pwn.pl/sjp/spojnik;2523279.html">Hasło "Spójnik" na sjp.pwn.pl</a>
	 */
	CONJUNCTION,

	/**
	 * Wykrzyknik
	 * @see <a href="https://sjp.pwn.pl/sjp/wykrzyknik;2539553.html">Hasło "Wykrzyknik" na sjp.pwn.pl</a>
	 */
	EXCLAMATION_MARK,

	/**
	 * Partykuła
	 * @see <a href="https://sjp.pwn.pl/sjp/partykula;2570803.html">Hasło "Partykuła" na sjp.pwn.pl</a>
	 */
	PARTICLE,

	/** Inny nieokreślony */
	OTHER;
}