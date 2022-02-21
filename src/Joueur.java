import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

public class Joueur {
    private String nom;
    private Main main;
    private ArrayList<Carte> r�cup;
    private Carte carteChoisie;

    public Joueur(String nom){
        this.nom = nom;
        this.main = new Main();
        this.r�cup = new ArrayList<>();
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


    //poss�de renom� en contient et d�plac� dans la main


    public void jouerTour(Partie partie, Scanner sc){
        System.out.println("A "+this.toString()+" de jouer.");
        pause();
        System.out.print(partie.getPlateau().toString());
        this.main.trierMain();
        System.out.println("-Vos cartes :"+this.getMain().toStringMain());
        System.out.print("Saissisez votre choix : ");
        boolean valeurVraiFaux = true;
        while(valeurVraiFaux) {
            int valeurCarteJou�e = sc.nextInt();
            if (this.main.contient(valeurCarteJou�e)) {
                this.carteChoisie = main.getCarteMainByValeur(valeurCarteJou�e);
                valeurVraiFaux = false;
            }
            else {
                System.out.print("Vous n'avez pas cette carte, saisissez votre choix : ");
            }
        }
        clearScreen();
    }
}