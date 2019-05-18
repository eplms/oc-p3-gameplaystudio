package com.oc.main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.utilitaire.GestionConfiguration;

public class Main {
	private static final Logger LOG = LogManager.getLogger(MainLog.class);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/**
		 * Lecture du nombre d'essais max pour trouver combinaison
		 */
		int nbTry = GestionConfiguration.lireNombreEssai();
	//	System.out.println("Le nombre max d'essais est de " + nbTry + " essais");
		LOG.debug("Le nombre max d'essais est de " + nbTry + " essais");
		/**
		 * Lecture de la taille de la combinaison à trouver en nombre de digits
		 */
		
		int nbDigit = GestionConfiguration.lireTailleCombinaison();
	//	System.out.println("La combinaison à trouver comporte " + nbDigit + " chiffres");
		LOG.debug("La combinaison à trouver comporte " + nbDigit + " chiffres");
		/**
		 * Lecture de l'activation du mode développeur
		 */
		
		boolean modeDev=GestionConfiguration.lireModeDeveloppeur();
		if(modeDev) {
		//	System.out.println("Le mode développeur est activé");
			LOG.debug("Le mode développeur est activé");
		} else 
		//	System.out.println("Le mode développeur est désactivé");
			LOG.debug("Le mode développeur est désactivé");
		}
		
	}

