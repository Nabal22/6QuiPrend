import java.util.ArrayList;
import java.util.Collections;

public class Partie {
    private static final int NBJOUEURMIN = 2;
    private static final int NBJOUEURMAX = 10;

    private Plateau plateau;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Integer> valeursCartesChoisies;

    public Partie(ArrayList<Joueur> joueurs){
        assert (joueurs.size()<=10 && joueurs.size() >=2);
        this.plateau = new Plateau();
        this.joueurs = joueurs;
        this.valeursCartesChoisies = new ArrayList<>();
        System.out.print("Les "+joueurs.size()+" joueurs sont");
        for (int i = 0 ; i < joueurs.size(); i++)
        {
            if (i == joueurs.size()-1)
                System.out.println(" "+ joueurs.get(i).getNom()+". Merci de jouer à 6 qui prend !");
            else if (i == joueurs.size()-2) System.out.print(" "+ joueurs.get(i).getNom()+" et " );
            else
                System.out.print(" "+ joueurs.get(i).getNom()+"," );
        }
    }

    public boolean estFinie(){
        for ( Joueur j : joueurs){
            if (j.getNbCartesMain()!=0) return false;
        }
        return true;
    }

    public Plateau getPlateau(){
        return plateau;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void ajouterCarteChoisie(int valeur){
        valeursCartesChoisies.add(valeur);
    }

    public void clearCartesChoisies(){
        valeursCartesChoisies.clear();
    }

    public void trierCartesChoisies(){
        Collections.sort(valeursCartesChoisies);
        for (int i : valeursCartesChoisies){
            System.out.println(i);
        }
    }

    public String toStringCartesChoisies(){
        String tmp = new String();
        tmp = "Les cartes";
        for (int i = 0 ; i < valeursCartesChoisies.size() ; i++){
            if (i== valeursCartesChoisies.size()-1)
                tmp +=" et "+valeursCartesChoisies.get(i) +" (" +
                        getJoueurCarteChoisie(valeursCartesChoisies.get(i)).getNom() + ") " ;
            else if (i== valeursCartesChoisies.size()-1)
            tmp += " "+ valeursCartesChoisies.get(i) +" (" +
                    getJoueurCarteChoisie(valeursCartesChoisies.get(i)).getNom() + ") " ;
            else
                tmp += " "+valeursCartesChoisies.get(i) +" (" +
                        getJoueurCarteChoisie(valeursCartesChoisies.get(i)).getNom() + ")," ;
        }
        for(int vCartes : valeursCartesChoisies){

        }
        return tmp+"ont été posées.";
    }
    public Joueur getJoueurCarteChoisie(int vCarte){
        for (Joueur j : joueurs){
            if (vCarte==j.getCarteChoisie().getValeur()){
                return j;
            }
        }
        return null;
    }
}