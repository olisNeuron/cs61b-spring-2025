package lec8;

import org.checkerframework.checker.units.qual.A;

public class IsADemo {
    public static void main(String[] args) {
        List61B<String> someList = new AList<>();
        someList.addFirst("elk");
        someList.addLast("dwell");
        someList.addLast("on");
        someList.addLast("existential");
        someList.addLast("crises");
    }
}