package Jeu;

import java.util.ArrayList;

/** Type de données représentant le plateau de jeu */
public class Plateau {
    /** nombre de série maximale d'un plateau */
    private static final int NBSERIE = 4;

    /** liste des séries du plateau */
    private ArrayList<Série> séries;

    /**
     * Constructeur du Plateau de jeu
     */
    public Plateau(){
        this.séries = new ArrayList<>();
        for (int i = 0 ; i < NBSERIE ; i++) séries.add(new Série());
    }

    /**
     * Indique le nombre de têtes de boeufs dans une série
     * @param idSérie index de la série
     * @return nombre de têtes de boeufs dans la série
     */
    public int getNbTeteDeBoeufsFromSérie(int idSérie){
        for(int i = 0 ; i < séries.size() ; i ++ ){
            if (i == idSérie) return séries.get(i).getNbTeteDeBoeufs();
        }
        return 0;
    }

    /**
     * Clear la série indiquée par l'index
     * @param idSérie index de la série
     */
    public void clearSérie(int idSérie){
        séries.get(idSérie).clear();
    }

    /**
     * Place la carte dans la série la plus adaptée
     * @param carte carte voulant être placée
     */
    public void placer(Carte carte){
        int tmp=104,idSérie = -1,i;
        for (i = 0; i < NBSERIE ; i++){
            if (séries.get(i).estVide()){
                idSérie = i;
                break;
            }
            else{
                if ((carte.getValeur() - séries.get(i).getLastCarte().getValeur()) < tmp
                && carte.getValeur() > séries.get(i).getLastCarte().getValeur()
                && !séries.get(i).estPleine())
                {
                    tmp = carte.getValeur() - séries.get(i).getLastCarte().getValeur();
                    idSérie = i;
                }
            }
        }
        séries.get(idSérie).ajouter(carte);
    }

    /**
     * Indique la liste de séries
     * @return séries la liste de séries
     */
    public ArrayList<Série> getSéries() {
        return séries;
    }

    /**
     * Indique si la carte de valeur i est posable dans l'une des séries
     * @param i la valeur de la carte à poser
     * @return vrai si la carte est posable
     */
    public boolean estPosable(int i){
        int difference = i - séries.get(0).getLastCarte().getValeur();
        boolean retour = true;
        for(Série s : séries){
            if((difference<0 && difference < i-s.getLastCarte().getValeur()) || (i-s.getLastCarte().getValeur())> 0 && i-s.getLastCarte().getValeur() < difference) {
                difference = i - s.getLastCarte().getValeur();
                retour = true;
            }
            if(s.estPleine() || difference < 0) retour = false;
        }
        return retour;}

    /**
     * Indique les séries et leur contenu (carte)
     * @return la chaine de caractère des séries
     */
    public String toString() {
        String tmp = new String();
        for (int i = 0 ; i <NBSERIE ; i++)
            tmp+= "- série n° "+(i+1)+" :"+séries.get(i).toString()+"\n";
        return tmp;
    }
}
