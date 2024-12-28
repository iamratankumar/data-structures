package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T> implements Iterable<T>{
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
    private int size;

    public LinkedList(){
        head = tail = null;
        size=0;
    }
    public LinkedList(T[] list){
        addAll(list);
    }

    public void addAll(T[] list){
        for(T ls :list){
            addLast(ls);
        }
    }


    public void add(T item){
        addLast(item);
    }
    public void add(int index, T item){
        if(index <0 || index >size) throw new IndexOutOfBoundsException("Invalid index: "+index);
        if(index==0){
            addFirst(item);
            return;
        }
        if(index == size){
            addLast(item);
            return;
        }


        Node curr = searchNode(index-1);
        Node newNode = new Node(item,curr.next,curr);

        newNode.next.prev = newNode;
        curr.next = newNode;
        size++;
    }

    public void addFirst(T item){
        Node newNode = new Node(item);
        if(isEmpty()) {
            head = tail = newNode;
        }
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

    public void addLast(T item){
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

    public void remove(int index){
        if(isEmpty()) throw  new IllegalStateException("List is empty");
        if(index ==0){
            removeFirst();
            return;
        }
        if(index == size-1) {
            removeLast();
            return;
        }
        Node curr = searchNode(index-1);
        curr.next= curr.next.next;
        curr.next.prev = curr;
        size--;

    }
    public void removeFirst(){
        if(isEmpty()) throw  new IllegalStateException("List is empty");
        head = head.next;
        head.prev = null;
        size--;
    }
    public void removeLast(){
        if(isEmpty()) throw new IllegalStateException("List is empty");
        tail = tail.prev;
        if(tail !=null) tail.next =null;
        else head =null;
        size--;
    }

    public boolean isEmpty(){ return head == null || size == 0;}

     Node searchNode(int idx){
        /*Node curr = head;
        int i=0;
        while(i<idx){
            curr = curr.next;
            i++;
        }
        return curr;*/

         Node curr;
         if(idx <size/2){
             curr = head;
             for(int i=0; i< idx;i++) curr = curr.next;
         }else{
             curr =tail;
             for(int i=size-1; i>idx;i--) curr= curr.prev;
         }
         return curr;
    }
    public T getLast(){
        if(isEmpty()) throw new IllegalStateException("List is Empty");
        return tail.value;
    }
    public T getFirst(){
        if(isEmpty()) throw new IllegalStateException("List is Empty");
        return head.value;
    }

    public T get(int index){
        if(index <0 || index >=size) throw new IndexOutOfBoundsException("Invalid index: "+index);
        if(isEmpty())throw new IllegalStateException("List is empty");
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

    public int size(){ return size;}
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node it = head;
            @Override
            public boolean hasNext() {
                return it != null;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                T val = it.value;
                it = it.next;
                return val;
            }
        };
    }


}
