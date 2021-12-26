package com.example.helloworld;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello World");

        String myInt = input.nextLine().toUpperCase();
        System.out.printf("you entered %s. %n%n",myInt);
    }
}
