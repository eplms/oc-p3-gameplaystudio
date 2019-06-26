package com.oc.utilitaire;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.main.Main;

/**
 * GestionConfiguration est la classe permettant de lire des données du fichier de configuration
 * @author Emmanuel Plumas
 * @version 1.0
 * Juin 2019
 */
public class GestionConfiguration {
	// Déclaration objet configuration et lecture du fichier config.properties dans l'objet configuration
	// "config" est le nom du fichier .properties
	static ResourceBundle configuration = ResourceBundle.getBundle("config");
	private static final Logger LOG = LogManager.getLogger(Main.class);
	/**
	 * Méthode permettant de lire le nombre de tentatives max autorisées indiquées dans  le fichier config.properties
	 * @return nombreEssai nombre de tentatives max autorisées
	 */
	
	public static int lireNombreEssai () {
		String nombreTry = configuration.getString("nombreTry");
		int nombreEssai;
		try {
			nombreEssai=Integer.parseInt(nombreTry);
		}
		catch( NumberFormatException ex) {
			System.out.println("la configuration du nombre d'essai possible est erronée");
			System.out.println("le nombre d'essais autorisés par défaut est de 10");
			LOG.warn(" Paramétrage du nombre d'essais max dans config.properties erroné : valeur par défaut utilisée ");
			nombreEssai=10;
		}		
		return nombreEssai;
	}
	
	/**
	 * Méthode permettant de lire la taille des combinaisons à trouver indiquées dans le fichier config.properties
	 * @return tailleCombinaison taille des combinaisons
	 */
	public static int lireTailleCombinaison() {
		String nombreDigit = configuration.getString("nombreDigit");
		int tailleCombinaison;
		try {
			tailleCombinaison =Integer.parseInt(nombreDigit);
		}catch(NumberFormatException ex) {
			System.out.println("la configuration de la taille de la combinaison est erronée");
			System.out.println("la taille de la combinaison par défaut est de 4 digits");
			LOG.warn(" Paramétrage de la taille de la combinaison dans config.properties erroné : valeur par défaut utilisée ");
			tailleCombinaison=4;
		}
		
		return tailleCombinaison;
	}
    
	/**
	 * Méthode permettant de lire l'indication de l'activation du mode développeur dans le fichier config.properties
	 * @return modeDeveloppeur
	 * 	true : si le mode developpeur est activé (oui)
	 * 	false : si le mode développeur n'est pas activé (non)
	 */
	public static int lireModeDeveloppeur() {
		int modeDeveloppeur=0;
		String modeDev;
		modeDev= configuration.getString("modeDeveloppeur");
		if (modeDev.equals("oui")) {
			modeDeveloppeur = 1;
		}else if (modeDev.equals("non")) {
			modeDeveloppeur = 2;
		}else {
			modeDeveloppeur=3;
		}
		return modeDeveloppeur;
	}
}
