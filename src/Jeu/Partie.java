package Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Mettre des privates dans partie pour les m�thodes qui sont utilis�es que dans JouerTour

/** Type de donn�e repr�sentant la partie */
public class Partie {
    /** Nombre de joueurs minimum pour une partie */
    private static final int NBJOUEURMIN = 2;
    /** Nombre de joueurs maximum pour une partie */
    private static final int NBJOUEURMAX = 10;

    /** Plateau de jeu pour la partie */
    private Plateau plateau;
    /** Liste de joueurs de la partie */
    private ArrayList<Joueur> joueurs;
    /** Liste de la valeur des cartes choisies lors de la partie */
    private ArrayList<Integer> valeursCartesChoisies;


    /**
     * Constructeur de la Partie
     * @param joueurs la liste de joueurs
     */
    public Partie(ArrayList<Joueur> joueurs){
        assert (joueurs.size()<=10 && joueurs.size() >=2);
        this.plateau = new Plateau();
        this.joueurs = joueurs;
        this.valeursCartesChoisies = new ArrayList<>();
    }

    /**
     * Vide les t�tes de boeufs de tous les joueurs
     */
    private void clearTetesDeBoeufsJoueurs(){
        for (Joueur j : joueurs) j.clearTetesDeBoeufs();
    }

    /**
     * Indique si la partie est finie
     * @return vrai si la partie est finie
     */
    public boolean estFinie(){
        for ( Joueur j : joueurs){
            if (j.nbCartesDansMain()!=0) return false;
        }
        return true;
    }

    /**
     * R�alise un tour dans la partie
     * @param sc l'entr�e du joueur
     */
    public void jouerTour(Scanner sc){
        boolean joueurARamass� = false;
        this.clearTetesDeBoeufsJoueurs();
        for (int i : valeursCartesChoisies){
            if (plateau.estPosable(i)) {
                this.getJoueurParCarteChoisie(i).poser(plateau);
            }
            else{
                int difference = i - plateau.getS�ries().get(0).getLastCarte().getValeur();
                int s�rieOuPlacer = 0;
                boolean posable = false;
                boolean posablePlein = false;
                for (int compt = 0; compt < plateau.getS�ries().size(); compt++) {
                    if ((difference < 0 && difference < i - plateau.getS�ries().get(compt).getLastCarte().getValeur())
                            || (plateau.getS�ries().get(compt).getLastCarte().getValeur() > 0 && plateau.getS�ries().get(compt).getLastCarte().getValeur() < difference)) {

                        difference = i - plateau.getS�ries().get(compt).getLastCarte().getValeur();
                        s�rieOuPlacer = compt;
                        posable = true;
                    }
                    if(plateau.getS�ries().get(compt).estPleine()){
                        posablePlein = true;
                        posable = false;
                    }
                    if(difference < 0){
                        posable = false;
                        posablePlein = false;
                    }
                }
                if (posable) {
                    joueurARamass� = true;
                    Joueur j = this.getJoueurParCarteChoisie(i);
                    j.ajouterTetesDeBoeufs(plateau.getNbTeteDeBoeufsFromS�rie(s�rieOuPlacer));
                    plateau.clearS�rie(s�rieOuPlacer);
                    j.poser(plateau);
                }
                else if(posablePlein) {
                    joueurARamass� = true;
                    Joueur j = this.getJoueurParCarteChoisie(i);
                    j.poser(plateau);
                }
                else {
                    joueurARamass� = true;
                    Joueur j = this.getJoueurParCarteChoisie(i);
                    System.out.println(this.toStringCartesChoisies(true));
                    System.out.println("Pour poser la carte " + i + ", " + j.toString() +
                            " doit choisir la s�rie qu'il va ramasser.");
                    System.out.print(this.plateau.toString());
                    int choix = 5;
                    System.out.print("Saisissez votre choix : ");
                    choix = sc.nextInt();
                    while (choix > 4 || choix < 1){
                        System.out.print("Ce n'est pas une s�rie valide, saisissez votre choix : ");
                        if (sc.hasNextInt()){
                            choix = sc.nextInt();
                        }
                    }
                    --choix;// modifier pour prendre en compte les erreurs

                    j.ajouterTetesDeBoeufs(plateau.getNbTeteDeBoeufsFromS�rie(choix));
                    plateau.clearS�rie(choix);
                    j.poser(plateau);
                }
            }
        }
        System.out.println(this.toStringCartesChoisies(false));
        System.out.print(this.plateau.toString());
        System.out.print(this.toStringTetesDeBoeufs(joueurARamass�));
    }

    /**
     * Indique le score final de la partie
     * @return tmp la chaine de caract�re du score de la partie
     */
    public String toStringFinal(){
        String tmp ="** Score final\n";
        boolean permut = true;
        int passage = 0;
        Joueur jTmp;
        while(permut == true){
            permut = false;
            passage++;
            for(int i = 0; i<joueurs.size()-passage;i++){
                if(joueurs.get(i).getNbTetesDeBoeufsRamass�es() > joueurs.get(i+1).getNbTetesDeBoeufsRamass�es()){
                    permut=true;
                    jTmp = joueurs.get(i);
                    joueurs.set(i,joueurs.get(i+1));
                    joueurs.set(i+1,jTmp);
                }
            }
        }
        for (Joueur j : joueurs){
            tmp += j.toStringFinal();
        }
        return tmp;
    }

    /**
     * Indique l'initialisaton de la partie
     * @return tmp une chaine de caract�re
     */
    public String toStringInit(){
        String tmp = new String();
        tmp+="Les "+joueurs.size()+" joueurs sont";
        for (int i = 0 ; i < joueurs.size(); i++)
        {
            if (i == joueurs.size()-1)
                tmp+=" "+ joueurs.get(i).toString()+". Merci de jouer � 6 qui prend !";
            else if (i == joueurs.size()-2) tmp+=" "+ joueurs.get(i).toString()+" et ";
            else
                tmp+=" "+ joueurs.get(i).toString()+",";
        }
        return tmp;
    }

    /**
     * Indique le plateau de jeu de la partie
     * @return le plateau de jeu
     */
    public Plateau getPlateau(){
        return plateau;
    }

    /**
     * Indique la liste de joueurs
     * @return les joueurs de la partie
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    /**
     * Indique le joueur � partir de la valeur de la carte qu'il a choisi
     * @param vCarte la valeur de la carte choisie
     * @return le joueur associ� � la valeur de la carte
     */
    public Joueur getJoueurParCarteChoisie(int vCarte){
        for (Joueur j : joueurs){
            if (vCarte==j.getValeurCarteChoisie()){
                return j;
            }
        }
        return null;
    }

    /**
     * Ajoute la valeur de la carte choisie � la liste des cartes choisies
     * @param valeur
     */
    public void ajouterCarteChoisie(int valeur){
        valeursCartesChoisies.add(valeur);
    }

    /**
     * Supprime toutes les cartes choisies
     */
    public void clearCartesChoisies(){
        valeursCartesChoisies.clear();
    }

    /**
     * Trie par ordre croissant les valeurs des cartes choisies
     */
    public void trierCartesChoisies(){
        Collections.sort(valeursCartesChoisies);
    }

    /**
     * Indique les cartes choisies qui vont ou ont �t� pos�es
     * @param vontEtrePos�es
     * @return
     */
    public String toStringCartesChoisies(boolean vontEtrePos�es){
        String tmp = new String();
        tmp = "Les cartes";
        for (int i = 0 ; i < valeursCartesChoisies.size() ; i++){
            if (i== valeursCartesChoisies.size()-1)
                tmp +=" et "+valeursCartesChoisies.get(i) +" (" +
                        getJoueurParCarteChoisie(valeursCartesChoisies.get(i)).toString() + ") " ;
            else if (i== valeursCartesChoisies.size()-2)
            tmp += " "+ valeursCartesChoisies.get(i) +" (" +
                    getJoueurParCarteChoisie(valeursCartesChoisies.get(i)).toString() + ")" ;
            else
                tmp += " "+valeursCartesChoisies.get(i) +" (" +
                        getJoueurParCarteChoisie(valeursCartesChoisies.get(i)).toString() + ")," ;
        }
        //a quoi sert cette boucle ???
        for(int vCartes : valeursCartesChoisies){

        }
        if (vontEtrePos�es) return tmp+"vont �tre pos�es.";
        else return tmp+"ont �t� pos�es.";
    }

    /**
     * Indique les t�tes de boeufs ramass�es
     * @param joueurARamass�
     * @return
     */
    public String toStringTetesDeBoeufs(boolean joueurARamass�){
        if (joueurARamass�) {
            String tmp = "";
            for(Joueur j : joueurs){
                tmp +=j.toStringRamass�();
            }
            return tmp;
        }
        else return "Aucun joueur ne ramasse de t�te de boeufs.\n";
    }
}