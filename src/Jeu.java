import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            for (int h=hauteur+1; h<=13; h++){
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
    public List<List<Integer>> getCartes() { return cartes; }


    public List<Object> extraire_ieme_carte(int indice, List<List<Integer>> liste){
        List<Object> resultatListe = new ArrayList<>();
        if (indice >0 && indice <= liste.size()){
            resultatListe.add(liste.get(indice-1));
            liste.remove(indice-1);
            resultatListe.add(liste);
        }
        return resultatListe;
    }

    public List<Object> tirer_une_carte(List<List<Integer>> liste){
        List<Object> resultatListe = new ArrayList<>();
        int nbRandom = new Random().nextInt(liste.size())+1;
        resultatListe = extraire_ieme_carte(nbRandom, liste);
        return resultatListe;
    }


    // Melanger les cartes
    public List<List<Integer>> melanger_jeu_cartes(List<List<Integer>> liste){
        List<List<Integer>> resultatListe = new ArrayList<>();
        while(!liste.isEmpty()){
            List<Object> carteTiree = tirer_une_carte(liste);
            resultatListe.add((List<Integer>) carteTiree.get(0));
            liste = (List<List<Integer>>) carteTiree.get(1);
        }
        return resultatListe;
    }

    public List<List<Integer>> melanger_jeu_cartes_shuffle(List<List<Integer>> liste){
        List<List<Integer>> resultatListe = new ArrayList<>(liste);
        Collections.shuffle(resultatListe);
        return resultatListe;
    }

    public List<List<List<Integer>>> piocher_n_cartes(List<List<Integer>> liste){
        List<List<List<Integer>>> resultatListe = new ArrayList<>();
        List<List<Integer>> cartesAuDessus      = new ArrayList<>();
        List<List<Integer>> cartesAuDesous      = new ArrayList<>();

        int randVal = new Random().nextInt(liste.size()-3)+4;

        for (int i=0; i< liste.size(); i++ ){
            if (i < randVal){
                cartesAuDessus.add(liste.get(i));
            }else {
                cartesAuDesous.add(liste.get(i));
            }
        }
        resultatListe.add(cartesAuDessus);
        resultatListe.add(cartesAuDesous);
        return resultatListe;
    }

    public List<List<Integer>> defausser_cartes(List<List<Integer>> cartesPioches, List<List<Integer>> cartesDefausser){
        return  Stream.concat(cartesPioches.stream(), cartesDefausser.stream()).collect(Collectors.toList());
//        List<List<Integer>> listeResultat = new ArrayList<>(cartesPioches);
//        listeResultat.addAll(cartesDefausser);
//        return listeResultat;
    }

}
