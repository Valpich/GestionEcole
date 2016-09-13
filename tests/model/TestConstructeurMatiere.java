package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
import model.Matiere;

/**
 * Classe pour tester les constructeurs des classes de base du modele.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class TestConstructeurMatiere {

	private Matiere matiere;

	/**
	 * Lance les tests.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(TestConstructeurMatiere.class));
	}

	/**
	 * Initialise les attributs.
	 */
	@Before
	public void initialiser() {
		matiere = new Matiere(2, 1, "TestMatiere", 8.5, 2, 3);
	}

	/**
	 * Test si la matiere a bien ete instanciee.
	 */
	@Test
	public void matiere() {
		assertNotNull("L'instance est créée", matiere);
	}

	/**
	 * Test les caracteristiques de la matiere pour verifier qu'elle corresponde
	 * bien a ce qui est attendu.
	 */
	@Test
	public void testMatiere() {
		assertEquals("L'id de la matiere est bon ?", new Integer(2), matiere.getId());
		assertEquals("L'id du responsable est bon ?", new Integer(1), matiere.getIdResponsable());
		assertEquals("Le nom de la matiere est bon ?", "TestMatiere", matiere.getNom());
		assertEquals("Le coefficient de la matiere est bon ?", new Double(8.5), matiere.getCoefficient());
		assertEquals("L'id semestre de la matiere est bon ?", new Integer(2), matiere.getIdSemestre());
		assertEquals("La moyenne de la matiere est bonne ?", new Double(3), matiere.getMoyenne());

	}

	/**
	 * De-reference les objets instanciee.
	 */
	@After
	public void nettoyer() {
		matiere = null;
	}
}
