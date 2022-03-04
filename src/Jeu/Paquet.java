package Jeu;

import java.util.ArrayList;
import java.util.Collections;

/** Type de donn�e repr�sentant un paquet */
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
     * M�lange le paquet
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
     * Dispose les s�ries en leur attribuant leurs premi�res cartes
     * @param s�ries la liste de s�ries
     */
    public void disposerS�rie(ArrayList<S�rie> s�ries){
        assert (s�ries.size() == 4);
        for (S�rie s : s�ries){
            s.ajouter(contenu.get(contenu.size()-1));
            contenu.remove(contenu.size()-1);
        }
    }
}
