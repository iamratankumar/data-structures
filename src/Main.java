import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>(1);


        list.add(2);
        list.add(3);
        list.add(1);
        list.add(3, 4);
        list.add(5);

        System.out.println(list.size());*/


        LinkedList<Integer>  ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(1,0);
        //ll.remove(2);
      // ll.removeLast();
        System.out.println(ll.get(3));

        LinkedList<Integer> lis = new LinkedList<>(new Integer[]{1,2,3,4,5});

        int a=1;
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(22);
        bst.insert(12);
        bst.insert(8);
        bst.insert(20);
        bst.insert(30);
        bst.insert(25);
        bst.insert(40);

        System.out.println(bst.traverse(BinarySearchTree.ORDER.INORDER));

        bst.remove(22);

        System.out.println(bst.traverse(BinarySearchTree.ORDER.INORDER));


    }
}