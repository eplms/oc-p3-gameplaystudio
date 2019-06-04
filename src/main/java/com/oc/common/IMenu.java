package com.oc.common;

public interface IMenu {
	public void afficherMenu (String texteMenu);
	public int lireChoixMenu(int nombreItem);
	public String getTexteMenu();
	public void setTexteMenu(String texteMenu);
	public int getNombreItem();
	public void setNombreItem(int nombreItem);
}
