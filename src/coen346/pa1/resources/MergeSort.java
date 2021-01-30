package coen346.pa1.resources;

public class MergeSort {
    public MergeSort(){}
    public MergeSort(int[] arr){
        sort(arr);
    }



    public static void merge(int[] arr, int lo, int mid, int hi){
         int firstNum = mid - lo + 1;
            int secondNum = hi - mid;

            int low[] = new int [firstNum];
            int high[] = new int [secondNum];

            for(int i=0;i<firstNum;++i)
                low[i]=arr[lo+i];
            
            for(int j=0;j<secondNum;++j)
                high[j]=arr[mid+j+1];

            int x=0;
            int y=0;
            int z=lo;
            
            while(x<firstNum && y<secondNum){
                if (low[x]<=high[y]){
                    arr[z]=low[x];
                    x++;
                }
                else{
                    arr[z]=high[y];
                    y++;
                }
                z++;
            }
            while (x<firstNum){
                arr[z]=low[x];
                z++;
                x++;
            }
            while (y<secondNum){
                arr[z]=high[y];
                z++;
                y++;
            }
    }

    private static void sort(int[] arr) {
        sort(arr, 0 , arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi){
        if (hi <= lo) return;

        //getting middle point -->had to change Ahmed's mid point equation
            int mid = (lo+hi)/2;

            //sorting each array half
            sort(arr, lo, mid); //originally was (arr,lo,hi)
            sort(arr, mid + 1, hi);

        merge(arr,lo,mid,hi);

    }

}
