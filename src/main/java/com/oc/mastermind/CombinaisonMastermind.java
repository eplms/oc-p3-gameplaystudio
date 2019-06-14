package com.oc.mastermind;

import com.oc.common.Combinaison;

public class CombinaisonMastermind extends Combinaison {
	public CombinaisonMastermind(int taille) {
		super(taille);
	}

	/**
	 * méthode de comparaison de deux combinaisons
	 * @return tableau contenant le resultat de la comparaison
	 * premier digit Bien placé
	 * Deuxième digit présent
	 */
	
	public String[] comparerCombinaison (int combinaison1[], int combinaison2[]){
		int nombreBienPlaces=0;
		int nombrePresents=0;
		int i=0;
		Boolean[] masqueCombinaison1 = new Boolean[taille];
		Boolean[] masqueCombinaison2= new Boolean[taille];
		String comparaison[]=new String[taille];
		
		// Initialisation des tableaux
		for(i=0;i<taille;i++) {
			masqueCombinaison1[i]=false;
			masqueCombinaison2[i]=false;
		}
		
		for (i=0; i<= taille-1; i++) {
			if (combinaison1[i]==combinaison2[i]) {
				nombreBienPlaces=nombreBienPlaces+1;
				masqueCombinaison1[i]= true;
				masqueCombinaison2[i]= true;
			}
		}
		int j=0;
		int k=0;
		for (j=0; j<taille;j++) {
			for(k=0;k<taille;k++) {
				if((j!=k) && (masqueCombinaison1[j]==false) && (masqueCombinaison2[k]==false)){
					if(combinaison1[j]==combinaison2[k]){
						nombrePresents=nombrePresents+1;
						masqueCombinaison1[j]=true;
						masqueCombinaison2[k]=true;
					}
				}
			}
		}
		comparaison[0]=Integer.toString(nombreBienPlaces);
		comparaison[1]=Integer.toString(nombrePresents);
		//comparaison[0]=String.valueOf(nombreBienPlaces);
		//comparaison[1]=String.valueOf(nombrePresents);
		return comparaison;
	}
	
	/**
	 * Méthode affichant le résultat de la combinaison
	 * @taille : taille de la combinaison
	 * @comparaison : tableau contenant le résultat de la comparaison
	 */
	public void afficherResultatComparaison(String comparaison[]) {
		System.out.println("-> Réponse : ");
		// Transformation des String en Integer
		int nombreBienPlaces = Integer.parseInt(comparaison[0]);
		int nombrePresents= Integer.parseInt(comparaison[1]);
		if (nombreBienPlaces == 0 && nombrePresents == 0) {
			System.out.println("Aucun nombre bien placé, aucun présent !");
		} else if(nombreBienPlaces==0 && nombrePresents!=0) {
			System.out.println(nombrePresents+" présent(s), aucun bien placé");
		} else if (nombreBienPlaces !=0 && nombrePresents ==0) {
			System.out.println(nombreBienPlaces+" bien placé(s) !");
		} else if (nombreBienPlaces !=0 && nombrePresents !=0) {
			System.out.println(nombreBienPlaces+" bien places et "+nombrePresents+" présent(s)");
		}
	}
	
	public int[] genererProchaineCombinaison(int nbTentative, int combinaison1[], String resultatComparaison[]) {
		int prochaineCombinaison[] = null;
		if (nbTentative==0) {
			prochaineCombinaison= genererCombinaisonAleatoire();
		}
		return prochaineCombinaison;
	}
	
	
	public boolean estJuste (String resultatComparaison[]) {
		boolean resultat=false;
		if (Integer.parseInt(resultatComparaison[0])==taille) {
			resultat=true;
		}else {
			resultat=false;
		}
		return resultat;
		
	}
	
	
	public String[] lireResultatComparaison() {
		String []resultatComparaison=new String[taille];

		return resultatComparaison;
		}
	
}
