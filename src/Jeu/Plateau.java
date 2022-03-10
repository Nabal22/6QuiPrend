package Jeu;

import java.util.ArrayList;

/** Type de donn�es repr�sentant le plateau de jeu */
public class Plateau {
    /** nombre de s�rie maximale d'un plateau */
    private static final int NBSERIE = 4;

    /** liste des s�ries du plateau */
    private ArrayList<S�rie> s�ries;

    /**
     * Constructeur du Plateau de jeu
     */
    public Plateau(){
        this.s�ries = new ArrayList<>();
        for (int i = 0 ; i < NBSERIE ; i++) s�ries.add(new S�rie());
    }

    /**
     * Indique le nombre de t�tes de boeufs dans une s�rie
     * @param idS�rie index de la s�rie
     * @return nombre de t�tes de boeufs dans la s�rie
     */
    public int getNbTeteDeBoeufsFromS�rie(int idS�rie){
        for(int i = 0 ; i < s�ries.size() ; i ++ ){
            if (i == idS�rie) return s�ries.get(i).getNbTeteDeBoeufs();
        }
        return 0;
    }

    /**
     * Clear la s�rie indiqu�e par l'index
     * @param idS�rie index de la s�rie
     */
    public void clearS�rie(int idS�rie){
        s�ries.get(idS�rie).clear();
    }

    /**
     * Place la carte dans la s�rie la plus adapt�e
     * @param carte carte voulant �tre plac�e
     */
    public void placer(Carte carte){
        int tmp=104,idS�rie = -1,i;
        for (i = 0; i < NBSERIE ; i++){
            if (s�ries.get(i).estVide()){
                idS�rie = i;
                break;
            }
            else{
                if ((carte.getValeur() - s�ries.get(i).getLastCarte().getValeur()) < tmp
                && carte.getValeur() > s�ries.get(i).getLastCarte().getValeur()
                && !s�ries.get(i).estPleine())
                {
                    tmp = carte.getValeur() - s�ries.get(i).getLastCarte().getValeur();
                    idS�rie = i;
                }
            }
        }
        s�ries.get(idS�rie).ajouter(carte);
    }

    /**
     * Indique la liste de s�ries
     * @return s�ries la liste de s�ries
     */
    public ArrayList<S�rie> getS�ries() {
        return s�ries;
    }

    /**
     * Indique si la carte de valeur i est posable dans l'une des s�ries
     * @param i la valeur de la carte � poser
     * @return vrai si la carte est posable
     */
    public boolean estPosable(int i){
        int difference = i - s�ries.get(0).getLastCarte().getValeur();
        boolean retour = true;
        for(S�rie s : s�ries){
            if((difference<0 && difference < i-s.getLastCarte().getValeur()) || (i-s.getLastCarte().getValeur())> 0 && i-s.getLastCarte().getValeur() < difference) {
                difference = i - s.getLastCarte().getValeur();
                retour = true;
            }
            if(s.estPleine() || difference < 0) retour = false;
        }
        return retour;}

    /**
     * Indique les s�ries et leur contenu (carte)
     * @return la chaine de caract�re des s�ries
     */
    public String toString() {
        String tmp = new String();
        for (int i = 0 ; i <NBSERIE ; i++)
            tmp+= "- s�rie n� "+(i+1)+" :"+s�ries.get(i).toString()+"\n";
        return tmp;
    }
}
