import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu(10,4);

        List<List<Integer>> cartes = jeu.getCartes();

        cartes.stream().collect(Collectors.toList()).forEach(System.out::println);

        List<Object> listeresult = jeu.recuperer_carte(2,cartes);
        System.out.println("----------------\n Apres la recuperation : (indice 2)");
        listeresult.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

}
