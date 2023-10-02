public class Carte {
    private final int hauteur;
    private final Couleur couleur;

    public Carte(int hauteur, Couleur couleur) {
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "(" + hauteur + ", " + couleur + ")";
    }
}
