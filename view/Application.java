package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Date;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.ExportSQL;
import model.GestionnaireModele;

/**
 * Classe principale du programme, celle-ci permet de lancer le programme.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Application implements MouseListener {
	final private Application application = this;
	static private JFrame frmProjetjava;
	private GestionnaireModele gestionnaireModele;

	private JMenuBar menuBar;

	private JMenu mnUtilisateur;
	private JMenuItem mntmSeConnecter;
	private JMenuItem mntmSeDeconnecter;
	private JMenuItem mntmModifierMonProfil;
	private JMenuItem mntmConsulterMesNotes;

	private JMenu mnFichier;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmRedimensionner;

	private JMenu mnOprations;
	private JMenu mnConsulter;
	private JMenuItem mntmConsulterNoteEtudiant;
	private JMenuItem mntmListeEtudiants;
	private JMenuItem mntmListeProfesseurs;
	private JMenuItem mntmListeAdministrateurs;
	private JMenu mnAjouter;
	private JMenuItem mntmAjouterPersonne;
	private JMenuItem mntmAjouterSemestre;
	private JMenuItem mntmAjouterUE;
	private JMenuItem mntmAjouterMatiere;
	private JMenuItem mntmAjouterNote;

	private JMenu mnGestionnaireBDD;
	private JMenuItem mntmCreeBDD;
	private JMenuItem mntmViderBDD;
	private JMenuItem mntmHistoriqueDesInstructions;
	private JMenuItem mntmViderLhistoriqueDes;
	private JMenuItem mntmMAJListes;

	private JMenu mnEmail;
	private JMenuItem mntmEnvoyerUnGraphique;
	private JMenuItem mntmModifierLesReglages;

	private JMenu mnAide;
	private JMenuItem mntmAfficherLaide;
	private JMenuItem mntmAfficherAbout;
	private JMenuItem mntmJouerAuTetris;

	/**
	 * Accesseur en lecture sur la fenetre du programme.
	 * 
	 * @return La fenetre du programme.
	 */
	public static JFrame getFrmProjetjava() {
		return frmProjetjava;
	}

	/**
	 * Accesseur en ecriture de la fenetre du programme.
	 * 
	 * @param frmProjetjava
	 *            La fenetre du programme.
	 */
	public static void setFrmProjetjava(JFrame frmProjetjava) {
		Application.frmProjetjava = frmProjetjava;
	}

	public Application getApplication() {
		return application;
	}

	/**
	 * Methode principale permettant le lancement du programme.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new File("Logs").mkdir();
					@SuppressWarnings("unused")
					Application window = new Application();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construit l'application par défaut.
	 */
	public Application() {
		initialize();
	}

	private void intialiserMenuBar() {

		menuBar = new JMenuBar();
		frmProjetjava.setJMenuBar(menuBar);

		// ######### Menu Fichier
		mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		mntmRedimensionner = new JMenuItem("Redimensionner");
		mntmRedimensionner.addMouseListener(this);
		mnFichier.add(mntmRedimensionner);

		mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addMouseListener(this);

		mntmJouerAuTetris = new JMenuItem("Jouer au Tetris");
		mntmJouerAuTetris.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Tetris.Tetris.main(null);
			}
		});
		mnFichier.add(mntmJouerAuTetris);
		mnFichier.add(mntmQuitter);
		// ######### FIN Menu Fichier

		// ######### Menu Utilisateur
		mnUtilisateur = new JMenu("Utilisateur");
		menuBar.add(mnUtilisateur);

		mntmSeConnecter = new JMenuItem("Se connecter");
		mntmSeConnecter.addMouseListener(this);
		mnUtilisateur.add(mntmSeConnecter);

		mntmModifierMonProfil = new JMenuItem("Modifier mon profil");
		mntmModifierMonProfil.addMouseListener(this);
		mnUtilisateur.add(mntmModifierMonProfil);

		mntmConsulterMesNotes = new JMenuItem("Consulter mes notes");
		mntmConsulterMesNotes.addMouseListener(this);
		mnUtilisateur.add(mntmConsulterMesNotes);

		mntmSeDeconnecter = new JMenuItem("Se d\u00E9connecter");
		mntmSeDeconnecter.addMouseListener(this);
		mnUtilisateur.add(mntmSeDeconnecter);
		// ######### FIN Menu Utilisateur

		// ######### Menu Operations
		mnOprations = new JMenu("Operations");
		menuBar.add(mnOprations);

		mnConsulter = new JMenu("Consulter");
		mnOprations.add(mnConsulter);

		mntmListeEtudiants = new JMenuItem("Liste des \u00E9tudiants");
		mntmListeEtudiants.addMouseListener(this);
		mnConsulter.add(mntmListeEtudiants);

		mntmListeProfesseurs = new JMenuItem("Liste des professeurs");
		mntmListeProfesseurs.addMouseListener(this);
		mnConsulter.add(mntmListeProfesseurs);

		mntmListeAdministrateurs = new JMenuItem("Liste des administrateurs");
		mntmListeAdministrateurs.addMouseListener(this);
		mnConsulter.add(mntmListeAdministrateurs);

		mntmConsulterNoteEtudiant = new JMenuItem("Consulter notes etudiant");
		mntmConsulterNoteEtudiant.addMouseListener(this);
		mnConsulter.add(mntmConsulterNoteEtudiant);

		mnAjouter = new JMenu("Ajouter");
		mnOprations.add(mnAjouter);

		mntmAjouterPersonne = new JMenuItem("Ajouter une personne");
		mntmAjouterPersonne.addMouseListener(this);
		mnAjouter.add(mntmAjouterPersonne);

		mntmAjouterSemestre = new JMenuItem("Ajouter un semestre");
		mntmAjouterSemestre.addMouseListener(this);
		mnAjouter.add(mntmAjouterSemestre);

		mntmAjouterMatiere = new JMenuItem("Ajouter une mati\u00E8re");
		mntmAjouterMatiere.addMouseListener(this);
		mnAjouter.add(mntmAjouterMatiere);

		mntmAjouterUE = new JMenuItem("Ajouter un UE");
		mntmAjouterUE.addMouseListener(this);
		mnAjouter.add(mntmAjouterUE);

		mntmAjouterNote = new JMenuItem("Ajouter une note");
		mntmAjouterNote.addMouseListener(this);
		mnAjouter.add(mntmAjouterNote);

		// ######### Fin Menu Operation

		// ######### Menu GestionnaireBDD
		mnGestionnaireBDD = new JMenu("Gestionnaire BDD");
		menuBar.add(mnGestionnaireBDD);

		mntmCreeBDD = new JMenuItem("Creer la base de donnees");
		mntmCreeBDD.addMouseListener(this);
		mnGestionnaireBDD.add(mntmCreeBDD);

		mntmViderBDD = new JMenuItem("Vider la base de donnees");
		mntmViderBDD.addMouseListener(this);
		mnGestionnaireBDD.add(mntmViderBDD);

		mntmHistoriqueDesInstructions = new JMenuItem("Historique des instructions SQL");
		mntmHistoriqueDesInstructions.addMouseListener(this);
		mnGestionnaireBDD.add(mntmHistoriqueDesInstructions);

		mntmViderLhistoriqueDes = new JMenuItem("Vider l'historique des instructions SQL");
		mntmViderLhistoriqueDes.addMouseListener(this);
		mnGestionnaireBDD.add(mntmViderLhistoriqueDes);

		mntmMAJListes = new JMenuItem("Mise \u00E0 jour des listes");
		mntmMAJListes.addMouseListener(this);
		mnGestionnaireBDD.add(mntmMAJListes);
		// ######### Fin Menu GestionnaireBDD

		// ######### Menu Mail
		mnEmail = new JMenu("E-Mail");
		menuBar.add(mnEmail);

		mntmEnvoyerUnGraphique = new JMenuItem("Envoyer le graphique des notes d'un devoir");
		mnEmail.add(mntmEnvoyerUnGraphique);
		mntmEnvoyerUnGraphique.addMouseListener(this);

		mntmModifierLesReglages = new JMenuItem("Modifier les reglages de l'adresse mail");
		mnEmail.add(mntmModifierLesReglages);
		mntmModifierLesReglages.addMouseListener(this);
		// ######### Fin Menu Mail

		// ######### Menu Aide
		mnAide = new JMenu("Aide");
		menuBar.add(mnAide);

		mntmAfficherLaide = new JMenuItem("Afficher l'aide");
		mntmAfficherLaide.addMouseListener(this);
		mnAide.add(mntmAfficherLaide);

		mntmAfficherAbout = new JMenuItem("About");
		mntmAfficherAbout.addMouseListener(this);
		mnAide.add(mntmAfficherAbout);
		// ######### Fin Menu Aide

	}

	private void actualiserMenuBar() {

		mnUtilisateur.setVisible(false);
		mntmSeConnecter.setVisible(false);
		mntmModifierMonProfil.setVisible(false);
		mntmConsulterMesNotes.setVisible(false);
		mntmSeDeconnecter.setVisible(false);

		mnOprations.setVisible(false);
		mnConsulter.setVisible(false);
		mntmListeEtudiants.setVisible(false);
		mntmListeEtudiants.setVisible(false);
		mntmListeProfesseurs.setVisible(false);
		mntmListeAdministrateurs.setVisible(false);
		mntmConsulterNoteEtudiant.setVisible(false);
		mnAjouter.setVisible(false);
		mntmAjouterPersonne.setVisible(false);
		mntmAjouterUE.setVisible(false);
		mntmAjouterMatiere.setVisible(false);
		mntmAjouterSemestre.setVisible(false);
		mntmAjouterNote.setVisible(false);

		mnGestionnaireBDD.setVisible(false);
		mntmCreeBDD.setVisible(false);
		mntmViderBDD.setVisible(false);
		mntmHistoriqueDesInstructions.setVisible(false);
		mntmViderLhistoriqueDes.setVisible(false);
		mntmMAJListes.setVisible(false);

		mnEmail.setVisible(false);
		mntmEnvoyerUnGraphique.setVisible(false);
		mntmModifierLesReglages.setVisible(false);

		if (getGestionnaireModele().getNiveauAcces() == -1) {
			mnUtilisateur.setVisible(true);
			mntmSeConnecter.setVisible(true);

		} else if (getGestionnaireModele().getNiveauAcces() == 0) {
			mnUtilisateur.setVisible(true);
			mntmModifierMonProfil.setVisible(true);
			mntmSeDeconnecter.setVisible(true);

			mnOprations.setVisible(true);
			mnConsulter.setVisible(true);
			mnAjouter.setVisible(true);
			mntmAjouterPersonne.setVisible(true);
			mntmListeEtudiants.setVisible(true);
			mntmListeProfesseurs.setVisible(true);
			mntmListeAdministrateurs.setVisible(true);
			mntmConsulterNoteEtudiant.setVisible(true);
			mntmAjouterUE.setVisible(true);
			mntmAjouterMatiere.setVisible(true);
			mntmAjouterSemestre.setVisible(true);
			mntmAjouterNote.setVisible(true);

			mnGestionnaireBDD.setVisible(true);
			mntmCreeBDD.setVisible(true);
			mntmViderBDD.setVisible(true);
			mntmHistoriqueDesInstructions.setVisible(true);
			mntmViderLhistoriqueDes.setVisible(true);
			mntmMAJListes.setVisible(true);

			mnEmail.setVisible(true);
			mntmEnvoyerUnGraphique.setVisible(true);
			mntmModifierLesReglages.setVisible(true);

		} else if (getGestionnaireModele().getNiveauAcces() == 1) {
			mnUtilisateur.setVisible(true);
			mntmModifierMonProfil.setVisible(true);
			mntmSeDeconnecter.setVisible(true);

			mnOprations.setVisible(true);
			mnConsulter.setVisible(true);
			mntmListeEtudiants.setVisible(true);
			mntmConsulterNoteEtudiant.setVisible(true);
			mnAjouter.setVisible(true);
			mntmAjouterNote.setVisible(true);

		} else if (getGestionnaireModele().getNiveauAcces() == 2) {
			mnUtilisateur.setVisible(true);
			mntmModifierMonProfil.setVisible(true);
			mntmConsulterMesNotes.setVisible(true);
			mntmSeDeconnecter.setVisible(true);
		}

	}

	/**
	 * Initialisation du contenu de la fenetre.
	 */
	private void initialize() {
		frmProjetjava = new JFrame();
		frmProjetjava.setTitle("projet_java");
		frmProjetjava.setBounds(0, 0, 720, 480);
		frmProjetjava.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmProjetjava.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(new JFrame(),
						"Vous allez quitter le programme.\nAttention vous serez d\u00E9connect\u00E9!",
						"Fermeture du programme", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
					try {
						getGestionnaireModele().getGestionnaireSQL().getExporterSQLSuccess().close();
						getGestionnaireModele().getGestionnaireSQL().getExporterSQLFail().close();
					} catch (Exception exception) {
						exception.printStackTrace();
					} finally {
						System.exit(0);
					}
				} else {

				}
			}
		});

		setGestionnaireModele(new GestionnaireModele());
		Application.getFrmProjetjava().setLocationRelativeTo(null);
		Application.getFrmProjetjava().setVisible(true);

		intialiserMenuBar();
		actualiserMenuBar();

		changerPanel(new AuthentificationPanel(this));

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// Zone de test !
					// test.ajouterNote(new Note("Informatique 1", 12.54, 4, 2,
					// 6));
					// test.ajouterMatiere(new
					// Matière(null,1,"Test",8.5,2,null));
					// test.ajouterSemestre(new
					// Semestre(null,Application.creerDate(90,8,3),Application.creerDate(91,1,27),"TestSemestreBisBis",1));
					/*
					 * ArrayList<String> mail= new ArrayList<String>();
					 * mail.add("etuMailProf@test.com");
					 * mail.add("etuMailPerso@test.com"); ArrayList<Integer>
					 * telephone= new ArrayList<Integer>();
					 * telephone.add(212345678); telephone.add(612345678);
					 * test.ajouterPersonne(new Etudiant(null,
					 * "nomEtudiantTest", "prenomEtudiantTest", new
					 * Integer(2),mail, telephone,
					 * false,Application.creerDate(1990, 1,
					 * 1),"PromoTestEtudiant","identifiantTest"));
					 */
					// test.ajouterAdresse(new Adresse(null, 12, "rue de test",
					// new
					// Integer(48372), "VilleTest", "TestLand","AdresseTest"));
					// test.supprimerMatiere(27);
					// test.supprimerNote(2);
					// test.getExporterSQLSuccess().close();
					// test.getExporterSQLFail().close();
					// test.supprimerAdresse(104);
					/*
					 * long chrono = java.lang.System.currentTimeMillis() ;
					 * test.recupererNotes();
					 * System.out.println(java.lang.System.currentTimeMillis()-
					 * chrono);
					 */
					/*
					 * for(Note note :test.recupererNotes()){
					 * System.out.println(note.toString()); }
					 */
					/*
					 * for(Professeur professeur :test.recupererProfesseurs()){
					 * System.out.println(professeur.toString()); }
					 */
					/*
					 * for(Administrateur
					 * administrateur:test.recupererAdministrateurs()){
					 * System.out.println(administrateur.toString()); }
					 */
					/*
					 * for (Etudiant etudiant : test.recupererEtudiants(null)) {
					 * System.out.println(etudiant.toString()); }
					 */
					/*
					 * for(Etudiant etudiant:test.recupererEtudiants(new String(
					 * "De Gennes" ))){ System.out.println(etudiant.toString());
					 * }
					 */
					/*
					 * for(Matière matière:test.recupererMatieres()){
					 * System.out.println(matière.toString()); }
					 */

					/*
					 * for(Adresse
					 * adresse:test.getGestionnaireSQL().recupererAdresses()){
					 * System.out.println(adresse.toString()); }
					 */
					/*
					 * for(Semestre semestre:test.recupererSemestres()){
					 * System.out.println(semestre.toString()); }
					 */
					// List<Note> notes =
					// getGestionnaireModele().getGestionnaireSQL().recupererNotes();
					/*
					 * for (Note note : notes) { note.setNom("A");
					 * note.setIdEtudiant(113); note.setValeur(8.2);
					 * note.setCoefficient(1.25);
					 * getGestionnaireModele().getGestionnaireSQL().altererNote(
					 * note); }
					 */
					/*
					 * List<Etudiant> tmp =
					 * getGestionnaireModele().getGestionnaireSQL().
					 * recupererEtudiants(null);
					 * tmp.get(0).setIdentifiant("testUpdate");
					 * getGestionnaireModele().getGestionnaireSQL().
					 * altererPersonne(tmp.get(0));
					 */
					/*
					 * List<Adresse> tmp =
					 * getGestionnaireModele().getGestionnaireSQL().
					 * recupererAdresses(); tmp.get(0).setPays("paysUpdate");
					 * getGestionnaireModele().getGestionnaireSQL().
					 * altererAdresse(tmp.get(0));
					 */
					/*
					 * List<Matiere> tmp =
					 * getGestionnaireModele().getGestionnaireSQL().
					 * recupererMatieres(); tmp.get(0).setCoefficient(0.14);
					 * getGestionnaireModele().getGestionnaireSQL().
					 * altererMatiere(tmp.get(0));
					 */
					/*
					 * List<Semestre> tmp =
					 * getGestionnaireModele().getGestionnaireSQL().
					 * recupererSemestres(); tmp.get(0).setNom("updateTest");
					 * getGestionnaireModele().getGestionnaireSQL().
					 * altererSemestre(tmp.get(0));
					 */
					// Application.emailNotes(notes);

					// getGestionnaireModele().getGestionnaireSQL().viderBaseDeDonnee();
					// getGestionnaireModele().getGestionnaireSQL().creerBaseDeDonnee();
					/*
					 * List<UniteEnseignement> ues =
					 * getGestionnaireModele().getGestionnaireSQL().recupererUe(
					 * ); for(UniteEnseignement ue : ues){
					 * System.out.println(ue); }
					 */
					/*
					 * ArrayList<Integer> listeTest = new ArrayList<Integer>();
					 * listeTest.add(new Integer(3)); listeTest.add(new
					 * Integer(4)); UniteEnseignement test = new
					 * UniteEnseignement("testEnvoi",2.3,listeTest);
					 * getGestionnaireModele().getGestionnaireSQL().ajouterUe(
					 * test);
					 */
					Application.getFrmProjetjava().validate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Methode statique permettant de creer une date sans decalage de 1990
	 * annees.
	 * 
	 * @param annee
	 *            L'annee.
	 * @param mois
	 *            Le mois.
	 * @param jour
	 *            Le jour.
	 * @return La date.
	 */
	@SuppressWarnings("deprecation")
	public static final Date creerDate(int annee, int mois, int jour) {
		// if(annee<2000)
		return new Date(annee - 1900, mois, jour);
		// else
		// return new Date(annee, mois, jour);
	}

	public GestionnaireModele getGestionnaireModele() {
		return gestionnaireModele;
	}

	public void setGestionnaireModele(GestionnaireModele gestionnaireModele) {
		this.gestionnaireModele = gestionnaireModele;
	}

	public void changerPanel(Component nouveauPanel) {
		actualiserMenuBar();
		Application.getFrmProjetjava().getContentPane().removeAll();
		Application.getFrmProjetjava().getContentPane().add(nouveauPanel);
		Application.getFrmProjetjava().validate();
		Application.getFrmProjetjava().repaint();
	}

	public void redimensionnerFenetre() {
		JFrame maFenetre = Application.getFrmProjetjava();
		Object[] possibilities = { "480*320", "720*480", "1280*720", "R\u00E9solution maximale" };
		String s = (String) JOptionPane.showInputDialog(new JFrame(), "Choisir votre r\u00E9solution:\n",
				"Changement de la r\u00E9solution d'affichage du programme", JOptionPane.PLAIN_MESSAGE,
				(Icon) new JFrame().getIconImage(), possibilities, "Choix");
		if ((s != null) && (s.length() > 0)) {
			GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle maximumWindowBounds = graphicsEnvironment.getMaximumWindowBounds();
			if (s.equals("480*320")) {
				if ((maximumWindowBounds.getHeight() >= 320) && (maximumWindowBounds.getWidth() >= 480)) {
					maFenetre.setSize(new Dimension(480, 320));
				} else {
					maFenetre.setSize(new Dimension(maximumWindowBounds.width, maximumWindowBounds.height));
				}
			}
			if (s.equals("720*480")) {
				if ((maximumWindowBounds.getHeight() >= 480) && (maximumWindowBounds.getWidth() >= 720)) {
					maFenetre.setSize(new Dimension(720, 480));
				} else {
					maFenetre.setSize(new Dimension(maximumWindowBounds.width, maximumWindowBounds.height));
				}
			}
			if (s.equals("1280*720")) {
				if ((maximumWindowBounds.getHeight() >= 720) && (maximumWindowBounds.getWidth() >= 1280)) {
					maFenetre.setSize(new Dimension(1280, 720));
				} else {
					maFenetre.setSize(new Dimension(maximumWindowBounds.width, maximumWindowBounds.height));
				}
			}
			if (s.equals("Resolution maximale")) {
				maFenetre.setSize(new Dimension(maximumWindowBounds.width, maximumWindowBounds.height));
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == mntmAjouterPersonne)
			changerPanel(new AjouterPersonnePanel(getApplication()));

		if (e.getSource() == mntmListeEtudiants)
			changerPanel(new ListeDesEtudiantsPanel(getApplication()));

		if (e.getSource() == mntmListeProfesseurs)
			changerPanel(new ListeDesProfesseursPanel(getApplication()));

		if (e.getSource() == mntmListeAdministrateurs)
			changerPanel(new ListeDesAdministrateursPanel(getApplication()));

		if (e.getSource() == mntmConsulterNoteEtudiant)
			changerPanel(new ConsulterNotePanel(getApplication()));

		if (e.getSource() == mntmAjouterSemestre)
			changerPanel(new AjouterSemestrePanel(getApplication()));

		if (e.getSource() == mntmAjouterMatiere)
			changerPanel(new AjouterMatierePanel(getApplication()));

		if (e.getSource() == mntmAjouterUE)
			changerPanel(new AjouterUEPanel(getApplication()));

		if (e.getSource() == mntmAjouterNote)
			changerPanel(new AjouterNotePanel(getApplication()));

		if (e.getSource() == mntmSeConnecter)
			changerPanel(new AuthentificationPanel(getApplication()));

		if (e.getSource() == mntmModifierMonProfil)
			changerPanel(new ModifierProfilPanel(getApplication()));

		if (e.getSource() == mntmConsulterMesNotes)
			changerPanel(new ConsulterNotePanel(getApplication()));

		if (e.getSource() == mntmEnvoyerUnGraphique)
			changerPanel(new MailPanel(getApplication()));

		if (e.getSource() == mntmCreeBDD) {
			Object[] possibilities = { "Non", "Oui" };
			String s = (String) JOptionPane.showInputDialog(new JFrame(),
					"Voulez-vous vraiment creer une nouvelle base de donnees ?\nAttention ! Si une base est deja presente, elle sera videe.",
					"Creation d'une nouvelle base de donnees", JOptionPane.WARNING_MESSAGE,
					(Icon) new JFrame().getIconImage(), possibilities, "Choix");
			if ((s != null) && (s.length() > 0)) {
				if (s.equals("Oui")) {
					getGestionnaireModele().getGestionnaireSQL().creerBaseDeDonnee();
				}
				return;
			}
		}

		if (e.getSource() == mntmViderBDD) {
			Object[] possibilities = { "Non", "Oui" };
			String s = (String) JOptionPane.showInputDialog(new JFrame(),
					"Voulez-vous vraiment vider DEFINITIVEMENT la base de donnees ?\n",
					"Suppression des donnees dans la base de donnees", JOptionPane.WARNING_MESSAGE,
					(Icon) new JFrame().getIconImage(), possibilities, "Choix");
			if ((s != null) && (s.length() > 0)) {
				if (s.equals("Oui")) {
					getGestionnaireModele().getGestionnaireSQL().viderBaseDeDonnee();
				}
				return;
			}
		}

		if (e.getSource() == mntmHistoriqueDesInstructions) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					UIManager.put("swing.boldMetal", Boolean.FALSE);
					JFrame frame = new JFrame("Choix du fichier");
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().add(new SelectionFichier(frame));
					frame.pack();
					frame.setVisible(true);
				}
			});
		}

		if (e.getSource() == mntmViderLhistoriqueDes) {
			ExportSQL.detruireLogs("Logs");
		}

		if (e.getSource() == mntmMAJListes) {
			getGestionnaireModele().miseAJourListes();
		}

		if (e.getSource() == mntmSeDeconnecter) {
			getGestionnaireModele().setNiveauAcces(-1);
			getGestionnaireModele().setIdUtilisateur(-1);
			getGestionnaireModele().getAuthentification().setIdentification(null);
			changerPanel(new AuthentificationPanel(getApplication()));
		}

		if (e.getSource() == mntmQuitter) {
			try {
				getGestionnaireModele().getGestionnaireSQL().getExporterSQLSuccess().close();
				getGestionnaireModele().getGestionnaireSQL().getExporterSQLFail().close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			System.exit(0);
		}

		if (e.getSource() == mntmRedimensionner)
			redimensionnerFenetre();

		if (e.getSource() == mntmAfficherLaide)
			changerPanel(new AidePane());

		if (e.getSource() == mntmAfficherAbout)
			changerPanel(new AboutPane());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
