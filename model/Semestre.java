package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Classe permettant de creer un Semestre.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Semestre {

	private Integer id;
	private Integer valide;
	private String nom;
	private Date dateDebut;
	private Date dateFin;

	/**
	 * Construit un semestre.
	 * 
	 * @param id
	 *            L'id du semestre.
	 * @param dateDebut
	 *            La date de debut du semestre.
	 * @param dateFin
	 *            La date de fin du semestre.
	 * @param nom
	 *            Le nom du semestre.
	 * @param valide
	 *            L'etat de validation du semestre.
	 */
	public Semestre(final Integer id, final Date dateDebut, Date dateFin, final String nom, final Integer valide) {
		this.setId(id);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setNom(nom);
		this.setValide(valide);
	}

	/**
	 * Accesseur en lecture sur la date de debut du semestre.
	 * 
	 * @return La date de debut du semestre.
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Accesseur en ecriture sur la date de debut du semestre.
	 * 
	 * @param dateDebut
	 *            La nouvelle date de debut du semestre.
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Accesseur en lecture sur la date de fin du semestre.
	 * 
	 * @return La date de fin du semestre.
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Accesseur en ecriture sur la date de fin du semestre.
	 * 
	 * @param dateFin
	 *            La nouvelle date de fin du semestre.
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Accesseur en lecture sur la validation du semestre.
	 * 
	 * @return La validation du semestre.
	 */
	public Integer getValide() {
		return valide;
	}

	/**
	 * Accesseur en ecriture sur la validation du semestre.
	 * 
	 * @param valide
	 *            La nouvelle validation du semestre.
	 */
	public void setValide(final Integer valide) {
		this.valide = valide;
	}

	/**
	 * Accesseur en lecture sur le nom du semestre.
	 * 
	 * @return Le nom du semestre.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur en ecriture sur le nom du semestre.
	 * 
	 * @param nom
	 *            Le nouveau nom du semestre.
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * Accesseur en lecture sur l'id du semestre.
	 * 
	 * @return L'id du semestre.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Accesseur en ecriture sur l'id du semestre.
	 * 
	 * @param id
	 *            Le nouvel id du semestre.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Decrit de facon textuelle un semestre.
	 * 
	 * @return La chaine de caractere.
	 */
	@Override
	public String toString() {
		/*return new String("L'id du semestre est : " + this.getId() + ", le nom du semestre est : " + this.getNom()
				+ ", la date de debut du semestre est : " + this.getDateDebut() + ", la date de fin est le : "
				+ this.getDateFin() + " et son etat de validation actuelle est : " + this.getValide() + ".");
		*/
		return new String(this.getNom() + " du " + new SimpleDateFormat("dd/MM/yyyy").format(this.getDateDebut()) + " au " + new SimpleDateFormat("dd/MM/yyyy").format(this.getDateFin()) );
	}
}
