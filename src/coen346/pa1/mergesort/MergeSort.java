package coen346.pa1.mergesort;

import java.util.Arrays;

/**
 * Sequential Merge Sort Algorithm
 */

public class MergeSort {

    /**
     * Typical Merge sort algorithm (Divide and Conquer)
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {

        if (arr.length >= 2) {
            int mid = arr.length / 2;

            int[] arr_a = Arrays.copyOfRange(arr, 0, mid);
            int[] arr_b = Arrays.copyOfRange(arr, mid, arr.length);

            // sort the halves
            mergeSort(arr_a);
            mergeSort(arr_b);

            // merge them back together
            merge(arr_a, arr_b, arr);
        }
    }

    /**
     * Merge Left & Right Subarrays into main arr
     *
     * @param left
     * @param right
     * @param arr
     */
    public static void merge(int[] left, int[] right, int [] arr) {
        int i = 0, j = 0, k = 0;
        while (i < arr.length) {
            if (k >= right.length) {
                arr[i] = left[j];
                j++;
            } else if (j < left.length && left[j] < right[k]) {
                arr[i] = left[j];
                j++;
            } else {
                arr[i] = right[k];
                k++;
            }
            i++;
        }
    }
}
