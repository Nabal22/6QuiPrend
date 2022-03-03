package Jeu;

import Jeu.Carte;
import Jeu.Joueur;

import java.util.*;
import java.util.ArrayList;

public class Paquet {
    private static final int NBCARTESMAX = 104;
    private ArrayList<Carte> contenu;

    /**
     *
     */
    public Paquet (){
        this.contenu = new ArrayList<Carte>();
        for (int i = 1;i<=NBCARTESMAX ;i++ ) {
            Carte c = new Carte(i);
            this.contenu.add(c);
        }
    }

    /**
     *
     */
    public void melanger(){
        assert (contenu.size()>1);
        Collections.shuffle(contenu);
    }

    /**
     *
     * @param joueurs
     */
    public void distribuer(ArrayList<Joueur> joueurs){
        assert (joueurs.size()!=0);
        for ( Joueur j : joueurs) {
            for (int i = 0; i < 10; i++) j.piocher(contenu);
        }
    }

    /**
     * 
     * @param séries
     */
    public void disposerSérie(ArrayList<Série> séries){
        assert (séries.size() == 4);
        for (Série s : séries){
            s.ajouter(contenu.get(contenu.size()-1));
            contenu.remove(contenu.size()-1);
        }
    }
}
