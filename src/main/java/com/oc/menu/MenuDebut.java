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
}
