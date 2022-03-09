package test;

import Jeu.Carte;
import Jeu.Série;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SérieTest {

    @Test
    public void ajouter() {
        Série série = new Série();
        Carte carte10 = new Carte(10);
        série.ajouter(carte10);
        assertTrue(série.getLastCarte() == carte10);
    }


    @Test
    public void testToString() {
        Série série = new Série();
        Carte carte10 = new Carte(10);
        série.ajouter(carte10);
        Carte carte2 = new Carte(2);
        série.ajouter(carte2);
        assertFalse(série.toString().equals(" 2, 10 (3)"));
        assertTrue(série.toString().equals(" 10 (3), 2"));
    }

    @Test
    public void estPleine() {
        Série série = new Série();
        assertFalse(série.estPleine());
        Carte carte10 = new Carte(10);
        série.ajouter(carte10);
        assertFalse(série.estPleine());
        Carte carte2 = new Carte(2);
        série.ajouter(carte2);
        assertFalse(série.estPleine());
        Carte carte16 = new Carte(16);
        série.ajouter(carte16);
        assertFalse(série.estPleine());
        Carte carte5 = new Carte(5);
        série.ajouter(carte5);
        assertFalse(série.estPleine());
        Carte carte76 = new Carte(76);
        série.ajouter(carte76);
        assertTrue(série.estPleine());

    }

    @Test
    public void estVide() {
        Série série = new Série();
        assertTrue(série.estVide());
    }

    @Test
    public void clear() {
        Série série = new Série();
        Carte carte10 = new Carte(10);
        série.ajouter(carte10);
        Carte carte2 = new Carte(2);
        série.ajouter(carte2);
        assertFalse(série.estVide());
        série.clear();
        assertTrue(série.estVide());
    }


    @Test
    public void getNbTeteDeBoeufs() {
        Série série = new Série();
        Carte carte10 = new Carte(10);
        série.ajouter(carte10);
        Carte carte2 = new Carte(2);
        série.ajouter(carte2);
        assertTrue(série.getNbTeteDeBoeufs() == 4);
        assertFalse(série.getNbTeteDeBoeufs() == 15);
    }
}