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
        assert (getNbCartesMain()<10);
        main.add(cartes.get(cartes.size()-1));
        cartes.remove(cartes.size()-1);
    }

    // récupère une carte en fonction de sa valeur
    public Carte getCarteMainByValeur(int v) {
        Carte c = null;
        for (int i = 0 ; i < getNbCartesMain() ; i++){
            if (v == main.get(i).getValeur()){
                c = main.get(i);
                main.remove(i);
            }
        }
        return c;
    }

    public Carte getCarteMainById(int i) {
        return main.get(i);
    }

    public int getNbCartesMain(){
        return main.size();
    }

    public void trierMain(){
        for(int i = 1; i<getNbCartesMain(); i++){
            Carte tmp = getCarteMainById(i);
            int j = i-1;
            while(j >= 0 && getCarteMainById(j).getValeur() > tmp.getValeur()){
                setCarteMain(j+1,getCarteMainById(j));
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
        for (int i = 0 ; i < getNbCartesMain() ; i++){
            if (i==getNbCartesMain()-1)
                tmp += getCarteMainById(i).toString();
            else
                tmp += getCarteMainById(i).toString()+",";
        }
        return tmp;
    }
}
