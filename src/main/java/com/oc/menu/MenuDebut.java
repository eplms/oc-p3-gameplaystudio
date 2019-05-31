package com.oc.menu;

import java.util.Scanner;

import com.oc.common.Menu;

public class MenuDebut extends Menu{
	
	public void afficherMenuChoixJeu() {
		System.out.println("Bienvenue dans le jeu !");
		System.out.println();
		System.out.println("A quel jeu voulez-vous jouer ?");
		System.out.println();
		System.out.println("1 - Recherche +/-");
		System.out.println("2 - Mastermind");
		System.out.println();
		System.out.println("Quel est votre choix ?");
	}
	
	public void afficherMenuChoixMode() {
		System.out.println("Dans quel mode souhaitez-vous jouer ?");
		System.out.println();
		System.out.println("1 - Challenger");
		System.out.println("2 - Défenseur");
		System.out.println("3 - Duel");
		System.out.println();
		System.out.println("Quel est votre choix ?");
	}	
	
	public static void afficherChoixJeuDebut(int choixJeu) {
		String jeu;
		if(choixJeu==1) {
			jeu="Recherche +/-";
		} else {
			jeu="Mastermind";
		}
		System.out.println("Vous avez choisi de jouer au jeu: "+jeu);
	}

	public static void afficherChoixModeDebut(int choixMode) {
		String mode;
		if(choixMode==1) {
			mode="Challenger";
		}else if(choixMode==2) {
			mode="Défenseur";
		} else {
			mode="Duel";
		}
		
		System.out.println("Vous avez choisi de jouer en mode "+mode+".");		
	}
}
