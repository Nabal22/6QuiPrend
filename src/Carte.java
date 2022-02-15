public class Carte {
    private final int MIN = 1;
    private final int MAXVALEUR = 104;

    private int valeur;
    private int nbBoeuf=0;

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
                break;
        }
        if (valeurString.length()==2 && (valeurString.charAt(0)==valeurString.charAt(1))) this.nbBoeuf+=5;
    }

    public String toString() {
        return "Carte{" +
                "valeur=" + valeur +
                ", nbBoeuf=" + nbBoeuf +
                '}';
    }

    public int getValeur() {
        return valeur;
    }

    public int getNbBoeuf() {
        return nbBoeuf;
    }
}
