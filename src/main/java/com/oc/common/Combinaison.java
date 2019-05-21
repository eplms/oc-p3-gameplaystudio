package com.oc.common;

import java.util.Random;
import java.util.Scanner;

public abstract class Combinaison implements ICombinaison{
	int taille;
	
	/** Méthode de génération aléatoire de combinaison
	 * @return tableau d'entier constituant la combinaison	
	 */
	public int[] genererCombinaisonAleatoire(int taille) {
		int i;
		double n;
		int t[] = new int[taille];
		for ( i =0;i<=taille-1; i++) {
			// génération aléatoire d'un nombre entre 0 et 1)
			n=Math.random();
			//transformation de ce nombre en entier compris entre 0 et 9
			t[i]=(int)(n*(9-0)+1);
		}
		return t;
	}
	 
	/**
	 * Méthode permettant d'afficher une combinaison
	 * @param taille de la combinaison
	 * @param combinaison tableau contenant la combinaison à afficher
	 */
	public void afficherCombinaison(int taille, int combinaison[]) {
		int i=0;
		for (i=0; i<=(taille-1); i++) {
			System.out.print(combinaison[i]);
		}
	}
	
	/**
	 * Méthode permettant la lecture d'une suite de nombres saisis au clavier
	 * @param taille
	 * @return tableau d'entier contenant la combinaison à afficher
	 */
	
	public int[] lireCombinaison (int taille){
		int i=0;
		int t[] = new int[taille];
		System.out.print("Proposition : ");
		
		Scanner saisie = new Scanner (System.in);
		String proposition = saisie.nextLine();
		
		if (proposition.length()!=taille) {
			System.out.println("vous devez entrer une combinaison de "+taille+" chiffres");
		} else {
			for (i=0; i<=proposition.length()-1;i++) {
				t[i]=proposition.charAt(i)-48;
			}
		}
		return t;
	}
	
}
