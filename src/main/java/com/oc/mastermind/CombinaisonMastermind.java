package com.oc.mastermind;

import com.oc.common.Combinaison;

public class CombinaisonMastermind extends Combinaison {
	public void comparerCombinaison () {
		
	}
	public void afficherResultatComparaison(int taille, String comparaison[]) {
		System.out.println("-> Réponse : ");
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
	public void genererProchaineCombinaison() {
		
	}
	
}
