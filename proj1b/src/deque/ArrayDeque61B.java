package deque;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private int size;
    public T[] items;
    public int nextFirst = 0;
    public int nextLast = 1;

    public ArrayDeque61B() {
        size = 0;
        items = (T[]) new Object[100];
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size + 1);
        }
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        items[nextFirst] = x;
        nextFirst -= 1;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(size + 1);
        }
        if (nextLast > items.length - 1) {
            nextLast = 0;
        }
        items[nextLast] = x;
        nextLast += 1;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size; i += 1) {
            returnList.add(items[i]);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
