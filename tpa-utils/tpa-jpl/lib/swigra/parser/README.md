# The Świgra Parser #

Author: Marcin Woliński

Web-based demo: <http://swigra.nlp.ipipan.waw.pl/>

Świgra is a constituency parser of Polish using an extended version of
the Definite Clause Grammar formalism.  The parser generates
constituency forests, which can be disambiguated by a statistical
component.  The program exists in two versions:

* Świgra 1 is a faithful implementation of Marek Świdziński's *Formal
  Grammar of Polish* (Świdziński 1992, *Gramatyka formalna języka
  polskiego*, GFJP)
  
* Świgra 2 operates with a new grammar stemming from GFJP but
  developed by Marcin Woliński. Compared to GFJP, Świgra 2 generates
  much simpler, more readable, and more intuitive parse trees.  The
  grammar describes a number of phenomena not covered by GFJP, e.g.,
  coordinated phrases of various types, constructions involving
  numerals, argument structures of non-verbal forms, constructions
  involving particles, common discontinuous structures, common
  sentence-like constructions without a verb.

Both versions use almost the same runtime (each version adds somewhat
different new features to DCG, but the general processing scheme is
the same).  The runtime is called Birnam (its slogan is *We bring
forests to your door*).

Świgra can use morphological analyser
[Morfeusz](http://morfeusz.sgjp.pl/) as its first step of processing
or it can be fed with preprocessed data in the format of the NKJP
corpus.

A very important component influencing the quality of trees generated
by a parser is its valence dictionary.  Świgra 2 uses
[Walenty](http://walenty.ipipan.waw.pl/) as the source of valency
data.  Previous versions of the parser depended on Marek Świdziński's
valence dictionary SDPV (1998) extended with the most frequent verbs
appearing in NKJP1M. This dictionary is also available in the
distribution package below.

## Publications ##

Świgra 1 and the Birnam runtime are documented in the work:

* Marcin Woliński. [*Komputerowa weryfikacja gramatyki
  Świdzińskiego*](http://nlp.ipipan.waw.pl/Bib/woli:04.pdf). Ph.D. dissertation,
  Institute of Computer Science, Polish Academy of Sciences, Warsaw,
  2004.

The grammar and implementation of Świgra 2 is presented in the book:

* Marcin Woliński. [*Automatyczna analiza składnikowa języka
  polskiego*](https://www.wuw.pl/data/include/cms/Automatyczna_analiza_skladnikowa_Wolinski_Marcin_2019.pdf). Wydawnictwa
  Uniwersytetu Warszawskiego, Warsaw, 2019.



## Availability and license ##


 * Świgra 2 [swigra_current.zip](http://zil.ipipan.waw.pl/%C5%9Awigra?action=AttachFile&do=get&target=swigra_current.zip)

Most of the files in the package are made available under the GNU
General Public License v3.  Some auxiliary files are put in the public
domain for the sake of simplicity — the author disclaims copyright to
these files.  This applies to the sample grammar for Birnam and the C
code used to interface Morfeusz with SWI Prolog.

The release of Świgra 1 and 2 under GPL is possible thanks to the kind
permission of the following persons and institutions:

1. Prof. Marek Świdziński, the author of the grammar used by Świgra 1,

2. Prof. Janusz S. Bień, the leader of a project 8T11C 00213 “Zestaw
   testów do weryfikacji i oceny analizatorów języka polskiego”
   (1997–1999) within which a prototype for Świgra 1 was developed
   (under the name AS),

3. Institute of Computer Science Polish Academy of Sciences, my
   current employer.


The development of Świgra 2 was co-financed by the following projects:

  * MNiSW N N104 224735 (2008–2011),
  * [Nekst](http://www.ipipan.waw.pl/nekst/) (2012–2013),
  * [CLARIN-PL](http://clarin-pl.eu/) (2014–2018).

The copyright holder of Świgra is the Institute of Computer Science,
Polish Academy of Sciences.


## Installation ##

1. Świgra is implemented in SWI Prolog, which can be downloaded from
   its [site](http://www.swi-prolog.org/download/stable).  On Linux a
   prepackaged version available in system repositories is preferable.

2. The files from the Świgra distribution should be extracted in an
   empty folder retaining the structure of sub-folders (including the
   `parser/` folder).

3. For interactive use Morfeusz is needed.  On Linux — please install
   system-wide as described on Morfeusz download page.  On Windows —
   download the [command-line
   version](http://sgjp.pl/morfeusz/download/20190415/morfeusz2-1.9.10.sgjp.20190415-Windows-amd64.tar.gz),
   extract the file `morfeusz2.dll` and put it in the Świgra’s
   `parser/` folder.

### Interactive use ###

For interactive use we suggest the web based interface, which can be
accessed in a web browser at the addres <http://localhost:3333/> after
a Świgra server is activated in the following way:

#### On Linux ####

In the parser folder execute the command:

```
./swigra -w
```

Świgra 2 is used by default.  For Świgra 1 add `-1` to the command line.

#### On Windows ####

Execute the command `swigra2_web.cmd` in the parser folder.


### Batch use ###

[to be described later]

Pakiety Ubuntu konieczne dla działania całej wsadowej ścieżki
przetwarzania (skrypty genparser i swigra_batch):

swi-prolog
libbsd-resource-perl
libfile-slurp-perl
libxml-libxml-perl


