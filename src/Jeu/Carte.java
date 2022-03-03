package Jeu;

public class Carte {
    private final int MIN = 1;
    private final int MAXVALEUR = 104;

    private int valeur;
    private int nbBoeuf=0;

    /**
     *
     * @param valeur
     */
    public Carte(int valeur) {
        assert (valeur >= MIN  && valeur <= MAXVALEUR );
        this.valeur=valeur;
        String valeurString = new String() ;
        valeurString = ""+valeur;

        switch (valeurString.charAt(valeurString.length()-1)){
            case '0' :
                this.nbBoeuf+=3;
                break;
            case '5' :
                this.nbBoeuf+=2;
                break;
            default:
                this.nbBoeuf+=1;
                break;
        }
        if (valeurString.length()==2 && (valeurString.charAt(0)==valeurString.charAt(1))) this.nbBoeuf+=5;
    }

    /**
     *
     * @return
     */
    public String toString()  {
        if (nbBoeuf <= 1) return " "+valeur;
        else
        return " "+valeur+" ("+nbBoeuf+")";
    }

    /**
     *
     * @return
     */
    public int getValeur() {
        return valeur;
    }

    /**
     *
     * @return
     */
    public int getNbBoeuf() {
        return nbBoeuf;
    }
}
