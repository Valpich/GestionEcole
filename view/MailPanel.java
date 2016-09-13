package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import model.Matiere;
import model.Note;
import model.Semestre;

/**
 * Permet d'ajouter une personne.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class MailPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;

	private JLabel lblAjouterUnePersonne;
	private JTextField tfNom;
	private JTextField tfPrenom;
	private JTextField tfUsername;

	private JPasswordField passwordField;
	private JLabel lblConfigurationDuServeur;
	private JScrollPane scrollPane;
	private JTree tree;
	private JButton btnEnvoyerAuxConcerns;
	private JButton btnEnvoyerAuProf;

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
	public MailPanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(39dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("left:max(44dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(43dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(67dlu;pref)"),
								FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("default:grow"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec
										.decode("75px"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(10dlu;default)"), FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MailPanel.class.getResource("/resources/ESEO.png")));
		add(label, "2, 2");

		lblAjouterUnePersonne = new JLabel("Ajouter un \u00E9tudiant");
		lblAjouterUnePersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterUnePersonne, "4, 2, 15, 1, center, default");

		lblConfigurationDuServeur = new JLabel("Configuration du serveur d'envoi (smtp obligatoire) :");
		add(lblConfigurationDuServeur, "6, 4, 11, 1");

		JLabel lblNom = new JLabel("Host :");
		add(lblNom, "2, 6, 3, 1, right, default");

		tfNom = new JTextField();
		add(tfNom, "6, 6, 7, 1, fill, default");
		tfNom.setColumns(15);

		JLabel lblPrnom = new JLabel("User :");
		add(lblPrnom, "14, 6, right, default");

		tfPrenom = new JTextField();
		add(tfPrenom, "16, 6, 3, 1, fill, default");
		tfPrenom.setColumns(15);

		JLabel lblNaissance = new JLabel("Password :");
		add(lblNaissance, "2, 8, 3, 1, right, default");

		passwordField = new JPasswordField();
		add(passwordField, "6, 8, 7, 1, fill, default");

		JLabel lblUser = new JLabel("Port :");
		add(lblUser, "14, 8, right, default");

		tfUsername = new JTextField();
		add(tfUsername, "16, 8, 3, 1, fill, default");
		tfUsername.setColumns(10);

		JLabel lblVille = new JLabel("Choisir une matiere :");
		add(lblVille, "2, 12, 3, 1, right, top");

		scrollPane = new JScrollPane();
		add(scrollPane, "6, 12, 13, 13, fill, fill");

		tree = new JTree();
		scrollPane.setViewportView(tree);

		btnEnvoyerAuProf = new JButton("Envoyer au prof seulement");
		add(btnEnvoyerAuProf, "16, 26");

		btnEnvoyerAuxConcerns = new JButton("Envoyer aux concern\u00E9s");
		add(btnEnvoyerAuxConcerns, "18, 26");

	}

	/**
	 * Construit le panneau d'ajout de personne.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public MailPanel(final Application application) {
		this();
		this.setApplication(application);
		actualiserJTree();
	}

	private void actualiserJTree() {
		// Construction du noeud racine.
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Semestres");

		// Construction des diff�rents noeuds de l'arbre.
		List<Semestre> listeSemestres = getApplication().getGestionnaireModele().getSemestres();
		List<Matiere> listeMatieres = getApplication().getGestionnaireModele().getMatieres();

		DefaultMutableTreeNode[] semestres = new DefaultMutableTreeNode[getApplication().getGestionnaireModele()
				.getSemestres().size()];
		DefaultMutableTreeNode[] matieres = new DefaultMutableTreeNode[getApplication().getGestionnaireModele()
				.getMatieres().size()];
		for (int i = 0; i < listeSemestres.size(); i++) {
			semestres[i] = new DefaultMutableTreeNode(listeSemestres.get(i));
			root.add(semestres[i]);
		}

		for (int j = 0; j < listeMatieres.size(); j++) {
			matieres[j] = new DefaultMutableTreeNode(listeMatieres.get(j));

			for (int i = 0; i < listeSemestres.size(); i++) {
				if (listeMatieres.get(j).getIdSemestre().equals(listeSemestres.get(i).getId()))
					semestres[i].add(matieres[j]);
			}
		}

		// Construction du mod�le de l'arbre.
		DefaultTreeModel myModel = new DefaultTreeModel(root);

		// Construction de l'arbre.
		tree.setModel(myModel);
		scrollPane.setViewportView(tree);
	}

	/**
	 * Les actions a effectuer lors d'un evenement.
	 * 
	 * @param arg0
	 *            L'evenement a traiter.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEnvoyerAuxConcerns) {
			Matiere matiere = null;
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if (node != null)
				if (node.getUserObject() instanceof Matiere)
					matiere = (Matiere) node.getUserObject();

			List<Integer> notesInteger = new ArrayList<Integer>();
			if (matiere != null) {
				for (Note notes : getApplication().getGestionnaireModele().getNotes()) {
					if (notes.getIdMatiere().equals(matiere.getId()))
						notesInteger.add(notes.getValeur().intValue());
				}

			}
		}
	}

	/**
	 * Permet de verifier la validitee des champs.
	 */

}
