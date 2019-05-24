package com.oc.common;

public interface ICombinaison {

	// Mode défenseur & challenger & Duel
	public int[] genererCombinaisonAleatoire(int taille);
	public boolean estJuste(int taille, String resultatComparaison[]);
	
	// Mode Challenger & duel
	public int[] lireCombinaison (int taille);
	public void afficherResultatComparaison(int taille, String resultatComparaison[]);
	public String[] comparerCombinaison (int taille, int combinaison1[], int combinaison2[]);
	
	// Mode Défenseur & Duel
	
	public int[] genererProchaineCombinaison(int taille,int nbTentative, int combinaison1[], String resultatComparaison[]);
	public void afficherCombinaison(int taille, int combinaison[]);
	public String[] lireResultatComparaison();

}
