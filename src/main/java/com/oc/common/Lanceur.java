package com.oc.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.main.Main;
import com.oc.mastermind.JeuMastermind;
import com.oc.recherchepm.JeuRecherche;
import com.oc.utilitaire.GestionConfiguration;


/**
 * Lanceur est la classe permettant de lancer les différents menus
 * @author Emmanuel Plumas
 * @version 1.0
 * Juin 2019
 */
public class Lanceur{
	private static final Logger LOG = LogManager.getLogger(Main.class);

	/**
	 * Méthode permettant la gestion du lancement des menus et de lecture des choix utilisateurs 
	 */
	public void lancerMenu(){
		Boolean finDuJeu=false;
		int choixJeux;
		int choixMode;
		int choixFin;
		do {
			choixJeux=lancerMenuJeu();
			LOG.debug(" choix de jeu : "+choixJeux);
			if (choixJeux!=3) {
				choixMode=lancerMenuMode();
				LOG.debug(" choix de Mode : "+choixMode);
				if(choixMode!=4) {
					lancerJeu(choixJeux,choixMode);
					choixFin=lancerMenuFin();
					LOG.debug(" choix de fin : "+choixFin);
					while(choixFin==1) {
						lancerJeu(choixJeux,choixMode);
						choixFin=lancerMenuFin();
						LOG.debug(" choix de fin : "+choixFin);
					}
					if(choixFin==3) {
						finDuJeu=true;
					}
				}else {
					finDuJeu=true;
				}
			}else {
				finDuJeu=true;
			}
		}while(!finDuJeu); 
	}
		
	/**
	 * Methode gérant le menu de choix du jeu
	 * 	Affichage du menu de choix du jeu 
	 *  Lecture du choix de jeu par l'utilisateur
	 * @return choixJeux Choix du jeu fait par l'utilisateur
	 */
	private int lancerMenuJeu() {
		String jeuxDebut="Bienvenue \n\n"+"A quel jeu voulez-vous jouer ?\n\n"+"1- Recherche+/- \n"+"2- Mastermind \n"+"3- quitter";
		int nombreItemJeu=3;
		int choixJeux;
		ContenuMenu menuJeux = new ContenuMenu();
		menuJeux.setNombreItem(nombreItemJeu);
		menuJeux.setTexteMenu(jeuxDebut);
		menuJeux.afficherMenu(menuJeux.getTexteMenu());
		int modeDeveloppeurActif=verifierModeDeveloppeur();
		if (modeDeveloppeurActif==1) {
			System.out.println("\nRappel : le mode développeur est activé !");
		} else if(modeDeveloppeurActif==2){
			System.out.println("\n (Le mode développeur n'est pas activé)");
		} else if(modeDeveloppeurActif==3) {
			System.out.println("\nLa configuration du mode développeur est erroné");
			System.out.println("La configuration active est la configuration par défaut (mode développeur désactivé)!");
		}
		choixJeux= menuJeux.lireChoixMenu(menuJeux.getNombreItem());
		return choixJeux;
	}
	
	/**
	 * Methode gérant le menu de choix de mode de jeu
	 * 	Affichage du menu de choix du jeu ( Challenger, défenseur ou duel)
	 *  Lecture du choix de jeu par l'utilisateur
	 * @return choixMode Choix du mode de jeu fait par l'utilisateur
	 */
	
	private int lancerMenuMode() {
		String jeuxMode="\nDans quel mode souhaitez-vous jouer ? \n\n"+"1- Challenger\n"+"2- Défenseur \n"+"3- Duel \n"+"4- quitter";
		int nombreItemMode=4;
		int choixMode;
		ContenuMenu menuMode = new ContenuMenu();
		menuMode.setNombreItem(nombreItemMode);
		menuMode.setTexteMenu(jeuxMode);
		menuMode.afficherMenu(menuMode.getTexteMenu());
		choixMode= menuMode.lireChoixMenu(menuMode.getNombreItem());
		return choixMode;
	}
	
	/**
	 * Methode gérant le menu de choix à la fin du jeu
	 * 	Affichage du menu de choix en fin de jeur (rejouer à l'identique, rejouer différement ou quitter) 
	 *  Lecture du choix de l'utilisateur
	 * @return choixFin Choix fait par l'utilisateur
	 */
	
	private int lancerMenuFin() {
		String jeuxFin="\nQue souhaitez-vous faire? \n"+"1- Rejouer à l'identique ?\n"+"2- Changer de jeu et/ou de mode ?\n"+"3- quitter ?\n";
		int nombreItemFin=3;
		int choixFin;
		ContenuMenu menuFin = new ContenuMenu();
		menuFin.setNombreItem(nombreItemFin);
		menuFin.setTexteMenu(jeuxFin);
		menuFin.afficherMenu(menuFin.getTexteMenu());
		choixFin= menuFin.lireChoixMenu(menuFin.getNombreItem());
		return choixFin;
	}
	/**
	 * Méthode lançant le jeu choisi dans le mode choisi par l'utilisateur
	 * @param choixJeux correspond au jeu choisi
	 * @param choixMode correspond au mode choisi
	 */
	private void lancerJeu(int choixJeux, int choixMode) {
		if (choixJeux==1) {
			JeuRecherche jeu1= new JeuRecherche();
			jeu1.lancerJeu(choixMode);
		} else if (choixJeux==2) {
			JeuMastermind jeu2=new JeuMastermind();
			jeu2.lancerJeu(choixMode);
		}
	}
	
	/**
	 * Méthode permettant de lire l'indication de l'activation du mode développeur dans le fichier config.properties
	 * @return modeDev
	 * 	1 : si le mode developpeur est activé (oui)
	 * 	2 : si le mode développeur n'est pas activé (non)
	 *  3 : si l'indication du mode développeur est erronnée 
	 */
	private int verifierModeDeveloppeur() {
		int modeDev=GestionConfiguration.lireModeDeveloppeur();
		return modeDev;
		}
}

	