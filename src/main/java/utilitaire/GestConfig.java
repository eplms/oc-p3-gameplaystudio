package utilitaire;

import java.util.ResourceBundle;

public class GestConfig {
	/* lecture du fichier config.properties dans l'objet conf */
	static ResourceBundle conf = ResourceBundle.getBundle("config");
	
	public static void lireConfig () {
	
	/* récupération du nombreTry en String dans conf */
	String nombreTry = conf.getString("nombreTry");
	/* récupération du nombreDigit en String dans conf */
    String nombreDigit = conf.getString("nombreDigit");
    System.out.println(nombreTry);
    System.out.println(nombreDigit);
    
    /* transformation des String en int */
    
	}
    
}
