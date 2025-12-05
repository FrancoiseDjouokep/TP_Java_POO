package com.enspdl.bibliotheque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bibliotheque b = new Bibliotheque("Bibliothèque ENSPD");


        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("****Bibliotheque ENSPD****");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Inscrire un membre");
            System.out.println("3. Effectuer un emprunt");
            System.out.println("4. Rechercher un livre par son tirte");
            System.out.println("5. Afficher livres disponibles");
            System.out.println("6. Statistiques");
            System.out.println("0. Quitter");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Titre: ");
                    String titre = sc.nextLine();
                    System.out.print("Auteur: ");
                    String auteur = sc.nextLine();
                    System.out.print("Année: ");
                    int annee = sc.nextInt(); sc.nextLine();

                    b.ajouterLivre(new Livre(isbn, titre, auteur, annee));
                    break;

                case 2:
                    System.out.print("1=Etudiant, 2=Enseignant: ");
                    int type = sc.nextInt(); sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    if (type == 1) {
                        System.out.print("Filière: ");
                        String filiere = sc.nextLine();
                        b.inscrireMembre(new Etudiant(id, nom, email, filiere));
                    } else {
                        System.out.print("Département: ");
                        String dep = sc.nextLine();
                        b.inscrireMembre(new Enseignant(id, nom, email, dep));
                    }
                    break;

                case 3:
                    System.out.print("ISBN livre: ");
                    String is = sc.nextLine();
                    System.out.print("ID membre: ");
                    String idm = sc.nextLine();
                    System.out.print("Date emprunt: ");
                    String d = sc.nextLine();
                    System.out.print("Date retour: ");
                    String dr = sc.nextLine();

                    b.effectuerEmprunt(is, idm, d, dr);
                    break;

                case 4:
                    System.out.print("Titre du livre à rechercher: ");
                    String titreR = sc.nextLine();
                    Livre found = b.rechercherLivreParTitre(titreR);
                    if (found != null) {
                        found.afficherDetails();
                    } else {
                        System.out.println("Livre introuvable pour le titre : " + titreR);
                    }
                    break;

                case 5:
                    b.afficherLivresDisponibles();
                    break;

                case 6:
                    b.afficherStatistiques();
                    break;
            }

        } while (choix != 0);

        sc.close();
    }
}
