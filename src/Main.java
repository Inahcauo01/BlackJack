import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Jeu jeu     = new Jeu();
        Jeu jeu2     = new Jeu(new Carte(12,3));

        List<Carte> cartes = jeu.getCartes();
        List<Carte> cartes2 = jeu2.getCartes();

        cartes2.stream().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("___________");
        cartes.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

}
