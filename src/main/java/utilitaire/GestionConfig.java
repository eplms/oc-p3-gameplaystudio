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
		
		/* création objet properties qui contient les données de configuration */
		Properties prop = new Properties();

		/* Création objet fichier de configuration */
		/* InputStream est une classe abstraite mais FileInputStream est une classe concrète*/
		InputStream fichier = new FileInputStream("src/main/resources/config.properties");
		/* chargement du fichier de configuration*/
		prop.load(fichier);
		/* mise à jour des valeurs de configuration avec la méthode setProperty*/
		System.out.println(prop.getProperty("nombreTry"));
		System.out.println(prop.getProperty("nombreDigit"));
	}
	
}
