package Service;

import Domaine.Carte;
import Domaine.Couleur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jeu {
    private List<Carte> cartes;


    public Jeu() {
        this(new Carte(0, Couleur.values()[0]));
    }


    public Jeu(Carte carte){
        cartes = new ArrayList<>();
        int hauteur = carte.getHauteur();
        Couleur couleur = carte.getCouleur();
        Couleur[] values = Couleur.values();

        for (int c = couleur.ordinal(); c < values.length; c++){
            for (int h=hauteur+1; h<=13; h++){
                cartes.add(new Carte(h, values[c]));
            }
            hauteur = 1;
        }
    }

    public List<Carte> getCartes() { return cartes; }

    public List<Object> extraire_ieme_carte(int indice, List<Carte> liste){
        List<Object> resultatListe = new ArrayList<>();

        if (indice >0 && indice <= liste.size()){
            resultatListe.add(liste.get(indice-1));
            liste.remove(indice-1);
            resultatListe.add(liste);
        }

        return resultatListe;
    }

    public List<Object> tirer_une_carte(List<Carte> liste){
        List<Object> resultatListe;
        int nbRandom  = new Random().nextInt(liste.size())+1;
        resultatListe = extraire_ieme_carte(nbRandom, liste);
        return resultatListe;
    }


    public List<Carte> melanger_jeu_cartes(List<Carte> liste){
        List<Carte> resultatListe = new ArrayList<>();

        while(!liste.isEmpty()){
            List<Object> carteTiree = tirer_une_carte(liste);
            resultatListe.add(0, (Carte) carteTiree.get(0));
            liste = (List<Carte>) carteTiree.get(1);
        }

        return resultatListe;
    }

    public List<Carte> melanger_jeu_cartes_shuffle(List<Carte> liste){
        List<Carte> resultatListe = new ArrayList<>(liste);
        Collections.shuffle(resultatListe);
        return resultatListe;
    }

    public List<List<Carte>> piocher_n_cartes(List<Carte> liste){
        List<List<Carte>> resultatListe = new ArrayList<>();
        List<Carte> cartesAuDessus      = new ArrayList<>();
        List<Carte> cartesAuDesous      = new ArrayList<>();

        int randVal = new Random().nextInt(liste.size()-3)+4;

        for (int i=0; i< liste.size(); i++ ) {
            if (i < randVal) {
                cartesAuDessus.add(liste.get(i));
            }else {
                cartesAuDesous.add(liste.get(i));
            }
        }
        resultatListe.add(cartesAuDessus);
        resultatListe.add(cartesAuDesous);
        return resultatListe;
    }

    public List<Carte> defausser_cartes(List<Carte> cartesPioches, List<Carte> cartesDefausser){
        return  Stream.concat(cartesPioches.stream(), cartesDefausser.stream()).collect(Collectors.toList());
//        List<Carte> listeResultat = new ArrayList<>(cartesPioches);
//        listeResultat.addAll(cartesDefausser);
//        return listeResultat;
    }

}
