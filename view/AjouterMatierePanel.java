package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import model.Matiere;
import model.Semestre;

/**
 * Permet d'ajouter une matiere.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AjouterMatierePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;
	private JTextField tfNomMatiere;
	private JComboBox cbProfs;
	private JComboBox cbSemestres;
	private JButton btnAjouter;
	private JButton btnNouveauProf;
	private JButton btnNouveauSemestre;
	private JTextField tfCoeff;
	private JLabel lblCoefficient;

	/**
	 * Accesseur en lecture sur l'application.
	 * 
	 * @return L'application.
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
	 * Cree le panneau.
	 */
	public AjouterMatierePanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(13dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(43dlu;default):grow"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(67dlu;pref)"),
								FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec
										.decode("75px"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(27dlu;default)"), FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("max(10dlu;default)"),
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AjouterPersonnePanel.class.getResource("/resources/ESEO.png")));
		add(label, "2, 2");

		JLabel lblAjouterMatiere = new JLabel("Ajouter mati\u00E8re");
		lblAjouterMatiere.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterMatiere, "4, 2, 9, 1, center, default");

		JLabel lblNom = new JLabel("Nom :");
		add(lblNom, "6, 10, right, default");

		tfNomMatiere = new JTextField();
		add(tfNomMatiere, "8, 10, fill, default");
		tfNomMatiere.setColumns(10);

		JLabel lblResponsable = new JLabel("Enseignant responsable :");
		add(lblResponsable, "6, 12, right, default");

		cbProfs = new JComboBox();
		add(cbProfs, "8, 12, fill, default");

		btnNouveauProf = new JButton("Nouveau prof");
		add(btnNouveauProf, "10, 12, fill, default");
		btnNouveauProf.addActionListener(this);

		JLabel lblSemestre = new JLabel("Semestre :");
		add(lblSemestre, "6, 14, right, default");

		cbSemestres = new JComboBox();
		add(cbSemestres, "8, 14, fill, default");

		btnNouveauSemestre = new JButton("Nouveau semestre");
		add(btnNouveauSemestre, "10, 14, left, default");
		btnNouveauSemestre.addActionListener(this);

		lblCoefficient = new JLabel("Coefficient :");
		add(lblCoefficient, "6, 16, right, default");

		tfCoeff = new JTextField();
		add(tfCoeff, "8, 16, left, default");
		tfCoeff.setColumns(2);

		btnAjouter = new JButton("Ajouter");
		add(btnAjouter, "8, 18, right, default");
		btnAjouter.addActionListener(this);
	}

	/**
	 * Construit le panneau d'ajout de matiere.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public AjouterMatierePanel(final Application application) {
		this();
		this.setApplication(application);
		initialiserJComboBoxes();
	}

	/**
	 * Initialise les JComboBoxes.
	 */
	private void initialiserJComboBoxes() {
		for (int i = 0; i < getApplication().getGestionnaireModele().getProfesseurs().size(); i++)
			cbProfs.addItem(new String(getApplication().getGestionnaireModele().getProfesseurs().get(i).getNom() + "  "
					+ getApplication().getGestionnaireModele().getProfesseurs().get(i).getPrenom()));

		for (Semestre semestres : getApplication().getGestionnaireModele().getSemestres())
			cbSemestres.addItem(new String(semestres.toString()));
	}

	/**
	 * Les actions a effectuer lors d'un evenement.
	 * 
	 * @param arg0
	 *            L'evenement a traiter.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAjouter) {
			String erreur = verifChamps();
			if (erreur.length() > 3)
				JOptionPane.showMessageDialog(null, erreur, "Erreur", JOptionPane.ERROR_MESSAGE);
			else {
				Integer idProf = getApplication().getGestionnaireModele().getProfesseurs()
						.get(cbProfs.getSelectedIndex()).getId();
				Integer idSemestre = getApplication().getGestionnaireModele().getSemestres()
						.get(cbSemestres.getSelectedIndex()).getId();

				Matiere newMatiere = new Matiere(new Integer(11), idProf, tfNomMatiere.getText(),
						Double.parseDouble(tfCoeff.getText()), idSemestre, new Double(0));

				getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterMatiere(newMatiere);
				getApplication().getGestionnaireModele().miseAJourListes();
				JOptionPane.showMessageDialog(null,
						"La mati\u00E8re " + tfNomMatiere.getText() + " a bien \u00E9t\u00E9 ajout\u00E9",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (arg0.getSource() == btnNouveauProf) {
			getApplication().changerPanel(new AjouterPersonnePanel(getApplication()));
		}

		if (arg0.getSource() == btnNouveauSemestre) {
			getApplication().changerPanel(new AjouterSemestrePanel(getApplication()));
		}
	}

	/**
	 * Permet de verifier la validitee des champs.
	 */
	private String verifChamps() {

		String erreur = new String("");

		if (tfNomMatiere.getText().isEmpty())
			erreur += "Rentrez un nom de mati\u00E8re valide";

		if (!Pattern.matches("[0-9]{1,5}$", tfCoeff.getText()))
			erreur += "\nRentrez un coefficient valide";

		if (cbProfs.getItemCount() == 0 || cbSemestres.getItemCount() == 0)
			erreur += "\nUne combobox est vide";

		return erreur;
	}
}
