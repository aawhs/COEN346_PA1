package coen346.pa1.resources;

import java.io.*;
import java.lang.*;
import java.util.*;

//the Merge Sort class by itself
public class MergeSort {

    public static void mergesort(int[] nums, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            mergesort(nums, low, mid);
            mergesort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }
    //merging the subarrays back together
    public static void merge(int[] nums, int lo, int mid, int hi) {
        int firstNum = mid - lo + 1;
        int secondNum = hi - mid;

        int low[] = new int [firstNum];
        int high[] = new int [secondNum];

        for(int i=0;i<firstNum;++i)
            low[i]=nums[lo+i];

        for(int j=0;j<secondNum;++j)
            high[j]=nums[mid+j+1];

        int x=0;
        int y=0;
        int z=lo;

        while(x<firstNum && y<secondNum){
            if (low[x]<=high[y]){
                nums[z]=low[x];
                x++;
            }
            else{
                nums[z]=high[y];
                y++;
            }
            z++;
        }

        while (x<firstNum){
            nums[z]=low[x];
            z++;
            x++;
        }
        while (y<secondNum){
            nums[z]=high[y];
            z++;
            y++;
        }

    }
}
