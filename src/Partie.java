import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Partie {
    private Jeu jeu;
    private List<List<Integer>> cartesJoueur;
    private List<List<Integer>> cartesDealer;
    private List<List<Integer>> cartesDeJeu;

    public List<List<Integer>> getCartesDeJeu() {
        return cartesDeJeu;
    }

    public Partie() {
        jeu = new Jeu();
        cartesDeJeu  = jeu.getCartes();
        cartesJoueur = new ArrayList<>();
        cartesDealer = new ArrayList<>();
        cartesDeJeu.addAll(
                jeu.piocher_n_cartes(
                        jeu.melanger_jeu_cartes(cartesDeJeu)
                ).get(0)
        );
    }

    public void initialiser(){
        // vider les cartes du joueur et dealer
        cartesJoueur.clear();
        cartesDealer.clear();
        // et les remplire
        cartesJoueur.add((List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0));
        cartesJoueur.add((List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0));
        cartesDealer.add((List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0));
    }

    public void hit_joueur(){
        List<Integer> carte = (List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0);
        if (!carte.isEmpty()){
            cartesJoueur.add(carte);
        }
    }

    public void hit_delear(){
        List<Integer> carte = (List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0);
        if (!carte.isEmpty()){
            cartesDealer.add(carte);
        }
    }

    public int calcul_total(List<List<Integer>> carteCalcul){
        int total = 0;
        int nbAce = 0;
        for (List<Integer> carte: carteCalcul) {
            if(carte.get(0) > 10) {
                total += 10;
            } else if (carte.get(0)>1 && carte.get(0)<11){
                total += carte.get(0);
            } else if (carte.get(0) == 1){
                total += 1;
                nbAce++;
            }
        }
        if (nbAce>0 && total<=11)
            total +=10;
        return total;
    }

    public void demarrer(){
        initialiser();
        while (true){
            System.out.println("Cartes du dealer : "+cartesDealer);
            System.out.println("Cartes du joueur : "+cartesJoueur);
            int total = calcul_total(cartesJoueur);
            System.out.println("total : "+total);
            break;
        }
    }

}
