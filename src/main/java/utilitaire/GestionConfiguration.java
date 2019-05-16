package utilitaire;

import java.util.ResourceBundle;

public class GestionConfiguration {
	/* Déclaration objet configuration et lecture du fichier config.properties dans l'objet configuration */
	static ResourceBundle configuration = ResourceBundle.getBundle("config");
	
	/**
	 * Fonction de lecture du nombre d'essai dans le fichier config.properties
	 * @return nombreEssai max autorisées
	 */
	
	public static int lireNombreEssai () {
		String nombreTry = configuration.getString("nombreTry");
		int nombreEssai=Integer.parseInt(nombreTry);
		return nombreEssai;
	}
	
	/**
	 * Fonction de lecture de la taille de la combinaison
	 * @return tailleCombinaison en nombre de digits
	 */
	public static int lireTailleCombinaison() {
		String nombreDigit = configuration.getString("nombreDigit");
		int tailleCombinaison =Integer.parseInt(nombreDigit);
		return tailleCombinaison;
	}
    
}
