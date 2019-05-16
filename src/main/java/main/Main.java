package main;
import utilitaire.GestionConfiguration;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/**
		 * Lecture du nombre d'essais max pour trouver combinaison
		 */
		int nbTry = GestionConfiguration.lireNombreEssai();
		System.out.println("Le nombre max d'essais est de " + nbTry + " essais");
		
		/**
		 * Lecture de la taille de la combinaison à trouver en nombre de digits
		 */
		
		int nbDigit = GestionConfiguration.lireTailleCombinaison();
		System.out.println("La combinaison à trouver comporte " + nbDigit + " chiffres");

	}

}
