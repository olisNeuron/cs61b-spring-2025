package lec7.speedtest;

import lec7.resize.AList;
import org.apache.bcel.generic.NEW;

public class ALListRunTime {
    public static void main(String[] args) {
        long runTime = System.currentTimeMillis();
        AList L = new AList();
        int i = 0;
        while (i <= 100000) {
            L.addLast(i);
            i += 1;
        }
    }
}
