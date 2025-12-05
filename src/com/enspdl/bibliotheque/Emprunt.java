package com.enspdl.bibliotheque;

public class Emprunt {
    private Livre livre;
    private Membre membre;
    private String dateEmprunt;
    private String dateRetourPrevue;
    private boolean rendu;

    public Emprunt(Livre livre, Membre membre, String dateEmprunt, String dateRetourPrevue) {
        this.livre = livre;
        this.membre = membre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.rendu = false;

        livre.setDisponible(false);
    }

    public Livre getLivre() { return livre; }
    public Membre getMembre() { return membre; }
    public boolean isRendu() { return rendu; }

    public void retournerLivre() {
        if (!rendu) {
            rendu = true;
            livre.setDisponible(true);
            System.out.println("Livre retourné : " + livre.getTitre());
        }
    }

    public void afficherEmprunt() {
        System.out.println("  EMPRUNT   ");
        System.out.println("Livre : " + livre.getTitre());
        System.out.println("Membre : " + membre.getNom());
        System.out.println("Date emprunt : " + dateEmprunt);
        System.out.println("Retour prévu : " + dateRetourPrevue);
        System.out.println("Rendu : " + (rendu ? "Oui" : "Non"));
    }
}

