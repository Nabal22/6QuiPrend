package test;

import Jeu.Carte;
import Jeu.Joueur;
import Jeu.Partie;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PartieTest {
    /**
     * Dans ce test, nous testons si le toStringFinal marche bien avec les valeurs renseigné, ainsi nous testons aussi
     * le constructeur de Partie.
     */
    @Test
    public void testToStringFinal() {
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur joueur1 = new Joueur("joueur1");
        joueur1.ajouterTetesDeBoeufs(53);
        Joueur joueur2 = new Joueur("joueur2");
        joueur2.ajouterTetesDeBoeufs(2);
        Joueur joueur3 = new Joueur("joueur3");
        joueur3.ajouterTetesDeBoeufs(18);
        Joueur joueur4 = new Joueur("joueur4");
        joueur4.ajouterTetesDeBoeufs(56);
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        joueurs.add(joueur3);
        joueurs.add(joueur4);
        Partie partie = new Partie(joueurs);
        System.out.println(partie.toStringFinal());
        assertTrue(partie.toStringFinal().equals("** Score final\njoueur2 a ramassé 2 têtes de boeufs\njoueur3 a ramassé 18 têtes de boeufs\n" +
                                                 "joueur1 a ramassé 53 têtes de boeufs\njoueur4 a ramassé 56 têtes de boeufs\n"));
    }

    /**
     * Dans ce test, nous testons si le toStringInit renvoie la bonne chaine de caractère
     */
    @Test
    public void testToStringInit() {
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur joueur1 = new Joueur("joueur1");
        Joueur joueur2 = new Joueur("joueur2");
        Joueur joueur3 = new Joueur("joueur3");
        Joueur joueur4 = new Joueur("joueur4");
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        joueurs.add(joueur3);
        joueurs.add(joueur4);
        Partie partie = new Partie(joueurs);
        assertTrue(partie.toStringInit().equals("Les 4 joueurs sont joueur1, joueur2, joueur3 et joueur4. Merci de jouer à 6 qui prend !"));
    }
}