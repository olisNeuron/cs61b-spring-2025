package lec7.resize;

public class AList {
    private int size;
    private int[] item;

    public AList() {
        size = 0;
        item = new int[100];
    }

    private void resize(int capacity) {
        int[] newItem = new int[capacity];
        System.arraycopy(item, 0, newItem, 0, size);
        item = newItem;
    }

    public void addLast(int x) {
        if (size == item.length){
            resize(size + 1000);
        }
        item[size] = x;
        size += 1;
    }

    public int getLast() {
        return item[size-1];
    }

    public int get(int i) {
        if (i >= size) {
            throw new IllegalArgumentException();
        }
        return item[i];
    }

    public int removeLast() {
        int itemToReturn = getLast();
        size -= 1;
        return itemToReturn;
    }
}
