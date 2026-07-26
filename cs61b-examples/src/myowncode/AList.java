package myowncode;

public class AList<T> {
    private int size;
    public T[] items;

    public AList() {
        size = 0;
        items = (T[]) new Object[100];
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(T x) {
        if(items.length == size) {
            resize(size + 1);
        }

        items[size] = x;
        size += 1;
    }

    public T getLast() {
        return items[size-1];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T x  = getLast();
        items[size-1] = null;
        size -= 1;
        return x;
    }
}
