import java.util.ArrayList;

public class Main {
    private ArrayList<Carte> main;

    public Main(){
        this.main = new ArrayList<>();
    }

    public ArrayList<Carte> getMain(){
        return main;
    }

    public void piocher(ArrayList<Carte> cartes){
        assert (taille()<10);
        main.add(cartes.get(cartes.size()-1));
        cartes.remove(cartes.size()-1);
    }

    public Carte getCarteMain(int i) {
        return this.main.get(i);
    }

    public int getNbCartesMain() {
        return this.taille();
    }

    public int taille(){
        return main.size();
    }

    public void trierMain(){
        for(int i = 1; i<taille(); i++){
            Carte tmp = getCarteMain(i);
            int j = i-1;
            while(j >= 0 && getCarteMain(j).getValeur() > tmp.getValeur()){
                setCarteMain(j+1,getCarteMain(j));
                j--;
            }
            setCarteMain(j+1, tmp);
        }
    }

    private void setCarteMain(int i, Carte carte) {
        this.main.set(i, carte);
    }


    public String toStringMain(){
        String tmp = new String();
        for (int i = 0 ; i < taille() ; i++){
            if (i==taille()-1)
                tmp += getCarteMain(i).toString();
            else
                tmp += getCarteMain(i).toString()+",";
        }
        return tmp;
    }
}
