package Domaine;

public class Carte {
    private final int hauteur;
    private final Couleur couleur;

    public Carte(int hauteur, Couleur couleur) {
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "(" + hauteur + ", " + couleur + ")";
    }
}
