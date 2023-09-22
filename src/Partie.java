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

    public void demarrer(){
        // vider les cartes du joueur et dealer
        cartesJoueur.clear();
        cartesDealer.clear();
        // et les remplire
        cartesJoueur.add((List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0));
        cartesJoueur.add((List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0));
        cartesDealer.add((List<Integer>) jeu.tirer_une_carte(cartesDeJeu).get(0));

    }


}
