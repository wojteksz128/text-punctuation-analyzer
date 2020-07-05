
Ujednoznaczniacz drzew dla Świgry oparty na modelowaniu maksimum entropii
=========================================================================

Do liczenia modelu używany jest Amis Kazuhiro Yoshidy:
http://nactem.ac.uk/amis/
https://github.com/mynlp/amis
Linuksowy kompilat jest w repozytorium (nie wygląda na bardzo zależny od wersji bibliotek).

Potrzebne są tylko zdania z pełnymi odpowiedziami.  Skrypt
`filter_full_trees.py` produkuje je niszcząco kasując pliki
odpowiadające odpowiedziom specjalnym we wskazanym katalogu ze Składnicą:

    ./filter_full_trees.py ../Składnica-frazowa-180105/

### Wywołanie crosswalidacji:

    nice -n 19 ./test-max-ent.py ../Składnica-frazowa-180105/  > output 2>&1
    nice -n 19 ./test-max-ent.py -c 10 --features pcfg,pcfgtfw ../Składnica-frazowa-180105/ > output 2>&1

Dokumentacja dostępnych cech: `./test-max-ent.py --help`


### Wywołanie trenowania:

    nice -n 19 ./train.py -c 10 --features pcfg,pcfgtfw ../Składnica-frazowa-180105/


### Ujednoznacznianie jednego drzewa:

    ./disamb-tree.py ../Składnica-frazowa-180105/NKJP_1M_SlowoPowszechne/morph_10-p/morph_10.24-s.xml

Używa modelu `models/default.pkl`
