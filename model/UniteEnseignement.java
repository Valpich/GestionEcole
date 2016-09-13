package model;

import java.util.List;

/**
 * Classe permettant de creer une Unite d'enseignement.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class UniteEnseignement {

	private String nom;
	private Double coefficient;
	private List<Integer> idMatieres;

	/**
	 * Construit une Unite d'Enseignement.
	 * 
	 * @param nom
	 *            Le nom de l'unite d'enseignement.
	 * @param coefficient
	 *            Le coefficient de l'unite d'enseignement.
	 * @param idMatieres
	 *            La liste des id des Matieres de l'unite d'enseignement.
	 */
	public UniteEnseignement(final String nom, final Double coefficient, final List<Integer> idMatieres) {
		this.setNom(nom);
		this.setCoefficient(coefficient);
		this.setIdMatieres(idMatieres);
	}

	/**
	 * Accesseur en lecture sur le nom de l'unite d'enseignement.
	 * 
	 * @return Le nom de l'unite d'enseignement.
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Accesseur en ecriture sur le nom de l'unite d'enseignement.
	 * 
	 * @param value
	 *            Le nouveau nom de l'unite d'enseignement.
	 */
	public void setNom(final String value) {
		this.nom = value;
	}

	/**
	 * Accesseur en lecture sur le coefficient de l'unite d'enseignement.
	 * 
	 * @return Le coefficient de l'unite d'enseignement.
	 */
	public Double getCoefficient() {
		return this.coefficient;
	}

	/**
	 * Accesseur en ecriture sur le coefficient de l'unite d'enseignement.
	 * 
	 * @param value
	 *            Le nouveau coefficient de l'unite d'enseignement.
	 */
	public void setCoefficient(final Double value) {
		this.coefficient = value;
	}

	/**
	 * Accesseur en lecture sur la liste des idMatieres de l'unite
	 * d'enseignement.
	 * 
	 * @return La liste des idMatieres t de l'unite d'enseignement.
	 */
	public List<Integer> getIdMatieres() {
		return this.idMatieres;
	}

	/**
	 * Accesseur en ecriture sur la liste des idMatieres de l'unite
	 * d'enseignement.
	 * 
	 * @param idMatieres
	 *            La nouvelle liste des idMatieres de l'unite d'enseignement.
	 */
	public void setIdMatieres(List<Integer> idMatieres) {
		this.idMatieres = idMatieres;
	}

	/**
	 * Decrit de facon textuelle une unite d'enseignement.
	 * 
	 * @return La chaine de caractere.
	 */
	@Override
	public String toString() {
		String tmp = new String("L'unité d'enseignement se nomme : " + this.getNom() + ", son coefficient est : "
				+ this.getCoefficient() + ", il possede les idMatieres suivants : ");
		boolean ajout = false;
		for (Integer id : this.getIdMatieres()) {
			tmp = new String(tmp + "" + id + ", ");
			ajout = true;
		}
		if (ajout == true) {
			tmp = new String(tmp.substring(0, tmp.length() - 2) + ".");
		} else {
			tmp = new String(tmp + ".");
		}
		return tmp;
	}

}
