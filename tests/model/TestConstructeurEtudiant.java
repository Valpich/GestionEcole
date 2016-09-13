package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
import model.Etudiant;
import view.Application;

/**
 * Classe pour tester les constructeurs de la classe Etudiant.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class TestConstructeurEtudiant {

	private Etudiant etudiant;

	/**
	 * Lance les tests.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(TestConstructeurEtudiant.class));
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
		etudiant = new Etudiant(new Integer(11), "nomEtudiantTest", "prenomEtudiantTest",
				Application.creerDate(1990, 1, 1), new Integer(2), mail, telephone, false,
				Application.creerDate(1990, 1, 1), "identifiantEtudiantTest", "promoTestEtudiant");
	}

	/**
	 * Test si l'etudiant a bien ete instanciee.
	 */
	@Test
	public void etudiant() {
		assertNotNull("L'instance est créée", etudiant);
	}

	/**
	 * Test les caracteristiques de l'etudiant pour verifier qu'il correspond
	 * bien a ce qui est attendu.
	 */
	@Test
	public void testEtudiant() {
		assertEquals("L'id de l'etutiant est bon ?", new Integer(11), etudiant.getId());
		assertEquals("Le nom de l'etutiant est bon ?", "nomEtudiantTest", etudiant.getNom());
		assertEquals("Le prenom de l'etutiant est bon ?", "prenomEtudiantTest", etudiant.getPrenom());
		assertEquals("Le date de naissance l'etutiant est bonne ?", Application.creerDate(1990, 1, 1),
				etudiant.getDateDeNaissance());
		assertEquals("L'id de l'adresse est bon ?", new Integer(2), etudiant.getIdAdresse());
		assertEquals("L'email professionel est bon ?", "etuMailProf@test.com", etudiant.getEmailProfessionnel());
		assertEquals("L'email personnel est bon ?", "etuMailPerso@test.com", etudiant.getEmailPersonnel());
		assertEquals("Le telephone mobile est bon ?", new Integer(612345678), etudiant.getTelephoneMobile());
		assertEquals("Le telephone fixe est bon ?", new Integer(212345678), etudiant.getTelephoneFixe());
		assertEquals("L'etudiant n'est pas un redoublant ?", false, etudiant.isRedoublant());
		assertEquals("L'année d'arrivée de l'étudiant est bonne ?", Application.creerDate(1990, 1, 1),
				etudiant.getAnneeArrivee());
		assertEquals("L'identifiant de l'etudiant est bon ?", "identifiantEtudiantTest", etudiant.getIdentifiant());
		assertEquals("La promotion de l'étudiant est bonne ?", "promoTestEtudiant", etudiant.getPromotion());
	}

	/**
	 * De-reference les objets instanciee.
	 */
	@After
	public void nettoyer() {
		etudiant = null;
	}
}
