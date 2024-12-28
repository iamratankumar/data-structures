import DataStructures.ArrayList;
import SortingAlgorithms.SelectionSort;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(1);


      /*  list.add(2);
        list.add(3);
        list.add(1);
        list.add(3, 4);
        list.add(5);

        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());*/


       /* DataStructures.LinkedList<Integer>  ll = new DataStructures.LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(1,0);
        //ll.remove(2);
      // ll.removeLast();
        System.out.println(ll.get(3));

        DataStructures.LinkedList<Integer> lis = new DataStructures.LinkedList<>(new Integer[]{1,2,3,4,5});

        int a=1;
        DataStructures.BinarySearchTree<Integer> bst = new DataStructures.BinarySearchTree<>();

        bst.insert(22);
        bst.insert(12);
        bst.insert(8);
        bst.insert(20);
        bst.insert(30);
        bst.insert(25);
        bst.insert(40);

        System.out.println(bst.traverse(DataStructures.BinarySearchTree.ORDER.INORDER));

        bst.remove(8);

        System.out.println(bst.traverse(DataStructures.BinarySearchTree.ORDER.INORDER));*/


        int[] arr = new int[]{2,3,1,5,8,9,0};


        SelectionSort.sort(arr);

    }
}