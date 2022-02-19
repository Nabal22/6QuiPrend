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
