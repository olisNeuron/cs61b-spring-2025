package lec8;

public interface List61B<item> {
    public void addFirst(item x);
    public void addLast(item x);
    public item getFirst();
    public item getLast();
    public item get(int i);
    public item removeLast();
    public int size();
    default public void print() {
        for (int i = 0; i < size();i+=1) {
            System.out.print(get(i) + " ");
        }
    }
}
