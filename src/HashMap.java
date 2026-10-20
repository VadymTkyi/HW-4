public class HashMap<K,V> {
    private Entry<K,V>[] buckets;
    private int size;
    private int capacity;

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
