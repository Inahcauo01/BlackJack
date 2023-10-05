package Service;

import Domaine.Carte;
import Service.Jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partie {
    private Jeu jeu;
    private List<Carte> cartesJoueur;
    private List<Carte> cartesDealer;
    private List<Carte> cartesDeJeu;
    private int montantTotal;
    private int mise;


    public Partie() {
        jeu = new Jeu();
        cartesDeJeu  = jeu.getCartes();
        cartesJoueur = new ArrayList<>();
        cartesDealer = new ArrayList<>();
        cartesDeJeu.addAll(
                jeu.piocher_n_cartes(
                        jeu.melanger_jeu_cartes(cartesDeJeu)
                ).get(0)
        );

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Entrer votre montatnt total ");
            try {
                montantTotal = scanner.nextInt();
                break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Veuiller entrer une correcte valeur !");
            }
        } while (true);
        mise = 0;
    }

    public void initialiser(){
        // vider les cartes du joueur et dealer
        cartesJoueur.clear();
        cartesDealer.clear();
        // et les remplire
        cartesJoueur.add((Carte) jeu.tirer_une_carte(cartesDeJeu).get(0));
        cartesJoueur.add((Carte) jeu.tirer_une_carte(cartesDeJeu).get(0));
        cartesDealer.add((Carte) jeu.tirer_une_carte(cartesDeJeu).get(0));
        // choisir votre mise
        choisirMise();
    }

    public void hit_carte(List<Carte> liste){
        if (cartesDeJeu.isEmpty()){ //refaire la partie avec meme score
            System.out.println("Il faut refausser les cartes a nouveau");
            return;
        }
        Carte carte = (Carte) jeu.tirer_une_carte(cartesDeJeu).get(0);
        if (carte != null){
            liste.add(carte);
        }
    }

    public int calcul_total(List<Carte> carteCalcul){
        int total = 0;
        int nbAce = 0;

        for (Carte carte: carteCalcul) {
            if(carte.getHauteur() > 10)
                total += 10;
            else if (carte.getHauteur() >1 && carte.getHauteur() <11)
                total += carte.getHauteur();
            else if (carte.getHauteur() == 1){
                total += 1;
                nbAce++;
            }
        }
        if (nbAce>0 && total<=11)
            total +=10;

        return total;
    }

    public void demarrer() {
        initialiser();
        while (true) {
            System.out.println("Cartes du dealer : " + cartesDealer);
            System.out.println("Vos cartes       : " + cartesJoueur);

            int totalJoueur = calcul_total(cartesJoueur);
            int totalDealer = calcul_total(cartesDealer);

            System.out.println("Votre total : " + totalJoueur);

            if (totalJoueur > 21) {
                System.out.println("\n**************** Bust! Vous avez perdu ****************");
                montantTotal -= mise;
                System.out.println("Votre mantant total : "+ montantTotal);
                demarrer();
                break;
            }

            System.out.println("Hit / Stand ? (h/s)");
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();

            if (choix.equalsIgnoreCase("h")) {
                hit_carte(cartesJoueur);
            } else {
                // stand
                if (totalJoueur <= 21) {
                    totalDealer = dealerJoue(totalDealer);
                    afficherResultat(totalJoueur, totalDealer);
                    break;
                }
            }
        }
    }

    private int dealerJoue(int totalDealer) {
        while (totalDealer < 17) {
            hit_carte(cartesDealer);
            totalDealer = calcul_total(cartesDealer);
        }
        System.out.println("Cartes du dealer : " + cartesDealer);
        System.out.println("Total du dealer  : " + totalDealer);
        return totalDealer;
    }

    private void afficherResultat(int totalJoueur, int totalDealer) {
        Scanner scanner = new Scanner(System.in);
        if (totalDealer > 21 || totalJoueur > totalDealer) {
            System.out.println("\n**************** Vous avez gagné ! ****************\n");
            montantTotal += mise;
        } else if (totalJoueur < totalDealer) {
            System.out.println("\n**************** Vous avez perdu ! ****************\n");
            montantTotal -= mise;
        } else {
            System.out.println("\n***************** Push! Égalité ******************\n");
        }
        if (montantTotal <= 0){
            System.out.println("Votre montant total est epuisé");
            System.exit(0);
        }
        System.out.println("Votre mantant total : "+ montantTotal);
        System.out.println("Voulez vous rejouer ? (O/N)");
        String choix = scanner.nextLine();
        if (choix.equalsIgnoreCase("o"))
            demarrer();
    }

    private void choisirMise(){
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Choisissez votre mise :");
            System.out.println("1. 10 jetons ");
            System.out.println("2. 20 jetons ");
            System.out.println("3. 50 jetons ");
            System.out.println("4. 100 jetons ");
            System.out.println("5. 500 jetons ");
            System.out.println("6. X2 jetons ");

            int choixMise;
            try {
                choixMise = scanner.nextInt();
            }catch (Exception e){
                System.out.println("La mise par défaut sera de 10 jetons");
                choixMise = 1;
            }

            switch (choixMise) {
                case 1:
                    mise = 10;
                    break;
                case 2:
                    mise = 20;
                    break;
                case 3:
                    mise = 50;
                    break;
                case 4:
                    mise = 100;
                    break;
                case 5:
                    mise = 500;
                    break;
                case 6:
                    mise = (montantTotal*2);
                    break;
                default:
                    System.out.println("Choix de mise invalide. La mise par défaut sera de 10 jetons.");
                    mise = 10;
                    break;
            }
        }while(mise > montantTotal);

    }

}
