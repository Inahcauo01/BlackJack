import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu(7,4);

        List<List<Integer>> cartes = jeu.getCartes();

        cartes.stream().collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n apres");
        List<List<Integer>> listeresult = jeu.melanger_jeu_cartes_shuffle(cartes);
        listeresult.stream().collect(Collectors.toList()).forEach(System.out::print);

    }

}
