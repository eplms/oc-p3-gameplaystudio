package com.oc.common;

import java.util.Random;
import java.util.Scanner;

public abstract class Combinaison implements ICombinaison{
	
/** Méthode de génération aléatoire de combinaison
 * @return tableau d'entier constituant la combinaison	
 */
	public int[] genererCombinaisonAleatoire(int taille) {
		int i;
		int t[] = new int[taille];
		Random rand= new Random();
		for ( i =0;i<=taille-1; i++) {
			t[i]=rand.nextInt();
		}
		return t;
	}
	
/** Méthode permettant d'afficher la combinaison
 * 	
 */
	public void afficherCombinaison(int tab[], int taille) {
		int i=0;
		for (i=0; i<=(taille-1); i++) {
			System.out.print(tab[i]);
		}
	}
	
}
