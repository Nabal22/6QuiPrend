package Jeu;

import java.util.ArrayList;

/** Type de donn�es repr�sentant la s�rie */
public class S�rie {
    /** maximum de carte dans une s�rie */
    private static final int MAXCONTENUSERIE = 5;

    /** contenu de la s�rie (liste de cartes) */
    private ArrayList<Carte> contenu;

    /**
     * Constructeur de la s�rie
     */
    public S�rie(){
        this.contenu = new ArrayList<Carte>();
    }

    /**
     * Indique si la s�rie est pleine
     * @return vrai si la s�rie est pleine
     */
    public boolean estPleine (){
        return (contenu.size() == MAXCONTENUSERIE);
   }

    /**
     * Indique si la s�rie est vide
     * @return vrai si la s�rie est vide
     */
   public boolean estVide(){
        if (contenu.size()==0) return true;
        else return false;
   }

    /**
     * clear le contenu de la s�rie
     */
   public void clear(){
        contenu.clear();
   }

    /**
     * Ajoute la carte indiqu� dans la s�rie
     * @param c la carte � ajouter
     */
    public void ajouter(Carte c){
        assert (!this.estPleine());
        contenu.add(c);
   }

    /**
     * Indique le nombre de t�tes de boeufs d'une s�rie
     * @return le nombre de t�tes de boeufs d'une s�rie
     */
   public int getNbTeteDeBoeufs(){
        int totalTeteDeBoeufs = 0;
        for(Carte c : contenu){
            totalTeteDeBoeufs+= c.getNbBoeuf();
        }
        return totalTeteDeBoeufs;
   }

    /**
     * Indique la derni�re carte de la s�rie
     * @return la carte en derni�re position de la s�rie
     */
    public Carte getLastCarte(){
        return contenu.get(contenu.size()-1);
   }

    /**
     * Indique les cartes dans la s�rie
     * @return la chaine de caract�re des cartes de la s�rie
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
