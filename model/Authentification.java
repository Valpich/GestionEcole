package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe permettant d'authentifier un utilisateur.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Authentification {
	private int nombreErreur;
	private GestionnaireModele gestionnaireModele;
	private String identification;

	/**
	 * Construit la classe Authentification.
	 * 
	 * @param value
	 *            Le gestionnaire modele.
	 */
	public Authentification(final GestionnaireModele value) {
		this.setNombreErreur(0);
		this.setGestionnaireModele(value);
		this.getGestionnaireModele().setNiveauAcces(-1);
	}

	/**
	 * Accesseur en lecture sur le GestionaireModele.
	 * 
	 * @return Le GestionnaireModele.
	 */
	public GestionnaireModele getGestionnaireModele() {
		return this.gestionnaireModele;
	}

	/**
	 * Accesseur en ecriture sur le GestionaireModele.
	 * 
	 * @param value
	 *            Le nouveau GestionaireModele.
	 */
	public void setGestionnaireModele(final GestionnaireModele value) {
		this.gestionnaireModele = value;
	}

	/**
	 * Accesseur en lecture sur le nombre d'erreurs.
	 * 
	 * @return Le nombre d'erreurs.
	 */
	public int getNombreErreur() {
		return this.nombreErreur;
	}

	/**
	 * Accesseur en ecriture sur le nombre d'erreurs.
	 * 
	 * @param value
	 *            Le nombre d'erreur.
	 */
	public void setNombreErreur(final int value) {
		this.nombreErreur = value;
	}

	/**
	 * Accesseur en lecture sur l'authentification.
	 * 
	 * @return L'authentification.
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * Accesseur en ecriture sur l'identification.
	 * 
	 * @param identification
	 *            La nouvelle identification.
	 */
	public void setIdentification(final String identification) {
		this.identification = identification;
	}

	/**
	 * Methode validant ou non l'authentification de l'utilisateur.
	 * 
	 * @param identifiant
	 *            L'identifiant a verifier.
	 * @param motDePasse
	 *            Le mot de passe donne a verifier.
	 * @return True si l'utilisateur a un login valide, false sinon.
	 */
	public static boolean verifierLogin(final String identifiant, final String motDePasse) {
		if (MD5(identifiant).substring(0, 8).equals(motDePasse)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Methode de gestion des erreurs sur l'authentification de l'utilisateur.
	 */
	public void gestionErreurLogin() {
		if (getNombreErreur() >= 2) {
			System.exit(10);
		} else {
			setNombreErreur(getNombreErreur() + 1);
		}
	}

	/**
	 * Methode de gestion de l'authentification de l'utilisateur. Affecte le
	 * niveau d'acces dans le GestionaireModele : 0 pour administrateur, 1 pour
	 * un professeur, 2 pour un etudiant.
	 * 
	 * @param identifiant
	 *            L'identifiant de l'utilisateur.
	 * @param motDePasse
	 *            Le mot de passe de l'utilisateur.
	 */
	public void authentification(final String identifiant, final String motDePasse) {
		if (verifierLogin(identifiant, motDePasse) == true) {
			for (Administrateur administrateur : this.getGestionnaireModele().getAdministrateurs()) {
				if (administrateur.getIdentifiant().equals(identifiant)){
					this.getGestionnaireModele().setNiveauAcces(0);
					this.getGestionnaireModele().setIdUtilisateur(administrateur.getId());
				}
			}
			for (Professeur professeur : this.getGestionnaireModele().getProfesseurs()) {
				if (professeur.getIdentifiant().equals(identifiant)){
					this.getGestionnaireModele().setNiveauAcces(1);
					this.getGestionnaireModele().setIdUtilisateur(professeur.getId());
				}
			}
			for (Etudiant etudiant : this.getGestionnaireModele().getEtudiants()) {
				if (etudiant.getIdentifiant().equals(identifiant)){
					this.getGestionnaireModele().setNiveauAcces(2);
					this.getGestionnaireModele().setIdUtilisateur(etudiant.getId());
				}
			}
			if (this.getGestionnaireModele().getNiveauAcces() != -1)
				this.setIdentification(identifiant);
		} else {
			this.gestionErreurLogin();
		}
	}

	/**
	 * Transformer une chaine de caractere en une chaine de caractere passee par
	 * MD5.
	 * 
	 * @param md5
	 *            La chaine a passe en MD5.
	 * @return Le chaine de caractere en MD5.
	 */
	public static String MD5(final String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
