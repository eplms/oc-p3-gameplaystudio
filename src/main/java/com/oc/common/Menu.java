package com.oc.common;

import java.util.Scanner;

public abstract class Menu implements IMenu {
	
	
	/**
	 * Méthode de lecture d'un choix de menu en saisie clavier sous forme d'entier
	 * @return int entier saisie au clavier
	 */
	public int lireChoixMenu() {
		Scanner saisie= new Scanner (System.in);
		int choixMenu = saisie.nextInt();
//		saisie.close();
// Problème : si je laisse saisie.close() alors le main bug 
		return choixMenu;
	}
}
