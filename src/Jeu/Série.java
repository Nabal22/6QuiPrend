package Jeu;

import java.util.ArrayList;

public class Série {
    private static final int MAXCONTENUSERIE = 5;
    private ArrayList<Carte> contenu;

    public Série(){
        this.contenu = new ArrayList<>();
    }

    public boolean estPleine (){
        return (contenu.size() == MAXCONTENUSERIE);
   }
   public boolean estVide(){
        if (contenu.size()==0) return true;
        else return false;
   }

   public void clear(){
        contenu.clear();
   }

    public void ajouter(Carte c){
        assert (this.estPleine());
        contenu.add(c);
   }

   public int getNbTeteDeBoeufs(){
        int totalTeteDeBoeufs = 0;
        for(Carte c : contenu){
            totalTeteDeBoeufs+= c.getNbBoeuf();
        }
        return totalTeteDeBoeufs;
   }

    public Carte getLastCarte(){
        return contenu.get(contenu.size()-1);
   }

    public String toString() {
        String tmp = new String();
        for (Carte c : contenu){
            tmp += c.toString();
        }
        return tmp;
    }
}
