package lec9;

public class Dog implements Comparable<Dog> {
    String name;
    int size;

    public Dog(String n, int s)  {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog uddaDog) {
        if (size < uddaDog.size) {
            return -1;
        } else if (size > uddaDog.size) {
            return 1;
        }
        return 0;
    }
}
