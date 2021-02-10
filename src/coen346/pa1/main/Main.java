package coen346.pa1.main;

import java.io.*;
import java.lang.*;
import java.util.*;
import coen346.pa1.resources.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        //could put this in its own method after...
        Scanner read=new Scanner(new File("Input.txt")); //Scanner object 'read' is created from the numbers in 'Input.txt'
        //could also set your own filepath in the brackets, but I simply tested with the text file in my project folder
        int[] numbers=new int[8]; //the array[8] 'numbers' which they will be put into
        int i=0;
        while(read.hasNextInt()){
            numbers[i++] = read.nextInt(); //proceeds to fill the 8 slot array with the numbers from the txt file
        }

        System.out.println("Original array: ");
        System.out.println(Arrays.toString(numbers)); //checking to make sure numbers were properly read prior to sorting

        MergeSort obj = new MergeSort(numbers); // --> Using the constructor instead of Lorenzo's direct call to reduce redundancy
        //obj.sort(numbers,0, numbers.length-1); //and now they get sent off to be sorted -->
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(numbers)); //newly sorted number array is now read out -->successful

        //Now need to write the array into 'Output.txt'
        //Should we implement this into mergesort function so that it writes as it goes into the 'Output.txt'?
    }
}
