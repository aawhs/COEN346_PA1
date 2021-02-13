package coen346.pa1.mergesort;

import java.util.Arrays;


/**
 * The MergeSortMT Runnable class uses the @class MergeSort to execute a Merge Sort algorithm that utilizes recursive
 * multithreading (Divide & Conquer Parallelism)
 * <p>
 * The Program works as follows
 * 1 - Get number of available processors in the system using the method mergeSortMT
 * 2 - Commence the merge sort algorithm
 * 3 - create left and right subarrays for each half of the original array
 * 4 - spawn two threads for each call
 * 5 - wait for threads to finish
 * 6 - each thread merges its sub threads after sorting
 * 7 - call recursively
 * <p>
 * Reference Code:
 * M. Stepp, “CSE 373 - Introduction to Parallel Algorithms.” University of Washington.
 * <p>
 * #should be run by each thread:
 * def merge_sort_thread(start_index, end_index, array):
 * if (start_index-end_index+1)==1:
 * #compare arr[index] with array[index_index] and swap if necessary
 * return
 * else:
 * mid_point = (start_index+end_index+1)/2
 * spawn_thread(func=merge_sort_thread, start_index = start_index, end_index=mid_point-1, array)
 * spawn_thread(func=merge_sort_thread, start_index = mid_point, end_index=end_index, array)
 * # wait for both threads to finish
 * #Merge array [start_index,mid_point-1] with [mid_point, end_index]
 * return
 * <p>
 * def recursive_merge_sort(array):
 * merge_sort_thread(0,array.length-1, array)
 */
public class MergeSortMT implements Runnable {

    // Private Data Members
    private final int[] arr;
    private final int threadCount;

    /**
     * Constructor of the Multithreaded Runnable implementation
     *
     * @param arr
     * @param threadCount
     */
    public MergeSortMT(int[] arr, int threadCount) {
        this.arr = arr;
        this.threadCount = threadCount;
    }

    /**
     * mergeSortMT is responsible for obtaining the number of available processors and executing the mergeSort algorithm
     *
     * @param arr
     */
    public static void mergeSortMT(int[] arr) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread " + Thread.currentThread().getName() + " Started");
        mergeSort(arr, availableProcessors);
    }

    /**
     * mergeSort method uses MergeSort class to execute
     * it checks the number of threads available to determine if creation of threads is necessary
     * if the number of threads <=1 then it executes a regular merge sort
     * else it starts() threads
     * then join() threads to wait for them to finish
     * then merge()
     *
     * @param arr
     * @param threadsAvailable
     */
    public static void mergeSort(int[] arr, int threadsAvailable) {
        if (threadsAvailable <= 1) {
            //Sequential Merge sort
            MergeSort.mergeSort(arr);
        } else if (arr.length >= 2) {
            //Thread Count
            int t_c = threadsAvailable / 2;
            //Mid Point of array
            int mid = arr.length / 2;

            // *********** Divide Implementation ***********
            int[] arr_a = Arrays.copyOfRange(arr, 0, mid);
            int[] arr_b = Arrays.copyOfRange(arr, mid, arr.length);

            //Creation of threads
            Thread threadA = new Thread(new MergeSortMT(arr_a, t_c));
            Thread threadB = new Thread(new MergeSortMT(arr_b, t_c));

            //Start Execution of Threads
            threadA.start();
            threadB.start();


            //Waiting for threads to finish execution
            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                e.printStackTrace();
            }

            // *********** Conquer Implementation ***********
            // Merging executes only after thread A and thread B are done executing
            MergeSort.merge(arr_a, arr_b, arr);

        }
    }

    /**
     * Runnable class Run method overridden to state and execute thread
     *
     * @Override run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Started");
        mergeSort(arr, threadCount);
        System.out.println(Thread.currentThread().getName() + " Finished : " + Arrays.toString(arr));
    }


}
