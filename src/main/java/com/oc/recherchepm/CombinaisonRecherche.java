package com.oc.recherchepm;

import java.util.Scanner;

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
	 * @return nouvelle combinaison à partir du résultat
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
	
	/**
	 * Méthode vérifiant sur la combinaison estJuste à partir du résultat de la comparaison
	 * @taille : taille de la combinaison
	 * @resultatComparaison : tableau dans lequel est stocké le résultat de la comparaison
	 * @return : 
	 */
	public boolean estJuste (int taille, String resultatComparaison[]) {
		boolean resultat;
		int i=0;
		int digit=0;
		for (i=0;i<=taille-1;i++) {
			if(resultatComparaison[i].equals("=")){
				digit=digit+1;
			}
		}
		if( digit==taille) {
			resultat=true;
		}else {
			resultat=false;
		}
		return resultat;
	}
	/**
	 * Méthode permettant à l'utilisateur de saisir le resultat de la comparaison entre la
	 * propo de l'IA et sa combinaison scrète
	 * @return resultat de la comparaison saisie
	 */
	public String[] lireResultatComparaison() {
		System.out.println("-> réponse : ");
		Scanner saisie = new Scanner (System.in);
		String saisieComparaison = saisie.nextLine();
		/* découpage de la chaine en caractère et mise dans un tableau */
		String resultatComparaison[]=saisieComparaison.split("");
		saisie.close();
		return resultatComparaison;
	}

	/**
	 *Méthode affichant le résultat de la comparaison entre la proposition du joueur et la combinaison secrete
	 * @taille : taille de la combinaison
	 * @tableau dans lequel sont stockés les résultats de la comparaison digit par digit
	 */
	public void afficherResultatComparaison(int taille, String resultatComparaison[]) {
		int i=0;
		for (i=0;i<=taille-1;i++) {
			System.out.print(resultatComparaison[i]);
			System.out.println("");
		}
	}
}
	


