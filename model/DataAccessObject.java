package model;

import java.util.List;

/**
 * Fourni l'interface qu'une classe voulant transformer des objets stockes a
 * l'exterieur du logiciel en objet du logiciel.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public interface DataAccessObject {

	/**
	 * Permet d'ajouter une note a la base de donnee.
	 * 
	 * @param note
	 *            La note a ajouter.
	 */
	void ajouterNote(Note note);

	/**
	 * Permet d'ajouter une matiere a la base de donnee.
	 * 
	 * @param matiere
	 *            La matiere a ajouter.
	 */
	void ajouterMatiere(Matiere matiere);

	/**
	 * Permet d'ajouter un semestre a la base de donnee.
	 * 
	 * @param semestre
	 *            Le semestre a ajouter.
	 */
	void ajouterSemestre(Semestre semestre);

	/**
	 * Permet d'ajouter une personne a la base de donnee.
	 * 
	 * @param personne
	 *            La personne a ajouter.
	 */
	void ajouterPersonne(Personne personne);

	/**
	 * Permet d'ajouter une adresse a la base de donnee.
	 * 
	 * @param adresse
	 *            L'adresse a ajouter.
	 */
	void ajouterAdresse(Adresse adresse);

	/**
	 * Permet d'ajouter un ue a la base de donnee.
	 * 
	 * @param ue
	 *            L'ue a ajouter.
	 */
	void ajouterUe(UniteEnseignement ue);

	/**
	 * Permet de supprimer une adresse de la base de donnee.
	 * 
	 * @param idAdresse
	 *            L'id de l'adresse a supprimer.
	 */
	void supprimerAdresse(Integer idAdresse);

	/**
	 * Permet de supprimer une note de la base de donnee.
	 * 
	 * @param idNote
	 *            L'id de la note a supprimer.
	 */
	void supprimerNote(Integer idNote);

	/**
	 * Permet de supprimer une matiere de la base de donnee.
	 * 
	 * @param idMatiere
	 *            L'id de la matiere a supprimer.
	 */
	void supprimerMatiere(Integer idMatiere);

	/**
	 * Permet de supprimer un semestre de la base de donnee.
	 * 
	 * @param idSemestre
	 *            L'id du semestre a supprimer.
	 */
	void supprimerSemestre(Integer idSemestre);

	/**
	 * Permet de supprimer une personne de la base de donnee.
	 * 
	 * @param idPersonne
	 *            L'id de la personne � supprimer.
	 */
	void supprimerPersonne(Integer idPersonne);

	/**
	 * Permet de supprimer un ue de la base de donnee.
	 * 
	 * @param ue
	 *            L'ue a supprimer.
	 */
	void supprimerUe(UniteEnseignement ue);

	/**
	 * Permet de recuperer la liste des notes en base de donnee.
	 * 
	 * @return La liste des notes.
	 * 
	 */
	List<Note> recupererNotes();

	/**
	 * Permet de recuperer la liste des professeurs en base de donnee.
	 * 
	 * @return La liste des professeurs.
	 * 
	 */
	List<Professeur> recupererProfesseurs();

	/**
	 * Permet de recuperer la liste des administrateurs en base de donnee.
	 * 
	 * @return La liste des administrateurs.
	 * 
	 */
	List<Administrateur> recupererAdministrateurs();

	/**
	 * Permet de recuperer la liste des etudiants en base de donnee.
	 * 
	 * @param promotion
	 *            La promotion a recuperer, recupere tous les etudiants si null.
	 * 
	 * @return La liste des eleves.
	 * 
	 */
	List<Etudiant> recupererEtudiants(String promotion);

	/**
	 * Permet de recuperer la liste des matieres en base de donnee.
	 * 
	 * @return La liste des matieres.
	 * 
	 */
	List<Matiere> recupererMatieres();

	/**
	 * Permet de recuperer la liste des matieres en base de donnee.
	 * 
	 * @return La liste des matieres.
	 * 
	 */
	List<Adresse> recupererAdresses();

	/**
	 * Permet de recuperer la liste des semestres en base de donnee.
	 * 
	 * @return La liste des semestres.
	 * 
	 */
	List<Semestre> recupererSemestres();

	/**
	 * Permet de recuperer la liste des ue en base de donnee.
	 * 
	 * @return La liste des ue.
	 * 
	 */
	List<UniteEnseignement> recupererUe();

}