package Jeu;

import java.util.ArrayList;

/** Type de donnée représentant la main */
public class Main {
    /** le contenu de la main du joueur (liste de carte) */
    private ArrayList<Carte> contenu;

    public Main(){
        this.contenu = new ArrayList<>();
    }

    private void setCarteMain(int i, Carte carte) {
        this.contenu.set(i, carte);
    }

    /**
     * Indique si la valeur de la carte est dans la main du joueur
     * @param valeurCarteChoisie la valeur de la carte choisie
     * @return vrai si la main contient la valeur de la carte
     */
    public boolean contient(int valeurCarteChoisie){
        assert (this.contenu.size()!=0);
        for(Carte carte : this.contenu){
            if (valeurCarteChoisie==carte.getValeur()){
                return true;
            }
        }
        return false;
    }

    /**
     * Ajoute à la main la dernière carte de la liste de cartes
     * @param cartes la liste de cartes
     */
    public void ajouterCarteDe(ArrayList<Carte> cartes){
        assert (getNbCartesMain()<10);
        contenu.add(cartes.get(cartes.size()-1));
        cartes.remove(cartes.size()-1);
    }

    /**
     * Indique la carte dans la main à partir de sa valeur
     * @param v la valeur de la carte
     * @return la carte dans la main
     */
    public Carte getCarteMainByValeur(int v) {
        Carte c = null;
        for (int i = 0 ; i < getNbCartesMain() ; i++){
            if (v == contenu.get(i).getValeur()){
                c = contenu.get(i);
                contenu.remove(i);
            }
        }
        return c;
    }

    /**
     * Indique le nombre de cartes dans la main
     * @return le nombre de cartes dans la main
     */
    public int getNbCartesMain(){
        return contenu.size();
    }

    /**
     * Trie par ordre croissant les cartes de la main par valeur
     */
    public void trierMain(){
        for(int i = 1; i<getNbCartesMain(); i++){
            Carte tmp = contenu.get(i);
            int j = i-1;
            while(j >= 0 && contenu.get(j).getValeur() > tmp.getValeur()){

                setCarteMain(j+1,contenu.get(j));
                j--;
            }
            setCarteMain(j+1, tmp);
        }
    }

    /**
     * Indique les cartes dans la main
     * @return une chaine de caractères des cartes dans la main
     */
    public String toStringMain(){
        String tmp = new String();
        for (int i = 0 ; i < getNbCartesMain() ; i++){
            if (i==getNbCartesMain()-1)
                tmp += contenu.get(i).toString();
            else
                tmp += contenu.get(i).toString()+",";
        }
        return tmp;
    }
}


