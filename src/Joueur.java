import java.util.ArrayList;

public class Joueur {
    private static final int NBCARTESMAINS = 10;

    private String nom;
    private ArrayList<Carte> main;
    private ArrayList<Carte>  r�cup;

    public Joueur(String nom ){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}