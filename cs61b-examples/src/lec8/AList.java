package lec8;

public class AList<Muster> {
    private int size;
    private Muster[] item;

    public AList() {
        size = 0;
        item = (Muster[]) new Object[100];
    }

    private void resize(int capacity) {
        Muster[] newItem = (Muster[]) new Object[capacity];
        System.arraycopy(item, 0, newItem, 0, size);
        item = newItem;
    }

    public void addLast(Muster x) {
        if (size == item.length){
            resize(size + 1000);
        }
        item[size] = x;
        size += 1;
    }

    public Muster getLast() {
        return item[size-1];
    }

    public Muster get(int i) {
        if (i >= size) {
            throw new IllegalArgumentException();
        }
        return item[i];
    }

    public int size(){
        return size;
    }

    public Muster removeLast() {
        Muster itemToReturn = getLast();
        size -= 1;
        return itemToReturn;
    }
}
