package model;

import java.sql.Date;
import java.util.List;

/**
 * Classe pour les Professeur.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Professeur extends Personne {

	/**
	 * Construit un Professeur.
	 * 
	 * @param id
	 *            L'id du Professeur.
	 * @param nom
	 *            Le nom du Professeur.
	 * @param prenom
	 *            Le prenom du Professeur.
	 * @param dateDeNaissance
	 *            La date de naissance du Professeur.
	 * @param idAdresse
	 *            L'id de l'adresse du Professeur.
	 * @param email
	 *            La liste des mails du Professeur.
	 * @param telephone
	 *            La liste des numeros de telephone du Professeur.
	 * @param anneeArrivee
	 *            L'annee d'arrive du Professeur.
	 * @param identifiant
	 *            L'identifiant du Professeur.
	 */
	public Professeur(final Integer id, final String nom, final String prenom, final Date dateDeNaissance,
			final Integer idAdresse, final List<String> email, final List<Integer> telephone, final Date anneeArrivee,
			final String identifiant) {
		super(id, nom, prenom, dateDeNaissance, idAdresse, email, telephone, false, anneeArrivee, identifiant,
				"Professeur");
	}

}
