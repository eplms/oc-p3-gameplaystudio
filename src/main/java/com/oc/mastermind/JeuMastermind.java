package com.oc.mastermind;

import com.oc.common.Jeu;


/**
 * JeuMastermind est la classe permettant de gérer le jeu Mastermind dans ses différents modes
 * @author Emmanuel Plumas
 * @version 1.0
 * Juin 2019
 */
public class JeuMastermind extends Jeu{
	
	
	/**
	 * Méthode selectionnant le mode de jeu à lancer et initialise la taille de la combinaison,
	 * le nombre maximum de tentatives et l'activation du mode developpeur
	 * @param choixMode  le mode de jeu selectionné
	 */
	public void lancerJeu(int choixMode) {
		initialiserParametresJeu();
		switch (choixMode){
			case 1: jouerChallenger();
				break;
			case 2: jouerDefenseur();
				break;
			case 3: jouerDuel();
			}	
	}
	
	/**
	 * Méthode lançant et pilotant le jeu mastermind dans le mode challenger
	 */
	private void jouerChallenger () {
		CombinaisonMastermind combinaison1 = new CombinaisonMastermind(getTaille());
		CombinaisonMastermind combinaison2 = new CombinaisonMastermind(getTaille());
		int nbTry=0;
		boolean resultat=false;
		int combinaisonSecrete[]=combinaison1.genererCombinaisonAleatoire();
		do {
			if(getModeDeveloppeur()==1) {
				System.out.print("\n(Combinaison secrète :");
				combinaison1.afficherCombinaison(combinaisonSecrete);
				System.out.println(")");
			}
			int proposition []= combinaison2.lireCombinaison(getTaille());
			String comparaison []=combinaison2.comparerCombinaison(combinaisonSecrete, proposition);
			combinaison2.afficherResultatComparaison(comparaison);
			resultat=combinaison2.estJuste(comparaison);
			nbTry=nbTry+1;
		}while ( !resultat && nbTry<getNombreEssai());
		if (resultat) {
			System.out.println("\nVous avez trouvé la bonne combinaison ! Félicitations !");
		}else {
			System.out.println("\nVous avez atteint le nombre max de tentative sans trouver la bonne combinaison! désolé !\n");
		}
	}
	
	/**
	 * Méthode lançant et pilotant le jeu mastermind dans le mode defenseur
	 */
	private void jouerDefenseur() {
		int proposition[] =new int [getTaille()];
		int nbTry=0;
		boolean resultat=false;
		CombinaisonMastermind combinaison1= new CombinaisonMastermind(getTaille());
		String resultatComparaison[] =new String[2];
		do {
			proposition=combinaison1.genererProchaineCombinaison(nbTry, proposition, resultatComparaison);
			System.out.print("\nLa proposition "+(nbTry+1)+" de l'IA est : ");
			combinaison1.afficherCombinaison(proposition);
			resultatComparaison=combinaison1.lireResultatComparaison();
			resultat=combinaison1.estJuste(resultatComparaison);
			nbTry=nbTry+1;
			//System.out.println(resultat);
			//System.out.println("le prochain essai est l'essai n°: "+(nbTry+1));
			//System.out.println("le nombre restant d'essai est de :"+(getNombreEssai()-(nbTry+1)));
		} while (!resultat && nbTry<getNombreEssai());
		
		if (!resultat) {
			System.out.println("\nL'IA a atteint le nombre max de tentative sans trouver la bonne combinaison! Félicitations !");
		}else {
			System.out.println("\nL'IA a trouvé la bonne combinaison! Désolé !");
		}
	}

	
	/**
	 * Méthode lançant et pilotant le jeu mastermind dans le mode duel
	 */
	private void jouerDuel() {
		int nbTry=0;
		CombinaisonMastermind combinaison1 = new CombinaisonMastermind(getTaille());
		CombinaisonMastermind combinaison2 = new CombinaisonMastermind(getTaille());
		boolean resultatUtilJuste=false;
		boolean resultatAiJuste=false;
		int combinaisonSecreteAi[]=combinaison1.genererCombinaisonAleatoire();
		int propositionAi[] =new int [getTaille()];
		String resultatComparaisonUtil[] =new String[2];

		do {
			//mode challenger
			if(getModeDeveloppeur()==1) {
				System.out.print("\n(Combinaison secrète :");
				combinaison1.afficherCombinaison(combinaisonSecreteAi);
				System.out.println(")");
			}
			int propositionUtilisateur []= combinaison2.lireCombinaison(getTaille());
			String comparaisonAI []=combinaison2.comparerCombinaison(combinaisonSecreteAi, propositionUtilisateur);
			combinaison2.afficherResultatComparaison(comparaisonAI);
			resultatUtilJuste=combinaison2.estJuste(comparaisonAI);
			//mode defenseur
			
			propositionAi=combinaison1.genererProchaineCombinaison(nbTry, propositionAi, resultatComparaisonUtil);
			System.out.print("\nLa proposition "+(nbTry+1)+" de l'IA est : ");
			combinaison1.afficherCombinaison(propositionAi);
			resultatComparaisonUtil=combinaison1.lireResultatComparaison();
			resultatAiJuste=combinaison1.estJuste(resultatComparaisonUtil);
			
			nbTry=nbTry+1;
		}while ( !resultatUtilJuste && !resultatAiJuste && nbTry<getNombreEssai());
		if (resultatAiJuste && resultatUtilJuste) {
			System.out.println("Egalité : l'IA et vous avez trouvé la bonne solution en même temps!");
		}else if(resultatAiJuste && !resultatUtilJuste) {
			System.out.println(" L'IA a trouvé la bonne combinaison avant vous : Vous avez perdu ! Désolé");
		}else if (!resultatAiJuste && resultatUtilJuste) {
			System.out.println("Vous avez trouvé la bonne combinaison avant l'IA ! félicitations !");
		}else {
			System.out.println("Vous et l'IA avez atteint le nombre max de tentatives sans que personne ne trouve la bonne combinaison! Personne ne gagne !\n");
		}
	}

}
