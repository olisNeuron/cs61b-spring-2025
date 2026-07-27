package deque;

import java.util.ArrayList;
import java.util.Arrays;
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

    public ArrayDeque61B(T x) {
        size = 0;
        items = (T[]) new Object[100];
        items[nextFirst] = x;
        nextFirst -= 1;
        size += 1;
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i+=1) {
            a[i] = get(i);
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
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
            returnList.add(items[Math.floorMod(nextFirst+1+i, items.length)]);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        if (nextFirst == items.length-1) {
            T returnItem = items[0];
            items[0] = null;
            nextFirst = 0;
            return returnItem;
        }
        T returnItem = items[nextFirst+1];
        items[nextFirst+1] = null;
        nextFirst += 1;
        return returnItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        if (nextLast == 0) {
            T returnItem = items[items.length-1];
            items[items.length-1] = null;
            nextLast = items.length - 1;
            return returnItem;
        }
        T returnItem = items[nextLast-1];
        items[nextLast-1] = null;
        nextLast -= 1;
        return returnItem;
    }

    @Override
    public T get(int index) {
        return items[Math.floorMod(nextFirst+1+index, items.length)];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }
}
