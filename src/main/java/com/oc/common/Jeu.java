package com.oc.common;

import com.oc.utilitaire.GestionConfiguration;

public abstract class Jeu implements IJeu{
	private int taille;
	private int nombreEssai;
	private boolean modeDeveloppeur;
		
	protected void initialiserParametreJeu() {		
		// initialisation de la taille de la combinaison à partir du fichier de configuration
		setTaille(lireTailleCombinaison());
		// initialisation du nombre d'essai max autorisé à partir du fichier de configuration
		setNombreEssai(lireNombreEssai());
		// initialisation du mode développeur à partir du fichier de configuration
		setModeDeveloppeur(lireModeDeveloppeur());
	}		
	
	private int lireNombreEssai() {
		int nbTry = GestionConfiguration.lireNombreEssai();
		return nbTry;
	}
	
	private int lireTailleCombinaison() {
		int nbDigit = GestionConfiguration.lireTailleCombinaison();
		return nbDigit;
	}
	
	private boolean lireModeDeveloppeur() {
		boolean modeDev=GestionConfiguration.lireModeDeveloppeur();
		return modeDev;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getNombreEssai() {
		return nombreEssai;
	}

	public void setNombreEssai(int nombreEssai) {
		this.nombreEssai = nombreEssai;
	}

	public boolean isModeDeveloppeur() {
		return modeDeveloppeur;
	}

	public void setModeDeveloppeur(boolean modeDeveloppeur) {
		this.modeDeveloppeur = modeDeveloppeur;
	}
	
	
}
