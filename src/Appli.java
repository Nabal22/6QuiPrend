import Jeu.Joueur;
import Jeu.Paquet;
import Jeu.Partie;

import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/** Classe de la méthode main */
public class Appli {

    public static void main(String[] args) {
        Partie partie = new Partie(enregistrementJoueur());
        System.out.println(partie.toStringInit());
        Paquet paquet = new Paquet();
        paquet.melanger();
        paquet.distribuer(partie.getJoueurs());
        paquet.disposerSérie(partie.getPlateau().getSéries());

        Scanner sc = new Scanner(System.in);
        while (!partie.estFinie()){
            partie.clearCartesChoisies();// Nouveau tour on clear les cartes jouées au tour d'avant
            for (Joueur j : partie.getJoueurs()){
                j.jouerTour(partie,sc);
                partie.ajouterCarteChoisie(j.getValeurCarteChoisie());
            }
            partie.trierCartesChoisies();
            partie.jouerTour(sc);
        }
        System.out.println(partie.toStringFinal());
        sc.close();
    }

    /**
     * Indique la liste de joueur enregistré
     * @return la liste des joueurs
     */
    public static ArrayList<Joueur> enregistrementJoueur(){
        try {
            Scanner fichier = new Scanner(new FileInputStream("config.txt"));
            ArrayList<Joueur> listeJoueur = new ArrayList<>();
            while (fichier.hasNextLine()) {
                Joueur j = new Joueur(fichier.nextLine());
                listeJoueur.add(j);
            }
            fichier.close();
            return listeJoueur;
        }
        catch (FileNotFoundException e) {
            System.out.println("Impossible d'ouvrire le fichier");
        }
        return null;
    }
}



