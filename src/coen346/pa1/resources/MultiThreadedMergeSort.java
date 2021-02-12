package coen346.pa1.resources;

public class MultiThreadedMergeSort implements Runnable{
    private static int threadsNeeded = 8; //the 8 threads used for splitting into subarrays
    private static int totalThreads=1; //The original first thread used to start with

    public static void sort(int[] nums){
        totalThreads=1; //the original first thread
        sort(nums,0, nums.length -1);
    }

    private static void sort(int[] nums, int low, int high){
        if (low<high){
            int mid = (low+high)/2;
            Thread createThread = new Thread();
            if (totalThreads < threadsNeeded) {
                createThread = new Thread(new MultiThreadedMergeSort(nums, low, high));
                totalThreads++;
                createThread.start(); //sorting first half subarray with this new thread
            }

            if(createThread != null) {
                sort(nums, mid + 1, high); //sorting second half subarray with thread
                try {
                    createThread.join(); //now wait for other threads to finish sorting before merging back
                    System.out.println("Thread "+ Thread.currentThread().getId() + " finished");
                    //letting other thread finish its sorting
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
            //no need to make new threads past this point
                    else{
                        MergeSort.mergesort(nums, low, mid);
                        MergeSort.mergesort(nums, mid+1, high);
                    }
                    MergeSort.merge(nums, low, mid, high); //merge sub arrays back

            }
        }

        private int[] nums;
        private int lo; //the low index
        private int hi; //the high index

    //subarray gets sorted here
        public MultiThreadedMergeSort(int[] nums, int low, int high){
            this.nums = nums;
            this.lo = low;
            this.hi=high;
        }

        //overriding the run() to show when new threads are made
        @Override
        public void run() {
            System.out.println("Thread "+ Thread.currentThread().getId() + " started");
            sort(nums, lo, hi); //sort method is included in this like Oussama said (Tutorial 2)
        }
    }

