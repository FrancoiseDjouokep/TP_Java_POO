package com.enspdl.bibliotheque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bibliotheque b = new Bibliotheque("Bibliothèque ENSPD");

        // données de test
        b.ajouterLivre(new Livre("1", "Clean Code", "Robert Martin", 2008));
        b.ajouterLivre(new Livre("2", "Design Patterns", "GoF", 1994));

        b.inscrireMembre(new Etudiant("E1", "Alice", "alice@mail.com", "Informatique"));
        b.inscrireMembre(new Enseignant("P1", "Dr Martin", "martin@mail.com", "Informatique"));

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Inscrire un membre");
            System.out.println("3. Effectuer un emprunt");
            System.out.println("4. Afficher livres disponibles");
            System.out.println("5. Statistiques");
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
                    b.afficherLivresDisponibles();
                    break;

                case 5:
                    b.afficherStatistiques();
                    break;
            }

        } while (choix != 0);

        sc.close();
    }
}
