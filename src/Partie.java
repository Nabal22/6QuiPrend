import java.util.ArrayList;

public class Partie {
    private static final int NBJOUEURMIN = 2;
    private static final int NBJOUEURMAX = 10;

    private Plateau plateau;
    private ArrayList<Joueur> joueurs;

    public Partie(ArrayList<Joueur> joueurs){
        assert (joueurs.size()<=10 && joueurs.size() >=2);
        this.plateau = new Plateau();
        this.joueurs = joueurs;
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

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
}