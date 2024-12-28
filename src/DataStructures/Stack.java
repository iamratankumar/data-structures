package DataStructures;

public class Stack<T> {

    private LinkedList<T> stackList;

    public Stack(){
        stackList = new LinkedList<>();
    }

    public void push(T value){
        stackList.addLast(value);
    }

    public T pop() {
        if(stackList.isEmpty()) throw new IllegalStateException("DataStructures.Stack is Empty");
        T val = peek();
        stackList.removeLast();
        return val;
    }

    public T peek(){
        if(stackList.isEmpty()) throw new IllegalStateException("DataStructures.Stack is Empty");
        return stackList.getLast();
    }
    public T bottom(){
        if(stackList.isEmpty()) throw new IllegalStateException("DataStructures.Stack is Empty");
        return stackList.getFirst();
    }
    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    public int size(){return stackList.size();}


}
