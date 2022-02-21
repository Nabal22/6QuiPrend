import java.util.ArrayList;

public class Série {
    private static final int MAXCONTENUSERIE = 5;
    private ArrayList<Carte> contenu;

    public Série(){
        this.contenu = new ArrayList<>();
    }

   public boolean estPleine (){
        return (contenu.size() == 5);
   }

   public void ajouter(Carte c){
        assert (this.estPleine());
        contenu.add(c);
   }

   public Carte getLastCarte(){
        return contenu.get(contenu.size()-1);
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
