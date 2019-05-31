package com.oc.menu;

import com.oc.common.Menu;

public class MenuDebut extends Menu{
	
	public void afficherMenuChoixJeu() {
		System.out.println("Bienvenue dans le jeu !");
		System.out.println();
		System.out.println("A vous de choisir le jeu auquel vous voulez jouer !");
		System.out.println();
		System.out.println("1 - Recherche +/-");
		System.out.println("2 - Mastermind");
		System.out.println();
		System.out.println("Quel est votre choix ?");
		System.out.println("");
	}
	
	public void afficherMenuChoixMode() {
		System.out.println("");
		System.out.println("Dans quel mode souhaitez-vous jouer ?");
		System.out.println();
		System.out.println("1 - Challenger");
		System.out.println("2 - Défenseur");
		System.out.println("3 - Duel");
		System.out.println();
		System.out.println("Quel est votre choix ?");
		System.out.println("");
	}	
	
	public void afficherChoixJeuDebut(int choixJeu) {
		String jeu;
		if(choixJeu==1) {
			jeu="Recherche +/-";
		} else if (choixJeu==2){
			jeu="Mastermind";
		} else {
			throw new IllegalArgumentException ("Vous devez choisir 1 ou 2");
			}
		System.out.println("");
		System.out.println("Vous avez choisi de jouer au jeu: "+jeu);
	}

	public void afficherChoixModeDebut(int choixMode) {
		String mode;
		if(choixMode==1) {
			mode="Challenger";
		}else if(choixMode==2) {
			mode="Défenseur";
		} else if (choixMode==3){
			mode="Duel";
		} else {
			throw new IllegalArgumentException ("Vous devez choisir 1, 2 ou 3");
		}
		System.out.println("");
		System.out.println("Vous avez choisi de jouer en mode "+mode+".");		
	}

	@Override
	public void afficherMenuFin(int jeu, int mode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherChoixMenuFin(int choixMenuFin) {
		// TODO Auto-generated method stub
		
	}

}
