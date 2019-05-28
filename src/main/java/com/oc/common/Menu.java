package com.oc.common;

import java.util.Scanner;

public abstract class Menu implements IMenu {
	public int lireChoixMenu() {
		Scanner saisie= new Scanner (System.in);
		int choixMenu = saisie.nextInt();
		saisie.close();
		return choixMenu;
	}
}
