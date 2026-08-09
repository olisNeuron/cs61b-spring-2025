package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private static final double DEFAULT_FACTOR = 0.75;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size;
    private double loadFactor;
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_FACTOR);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_FACTOR);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor maximum load factor
     */
    public MyHashMap(int initialCapacity, double loadFactor) {
        buckets = new Collection[initialCapacity];
        for (int i = 0; i < initialCapacity; i+=1) {
            buckets[i] = createBucket();
        }
        this.loadFactor = loadFactor;
        size = 0;
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *  Note that this is referring to the hash table bucket itself,
     *  not the hash map itself.
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        // TODO: Fill in this method.
        return new LinkedList<>();
    }

    private int hashIndex(K key) {
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

    @Override
    public void put(K key, V value) {
        int keyHashIndex = hashIndex(key);
        for (Node x : buckets[keyHashIndex]) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        buckets[keyHashIndex].add(new Node(key, value));
        size += 1;

        double factor = (double) size / buckets.length;
        if (factor > loadFactor) {
            // traversal and store all node from original list
            LinkedList<Node> nodeList = new LinkedList<>();
            LinkedList<Integer> hashIndexList = new LinkedList<>();
            for (int j = 0; j < buckets.length; j+=1) {
                for (Node x : buckets[j]){
                    nodeList.add(x);
                }
            }

            // create new resizing list and reput node
            buckets = new Collection[buckets.length*2];
            for (Node x : nodeList) {
                hashIndexList.add(hashIndex(x.key));
            }
            for (int i = 0; i < buckets.length; i+=1) {
                buckets[i] = createBucket();
            }
            for (int i = 0; i < hashIndexList.size();i+=1) {
                buckets[hashIndexList.get(i)].add(nodeList.get(i));
            }
        }
    }

    @Override
    public V get(K key) {
        int keyHashIndex = hashIndex(key);
        for (Node x : buckets[keyHashIndex]) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        if (get(key) == null) {
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for
    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

}
