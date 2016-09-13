package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
import model.Administrateur;
import view.Application;

/**
 * Classe pour tester les constructeurs de la classe Administrateur.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class TestConstructeurAdministrateur {

	private Administrateur administrateur;

	/**
	 * Lance les tests.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(TestConstructeurAdministrateur.class));
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
		administrateur = new Administrateur(new Integer(12), "nomAdministrateurTest", "prenomAdministrateurTest",
				Application.creerDate(1991, 1, 1), new Integer(5), mail, telephone, Application.creerDate(1994, 1, 1),
				"identifiantAdminTest");
	}

	/**
	 * Test si l'administrateur a bien ete instanciee.
	 */
	@Test
	public void administrateur() {
		assertNotNull("L'instance est créée", administrateur);
	}

	/**
	 * Test les caracteristiques de l'administrateur pour verifier qu'il
	 * correspond bien a ce qui est attendu.
	 */
	@Test
	public void testAdministrateur() {
		assertEquals("L'id de l'administrateur est bon ?", new Integer(12), administrateur.getId());
		assertEquals("Le nom de l'administrateur est bon ?", "nomAdministrateurTest", administrateur.getNom());
		assertEquals("Le prenom de l'administrateur est bon ?", "prenomAdministrateurTest", administrateur.getPrenom());
		assertEquals("Le date de naissance l'administrateur est bonne ?", Application.creerDate(1991, 1, 1),
				administrateur.getDateDeNaissance());
		assertEquals("L'id de l'adresse est bon ?", new Integer(5), administrateur.getIdAdresse());
		assertEquals("L'email professionel est bon ?", "etuMailProf@test.com", administrateur.getEmailProfessionnel());
		assertEquals("L'email personnel est bon ?", "etuMailPerso@test.com", administrateur.getEmailPersonnel());
		assertEquals("Le telephone mobile est bon ?", new Integer(612345678), administrateur.getTelephoneMobile());
		assertEquals("Le telephone fixe est bon ?", new Integer(212345678), administrateur.getTelephoneFixe());
		assertEquals("L'administrateur n'est pas un redoublant ?", false, administrateur.isRedoublant());
		assertEquals("L'année d'arrivée de l'administrateur est bonne ?", Application.creerDate(1994, 1, 1),
				administrateur.getAnneeArrivee());
		assertEquals("L'identifiant de l'administrateur est bon ?", "identifiantAdminTest",
				administrateur.getIdentifiant());
		assertEquals("La promotion de l'administrateur est bonne ?", "Administrateur", administrateur.getPromotion());
	}

	/**
	 * De-reference les objets instanciee.
	 */
	@After
	public void nettoyer() {
		administrateur = null;
	}
}
