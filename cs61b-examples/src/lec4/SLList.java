package lec4;

public class SLList<Mustard> {
    private class IntNode {
        public Mustard item;
        public IntNode next;

        public IntNode(Mustard i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList(Mustard x) {
        sentinel = new IntNode(null, null);
        sentinel = new IntNode(x, sentinel);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public void addFirst(Mustard x) {
        size++;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public void addLast(Mustard x) {
        size++;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public Mustard getFirst() {
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
