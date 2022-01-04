package com.example.helloworld;

import java.util.Scanner;

public class Morse {
    public static void main(String[] args){
        System.out.print("Entrer votre text: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String[] textArray = text.split(" ");
        for (String s : textArray) {
            System.out.print(s + " Stop. ");
        }
    }

}
