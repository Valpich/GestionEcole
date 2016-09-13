package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import model.Administrateur;
import model.Adresse;
import model.Etudiant;
import model.Professeur;

/**
 * Permet d'ajouter une personne.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AjouterPersonnePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;

	private JLabel lblAjouterUnePersonne;
	private JTextField tfNom;
	private JTextField tfPrenom;
	private JTextField tfNumero;
	private JTextField tfAdresse;
	private JTextField tfVille;
	private JTextField tfCodePostal;
	private JTextField tfPays;
	private JTextField tfJour;
	private JTextField tfMois;
	private JTextField tfAnnee;
	private JTextField tfMailPerso;
	private JTextField tfMailPro;
	private JTextField tfTelPerso;
	private JTextField tfTelPro;
	private JTextField tfPromo;
	private JTextField tfAnneeArrivee;
	private JTextField tfUsername;
	private JButton btnAjouter;
	private JCheckBox chckbxRedoublant;
	private JComboBox cbIntituleAdresse;
	private JComboBox cbTypePersonne;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

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
	public AjouterPersonnePanel() {
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
		label.setIcon(new ImageIcon(AjouterPersonnePanel.class.getResource("/resources/ESEO.png")));
		add(label, "2, 2");

		lblAjouterUnePersonne = new JLabel("Ajouter un \u00E9tudiant");
		lblAjouterUnePersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterUnePersonne, "4, 2, 15, 1, center, default");

		JLabel lblNom = new JLabel("Nom :");
		add(lblNom, "4, 6, right, default");

		tfNom = new JTextField();
		add(tfNom, "6, 6, 7, 1, fill, default");
		tfNom.setColumns(15);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		add(lblPrnom, "14, 6, right, default");

		tfPrenom = new JTextField();
		add(tfPrenom, "16, 6, 3, 1, fill, default");
		tfPrenom.setColumns(15);

		JLabel lblNaissance = new JLabel("Naissance :");
		add(lblNaissance, "4, 8, right, default");

		tfJour = new JTextField();
		add(tfJour, "6, 8, left, default");
		tfJour.setColumns(3);

		tfMois = new JTextField();
		add(tfMois, "8, 8, left, default");
		tfMois.setColumns(3);

		tfAnnee = new JTextField();
		add(tfAnnee, "10, 8, left, default");
		tfAnnee.setColumns(4);

		JLabel lblUser = new JLabel("Username :");
		add(lblUser, "14, 8, right, default");

		tfUsername = new JTextField();
		add(tfUsername, "16, 8, 3, 1, fill, default");
		tfUsername.setColumns(10);

		JLabel lblNumero = new JLabel("Adresse :");
		add(lblNumero, "4, 10, right, default");

		tfNumero = new JTextField();
		add(tfNumero, "6, 10, right, default");
		tfNumero.setColumns(3);

		tfAdresse = new JTextField();
		add(tfAdresse, "8, 10, 11, 1, fill, default");
		tfAdresse.setColumns(10);

		JLabel lblVille = new JLabel("Ville :");
		add(lblVille, "4, 12, right, default");

		tfVille = new JTextField();
		add(tfVille, "6, 12, 7, 1, fill, default");
		tfVille.setColumns(10);

		JLabel lblCodePostal = new JLabel("Code Postal :");
		add(lblCodePostal, "14, 12, right, default");

		tfCodePostal = new JTextField();
		add(tfCodePostal, "16, 12, 3, 1, fill, default");
		tfCodePostal.setColumns(6);

		JLabel lblPays = new JLabel("Pays :");
		add(lblPays, "4, 14, right, default");

		tfPays = new JTextField();
		add(tfPays, "6, 14, 7, 1, fill, default");
		tfPays.setColumns(10);

		cbIntituleAdresse = new JComboBox();
		cbIntituleAdresse
				.setModel(new DefaultComboBoxModel(new String[] { "Adresse principale", "Adresse secondaire" }));
		add(cbIntituleAdresse, "14, 14, 5, 1, fill, default");

		JLabel lblEmailPerso = new JLabel("Email perso :");
		add(lblEmailPerso, "4, 16, right, default");

		tfMailPerso = new JTextField();
		add(tfMailPerso, "6, 16, 7, 1, fill, default");
		tfMailPerso.setColumns(10);

		JLabel lblEmailPro = new JLabel("Email pro :");
		add(lblEmailPro, "14, 16, right, default");

		tfMailPro = new JTextField();
		add(tfMailPro, "16, 16, 3, 1, fill, default");
		tfMailPro.setColumns(10);

		JLabel lblTelPerso = new JLabel("Tel perso :");
		add(lblTelPerso, "4, 18, right, default");

		tfTelPerso = new JTextField();
		add(tfTelPerso, "6, 18, 7, 1, fill, default");
		tfTelPerso.setColumns(10);

		JLabel lblTelPro = new JLabel("Tel pro :");
		add(lblTelPro, "14, 18, right, default");

		tfTelPro = new JTextField();
		add(tfTelPro, "16, 18, 3, 1, fill, default");
		tfTelPro.setColumns(10);

		JLabel lblPromotion = new JLabel("Promotion :");
		add(lblPromotion, "4, 22, right, default");

		tfPromo = new JTextField();
		add(tfPromo, "6, 22, 7, 1, fill, default");
		tfPromo.setColumns(10);

		cbTypePersonne = new JComboBox();
		cbTypePersonne.setModel(new DefaultComboBoxModel(new String[] { "Etudiant", "Professeur", "Administrateur" }));
		add(cbTypePersonne, "14, 22, 5, 1, fill, default");

		JLabel lblAnneArrive = new JLabel("Ann\u00E9e arriv\u00E9e :");
		add(lblAnneArrive, "4, 24");

		tfAnneeArrivee = new JTextField();
		add(tfAnneeArrivee, "6, 24, 3, 1, fill, default");
		tfAnneeArrivee.setColumns(4);

		chckbxRedoublant = new JCheckBox("Redoublant");
		add(chckbxRedoublant, "14, 24");

		btnAjouter = new JButton("Ajouter");
		add(btnAjouter, "16, 28, 3, 1");

		btnAjouter.addActionListener(this);
		cbTypePersonne.addActionListener(this);

	}

	/**
	 * Construit le panneau d'ajout de personne.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public AjouterPersonnePanel(final Application application) {
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
				ArrayList<String> mail = new ArrayList<String>();
				mail.add(tfMailPro.getText());
				mail.add(tfMailPerso.getText());
				ArrayList<Integer> telephone = new ArrayList<Integer>();
				telephone.add(Integer.parseInt(tfTelPerso.getText()));
				telephone.add(Integer.parseInt(tfTelPro.getText()));

				Adresse nouvelleAdresse = new Adresse(new Integer(11), Integer.parseInt(tfNumero.getText()),
						tfAdresse.getText(), Integer.parseInt(tfCodePostal.getText()), tfVille.getText(),
						tfPays.getText(), cbIntituleAdresse.getSelectedItem().toString());

				getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterAdresse(nouvelleAdresse);
				getApplication().getGestionnaireModele().miseAJourListes();
				List<Adresse> listeAdresses = getApplication().getGestionnaireModele().getGestionnaireSQL()
						.recupererAdresses();
				int idAdresse = listeAdresses.get(listeAdresses.size() - 1).getId();

				if (cbTypePersonne.getSelectedIndex() == 0) {
					Etudiant etudiantACreer = new Etudiant(new Integer(11), tfNom.getText(), tfPrenom.getText(),
							Application.creerDate(Integer.parseInt(tfAnnee.getText()),
									Integer.parseInt(tfMois.getText()) - 1, Integer.parseInt(tfJour.getText())),
							idAdresse, mail, telephone, chckbxRedoublant.isSelected(),
							Application.creerDate(Integer.parseInt(tfAnneeArrivee.getText()), 0, 1),
							tfUsername.getText(), tfPromo.getText());
					getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterPersonne(etudiantACreer);

				} else if (cbTypePersonne.getSelectedIndex() == 1) {
					Professeur profACreer = new Professeur(new Integer(11), tfNom.getText(), tfPrenom.getText(),
							Application.creerDate(Integer.parseInt(tfAnnee.getText()),
									Integer.parseInt(tfMois.getText()) - 1, Integer.parseInt(tfJour.getText())),
							idAdresse, mail, telephone,
							Application.creerDate(Integer.parseInt(tfAnneeArrivee.getText()), 0, 1),
							tfUsername.getText());
					getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterPersonne(profACreer);

				} else {
					Administrateur adminACreer = new Administrateur(new Integer(11), tfNom.getText(),
							tfPrenom.getText(),
							Application.creerDate(Integer.parseInt(tfAnnee.getText()),
									Integer.parseInt(tfMois.getText()) - 1, Integer.parseInt(tfJour.getText())),
							idAdresse, mail, telephone,
							Application.creerDate(Integer.parseInt(tfAnneeArrivee.getText()), 0, 1),
							tfUsername.getText());
					getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterPersonne(adminACreer);
				}
				getApplication().getGestionnaireModele().miseAJourListes();
				JOptionPane.showMessageDialog(null,
						tfPrenom.getText() + " " + tfNom.getText() + " a bien \u00E9t\u00E9 ajout\u00E9", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (arg0.getSource() == cbTypePersonne) {
			if (cbTypePersonne.getSelectedIndex() != 0) {
				if (cbTypePersonne.getSelectedIndex() == 1)
					lblAjouterUnePersonne.setText("Ajouter un professeur");
				else
					lblAjouterUnePersonne.setText("Ajouter un administrateur");
				tfPromo.setText("");
				tfPromo.setEditable(false);
				chckbxRedoublant.setSelected(false);
				chckbxRedoublant.setEnabled(false);
			} else {
				lblAjouterUnePersonne.setText("Ajouter un \u00E9tudiant");
				tfPromo.setEditable(true);
				chckbxRedoublant.setEnabled(true);
			}
		}

	}

	/**
	 * Permet de verifier la validitee des champs.
	 */
	private String verifChamps() {

		String erreur = new String("");

		if (!Pattern.matches("[A-Za-z \\-*]{2,30}$", tfNom.getText()))
			erreur += "Rentrez un nom valide [a-zA-Z] (Entre 2 et 30 char)";

		if (!Pattern.matches("[A-Za-z \\-*]{2,30}$", tfPrenom.getText()))
			erreur += "\nRentrez un prenom valide [a-zA-Z] (Entre 2 et 30 char)";

		if (!Pattern.matches("[0-9]{1,4}$", tfNumero.getText()))
			erreur += "\nRentrez un numero de rue valide (Entre 1 et 4 chiffres)";

		if (!Pattern.matches("[A-Za-z \\-*]{2,60}$", tfAdresse.getText()))
			erreur += "\nRentrez une rue valide [a-zA-Z] (Entre 2 et 60 char)";

		if (!Pattern.matches("[a-z]{3,15}$", tfUsername.getText()))
			erreur += "\nRentrez un nom d'utilisateur [a-z] (Entre 3 et 15 char)";

		if (!Pattern.matches("[A-Za-z \\-*]{2,30}$", tfVille.getText()))
			erreur += "\nRentrez une ville valide [a-zA-Z] (Entre 2 et 30 char)";

		if (!Pattern.matches("[0-9]{5,5}$", tfCodePostal.getText()))
			erreur += "\nRentrez un code postal valide (5 chiffres)";

		if (!Pattern.matches("[A-Za-z \\-*]{2,30}$", tfPays.getText()))
			erreur += "\nRentrez un pays valide [a-zA-Z] (Entre 2 et 30 char)";

		if (!Pattern.matches("[0-9]{2,2}$", tfJour.getText()) || !Pattern.matches("^1[0-2]$|^0[1-9]$", tfMois.getText())
				|| !Pattern.matches("((19|20)\\d\\d)", tfAnnee.getText()))
			erreur += "\nRentrez une annee valide (jj mm aaaa) entre 1900 et 2099";

		if (!Pattern.matches(EMAIL_PATTERN, tfMailPerso.getText()))
			erreur += "\nRentrez un mail perso valide (*@*.*)";

		if (!Pattern.matches(EMAIL_PATTERN, tfMailPro.getText()))
			erreur += "\nRentrez un mail pro valide (*@*.*)";

		if (!Pattern.matches("[0-9]{10,10}$", tfTelPerso.getText()))
			erreur += "\nRentrez un tel perso valide (10 chiffres)";

		if (!Pattern.matches("[0-9]{10,10}$", tfTelPro.getText()))
			erreur += "\nRentrez un tel pro valide (10 chiffres)";

		if (!Pattern.matches("[A-Za-z \\-*]{2,30}$", tfPromo.getText()) && cbTypePersonne.getSelectedIndex() == 0)
			erreur += "\nRentrez une promo valide (30 char)";

		if (!Pattern.matches("((19|20)\\d\\d)", tfAnneeArrivee.getText()))
			erreur += "\nRentrez une Annee d'arrivee valide entre 1900 et 2099";
		return erreur;
	}
}
