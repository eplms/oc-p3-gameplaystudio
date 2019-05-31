package com.oc.common;

public interface IMenu {
	public int lireChoixMenu();
	public void afficherMenuChoixJeu();
	public void afficherMenuChoixMode();
	public void afficherMenuFin(int jeu, int mode);
	public void afficherChoixJeuDebut(int choixJeu);
	public void afficherChoixModeDebut(int choixMode); 
	public void afficherChoixMenuFin(int choixMenuFin); 	
}
