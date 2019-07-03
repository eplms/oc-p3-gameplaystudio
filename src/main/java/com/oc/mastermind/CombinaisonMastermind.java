package com.oc.mastermind;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.common.Combinaison;
import com.oc.main.Main;
import com.oc.utilitaire.GestionConfiguration;


/**
 * CombinaisonMastermind est la classe permettant de gérer les combinaisons spécifiquement au jeu Mastermind
 * @author Emmanuel Plumas
 * @version 1.0
 * Juin 2019
 */
public class CombinaisonMastermind extends Combinaison {
	Scanner saisieComp=new Scanner (System.in);
	private static final Logger LOG = LogManager.getLogger(Main.class);
	
	
	public CombinaisonMastermind(int taille) {
		super(taille);
	}
	
	protected int historiquePropositionCombinaison [][]= new int [GestionConfiguration.lireNombreEssai()][taille];
	protected String historiqueComparaisonCombinaison [][]= new String [GestionConfiguration.lireNombreEssai()][2];
	
	
	/**
	 * méthode de comparaison de deux combinaisons
	 * @return tableau contenant le resultat de la comparaison
	 * 	Premier case : Nombre de digits biens placés
	 * 	Deuxième case: Nombre de digits présents (n'inclut pas les biens placés
	 */
	
	public String[] comparerCombinaison (int combinaison1[], int combinaison2[]){
		int nombreBienPlaces=0;
		int nombrePresents=0;
		int i=0;
		Boolean[] masqueCombinaison1 = new Boolean[taille];
		Boolean[] masqueCombinaison2= new Boolean[taille];
		String comparaison[]=new String[2];
		
		// Initialisation des tableaux
		for(i=0;i<taille;i++) {
			masqueCombinaison1[i]=false;
			masqueCombinaison2[i]=false;
		}
		
		for (i=0; i<= taille-1; i++) {
			if (combinaison1[i]==combinaison2[i]) {
				nombreBienPlaces=nombreBienPlaces+1;
				masqueCombinaison1[i]= true;
				masqueCombinaison2[i]= true;
			}
		}
		int j=0;
		int k=0;
		for (j=0; j<taille;j++) {
			for(k=0;k<taille;k++) {
				if((j!=k) && (masqueCombinaison1[j]==false) && (masqueCombinaison2[k]==false)){
					if(combinaison1[j]==combinaison2[k]){
						nombrePresents=nombrePresents+1;
						masqueCombinaison1[j]=true;
						masqueCombinaison2[k]=true;
					}
				}
			}
		}
		comparaison[0]=Integer.toString(nombreBienPlaces);
		comparaison[1]=Integer.toString(nombrePresents);
		//comparaison[0]=String.valueOf(nombreBienPlaces);
		//comparaison[1]=String.valueOf(nombrePresents);
		return comparaison;
	}
	
	/**
	 * Méthode générant une nouvelle combinaison en fonction de l'historique des propositions et des comparaisons
	 * @param nbTentative correspond au rang de la tentative
	 * @param combinaison1 combinaison précédente
	 * @param resultatComparaison tableau de résultat de la comparaison précédente avec la solution
	 * @return prochaineCombinaison nouvelle proposition de combinaison
	 */
	public int[] genererProchaineCombinaison(int nbTentative, int combinaison1[], String resultatComparaison[]) {
		int[] prochaineCombinaison = new int [taille];
		boolean estAdmissible=true;
		String comparaison[]=new String[2];
		int nbComparaison=0;
		if (nbTentative==0) {
			prochaineCombinaison=genererCombinaisonAleatoire();
			for (int i=0; i<taille;i++) {
				historiquePropositionCombinaison[nbTentative][i]=prochaineCombinaison[i];
			}			
		} else {
			do {
				for (int i=0; i<2;i++) {
					historiqueComparaisonCombinaison[nbTentative-1][i]=resultatComparaison[i];
				}
				prochaineCombinaison=genererCombinaisonAleatoire();
				nbComparaison=0;
				for (int i=0; i<nbTentative; i++) {
					// comparer prochaine combinaison à chaque combinaison de l'historique
					comparaison=comparerCombinaison(prochaineCombinaison,historiquePropositionCombinaison[i]);
					// comparer le resultat de la comparaison avec les comparaisons des précédentes combinaisons
					for (int j=0; j<2;j++) {
						if (comparaison[j].equals(historiqueComparaisonCombinaison[i][j])) {
							nbComparaison=nbComparaison+1;
							}
					}
					
					// comparer le résultat de la comparaison à chaque comparaison de l'historique
				}
				if(nbComparaison==nbTentative*2) {
					estAdmissible=true;
				}else {
					estAdmissible=false;
				}
					
			}while (!estAdmissible);	
		}
		for (int i=0; i<taille;i++) {
			historiquePropositionCombinaison[nbTentative][i]=prochaineCombinaison[i];
		}
		return prochaineCombinaison;
	}

	/**
	 * Méthode affichant le résultat de la combinaison
	 * @param  comparaison[] tableau contenant le résultat de la comparaison
	 */
	public void afficherResultatComparaison(String comparaison[]) {
		System.out.println("-> Réponse : ");
		// Transformation des String en Integer
		int nombreBienPlaces = Integer.parseInt(comparaison[0]);
		int nombrePresents= Integer.parseInt(comparaison[1]);
		if (nombreBienPlaces == 0 && nombrePresents == 0) {
			System.out.println("Aucun nombre bien placé, aucun présent !");
		} else if(nombreBienPlaces==0 && nombrePresents!=0) {
			System.out.println(nombrePresents+" présent(s), aucun bien placé");
		} else if (nombreBienPlaces !=0 && nombrePresents ==0) {
			System.out.println(nombreBienPlaces+" bien placé(s) !");
		} else if (nombreBienPlaces !=0 && nombrePresents !=0) {
			System.out.println(nombreBienPlaces+" bien places et "+nombrePresents+" présent(s)");
		}
	}
	
	
	
	/**
	 * Méthode indiquant à partir du résultat de la comparaison si la combinaison est juste (identique à la combinaison secrete)
	 * @param resultatComparaison tableau contenant
	 * 	première case : nombre de digits biens placés
	 *  deuxième case : nombre de digits présents (n'inclut pas les biens placés
	 * @return resultat : true si la combinaison est juste, false sinon.
	 */
	public boolean estJuste (String resultatComparaison[]) {
		boolean resultat=false;
		if ((Integer.parseInt(resultatComparaison[0]))==taille) {
			resultat=true;
			//System.out.println("resultat juste");
		}else {
			resultat=false;
			//System.out.println("resultat fau");
		}
		return resultat;
	}
	
	/**
	 * Méthode permettant à l'utilisateur de saisir le resultat de la comparaison entre la
	 * propo de l'IA et sa combinaison secrète
	 * @return resultatComparaison Tableau stockant les resultats de la comparaison
	 *  première case : nombre de digits biens placés
	 *  deuxième case : nombre de digits présents (n'inclut pas les biens placés
	 */
	
	public String[] lireResultatComparaison() {
		String []resultatComparaison=new String[2];
		boolean saisieBienPlaceValable=false;
		boolean saisiePresentValable=false;
		
		while (!saisieBienPlaceValable){
			try {
				do {
					System.out.println("\n-> votre réponse :");	
					System.out.println("Nombre de digit bien placés : ");
					resultatComparaison[0]=saisieComp.nextLine();
					int nombreBienPlaces = Integer.parseInt(resultatComparaison[0]);
				
					if ((nombreBienPlaces<0) || (nombreBienPlaces>taille )) {
						LOG.warn("Mauvaise saisie du nombre de digit bien positionnés "+ nombreBienPlaces);
						System.out.println("Vous devez indiquer le nombre de digits bien positionnés");
						System.out.println("Il s'agit d'un chiffre compris entre 0 et "+taille);
						saisieBienPlaceValable=false;
					}else {
						saisieBienPlaceValable=true;
					}
				}while (!saisieBienPlaceValable);
			
			}catch(NumberFormatException e) {
				LOG.warn("Mauvaise saisie du nombre de digits bien positionnés : saisie d'un signe autre qu'un chiffre");
				System.out.println("Vous devez indiquer le nombre de digits bien positionnés");
				System.out.println("Il s'agit d'un chiffre compris entre 0 et "+taille);
				saisieBienPlaceValable=false;
			}
		}	
		
		
		while (!saisiePresentValable) {
			try {
				do {
					System.out.println("\nNombre de digit présents : ");
					resultatComparaison[1]=saisieComp.nextLine();
					int nombrePresent = Integer.parseInt(resultatComparaison[1]);
					if ((nombrePresent<0) || (nombrePresent>taille )) {
						LOG.warn("Mauvaise saisie du nombre de digit bien positionnés "+ nombrePresent);
						System.out.println("Vous devez indiquer le nombre de digits present");
						System.out.println("Il s'agit d'un chiffre compris entre 0 et "+taille);
						saisiePresentValable=false;
					}else {
						saisiePresentValable=true;
					}
				}while(!saisiePresentValable);
			}catch(NumberFormatException e) {
				LOG.warn("Mauvaise saisie du nombre de digits présent : saisie d'un signe autre qu'un chiffre");
				System.out.println("Vous devez indiquer le nombre de digits présents");
				System.out.println("Il s'agit d'un chiffre compris entre 0 et "+taille);
				saisiePresentValable=false;
			}
		}	
		return resultatComparaison;
		}
	
}
