import java.util.NoSuchElementException;

public class ArrayList<T> {
    private T arr[];
    private int size=0,capacity=0;

    public ArrayList(){
        this.capacity=4;
        arr = (T[]) new Object[capacity];
    }
    public ArrayList(int size){
        this.capacity = size;
        arr = (T[]) new Object[capacity];
    }
    public ArrayList(T[] list){

    }

    void add(T item){
        resize();
        arr[size++] = item;
    }
    void add(int index,T item){
        if( index >size) throw new IndexOutOfBoundsException("invalid index value: "+index);
        resize();
        T iloc=null;
        if(index == size){
            arr[size++] = item;
            return;
        }
        for(int i=0; i<=size;i++){
            if(i == index){
                iloc= arr[i];
                arr[i]= item;
            }else if(i>index){
                T tmp = iloc;
                iloc= arr[i];
                arr[i] =tmp;
            }
        }
    }

    T get(int index){
        if(index >=size || index <0) throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    int indexOf(T item){
        for(int i=0;i<size; i++){
            if (arr[i].equals(item)) return i;
        }
        throw new NoSuchElementException("No such item: "+item);
    }

    void replace(int index, T item){
        if(index <0 || index>=size) throw  new IndexOutOfBoundsException();
        arr[index] = item;
    }

    int size(){
        return size;
    }

    private void resize(){
        if(size==capacity){
            capacity*=2;
            T[] tmp = (T[]) new Object[capacity];
            for(int i=0; i<size; i++){
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
    }

}