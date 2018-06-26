package com.dvoinenko.draft.tasks;

public class Factorial {
    long factorial(int a) {
        if (a == 1) {
            return 1;
        }
        return a*factorial(a-1);
    }

    public static void main(String[] args) {
        Factorial newFacrorial = new Factorial();
        System.out.println(newFacrorial.factorial(40));
    }
}
