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
        //ll.add(1,0);
//        ll.removeLast();
        System.out.println(ll.getLast());
    }
}