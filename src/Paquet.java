import javafx.animation.PauseTransition;
import java.util.*;

import java.util.ArrayList;
import java.util.Collection;

public class Paquet {
    private static final int NBCARTESMAX = 104;

    private ArrayList<Carte> contenu;

    public Paquet (){
        this.contenu = new ArrayList<Carte>();
        for (int i = 1;i<=104 ;i++ ) {
            Carte c = new Carte(i);
            this.contenu.add(c);
        }
    }

    public void melanger(){
        assert (contenu.size()>1);
        Collections.shuffle(contenu);
    }

    public void distribuer(ArrayList<Joueur> joueurs){
        assert (joueurs.size()!=0);
        for ( Joueur j : joueurs) {
            for (int i = 0; i < 10; i++) j.piocher(contenu);
        }
    }

    public void affichePaquet(){
        for (Carte i : this.contenu){
            System.out.println(i.toString());
        }
    }
}
