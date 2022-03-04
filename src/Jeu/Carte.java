package Jeu;

/** Type de données représentant une carte */
public class Carte {
    /** valeur minimale d'une carte */
    private final int MIN = 1;
    /** valeur maximale d'une carte */
    private final int MAXVALEUR = 104;

    /** valeur d'une carte */
    private int valeur;
    /** nombre de têtes de boeufs d'une carte */
    private int nbBoeuf=0;

    /**
     * Constructeur d'une carte
     * @param valeur valeur de la carte
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
     * Indique la valeur et le nombre de têtes de boeufs d'une carte
     * @return la valeur et le nombre de têtes de boeufs d'une carte
     */
    public String toString()  {
        if (nbBoeuf <= 1) return " "+valeur;
        else
        return " "+valeur+" ("+nbBoeuf+")";
    }

    /**
     * Indique la valeur d'une carte
     * @return la valeur de la carte
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Indique le nombre de têtes de boeufs d'une carte
     * @return le nombre de têtes de boeufs d'une carte
     */
    public int getNbBoeuf() {
        return nbBoeuf;
    }
}
