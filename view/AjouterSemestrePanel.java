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

import model.Semestre;

/**
 * Permet d'ajouter un semestre.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AjouterSemestrePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;
	private JButton btnAjouter;
	private JTextField tfJourFin;
	private JTextField tfMoisDebut;
	private JTextField tfMoisFin;
	private JTextField tfAnneeDebut;
	private JTextField tfAnneeFin;
	private JTextField tfJourDebut;
	private JComboBox cbNomSemestre;

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
	public AjouterSemestrePanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(39dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("left:default:grow"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
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

		JLabel lblAjouterSemestre = new JLabel("Ajouter un semestre");
		lblAjouterSemestre.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterSemestre, "4, 2, 19, 1, center, default");

		JLabel lblNom = new JLabel("Nom :");
		add(lblNom, "12, 10, right, default");

		cbNomSemestre = new JComboBox(new String[] { "Semestre 1", "Semestre 2", "Semestre 3", "Semestre 4",
				"Semestre 5", "Semestre 6", "Semestre 7", "Semestre 8", "Semestre 9", "Semestre 10" });
		add(cbNomSemestre, "14, 10, 5, 1, fill, default");

		JLabel lblDateDebut = new JLabel("Date d\u00E9but :");
		add(lblDateDebut, "12, 12, right, default");

		tfJourDebut = new JTextField();
		add(tfJourDebut, "14, 12, left, default");
		tfJourDebut.setColumns(2);

		tfMoisDebut = new JTextField();
		add(tfMoisDebut, "16, 12, left, default");
		tfMoisDebut.setColumns(2);

		tfAnneeDebut = new JTextField();
		add(tfAnneeDebut, "18, 12, left, default");
		tfAnneeDebut.setColumns(4);

		JLabel lblDateFin = new JLabel("Date fin :");
		add(lblDateFin, "12, 14, right, default");

		tfJourFin = new JTextField();
		add(tfJourFin, "14, 14, left, default");
		tfJourFin.setColumns(2);

		tfMoisFin = new JTextField();
		add(tfMoisFin, "16, 14, left, default");
		tfMoisFin.setColumns(2);

		tfAnneeFin = new JTextField();
		add(tfAnneeFin, "18, 14, left, default");
		tfAnneeFin.setColumns(4);

		btnAjouter = new JButton("Ajouter");
		add(btnAjouter, "14, 16, 5, 1, right, default");
		btnAjouter.addActionListener(this);
	}

	/**
	 * Construit le panneau d'ajout de semestre.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public AjouterSemestrePanel(final Application application) {
		this();
		this.setApplication(application);
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
				Semestre newSemestre = new Semestre(new Integer(11),
						Application.creerDate(Integer.parseInt(tfAnneeDebut.getText()),
								Integer.parseInt(tfMoisDebut.getText()) - 1, Integer.parseInt(tfJourDebut.getText())),
						Application.creerDate(Integer.parseInt(tfAnneeFin.getText()),
								Integer.parseInt(tfMoisFin.getText()) - 1, Integer.parseInt(tfJourFin.getText())),
						cbNomSemestre.getSelectedItem().toString(), 0);

				getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterSemestre(newSemestre);
				getApplication().getGestionnaireModele().miseAJourListes();
				JOptionPane.showMessageDialog(null,
						"Le " + cbNomSemestre.getSelectedItem().toString() + " qui d\u00E9bute le "
								+ tfJourDebut.getText() + "/" + tfMoisDebut.getText() + "/" + tfAnneeDebut.getText()
								+ " et qui prend fin le " + tfJourFin.getText() + "/" + tfMoisFin.getText() + "/"
								+ tfAnneeFin.getText() + " a bien \u00E9t\u00E9 ajout\u00E9",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	/**
	 * Permet de verifier la validitee des champs.
	 */
	private String verifChamps() {

		String erreur = new String("");

		if (!Pattern.matches("[0-9]{2,2}$", tfJourFin.getText())
				|| !Pattern.matches("^1[0-2]$|^0[1-9]$", tfMoisFin.getText())
				|| !Pattern.matches("((19|20)\\d\\d)", tfAnneeFin.getText()))
			erreur += "\nRentrez une date valide (jj mm aaaa) entre 1900 et 2099";

		if (!Pattern.matches("[0-9]{2,2}$", tfJourDebut.getText())
				|| !Pattern.matches("^1[0-2]$|^0[1-9]$", tfMoisDebut.getText())
				|| !Pattern.matches("((19|20)\\d\\d)", tfAnneeDebut.getText()))
			erreur += "\nRentrez une date valide (jj mm aaaa) entre 1900 et 2099";

		return erreur;
	}
}
