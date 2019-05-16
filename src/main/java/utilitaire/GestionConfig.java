package utilitaire;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class GestionConfig {
	
	
	public static void ecrireConfiguration ()throws Exception{
		
		/* création objet properties qui contient les données de configuration */
		Properties prop = new Properties();
		/* Création objet fichier de configuration */
		/* OutpuStream est une classe abstraite mais FileOutputStream est une classe concrète*/
		OutputStream fichier = new FileOutputStream("src/main/resources/config.properties");
		/* mise à jour des valeurs de configuration avec la méthode setProperty*/
		prop.setProperty("nombreTry","9");
		prop.setProperty("nombreDigit","3");
		
		/* envoie des données de l'objet prop dans le fichier sans commentaires null*/
		prop.store(fichier,null);
		System.out.println(prop);
	}
	public static void lireConfiguration ()throws Exception{
		String nbTry;
		String nbDigit;
		int essaiMax=0;
		int taille=0;
		/* création objet properties qui contient les données de configuration */
		Properties prop = new Properties();

		/* Création objet fichier de configuration */
		/* InputStream est une classe abstraite mais FileInputStream est une classe concrète*/
		InputStream fichier = new FileInputStream("src/main/resources/config.properties");
		/* chargement du fichier de configuration*/
		prop.load(fichier);
		/* récupération des valeurs de configuration avec la méthode getProperty*/
		nbTry= prop.getProperty("nombreTry");
		nbDigit= prop.getProperty("nombreDigit");
		
		/*Transformation des String du fichier de configuration en int */
		essaiMax= Integer.parseInt(nbTry);
		taille=Integer.parseInt(nbDigit);
		System.out.println(essaiMax);
		System.out.println(taille);
	}
	
}
