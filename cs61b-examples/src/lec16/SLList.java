package lec16;
import lec8.List61B;

public class SLList<item> implements List61B<item> {
    private class Node {
        public item item;
        public Node next;

        public Node(item i, Node n) {
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public SLList(item x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    @Override
    public void addFirst(item x) {
        size++;
        Node nextNode = sentinel.next;
        sentinel.next = new Node(x, nextNode);
    }

    @Override
    public void addLast(item x) {
        size++;
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
    }

    @Override
    public item getFirst() {
        return sentinel.next.item;
    }

    @Override
    public item getLast() {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public item get(int i) {
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
    public item removeLast() {
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
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }
}

