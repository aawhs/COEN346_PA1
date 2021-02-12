package coen346.pa1.main;

import java.io.*;
import java.lang.*;
import java.util.*;
import coen346.pa1.resources.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //could put this in its own method after...
        Scanner read=new Scanner(new File("Input.txt")); //Scanner object 'read' is created from the numbers in 'Input.txt'
        int[] numbers=new int[8]; //the array[8] 'numbers' which they will be put into
        int i=0;
        while(read.hasNextInt()){
            numbers[i++] = read.nextInt(); //proceeds to fill the 8 slot array with the numbers from the txt file
        }

        PrintStream output = new PrintStream(new File("Output.txt")); //setting up the console output to be sent to 'Output.txt'
        System.setOut(output);

        System.out.println("Original array: ");
        System.out.println(Arrays.toString(numbers)); //checking to make sure numbers were properly read prior to sorting

        MultiThreadedMergeSort.sort(numbers);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(numbers));

    }

}
