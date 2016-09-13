package view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * Ouvrir un fichier dans l'editeur par defaut.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class LancerEditeurDeTexte {

	/**
	 * Lancer l'executable et ouvrir le fichier.
	 * 
	 * @param lancer
	 *            Le nom du fichier.
	 */
	public static void lancer(final String lancer) {
		File file = new File(lancer);
		if (!file.exists() && file.length() < 0) {
			System.out.println("Le fichier n'existe pas !");
			System.exit(0);
		}
		Desktop desktop = null;
		if (Desktop.isDesktopSupported()) {
			desktop = Desktop.getDesktop();
		}
		try {
			desktop.edit(file);
		} catch (IOException ex) {
			System.out.println("Impossible d'ouvrir le fichier.");
		}
	}

}