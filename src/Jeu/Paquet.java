package Jeu;

import java.util.ArrayList;
import java.util.Collections;

/** Type de donnée représentant un paquet */
public class Paquet {
    /** nombres de cartes max dans un paquet */
    private static final int NBCARTESMAX = 104;

    /** contenu du paquet (liste de cartes) */
    private ArrayList<Carte> contenu;

    /**
     * Constructeur d'un paquet
     */
    public Paquet (){
        this.contenu = new ArrayList<Carte>();
        for (int i = 1;i<=NBCARTESMAX ;i++ ) {
            Carte c = new Carte(i);
            this.contenu.add(c);
        }
    }

    /**
     * Mélange le paquet
     */
    public void melanger(){
        assert (contenu.size()>1);
        Collections.shuffle(contenu);
    }

    /**
     * Distribue pour chaque joueur 10 cartes du paquet vers leur main
     * @param joueurs la liste de joueurs
     */
    public void distribuer(ArrayList<Joueur> joueurs){
        assert (joueurs.size()!=0);
        for ( Joueur j : joueurs) {
            for (int i = 0; i < 10; i++) j.piocher(contenu);
        }
    }

    /**
     * Dispose les séries en leur attribuant leurs premières cartes
     * @param séries la liste de séries
     */
    public void disposerSérie(ArrayList<Série> séries){
        assert (séries.size() == 4);
        for (Série s : séries){
            s.ajouter(contenu.get(contenu.size()-1));
            contenu.remove(contenu.size()-1);
        }
    }
}
