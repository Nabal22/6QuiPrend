package Jeu;

import java.util.ArrayList;

public class Plateau {
    private static final int NBSERIE = 4;

    private ArrayList<S�rie> s�ries;

    public Plateau(){
        this.s�ries = new ArrayList<>();
        for (int i = 0 ; i < NBSERIE ; i++) s�ries.add(new S�rie());
    }

    public void placer(Carte carte){
        int tmp=104,idS�rie = -1,i;
        for (i = 0; i < NBSERIE ; i++){
            if ((carte.getValeur() - s�ries.get(i).getLastCarte().getValeur()) < tmp
            && carte.getValeur() > s�ries.get(i).getLastCarte().getValeur()
            && !s�ries.get(i).estPleine() )
            {
                tmp = carte.getValeur() - s�ries.get(i).getLastCarte().getValeur();
                idS�rie = i;
            }
        }
        s�ries.get(idS�rie).ajouter(carte);
    }

    public ArrayList<S�rie> getS�ries() {
        return s�ries;
    }

    public boolean estPosable(int i){
        for(S�rie s : s�ries){
            if (s.getLastCarte().getValeur() < i) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String tmp = new String();
        for (int i = 0 ; i <NBSERIE ; i++)
            tmp+= "- s�rie n� "+(i+1)+" :"+s�ries.get(i).toString()+"\n";
        return tmp;
    }
}
