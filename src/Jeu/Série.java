package Jeu;

import java.util.ArrayList;
import java.util.Iterator;

/**  */
public class Série {
    private static final int MAXCONTENUSERIE = 5;
    private ArrayList<Carte> contenu;

    /**
     *
     */
    public Série(){
        this.contenu = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public boolean estPleine (){
        return (contenu.size() == MAXCONTENUSERIE);
   }

    /**
     *
     * @return
     */
   public boolean estVide(){
        if (contenu.size()==0) return true;
        else return false;
   }

    /**
     *
     */
   public void clear(){
        contenu.clear();
   }

    /**
     *
     * @param c
     */
    public void ajouter(Carte c){
        assert (this.estPleine());
        contenu.add(c);
   }

    /**
     *
     * @return
     */
   public int getNbTeteDeBoeufs(){
        int totalTeteDeBoeufs = 0;
        for(Carte c : contenu){
            totalTeteDeBoeufs+= c.getNbBoeuf();
        }
        return totalTeteDeBoeufs;
   }

    /**
     *
     * @return
     */
    public Carte getLastCarte(){
        return contenu.get(contenu.size()-1);
   }

    /**
     *
     * @return
     */
    public String toString() {
        String tmp = new String();
        int i = 0;
        while(i < contenu.size()){
            tmp += contenu.get(i).toString();
            if (++i != contenu.size())
                tmp += ",";
        }
        return tmp;
    }
}
