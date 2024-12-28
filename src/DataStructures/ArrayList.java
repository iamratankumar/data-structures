package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements Iterable<T> {
    private T[] arr;
    private int size=0,capacity=0;

    public ArrayList(){
        this.capacity=4;
        arr = (T[]) new Object[capacity];
    }
    public ArrayList(int size){
        this.capacity = size;
        arr = (T[]) new Object[capacity];
    }
    ArrayList(T[] list){
        addAll(list);
    }
    void addAll(T[] list){
        for(T it : list){
            add(it);
        }
    }

    public void add(T item){
        resize();
        arr[size++] = item;
    }
    public void add(int index,T item){
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

    public T get(int index){
        if(index >=size || index <0) throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    public int indexOf(T item){
        for(int i=0;i<size; i++){
            if (arr[i].equals(item)) return i;
        }
        throw new NoSuchElementException("No such item: "+item);
    }

    public void replace(int index, T item){
        if(index <0 || index>=size) throw  new IndexOutOfBoundsException();
        arr[index] = item;
    }


    public int size(){
        return size;
    }

    private void resize(){
        if(size==capacity){
            capacity*=2;
            T[] tmp = (T[]) new Object[capacity];
            if (size >= 0) System.arraycopy(arr, 0, tmp, 0, size);
            arr = tmp;
        }
    }

    /*This method will reverse the array and save it.
    * This method will not return anything
    * */
    public void reverse(){
        T[] tmp = (T[]) new Object[size];

        for(int i=size-1,j=0;i>=0; i--,j++){
            tmp[j] = arr[i];
        }
        arr = tmp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i=0;
            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                return arr[i++];
            }
        };
    }


    @Override
    public String toString() {
        if(size ==0) return "[]";
        StringBuilder sb = new StringBuilder(size);
        for(T item: arr){
            if(item !=null)
                sb.append(String.format("%s ",item));
        }
        return String.format("[ %s]", sb.toString());
    }
}
