import java.util.ArrayList;
import java.util.Scanner;

public class Partie {
    private static final int NBJOUEURMIN = 2;
    private static final int NBJOUEURMAX = 10;

    private Plateau plateau;
    private Paquet pioche;
    private ArrayList<Joueur> joueurs;
    private int nbJoueur;

    public Partie(ArrayList<Joueur> joueurs){
        this.plateau = new Plateau();
        this.pioche = new Paquet();
        this.joueurs = joueurs;
        this.nbJoueur = joueurs.size();
        System.out.print("Les "+this.nbJoueur+" joueurs sont");
        for (int i = 0 ; i < joueurs.size(); i++)
        {
            if (i == joueurs.size()-1)
                System.out.println(" "+ joueurs.get(i).getNom()+". Merci de jouer ? 6 qui prend !");
            else if (i == joueurs.size()-2) System.out.print(" "+ joueurs.get(i).getNom()+" et " );
            else
                System.out.print(" "+ joueurs.get(i).getNom()+"," );
        }
    }

}