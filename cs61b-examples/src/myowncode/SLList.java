package myowncode;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentenel;
    private int size;

    public SLList(int x) {
        size++;
        sentenel = new IntNode(12345, null);
        sentenel.next = new IntNode(x, null);
    }

    public SLList() {
        sentenel = new IntNode(12345, null);
    }

    public void addFirst(int x) {
        size++;
        sentenel.next = new IntNode(x, sentenel.next);
    }

    public void addLast(int x) {
        size++;
        IntNode p = sentenel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int getFirst() {
        return sentenel.next.item;
    }

    public int getLast() {
        IntNode p = sentenel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    public int size() {
        return size;
    }
}
