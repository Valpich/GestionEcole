package view;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import model.Etudiant;
import model.Matiere;
import model.Note;
import model.Personne;
import model.Semestre;

/**
 * Permet la creation du panneau consulter notes.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class ConsulterNotePanel extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;

	private Integer idPersonne;
	private Personne personne;

	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTree tree;
	private JList list;
	private DefaultListModel listModel;
	private JLabel lblSlctionezUnEleve;
	private JLabel lblNoteDe;

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
	 * Accesseur en lecture sur l'id de la personne.
	 * 
	 * @return L'id de la personne.
	 */
	public Integer getIdPersonne() {
		return idPersonne;
	}

	/**
	 * Accesseur en ecriture sur l'id de la personne.
	 * 
	 * @param idPersonne
	 *            Le nouvel id de la personne.
	 */
	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * Cree le panneau.
	 */
	public ConsulterNotePanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(88dlu;min)"),
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

		lblNoteDe = new JLabel("Notes de ");
		lblNoteDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNoteDe, "4, 2, 9, 1, center, default");

		lblSlctionezUnEleve = new JLabel("S\u00E9l\u00E9ctionez un \u00E9tudiant :");
		add(lblSlctionezUnEleve, "4, 4");

		scrollPane = new JScrollPane();
		// add(scrollPane, "4, 6, 1, 21, fill, fill");

		tree = new JTree();

		scrollPane_1 = new JScrollPane();
		// add(scrollPane_1, "6, 6, 7, 21, fill, fill");

		list = new JList();
		listModel = new DefaultListModel();
		list.setModel(listModel);
		scrollPane.setViewportView(list);
		list.addListSelectionListener(this);
	}

	/**
	 * Construit la classe du panneau consulter note.
	 * 
	 * @param application
	 *            L'application du panneau.
	 */
	public ConsulterNotePanel(final Application application) {
		this();
		this.setApplication(application);
		getApplication().getGestionnaireModele().miseAJourListes();

		actualiserAcces();
		actualiserEtudiant();
		if (personne != null)
			actualiserJTree();
		initialiserJList();
	}

	/**
	 * Construit la classe du panneau consulter note.
	 * 
	 * @param application
	 *            L'application du panneau.
	 * @param idPersonne
	 *            L'id de la personne.
	 */
	public ConsulterNotePanel(final Application application, Integer idPersonne) {
		this();
		this.setApplication(application);
		this.setIdPersonne(idPersonne);
		getApplication().getGestionnaireModele().miseAJourListes();

		actualiserAcces();
		actualiserEtudiant();
		if (personne != null)
			actualiserJTree();
		initialiserJList();
	}

	/**
	 * Met a jours les acces.
	 */
	private void actualiserAcces() {
		this.remove(scrollPane);
		this.remove(scrollPane_1);

		if (getApplication().getGestionnaireModele().getNiveauAcces() == 0
				|| getApplication().getGestionnaireModele().getNiveauAcces() == 1) {
			add(scrollPane, "4, 6, 1, 21, fill, fill");
			add(scrollPane_1, "6, 6, 7, 21, fill, fill");
			list.setVisible(true);
			lblSlctionezUnEleve.setVisible(true);
			scrollPane.setVisible(true);

		} else if (getApplication().getGestionnaireModele().getNiveauAcces() == 2) {
			add(scrollPane_1, "4, 6, 9, 21, fill, fill");
			list.setVisible(false);
			lblSlctionezUnEleve.setVisible(false);
			scrollPane.setVisible(false);

		} else {
			add(scrollPane_1, "4, 6, 9, 21, fill, fill");
			list.setVisible(false);
			lblSlctionezUnEleve.setVisible(false);
			scrollPane.setVisible(false);
		}
	}

	private void actualiserEtudiant() {
		if (getIdPersonne() == null) {
			idPersonne = getApplication().getGestionnaireModele().getIdUtilisateur();
		}

		if (getApplication().getGestionnaireModele().getNiveauAcces() == 2) {
			for (Etudiant etudiant : getApplication().getGestionnaireModele().getEtudiants())
				if (etudiant.getId().equals(idPersonne))
					personne = etudiant;
		}

		if (personne != null) {
			lblNoteDe.setText("Notes de " + personne);
		}
	}

	private void actualiserJTree() {
		// Construction du noeud racine.
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Semestres");

		// Construction des differents noeuds de l'arbre
		List<Semestre> listeSemestres2 = getApplication().getGestionnaireModele().getSemestres();
		List<Matiere> listeMatieres2 = getApplication().getGestionnaireModele().getMatieres();
		List<Note> listeNotes2 = getApplication().getGestionnaireModele().getNotes();

		List<Note> listeNotes = new ArrayList<Note>();
		for (int i = 0; i < listeNotes2.size(); i++) {
			if (listeNotes2.get(i).getIdEtudiant().equals(personne.getId()))
				listeNotes.add(listeNotes2.get(i));
		}

		List<Matiere> listeMatieres = new ArrayList<Matiere>();
		for (int i = 0; i < listeMatieres2.size(); i++) {
			for (int j = 0; j < listeNotes.size(); j++) {
				if (listeMatieres2.get(i).getId().equals(listeNotes.get(j).getIdMatiere()))
					listeMatieres.add(listeMatieres2.get(i));
			}
		}

		List<Semestre> listeSemestres = new ArrayList<Semestre>();
		for (int i = 0; i < listeSemestres2.size(); i++) {
			for (int j = 0; j < listeMatieres.size(); j++) {
				if (listeSemestres2.get(i).getId().equals(listeMatieres.get(j).getIdSemestre()))
					listeSemestres.add(listeSemestres2.get(i));
			}
		}

		DefaultMutableTreeNode[] semestres = new DefaultMutableTreeNode[listeSemestres.size()];
		DefaultMutableTreeNode[] matieres = new DefaultMutableTreeNode[listeMatieres.size()];
		DefaultMutableTreeNode[] notes = new DefaultMutableTreeNode[listeNotes.size()];

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

		for (int j = 0; j < listeNotes.size(); j++) {
			notes[j] = new DefaultMutableTreeNode(listeNotes.get(j));

			for (int i = 0; i < listeMatieres.size(); i++) {
				if (listeNotes.get(j).getIdMatiere().equals(listeMatieres.get(i).getId()))
					if (personne.getId().equals(listeNotes.get(j).getIdEtudiant()))
						matieres[i].add(notes[j]);
			}
		}

		for (int i = 0; i < root.getChildCount(); i++)
			if (root.getChildAt(i).isLeaf())
				root.remove(i);

		if (root.isLeaf())
			root = new DefaultMutableTreeNode("Aucune note");

		// Construction du modele de l'arbre.
		DefaultTreeModel myModel = new DefaultTreeModel(root);

		// Construction de l'arbre.
		tree.setModel(myModel);
		scrollPane_1.setViewportView(tree);
		int row = 0;
		while (row < tree.getRowCount()) {
			tree.expandRow(row);
			row++;
		}
	}

	void initialiserJList() {

		List<Etudiant> etudiants = getApplication().getGestionnaireModele().getEtudiants();

		for (int i = 0; i < etudiants.size(); i++)
			listModel.addElement(etudiants.get(i));
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if (arg0.getSource() == list) {
			if (!list.isSelectionEmpty()) {
				personne = (Personne) list.getSelectedValue();
				if (personne != null) {
					lblNoteDe.setText("Notes de " + personne);
					actualiserJTree();
				}
			}
		}
	}

}
