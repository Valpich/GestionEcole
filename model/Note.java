package model;

/**
 * Classe permettant de creer une Note.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Note {

	private Integer id;
	private String nom;
	private Double valeur;
	private Double coefficient;
	private Integer idEtudiant;
	private Integer idMatiere;

	/**
	 * Construit une Note.
	 * 
	 * @param id
	 *            L'id de la note.
	 * @param nom
	 *            Le nom de la note.
	 * @param valeur
	 *            La valeur de la note.
	 * @param coefficient
	 *            Le coefficient de la note.
	 * @param etudiant
	 *            L'Etudiant a qui appartient la note.
	 * @param matiere
	 *            La matiere dans laquelle est la note.
	 */
	public Note(final Integer id, final String nom, final double valeur, final double coefficient, final Etudiant etudiant,
			final Matiere matiere) {
		this(id, nom, valeur, coefficient, etudiant.getId(), matiere.getId());
	}

	/**
	 * Construit une Note a l'aide des id base de donnee.
	 * 
	 * @param id
	 *            L'id de la note.
	 * @param nom
	 *            Le nom de la note.
	 * @param valeur
	 *            La valeur de la note.
	 * @param coefficient
	 *            Le coefficient de la note.
	 * @param idEtudiant
	 *            L'id de l'Etudiant a qui appartient la note.
	 * @param idMatiere
	 *            L'id de la matiere dans laquelle est la note.
	 */
	public Note(final Integer id, final String nom, final double valeur, final double coefficient,
			final Integer idEtudiant, final Integer idMatiere) {
		this.setId(id);
		this.setNom(nom);
		this.setValeur(valeur);
		this.setCoefficient(coefficient);
		this.setIdEtudiant(idEtudiant);
		this.setIdMatiere(idMatiere);
	}

	/**
	 * Accesseur en ecriture sur l'id de la note.
	 * 
	 * @param id
	 *            Le nouvel id de la note.
	 */

	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Accesseur en lecture sur l'id de la note.
	 * 
	 * @return L'id de la note.
	 */

	public Integer getId() {
		return this.id;
	}

	/**
	 * Accesseur en lecture sur le nom de la note.
	 * 
	 * @return Le nom.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur en ecriture sur le nom de la note.
	 * 
	 * @param nom
	 *            Le nouveau nom.
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * Accesseur en lecture sur la valeur de la note.
	 * 
	 * @return La valeur.
	 */
	public Double getValeur() {
		return this.valeur;
	}

	/**
	 * Accesseur en ecriture sur la valeur de la note.
	 * 
	 * @param value
	 *            La nouvelle valeur.
	 */
	public void setValeur(final double value) {
		this.valeur = new Double(value);
	}

	/**
	 * Accesseur en lecture sur le coefficient de la note.
	 * 
	 * @return Le coefficient.
	 */
	public Double getCoefficient() {
		return this.coefficient;
	}

	/**
	 * Accesseur en ecriture sur le coefficient de la note.
	 * 
	 * @param coef
	 *            Le nouveau coefficient.
	 */
	public void setCoefficient(final double coef) {
		this.coefficient = new Double(coef);
	}

	/**
	 * Accesseur en lecture sur l'idEtudiant de la note.
	 * 
	 * @return L'idEtudiant.
	 */
	public Integer getIdEtudiant() {
		return idEtudiant;
	}

	/**
	 * Accesseur en ecriture sur l'idEtudiant de la note.
	 * 
	 * @param idEtudiant
	 *            Le nouvel idEtudiant.
	 */
	public void setIdEtudiant(final int idEtudiant) {
		this.idEtudiant = new Integer(idEtudiant);
	}

	/**
	 * Accesseur en lecture sur l'idMatiere de la note.
	 * 
	 * @return L'idMatiere.
	 */
	public Integer getIdMatiere() {
		return idMatiere;
	}

	/**
	 * Accesseur en ecriture sur l'idMatiere de la note.
	 * 
	 * @param idMatiere
	 *            Le nouvel idMatiere.
	 */
	public void setIdMatiere(final int idMatiere) {
		this.idMatiere = new Integer(idMatiere);
	}

	/**
	 * Transformer en une chaine de caracteres une Note.
	 * 
	 * @return La chaine de caractere decrivant la Note.
	 */
	@Override
	public String toString() {
		/*return new String("L'etudiant id : " + this.getIdEtudiant() + ", a obtenu : " + this.getValeur()
				+ ", a l'epreuve : " + this.getNom() + ", coefficient : " + this.getCoefficient()
				+ ", dans la matiere id : " + this.getIdMatiere() + ".");
				*/
		return new String(this.getNom() + " : " + this.getValeur() + "/20 Coefficient " +  this.getCoefficient());
	}

}
