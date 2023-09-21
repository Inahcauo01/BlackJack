import java.util.ArrayList;
import java.util.List;

public class Jeu {
    private List<Carte> cartes;

    // Construction de toutes les 52 cartes
    public Jeu() {
        cartes = new ArrayList<>();
        for (int c=1; c<=4; c++){
            for (int h=1; h<=13; h++){
                cartes.add(new Carte(h, c));
            }
        }
    }

    // Construction des cartes à partir d'une carte donnée
    public Jeu(Carte carte){
        cartes = new ArrayList<>();
        for (int c=carte.getCouleur(); c<=4; c++){
            for (int h=1; h<=13; h++){
                cartes.add(new Carte(h, c));
            }
        }
    }

    public List<Carte> getCartes() {
        return cartes;
    }
}
