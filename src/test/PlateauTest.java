package test;

import Jeu.Carte;
import Jeu.Plateau;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {

    @Test
    public void getNbTeteDeBoeufsFromS�rie() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getNbTeteDeBoeufsFromS�rie(0) == 1);
    }

    @Test
    public void clearS�rie() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getS�ries().get(0).getLastCarte() == carte8);
        plateau.clearS�rie(0);
        assertTrue(plateau.getS�ries().get(0).estVide());
    }

    @Test
    public void placer() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getS�ries().get(0).getLastCarte() == carte8);
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
        assertTrue(plateau.toString().equals("- s�rie n� 1 : 8\n- s�rie n� 2 : 19\n- s�rie n� 3 : 78\n- s�rie n� 4 : 98\n"));
    }
}