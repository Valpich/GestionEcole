package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

import model.Matiere;
import model.Semestre;
import model.UniteEnseignement;

/**
 * Permet d'ajouter un ue.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AjouterUEPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;
	private JTextField tfNomUE;
	private JTextField tfCoeff;
	private JButton btnAjouter;
	private JButton btnAddMatiere;
	private JButton btnDelMatiere;
	private JLabel lblCoefficient_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTree tree;
	private JList list;
	private DefaultListModel listModel;

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
	public AjouterUEPanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(101dlu;default):grow"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
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

		JLabel lblAjouterMatiere = new JLabel("Ajouter UE");
		lblAjouterMatiere.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAjouterMatiere, "4, 2, 9, 1, center, default");

		scrollPane = new JScrollPane();
		add(scrollPane, "4, 6, 3, 17, fill, fill");

		tree = new JTree();

		btnAddMatiere = new JButton(">");
		add(btnAddMatiere, "8, 6, center, bottom");
		btnAddMatiere.addActionListener(this);

		scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "10, 6, 3, 17, fill, fill");

		list = new JList();
		listModel = new DefaultListModel();
		list.setModel(listModel);
		scrollPane_1.setViewportView(list);

		btnDelMatiere = new JButton("<");
		add(btnDelMatiere, "8, 8, center, default");
		btnDelMatiere.addActionListener(this);

		JLabel lblNom = new JLabel("Nom :");
		add(lblNom, "4, 24, right, bottom");

		tfNomUE = new JTextField();
		add(tfNomUE, "6, 24, 5, 1, fill, bottom");
		tfNomUE.setColumns(10);

		lblCoefficient_1 = new JLabel("Coefficient :");
		add(lblCoefficient_1, "4, 26, right, default");

		tfCoeff = new JTextField();
		add(tfCoeff, "6, 26, left, default");
		tfCoeff.setColumns(2);

		btnAjouter = new JButton("Ajouter");
		add(btnAjouter, "10, 28, right, default");
		btnAjouter.addActionListener(this);
	}

	/**
	 * Construit le panneau d'ajout d'ue.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public AjouterUEPanel(final Application application) {
		this();
		this.setApplication(application);
		getApplication().getGestionnaireModele().miseAJourListes();

		initialiserJTree();

	}

	/**
	 * Permet l'actualisation des composants.
	 */
	private void initialiserJTree() {
		// Construction du noeud racine.
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Semestres");

		// Construction des differents noeuds de l'arbre.
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

		// Construction du modele de l'arbre.
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
		if (arg0.getSource() == btnAddMatiere) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if (node != null) {
				if (node.getUserObject() instanceof Matiere) {
					if (!listModel.contains(node.getUserObject())) {
						listModel.addElement(node.getUserObject());
					}
				}
			}
		}

		if (arg0.getSource() == btnDelMatiere) {
			if (!list.isSelectionEmpty())
				listModel.removeElement(list.getSelectedValue());
		}

		if (arg0.getSource() == btnAjouter) {
			String erreur = verifChamps();
			if (erreur.length() > 3)
				JOptionPane.showMessageDialog(null, erreur, "Erreur", JOptionPane.ERROR_MESSAGE);
			else {
				if (!listModel.isEmpty()) {

					List<Integer> idMatieres = new ArrayList<Integer>();
					for (int i = 0; i < listModel.getSize(); i++)
						idMatieres.add(((Matiere) listModel.get(i)).getId());

					UniteEnseignement newUE = new UniteEnseignement(tfNomUE.getText(),
							Double.parseDouble(tfCoeff.getText()), idMatieres);
					getApplication().getGestionnaireModele().getGestionnaireSQL().ajouterUe(newUE);
					getApplication().getGestionnaireModele().miseAJourListes();
					JOptionPane.showMessageDialog(null,
							"L'UE " + tfNomUE.getText() + " a bien \u00E9t\u00E9 ajout\u00E9", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	/**
	 * Permet de verifier la validitee des champs.
	 */
	private String verifChamps() {

		String erreur = new String("");

		if (tfNomUE.getText().isEmpty())
			erreur += "Rentrez un nom d'UE valide";

		if (!Pattern.matches("[0-9]{1,5}$", tfCoeff.getText()))
			erreur += "\nRentrez un coefficient valide";

		return erreur;
	}
}
