package Jeu;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

public class Joueur {
    private String nom;
    private Main main;
    private Carte carteChoisie;
    private int nbTetesDeBoeufsRamass�es;
    private int NbTetesDeBoeufsRamass�esCeTour;

    public Joueur(String nom){
        this.nom = nom;
        this.main = new Main();
        this.nbTetesDeBoeufsRamass�es = 0;
        this.nbTetesDeBoeufsRamass�es = 0;
    }
    public void clearTetesDeBoeufs(){NbTetesDeBoeufsRamass�esCeTour = 0;}//ne pas oublier de clear a chaque tour

    public void ajouterTetesDeBoeufs(int i){
        NbTetesDeBoeufsRamass�esCeTour = i;
        nbTetesDeBoeufsRamass�es+=i;
    }

    public int getValeurCarteChoisie() {
        return carteChoisie.getValeur();
    }

    public void poser(Plateau plateau){
        plateau.placer(carteChoisie);
    }

    public void piocher(ArrayList<Carte> cartes){
        main.ajouterCarteDe(cartes);
    }

    public int nbCartesDansMain(){
        return main.getNbCartesMain();
    }

    public void jouerTour(Partie partie, Scanner sc){
        System.out.println("A "+this.toString()+" de jouer.");
        pause();
        System.out.print(partie.getPlateau().toString());
        this.main.trierMain();
        System.out.println("- Vos cartes :"+this.main.toStringMain());
        System.out.print("Saisisez votre choix : ");
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

    public String toString() {
        return nom;
    }

    public String toStringRamass�(){
        if (NbTetesDeBoeufsRamass�esCeTour>0)
            return this.nom+" a ramass� "+this.NbTetesDeBoeufsRamass�esCeTour+" t�tes de boeufs\n";
        else return "";
    }

    public String toStringFinal(){
        return this.nom +" a ramass� "+ this.nbTetesDeBoeufsRamass�es+" t�tes de boeufs\n"; }
}