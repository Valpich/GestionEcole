package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import model.Adresse;

/**
 * Permet d'afficher la liste des administrateurs.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class ListeDesAdministrateursPanel extends JPanel implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;

	private JList jlist;
	private JLabel lblNom;
	private JLabel lblDateNaissance;
	private JLabel lblPrenom;
	private JLabel lblRue;
	private JLabel lblCodePostalEtVille;
	private JLabel lblPays;
	private JLabel lblEmailPerso;
	private JLabel lblEmailPro;
	private JLabel lblTelPro;
	private JLabel lblTelPerso;
	private JLabel lblAnneeArrivee;
	private JButton btnModifierProfil;

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
	public ListeDesAdministrateursPanel() {
		setLayout(new FormLayout(new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px:grow"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(29dlu;default)"), FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("left:default:grow"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(43dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(67dlu;pref)"), FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"), },
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
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AjouterPersonnePanel.class.getResource("/resources/ESEO.png")));
		add(label, "2, 2");

		JLabel lblAjouterUnePersonne = new JLabel("Liste des administrateurs");
		lblAjouterUnePersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterUnePersonne, "6, 2, 15, 1, center, default");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 6, 5, 31, fill, fill");

		jlist = new JList();
		scrollPane.setViewportView(jlist);

		lblNom = new JLabel(" ");
		add(lblNom, "16, 6, left, default");

		lblDateNaissance = new JLabel(" ");
		add(lblDateNaissance, "18, 6, right, default");

		lblPrenom = new JLabel(" ");
		add(lblPrenom, "16, 8, left, default");

		JLabel lblHabbiteAu = new JLabel("Habite au :");
		add(lblHabbiteAu, "8, 12, right, default");

		lblRue = new JLabel(" ");
		add(lblRue, "16, 12, 3, 1");

		lblCodePostalEtVille = new JLabel(" ");
		add(lblCodePostalEtVille, "16, 14, 3, 1, left, default");

		lblPays = new JLabel(" ");
		add(lblPays, "16, 16, 3, 1, left, default");

		JLabel lblEmail = new JLabel("E-mail :");
		add(lblEmail, "8, 20, right, default");

		lblEmailPerso = new JLabel(" ");
		add(lblEmailPerso, "16, 20, 3, 1");

		lblEmailPro = new JLabel(" ");
		add(lblEmailPro, "16, 22, 3, 1");

		JLabel lblTelephone = new JLabel("T\u00E9l\u00E9phone :");
		add(lblTelephone, "8, 26, right, default");

		lblTelPro = new JLabel(" ");
		add(lblTelPro, "16, 26");

		lblTelPerso = new JLabel(" ");
		add(lblTelPerso, "16, 28");

		lblAnneeArrivee = new JLabel("Inscrit depuis ");
		add(lblAnneeArrivee, "16, 32, right, default");

		btnModifierProfil = new JButton("Modifier le profil");
		add(btnModifierProfil, "18, 36, right, default");

		btnModifierProfil.addActionListener(this);
		jlist.addListSelectionListener(this);

	}

	/**
	 * Construit le panneau d'affichage de la liste des admnistrateurs.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public ListeDesAdministrateursPanel(final Application application) {
		this();
		this.setApplication(application);

		getApplication().getGestionnaireModele().miseAJourListes();

		DefaultListModel listModel = new DefaultListModel();

		for (int i = 0; i < getApplication().getGestionnaireModele().getAdministrateurs().size(); i++)
			listModel
					.addElement(new String(getApplication().getGestionnaireModele().getAdministrateurs().get(i).getNom()
							+ "  " + getApplication().getGestionnaireModele().getAdministrateurs().get(i).getPrenom()));

		jlist.setModel(listModel);
		jlist.addListSelectionListener(this);
	}

	/**
	 * Les actions a effectuer lors d'un evenement.
	 * 
	 * @param arg0
	 *            L'evenement a traiter.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModifierProfil) {
			if (!jlist.isSelectionEmpty()) {
				Integer idPersonne = getApplication().getGestionnaireModele().getAdministrateurs()
						.get(jlist.getSelectedIndex()).getId();
				getApplication().changerPanel(new ModifierProfilPanel(getApplication(), idPersonne));
			}
		}
	}

	/**
	 * Les actions a effectuer lors d'un evenement.
	 * 
	 * @param arg0
	 *            L'evenement a traiter.
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {

		if (arg0.getSource() == jlist) {

			DecimalFormat telephone = new DecimalFormat("0000000000");

			lblNom.setText(getApplication().getGestionnaireModele().getAdministrateurs().get(jlist.getSelectedIndex())
					.getNom());
			lblPrenom.setText(getApplication().getGestionnaireModele().getAdministrateurs()
					.get(jlist.getSelectedIndex()).getPrenom());
			String date = new SimpleDateFormat("dd/MM/yyyy").format(getApplication().getGestionnaireModele()
					.getAdministrateurs().get(jlist.getSelectedIndex()).getDateDeNaissance());
			lblDateNaissance.setText(date);
			lblEmailPerso.setText(getApplication().getGestionnaireModele().getAdministrateurs()
					.get(jlist.getSelectedIndex()).getEmailPersonnel());
			lblEmailPro.setText(getApplication().getGestionnaireModele().getAdministrateurs()
					.get(jlist.getSelectedIndex()).getEmailProfessionnel());
			lblTelPro.setText(telephone.format(getApplication().getGestionnaireModele().getAdministrateurs()
					.get(jlist.getSelectedIndex()).getTelephoneFixe()));
			lblTelPerso.setText(telephone.format(getApplication().getGestionnaireModele().getAdministrateurs()
					.get(jlist.getSelectedIndex()).getTelephoneMobile()));
			String anneeArrivee = new SimpleDateFormat("yyyy").format(getApplication().getGestionnaireModele()
					.getAdministrateurs().get(jlist.getSelectedIndex()).getAnneeArrivee());
			lblAnneeArrivee.setText("Inscrit depuis " + anneeArrivee);

			Integer idAdresse = getApplication().getGestionnaireModele().getAdministrateurs()
					.get(jlist.getSelectedIndex()).getIdAdresse();
			Adresse adresseAssociee = null;
			for (int i = 0; i < getApplication().getGestionnaireModele().getAdresses().size(); i++) {
				Integer id = getApplication().getGestionnaireModele().getAdresses().get(i).getId();
				if (id.equals(idAdresse))
					adresseAssociee = getApplication().getGestionnaireModele().getAdresses().get(i);
			}
			if (adresseAssociee != null) {
				lblRue.setText(adresseAssociee.getNumero() + " " + adresseAssociee.getRue());
				lblCodePostalEtVille.setText(adresseAssociee.getCodePostal() + " " + adresseAssociee.getVille());
				lblPays.setText(adresseAssociee.getPays());
			}
		}
	}
}
