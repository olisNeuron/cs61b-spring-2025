package game2048logic;

import game2048rendering.Side;
import static game2048logic.MatrixUtils.rotateLeft;
import static game2048logic.MatrixUtils.rotateRight;

/**
 * @author  Josh Hug
 */
public class GameLogic {
    /** Moves the given tile up as far as possible, subject to the minR constraint.
     *
     * @param board the current state of the board
     * @param r     the row number of the tile to move up
     * @param c -   the column number of the tile to move up
     * @param minR  the minimum row number that the tile can land in, e.g.
     *              if minR is 2, the moving tile should move no higher than row 2.
     * @return      if there is a merge, returns the 1 + the row number where the merge occurred.
     *              if no merge occurs, then return 0.
     */
    public static int moveTileUpAsFarAsPossible(int[][] board, int r, int c, int minR) {
        // TODO: Fill this in in tasks 2, 3, 4
        int val = board[r][c];
        int targetRow = -1;

        if (val == 0) {
            return 0;
        }

        for (int i = r - 1;i >= minR;i--) {
            if (board[i][c] != 0) {
                if (board[i][c] != board[r][c]) {
                    targetRow = i + 1;
                }
                else {
                    targetRow = i;
                }
                break;
            }
        }

        if (targetRow == -1) {
            targetRow = minR;
        }
        if (targetRow == r) {
            return 0;
        }

        if (board[targetRow][c] != board[r][c]) {
            board[targetRow][c] = board[r][c];
            board[r][c] = 0;
            return 0;
        }
        else {
            board[targetRow][c] = 2 * board[r][c];
            board[r][c] = 0;
            return 1 + targetRow;
        }
    }

    /**
     * Modifies the board to simulate the process of tilting column c
     * upwards.
     *
     * @param board     the current state of the board
     * @param c         the column to tilt up.
     */
    public static void tiltColumn(int[][] board, int c) {
        // TODO: fill this in in task 5
        int idx = 0;
        int[] temp = new int[4];

        //{2,2,4,0} -> {0,2,2,4}
        for (int i = 0;i < 4;i++) {
            if (board[i][c] != 0) {
                temp[idx++] = board[i][c];
            }
        }

        //{0,2,2,4} -> {0,4,0,4}
        for (int i = 0;i < 3;i++) {
            if (temp[i] == temp[i+1] && temp[i] != 0) {
                temp[i] *= 2;
                temp[i+1] = 0;
            }
        }

        //{0,4,0,4} -> {0,0,4,4}
        idx = 0;
        for (int i = 0;i < 4;i++) {
            if (temp[i] != 0) {
                board[idx++][c] = temp[i];
            }
        }

        while (idx < 4) {
            board[idx++][c] = 0;
        }
    }

    /**
     * Modifies the board to simulate tilting all columns upwards.
     *
     * @param board     the current state of the board.
     */
    public static void tiltUp(int[][] board) {
        // TODO: fill this in in task 6
        tiltColumn(board, 0);
        tiltColumn(board, 1);
        tiltColumn(board, 2);
        tiltColumn(board, 3);
        return;
    }

    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    public static void tilt(int[][] board, Side side) {
        // TODO: fill this in in task 7
        if (side == Side.EAST) {
            rotateLeft(board);
            tiltUp(board);
            rotateRight(board);
            return;
        } else if (side == Side.WEST) {
            rotateRight(board);
            tiltUp(board);
            rotateLeft(board);
            return;
        } else if (side == Side.SOUTH) {
            rotateRight(board);
            rotateRight(board);
            tiltUp(board);
            rotateLeft(board);
            rotateLeft(board);
            return;
        } else {
            tiltUp(board);
            return;
        }
    }
}
