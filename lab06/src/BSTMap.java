import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    public class BST {
        public K key;
        public V value;
        public BST left;
        public BST right;

        public BST(K k, V v) {
            key = k;
            value = v;
        }
    }

    private BST root;

    private BST put(K key, V value, BST root) {
        if (root == null) {
            return new BST(key, value);
        }
        else (value > )
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
