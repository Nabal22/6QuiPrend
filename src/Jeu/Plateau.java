package Jeu;

import java.util.ArrayList;

public class Plateau {
    private static final int NBSERIE = 4;

    private ArrayList<Série> séries;

    public Plateau(){
        this.séries = new ArrayList<>();
        for (int i = 0 ; i < NBSERIE ; i++) séries.add(new Série());
    }

    public int getNbTeteDeBoeufsFromSérie(int idSérie){
        for(int i = 0 ; i < séries.size() ; i ++ ){
            if (i == idSérie) return séries.get(i).getNbTeteDeBoeufs();
        }
        return 0;
    }

    public void clearSérie(int idSérie){
        séries.get(idSérie).clear();
    }

    public void placer(Carte carte){
        int tmp=104,idSérie = -1,i;
        for (i = 0; i < NBSERIE ; i++){
            if (séries.get(i).estVide()){
                idSérie = i;
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

    public ArrayList<Série> getSéries() {
        return séries;
    }

    public boolean estPosable(int i){
        for(Série s : séries){
            if (s.getLastCarte().getValeur() < i) return true;
        }
        return false;
    }

    public String toString() {
        String tmp = new String();
        for (int i = 0 ; i <NBSERIE ; i++)
            tmp+= "- série n° "+(i+1)+" :"+séries.get(i).toString()+"\n";
        return tmp;
    }
}
