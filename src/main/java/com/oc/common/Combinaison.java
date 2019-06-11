package com.oc.common;

import java.util.Scanner;

public abstract class Combinaison implements ICombinaison{
	protected int taille;
	protected int combinaison[];
	protected int historique;
	Scanner saisieCombi = new Scanner (System.in);

	/** Méthode de génération aléatoire de combinaisons
	 * @return tableau d'entier constituant la combinaison	
	 */
	
	public Combinaison (int taille) {
		this.taille=taille;
	}
	
	public int[] genererCombinaisonAleatoire() {
		int i;
		double digit;
		int combinaisonAleatoire[] = new int[taille];
		for ( i =0;i<=taille-1; i++) {
			// génération aléatoire d'un nombre entre 0 et 1)
			digit=Math.random();
			//transformation de ce nombre en entier compris entre 0 et 9
			combinaisonAleatoire[i]=(int)(digit*(9-0)+1);
		}
		return combinaisonAleatoire;
	}
	 
	/**
	 * Méthode permettant d'afficher une combinaison
	 * @param combinaison tableau contenant la combinaison à afficher
	 */
	public void afficherCombinaison(int combinaison[]) {
		System.out.println("\nProposition de l'AI");
		for (int i=0; i<=(taille-1); i++) {
			System.out.print(+combinaison[i]);
		}
	}
	
	/**
	 * Méthode permettant la lecture d'une suite de nombres saisis au clavier
	 * @return tableau d'entier contenant la combinaison à afficher
	 */
	
	public int[] lireCombinaison (int taille){
		int combinaison[] = new int[taille];
		int digit=0;
			
		System.out.print("\nVotre Proposition : ");
		//System.out.println(taille);
		// saisie direct d'une suite d'un entier à la place d'un String
		int proposition = saisieCombi.nextInt();
		
		// Calcul du nbre de digits de la combinaison lue
		while ((proposition/(Math.pow(10,digit)))>=1){
			digit++;
			}
		if (digit!=taille) {
				System.err.println("vous devez entrer une combinaison de "+taille+" chiffres");
		} else {
			try {
				for (int i=0; i<(taille);i++) {
					combinaison[(taille-i-1)] = (int) (proposition % (Math.pow(10,1)));
					proposition=proposition/10;
				}
			} catch(NumberFormatException ex) {
				System.err.println("vous devez saisir des chiffres compris entre 0 et 9");
			}
		}
		return combinaison;
	}
}
