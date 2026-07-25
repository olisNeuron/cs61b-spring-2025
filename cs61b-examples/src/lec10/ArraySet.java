package lec10;

import net.sf.saxon.functions.ConstantFunction;

import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contain(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {    //items[i] == item is not correct, == compares addresses of two space
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }

        if (contain(x)) {
            return;
        }

        items[size] = x;
        size += 1;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        ArraySetIterator() {
            wizPos = 0;
        }
        @Override
        public boolean hasNext() {
            if (wizPos < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T itemToReturn = items[wizPos];
            wizPos += 1;
            return itemToReturn;
        }
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(0);
        aset.add(1);
        aset.add(2);
        aset.add(3);

        Iterator<Integer> aseer = aset.iterator();
        while (aseer.hasNext()) {
            int i = aseer.next();
            System.out.println(i);
        }
    }
}
