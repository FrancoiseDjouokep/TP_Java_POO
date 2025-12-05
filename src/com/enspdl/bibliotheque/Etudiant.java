package com.enspdl.bibliotheque;

public class Etudiant extends Membre {
    private String filiere;

    public Etudiant(String id, String nom, String email, String filiere) {
        super(id, nom, email);
        this.filiere = filiere;
    }

    public String getFiliere() { return filiere; }
    public void setFiliere(String filiere) { this.filiere = filiere; }

    @Override
    public int getNombreMaxEmprunts() {
        return 3;
    }

    @Override
    public int getDureeEmprunt() {
        return 14;
    }

    @Override
    public void afficherInfo() {
        System.out.println("[Etudiant] " + getId() + " - " + getNom() + " - " + getEmail() + " - Filière: " + filiere);
    }
}
