package lec8;
import javax.print.DocFlavor;

public class SLList<Mustard> implements List61B<Mustard>{
    private class Node {
        public Mustard item;
        public Node next;

        public Node(Mustard i, Node n) {
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public SLList(Mustard x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    @Override
    public void addFirst(Mustard x) {
        size++;
        sentinel.next = new Node(x, sentinel.next);
    }

    @Override
    public void addLast(Mustard x) {
        size++;
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
    }

    @Override
    public Mustard getFirst() {
        return sentinel.next.item;
    }

    @Override
    public Mustard getLast() {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public Mustard get(int i) {
        Node p = sentinel.next;
        for (int idx = 0;idx < i;idx++) {
            p = p.next;
        }
        return p.item;
    }

    public Node getLastNode() {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }
    @Override
    public Mustard removeLast() {
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }

        Node p = sentinel;

        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;
    }
    private int size(Node p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {
        Node p = sentinel.next;
        while (p.next != null) {
            p = p.next;
            System.out.print(p.item + " ");
        }
    }
}

