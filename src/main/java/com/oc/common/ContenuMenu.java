package com.oc.common;

/**
 * Classe permettant de gérer le contenu des menus
 * @author emmanuel
 * @version 1.0
 *	Juin 2019
 */


public class ContenuMenu extends Menu{
	private String texteMenu;
	private int nombreItem;
	
	public String getTexteMenu() {
		return texteMenu;
	}
	public void setTexteMenu(String texteMenu) {
		this.texteMenu = texteMenu;
	}
	public int getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(int nombreItem) {
		this.nombreItem = nombreItem;
	}
}
	