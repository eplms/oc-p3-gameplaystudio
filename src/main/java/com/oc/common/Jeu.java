package com.oc.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.main.Main;
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
	private int modeDeveloppeur;
	private static final Logger LOG = LogManager.getLogger(Main.class);

	/**
	 * Méthode permettant de lancer la récupération des paramètres du jeu dans le fichier de configuration
	 * 	taille de la combinaison
	 * 	nombre max d'essais autorisés
	 * 	activation ou non du mode développeur
	 */
	public void initialiserParametresJeu() {		
		// initialisation de la taille de la combinaison à partir du fichier de configuration
		taille=lireTailleCombinaison();
		LOG.debug("taille combinaison :"+taille);
		// initialisation du nombre d'essai max autorisé à partir du fichier de configuration
		nombreEssai=lireNombreEssai();
		LOG.debug("nombre essai : "+nombreEssai);
		// initialisation du mode développeur à partir du fichier de configuration
		modeDeveloppeur=lireModeDeveloppeur();
		if(modeDeveloppeur==1){
			LOG.debug("Mode développeur activé");
		}else if(modeDeveloppeur==2){
			LOG.debug("Mode développeur désactivé");
		}else if(modeDeveloppeur==3) {
			LOG.warn("La configuration du mode developpeur est erroné : par défaut le mode développeur n'est pas activé");
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
	 *    1 : le mode développeur est activé
	 *    2 : le mode développeur est désactivé
	 *    3 : indique une erreur dans la configuration du mode développeur 
	 */
	private int lireModeDeveloppeur() {
		int modeDev=GestionConfiguration.lireModeDeveloppeur();
		return modeDev;
	}

	public int getTaille() {
		return taille;
	}

	public int getNombreEssai() {
		return nombreEssai;
	}

	public int getModeDeveloppeur() {
		return modeDeveloppeur;
	}
	
}
