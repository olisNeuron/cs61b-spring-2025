import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;


public class Percolation {
    // TODO: Add any necessary instance variables.
    private List<Integer> openBlock;
    private int[][] grid;

    //vitual blocks that point to bottom and top of the grid element
    private int topBlock = 9999;
    private int bottomBlock = 999;

    public Percolation(int N) {
        // TODO: Fill in this constructor.
        // list of open block
        openBlock = new ArrayList<>();

        //construct N*N grid
        grid = new int[N][N];
        int totalNum = 0;
        for (int i = 0; i < N; i+=1) {
            for (int j = 0; j < N; j+=1) {
                grid[i][j] = totalNum;
                totalNum += 1;
            }
        }

        //make topBlock and bottomBlock pointing to the top row and bottom row
        for (int i = 0; i < N; i+=1) {
            
        }
    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
        if (!openBlock.contains(grid[row][col])){
            openBlock.add(grid[row][col]);
        }
    }

    public boolean isOpen(int row, int col) {
        // TODO: Fill in this method.
        return openBlock.contains(grid[row][col]);
    }

    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        return false;
    }

    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        return 0;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return false;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}
