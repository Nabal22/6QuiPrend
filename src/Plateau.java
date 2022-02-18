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

    @Override
    public String toString() {
        String tmp = new String();
        int idS�rie = 1;
        for ( S�rie s : s�ries){
            tmp+= "- s�rie n� "+idS�rie+" :"+s.toString();
            idS�rie++;
        }
        return tmp;
    }
}
