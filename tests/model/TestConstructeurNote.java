package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestSuite;
import model.Note;

/**
 * Classe pour tester les constructeurs de la classe Note.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class TestConstructeurNote {

	private Note note;

	/**
	 * Lance les tests.
	 * 
	 * @param args
	 *            Le tableau des chaines de caracteres de la liste de commande.
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(TestConstructeurNote.class));
	}

	/**
	 * Initialise les attributs.
	 */
	@Before
	public void initialiser() {
		note = new Note(1,"Informatique 1", 12.54, 4, 2, 6);
	}

	/**
	 * Test si la note a bien ete instanciee.
	 */
	@Test
	public void note() {
		assertNotNull("L'instance est creee", note);
	}

	/**
	 * Test les caracteristiques de la note pour verifier qu'elle correspond
	 * bien a ce qui est attendu.
	 */
	@Test
	public void testNote() {
		assertEquals("L'id de la note est bon ?", new Integer(1), note.getId());
		assertEquals("Le nom de la note est bon ?", "Informatique 1", note.getNom());
		assertEquals("La valeur de la note est bonne ?", new Double(12.54), note.getValeur());
		assertEquals("Le coefficient de la note est bon ?", new Double(4), note.getCoefficient());
		assertEquals("L'id de l'etudiant est bon ?", new Integer(2), note.getIdEtudiant());
		assertEquals("L'id de la matiere est bon ?", new Integer(6), note.getIdMatiere());
	}

	/**
	 * De-reference les objets instanciee.
	 */
	@After
	public void nettoyer() {
		note = null;
	}
}
