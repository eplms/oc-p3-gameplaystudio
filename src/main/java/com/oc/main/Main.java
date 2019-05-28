package com.oc.main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.menu.MenuDebut;
import com.oc.utilitaire.GestionConfiguration;

public class Main {
	private static final Logger LOG = LogManager.getLogger(MainLog.class);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int choixJeu;
		int choixMode;
		String jeu=null;
		String mode=null;
		MenuDebut menu1= new MenuDebut();
		menu1.afficherMenuChoixJeu();
		choixJeu= menu1.lireChoixMenu();
		
		
		if(choixJeu==1) {
			jeu="Recherche +/-";
		} else {
			jeu="Mastermind";
		}
		System.out.println("Vous avez choisi de jouer au jeu: "+jeu);
		
		MenuDebut menu2=new MenuDebut();
		menu2.afficherMenuChoixMode();
		choixMode=menu2.lireChoixMenu();
		
		if(choixMode==1) {
			mode="Challenger";
		}else if(choixMode==2) {
			mode="Défenseur";
		} else {
			mode="Duel";
		}
		
		System.out.println("Vous avez choisi de jouer en mode "+mode+".");
		
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

