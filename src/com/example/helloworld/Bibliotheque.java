package com.example.helloworld;

import java.util.Vector;

public class Bibliotheque {
    int nbr_max;
    Vector<Livres> livres_list;
    public static void main(String[] args){
        String[] auteurs = new String[]{"Mohamed","Yassine"};
        Vector<Livres> auteurLivres = new Vector<Livres>();
        Livres first = new Livres("Antigone",auteurs,"333",120.40);
        Livres second = new Livres("Hahaha",auteurs,"333",120.40);
        Bibliotheque bibliothe = new Bibliotheque(10);
        bibliothe.ajouterLivres(first);
        bibliothe.ajouterLivres(second);
        System.out.println(bibliothe);
        auteurLivres = bibliothe.Cherche("Mohamed");
        System.out.println("Les livres ecrits par Mohamed ");
        for(Livres livre:auteurLivres){
            System.out.println(livre);
        }

    }
    public Bibliotheque(int nbr_max) {
        this.nbr_max = nbr_max;
        livres_list = new Vector<Livres>();
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
        Vector<Livres> livress = new Vector<Livres>();
        for(Livres livres : livres_list){
            for(String auteurr : livres.auteurs){
                if(auteurr.matches(auteur)){
                    livress.add(livres);
                }
            }
        }
        return livress;
    }

}
