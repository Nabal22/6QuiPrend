package Jeu;

import java.util.ArrayList;

/** Type de données représentant la série */
public class Série {
    /** maximum de carte dans une série */
    private static final int MAXCONTENUSERIE = 5;

    /** contenu de la série (liste de cartes) */
    private ArrayList<Carte> contenu;

    /**
     * Constructeur de la série
     */
    public Série(){
        this.contenu = new ArrayList<Carte>();
    }

    /**
     * Indique si la série est pleine
     * @return vrai si la série est pleine
     */
    public boolean estPleine (){
        return (contenu.size() == MAXCONTENUSERIE);
   }

    /**
     * Indique si la série est vide
     * @return vrai si la série est vide
     */
   public boolean estVide(){
        if (contenu.size()==0) return true;
        else return false;
   }

    /**
     * clear le contenu de la série
     */
   public void clear(){
        contenu.clear();
   }

    /**
     * Ajoute la carte indiqué dans la série
     * @param c la carte à ajouter
     */
    public void ajouter(Carte c){
        assert (!this.estPleine());
        contenu.add(c);
   }

    /**
     * Indique le nombre de têtes de boeufs d'une série
     * @return le nombre de têtes de boeufs d'une série
     */
   public int getNbTeteDeBoeufs(){
        int totalTeteDeBoeufs = 0;
        for(Carte c : contenu){
            totalTeteDeBoeufs+= c.getNbBoeuf();
        }
        return totalTeteDeBoeufs;
   }

    /**
     * Indique la dernière carte de la série
     * @return la carte en dernière position de la série
     */
    public Carte getLastCarte(){
        return contenu.get(contenu.size()-1);
   }

    /**
     * Indique les cartes dans la série
     * @return la chaine de caractère des cartes de la série
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
