package com.oc.common;

public interface IJeu {
	// accesseur attributs classe abstraite
	public int getTaille();
	public void setTaille(int taille);
	public int getNombreEssai();
	public void setNombreEssai(int nombreEssai);
	public boolean isModeDeveloppeur();
	public void setModeDeveloppeur(boolean modeDeveloppeur);

	//Méthode de classe abstraite Jeu
	public void initialiserParametresJeu();

	//Méthode de classe JeuRecherche et JeuMastermind implémentées différement
	public void lancerJeu(int choixMode);
}
