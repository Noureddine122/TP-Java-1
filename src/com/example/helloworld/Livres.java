package com.example.helloworld;

import java.util.Arrays;

public class Livres implements java.io.Serializable{
    String titre;
    String[] auteurs;
    String ISBN;
    double price;

    public static void main(String[] args){

    }
    public Livres(String titre, String[] auteurs, String ISBN, double price) {
        this.titre = titre;
        this.auteurs = auteurs;
        this.ISBN = ISBN;
        this.price = price;
    }
    public String toString() {
        String res = null;
        res = "\n-------------------";
        res += "\nTitre: "+ titre;
        res += "\nAuteurs: "+ Arrays.toString(auteurs);
        res += "\nISBN: "+ISBN;
        res += "\nPrice: "+price;
        res += "\n-------------------";

        return res;
    }
}
