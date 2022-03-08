package test;

import Jeu.Carte;
import Jeu.Joueur;
import Jeu.Partie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class JoueurTest {

    @Test
    public void testAjouterTetesDeBoeufs() {
        Joueur j = new Joueur("simon");
        j.ajouterTetesDeBoeufs(14);
        assertTrue(j.getNbTetesDeBoeufsRamass�es() == 14);
        assertFalse(j.getNbTetesDeBoeufsRamass�es() == 18);
        System.out.println(j.toStringFinal());
        assertTrue(j.toStringFinal().equals("simon a ramass� 14 t�tes de boeufs\n"));
    }

    @Test
    public void clearTetesDeBoeufs() {
        Joueur j = new Joueur("alban");
        j.ajouterTetesDeBoeufs(15);
        assertTrue(j.getNbTetesDeBoeufsRamass�es() == 15);
        j.clearTetesDeBoeufs();
        assertFalse(j.getNbTetesDeBoeufsRamass�es() == 15);
        assertTrue(j.getNbTetesDeBoeufsRamass�es() == 0);

    }


    @Test
    public void piocher() {
        Joueur j = new Joueur("alban");
        ArrayList<Carte> temp = new ArrayList<>();
        for (int i = 10; i >0; i--) {
            Carte tempCarte = new Carte(i);
            temp.add(tempCarte);
            j.piocher(temp);
        }
        assertFalse(j.nbCartesDansMain() == 29);
        assertTrue(j.nbCartesDansMain() == 10);
    }

    @Test
    public void testToString() {
    }

    @Test
    public void toStringRamass�() {
    }
}