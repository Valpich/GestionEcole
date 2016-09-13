package view;

import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Creer un panneau a propros.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AboutPane extends JTextPane {

	private static final long serialVersionUID = -1129735927402799521L;

	/**
	 * Permet la creation et l'affichage du panneau a propros.
	 */
	public AboutPane() {
		super();
		this.setOpaque(true);
		StyledDocument doc = this.getStyledDocument();
		MutableAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
		doc.setParagraphAttributes(0, 0, center, true);
		this.setText("\t\tMini-Projet JAVA ESEO Semestre 6\n\n" + "Auteurs : " + "\tHAMON Romain\n"
				+ "\tPICHAVANT Valentin\n\n" + "Annee 2015 - Promotion De Gennes");
	}

}
