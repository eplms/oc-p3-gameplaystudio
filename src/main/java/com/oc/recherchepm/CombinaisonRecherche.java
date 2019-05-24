package com.oc.recherchepm;

import com.oc.common.Combinaison;

public class CombinaisonRecherche extends Combinaison{
	
	/**
	 * méthode de comparaison de deux combinaisons
	 * @return tableau contenant le resultat de la comparaison digit par digit
	 */
	public String[] comparerCombinaison (int taille, int combinaison1[], int combinaison2[]) {
		int i=0;
        String resultatComparaison[]= new String [taille];
        for( i =0; i<=(taille-1);i++) {
        	if(combinaison1[i]==combinaison2[i]) {
        		resultatComparaison[i]="=";
        	}else if (combinaison1[i]>combinaison2[i]) {
        		resultatComparaison[i]="+";
        	}else {
        		resultatComparaison[i]="-";
        	}
        }
        return resultatComparaison;
	}
	
	/**
	 * Méthode générant une nouvelle combinaison en fonction du résultat de la comparaison
	 * @param taille  taille de la combinaison
	 * @param nbTentative nombre de combinaisons tentée avant celle-ci
	 * @param combinaison1 combinaison  précédente
	 * @param resultatComparaison tableau de résultat de la comparaison précédente avec la solution
	 * @return
	 */
	public int[] genererProchaineCombinaison(int taille,int nbTentative, int combinaison1[], String resultatComparaison[]) {
    	int i=0;
		int prochaineCombinaison[]= new int[taille];
		CombinaisonRecherche nouvelle= new CombinaisonRecherche();
	    if (nbTentative == 0) { 
	    		prochaineCombinaison= nouvelle.genererCombinaisonAleatoire(taille);
	    	}else {
	    	for (i=0;i<=(taille-1);i++) {
	    		if(resultatComparaison[i].equals("=")) {
	    			prochaineCombinaison[i]=combinaison1[i];
	    		} else if (resultatComparaison[i].equals("+")) {
	    			prochaineCombinaison[i]=combinaison1[i]+1;
	    		} else {
	    			prochaineCombinaison[i]=combinaison1[i]-1;
	    		}
	    	}
	    }
	    return prochaineCombinaison;
	}
	
}



