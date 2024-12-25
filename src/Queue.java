public class Queue<T> {
    LinkedList<T> queueList;

    Queue(){
        queueList = new LinkedList<>();
    }


    void enqueue(T value){
        queueList.addLast(value);
    }
    void dequeue(){
        if(queueList.isEmpty()) throw new IllegalStateException("Stack is Empty");
        queueList.removeFirst();
    }
    T peek(){
        if(queueList.isEmpty()) throw new IllegalStateException("Stack is Empty");
        return queueList.getFirst();
    }
    T rear(){
        if(queueList.isEmpty()) throw new IllegalStateException("Stack is Empty");
        return queueList.getLast();
    }
    boolean isEmpty(){return queueList.isEmpty();}
    int size(){return queueList.size();}

}
