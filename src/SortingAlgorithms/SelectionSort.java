package SortingAlgorithms;

public final class SelectionSort {
    private SelectionSort(){}

    public static void sort(int[] list){
        if(list == null || list.length ==0) return;
        int smallNo=0;
        for(int i=0; i<list.length-1; i++){
            smallNo=i;
            for(int j=i+1; j<list.length;j++){
                if(list[j] < list[smallNo])  smallNo = j;
            }
            if(i!=smallNo) swap(list, i, smallNo);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j]=tmp;
    }

}
