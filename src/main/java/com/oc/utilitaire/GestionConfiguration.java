package com.oc.utilitaire;

import java.util.ResourceBundle;

public class GestionConfiguration {
	// Déclaration objet configuration et lecture du fichier config.properties dans l'objet configuration
	// "config" est le nom du fichier .properties
	static ResourceBundle configuration = ResourceBundle.getBundle("config");
	
	/**
	 * Méthode permettant de lire le nombre de tentatives max autorisées indiquées dans  le fichier config.properties
	 * @return nombreEssai nombre de tentatives max autorisées
	 */
	
	public static int lireNombreEssai () {
		String nombreTry = configuration.getString("nombreTry");
		int nombreEssai=Integer.parseInt(nombreTry);
		return nombreEssai;
	}
	
	/**
	 * Méthode permettant de lire la taille des combinaisons à trouver indiquées dans le fichier config.properties
	 * @return tailleCombinaison taille des combinaisons
	 */
	public static int lireTailleCombinaison() {
		String nombreDigit = configuration.getString("nombreDigit");
		int tailleCombinaison =Integer.parseInt(nombreDigit);
		return tailleCombinaison;
	}
    
	/**
	 * Méthode permettant de lire l'indication de l'activation du mode développeur dans le fichier config.properties
	 * @return modeDeveloppeur
	 * 	true : si le mode developpeur est activé (oui)
	 * 	false : si le mode développeur n'est pas activé (non)
	 */
	public static boolean lireModeDeveloppeur() {
		boolean modeDeveloppeur=false;
		String modeDev= configuration.getString("modeDeveloppeur");
		if (modeDev.equals("oui")) {
			modeDeveloppeur = true;
		}else if (modeDev.contentEquals("non")) {
			modeDeveloppeur = false;
		}
		return modeDeveloppeur;
	}
}
