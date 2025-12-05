package com.enspdl.bibliotheque;

import java.time.Year;

public class Livre {
    private String isbn;
    private String titre;
    private String auteur;
    private int anneePublication;
    private boolean disponible;

    public Livre(String isbn, String titre, String auteur, int anneePublication) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.disponible = true;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public int getAnneePublication() { return anneePublication; }
    public void setAnneePublication(int anneePublication) { this.anneePublication = anneePublication; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public void afficherDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Année: " + anneePublication);
        System.out.println("Disponible: " + (disponible ? "Oui" : "Non"));
    }

    public int getAge() {
        return Year.now().getValue() - anneePublication;
    }
}

