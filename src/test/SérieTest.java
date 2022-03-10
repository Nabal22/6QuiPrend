package test;

import Jeu.Carte;
import Jeu.Série;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SérieTest {

    /**
     * Dans ce test, nous testons si la méthode ajouter ajoute bien la carte voulu dans la série
     */
    @Test
    public void testAjouter() {
        Série série = new Série();
        Carte carte10 = new Carte(10);
        série.ajouter(carte10);
        assertTrue(série.getLastCarte() == carte10);
    }


    /**
     * Dans ce test, nous testons si toString renvoie la valeur attendu de la série
     */
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

    /**
     * Dans ce test, nous testons dans plusieurs cas de figures si la série est pleine ou non
     */
    @Test
    public void testEstPleine() {
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

    /**
     * Dans ce test, nous testons si la série est vide
     */
    @Test
    public void testEstVide() {
        Série série = new Série();
        assertTrue(série.estVide());
        Carte carte76 = new Carte(76);
        série.ajouter(carte76);
        assertFalse(série.estVide());
    }

    /**
     * Dans ce test, nous testons si la série se clear grâce à la méthode clear
     */
    @Test
    public void testClear() {
        Série série = new Série();
        Carte carte10 = new Carte(10);
        série.ajouter(carte10);
        Carte carte2 = new Carte(2);
        série.ajouter(carte2);
        assertFalse(série.estVide());
        série.clear();
        assertTrue(série.estVide());
    }

    /**
     * Dans ce test, nous testons si la méthode getNbTeteBoeufs renvoie le bon nombre de têtes de boeufs de la série
     */
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