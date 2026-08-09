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

    public int size;
    private Node root;

//    public BSTMap() {
//        size = 0;
//        root = null;
//    }

    private Node put(K key, V value, Node T) {
        if (T == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(T.key);
        if (cmp > 0) {
            T.right = put(key, value, T.right);
        }
        else if (cmp < 0) {
            T.left = put(key, value, T.left);
        }
        else {
            T.value = value;
        }
        return T;
    }

    @Override
    public void put(K key, V value) {
        boolean isNew = !containsKey(key);
        root = put(key, value, root);
        if (isNew) {
            size += 1;
        }
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

    private boolean containsKey(K key, Node T) {
        if (T == null) {
            return false;
        }
        if (key.compareTo(T.key) > 0) {
            return containsKey(key, T.right);
        }
        else if (key.compareTo(T.key) < 0) {
            return containsKey(key, T.left);
        }
        return true;
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(key, root);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
//        return Set.of();
    }

    private Node findMin(Node T) {
        if (T.left != null) {
            return findMin(T.left);
        }
        return T;
    }

     private Node remove(K key, Node T) {
        int cmp = key.compareTo(T.key);
        if (cmp > 0) {
            T.right = remove(key, T.right);
        }
        else if (cmp < 0) {
            T.left = remove(key, T.left);
        }
        else {
            if (T.left == null) {
                return T.right;
            } else if (T.right == null) {
                return T.left;
            }
            Node min = findMin(T.right);
            T.key = min.key;
            T.value = min.value;
            T.right = remove(min.key,T.right);
        }
         return T;
    }

    @Override
    public V remove(K key) {
        boolean doesExist = containsKey(key);
        if (!doesExist) {
            return null;
        }
        V value = get(key);
        root = remove(key, root);
        size -= 1;
        return value;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
