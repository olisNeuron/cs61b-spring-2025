import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.apache.bcel.generic.ATHROW;

public class Percolation {
    // TODO: Add any necessary instance variables.
    private boolean[][] siteArray;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufFull;
    public int topSite;
    public int bottomSite;

    public Percolation(int N) {
        // TODO: Fill in this constructor.
        siteArray = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N + 2);
        ufFull = new WeightedQuickUnionUF(N * N + 1);
        topSite = N*N;
        bottomSite = N*N+1;

        for (int i = 0; i < N; i += 1) {
            uf.union(transform(0, i), topSite);
            uf.union(transform(N-1, i), bottomSite);
            ufFull.union(transform(0, i), topSite);
        }
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
                ufFull.union(
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
        if (ufFull.connected(transform(row,col),topSite)){
            return true;
        }
        return false;
    }

    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        int totalNum = 0;
        for (boolean[] sa : siteArray) {
            for (boolean saInside : sa) {
                if (saInside) {
                    totalNum += 1;
                }
            }
        }
        return totalNum;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return uf.connected(topSite, bottomSite);
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}
