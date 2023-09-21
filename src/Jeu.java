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
    public Jeu(int hauteur, int couleur){
        cartes = new ArrayList<>();
        for (int c=couleur; c<=4; c++){
            for (int h=hauteur; h<=13; h++){
                cartes.add(new Carte(h, c));
            }
            hauteur = 1;
        }
    }


public List<Carte> getCartes() {
        return cartes;
    }
}
