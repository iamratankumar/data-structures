package SortingAlgorithms;

public final class SelectionSort{
    private SelectionSort(){
        // Prevent instantiation
    }
    /**
     * Sorts the given array in ascending order using the Selection Sort algorithm.
     *
     * @param list the array to sort
     */
    public static void sort(int[] list){
        if(list == null || list.length <=1) return;
        int smallNo=0;
        for(int i=0; i<list.length-1; i++){
            smallNo=i;
            for(int j=i+1; j<list.length;j++){
                if(list[j] < list[smallNo])  smallNo = j;
            }
            if(i!=smallNo) SortingUtils.swap(list, i, smallNo);
        }
    }




}
