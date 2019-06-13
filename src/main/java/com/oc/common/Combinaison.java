package com.oc.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Combinaison implements ICombinaison{
	protected int taille;
	protected int combinaison[][];
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
		//System.out.println("\nProposition de l'AI");
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
		int proposition=0;
		do {
			System.out.print("\nVotre Proposition : ");
			// saisie direct d'une suite d'un entier à la place d'un String
			try {
				proposition = saisieCombi.nextInt();
				// Calcul du nbre de digits de la combinaison lue
				digit=0;
				while ((proposition/(Math.pow(10,digit)))>=1){
					digit++;
					}
				if (digit!=taille) {
					System.out.println("");
					System.out.println("Attention !! vous avez saisi une combinaison de "+digit+" chiffres");
					System.out.println("vous devez entrer une combinaison de "+taille+" chiffres");
				} else {
					// Affectation de chaque digit à une case du tableau
					for (int i=0; i<(taille);i++) {
						combinaison[(taille-i-1)] = (int) (proposition % (Math.pow(10,1)));
						proposition=proposition/10;		
					}
				}
			}
			catch(InputMismatchException e) {
				// gestion de l'exception en cas de saisie autre que d'entiers
				System.out.println("Attention ! il ne faut saisir que des chiffres !");
				//vider le buffer
				saisieCombi.nextLine();
			}			
		}while(digit!=taille);
		return combinaison;
	}
}
