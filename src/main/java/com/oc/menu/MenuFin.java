package com.oc.menu;

import com.oc.common.Menu;

public class MenuFin extends Menu{
	public void afficherMenuFin(int jeu, int mode) {
		System.out.println("Que souhaitez-faire ?");
		System.out.println("1- Vous souhaitez rejouer ?");
		System.out.println("2- Vous souhaitez jouer à un autre jeu et/ou dans un autre mode ?");
	}
	public void afficherChoixMenuFin(int choixMenuFin) {
		String choixMenu = null;
		if(choixMenuFin==1) {
			choixMenu="Vous avez choisi de jouer au même jeu";
		}else if(choixMenuFin==2) {
			choixMenu="Vous avez choisi de jouer à un autre jeu et/ou dans un autre mode";
		}
		System.out.println(choixMenu);		
		
	}
	@Override
	public void afficherMenuChoixJeu() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afficherMenuChoixMode() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afficherChoixJeuDebut(int choixJeu) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afficherChoixModeDebut(int choixMode) {
		// TODO Auto-generated method stub
		
	}
}
