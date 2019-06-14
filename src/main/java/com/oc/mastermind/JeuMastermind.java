package com.oc.mastermind;

import com.oc.common.Jeu;

public class JeuMastermind extends Jeu{

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
	
	private void jouerChallenger () {
		CombinaisonMastermind combinaison1 = new CombinaisonMastermind(getTaille());
		CombinaisonMastermind combinaison2 = new CombinaisonMastermind(getTaille());
		int nbTry=0;
		boolean resultat=false;
		int combinaisonSecrete[]=combinaison1.genererCombinaisonAleatoire();
		do {
			if(isModeDeveloppeur()) {
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
	
	
	private void jouerDefenseur() {
		
		
	}

	private void jouerDuel() {
		
	}

}
