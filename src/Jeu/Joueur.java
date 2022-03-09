package Jeu;

import java.util.ArrayList;
import java.util.Scanner;

import static util.Console.clearScreen;
import static util.Console.pause;

/** Type de donn�es repr�sentant les joueurs */
public class Joueur {
    /** nom du joueur */
    private String nom;
    /** main du joueur */
    private Main main;
    /** carte choisi par le joueur */
    private Carte carteChoisie;
    /** nombre de t�te de boeufs total du joueur */
    private int nbTetesDeBoeufsRamass�es;
    /** nombre de t�te de boeufs ramas� par le joueur en un tour */
    private int NbTetesDeBoeufsRamass�esCeTour;

    /**
     * Constructeur du joueur
     * @param nom nom du joueur
     */
    public Joueur(String nom){
        this.nom = nom;
        this.main = new Main();
        this.NbTetesDeBoeufsRamass�esCeTour = 0;
        this.nbTetesDeBoeufsRamass�es = 0;
    }

    /**
     * Clear le nombre de t�tes de boeufs d'un joueur lors d'un tour
     */
    public void clearTetesDeBoeufs(){NbTetesDeBoeufsRamass�esCeTour = 0;}//ne pas oublier de clear a chaque tour

    /**
     * Ajoute au total de nombre de t�tes de boeufs le nombre indiqu�
     * @param i le nombre de t�tes de boeufs � ajouter
     */
    public void ajouterTetesDeBoeufs(int i){
        NbTetesDeBoeufsRamass�esCeTour = i;
        nbTetesDeBoeufsRamass�es+=i;
    }

    /**
     * Retourne le nombre de t�tes de boeufs ramass�s au total par un joueur
     * @return nbTetesDeBoeufsRamass�es
     */
    public int getNbTetesDeBoeufsRamass�es() {
        return nbTetesDeBoeufsRamass�es;
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
     * Joue le tour du joueur en selectionnant la carte voulant �tre jou�e
     * @param partie la partie actuel
     * @param sc l'entr�e de la valeur de la carte du joueur
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

    /**
     * Indique le nom du joueur
     * @return la chaine de caract�re du nom du joueur
     */
    public String toString() {
        return nom;
    }

    /**
     * Indique le nom du joueur et le nombre de t�tes de boeufs qu'il a ramass�
     * @return le nom du joueur et le nombre de t�tes de boeufs qu'il a ramass�
     */
    public String toStringRamass�(){
        if (NbTetesDeBoeufsRamass�esCeTour>0)
            return this.nom+" a ramass� "+this.NbTetesDeBoeufsRamass�esCeTour+" t�tes de boeufs\n";
        else return "";
    }

    /**
     * Indique le nom du joueur et le nombre de t�tes de boeufs qu'il a ramass� au total
     *      * @return le nom du joueur et le nombre de t�tes de boeufs qu'il a ramass� au total
     */
    public String toStringFinal(){
        return this.nom +" a ramass� "+ this.nbTetesDeBoeufsRamass�es+" t�tes de boeufs\n"; }
}