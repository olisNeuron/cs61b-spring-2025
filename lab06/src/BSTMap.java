import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    public class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private int size;
    private Node root;

    private Node put(K key, V value, Node T) {
        if (T == null) {
            return new Node(key, value);
        }
        if (key.compareTo(T.key) > 0) {
            T.right = put(key, value, T.right);
        }
        else if (key.compareTo(T.key) < 0) {
            T.left = put(key, value, T.left);
        }
        return T;
    }

    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
        size += 1;
    }

    private V get(K key, Node T) {
        if (T == null) {
            return null;
        }
        if (key.compareTo(T.key) > 0) {
            return get(key, T.right);
        }
        else if (key.compareTo(T.key) < 0) {
            return get(key, T.left);
        }
        return T.value;
    }

    @Override
    public V get(K key) {
        return get(key, root);
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

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
