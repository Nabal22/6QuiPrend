import java.util.ArrayList;

public class S�rie {
    private static final int MAXCONTENUSERIE = 5;
    private ArrayList<Carte> contenu;

    public S�rie(){
        this.contenu = new ArrayList<>();
    }

   public boolean estPleine (){
        return (contenu.size() == 5);
   }

   public void ajouter(Carte c){
        assert (this.estPleine());
        contenu.add(c);
   }

    @Override
    public String toString() {
        String tmp = new String();
        for (Carte c : contenu){
            tmp += c.toString();
        }
        return tmp;
    }
}
