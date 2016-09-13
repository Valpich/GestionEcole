package model;

import java.util.List;

/**
 * Classe gerant les actions dans le modele.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class GestionnaireModele {

	private int niveauAcces;
	private int idUtilisateur;
	private GestionnaireSQL gestionnaireSQL;
	private Authentification authentification;
	private List<Professeur> professeurs;
	private List<Administrateur> administrateurs;
	private List<Etudiant> etudiants;
	private List<Matiere> matieres;
	private List<Adresse> adresses;
	private List<Note> notes;
	private List<Semestre> semestres;
	private List<UniteEnseignement> ue;

	/**
	 * Construit la classe GestionnaireModele.
	 * 
	 */
	public GestionnaireModele() {
		this.setGestionnaireSQL(new GestionnaireSQL());
		this.setAuthentification(new Authentification(this));
		this.setNiveauAcces(-1);
		this.miseAJourListes();
	}

	/**
	 * Accesseur en lecture sur le GestionaireSQL.
	 * 
	 * @return Le GestionnaireSQL.
	 */
	public GestionnaireSQL getGestionnaireSQL() {
		return gestionnaireSQL;
	}

	/**
	 * Accesseur en ecriture sur le GestionaireSQL.
	 * 
	 * @param gestionnaireSQL
	 *            Le nouveau GestionaireSQL.
	 */
	public void setGestionnaireSQL(GestionnaireSQL gestionnaireSQL) {
		this.gestionnaireSQL = gestionnaireSQL;
	}
	

	/**
	 * Accesseur en lecture du niveau d'acreditation de l'utilisateur.
	 * 
	 * @return Le niveau de d'acreditation de l'utilisateur.
	 */
	public int getNiveauAcces() {
		return this.niveauAcces;
	}
	
	/**
	 * Accesseur en ecriture du niveau d'acreditation de l'utilisateur.
	 * 
	 * @param value
	 *            Le nouveau niveau d'acreditation de l'utilisateur.
	 */
	public void setNiveauAcces(final int value) {
		this.niveauAcces = value;
	}

	/**
	 * Accesseur en lecture de l'id de l'utilisateur qui s'est connecte.
	 * 
	 * @return L'id de l'utilisateur.
	 */
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}
	
	/**
	 * Accesseur en ecriture de l'id de l'utilisateur qui s'est connecte.
	 * 
	 * @param value
	 *            L'id de l'utilisateur.
	 */
	public void setIdUtilisateur(final int value) {
		this.idUtilisateur = value;
	}
	

	/**
	 * Accesseur en lecture sur la liste des Professeurs.
	 * 
	 * @return La liste des Professeurs.
	 */
	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	/**
	 * Accesseur en ecriture sur la liste des Professeurs.
	 * 
	 * @param professeurs
	 *            La nouvelle liste des Professeurs.
	 */
	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	/**
	 * Accesseur en lecture sur la liste des Administrateurs.
	 * 
	 * @return La liste des Administrateurs.
	 */
	public List<Administrateur> getAdministrateurs() {
		return administrateurs;
	}

	/**
	 * Accesseur en ecriture sur la liste des Administrateurs.
	 * 
	 * @param administrateurs
	 *            La nouvelle liste des Administrateurs.
	 */
	public void setAdministrateurs(List<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}

	/**
	 * Accesseur en lecture sur la liste des Etudiants.
	 * 
	 * @return La liste des Etudiants.
	 */
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	/**
	 * Accesseur en ecriture sur la liste des Etudiants.
	 * 
	 * @param etudiants
	 *            La nouvelle liste des Etudiants.
	 */
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	/**
	 * Accesseur en lecture sur la liste des Matieres.
	 * 
	 * @return La liste des Matieres.
	 */
	public List<Matiere> getMatieres() {
		return matieres;
	}

	/**
	 * Accesseur en ecriture sur la liste des Matieres.
	 * 
	 * @param matieres
	 *            La nouvelle liste des Matieres.
	 */
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	/**
	 * Accesseur en lecture sur la liste des Adresses.
	 * 
	 * @return La liste des Adresses.
	 */
	public List<Adresse> getAdresses() {
		return adresses;
	}

	/**
	 * Accesseur en ecriture sur la liste des Adresses.
	 * 
	 * @param adresses
	 *            La nouvelle liste des Adresses.
	 */
	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	/**
	 * Accesseur en lecture sur la liste des Notes.
	 * 
	 * @return La liste des Notes.
	 */
	public List<Note> getNotes() {
		return notes;
	}

	/**
	 * Accesseur en ecriture sur la liste des Notes.
	 * 
	 * @param notes
	 *            La nouvelle liste des Notes.
	 */
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	/**
	 * Accesseur en lecture sur la liste des Semestres.
	 * 
	 * @return La liste des Semestres.
	 */
	public List<Semestre> getSemestres() {
		return semestres;
	}

	/**
	 * Accesseur en ecriture sur la liste des Semestres.
	 * 
	 * @param semestres
	 *            La nouvelle liste des Semestres.
	 */
	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}

	/**
	 * Accesseur en lecture sur la liste des ue.
	 * 
	 * @return La liste des ue.
	 */
	public List<UniteEnseignement> getUe() {
		return ue;
	}

	/**
	 * Accesseur en ecriture sur la liste des ue.
	 * 
	 * @param ue
	 *            La nouvelle liste des ue.
	 */
	public void setUe(List<UniteEnseignement> ue) {
		this.ue = ue;
	}

	/**
	 * Accesseur en lecture sur le gestionnaire d'authentification.
	 * 
	 * @return Le gestionnaire d'authentification.
	 */
	public Authentification getAuthentification() {
		return this.authentification;
	}

	/**
	 * Accesseur en ecriture sur le gestionnaire d'authentification.
	 * 
	 * @param authentification
	 *            Le nouveau gestionnaire d'authentification.
	 */
	public void setAuthentification(final Authentification authentification) {
		this.authentification = authentification;
	}

	/**
	 * Met a jour les listes dans le GestionnaireModele par recuperation des
	 * informations en base de donnee.
	 * 
	 */
	public void miseAJourListes() {
		this.setProfesseurs(this.getGestionnaireSQL().recupererProfesseurs());
		this.setEtudiants(this.getGestionnaireSQL().recupererEtudiants(null));
		this.setAdministrateurs(this.getGestionnaireSQL().recupererAdministrateurs());
		this.setMatieres(this.getGestionnaireSQL().recupererMatieres());
		this.setSemestres(this.getGestionnaireSQL().recupererSemestres());
		this.setNotes(this.getGestionnaireSQL().recupererNotes());
		this.setAdresses(this.getGestionnaireSQL().recupererAdresses());
		this.setUe(this.getGestionnaireSQL().recupererUe());
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer un nouveau professeur.
	 * 
	 * @return True si il peut, sinon false.
	 */
	public boolean peutCreerProfesseur() {
		boolean ok = false;
		if (this.getNiveauAcces() == 0) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer une nouvelle matiere.
	 * 
	 * @return True si il peut, sinon false.
	 */
	public boolean peutCreerMatiere() {
		boolean ok = false;
		if (this.getNiveauAcces() == 0 || this.getNiveauAcces() == 1) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer un nouvel etudiant
	 * 
	 * @return True si il peut, sinon false..
	 */
	public boolean peutCreerEtudiant() {
		boolean ok = false;
		if (this.getNiveauAcces() == 0) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer une nouvelle note.
	 * 
	 * @return True si il peut, sinon false.
	 */
	public boolean peutCreerNote() {
		boolean ok = false;
		if (this.getNiveauAcces() == 0 || this.getNiveauAcces() == 1) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer un nouveau semestre.
	 * 
	 * @return True si il peut, sinon false.
	 */
	public boolean peutCreerSemestre() {
		boolean ok = false;
		if (this.getNiveauAcces() == 0 || this.getNiveauAcces() == 1) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer un nouvel administrateur
	 * 
	 * @return True si il peut, sinon false. .
	 */
	public boolean peutCreerAdmnistrateur() {
		boolean ok = false;
		if (this.getNiveauAcces() == 0) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer une nouvelle adresse.
	 * 
	 * @return True si il peut, sinon false.
	 */
	public boolean peutCreerAdresse() {
		boolean ok = false;
		if (this.getNiveauAcces() == 0 || this.getNiveauAcces() == 1 || this.getNiveauAcces() == 2) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Permet de verifier si l'utilisateur peut creer un nouvel ue.
	 * 
	 * @return True si il peut, sinon false.
	 */
	public boolean peutCreerUe() {
		boolean ok = false;
		if (this.getNiveauAcces() == 2) {
			ok = true;
		}
		return ok;
	}
}
