package exercicesTwo.exercise6;

import exercicesTwo.exercise4.MyHashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

/**
 * Create a resizable generic HashMap. When the number of entries exceeds (load capacity * bucket array size)
 * the HashMap needs to be resized.
 *
 * Resizing (rehashing) consists in increasing the size of the bucket array with the value of
 * INCREASE_SIZE_FACTOR. After this step, all the entries that were stored in the HashMap
 * must be inserted in the new bucket array according to the insertion algorithm in a HashMap:
 * the entry must be placed in a bucket after applying the hash function (hashcode modulo (bucket array size))
 * on the key's hashcode value. The result of the hash function will return the index from the
 * bucket array where the entry will be stored. (see HashMap documentation)
 *

 */
public class MyResizableHashMap<K, V> {

    /**
     * The array of buckets.
     */
    private ArrayList<LinkedList<MyEntry>> buckets;

    /**
     * Default initial capacity for the bucket array.
     */
    private final int DEFAULT_BUCKET_ARRAY_SIZE = 16;

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * The number of entries stored in the Map.
     */
    private int size;

    //used to persist value for null key.
    private String nullKey;

    public MyResizableHashMap() {
        init();
        // TODO Initialize buckets list
    }

    private void init() {
        buckets=new ArrayList<>(DEFAULT_BUCKET_ARRAY_SIZE);
        // TODO Initialize buckets list.
        //You must keep in mind that the information is added to the buckets depending on the key hash.
        // You should look in getIndex (key) method

    }

    private void resize() {
        // TODO function that does the rehashing of the HashMap
    }

    public V get(K key) {
        // TODO
        return null;
    }

    public void put(K key, V value) {
        // TODO
    }

    public Set<K> keySet() {
        // TODO
        return null;
    }

    public Collection<V> values() {
        // TODO
        return null;
    }

    public V remove(K key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        return null;
    }

    public boolean containsKey(K key) {
        // TODO
        return false;
    }

    public boolean containsValue(V value) {
        // TODO
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        return 0;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        return null;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    /**
     * This method is used to select the bucket index based on the key
     * @param key - the key
     * @return - the selected bucket based on the key
     */
    private int getIndex(String key){
        int hash = hash(key);
        int n, i;
        n=buckets.size();
        i=(n-1)&hash;
        return i;
    }

    /**
     * This method is used to calculate the key hash
     * @param key - value of the key
     * @return - the key value hash
     */
    private static int hash(String key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public static class MyEntry<K, V> {
        private K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
