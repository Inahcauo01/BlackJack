import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();

        List<Carte> cartes = jeu.getCartes();

        cartes.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

}
