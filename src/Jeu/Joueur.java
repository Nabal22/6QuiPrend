package Jeu;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

public class Joueur {
    private String nom;
    private Main main;
    private Carte carteChoisie;
    private int nbTetesDeBoeufsRamassées;
    private int NbTetesDeBoeufsRamasséesCeTour;

    /**
     *
     * @param nom
     */
    public Joueur(String nom){
        this.nom = nom;
        this.main = new Main();
        this.nbTetesDeBoeufsRamassées = 0;
        this.nbTetesDeBoeufsRamassées = 0;
    }

    /**
     *
     */
    public void clearTetesDeBoeufs(){NbTetesDeBoeufsRamasséesCeTour = 0;}//ne pas oublier de clear a chaque tour

    /**
     *
     * @param i
     */
    public void ajouterTetesDeBoeufs(int i){
        NbTetesDeBoeufsRamasséesCeTour = i;
        nbTetesDeBoeufsRamassées+=i;
    }

    /**
     *
     * @return
     */
    public int getValeurCarteChoisie() {
        return carteChoisie.getValeur();
    }

    /**
     *
     * @param plateau
     */
    public void poser(Plateau plateau){
        plateau.placer(carteChoisie);
    }

    /**
     *
     * @param cartes
     */
    public void piocher(ArrayList<Carte> cartes){
        main.ajouterCarteDe(cartes);
    }

    /**
     *
     * @return
     */
    public int nbCartesDansMain(){
        return main.getNbCartesMain();
    }

    /**
     *
     * @param partie
     * @param sc
     */
    public void jouerTour(Partie partie, Scanner sc){
        System.out.println("A "+this.toString()+" de jouer.");
        pause();
        System.out.print(partie.getPlateau().toString());
        this.main.trierMain();
        System.out.println("- Vos cartes :"+this.main.toStringMain());
        System.out.print("Saisissez votre choix : ");
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

    /**
     *
     * @return
     */
    public String toString() {
        return nom;
    }

    /**
     *
     * @return
     */
    public String toStringRamassé(){
        if (NbTetesDeBoeufsRamasséesCeTour>0)
            return this.nom+" a ramassé "+this.NbTetesDeBoeufsRamasséesCeTour+" têtes de boeufs\n";
        else return "";
    }

    /**
     *
     * @return
     */
    public String toStringFinal(){
        return this.nom +" a ramassé "+ this.nbTetesDeBoeufsRamassées+" têtes de boeufs\n"; }
}