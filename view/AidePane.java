package view;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Ouvre le panneau d'aide.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AidePane extends JTextPane {

	private static final long serialVersionUID = -1129735927402799521L;

	/**
	 * Construit le panneau d'aide.
	 */
	public AidePane() {
		super();
		setEditable(false);
		setFont(new Font("Helvetica", Font.PLAIN, 11));
		setToolTipText("Aide");
		this.setOpaque(true);
		this.setText(
				"\t\tBienvenue dans l'aide du programme.\n\nLe menu Fichier vous permet de redimenssionner la fenetre, de jouer au jeu de Tetris, ou de quitter le programme.\n\nLe menu Utilisateur vous permet de vous connecter, vous deconnecter ou modifier votre profil utilisateur.\n\nLe menu Operation vous permet de consulters des listes en fonctions de vos droits, il vous permet egalement d'ajouter des objets en base de donnée.\n\nLe menu GestionnaireBDD vous fourni la possiblité de creer/vider celle-ci, d'afficher et de supprimer l'historique des requetes, ainsi que de mettre a jour les listes actuellements utilisees par le programme.\n\nLe menu E-Mail vous permet d'envoyer un mail a une liste de personnes pour leur annonce le resultat de la repartition des notes d'un examen.\n\nAttention, la barre de menu est automatiquement actualisee en fonction de l'utilisateur, chaque utilisateur ne dipose pas forcement des memes droits.\n\nNote : vous devez etre enregistre en base de donnee avec un identifiant valide pour pouvoir vous connecter.\n\n\n");
		StyledDocument doc = this.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

	}

}
