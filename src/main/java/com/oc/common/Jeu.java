package com.oc.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.main.MainLog;
import com.oc.utilitaire.GestionConfiguration;

public abstract class Jeu implements IJeu{
	private int taille;
	private int nombreEssai;
	private boolean modeDeveloppeur;
	private static final Logger LOG = LogManager.getLogger(MainLog.class);

	
	public void initialiserParametresJeu() {		
		// initialisation de la taille de la combinaison à partir du fichier de configuration
		setTaille(lireTailleCombinaison());
		LOG.debug("taille combinaison :"+lireTailleCombinaison());
		// initialisation du nombre d'essai max autorisé à partir du fichier de configuration
		setNombreEssai(lireNombreEssai());
		LOG.debug("nombre essai : "+lireNombreEssai());
		// initialisation du mode développeur à partir du fichier de configuration
		setModeDeveloppeur(lireModeDeveloppeur());
		if(lireModeDeveloppeur()){
			LOG.debug("Mode développeur activé");
		}else {
			LOG.debug("Mode développeur désactivé");
		}

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
