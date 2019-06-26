package com.oc.common;

public interface IJeu {
	// accesseur attributs classe abstraite
	public int getTaille();
	public int getNombreEssai();
	public int getModeDeveloppeur();

	//Méthode de classe abstraite Jeu
	public void initialiserParametresJeu();

	//Méthode de classe JeuRecherche et JeuMastermind implémentées différement
	public void lancerJeu(int choixMode);
}
