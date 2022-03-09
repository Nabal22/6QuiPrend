package test;

import Jeu.Carte;
import Jeu.Joueur;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JoueurTest {

    @Test
    public void testAjouterTetesDeBoeufs() {
        Joueur joueur1 = new Joueur("joueur1");
        joueur1.ajouterTetesDeBoeufs(14);
        assertTrue(joueur1.getNbTetesDeBoeufsRamassées() == 14);
        assertFalse(joueur1.getNbTetesDeBoeufsRamassées() == 18);
        System.out.println(joueur1.toStringFinal());
        assertTrue(joueur1.toStringFinal().equals("joueur1 a ramassé 14 têtes de boeufs\n"));
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
        Joueur joueur1 = new Joueur("joueur1");
        assertTrue(joueur1.toString().equals("joueur1"));
        assertFalse(joueur1.toString().equals("joueur2"));
        Joueur joueur2 = new Joueur("joueur2");
        assertTrue(joueur2.toString().equals("joueur2"));
        assertFalse(joueur2.toString().equals("joueur1"));
    }

    @Test
    public void toStringFinal() {
        Joueur joueur1 = new Joueur("joueur1");
        joueur1.ajouterTetesDeBoeufs(10);
        assertFalse(joueur1.toStringFinal().equals("joueur1"));
        assertTrue(joueur1.toStringFinal().equals("joueur1 a ramassé 10 têtes de boeufs\n"));
    }
}