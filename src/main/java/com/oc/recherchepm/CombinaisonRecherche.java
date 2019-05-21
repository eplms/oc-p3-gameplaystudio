package com.oc.recherchepm;

import com.oc.common.Combinaison;

public class CombinaisonRecherche extends Combinaison{
	public String[] comparerCombinaison (int taille, int combinaison1[], int combinaison2[]) {
		int i=0;
        String tab3[]= new String [taille];
        for( i =0; i<=(taille-1);i++) {
        	if(combinaison1[i]==combinaison2[i]) {
        		tab3[i]="=";
        	}else if (combinaison1[i]>combinaison2[i]) {
        		tab3[i]="+";
        	}else {
        		tab3[i]="-";
        	}
        }
        return tab3;
            
	}
	public void genererProchaineCombinaison() {
		
	}
}
