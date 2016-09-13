package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import model.Administrateur;
import model.Etudiant;
import model.Professeur;

/**
 * Ouvrir le panneau d'acceuil.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AccueilPanel extends JPanel {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;

	private JLabel lblAjouterUnePersonne;

	/**
	 * Accesseur en lecture sur l'application.
	 * 
	 * @return L'application du panneau.
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * Accesseur en ecriture sur l'application.
	 * 
	 * @param application
	 *            La nouvelle application.
	 */
	public void setApplication(final Application application) {
		this.application = application;
	}

	/**
	 * Creer le panneau.
	 */
	public AccueilPanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(39dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("left:default:grow"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(43dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(67dlu;pref)"),
								FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec
										.decode("75px"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(10dlu;default)"), FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AccueilPanel.class.getResource("/resources/ESEO.png")));
		add(label, "2, 2");

		lblAjouterUnePersonne = new JLabel("Bonjour NOM PRENOM");
		lblAjouterUnePersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterUnePersonne, "4, 2, 15, 1, center, default");
	}

	/**
	 * Construit le panneau.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public AccueilPanel(final Application application) {
		this();
		this.setApplication(application);

		if (getApplication().getGestionnaireModele().getNiveauAcces() == 0) {
			for (Administrateur administrateur : getApplication().getGestionnaireModele().getAdministrateurs()) {
				if (administrateur.getId().equals(getApplication().getGestionnaireModele().getIdUtilisateur()))
					lblAjouterUnePersonne
							.setText("Bonjour " + administrateur.getPrenom() + " " + administrateur.getNom());
			}
		} else if (getApplication().getGestionnaireModele().getNiveauAcces() == 1) {
			for (Professeur professeur : getApplication().getGestionnaireModele().getProfesseurs()) {
				if (professeur.getId().equals(getApplication().getGestionnaireModele().getIdUtilisateur()))
					lblAjouterUnePersonne.setText("Bonjour " + professeur.getPrenom() + " " + professeur.getNom());
			}
		} else if (getApplication().getGestionnaireModele().getNiveauAcces() == 2) {
			for (Etudiant etudiant : getApplication().getGestionnaireModele().getEtudiants()) {
				if (etudiant.getId().equals(getApplication().getGestionnaireModele().getIdUtilisateur()))
					lblAjouterUnePersonne.setText("Bonjour " + etudiant.getPrenom() + " " + etudiant.getNom());
			}
		}
	}

}
