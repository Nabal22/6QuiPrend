package test;

import Jeu.Carte;
import Jeu.Plateau;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {

    @Test
    public void getNbTeteDeBoeufsFromSérie() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getNbTeteDeBoeufsFromSérie(0) == 1);
    }

    @Test
    public void clearSérie() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getSéries().get(0).getLastCarte() == carte8);
        plateau.clearSérie(0);
        assertTrue(plateau.getSéries().get(0).estVide());
    }

    @Test
    public void placer() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getSéries().get(0).getLastCarte() == carte8);
        //finir
    }

    @Test
    public void estPosable() {
        //finir
    }

    @Test
    public void testToString() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        Carte carte19 = new Carte(19);
        plateau.placer(carte19);
        Carte carte78 = new Carte(78);
        plateau.placer(carte78);
        Carte carte89 = new Carte(98);
        plateau.placer(carte89);
        assertTrue(plateau.toString().equals("- série n° 1 : 8\n- série n° 2 : 19\n- série n° 3 : 78\n- série n° 4 : 98\n"));
    }
}