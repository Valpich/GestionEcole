package model;

import java.sql.Date;
import java.util.List;

/**
 * Classe pour les Professeur.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */

public class Etudiant extends Personne {

	/**
	 * Construit un Etudiant dans la promotion par defaut.
	 * 
	 * @param id
	 *            L'id de l'Etudiant.
	 * @param nom
	 *            Le nom de l'Etudiant.
	 * @param prenom
	 *            Le prenom de l'Etudiant.
	 * @param dateDeNaissance
	 *            La date de naissance de l'Etudiant.
	 * @param idAdresse
	 *            L'id de l'adresse de l'Etudiant.
	 * @param email
	 *            La liste des mails de l'Etudiant.
	 * @param telephone
	 *            La liste des numeros de telephone de l'Etudiant.
	 * @param redoublant
	 *            Vaut true si l'Etudiant redouble, false sinon.
	 * @param anneeArrivee
	 *            L'annee d'arrive de l'Etudiant.
	 * @param identifiant
	 *            L'identifiant de l'Etudiant.
	 */
	public Etudiant(final Integer id, final String nom, final String prenom, final Date dateDeNaissance,
			final Integer idAdresse, final List<String> email, final List<Integer> telephone, final boolean redoublant,
			final Date anneeArrivee, final String identifiant) {
		super(id, nom, prenom, dateDeNaissance, idAdresse, email, telephone, redoublant, anneeArrivee, identifiant);
	}

	/**
	 * Construit un Etudiant.
	 * 
	 * @param id
	 *            L'id de l'Etudiant.
	 * @param nom
	 *            Le nom de l'Etudiant.
	 * @param prenom
	 *            Le prenom de l'Etudiant.
	 * @param dateDeNaissance
	 *            La date de naissance de l'Etudiant.
	 * @param idAdresse
	 *            L'id de l'adresse de l'Etudiant.
	 * @param email
	 *            La liste des mails de l'Etudiant.
	 * @param telephone
	 *            La liste des numeros de telephone de l'Etudiant.
	 * @param redoublant
	 *            Vaut true si l'Etudiant redouble, false sinon.
	 * @param anneeArrivee
	 *            L'annee d'arrive de l'Etudiant.
	 * @param identifiant
	 *            L'identifiant de l'Etudiant.
	 * @param promotion
	 *            La promotion de l'Etudiant.
	 */
	public Etudiant(final Integer id, final String nom, final String prenom, final Date dateDeNaissance,
			final Integer idAdresse, final List<String> email, final List<Integer> telephone, final boolean redoublant,
			final Date anneeArrivee, final String identifiant, final String promotion) {
		super(id, nom, prenom, dateDeNaissance, idAdresse, email, telephone, redoublant, anneeArrivee, identifiant,
				promotion);
		if (promotion.equals("Professeur") || promotion.equals("Administrateur")) {
			this.setPromotion(super.getDefaultPromotion());
		}
	}

}
