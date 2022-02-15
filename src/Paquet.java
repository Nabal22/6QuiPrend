import javafx.animation.PauseTransition;

import java.util.ArrayList;

public class Paquet {
    private static final int NBCARTESMAX = 104;

    private int nbCarte;
    private ArrayList<Carte> contenu;

    public Paquet (){
        this.contenu = new ArrayList<Carte>();
        for (int i = 1;i<=104 ;i++ ) {
            Carte c = new Carte(i);
            this.contenu.add(c);
        }
    }

    public void affichePaquet(){
        for (Carte i : this.contenu){
            System.out.println(i.toString());
        }
    }
}
