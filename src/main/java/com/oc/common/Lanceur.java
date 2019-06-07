package com.oc.common;

import com.oc.recherchepm.JeuRecherche;

public class Lanceur{

	/**
	 * Méthode de gestion du lancement des menus et de lecture des choix utilisateurs 
	 */
	
	public void lancerMenu(){
		Boolean finDuJeu=false;
		int choixJeux;
		int choixMode;
		int choixFin;
		do {
			choixJeux=lancerMenuJeu();
			choixMode=lancerMenuMode();
			do {
				lancerJeu(choixJeux,choixMode);
				choixFin=lancerMenuFin();
			}while (choixFin==1);
			if(choixFin==3) {
				finDuJeu=true;
			}
		}while(!finDuJeu); 
	}
		
	/**
	 * Affichage du menu de choix du jeu et lecture du choix utilisateur
	 * @return Choix du jeu fait par l'utilisateur
	 */
	
	private int lancerMenuJeu() {
		String jeuxDebut="Bienvenue \n\n"+"A quel jeu voulez-vous jouer ?\n\n"+"1- Recherche+/- \n"+"2- Mastermind \n"+"3- quitter";
		int nombreItemJeu=3;
		int choixJeux;
		ContenuMenu menuJeux = new ContenuMenu();
		menuJeux.setNombreItem(nombreItemJeu);
		menuJeux.setTexteMenu(jeuxDebut);
		menuJeux.afficherMenu(menuJeux.getTexteMenu());
		choixJeux= menuJeux.lireChoixMenu(menuJeux.getNombreItem());
		return choixJeux;
	}
	
	/**
	 * Affichage du menu de choix de mode et lecture du choix utilisateur
	 * @return mode de jeu choisi par utilisateur
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
	 * Affichage du menu de fin et lecture du choix utilisateur
	 * @return choix de l'utilisateur
	 */
	
	private int lancerMenuFin() {
		String jeuxFin="Que souhaitez-vous faire? \n"+"1- Rejouer à l'identique ?\n"+"2- Changer de jeu et/ou de mode\n"+"3- quitter\n";
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
	 * lancement du jeu choisi dans le mode choisi
	 * @param choixJeux correspond au jeu choisi
	 * @param choixMode correspond au mode choisi
	 */
	
	private void lancerJeu(int choixJeux, int choixMode) {
		if (choixJeux==1) {
			JeuRecherche jeu1= new JeuRecherche();
			jeu1.lancerJeu(choixMode);
		} else if (choixJeux==2) {
			System.out.println("lancement du jeu Mastermind");
		}
	}
}

	