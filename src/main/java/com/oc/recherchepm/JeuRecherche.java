package com.oc.recherchepm;

import com.oc.common.Jeu;
/**
 * JeuRecherche est la classe permettant de gérer le jeu Recherche dans ses différents modes
 * @author Emmanuel Plumas
 * @version 1.0
 * Juin 2019
 */
public class JeuRecherche extends Jeu {
	
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
	 * Méthode lançant et pilotant le mode challenger du jeu recherche
	 */
	private void jouerChallenger () {
		CombinaisonRecherche combinaison1 = new CombinaisonRecherche(getTaille());
		CombinaisonRecherche combinaison2 = new CombinaisonRecherche(getTaille());
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
	 * Méthode lançant et pilotant le mode defenseur du jeu recherche
	 */
	private void jouerDefenseur() {
		int proposition[] =new int[getTaille()];
		int nbTry=0;
		boolean resultat=false;
		CombinaisonRecherche combinaison1= new CombinaisonRecherche(getTaille());
		String resultatComparaison[]=new String[getTaille()];
		do {
			proposition=combinaison1.genererProchaineCombinaison(nbTry, proposition, resultatComparaison);
			System.out.print("\nLa proposition "+(nbTry+1)+" de l'IA est : ");
			combinaison1.afficherCombinaison(proposition);
			resultatComparaison=combinaison1.lireResultatComparaison();
			resultat=combinaison1.estJuste(resultatComparaison);
			nbTry=nbTry+1;
		}while (!resultat && nbTry<getNombreEssai());
		if (!resultat) {
			System.out.println("\nL'IA a atteint le nombre max de tentative sans trouver la bonne combinaison! Félicitations !");
		}else {
			System.out.println("\nL'IA a trouvé la bonne combinaison! Désolé !");
		}
		
	}

	/**
	 * Méthode lançant et pilotant le mode duel du jeu recherche
	 */
	
	private void jouerDuel() {
		int nbTry=0;
		boolean resultatAiJuste=false;
		boolean resultatUtilJuste=false;
		// instance représentant la combinaison secrete de l'AI
		CombinaisonRecherche combinaison1 =new CombinaisonRecherche(getTaille());
		// instance representant les proposition de l'utilisateur
		CombinaisonRecherche combinaison2= new CombinaisonRecherche(getTaille());
		int combinaisonSecreteAi[]=combinaison1.genererCombinaisonAleatoire();
		int propositionAi[]=new int[getTaille()];
		String resultatComparaisonUtil[]=new String [getTaille()];
		
		// instance représentant les proposition de l'AI
		CombinaisonRecherche combinaison3 = new CombinaisonRecherche(getTaille());
		
		do {
			// partie mode challenger 
			if(getModeDeveloppeur()==1) {
				System.out.print("\n(Combinaison secrète :");
				combinaison1.afficherCombinaison(combinaisonSecreteAi);
				System.out.println(")");
			}
			int propositionUtilisateur[]=combinaison2.lireCombinaison(getTaille());
			String resultatComparaisonAi[]=combinaison2.comparerCombinaison(combinaisonSecreteAi, propositionUtilisateur);
			combinaison2.afficherResultatComparaison(resultatComparaisonAi);
			resultatUtilJuste=combinaison2.estJuste(resultatComparaisonAi);
			
			//partie mode defenseur
			propositionAi=combinaison3.genererProchaineCombinaison(nbTry, propositionAi, resultatComparaisonUtil);
			System.out.print("\nla proposition "+(nbTry+1)+" de l'IA est :");
			combinaison3.afficherCombinaison(propositionAi);
			resultatComparaisonUtil=combinaison3.lireResultatComparaison();
			resultatAiJuste=combinaison3.estJuste(resultatComparaisonUtil);
			nbTry=nbTry+1;
		}while ( !resultatAiJuste && !resultatUtilJuste && nbTry<getNombreEssai());
		
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
