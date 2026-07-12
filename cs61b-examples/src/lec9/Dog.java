package lec9;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    String name;
    int size;

    public Dog(String n, int s)  {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog uddaDog) {
        return size - uddaDog.size;
    }

    public static class nameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }
}
