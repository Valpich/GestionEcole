package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import model.Etudiant;
import model.Matiere;
import model.Note;
import model.Semestre;

/**
 * Permet d'ajouter une note.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AjouterNotePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;
	private JTextField tfNomDevoir;
	private JButton btnAjouter;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTree tree;
	private JList list;
	private DefaultListModel listModel;
	private JLabel lblSlctionezUneMatire;
	private JLabel lblSlctionnezUnlve;
	private JTextField tfNote;
	private JLabel lblNote;
	private JLabel lblCoeffDuDevoir;
	private JTextField tfCoeff;

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
	public AjouterNotePanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(101dlu;default):grow"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(43dlu;default):grow"),
								FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("max(67dlu;pref)"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec
										.decode("75px"), },
				new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(27dlu;default):grow"), FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("max(10dlu;default)"),
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AjouterPersonnePanel.class.getResource("/resources/ESEO.png")));
		add(label, "2, 2");

		JLabel lblAjouterNote = new JLabel("Ajouter note");
		lblAjouterNote.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterNote, "4, 2, 9, 1, center, default");

		lblSlctionezUneMatire = new JLabel("S\u00E9l\u00E9ctionez une mati\u00E8re :");
		add(lblSlctionezUneMatire, "4, 4");

		lblSlctionnezUnlve = new JLabel("S\u00E9l\u00E9ctionnez un \u00E9l\u00E8ve :");
		add(lblSlctionnezUnlve, "10, 4");

		scrollPane = new JScrollPane();
		add(scrollPane, "4, 6, 3, 15, fill, fill");

		tree = new JTree();

		scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "10, 6, 3, 15, fill, fill");

		list = new JList();
		listModel = new DefaultListModel();
		list.setModel(listModel);
		scrollPane_1.setViewportView(list);

		JLabel lblNom = new JLabel("Nom du devoir :");
		add(lblNom, "4, 22, right, bottom");

		tfNomDevoir = new JTextField();
		add(tfNomDevoir, "6, 22, 5, 1, fill, bottom");
		tfNomDevoir.setColumns(10);

		lblCoeffDuDevoir = new JLabel("Coeff du devoir :");
		add(lblCoeffDuDevoir, "4, 24, right, default");

		tfCoeff = new JTextField();
		add(tfCoeff, "6, 24, left, default");
		tfCoeff.setColumns(2);

		lblNote = new JLabel("Note /20 :");
		add(lblNote, "4, 26, right, default");

		tfNote = new JTextField();
		add(tfNote, "6, 26, 3, 1, left, default");
		tfNote.setColumns(2);

		btnAjouter = new JButton("Ajouter");
		add(btnAjouter, "10, 26, right, default");
		btnAjouter.addActionListener(this);
	}

	/**
	 * Construit le panneau d'ajout de note.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public AjouterNotePanel(final Application application) {
		this();
		this.setApplication(application);
		getApplication().getGestionnaireModele().miseAJourListes();

		initialiserJTree();
		initialiserJList();

	}

	/**
	 * Permet l'initialisation de l'arbre.
	 */
	private void initialiserJTree() {
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
	 * Permet l'actualisation des composants.
	 */
	void initialiserJList() {

		List<Etudiant> etudiants = getApplication().getGestionnaireModele().getEtudiants();

		for (int i = 0; i < etudiants.size(); i++)
			listModel.addElement(etudiants.get(i));
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

				Etudiant etudiant = null;
				if (!listModel.isEmpty())
					etudiant = (Etudiant) list.getSelectedValue();

				Matiere matiere = null;
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node != null)
					if (node.getUserObject() instanceof Matiere)
						matiere = (Matiere) node.getUserObject();

				if (etudiant != null && matiere != null) {
					Note newNote = new Note(new Integer(11), tfNomDevoir.getText(),
							Double.parseDouble(tfNote.getText()), Double.parseDouble(tfCoeff.getText()), etudiant,
							matiere);
					getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterNote(newNote);
					getApplication().getGestionnaireModele().miseAJourListes();
					JOptionPane.showMessageDialog(null,
							"La note du devoir " + tfNomDevoir.getText()
									+ " a bien \u00E9t\u00E9 ajout\u00E9 \u00E0 l'\u00E9tudiant " + etudiant,
							"Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	/**
	 * Permet de verifier la validitee des champs.
	 */
	private String verifChamps() {

		String erreur = new String("");

		if (tfNomDevoir.getText().isEmpty())
			erreur += "Rentrez un nom de note valide";

		if (!Pattern.matches("[0-9]{1,5}$", tfCoeff.getText()))
			erreur += "\nRentrez un coefficient valide";

		if (!Pattern.matches("[0-9]{1,5}$", tfCoeff.getText()) || Double.parseDouble(tfNote.getText()) < 0
				|| Double.parseDouble(tfNote.getText()) > 20)
			erreur += "\nRentrez un nom de note valide (entre 0 et 20)";

		return erreur;
	}
}
