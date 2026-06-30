package lec2;

public class MinIndex {
    public static int minIndex(int[] number) {
        if (number.length == 0) {
            throw new IllegalArgumentException("there are no elements!");
        }
        int m = number[0];
        int idx = 0;
        for (int i = 0; i < number.length;i++) {
            if (number[i] < m) {
                m = number[i];
                idx = i;
            }
        }
        return idx;
    }
}
