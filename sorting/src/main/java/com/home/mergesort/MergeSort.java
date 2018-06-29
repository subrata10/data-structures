package com.home.mergesort;

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter the number: ");
        for (int i=0; i<size; i++) {
            numbers[i] = input.nextInt();
        }

        input.close();

        System.out.println("Entered number in non sorting order:");
        for (int number : numbers) {
            System.out.print(number+" ");
        }

        System.out.println("\n");

        doMergeSort(numbers);

        System.out.println("Sorted number: ");
        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }

    private static void doMergeSort(int[] numbersArr) {

    }
}
