import Jeu.Joueur;
import Jeu.Paquet;
import Jeu.Partie;

import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Appli {

    public static void main(String[] args) {
        Partie partie = new Partie(enregistrementJoueur());
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
            //Trie et affichage des cartes choisie
            partie.trierCartesChoisies();
            System.out.println(partie.toStringCartesChoisies());
            //A mon avis il faut faire la boucle suivante dans la classe partie
            //ça nous enlevera plein de getter.
            partie.jouerTour();

        }
        sc.close();
    }

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



