package test;

import Jeu.Carte;
import Jeu.Joueur;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JoueurTest {


    /**
     * Dans ce test, nous testons si la m�thodes d'ajout de t�tes de boeufs sur un joueur ajoute la bonne quantit�, nous testons aussi le toStringFinal et le constructeur
     */
    @Test
    public void testAjouterTetesDeBoeufs() {
        Joueur joueur1 = new Joueur("joueur1");
        joueur1.ajouterTetesDeBoeufs(14);
        assertTrue(joueur1.getNbTetesDeBoeufsRamass�es() == 14);
        assertFalse(joueur1.getNbTetesDeBoeufsRamass�es() == 18);
        assertTrue(joueur1.toStringFinal().equals("joueur1 a ramass� 14 t�tes de boeufs\n"));
    }


    /**
     * Dans ce test, nous testons la pioche d'un joueur si il pioche des cartes d'une liste de 1 � 10, il doit avoir 10 cartes en main. Nous testons les m�thodes
     * piocher et nbCartesDansMain
     */
    @Test
    public void testPiocher() {
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

    /**
     * Dans ce test, nous testons le toString renvoyer le nom du joueur
     */
    @Test
    public void testToString() {
        Joueur joueur1 = new Joueur("joueur1");
        assertTrue(joueur1.toString().equals("joueur1"));
        assertFalse(joueur1.toString().equals("joueur2"));
        Joueur joueur2 = new Joueur("joueur2");
        assertTrue(joueur2.toString().equals("joueur2"));
        assertFalse(joueur2.toString().equals("joueur1"));
    }

    /**
     * Dans ce test, nous testons si le toStringFinal renvoie la chaine de caract�re souhait�. Nous testons les m�thodes toStringFinal et ajouterTetesDeBoeufs
     */
    @Test
    public void toStringFinal() {
        Joueur joueur1 = new Joueur("joueur1");
        joueur1.ajouterTetesDeBoeufs(10);
        assertFalse(joueur1.toStringFinal().equals("joueur1"));
        assertTrue(joueur1.toStringFinal().equals("joueur1 a ramass� 10 t�tes de boeufs\n"));
    }
}