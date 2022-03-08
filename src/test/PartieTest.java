package test;

import Jeu.Joueur;
import Jeu.Partie;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PartieTest {

    @Test
    public void estFinie() {
    }

    @Test
    public void jouerTour() {
    }

    @Test
    public void toStringFinal() {
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur simon = new Joueur("simon");
        simon.ajouterTetesDeBoeufs(53);
        Joueur alban = new Joueur("alban");
        alban.ajouterTetesDeBoeufs(2);
        Joueur marwan = new Joueur("marwan");
        marwan.ajouterTetesDeBoeufs(18);
        Joueur steven = new Joueur("steven");
        steven.ajouterTetesDeBoeufs(56);
        joueurs.add(simon);
        joueurs.add(alban);
        joueurs.add(marwan);
        joueurs.add(steven);
        Partie partie = new Partie(joueurs);
        System.out.println(partie.toStringFinal());
    }

    @Test
    public void getPlateau() {
    }

    @Test
    public void getJoueurs() {
    }

    @Test
    public void getJoueurParCarteChoisie() {
    }

    @Test
    public void ajouterCarteChoisie() {
    }

    @Test
    public void clearCartesChoisies() {
    }

    @Test
    public void trierCartesChoisies() {
    }

    @Test
    public void toStringCartesChoisies() {
    }

    @Test
    public void toStringTetesDeBoeufs() {
    }
}