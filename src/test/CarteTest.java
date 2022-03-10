package test;

import Jeu.Carte;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarteTest {

    /**
     * Dans ce test, nous testons si le contructeur de carte initialise bien la carte et nous testons aussi la méthode toString
     */
    @Test
    public void testCarte() {
        Carte a = new Carte(1); Carte b = new Carte(1);
        assertTrue(a.toString().equals(b.toString()));
        Carte c = new Carte(2);
        assertFalse(a.toString().equals(c.toString()));
    }

    /**
     * Dans ce test, nous testons si les valeurs initialiser sont correctes
     */
    @Test
    public void testGet() {
        Carte a = new Carte(5);
        assertFalse(a.getValeur() == 6);
        assertTrue(a.getValeur() == 5);
        assertTrue(a.getNbBoeuf() == 2);
        assertFalse(a.getNbBoeuf() == 15);
    }
}