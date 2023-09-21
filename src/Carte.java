public class Carte {
    private final int hauteur;
    private final int couleur;

    public Carte(int hauteur, int couleur) {
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "(" + hauteur + ", " + couleur + ")";
    }
}
