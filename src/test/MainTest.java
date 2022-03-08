package test;

import Jeu.Carte;
import Jeu.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMain() {
        Main m = new Main();
        ArrayList<Carte> temp = new ArrayList<>();
        for (int i = 10; i >0; i--) {
            Carte tempCarte = new Carte(i);
            temp.add(tempCarte);
            m.ajouterCarteDe(temp);
        }
        assertTrue(m.toStringMain().equals(" 10 (3), 9, 8, 7, 6, 5 (2), 4, 3, 2, 1"));


    }

    @Test
    public void getCarteMainByValeur() {
        Main m = new Main();
        ArrayList<Carte> temp = new ArrayList<>();
        for (int i = 10; i >0; i--) {
            Carte tempCarte = new Carte(i);
            temp.add(tempCarte);
            m.ajouterCarteDe(temp);
        }
        Carte c = m.getCarteMainByValeur(5);
        assertTrue(c.getValeur() == 5);
        assertTrue(c.getNbBoeuf() == 2);
        assertFalse(c.getValeur() == 2);
        assertFalse(c.getNbBoeuf() == 18);
        assertTrue(c.toString().equals(" 5 (2)"));
    }

    @Test
    public void getNbCartesMain() {
        Main m = new Main();
        ArrayList<Carte> temp = new ArrayList<>();
        for (int i = 10; i >0; i--) {
            Carte tempCarte = new Carte(i);
            temp.add(tempCarte);
            m.ajouterCarteDe(temp);
        }
        assertFalse(m.getNbCartesMain() == 5);
        assertTrue(m.getNbCartesMain() == 10);
    }

    @Test
    public void trierMain() {
        Main m = new Main();
        ArrayList<Carte> temp = new ArrayList<>();
        for (int i = 10; i >0; i--) {
            Carte tempCarte = new Carte(i);
            temp.add(tempCarte);
            m.ajouterCarteDe(temp);
        }
        m.trierMain();
        assertTrue(m.toStringMain().equals(" 1, 2, 3, 4, 5 (2), 6, 7, 8, 9, 10 (3)"));
    }

}