public class LinkedList<T>{
    private class Node{
        T value;
        Node next;

        public Node(T item){
            this.value = item;
        }
        public Node(T item, Node next){
            this.value = item;
            this.next = next;
        }

    }// value, next

    private Node head;
    private int size;

    public void LinkedList(){
        head =null;
    }

    public void add(T item){
        addLast(item);
    }
    void add(int index, T item){
        if(index <0 || index >size) throw new IndexOutOfBoundsException("Invalid index: "+index);
        Node newNode = new Node(item);
        if(index==0){
            newNode.next = head;
            head = newNode;
        }else {
            Node curr = findReference(index);
            newNode.next = curr;
            curr.next = newNode;
        }
    }

    void addFirst(T item){
        if(head == null) head = new Node(item);
        else{
            Node newNode = new Node(item);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addLast(T item){
        if(head == null) head = new Node(item);
        else {
            Node curr= head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(item);
        }
        size++;
    }

    void remove(int index){
        if(head == null) throw  new NullPointerException("List is empty");
        if(index ==0) head = head.next;
        Node curr = findReference(index);
        curr.next= curr.next.next;
    }

    private  Node findReference(int idx){
        Node curr = head;
        int i=1;
        while(i<idx){
            curr = curr.next;
            i++;
        }
        return curr;
    }

    T get(int index){
        if(index <0 || index >size) throw new IndexOutOfBoundsException("Invalid index: "+index);
        if(head == null)throw new NullPointerException("List is empty");
        int i=0;
        Node curr =head;
        while (i < index){
            curr = curr.next;
            i++;
        }
        return curr.value;
    }

    int size(){ return size;}

}
