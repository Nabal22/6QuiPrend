import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

public class Joueur {
    private String nom;
    private ArrayList<Carte> main;
    private ArrayList<Carte>  récup;
    private Carte carteChoisie;

    public Joueur(String nom){
        this.nom = nom;
        this.main = new ArrayList<>();
        this.récup = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getNbCartesMain() {
        return main.size();
    }

    public Carte getCarteChoisie() {
        return carteChoisie;
    }

    public String toStringMain(){
        String tmp = new String();
        for (int i = 0 ; i < main.size() ; i++){
            if (i==main.size()-1)
                tmp += main.get(i).toString();
            else
                tmp += main.get(i).toString()+",";
        }
        return tmp;
    }

    public void piocher(ArrayList<Carte> cartes){
        assert (main.size()<10);
        main.add(cartes.get(cartes.size()-1));
        cartes.remove(cartes.size()-1);
    }

    public boolean possède(int valeurCarteChoisie){
        assert (main.size()!=0);
        for(Carte carte : main){
            if (valeurCarteChoisie==carte.getValeur()){
                return true;
            }
        }
        return false;
    }

    // Probleme ici le assert ne plante pas le programme
    public void setCarteChoisie(int valeur){
        for (int i = 0;i < main.size() ; i++){
            carteChoisie = main.get(i);
            main.remove(i);
        }
    }

    public void jouerTour(Partie partie, Scanner sc){
        System.out.println("A "+this.getNom()+" de jouer.");
        pause();
        System.out.print(partie.getPlateau().toString());
        System.out.println("-Vos cartes :"+this.toStringMain());
        System.out.print("Saissisez votre choix : ");
        boolean valeurVraiFaux = true;
        while(valeurVraiFaux) {
            int carteJoué = sc.nextInt();
            if (this.possède(carteJoué)) {
                this.setCarteChoisie(carteJoué);
                valeurVraiFaux = false;
            }
            else {
                System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
            }
        }
        clearScreen();
    }
}