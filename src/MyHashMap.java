import java.security.Key;

public class MyHashMap<K,V> {
    private Entry<K,V>[] buckets;
    private int size = 0;
    private int capacity;


    public MyHashMap(int capacity){
        this.capacity = capacity;
        buckets = new Entry[capacity];
    }
    public void put(K key,V value){
       int index = getIndex(key);
       Entry<K,V> current = buckets[index];
       if (current == null){
           buckets[index] = new Entry<>(key,value);
           size++;
           return;
       }
       while (current != null){
           if (current.key.equals(key)){
               current.value = value;
               return;
           }
           if (current.next == null){
               current.next = new Entry<>(key,value);
               size++;
               return;
           }
           current = current.next;
       }
    }
    public void remove(K key){
        int index = getIndex(key);
        Entry<K,V> previous = null;
        Entry<K,V> current = buckets[index];
        while (current !=null){
            if (current.key.equals(key)){
                if (previous == null){
                    buckets[index] = current.next;
                }
                else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }



    }
    public V get(K key){
        int index = getIndex(key);

        Entry<K,V> current = buckets[index];

        while (current!=null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int index = getIndex(key);

        Entry<K,V> current = buckets[index];

        while (current!=null){
            if (current.key.equals(key)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    private int getIndex( K key){
        return Math.floorMod(key.hashCode(), capacity);
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    private static class Entry<K,V>{
        K key;
        V value;
        private Entry<K,V> next;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}