package Jeu;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

/** Type de données représentant les joueurs */
public class Joueur {
    /** nom du joueur */
    private String nom;
    /** main du joueur */
    private Main main;
    /** carte choisi par le joueur */
    private Carte carteChoisie;
    /** nombre de tête de boeufs total du joueur */
    private int nbTetesDeBoeufsRamassées;
    /** nombre de tête de boeufs ramasé par le joueur en un tour */
    private int NbTetesDeBoeufsRamasséesCeTour;

    /**
     * Constructeur du joueur
     * @param nom nom du joueur
     */
    public Joueur(String nom){
        this.nom = nom;
        this.main = new Main();
        this.NbTetesDeBoeufsRamasséesCeTour = 0;
        this.nbTetesDeBoeufsRamassées = 0;
    }

    /**
     * Clear le nombre de têtes de boeufs d'un joueur lors d'un tour
     */
    public void clearTetesDeBoeufs(){NbTetesDeBoeufsRamasséesCeTour = 0;}//ne pas oublier de clear a chaque tour

    /**
     * Ajoute au total de nombre de têtes de boeufs le nombre indiqué
     * @param i le nombre de têtes de boeufs à ajouter
     */
    public void ajouterTetesDeBoeufs(int i){
        NbTetesDeBoeufsRamasséesCeTour = i;
        nbTetesDeBoeufsRamassées+=i;
    }

    /**
     * Retourne le nombre de têtes de boeufs ramassés au total par un joueur
     * @return nbTetesDeBoeufsRamassées
     */
    public int getNbTetesDeBoeufsRamassées() {
        return nbTetesDeBoeufsRamassées;
    }

    /**
     * Indique la valeur de la carte choisie par le joueur lors du tour
     * @return la valeur de la carte choisie
     */
    public int getValeurCarteChoisie() {
        return carteChoisie.getValeur();
    }

    /**
     * Pose la carte choisie sur le plateau de jeu
     * @param plateau le plateau de jeu
     */
    public void poser(Plateau plateau){
        plateau.placer(carteChoisie);
    }

    /**
     * Pioche une carte du paquet vers la main
     * @param cartes le contenu du paquet de cartes
     */
    public void piocher(ArrayList<Carte> cartes){
        main.ajouterCarteDe(cartes);
    }

    /**
     * Indique le nombre de cartes dans la main d'un joueur
     * @return le nombre de cartes dans la main du joueur
     */
    public int nbCartesDansMain(){
        return main.getNbCartesMain();
    }

    /**
     * Joue le tour du joueur en selectionnant la carte voulant être jouée
     * @param partie la partie actuel
     * @param sc l'entrée de la valeur de la carte du joueur
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
     * Indique le nom du joueur
     * @return la chaine de caractère du nom du joueur
     */
    public String toString() {
        return nom;
    }

    /**
     * Indique le nom du joueur et le nombre de têtes de boeufs qu'il a ramassé
     * @return le nom du joueur et le nombre de têtes de boeufs qu'il a ramassé
     */
    public String toStringRamassé(){
        if (NbTetesDeBoeufsRamasséesCeTour>0)
            return this.nom+" a ramassé "+this.NbTetesDeBoeufsRamasséesCeTour+" têtes de boeufs\n";
        else return "";
    }

    /**
     * Indique le nom du joueur et le nombre de têtes de boeufs qu'il a ramassé au total
     *      * @return le nom du joueur et le nombre de têtes de boeufs qu'il a ramassé au total
     */
    public String toStringFinal(){
        return this.nom +" a ramassé "+ this.nbTetesDeBoeufsRamassées+" têtes de boeufs\n"; }
}