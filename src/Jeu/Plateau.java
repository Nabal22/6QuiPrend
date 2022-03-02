package Jeu;

import java.util.ArrayList;

public class Plateau {
    private static final int NBSERIE = 4;

    private ArrayList<S�rie> s�ries;

    public Plateau(){
        this.s�ries = new ArrayList<>();
        for (int i = 0 ; i < NBSERIE ; i++) s�ries.add(new S�rie());
    }

    public int getNbTeteDeBoeufsFromS�rie(int idS�rie){
        for(int i = 0 ; i < s�ries.size() ; i ++ ){
            if (i == idS�rie) return s�ries.get(i).getNbTeteDeBoeufs();
        }
        return 0;
    }

    public void clearS�rie(int idS�rie){
        s�ries.get(idS�rie).clear();
    }

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

    public ArrayList<S�rie> getS�ries() {
        return s�ries;
    }

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
        return retour;
    }

    public String toString() {
        String tmp = new String();
        for (int i = 0 ; i <NBSERIE ; i++)
            tmp+= "- s�rie n� "+(i+1)+" :"+s�ries.get(i).toString()+"\n";
        return tmp;
    }
}
