package com.enspdl.bibliotheque;

public class Enseignant extends Membre {
    private String departement;

    public Enseignant(String id, String nom, String email, String departement) {
        super(id, nom, email);
        this.departement = departement;
    }

    public String getDepartement() { return departement; }
    public void setDepartement(String departement) { this.departement = departement; }

    @Override
    public int getNombreMaxEmprunts() {
        return 5;
    }

    @Override
    public int getDureeEmprunt() {
        return 30;
    }

    @Override
    public void afficherInfo() {
        System.out.println("[Enseignant] " + getId() + " - " + getNom() + " - " + getEmail() + " - Département: " + departement);
    }
}
