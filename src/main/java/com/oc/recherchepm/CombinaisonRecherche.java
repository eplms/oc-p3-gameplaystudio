package com.oc.recherchepm;

import java.util.Scanner;

import com.oc.common.Combinaison;

public class CombinaisonRecherche extends Combinaison{
	Scanner saisieComp = new Scanner (System.in);

	public CombinaisonRecherche(int taille) {
		super(taille);
	}

	/**
	 * méthode de comparaison de deux combinaisons
	 * @return tableau contenant le resultat de la comparaison digit par digit
	 * @param 1 : combinaison à trouver
	 * @param 2: proposition de l'utilisateur
	 */
	public String[] comparerCombinaison (int combinaison1[], int proposition[]) {
        String resultatComparaison[]= new String [taille];
        for(int i =0; i<=(taille-1);i++) {
        	if(combinaison1[i]==proposition[i]) {
        		resultatComparaison[i]="=";
        	}else if (combinaison1[i]>proposition[i]) {
        		resultatComparaison[i]="+";
        	}else {
        		resultatComparaison[i]="-";
        	}	
        }
        return resultatComparaison;
	}
	
	/**
	 * Méthode générant une nouvelle combinaison en fonction du résultat de la comparaison
	 * @param nbTentative nombre de combinaisons tentée avant celle-ci
	 * @param combinaison1 combinaison  précédente
	 * @param resultatComparaison tableau de résultat de la comparaison précédente avec la solution
	 * @return nouvelle combinaison à partir du résultat
	 */
	public int[] genererProchaineCombinaison(int nbTentative, int combinaison1[], String resultatComparaison[]) {
		int prochaineCombinaison[]= new int[taille];
	    if (nbTentative == 0) { 
	    		prochaineCombinaison = genererCombinaisonAleatoire();
	    	}else {
	    	for (int i=0;i<=(taille-1);i++) {
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
	 * @resultatComparaison : tableau dans lequel est stocké le résultat de la comparaison
	 * @return : Boolean indiquant sur la comparaison correspond à une combinaison juste ou fausse
	 */
	public boolean estJuste (String resultatComparaison[]) {
		boolean resultat;
		int digit=0;
		for (int i=0;i<=taille-1;i++) {
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
		String []resultatComparaison=new String[taille];
		System.out.println("\n-> votre réponse : ");
		// Valider la saisie de l'utilisateur a-t-il bien saisi des + - ou = uniquement en parcourant la chaine et comparer les caractères
		String saisieComparaison = saisieComp.nextLine();
		//saisie.close();
		// test de la taille de la chaine de caractère saisie		
		if (saisieComparaison.length()!=taille) {
			throw new IllegalArgumentException("Vous devez saisir "+taille+" signes =,+ ou -");
		}
		/* découpage de la chaine en caractère et mise dans un tableau */
		for (int i=0; i<saisieComparaison.length();i++) {
			/* ajout de chaine de caractère vide conversion implicite en chaine de caratère*/
			resultatComparaison[i]=saisieComparaison.charAt(i)+"";
			//Gestion d'exception si saisie autre que = ou + ou - 
			if (!((resultatComparaison[i].equals("="))||(resultatComparaison[i].equals("+"))||(resultatComparaison[i].equals("-")))) {
				throw new IllegalArgumentException ("Vous devez saisir une combinaison de =, + ou - !!!");
			}
		}
		return resultatComparaison;
	}

	/**
	 *Méthode affichant le résultat de la comparaison entre la proposition du joueur et la combinaison secrete
	 * @tableau dans lequel sont stockés les résultats de la comparaison digit par digit
	 */
	public void afficherResultatComparaison(String resultatComparaison[]) {
		System.out.println("Résultat :");
		for (int i=0;i<=taille-1;i++) {
			System.out.print(resultatComparaison[i]);
		}
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
}
	


