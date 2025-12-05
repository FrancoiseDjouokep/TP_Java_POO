package com.enspdl.bibliotheque;

public class Bibliotheque {
    private String nom;
    private Livre[] livres;
    private Membre[] membres;
    private Emprunt[] emprunts;
    private int nbLivres;
    private int nbMembres;
    private int nbEmprunts;

    public Bibliotheque(String nom) {
        this.nom = nom;
        this.livres = new Livre[100];
        this.membres = new Membre[50];
        this.emprunts = new Emprunt[200];
        this.nbLivres = 0;
        this.nbMembres = 0;
        this.nbEmprunts = 0;
    }

    public void ajouterLivre(Livre l) {
        livres[nbLivres++] = l;
    }

    public void inscrireMembre(Membre m) {
        membres[nbMembres++] = m;
    }

    public Livre rechercherLivreParTitre(String titre) {
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getTitre().equalsIgnoreCase(titre))
                return livres[i];
        }
        return null;
    }

    public Livre rechercherLivreParIsbn(String isbn) {
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getIsbn().equals(isbn))
                return livres[i];
        }
        return null;
    }

    public Membre rechercherMembreParId(String id) {
        for (int i = 0; i < nbMembres; i++) {
            if (membres[i].getId().equals(id))
                return membres[i];
        }
        return null;
    }

    public void effectuerEmprunt(String isbn, String idMembre, String date, String dateRetour) {
        Livre l = rechercherLivreParIsbn(isbn);
        Membre m = rechercherMembreParId(idMembre);

        if (l == null || m == null || !l.isDisponible()) {
            System.out.println("Impossible d'effectuer l'emprunt.");
            return;
        }

        Emprunt e = new Emprunt(l, m, date, dateRetour);
        emprunts[nbEmprunts++] = e;

        System.out.println("Emprunt effectué avec succès !");
    }

    public void afficherLivresDisponibles() {
        System.out.println("----- LIVRES DISPONIBLES -----");
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].isDisponible()) {
                System.out.println("- " + livres[i].getTitre());
            }
        }
    }

    public void afficherStatistiques() {
        int disponibles = 0;
        int empruntsEnCours = 0;
        int etu = 0, ens = 0;

        for (int i = 0; i < nbLivres; i++)
            if (livres[i].isDisponible()) disponibles++;

        for (int i = 0; i < nbMembres; i++) {
            if (membres[i] instanceof Etudiant) etu++;
            else if (membres[i] instanceof Enseignant) ens++;
        }

        for (int i = 0; i < nbEmprunts; i++)
            if (!emprunts[i].isRendu()) empruntsEnCours++;

        System.out.println("----- STATISTIQUES -----");
        System.out.println("Total livres : " + nbLivres);
        System.out.println("Livres disponibles : " + disponibles);
        System.out.println("Membres : " + nbMembres + " (Etudiants : " + etu + ", Enseignants : " + ens + ")");
        System.out.println("Emprunts en cours : " + empruntsEnCours);
    }
}

