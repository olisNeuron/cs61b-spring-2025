package deque;

import net.sf.saxon.functions.ConstantFunction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedListDeque61B<T> implements Deque61B<T>{

    public class Node{
        public Node next;
        public T item;
        public Node prev;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public Node firstSenti;
    public Node lastSenti;
    public int size;

    public LinkedListDeque61B() {
        firstSenti = new Node(null, null, null);
        lastSenti = new Node(null, null, null);
        firstSenti.next = lastSenti;
        lastSenti.prev = firstSenti;
        size = 0;
    }

    public LinkedListDeque61B(T x) {
        firstSenti = new Node(null, null, null);
        lastSenti = new Node(null, null, null);
        firstSenti.next = lastSenti;
        lastSenti.prev = firstSenti;
        Node temp = new Node(firstSenti, x, lastSenti);
        size = 1;
    }

    @Override
    public void addFirst(T x) {
        Node temp = new Node(firstSenti, x, firstSenti.next);
        firstSenti.next.prev = temp;
        firstSenti.next = temp;
        size+=1;
    }

    @Override
    public void addLast(T x) {
        Node temp = new Node(lastSenti.prev, x, lastSenti);
        lastSenti.prev.next = temp;
        lastSenti.prev = temp;
        size+=1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = firstSenti.next;
        while (p.next != null) {
            returnList.add(p.item);
            p = p.next;
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
        Node removeNode  = firstSenti.next;
        if (removeNode == lastSenti) {
            return null;
        }
        firstSenti.next = removeNode.next;
        removeNode.next.prev = firstSenti;
        size-=1;
        return removeNode.item;
    }

    @Override
    public T removeLast() {
        Node removeNode = lastSenti.prev;
        if (removeNode == firstSenti) {
            return null;
        }
        lastSenti.prev = removeNode.prev;
        removeNode.prev.next = lastSenti;
        size-=1;
        return removeNode.item;
    }

    @Override
    public T get(int index) {
        Node p = firstSenti.next;
        for (int i = 0; i < index; i+=1) {
            if (p.next != null) {
                p = p.next;
            }
            else {
                return null;
            }
        }
        return p.item;
    }

    private T getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        if (p.next == lastSenti) {
            return null;
        }
        else {
            return getRecursiveHelper(index - 1, p.next);
        }
    }

    @Override
    public T getRecursive(int index) {
        return getRecursiveHelper(index, firstSenti.next);
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node p;

        LinkedListIterator() {
            p = firstSenti.next;
        }
        @Override
        public boolean hasNext() {
            return p.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T itemToReturn = p.item;
            p = p.next;
            return itemToReturn;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public boolean contain(T x) {
        Node p = firstSenti.next;
        for (int i = 0; i < size; i+=1) {
            if (p.item == x) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque61B uddaSet) {
            if (uddaSet.size() != this.size()) {
                return false;
            }
            for (T x : this) {
                if (!uddaSet.contain(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringReturn = new StringBuilder("{");
        for (T x : this) {
            stringReturn.append(x);
            stringReturn.append(",");
        }
        stringReturn.append("}");
        return stringReturn.toString();
    }
}
