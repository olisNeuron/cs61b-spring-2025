package lec3;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int myGet(int index) {
        int num = 0;
        int count = 0;
        IntList p = this;
        while (p != null) {
            if (count == index) {
                num = p.first;
            }
            count += 1;
            p = p.rest;
        }
        return num;
    }

    public int get(int i) {
        if (i == 0) {
            return this.first;
        }
        return this.rest.get(i - 1);
    }

    public int iterationSize() {
        int totalItertation = 0;
        IntList p = this;
        while (p != null) {
            totalItertation += 1;
            p = p.rest;
        }
        return totalItertation;
    }

    public static void main(String[] args) {
        IntList L = new IntList(123,null);
        L = new IntList(456,L);
        L = new IntList(789,L);
        L = new IntList(10,L);
        System.out.println(L.myGet(0) + " " + L.myGet(1) + " " + L.myGet(2) + " " + L.myGet(3));
        System.out.print(L.get(0) + " " + L.get(1) + " " + L.get(2) + " " + L.get(3));
    }
}
