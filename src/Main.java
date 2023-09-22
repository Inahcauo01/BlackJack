import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        Jeu jeu  = new Jeu(8,4);
//
//        List<List<Integer>> cartes = jeu.getCartes();
//
//        cartes.stream().collect(Collectors.toList()).forEach(System.out::print);
//        List<Object> result = new ArrayList<>();
//        result = jeu.tirer_une_carte(cartes);
//        System.out.println("\n----------------------------------");

        Partie partie = new Partie();
        System.out.println(partie.getCartesDeJeu());

    }

}
