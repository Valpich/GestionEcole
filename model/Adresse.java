package model;

/**
 * Classe permettant de creer une Adresse.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Adresse {

	private Integer id = null;
	private Integer numero;
	private String rue;
	private Integer codePostal;
	private String ville;
	private String pays;
	private String nomAdresse;
	private static final String DEFAULT_ADRESSE_NAME = "Adresse principale";
	private static final String DEFAULT_COUNTRY_NAME = "FRANCE";

	/**
	 * Construit une adresse.
	 * 
	 * @param id
	 *            L'id de l'Adresse.
	 * @param numero
	 *            Le numero de l'Adresse.
	 * @param rue
	 *            La rue de l'Adresse.
	 * @param codePostal
	 *            Le code postal de l'Adresse.
	 * @param ville
	 *            La ville de l'Adresse.
	 */
	public Adresse(final Integer id, final int numero, final String rue, final int codePostal, final String ville) {
		if (id != null)
			this.setId(id);
		this.setNumero(numero);
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setPays(getDefaultCountryName());
		this.setNomAdresse(getDefaultAdresseName());
	}

	/**
	 * Construit une adresse.
	 * 
	 * @param id
	 *            L'id de l'Adresse.
	 * @param numero
	 *            Le numero de l'Adresse.
	 * @param rue
	 *            La rue de l'Adresse.
	 * @param codePostal
	 *            Le code postal de l'Adresse.
	 * @param ville
	 *            La ville de l'Adresse.
	 * @param pays
	 *            Le pays de l'Adresse.
	 */
	public Adresse(final Integer id, final int numero, final String rue, final Integer codePostal, final String ville,
			final String pays) {
		this(id, numero, rue, codePostal, ville);
		this.setPays(pays);
	}

	/**
	 * Construit une adresse.
	 * 
	 * @param id
	 *            L'id de l'Adresse.
	 * @param numero
	 *            Le numero de l'Adresse.
	 * @param rue
	 *            La rue de l'Adresse.
	 * @param codePostal
	 *            Le code postal de l'Adresse.
	 * @param ville
	 *            La ville de l'Adresse.
	 * @param pays
	 *            Le pays de l'Adresse.
	 * @param nomAdresse
	 *            Le nom de l'Adresse.
	 */
	public Adresse(final Integer id, final int numero, final String rue, final Integer codePostal, final String ville,
			final String pays, final String nomAdresse) {
		this(id, numero, rue, codePostal, ville, pays);
		this.setNomAdresse(nomAdresse);
	}

	/**
	 * Accesseur en lecture sur le numero.
	 * 
	 * @return Le numero.
	 */
	public Integer getNumero() {
		return this.numero;
	}

	/**
	 * Accesseur en ecriture sur le numero.
	 * 
	 * @param value
	 *            Le nouveau numero.
	 */
	public void setNumero(final int value) {
		this.numero = new Integer(value);
	}

	/**
	 * Accesseur en lecture sur l'id.
	 * 
	 * @return L'id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Accesseur en ecriture sur l'id.
	 * 
	 * @param id
	 *            Le nouvel id.
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Accesseur en lecture sur la rue.
	 * 
	 * @return La rue.
	 */
	public String getRue() {
		return this.rue;
	}

	/**
	 * Accesseur en ecriture sur la rue.
	 * 
	 * @param value
	 *            La nouvelle rue.
	 */
	public void setRue(final String value) {
		this.rue = value;
	}

	/**
	 * Accesseur en lecture sur la ville.
	 * 
	 * @return La ville.
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Accesseur en ecriture sur la ville.
	 * 
	 * @param value
	 *            La nouvelle ville.
	 */
	public void setVille(final String value) {
		this.ville = value;
	}

	/**
	 * Accesseur en lecture sur le pays.
	 * 
	 * @return Le pays.
	 */
	public String getPays() {
		return this.pays;
	}

	/**
	 * Accesseur en ecriture sur le pays.
	 * 
	 * @param value
	 *            Le nouveau pays.
	 */
	public void setPays(final String value) {
		this.pays = value;
	}

	/**
	 * Accesseur en lecture sur le nom de l'adresse.
	 * 
	 * @return Le nom de l'adresse.
	 */
	public String getNomAdresse() {
		return this.nomAdresse;
	}

	/**
	 * Accesseur en ecriture sur le nom de l'adresse.
	 * 
	 * @param value
	 *            Le nouveau nom de l'adresse.
	 */
	public void setNomAdresse(final String value) {
		this.nomAdresse = value;
	}

	/**
	 * Accesseur en lecture sur le code postal.
	 * 
	 * @return Le code postal.
	 */
	public Integer getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Accesseur en ecriture sur le code postal.
	 * 
	 * @param value
	 *            Le nouveau code postal.
	 */
	public void setCodePostal(final int value) {
		this.codePostal = new Integer(value);
	}

	/**
	 * Accesseur en lecture sur le nom d'adresse par defaut.
	 * 
	 * @return Le nom d'adresse par defaut.
	 */
	public static String getDefaultAdresseName() {
		return DEFAULT_ADRESSE_NAME;
	}

	/**
	 * Accesseur en lecture sur le nom du pays par defaut.
	 * 
	 * @return Le nom du pays par defaut.
	 */
	public static String getDefaultCountryName() {
		return DEFAULT_COUNTRY_NAME;
	}

	/**
	 * Affiche sous la forme d'une chaine de caracteres une adresse.
	 * 
	 */
	@Override
	public String toString() {
		return new String("Le nom est : " + this.getNomAdresse() + ", celle-ci est :\n" + this.getNumero() + ", "
				+ this.getRue() + "\n" + this.getCodePostal() + "   " + this.getVille() + "\n" + this.getPays());
	}
}
