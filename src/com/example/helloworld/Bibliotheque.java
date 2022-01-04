package com.example.helloworld;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Bibliotheque implements java.io.Serializable{
    int nbr_max;
    Vector<Livres> livres_list;
    public static void main(String[] args) throws IOException {
        String file = "serial";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        String[] auteurs = new String[]{"Mohamed", "Yassine"};
        Bibliotheque bibliothe = new Bibliotheque(10);
        Livres first = new Livres("Antigone", auteurs, "333", 120.40);
        oos.writeObject(first);
        Livres second = new Livres("Hahaha", auteurs, "333", 120.40);
        oos.writeObject(second);

        bibliothe.ajouterLivres(first);
        bibliothe.ajouterLivres(second);
        Bibliotheque bib = new Bibliotheque(10);
        ArrayList<Livres> list = new ArrayList<Livres>();

        int choiceInt;
        String choices;
        do {
            System.out.println("**********************");
            System.out.println("1-Voir les livres disponibles");
            System.out.println("2-Ajouter un nouveau livre");
            System.out.println("3-Chercher un livre par son auteur ");
            System.out.print("Votre choix: ");
            Scanner choice = new Scanner(System.in);
            choiceInt = Integer.parseInt(String.valueOf(choice.nextInt()));

            switch (choiceInt) {
                case 1 -> System.out.println(bibliothe);
                case 2 -> {
                    System.out.print("Entrer le nom du votre livre: ");
                    Scanner inputLivreTitle = new Scanner(System.in);
                    String title = inputLivreTitle.nextLine();
                    System.out.print("Entrer les auteurs: ");
                    Scanner outputL = new Scanner(System.in);
                    String[] tabAuteur = outputL.nextLine().split(" ");
                    System.out.print("Entrer ISBN: ");
                    String isbn = (new Scanner(System.in)).nextLine();
                    System.out.print("Entrer Prix: ");
                    float price = (new Scanner(System.in)).nextFloat();
                    Livres newLivres = new Livres(title, tabAuteur, isbn, price);
                    bibliothe.ajouterLivres(newLivres);
                    oos.writeObject(newLivres);
                    System.out.println("Le livre "+ title +"est bien Enregistreé!");
                    System.out.println("Le livre "+ title +"est bien Serialisé");

                }
                case 3 -> {
                    System.out.println("Entrer le nom du auteur recherché");
                    String auteur = (new Scanner(System.in)).nextLine();
                    Vector<Livres> auteurLivres = bibliothe.Cherche(auteur);
                    if (auteurLivres.isEmpty()) {
                        System.out.println("L'auteur que vous avez entrez n'a aucun livres chez nous");
                    } else {
                        System.out.println("Les livres ecrits par:" + auteur);

                        for (Livres livre : auteurLivres) {
                            System.out.println(livre);
                        }
                    }
                }
                default -> System.out.println("Votre choix n'existe pas !! essayez encore");
            }
            System.out.print("Voulez vous continuez ?! Tapez [N] si non:: ");
            choices = (new Scanner(System.in)).nextLine();
        } while (!Objects.equals(choices, "N"));
        System.out.println("Au revoir");
        oos.close();
        fos.close();
        bibliothe.livres_list.clear();
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(fis.available() != 0) bib.ajouterLivres((Livres) ois.readObject());
            ois.close();
            fis.close();
            System.out.println(bib);
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
        }

    }
    public Bibliotheque(int nbr_max) {
        this.nbr_max = nbr_max;
        livres_list = new Vector<>();
    }
    int capacity() {
        return nbr_max;
    }
    void ajouterLivres(Livres livre) {
        if(livres_list.size()<nbr_max-1){
            livres_list.add(livre);
        }else{
            System.out.println("La bibliotheque est full");
        }
    }
    int size(){
        return livres_list.size();
    }
    public String toString(){
        StringBuilder res = new StringBuilder(super.toString());
        res.append("\nLes livres disponibiles: ");
        for (Livres livres : livres_list) {
            res.append(livres.toString());
        }
        return res.toString();
    }
    public Vector<Livres> Cherche(String auteur){
        Vector<Livres> livress = new Vector<>();
        for(Livres livres : livres_list){
            for(String auteurr : livres.auteurs){
                if(auteurr.toLowerCase().matches(auteurr.toLowerCase())){
                    livress.add(livres);
                }
            }
        }
        return livress;
    }

}
