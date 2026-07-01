package lec4;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList(int x) {
        sentinel = new IntNode(12345, null);
        sentinel = new IntNode(x, sentinel);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(12345, null);
        size = 0;
    }

    public void addFirst(int x) {
        size++;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public void addLast(int x) {
        size++;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    private int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size() {
        return size;
    }
}
