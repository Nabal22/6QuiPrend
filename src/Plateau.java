import java.util.ArrayList;

public class Plateau {
    private static final int NBSERIE = 4;

    private ArrayList<S�rie> s�ries;

    public Plateau(){
        this.s�ries = new ArrayList<>();
        for (int i = 0 ; i < NBSERIE ; i++) s�ries.add(new S�rie());
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
