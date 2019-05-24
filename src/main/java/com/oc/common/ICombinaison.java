package com.oc.common;

public interface ICombinaison {

	public int[] genererCombinaisonAleatoire(int taille);
	public int[] lireCombinaison (int taille);
	public void afficherCombinaison(int taille, int combinaison[]);
	public String[] comparerCombinaison (int taille, int combinaison1[], int combinaison2[]);
	public int[] genererProchaineCombinaison(int taille,int nbTentative, int combinaison1[], String resultatComparaison[]);
	public boolean estJuste(int taille, String resultatComparaison[]);
}
