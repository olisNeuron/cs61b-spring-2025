package lec8;

public class AList<Muster> implements List61B<Muster>{
    private int size;
    private Muster[] items;

    public AList() {
        size = 0;
        items = (Muster[]) new Object[100];
    }

    private void resize(int capacity) {
        Muster[] newItem = (Muster[]) new Object[capacity];
        System.arraycopy(items, 0, newItem, 0, size);
        items = newItem;
    }

    public void addLast(Muster x) {
        if (size == items.length){
            resize(size + 1000);
        }
        items[size] = x;
        size += 1;
    }

    public void addFirst(Muster x) {
        insert(0, x);
    }

    public Muster getLast() {
        return items[size-1];
    }

    public Muster getFirst() {
        return get(0);
    }

    public Muster get(int i) {
        return items[i];
    }

    public void insert(int position, Muster x) {
        Muster[] newItems = (Muster[]) new Object[items.length + 1];

        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = x;

        System.arraycopy(items, position, newItems, position + 1, items.length - position);
        items = newItems;
    }

    public Muster removeLast() {
        Muster itemToReturn = getLast();
        size -= 1;
        return itemToReturn;
    }

    public int size(){
        return size;
    }
}
