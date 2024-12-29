package SortingAlgorithms;

public class SortingUtils {
    /**
     * Swaps the elements at the specified indices in the array.
     *
     * @param arr the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j]=tmp;
    }
}
