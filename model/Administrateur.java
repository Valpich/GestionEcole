package model;

import java.sql.Date;
import java.util.List;

/**
 * Classe pour creer les Administrateur.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Administrateur extends Personne {

	/**
	 * Construit un Administrateur.
	 * 
	 * @param id
	 *            L'id de l'Administrateur.
	 * @param nom
	 *            Le nom de l'Administrateur.
	 * @param prenom
	 *            Le prenom de l'Administrateur.
	 * @param dateDeNaissance
	 *            La date de naissance de l'Administrateur.
	 * @param idAdresse
	 *            L'id de l'adresse de l'Administrateur.
	 * @param email
	 *            La liste des mails de l'Administrateur.
	 * @param telephone
	 *            La liste des numeros de telephone de l'Administrateur.
	 * @param anneeArrivee
	 *            L'annee d'arrive de l'Administrateur.
	 * @param identifiant
	 *            L'identifiant de l'Administrateur.
	 */
	public Administrateur(final Integer id, final String nom, final String prenom, final Date dateDeNaissance,
			final Integer idAdresse, final List<String> email, final List<Integer> telephone, final Date anneeArrivee,
			final String identifiant) {
		super(id, nom, prenom, dateDeNaissance, idAdresse, email, telephone, false, anneeArrivee, identifiant,
				"Administrateur");
	}

}
