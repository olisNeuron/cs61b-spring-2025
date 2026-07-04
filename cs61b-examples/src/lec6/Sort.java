package lec6;

public class Sort {
    public static void sort(String[] x) {
        int smallest = findSmallest(x);
        swap(x, 0, 1);
        return;
    }

    public static int findSmallest(String[] x) {
        int smallest = 0;
        for (int i = 1;i < x.length;i++) {
            int cmp = x[i].compareTo(x[smallest]);
            if (cmp < 0) {
                smallest = i;
            }
        }
        return smallest;
    }
    public static void swap(String[] x,int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
