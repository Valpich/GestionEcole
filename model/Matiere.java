package model;

/**
 * Classe pour creer une Matiere.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Matiere {

	private Integer id;
	private String nom;
	private double coefficient;
	private Double moyenne = null;
	private Integer idResponsable;
	private Integer idSemestre;

	/**
	 * Accesseur en lecture sur la valeur de la moyenne.
	 * 
	 * @return La moyenne.
	 */
	public Double getMoyenne() {
		return moyenne;
	}

	/**
	 * Accesseur en ecriture sur la valeur de la moyenne.
	 * 
	 * @param moyenne
	 *            La valeur de la moyenne.
	 */
	public void setMoyenne(final double moyenne) {
		this.moyenne = new Double(moyenne);
	}

	/**
	 * Accesseur en lecture sur l'id de la moyenne.
	 * 
	 * @return L'id de la moyenne.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Accesseur en ecriture sur l'id de la matiere.
	 * 
	 * @param id
	 *            Le nouvel id de la matiere.
	 */
	public void setId(final int id) {
		this.id = new Integer(id);
	}

	/**
	 * Accesseur en lecture sur l'id du responsable de la matiere.
	 * 
	 * @return L'id du responsable de la matiere.
	 */
	public Integer getIdResponsable() {
		return idResponsable;
	}

	/**
	 * Accesseur en ecriture sur l'id du responsable de la matiere.
	 * 
	 * @param idResponsable
	 *            Le nouvel id du responsable de la matiere.
	 */
	public void setIdResponsable(final int idResponsable) {
		this.idResponsable = new Integer(idResponsable);
	}

	/**
	 * Accesseur en lecture sur le nom de la matiere.
	 * 
	 * @return Le nom de la matiere.
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Accesseur en ecriture sur le nom de la matiere.
	 * 
	 * @param value
	 *            Le nouveau nom de la matiere.
	 */
	public void setNom(final String value) {
		this.nom = value;
	}

	/**
	 * Accesseur en lecture sur le coefficient de la moyenne.
	 * 
	 * @return Le coefficient de la moyenne.
	 */
	public Double getCoefficient() {
		return this.coefficient;
	}

	/**
	 * Accesseur en ecriture sur le coefficient de la moyenne.
	 * 
	 * @param value
	 *            Le nouveau coefficient de la matiere.
	 */
	public void setCoefficient(final double value) {
		this.coefficient = new Double(value);
	}

	/**
	 * Accesseur en lecture sur l'id du semestre de la matiere.
	 * 
	 * @return L'id du semestre de la matiere.
	 */
	public Integer getIdSemestre() {
		return idSemestre;
	}

	/**
	 * Accesseur en ecriture sur l'id du semestre de la matiere.
	 * 
	 * @param idSemestre
	 *            Le nouvel id du semestre de la matiere.
	 */
	public void setIdSemestre(final int idSemestre) {
		this.idSemestre = new Integer(idSemestre);
	}

	/**
	 * Decrit de facon textuelle une matiere.
	 * 
	 */
	@Override
	public String toString() {
		/*return new String("La matiere se nomme : " + this.getNom() + ", le professeur est : " + this.getIdResponsable()
				+ ", le coefficient de la matière est : " + this.getCoefficient() + " .");
				*/
		return new String(this.getNom());
	}

	/**
	 * Construit une matiere
	 * 
	 * @param id
	 *            L'id de la matiere.
	 * @param professeur
	 *            Le professeur responsable de la matiere.
	 * @param nom
	 *            Le nom de la matiere.
	 * @param coefficient
	 *            Le coefficient de la matiere.
	 * @param semestre
	 *            La semestre de la matiere.
	 * @param moyenne
	 *            La moyenne de la matiere.
	 */
	public Matiere(final Integer id, final Professeur professeur, final String nom, final Double coefficient,
			final Semestre semestre, final double moyenne) {
		this(id, professeur.getId(), nom, coefficient, semestre.getId(), moyenne);
	}

	/**
	 * Construit une matiere
	 * 
	 * @param id
	 *            L'id de la matiere.
	 * @param idProfesseur
	 *            L'id du professeur responsable de la matiere.
	 * @param nom
	 *            Le nom de la matiere.
	 * @param coefficient
	 *            Le coefficient de la matiere.
	 * @param idSemestre
	 *            L'id du semestre de la matiere.
	 * @param moyenne
	 *            La moyenne de la matiere.
	 */
	public Matiere(final Integer id, final Integer idProfesseur, final String nom, final Double coefficient,
			final Integer idSemestre, final double moyenne) {
		this.setId(id);
		this.setIdResponsable(idProfesseur);
		this.setNom(nom);
		this.setCoefficient(coefficient);
		this.setIdSemestre(idSemestre);
		this.setMoyenne(moyenne);
	}

}
