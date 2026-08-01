package lec16;

public class VengefulSLList<item> extends SLList<item>{
    public SLList<item> deletedItem;

    public VengefulSLList() {
        super();
        deletedItem = new SLList<>();
    }

    public VengefulSLList(item x) {
        super(x);
        deletedItem = new SLList<>();
    }

    @Override
    public item removeLast() {
        item x = super.removeLast();
        deletedItem.addLast(x);
        return x;
    }

    public void printLostItem() {
        deletedItem.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs = new VengefulSLList<>(0);
        vs.addLast(1);
        vs.addLast(2);
        vs.addLast(3);
        vs.addLast(4);

        vs.removeLast();
        vs.removeLast();

        System.out.print("the fallen item was: ");
        vs.printLostItem();
    }
}
