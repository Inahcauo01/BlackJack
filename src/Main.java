import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();

        List<List<Integer>> cartes = jeu.getCartes();

        cartes.stream().collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n apres");
        List<List<List<Integer>>> listeresult = jeu.piocher_n_cartes(cartes);
        List<List<Integer>> carteAjouer = listeresult.get(0);
        List<List<Integer>> carteBanque = listeresult.get(1);
        listeresult.stream().collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n_____________________________\n");
        carteAjouer.stream().collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n");
        carteBanque.stream().collect(Collectors.toList()).forEach(System.out::print);

    }

}
