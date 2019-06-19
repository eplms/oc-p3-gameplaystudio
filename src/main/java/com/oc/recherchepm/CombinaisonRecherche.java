package com.oc.recherchepm;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.common.Combinaison;
import com.oc.main.MainLog;

public class CombinaisonRecherche extends Combinaison{
	Scanner saisieComp=new Scanner (System.in);
	private static final Logger LOG = LogManager.getLogger(MainLog.class);

	public CombinaisonRecherche(int taille) {
		super (taille);
	}
	
	/**
	 * méthode de comparaison de deux combinaisons
	 * @return tableau contenant le resultat de la comparaison digit par digit
	 * @param 1 : combinaison à trouver
	 * @param 2: proposition de l'utilisateur
	 */
	public String[] comparerCombinaison (int combinaison1[], int proposition[]) {
        String resultatComparaison[]= new String [taille];
        for(int i =0; i<=(taille-1);i++) {
        	if(combinaison1[i]==proposition[i]) {
        		resultatComparaison[i]="=";
        	}else if (combinaison1[i]>proposition[i]) {
        		resultatComparaison[i]="+";
        	}else {
        		resultatComparaison[i]="-";
        	}	
        }
        return resultatComparaison;
	}
	
	/**
	 * Méthode générant une nouvelle combinaison en fonction du résultat de la comparaison
	 * @param nbTentative nombre de combinaisons tentée avant celle-ci
	 * @param combinaison1 combinaison  précédente
	 * @param resultatComparaison tableau de résultat de la comparaison précédente avec la solution
	 * @return nouvelle combinaison à partir du résultat
	 */
	public int[] genererProchaineCombinaison(int nbTentative, int combinaison1[], String resultatComparaison[]) {
		int prochaineCombinaison[]= new int[taille];
	    if (nbTentative == 0) { 
	    	for (int i=0;i<=(taille-1);i++) {
	    		prochaineCombinaison[i] = 5;
	    		}
	    } else if (nbTentative==1){
	    	for (int i=0;i<=(taille-1);i++) {
	    		if(resultatComparaison[i].equals("=")) {
	    			prochaineCombinaison[i]=combinaison1[i];
	    		} else if (resultatComparaison[i].equals("+")) {
	    			prochaineCombinaison[i]= combinaison1[i]+2;
	    		} else {
	    			prochaineCombinaison[i]=combinaison1[i]-3;
	    		}
	    	}
	    }else {
	    	for (int i=0;i<=(taille-1);i++) {
	    		if(resultatComparaison[i].equals("=")) {
	    			prochaineCombinaison[i]=combinaison1[i];
	    		} else if (resultatComparaison[i].equals("+")) {
	    			prochaineCombinaison[i]= combinaison1[i]+1;
	    		} else {
	    			prochaineCombinaison[i]=combinaison1[i]-1;
	    		}
	    	}
	    }	
	    return prochaineCombinaison;
	}
	
	/**
	 * Méthode vérifiant sur la combinaison estJuste à partir du résultat de la comparaison
	 * @resultatComparaison : tableau dans lequel est stocké le résultat de la comparaison
	 * @return : Boolean indiquant sur la comparaison correspond à une combinaison juste ou fausse
	 */
	public boolean estJuste (String resultatComparaison[]) {
		boolean resultat;
		int digit=0;
		for (int i=0;i<=taille-1;i++) {
			if(resultatComparaison[i].equals("=")){
				digit=digit+1;
			}
		}
		if( digit==taille) {
			resultat=true;
		}else {
			resultat=false;
		}
		return resultat;
	}
	/**
	 * Méthode permettant à l'utilisateur de saisir le resultat de la comparaison entre la
	 * propo de l'IA et sa combinaison scrète
	 * @return resultat de la comparaison saisie
	 */
	public String[] lireResultatComparaison() {
		char []resultatComp=new char[taille];
		String []resultatComparaison=new String[taille];
		String saisieComparaison;
		boolean saisieValable;
		boolean saisieLongueur;
		
		do {
			saisieValable=true;
			saisieLongueur=true;
			System.out.println("\n-> votre réponse : ");			
			saisieComparaison=saisieComp.nextLine();
			// Découpage du String saisi en tableau de char
			resultatComp=saisieComparaison.toCharArray();
			for (int i=0; i<saisieComparaison.length();i++) {
				//Transformation du char en string à un caractère avec ""
				resultatComparaison[i]=resultatComp[i]+"";
				if (!((resultatComparaison[i].equals("="))||(resultatComparaison[i].equals("+"))||(resultatComparaison[i].equals("-")))) { 
					saisieValable=false;
					LOG.warn(" Saisie d'un mauvais caractère : "+resultatComparaison[i]);
				}
			}
			if(!saisieValable) {
                System.out.println("Attention ! Vous avez saisie d'autres caractères que =, + ou - !!!");
                System.out.println("Vous devez saisir une combinaison de =, + ou - uniquement!!!");
            }
			//validation de la longueur de la saisie
			if (saisieComparaison.length()!=taille) {
				System.out.println("Attention ! vous n'avez pas saisie le bon nombre de signes !");
				System.out.println("Vous devez saisir "+taille+" signes =,+ ou -");
				LOG.warn(" Mauvaise réponse saisie : "+saisieComparaison.length()+"caractères saisis. au lieu de "+taille);
				saisieLongueur=false;
			}
		}while(!(saisieValable && saisieLongueur));
		return resultatComparaison;
	}
	/**
	 *Méthode affichant le résultat de la comparaison entre la proposition du joueur et la combinaison secrete
	 * @tableau dans lequel sont stockés les résultats de la comparaison digit par digit
	 */
	public void afficherResultatComparaison(String resultatComparaison[]) {
		System.out.print("Résultat : ");
		for (int i=0;i<=taille-1;i++) {
			System.out.print(resultatComparaison[i]);
		}
		System.out.println();

	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

}
	


