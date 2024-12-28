package DataStructures.HashTable;

public abstract class HashMap<K,V>  implements HashMapInterface<K,V> {


    @Override
    public V get(K key) {
        return null;
    }

    protected static class Entry<K,V>{
        K key;
        V value;
        public Entry(K key,V value){
            this.key = key; this.value=value;
        }

        @SuppressWarnings("unchecked")
        public boolean equals(Object o){
            if(o instanceof Entry) return this.equals((Entry<K,V>)o);
            return false;
        }


        boolean equals(Entry<K,V> entry){
            return this.matches(entry.key);
        }
        boolean matches(K key){
            return this.key.equals(key);
        }
    }


}
