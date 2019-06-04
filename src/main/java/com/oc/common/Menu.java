package com.oc.common;

import java.util.Scanner;

public abstract class Menu implements IMenu {	
	
	/**
	 * Méthode d'affichage d'un menu
	 * @param texte de contenu du menu
	 */
	
	public void afficherMenu (String texteMenu) {
		System.out.println(texteMenu);
	}
	
	/**
	 * Méthode de lecture d'un choix de menu en saisie clavier sous forme d'entier
	 * @return int entier saisie au clavier
	 */
	public int lireChoixMenu(int nombreItem) {
			Scanner saisie= new Scanner(System.in );
			int choixMenu = saisie.nextInt();
			if (choixMenu > nombreItem) {
				System.out.println("choix incorrect : vous devez saisir un nombre compris entre O et "+nombreItem);
		}	
		return choixMenu;
	}
}
