package com.oc.common;

public interface IJeu {
	public int getTaille();
	public void setTaille(int taille);
	public int getNombreEssai();
	public void setNombreEssai(int nombreEssai);
	public boolean isModeDeveloppeur();
	public void setModeDeveloppeur(boolean modeDeveloppeur);
	public void lancerJeuRecherche(int choixMode);
}
