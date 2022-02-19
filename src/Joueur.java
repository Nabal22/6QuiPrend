import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

public class Joueur {
    private String nom;
    private Main main;
    private ArrayList<Carte> récup;
    private Carte carteChoisie;

    public Joueur(String nom){
        this.nom = nom;
        this.main = new Main();
        this.récup = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public Main getMain() {
        return main;
    }

    public Carte getCarteChoisie() {
        return carteChoisie;
    }


    public boolean possède(int valeurCarteChoisie){
        assert (main.taille()!=0);
        for(Carte carte : this.getMain().getMain()){
            if (valeurCarteChoisie==carte.getValeur()){
                return true;
            }
        }
        return false;
    }

    // Probleme ici le assert ne plante pas le programme
    public void setCarteChoisie(int valeur){
        for (int i = 0;i < main.taille() ; i++){
            carteChoisie = main.getCarteMain(i);
            main.getMain().remove(i);
        }
    }

    public void jouerTour(Partie partie, Scanner sc){
        System.out.println("A "+this.getNom()+" de jouer.");
        pause();
        System.out.print(partie.getPlateau().toString());
        this.main.trierMain();
        System.out.println("-Vos cartes :"+this.getMain().toStringMain());
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