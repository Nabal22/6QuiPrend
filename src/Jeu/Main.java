package Jeu;

import Jeu.Carte;

import java.util.ArrayList;

public class Main {
    private ArrayList<Carte> contenu;

    public Main(){
        this.contenu = new ArrayList<>();
    }

    private void setCarteMain(int i, Carte carte) {
        this.contenu.set(i, carte);
    }

    /**
     *
     * @param valeurCarteChoisie
     * @return
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
     *
     * @param cartes
     */
    public void ajouterCarteDe(ArrayList<Carte> cartes){
        assert (getNbCartesMain()<10);
        contenu.add(cartes.get(cartes.size()-1));
        cartes.remove(cartes.size()-1);
    }

    /**
     *
     * @param v
     * @return
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
     *
     * @return
     */
    public int getNbCartesMain(){
        return contenu.size();
    }

    /**
     *
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
     *
     * @return
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


