package lec16;

public class RotateRightSLList<item> extends SLList<item>{

    public void rotateRight() {
        item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotateRightSLList<Integer> rsl = new RotateRightSLList<>();
        rsl.addLast(1);
        rsl.addLast(2);
        rsl.addLast(3);
        rsl.addLast(4);

        rsl.rotateRight();
        rsl.print();
    }
}
