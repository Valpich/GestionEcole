package model;

import java.sql.Date;
import java.util.List;

/**
 * Classe abstraite permettant de creer une Personne.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public abstract class Personne {

	public static final String DEFAULT_PROMOTION = "Etudiant";
	protected Integer id;
	protected boolean redoublant;
	protected String nom;
	protected String prenom;
	protected Date dateDeNaissance;
	protected String emailProfessionnel;
	protected String emailPersonnel;
	protected Integer telephoneFixe;
	protected Integer telephoneMobile;
	protected String identifiant;
	protected Date anneeArrivee;
	protected Integer idAdresse;
	protected String promotion;

	/**
	 * Construit une Personne.
	 * 
	 * @param id
	 *            L'id de la Personne.
	 * @param nom
	 *            Le nom de la Personne.
	 * @param prenom
	 *            Le prenom de la Personne.
	 * @param dateDeNaissance
	 *            La date de naissance de la Personne.
	 * @param idAdresse
	 *            L'id de l'adresse de la Personne.
	 * @param email
	 *            La liste des mails de la Personne.
	 * @param telephone
	 *            La liste des numeros de telephone de la Personne.
	 * @param redoublant
	 *            Vaut true si la Personne redouble, false sinon.
	 * @param anneeArrivee
	 *            L'annee d'arrivee de la Personne.
	 * @param identifiant
	 *            L'indentifiant de la Personne.
	 */
	public Personne(final Integer id, final String nom, final String prenom, final Date dateDeNaissance,
			final Integer idAdresse, final List<String> email, final List<Integer> telephone, final boolean redoublant,
			final Date anneeArrivee, final String identifiant) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateDeNaissance(dateDeNaissance);
		this.setIdAdresse(idAdresse);
		this.setEmailProfessionel(email.get(0));
		this.setEmailPersonnel(email.get(1));
		this.setTelephoneFixe(telephone.get(0));
		this.setTelephoneMobile(telephone.get(1));
		this.setRedoublant(redoublant);
		this.setAnneeArrivee(anneeArrivee);
		this.setPromotion(getDefaultPromotion());
		this.setIdentifiant(identifiant);
	}

	/**
	 * Construit une Personne.
	 * 
	 * @param id
	 *            L'id de la Personne.
	 * @param nom
	 *            Le nom de la Personne.
	 * @param prenom
	 *            Le prenom de la Personne.
	 * @param dateDeNaissance
	 *            La date de naissance de la Personne.
	 * @param idAdresse
	 *            L'id de l'adresse de la Personne.
	 * @param email
	 *            La liste des mails de la Personne.
	 * @param telephone
	 *            La liste des numeros de telephone de la Personne.
	 * @param redoublant
	 *            Vaut true si la Personne redouble, false sinon.
	 * @param anneeArrivee
	 *            L'annee d'arrive de la Personne.
	 * @param identifiant
	 *            L'indentifiant de la Personne.
	 * @param promotion
	 *            La promotion de la Personne.
	 */
	public Personne(final Integer id, final String nom, final String prenom, final Date dateDeNaissance,
			final Integer idAdresse, final List<String> email, final List<Integer> telephone, final boolean redoublant,
			final Date anneeArrivee, final String identifiant, final String promotion) {
		this(id, nom, prenom, dateDeNaissance, idAdresse, email, telephone, redoublant, anneeArrivee, identifiant);
		this.setPromotion(promotion);
	}

	/**
	 * Accesseur en lecture sur le nom de la personne.
	 * 
	 * @return Le nom de la personne.
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Accesseur en ecriture sur le nom de la personne.
	 * 
	 * @param value
	 *            Le nouveau nom de la personne.
	 */
	public void setNom(final String value) {
		this.nom = value;
	}

	/**
	 * Accesseur en lecture sur le prenom de la personne.
	 * 
	 * @return Le prenom de la personne.
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Accesseur en lecture sur le prenom de la personne.
	 * 
	 * @param value
	 *            Le nouveau prenom de la personne.
	 */
	public void setPrenom(final String value) {
		this.prenom = value;
	}

	/**
	 * Accesseur en lecture sur la date de naissance de la personne.
	 * 
	 * @return La date de naissance de la personne.
	 */
	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	/**
	 * Accesseur en ecriture sur la date de naissance de la personne.
	 * 
	 * @param value
	 *            La nouvelle date de naissance de la personne.
	 */
	public void setDateDeNaissance(final Date value) {
		this.dateDeNaissance = value;
	}

	/**
	 * Accesseur en lecture sur l'email professionnel de la personne.
	 * 
	 * @return L'email professionnel de la personne.
	 */
	public String getEmailProfessionnel() {
		return this.emailProfessionnel;
	}

	/**
	 * Accesseur en ecriture sur l'email professionnel de la personne.
	 * 
	 * @param value
	 *            Le nouvel email professionnel.
	 */
	public void setEmailProfessionel(final String value) {
		this.emailProfessionnel = value;
	}

	/**
	 * Accesseur en lecture sur l'email personnel de la personne.
	 * 
	 * @return L'email personnel de la personne.
	 */
	public String getEmailPersonnel() {
		return this.emailPersonnel;
	}

	/**
	 * Accesseur en ecriture sur l'email personnel de la personne.
	 * 
	 * @param value
	 *            Le nouvel email personnel.
	 */
	public void setEmailPersonnel(final String value) {
		this.emailPersonnel = value;
	}

	/**
	 * Accesseur en lecture sur le telephone fixe de la personne.
	 * 
	 * @return Le telephone fixe de la personne.
	 */
	public Integer getTelephoneFixe() {
		return this.telephoneFixe;
	}

	/**
	 * Accesseur en ecriture sur le telephone fixe de la personne.
	 * 
	 * @param value
	 *            Le nouveau telephone fixe de la personne.
	 */
	public void setTelephoneFixe(final int value) {
		this.telephoneFixe = new Integer(value);
	}

	/**
	 * Accesseur en lecture sur le telephone mobile de la personne.
	 * 
	 * @return Le telephone mobile de la personne.
	 */
	public Integer getTelephoneMobile() {
		return this.telephoneMobile;
	}

	/**
	 * Accesseur en ecriture sur le telephone mobile de la personne.
	 * 
	 * @param value
	 *            Le nouveau telephone mobile de la personne.
	 */
	public void setTelephoneMobile(final int value) {
		this.telephoneMobile = new Integer(value);
	}

	/**
	 * Accesseur en lecture sur l'identifiant de la personne.
	 * 
	 * @return L'identifiant de la personne.
	 */
	public String getIdentifiant() {
		return this.identifiant;
	}

	/**
	 * Accesseur en ecriture sur l'identifiant de la personne.
	 * 
	 * @param value
	 *            Le nouvel identifiant de la personne.
	 */
	public void setIdentifiant(final String value) {
		this.identifiant = value;
	}

	/**
	 * Accesseur en lecture sur l'id de la personne.
	 * 
	 * @return L'id de la personne.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Accesseur en ecriture sur l'id de la personne.
	 * 
	 * @param id
	 *            Le nouvel id de la personne.
	 */
	public void setId(final int id) {
		this.id = new Integer(id);
	}

	/**
	 * Accesseur en lecture sur l'etat de redoublement de la personne.
	 * 
	 * @return True si la personne redouble sinon false.
	 */
	public boolean isRedoublant() {
		return redoublant;
	}

	/**
	 * Accesseur en ecriture sur l'etat de redoublement de la personne.
	 * 
	 * @param redoublant
	 *            Le nouvel etat du redoublement de la personne.
	 */
	public void setRedoublant(final boolean redoublant) {
		this.redoublant = redoublant;
	}

	/**
	 * Accesseur en lecture sur l'id de l'adresse de la personne.
	 * 
	 * @return L'id de l'adresse de la personne.
	 */
	public Integer getIdAdresse() {
		return idAdresse;
	}

	/**
	 * Accesseur en ecriture sur l'id de l'adresse de la personne.
	 * 
	 * @param idAdresse
	 *            Le nouvel id de l'adresse de la personne.
	 */
	public void setIdAdresse(final int idAdresse) {
		this.idAdresse = new Integer(idAdresse);
	}

	/**
	 * Accesseur en lecture sur la promotion de la personne.
	 * 
	 * @return La promotion de la personne.
	 */
	public String getPromotion() {
		return promotion;
	}

	/**
	 * Accesseur en ecriture sur la promotion de la personne.
	 * 
	 * @param promotion
	 *            La nouvel promotion de la personne.
	 */
	public void setPromotion(final String promotion) {
		this.promotion = promotion;
	}

	/**
	 * Accesseur en lecture sur la promotion par defaut de la personne.
	 * 
	 * @return La promotion par defaut de la personne.
	 */
	public static String getDefaultPromotion() {
		return DEFAULT_PROMOTION;
	}

	/**
	 * Accesseur en lecture sur l'annee d'arrivee de la personne.
	 * 
	 * @return L'annee d'arrivee de la personne.
	 */
	public Date getAnneeArrivee() {
		return this.anneeArrivee;
	}

	/**
	 * Accesseur en ecriture sur l'annee d'arrivee de la personne.
	 * 
	 * @param value
	 *            La nouvelle annee d'arrivee de la personne.
	 */
	public void setAnneeArrivee(final Date value) {
		this.anneeArrivee = value;
	}

	/**
	 * Accesseur en ecriture sur l'id de la personne.
	 * 
	 * @param id
	 *            Le nouvel id de la personne.
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Accesseur en ecriture sur le telephone fixe de la personne.
	 * 
	 * @param telephoneFixe
	 *            Le nouveau telephone fixe de la personne.
	 */
	public void setTelephoneFixe(final Integer telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	/**
	 * Accesseur en ecriture sur le telephoneMobile de la personne.
	 * 
	 * @param telephoneMobile
	 *            Le nouveau telephone mobile de la personne.
	 */
	public void setTelephoneMobile(final Integer telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	/**
	 * Accesseur en ecriture sur l'id de l'adresse de la personne.
	 * 
	 * @param idAdresse
	 *            Le nouvel id de l'adresse de la personne.
	 */
	public void setIdAdresse(final Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	/**
	 * Accesseur en lecture sur donnant les caracteristiques de la personne sous
	 * forme de tableau.
	 * 
	 * @return Les attributs de la personne.
	 */
	public Object[] getTabAttributes() {
		Object[] tabAttributes = { id, nom, prenom, dateDeNaissance, emailProfessionnel, emailPersonnel, telephoneFixe,
				telephoneMobile, identifiant, anneeArrivee, promotion, redoublant, idAdresse };
		return tabAttributes;
	}

	/**
	 * Affiche sous la forme d'une chaine de caracteres une personne.
	 * 
	 * @return La chaine de caractere.
	 */
	@Override
	public String toString() {
		/*return new String("La personne est un : " + getClass().getSimpleName() + ", son nom est : " + this.getNom()
				+ ", le prenom est : " + this.getPrenom() + ", il est née le : " + this.getDateDeNaissance()
				+ ", il est arrive en : " + (1900 + this.getAnneeArrivee().getYear()) + ", l'id adresse est : "
				+ this.getIdAdresse() + ".\nLes emails sont : " + this.getEmailPersonnel() + " , "
				+ this.getEmailProfessionnel() + " et les numeros de telephone sont : " + this.getTelephoneFixe()
				+ " , " + this.getTelephoneMobile());
				*/
		return new String(this.getNom() + " " + this.getPrenom());
	}

}
