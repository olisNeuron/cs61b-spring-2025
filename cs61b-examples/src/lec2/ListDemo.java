package lec2;

import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> L = new LinkedList<>();
        L.add("a");
        L.add("b");
        L.add("c");
        String s = L.get(0);
        System.out.println(s);
    }
}
