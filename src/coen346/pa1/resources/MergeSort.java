package coen346.pa1.resources;

public class MergeSort {
    public MergeSort(){}
    public MergeSort(int[] arr){
        sort(arr);
    }



    public static void merge(int[] arr, int lo, int mid, int hi){
        //This is a test
    }

    private static void sort(int[] arr) {
        sort(arr, 0 , arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi){
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        sort(arr, lo, hi);
        sort(arr, mid+1, hi);

        merge(arr,lo,mid,hi);

    }

}
