package test;

import Jeu.Carte;
import Jeu.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {

    /**
     * Dans ce test, nous testons si le constructeur et la méthode ajouterCarteDe constitue une main. Nous
     * testons aussi la méthode toString en comparant avec le résultat souhaité
     */
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

    /**
     * Dans ce test, nous testons si la méthode getCarteMainByValeur renvoie la bonne carte depuis la valeur choisie
     */
    @Test
    public void testGetCarteMainByValeur() {
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


    /**
     * Dans ce test, nous testons si la méthode getNbCartesMain renvoie le bon nombre de carte en main
     */
    @Test
    public void testGetNbCartesMain() {
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

    /**
     *  Dans ce test, nous testons si la méthode trierMain trie les cartes dans l'ordre croissant de valeur
     */
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