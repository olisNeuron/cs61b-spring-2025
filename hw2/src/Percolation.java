import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.apache.bcel.generic.ATHROW;

public class Percolation {
    // TODO: Add any necessary instance variables.
    public boolean[][] siteArray;
    public WeightedQuickUnionUF uf;

    public Percolation(int N) {
        // TODO: Fill in this constructor.
        siteArray = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N);
    }

    public int transform(int row, int col) {
        return row*(siteArray.length)+col;
    }

    public void connectNeighbor(int row, int col) {
        int[][] checkArray = {{0, 1},{1, 0},{-1, 0},{0, -1}};
        for (int[] ca : checkArray) {
            int r = row-ca[0];
            int c = col-ca[1];

            if (isOpen(r, c)) {
                uf.union(
                        transform(row, col),
                        transform(r, c)
                );
            }
        }
    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
        siteArray[row][col] = true;
        connectNeighbor(row, col);
    }

    public boolean isOpen(int row, int col) {
        // TODO: Fill in this method.
        if (row < 0 || row >= siteArray.length || col < 0 || col >= siteArray.length) {
            return false;
        }
        return siteArray[row][col];
    }

    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        if (!isOpen(row, col)) {
            return false;
        }
        for (int i = 0; i < siteArray.length; i++) {
            if (uf.connected(transform(0, i), transform(row, col))) {
                return true;
            }
        }
        return false;
    }

    public int numberOfOpenSites() {
//        // TODO: Fill in this method.
//        int totalNum = 0;
//        for (boolean[] sa : siteArray) {
//            for (boolean saInside : sa) {
//                totalNum += 1;
//            }
//        }
        return 0;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return false;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}
