package exercicesTwo.exercise4;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 * <p>
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function is implemented below
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;
    //used to persist value for null key.
    private String nullKeyValue;

    //size of entries. You should increment and decrease the size whenever the entries change
    private int size = 0;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {
        init();
    }

    private void init() {
        buckets = new ArrayList<>(BUCKET_ARRAY_SIZE);
        nullKeyValue = null;
        size = 0;
        for (int i = 0; i < BUCKET_ARRAY_SIZE; i++) {
            buckets.add(i, new LinkedList<>());

        }

    }

    public String get(String key) {
        int idx = getIndex(key);
        LinkedList<MyEntry> bucket = buckets.get(idx);
        for (MyEntry myEntry : bucket) {
            if (myEntry.getKey().equals(key)) {
                return myEntry.getValue();
            }
        }
        // TODO
        return null;
    }

    public void put(String key, String value) {
        if (key == null) {
            if (nullKeyValue == null) {
                size++;
            }
            nullKeyValue = value;
            return;
        }
        int idx = getIndex(key);
        LinkedList<MyEntry> bucket = buckets.get(idx);


        //replacing value
        for (MyEntry myEntry : bucket) {
            if (myEntry.getKey().equals(key)) {
                myEntry.setValue(value);
                return;
            }
        }

        //adding new entry
        bucket.add(new MyEntry(key, value));
        size++;
    }

    public Set<String> keySet() {
        Set<String> ret = new HashSet<>();
        if (nullKeyValue != null) {
            ret.add(null);
        }
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                ret.add(myEntry.getKey());
            }
        }

        return ret;
    }

    public Collection<String> values() {
        Collection<String> ret = new ArrayList<>();
        if (nullKeyValue != null) {
            ret.add(nullKeyValue);
        }
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                ret.add(myEntry.getValue());
            }
        }

        return ret;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        if (key == null) {
            String ret = nullKeyValue;
            nullKeyValue = null;
            size--;
            return ret;
        }
        int bucketIdx = getIndex(key);
        LinkedList<MyEntry> bucket = buckets.get(bucketIdx);

        if (!this.containsKey(key)) {
            return null;
        }

        int i;
        for (i = 0; i < bucket.size(); i++) {
            MyEntry myEntry = bucket.get(i);
            if (myEntry.getKey().equals(key)) {
                break;
            }
        }
        String value = bucket.get(i).value;
        bucket.remove(i);
        size--;
        return value;
    }

    public boolean containsKey(String key) {
        if (key == null) {
            return nullKeyValue != null;
        }
        int bucketIdx = getIndex(key);
        LinkedList<MyEntry> bucket = buckets.get(bucketIdx);
        return bucket.contains(new MyEntry(key, null));

    }

    public boolean containsValue(String value) {
        if (nullKeyValue != null && nullKeyValue.equals(value)) {
            return true;
        }
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                if (myEntry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        return size;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        init();


    }

    public Set<MyEntry> entrySet() {
        Set<MyEntry> ret = new HashSet<>();
        for (LinkedList<MyEntry> bucket : buckets) {

            ret.addAll(bucket);
        }
        // TODO Return a Set containing all the Entry objects
        return ret;
    }

    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    /**
     * This method is used to select the bucket index based on the key
     *
     * @param key - the key
     * @return - the selected bucket based on the key
     */
    private int getIndex(String key) {
        int hash = hash(key);
        int n, i;
        int size = buckets.size();
        n = size == 0 ? BUCKET_ARRAY_SIZE : size;
        i = (n - 1) & hash;
        return i;
    }

    /**
     * This method is used to calculate the key hash
     *
     * @param key - value of the key
     * @return - the key value hash
     */
    private static int hash(String key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * This class is used to store value key inputs
     */
    public static class MyEntry {
        //the key
        private String key;
        //the associated value
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyEntry myEntry = (MyEntry) o;
            return Objects.equals(key, myEntry.key);
        }

        @Override
        public int hashCode() {

            return Objects.hash(key);
        }
    }
}
