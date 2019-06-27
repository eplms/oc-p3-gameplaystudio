package com.oc.main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.oc.common.Lanceur;

public class Main {
	
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		
		Lanceur jeu=new Lanceur();
		LOG.debug("Lancement du jeu");
		jeu.lancerMenu();
	}
}

	