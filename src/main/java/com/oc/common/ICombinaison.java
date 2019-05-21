package com.oc.common;

public interface ICombinaison {

	public int[] genererCombinaisonAleatoire(int taille);
	public int[] lireCombinaison (int taille);
	public void afficherCombinaison(int tab[], int taille);
	public String [] comparerCombinaison(int taille, int combinaison1[], int combinaison2[]);
	public void genererProchaineCombinaison();
	
}
