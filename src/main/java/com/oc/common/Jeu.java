package com.oc.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.main.MainLog;
import com.oc.utilitaire.GestionConfiguration;

/**
 * Jeu est la classe abstraite permettant de gérer les jeux mastermind et recherche de manière commune
 * @author Emmanuel Plumas
 * @version 1.0
 * Juin 2019
 */
public abstract class Jeu implements IJeu{
	private int taille;
	private int nombreEssai;
	private boolean modeDeveloppeur;
	private static final Logger LOG = LogManager.getLogger(MainLog.class);

	/**
	 * Méthode permettant de lancer la récupération des paramètres du jeu dans le fichier de configuration
	 * 	taille de la combinaison
	 * 	nombre max d'essais autorisés
	 * 	activation ou non du mode développeur
	 */
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
	
	/**
	 * Méthode permettant de récupérater le nombre max d'essais autorisés dans le fichier de configuration
	 * 	@return nbTry nombre max d'essais autorisés
	 */
	private int lireNombreEssai() {
		int nbTry = GestionConfiguration.lireNombreEssai();
		return nbTry;
	}
	
	/**
	 * Méthode permettant de récupérater la taille des combinaisons dans le fichier de configuration
	 * 	@return nbDigit nombre de digits dont sont constitués les combinaisons
	 */
	private int lireTailleCombinaison() {
		int nbDigit = GestionConfiguration.lireTailleCombinaison();
		return nbDigit;
	}
	
	/**
	 * Méthode permettant de récupérater l'indication d'activation du mode développeur dans le fichier de configuration
	 * 	@return modDev 
	 *    true : le mode développeur est activé
	 *    false : le mode développeur est désactivé
	 */
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
