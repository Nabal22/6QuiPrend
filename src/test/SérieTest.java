package test;

import Jeu.Carte;
import Jeu.S�rie;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class S�rieTest {

    /**
     * Dans ce test, nous testons si la m�thode ajouter ajoute bien la carte voulu dans la s�rie
     */
    @Test
    public void testAjouter() {
        S�rie s�rie = new S�rie();
        Carte carte10 = new Carte(10);
        s�rie.ajouter(carte10);
        assertTrue(s�rie.getLastCarte() == carte10);
    }


    /**
     * Dans ce test, nous testons si toString renvoie la valeur attendu de la s�rie
     */
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

    /**
     * Dans ce test, nous testons dans plusieurs cas de figures si la s�rie est pleine ou non
     */
    @Test
    public void testEstPleine() {
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

    /**
     * Dans ce test, nous testons si la s�rie est vide
     */
    @Test
    public void testEstVide() {
        S�rie s�rie = new S�rie();
        assertTrue(s�rie.estVide());
        Carte carte76 = new Carte(76);
        s�rie.ajouter(carte76);
        assertFalse(s�rie.estVide());
    }

    /**
     * Dans ce test, nous testons si la s�rie se clear gr�ce � la m�thode clear
     */
    @Test
    public void testClear() {
        S�rie s�rie = new S�rie();
        Carte carte10 = new Carte(10);
        s�rie.ajouter(carte10);
        Carte carte2 = new Carte(2);
        s�rie.ajouter(carte2);
        assertFalse(s�rie.estVide());
        s�rie.clear();
        assertTrue(s�rie.estVide());
    }

    /**
     * Dans ce test, nous testons si la m�thode getNbTeteBoeufs renvoie le bon nombre de t�tes de boeufs de la s�rie
     */
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