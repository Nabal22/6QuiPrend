package test;

import Jeu.Carte;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarteTest {

    @Test
    public void testCarte() {
        Carte a = new Carte(1); Carte b = new Carte(1);
        assertTrue(a.toString().equals(b.toString()));
        Carte c = new Carte(2);
        assertFalse(a.toString().equals(c.toString()));
    }

    @Test
    public void getValeur() {
    }

    @Test
    public void getNbBoeuf() {
    }
}