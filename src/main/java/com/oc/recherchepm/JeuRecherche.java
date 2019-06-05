package com.oc.recherchepm;

import com.oc.common.Jeu;

public class JeuRecherche extends Jeu {
	
	public void lancerJeuRecherche(int choixMode) {
		initialiserParametreJeu();
		if (choixMode==1) {
			jouerChallenger();
		}else if (choixMode==2) {
			jouerDefenseur();
		}else if (choixMode==3) {
			jouerDuel();
		}
	}
	
	private void jouerChallenger () {
		CombinaisonRecherche combinaison1 = new CombinaisonRecherche();
		CombinaisonRecherche combinaison2 = new CombinaisonRecherche();
		int nbTry=0;
		boolean resultat=false;
		int combinaisonSecrete[]=combinaison1.genererCombinaisonAleatoire();
	
		do {
			int proposition []= combinaison2.lireCombinaison();
			String comparaison []=combinaison2.comparerCombinaison(combinaisonSecrete, proposition);
			combinaison2.afficherResultatComparaison(comparaison);
			resultat=combinaison2.estJuste(comparaison);
			nbTry=nbTry+1;
		}while ( !resultat && nbTry<getNombreEssai());
	}
	
	
	private void jouerDefenseur() {
		int proposition[] =new int[getTaille()];
		int nbTry=0;
		boolean resultat=false;
		CombinaisonRecherche combinaison1= new CombinaisonRecherche();
		String resultatComparaison[]=new String[getTaille()];
		do {
			proposition=combinaison1.genererProchaineCombinaison(nbTry, proposition, resultatComparaison);
			combinaison1.afficherCombinaison(proposition);
			String comparaison[]=combinaison1.lireResultatComparaison();
			resultat=combinaison1.estJuste(comparaison);
			nbTry=nbTry+1;
		}while (!resultat && nbTry<getNombreEssai());
		
	}

	private void jouerDuel() {
		int nbTry=0;
		boolean resultatAiJuste=false;
		boolean resultatUtilJuste=false;
		// instance représentant la combinaison secrete de l'AI
		CombinaisonRecherche combinaison1 =new CombinaisonRecherche();
		// instance representant les proposition de l'utilisateur
		CombinaisonRecherche combinaison2= new CombinaisonRecherche();
		int combinaisonSecreteAi[]=combinaison1.genererCombinaisonAleatoire();
		int propositionAi[]=new int[getTaille()];
		String resultatComparaisonUtil[]=new String [getTaille()];
		
		// instance représentant les proposition de l'AI
		CombinaisonRecherche combinaison3 = new CombinaisonRecherche();
		
		do {
			// partie mode challenger 
			int propositionUtilisateur[]=combinaison2.lireCombinaison();
			String resultatComparaisonAi[]=combinaison2.comparerCombinaison(combinaisonSecreteAi, propositionUtilisateur);
			combinaison2.afficherResultatComparaison(resultatComparaisonAi);
			resultatUtilJuste=combinaison2.estJuste(resultatComparaisonAi);
			
			//partie mode defenseur
			propositionAi=combinaison3.genererProchaineCombinaison(nbTry, propositionAi, resultatComparaisonUtil);
			combinaison3.afficherCombinaison(propositionAi);
			String comparaison[]=combinaison3.lireResultatComparaison();
			resultatAiJuste=combinaison3.estJuste(comparaison);
		}while ( !resultatAiJuste && !resultatUtilJuste && nbTry<getNombreEssai());
		
		if (resultatAiJuste && resultatUtilJuste) {
			System.out.println("Egalité !");
		}else if(resultatAiJuste && !resultatUtilJuste) {
			System.out.println("Vous avez perdu !");
		}else if (!resultatAiJuste && resultatUtilJuste) {
			System.out.println("Vous avez gagné !");
		}else {
			System.out.println("tout le monde a perdu !");
		}
		
	}

	
}
