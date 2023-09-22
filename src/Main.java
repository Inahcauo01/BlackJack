import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu(12,4);
        Jeu jeu2 = new Jeu(1, 3);

        List<List<Integer>> cartes = jeu.getCartes();
        List<List<Integer>> cartes2 = jeu2.getCartes();
//        List<List<Integer>> cartesM = jeu.melanger_jeu_cartes(cartes);

        cartes.stream().collect(Collectors.toList()).forEach(System.out::println);
        cartes2.stream().collect(Collectors.toList()).forEach(System.out::print);
        System.out.println("\n defausser les cartes : \n");
        List<List<Integer>> defausser = jeu.defausser_cartes(cartes, cartes2);
        defausser.stream().collect(Collectors.toList()).forEach(System.out::print);
//        System.out.println("\n Piocher les cartes : \n");
//        List<List<List<Integer>>> listeresult = jeu.piocher_n_cartes(cartes);
//        List<List<Integer>> cartesAjouer = listeresult.get(0);
//        List<List<Integer>> cartesPioche = listeresult.get(1);
//        listeresult.stream().collect(Collectors.toList()).forEach(System.out::println);
//        System.out.println("\n_____________________________\n");
//        cartesAjouer.stream().collect(Collectors.toList()).forEach(System.out::print);
//        System.out.println("\n");
//        cartesPioche.stream().collect(Collectors.toList()).forEach(System.out::print);

    }

}
