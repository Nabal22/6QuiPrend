import java.util.ArrayList;

public class Joueur {

    private String nom;
    private ArrayList<Carte> main;
    private ArrayList<Carte>  récup;

    public Joueur(String nom ){
        this.nom = nom;
        this.main = new ArrayList<>();
        this.récup = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        String tmp = new String();
        tmp = "- Vos cartes :";
        for (Carte c : main) tmp+= " -" +  c.toString();
        return tmp+"\nSaissisez votre choix : ";
    }

    public void piocher(ArrayList<Carte> cartes){
        assert (main.size()<10);
        main.add(cartes.get(cartes.size()-1));
        cartes.remove(cartes.size()-1);
    }

    public int getNbCartesMain() {
        return main.size();
    }
}