import java.util.ArrayList;
import java.util.List;

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

    }

    @Override
    public T removeLast() {
        return null;
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
}
