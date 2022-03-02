package Jeu;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Mettre des privates dans partie pour les méthodes qui sont utilisées que dans JouerTour

public class Partie {
    private static final int NBJOUEURMIN = 2;
    private static final int NBJOUEURMAX = 10;

    private Plateau plateau;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Integer> valeursCartesChoisies;

    public Partie(ArrayList<Joueur> joueurs){
        assert (joueurs.size()<=10 && joueurs.size() >=2);
        this.plateau = new Plateau();
        this.joueurs = joueurs;
        this.valeursCartesChoisies = new ArrayList<>();
        System.out.print("Les "+joueurs.size()+" joueurs sont");
        for (int i = 0 ; i < joueurs.size(); i++)
        {
            if (i == joueurs.size()-1)
                System.out.println(" "+ joueurs.get(i).toString()+". Merci de jouer à 6 qui prend !");
            else if (i == joueurs.size()-2) System.out.print(" "+ joueurs.get(i).toString()+" et " );
            else
                System.out.print(" "+ joueurs.get(i).toString()+"," );
        }
    }

    private void clearTetesDeBoeufsJoueurs(){
        for (Joueur j : joueurs) j.clearTetesDeBoeufs();
    }

    public boolean estFinie(){
        for ( Joueur j : joueurs){
            if (j.nbCartesDansMain()!=0) return false;
        }
        return true;
    }

    public void jouerTour(Scanner sc){
        boolean joueurARamassé = false;
        this.clearTetesDeBoeufsJoueurs();
        for (int i : valeursCartesChoisies){
            if (plateau.estPosable(i)) {
                this.getJoueurParCarteChoisie(i).poser(plateau);
            }
            else{
                int difference = i - plateau.getSéries().get(0).getLastCarte().getValeur();
                int sérieOuPlacer = 0;
                boolean posable = false;
                for (int compt = 0; compt < plateau.getSéries().size(); compt++) {
                    if ((difference < 0 && difference < i - plateau.getSéries().get(compt).getLastCarte().getValeur())
                            || (plateau.getSéries().get(compt).getLastCarte().getValeur() > 0 && plateau.getSéries().get(compt).getLastCarte().getValeur() < difference)) {

                        difference = i - plateau.getSéries().get(compt).getLastCarte().getValeur();
                        sérieOuPlacer = compt;
                        posable = true;
                    }
                    if(difference < 0) posable = false;
                    if(plateau.getSéries().get(compt).estPleine()) posable = true;
                }
                if (posable) {
                    joueurARamassé = true;
                    Joueur j = this.getJoueurParCarteChoisie(i);
                    j.ajouterTetesDeBoeufs(plateau.getNbTeteDeBoeufsFromSérie(sérieOuPlacer));
                    plateau.clearSérie(sérieOuPlacer);
                    j.poser(plateau);
                }
                else {
                    joueurARamassé = true;
                    Joueur j = this.getJoueurParCarteChoisie(i);
                    System.out.println(this.toStringCartesChoisies(true));
                    System.out.println("Pour poser la carte " + i + ", " + j.toString() +
                            " doit choisir la série qu'il va ramasser.");
                    System.out.print(this.plateau.toString());
                    System.out.print("Saissisez votre choix : ");
                    int choix = sc.nextInt();
                    while (choix > 4) choix = sc.nextInt();
                    --choix;// modifier pour prendre en compte les erreurs

                    j.ajouterTetesDeBoeufs(plateau.getNbTeteDeBoeufsFromSérie(choix));
                    plateau.clearSérie(choix);
                    j.poser(plateau);
                }
            }
        }
        System.out.println(this.toStringCartesChoisies(false));
        System.out.print(this.plateau.toString());
        System.out.println(this.toStringTetesDeBoeufs(joueurARamassé));
    }

    public String toStringFinal(){
        String tmp ="** Score final\n";
        for (Joueur j : joueurs){
            tmp += j.toStringFinal();
        }
        return tmp;
    }

    public Plateau getPlateau(){
        return plateau;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Joueur getJoueurParCarteChoisie(int vCarte){
        for (Joueur j : joueurs){
            if (vCarte==j.getValeurCarteChoisie()){
                return j;
            }
        }
        return null;
    }

    public void ajouterCarteChoisie(int valeur){
        valeursCartesChoisies.add(valeur);
    }

    public void clearCartesChoisies(){
        valeursCartesChoisies.clear();
    }

    public void trierCartesChoisies(){
        Collections.sort(valeursCartesChoisies);
    }

    public String toStringCartesChoisies(boolean vontEtrePosées){
        String tmp = new String();
        tmp = "Les cartes";
        for (int i = 0 ; i < valeursCartesChoisies.size() ; i++){
            if (i== valeursCartesChoisies.size()-1)
                tmp +=" et "+valeursCartesChoisies.get(i) +" (" +
                        getJoueurParCarteChoisie(valeursCartesChoisies.get(i)).toString() + ") " ;
            else if (i== valeursCartesChoisies.size()-2)
            tmp += " "+ valeursCartesChoisies.get(i) +" (" +
                    getJoueurParCarteChoisie(valeursCartesChoisies.get(i)).toString() + ") " ;
            else
                tmp += " "+valeursCartesChoisies.get(i) +" (" +
                        getJoueurParCarteChoisie(valeursCartesChoisies.get(i)).toString() + ")," ;
        }
        //a quoi sert cette boucle ???
        for(int vCartes : valeursCartesChoisies){

        }
        if (vontEtrePosées) return tmp+"vont être posées.";
        else return tmp+"ont été posées.";
    }

    public String toStringTetesDeBoeufs(boolean joueurARamassé){
        if (joueurARamassé) {
            String tmp = "";
            for(Joueur j : joueurs){
                tmp +=j.toStringRamassé();
            }
            return tmp;
        }
        else return "Aucun joueur ne ramasse de tête de boeufs.";
    }
}