/* Prolog interface to the morphological analyzer Morfeusz 
   Version for SWI Prolog up to release 5.4 (non Unicode relases)

   Author: Marcin Woliński 
   This file is in the public domain. 

   To compile use this incantation:
   
   plld -v -shared -o morfeusz-swi.so morfeusz-glueswi5.4.c -lmorfeusz

   If your Prolog interpreter is not called 'pl' add to the options
   -pl <interpreter>.  So for Debian and Ubuntu the line becomes:
   
   plld -v -pl swipl -shared -o morfeusz-swi.so morfeusz-glueswi5.4.c \
   -lmorfeusz

*/
#include <SWI-Prolog.h>
#include <string.h>
#include "morfeusz.h"

static functor_t F_interp;

static foreign_t pl_morfeusz_analyse(term_t st, term_t at) { 
  char *tekst;
  
  if ( PL_get_chars(st, &tekst,
		    CVT_ATOM|CVT_STRING|CVT_LIST|BUF_DISCARDABLE) ) { 
    InterpMorf *mo = morfeusz_analyse(tekst);
    term_t l = PL_copy_term_ref(at);
    term_t elem = PL_new_term_ref();
    int i;
    
    for (i=0; mo[i].p != -1; i++) { 
      term_t interp = PL_new_term_ref();
      if ( !PL_unify_list(l, elem, l) ||
	   !PL_chars_to_term(mo[i].interp==NULL?"[]":mo[i].interp, interp) ||
	   !PL_unify_term(elem,
			  PL_FUNCTOR, F_interp,
			  PL_INTEGER, mo[i].p,
			  PL_INTEGER, mo[i].k,
			  PL_CHARS, mo[i].forma==NULL?"":mo[i].forma,
			  PL_CHARS, mo[i].haslo==NULL?"[]":mo[i].haslo,
			  PL_TERM, interp
			  )
	   // PL_TERM int PL_chars_to_term(const char *chars, term_t -t)
	   ) PL_fail;
    }
    return PL_unify_nil(l);
  }
  PL_fail;
}

install_t install() { 
  F_interp = PL_new_functor(PL_new_atom("i"), 5);
  morfeusz_set_option(MORFOPT_ENCODING, MORFEUSZ_ISO8859_2);
  PL_register_foreign("morfeusz_analyse", 2, pl_morfeusz_analyse, 0);
}


/* Local Variables: */
/* coding: utf-8 */
/* mode: c */
/* End: */
