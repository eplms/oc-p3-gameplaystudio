package com.oc.common;

public interface ICombinaison {

	// Mode défenseur & challenger & Duel
	public int[] genererCombinaisonAleatoire();
	public boolean estJuste(String resultatComparaison[]);
	
	// Mode Challenger & duel
	public int[] lireCombinaison (int taille);
	public void afficherResultatComparaison(String resultatComparaison[]);
	public String[] comparerCombinaison (int combinaison1[], int combinaison2[]);
	
	// Mode Défenseur & Duel
	public int[] genererProchaineCombinaison(int nbTentative, int combinaison1[], String resultatComparaison[]);
	public void afficherCombinaison(int combinaison[]);
	public String[] lireResultatComparaison();

}
