import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jeu {
    //private List<Carte> cartes;     //objet carte
    private List<List<Integer>> cartes;



    // Construction de toutes les 52 cartes
    public Jeu() {
        cartes = new ArrayList<>();
        for (int c=1; c<=4; c++){
            for (int h=1; h<=13; h++){
                //cartes.add(new Carte(h, c));  //objet carte
                List<Integer> carte = new ArrayList<>();
                carte.add(h);
                carte.add(c);
                cartes.add(carte);

            }
        }
    }

    // Construction des cartes à partir d'une carte donnée
    public Jeu(int hauteur, int couleur){
        cartes = new ArrayList<>();
        for (int c=couleur; c<=4; c++){
            for (int h=hauteur; h<=13; h++){
                //cartes.add(new Carte(h, c));  //objet carte
                List<Integer> carte = new ArrayList<>();
                carte.add(h);
                carte.add(c);
                cartes.add(carte);
            }
            hauteur = 1;
        }
    }

    //public List<Carte> getCartes() {  //objet carte
    public List<List<Integer>> getCartes() {
        return cartes;
    }

    public List<Object> recuperer_carte(int indice, List<List<Integer>> liste){
        List<Object> resultatListe = new ArrayList<>();

        if (indice >0 && indice <= liste.size()){
            resultatListe.add(liste.get(indice-1));
            liste.remove(indice-1);
            resultatListe.add(liste);
        }

        return resultatListe;
    }
}
