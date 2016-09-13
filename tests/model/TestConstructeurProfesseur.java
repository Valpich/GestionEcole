package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
import model.Professeur;
import view.Application;

/**
 * Classe pour tester les constructeurs de la classe Professeur.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class TestConstructeurProfesseur {

	private Professeur professeur;

	/**
	 * Lance les tests.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(TestConstructeurProfesseur.class));
	}

	/**
	 * Initialise les attributs.
	 */
	@Before
	public void initialiser() {
		ArrayList<String> mail = new ArrayList<String>();
		mail.add("etuMailProf@test.com");
		mail.add("etuMailPerso@test.com");
		ArrayList<Integer> telephone = new ArrayList<Integer>();
		telephone.add(212345678);
		telephone.add(612345678);
		professeur = new Professeur(new Integer(13), "nomProfesseurTest", "prenomProfesseurTest",
				Application.creerDate(1993, 1, 1), new Integer(3), mail, telephone, Application.creerDate(1996, 1, 1),
				"identifiantProfTest");
	}

	/**
	 * Test si le professeur a bien ete instanciee.
	 */
	@Test
	public void professeur() {
		assertNotNull("L'instance est créée", professeur);
	}

	/**
	 * Test les caracteristiques du professeur pour verifier qu'il correspond
	 * bien a ce qui est attendu.
	 */
	@Test
	public void testProfesseur() {
		assertEquals("L'id du professeur est bon ?", new Integer(13), professeur.getId());
		assertEquals("Le nom du professeur est bon ?", "nomProfesseurTest", professeur.getNom());
		assertEquals("Le prenom du professeur est bon ?", "prenomProfesseurTest", professeur.getPrenom());
		assertEquals("Le date de naissance du professeur est bonne ?", Application.creerDate(1993, 1, 1),
				professeur.getDateDeNaissance());
		assertEquals("L'id de l'adresse est bon ?", new Integer(3), professeur.getIdAdresse());
		assertEquals("L'email professionel est bon ?", "etuMailProf@test.com", professeur.getEmailProfessionnel());
		assertEquals("L'email personnel est bon ?", "etuMailPerso@test.com", professeur.getEmailPersonnel());
		assertEquals("Le telephone mobile est bon ?", new Integer(612345678), professeur.getTelephoneMobile());
		assertEquals("Le telephone fixe est bon ?", new Integer(212345678), professeur.getTelephoneFixe());
		assertEquals("Le professeur n'est pas un redoublant ?", false, professeur.isRedoublant());
		assertEquals("L'année d'arrivée du professeur est bonne ?", Application.creerDate(1996, 1, 1),
				professeur.getAnneeArrivee());
		assertEquals("L'identifiant du professeur est bon ?", "identifiantProfTest", professeur.getIdentifiant());
		assertEquals("La promotion du professeur est bonne ?", "Professeur", professeur.getPromotion());
	}

	/**
	 * De-reference les objets instanciee.
	 */
	@After
	public void nettoyer() {
		professeur = null;
	}
}
