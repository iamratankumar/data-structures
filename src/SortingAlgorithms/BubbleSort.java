package SortingAlgorithms;


public final class BubbleSort{

    private BubbleSort(){
        // Prevent instantiation
    };
    /**
     * Sorts the given array in ascending order using the Bubble Sort algorithm.
     *
     * @param list the array to sort
     */
    public static void sort(int[] list){
        if(list == null || list.length <=1) return;
        boolean swapped;
        for(int i=0; i<list.length; i++){
            swapped = false;
            for(int j=0; j< list.length-i-1; j++){
                if(list[j]>list[j+1]) {
                    SortingUtils.swap(list, j, j + 1);
                    swapped=true;
                }
            }
            if(!swapped) break;
        }
    }

}
