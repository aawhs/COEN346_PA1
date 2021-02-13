package coen346.pa1.main;

/**
 * @Title COEN346 - Programming Assignment 1
 *
 * @author Ahmed Ali - 40102454
 * @author Lorenzo Bertacchi - 40029341
 * @author Petru-Andrei Vrabie - 40113236
 *
 * Driver - MAIN CLASS
 */

import coen346.pa1.mergesort.MergeSortMT;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = new Scanner(new File("Input.txt")); //Scanner object 'read' is created from the numbers in 'Input.txt'
        int[] numbers = new int[8]; //the array[8] 'numbers' which they will be put into
        int i = 0;
        while (read.hasNextInt()) {
            numbers[i++] = read.nextInt(); //proceeds to fill the 8 slot array with the numbers from the txt file
        }

        PrintStream output = new PrintStream("Output.txt"); //setting up the console output to be sent to 'Output.txt'
        System.setOut(output);

        System.out.println("Original array: ");
        System.out.println(Arrays.toString(numbers)); //checking to make sure numbers were properly read prior to sorting


        //Sorting using Recursive Multithreading & MergeSort
        MergeSortMT.mergeSortMT(numbers);
        System.out.println("Thread " + Thread.currentThread().getName() + " Finished : " + Arrays.toString(numbers));

        //Printing to output file
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(numbers));

    }

}
