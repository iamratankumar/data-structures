public class Stack<T> {

    private LinkedList<T> stackList;

    Stack(){
        stackList = new LinkedList<>();
    }

    void push(T value){
        stackList.addLast(value);
    }

    T pop() {
        if(stackList.isEmpty()) throw new IllegalStateException("Stack is Empty");
        T val = peek();
        stackList.removeLast();
        return val;
    }

    T peek(){
        if(stackList.isEmpty()) throw new IllegalStateException("Stack is Empty");
        return stackList.getLast();
    }
    T bottom(){
        if(stackList.isEmpty()) throw new IllegalStateException("Stack is Empty");
        return stackList.getFirst();
    }
    boolean isEmpty(){
        return stackList.isEmpty();
    }

    int size(){return stackList.size();}


}
