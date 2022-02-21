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

    public String toString() {
        return nom;
    }

    public Main getMain() {
        return main;
    }

    public Carte getCarteChoisie() {
        return carteChoisie;
    }


    //possède renomé en contient et déplacé dans la main


    public void jouerTour(Partie partie, Scanner sc){
        System.out.println("A "+this.toString()+" de jouer.");
        pause();
        System.out.print(partie.getPlateau().toString());
        this.main.trierMain();
        System.out.println("-Vos cartes :"+this.getMain().toStringMain());
        System.out.print("Saissisez votre choix : ");
        boolean valeurVraiFaux = true;
        while(valeurVraiFaux) {
            int valeurCarteJouée = sc.nextInt();
            if (this.main.contient(valeurCarteJouée)) {
                this.carteChoisie = main.getCarteMainByValeur(valeurCarteJouée);
                valeurVraiFaux = false;
            }
            else {
                System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
            }
        }
        clearScreen();
    }
}