package com.example.helloworld;

import java.util.Scanner;

public class NumbersSomme {
    public static void main(String[] args){
        float result = 0;
        System.out.print("Entrer les nombres avec {,} entre eux : ");
        Scanner input = new Scanner(System.in);
        String StringValue = input.nextLine();
        String[] Values = StringValue.trim().split(",");
        for(String s:Values){

            try {
                result = result + Float.parseFloat(s);
            }
            catch (Exception e) {
                System.out.println("L'un des elements n'est pas un float : " + s);
                return;
            }
        }
        System.out.println("La somme est :"+ result);
    }

}
