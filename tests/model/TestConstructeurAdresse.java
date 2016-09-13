package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
import model.Adresse;

/**
 * Classe pour tester les constructeurs de la classe Adresse.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class TestConstructeurAdresse {

	private Adresse adresse;

	/**
	 * Lance les tests.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(TestConstructeurAdresse.class));
	}

	/**
	 * Initialise les attributs.
	 */
	@Before
	public void initialiser() {
		adresse = new Adresse(3, 12, "rue de test", new Integer(48372), "VilleTest", "TestLand", "AdresseTest");
	}

	/**
	 * Test si l'adresse a bien ete instanciee.
	 */
	@Test
	public void adresse() {
		assertNotNull("L'instance est créée", adresse);
	}

	/**
	 * Test les caracteristiques de l'adresse pour verifier qu'elle correspond
	 * bien a ce qui est attendu.
	 */
	@Test
	public void testAdresse() {
		assertEquals("L'id de l'adresse est bon ?", new Integer(3), adresse.getId());
		assertEquals("Le numéro de l'adresse est bon ?", new Integer(12), adresse.getNumero());
		assertEquals("La rue de l'adresse est bonne ?", "rue de test", adresse.getRue());
		assertEquals("Le code postal de l'adresse est bonne ?", new Integer(48372), adresse.getCodePostal());
		assertEquals("La ville de l'adresse est bonne ?", "VilleTest", adresse.getVille());
		assertEquals("Le pays de l'adresse est bon ?", "TestLand", adresse.getPays());
		assertEquals("Le nom de l'adresse est bon ?", "AdresseTest", adresse.getNomAdresse());
	}

	/**
	 * De-reference les objets instanciee.
	 */
	@After
	public void nettoyer() {
		adresse = null;
	}
}
