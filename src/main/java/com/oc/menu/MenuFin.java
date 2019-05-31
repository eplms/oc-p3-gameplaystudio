package com.oc.menu;

import com.oc.common.Menu;

public class MenuFin extends Menu{
	
	/**
	 * Méthode d'affichage du menu à la fin du jeu
	 * @param int jeu correspond au jeu choisi initialement par utilisateur
	 * @param int mode correspond au mode de jeu choisi initialement par utilisateur
	 */
	public void afficherMenuFin(int jeu, int mode) {
		String intituleJeu;
		String intituleMode;
		System.out.println("");
		System.out.println("Que souhaitez-faire ?");
		if(jeu==1) {
			intituleJeu="Recherche +/-";
		} else {
			intituleJeu="Mastermind";
		}
		if(mode==1) {
			intituleMode="Challenger";
		}else if(mode==2) {
			intituleMode="Défenseur";
		} else {
			intituleMode="Duel";
		}
		System.out.println("1- Vous souhaitez rejouer à "+intituleJeu+" en mode "+intituleMode+" ?");
		System.out.println("2- Vous souhaitez jouer à un autre jeu et/ou dans un autre mode ?");
		System.out.println("");
	}
	
	/**
	 * Méthode affichant le choix fait par utilisateur à la fin du jeu
	 * @param int choixMenuFin entier correspondant au choix saisi par utilisateur
	 */
	public void afficherChoixMenuFin(int choixMenuFin) {
		String choixMenu = null;
		if(choixMenuFin==1) {
			choixMenu="Vous avez choisi de jouer au même jeu";
		}else if(choixMenuFin==2) {
			choixMenu="Vous avez choisi de jouer à un autre jeu et/ou dans un autre mode";
		} else {
			throw new IllegalArgumentException ("Vous devez choisir 1 ou 2");
		}
		System.out.println("");
		System.out.println(choixMenu);		
		
	}
	@Override
	public void afficherMenuChoixJeu() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afficherMenuChoixMode() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afficherChoixJeuDebut(int choixJeu) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afficherChoixModeDebut(int choixMode) {
		// TODO Auto-generated method stub
		
	}
}
