package test;

import Jeu.Carte;
import Jeu.S�rie;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class S�rieTest {

    @Test
    public void ajouter() {
        S�rie s�rie = new S�rie();
        Carte carte10 = new Carte(10);
        s�rie.ajouter(carte10);
        assertTrue(s�rie.getLastCarte() == carte10);
    }


    @Test
    public void testToString() {
        S�rie s�rie = new S�rie();
        Carte carte10 = new Carte(10);
        s�rie.ajouter(carte10);
        Carte carte2 = new Carte(2);
        s�rie.ajouter(carte2);
        assertFalse(s�rie.toString().equals(" 2, 10 (3)"));
        assertTrue(s�rie.toString().equals(" 10 (3), 2"));
    }

    @Test
    public void estPleine() {
        S�rie s�rie = new S�rie();
        assertFalse(s�rie.estPleine());
        Carte carte10 = new Carte(10);
        s�rie.ajouter(carte10);
        assertFalse(s�rie.estPleine());
        Carte carte2 = new Carte(2);
        s�rie.ajouter(carte2);
        assertFalse(s�rie.estPleine());
        Carte carte16 = new Carte(16);
        s�rie.ajouter(carte16);
        assertFalse(s�rie.estPleine());
        Carte carte5 = new Carte(5);
        s�rie.ajouter(carte5);
        assertFalse(s�rie.estPleine());
        Carte carte76 = new Carte(76);
        s�rie.ajouter(carte76);
        assertTrue(s�rie.estPleine());

    }

    @Test
    public void estVide() {
        S�rie s�rie = new S�rie();
        assertTrue(s�rie.estVide());
    }

    @Test
    public void clear() {
        S�rie s�rie = new S�rie();
        Carte carte10 = new Carte(10);
        s�rie.ajouter(carte10);
        Carte carte2 = new Carte(2);
        s�rie.ajouter(carte2);
        assertFalse(s�rie.estVide());
        s�rie.clear();
        assertTrue(s�rie.estVide());
    }


    @Test
    public void getNbTeteDeBoeufs() {
        S�rie s�rie = new S�rie();
        Carte carte10 = new Carte(10);
        s�rie.ajouter(carte10);
        Carte carte2 = new Carte(2);
        s�rie.ajouter(carte2);
        assertTrue(s�rie.getNbTeteDeBoeufs() == 4);
        assertFalse(s�rie.getNbTeteDeBoeufs() == 15);
    }
}