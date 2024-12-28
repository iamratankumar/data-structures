package DataStructures.HashTable;

public interface HashMapInterface<K,V> {


    boolean contains(K key);

    V get(K key);

    int put(K key, V value);

    int size();

}
