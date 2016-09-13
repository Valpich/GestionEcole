package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
import model.Semestre;
import view.Application;

/**
 * Classe pour tester les constructeurs de la classe Semestre.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class TestConstructeurSemestre {

	private Semestre semestre;

	/**
	 * Lance les tests.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(TestConstructeurSemestre.class));
	}

	/**
	 * Initialise les attributs.
	 */
	@Before
	public void initialiser() {
		semestre = new Semestre(3, Application.creerDate(90, 8, 3), Application.creerDate(91, 1, 27), "testSemestre",
				new Integer(1));
	}

	/**
	 * Test si le semestre a bien ete instanciee.
	 */
	@Test
	public void semestre() {
		assertNotNull("L'instance est créée", semestre);
	}

	/**
	 * Test les caracteristiques du semestre pour verifier qu'il correspond bien
	 * a ce qui est attendu.
	 */
	@Test
	public void testSemestre() {
		assertEquals("L'id du semestre est bon ?", new Integer(3), semestre.getId());
		assertEquals("La date de début du semestre est bonne ?", Application.creerDate(90, 8, 3),
				semestre.getDateDebut());
		assertEquals("La date de début du semestre est bonne ?", Application.creerDate(91, 1, 27),
				semestre.getDateFin());
		assertEquals("Le nom du semestre est bon ?", "testSemestre", semestre.getNom());
		assertEquals("La validation du semestre est bonne ?", new Integer(1), semestre.getValide());
	}

	/**
	 * De-reference les objets instanciee.
	 */
	@After
	public void nettoyer() {
		semestre = null;
	}
}
