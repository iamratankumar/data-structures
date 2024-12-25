public class LinkedList<T>{
    private class Node{
        T value;
        Node next;
        Node prev;

        public Node(T item){
            this.value = item;
        }
        public Node(T item, Node next, Node prev){
            this.value = item;
            this.next = next;
            this.prev = prev;
        }

    }// value, next

    private Node head,tail;
    private static int size;

    public LinkedList(){
        head = tail = null;
        size=0;
    }


    public void add(T item){
        addLast(item);
    }
    void add(int index, T item){
        if(index <0 || index >size) throw new IndexOutOfBoundsException("Invalid index: "+index);
        Node newNode = new Node(item);
        if(index==0){
            addFirst(item);
        }else {
            Node curr = searchNode(index-1);
            newNode.next = curr;
            curr.next = newNode;
            size++;
        }
    }

    void addFirst(T item){
        Node newNode = new Node(item);
        if(isEmpty()) {head = tail = newNode;}
        else{
            /*Node newNode = new Node(item);
            newNode.next = head;
            head = newNode;*/
            newNode.next =head;
            head.prev = newNode;
            head = head.prev;
        }

        size++;
    }

    void addLast(T item){
        Node newNode = new Node(item);
        if(isEmpty()) {head =tail = newNode;}
        else {
            /*Node curr= head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(item);*/
           newNode.prev = tail;
           tail.next = newNode;
           tail = tail.next;
        }
        size++;
    }

    void remove(int index){
        if(isEmpty()) throw  new NullPointerException("List is empty");
        if(index ==0) head = head.next;
        Node curr = searchNode(index-1);
        curr.next= curr.next.next;
        curr.next.prev = curr;
        size--;

    }
    void removeFirst(){
        if(isEmpty()) throw  new NullPointerException("List is empty");
        head = head.next;
        head.prev = null;
        size--;
    }
    void removeLast(){
        if(isEmpty()) throw new NullPointerException("List is empty");
        tail = tail.prev;
        tail.next =null;
        size--;
    }

    boolean isEmpty(){ return head== null || size<=0;}

     Node searchNode(int idx){
        Node curr = head;
        int i=0;
        while(i<idx){
            curr = curr.next;
            i++;
        }
        return curr;
    }
    T getLast(){
        if(isEmpty()) throw new NullPointerException("List is Empty");
        return tail.value;
    }
    T getFirst(){
        if(isEmpty()) throw new NullPointerException("List is Empty");
        return head.value;
    }

    T get(int index){
        if(index <0 || index >size) throw new IndexOutOfBoundsException("Invalid index: "+index);
        if(isEmpty())throw new NullPointerException("List is empty");
        if(index ==0) return getFirst();
        if(index==size()-1) return getLast();
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
