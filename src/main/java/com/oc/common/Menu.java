package com.oc.common;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.main.Main;

/**
 * Menu est la classe abstraite permettant de gérer les différents menu dans ce qu'ils ont de commun
 * @author Emmanuel Plumas
 * @version 1.0
 * Juin 2019
 */
public abstract class Menu implements IMenu {	
	Scanner saisie=new Scanner(System.in);
	private static final Logger LOG = LogManager.getLogger(Main.class);

	/**
	 * Méthode d'affichage d'un menu
	 * @param texteMenu texte de contenu du menu
	 */
	public void afficherMenu (String texteMenu) {
		System.out.println(texteMenu);
	}
	
	/**
	 * Méthode de lecture d'un choix de menu en saisie clavier sous forme d'entier
	 * @param nombreItem nombre de choix possible dans le menu
	 * @return choixMenu entier saisie au clavier correspondant au menu
	 */
	public int lireChoixMenu(int nombreItem) {
		boolean saisieCorrecte=false;
		int choixMenu = 0;
		while(!saisieCorrecte) {
			try {
				choixMenu = saisie.nextInt();
				if (choixMenu<1 || choixMenu > nombreItem) {
					LOG.warn(" Mauvais choix de Menu : "+choixMenu);
					System.out.println("choix incorrect ! ");
					System.out.println("Veuillez saisir un nombre entre 1 et "+nombreItem+" pour indiquer votre choix");
					saisieCorrecte=false;
				}else{
					saisieCorrecte=true;
				}
				// vidage du buffer
				saisie.nextLine();
			}catch(InputMismatchException e) {
				LOG.warn(" Mauvais choix de Menu. Saisie d'un signe différent d'un entier");
				System.out.println(("Attention ! Vous n'avez pas saisie un nombre !"));
				System.out.println("Vous devez impérativement saisir un nombre entier !");
				System.out.println("Veuillez saisir un nombre entre 1 et "+nombreItem+" pour indiquer votre choix");
				saisieCorrecte=false;
				saisie.nextLine();
			}
		}
		return choixMenu;
	}
}
