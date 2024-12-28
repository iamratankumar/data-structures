package DataStructures;

public class Queue<T> {
    LinkedList<T> queueList;

    Queue(){
        queueList = new LinkedList<>();
    }


    public void enqueue(T value){
        queueList.addLast(value);
    }
    public void dequeue(){
        if(queueList.isEmpty()) throw new IllegalStateException("DataStructures.Stack is Empty");
        queueList.removeFirst();
    }
    public T peek(){
        if(queueList.isEmpty()) throw new IllegalStateException("DataStructures.Stack is Empty");
        return queueList.getFirst();
    }
    public T rear(){
        if(queueList.isEmpty()) throw new IllegalStateException("DataStructures.Stack is Empty");
        return queueList.getLast();
    }
    public boolean isEmpty(){return queueList.isEmpty();}
    public int size(){return queueList.size();}

}
