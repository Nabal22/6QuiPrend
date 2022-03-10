package test;

import Jeu.Carte;
import Jeu.Plateau;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {

    /**
     * Dans ce test, nous testons si le get du nombre de têtes de boeufs pour une série (ici la première) fonctionne. Nous testons la méthode placer par la même occasion
     */
    @Test
    public void testGetNbTeteDeBoeufsFromSérie() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getNbTeteDeBoeufsFromSérie(0) == 1);
    }

    /**
     * Dans ce test, nous testons si les série se clear bien avec la méthode
     */
    @Test
    public void testClearSérie() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getSéries().get(0).getLastCarte() == carte8);
        plateau.clearSérie(0);
        assertTrue(plateau.getSéries().get(0).estVide());
    }

    /**
     * Dans ce test, nous testons si la méthode placer place les cartes au bon endroit dans la bonne série
     */
    @Test
    public void testPlacer() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        assertTrue(plateau.getSéries().get(0).getLastCarte() == carte8);
        Carte carte6 = new Carte(6);
        plateau.placer(carte6);
        assertTrue(plateau.getSéries().get(1).getLastCarte() == carte6);
        Carte carte18 = new Carte(18);
        plateau.placer(carte18);
        assertTrue(plateau.getSéries().get(2).getLastCarte() == carte18);
        Carte carte54 = new Carte(54);
        plateau.placer(carte54);
        assertTrue(plateau.getSéries().get(3).getLastCarte() == carte54);
        Carte carte55 = new Carte(55);
        plateau.placer(carte55);
        assertTrue(plateau.getSéries().get(3).getLastCarte() == carte55);
    }

    /**
     * Dans ce test, je vérifie à partir d'une situation donnée si une carte est posabale dans le plateau.
     * Elle ne l'est pas si la série est pleine ou si la valeur est inférieur à toute les dernière carte de chaque série
     */
    @Test
    public void testEstPosable() {
        Plateau plateau = new Plateau();
        Carte carte8 = new Carte(8);
        plateau.placer(carte8);
        Carte carte6 = new Carte(6);
        plateau.placer(carte6);
        Carte carte18 = new Carte(18);
        plateau.placer(carte18);
        Carte carte54 = new Carte(54);
        plateau.placer(carte54);
        Carte carte55 = new Carte(55);
        plateau.placer(carte55);
        assertFalse(plateau.estPosable(1));
        assertTrue(plateau.estPosable(58));
        Carte carte56 = new Carte(56);
        plateau.placer(carte56);
        Carte carte57 = new Carte(57);
        plateau.placer(carte57);
        Carte carte58 = new Carte(58);
        plateau.placer(carte58);
        assertFalse(plateau.estPosable(58));
    }

    /**
     * Dans ce test, nous testons si la méthode toString du plateau indique la chaine de caractère attendu
     */
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