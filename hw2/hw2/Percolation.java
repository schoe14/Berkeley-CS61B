package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int len;
    private int top = 0;
    private int bottom;
    private WeightedQuickUnionUF uf;
    private int numOfOpened;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        len = N;
        grid = new boolean[N][N];
        bottom = N * N + 1;
        uf = new WeightedQuickUnionUF(N * N + 2);
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row > len - 1 || col < 0 || col > len - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (!isOpen(row, col)) {
            grid[row][col] = true;
            numOfOpened++;
            int opened = xyTo1D(row, col);
            int left;
            int right;
            int up;
            int down;
            if (row == 0) {
                uf.union(top, opened + 1);
            }
            // union (same row)
            if (col - 1 >= 0 && isOpen(row, col - 1)) {
                left = xyTo1D(row, col - 1);
                uf.union(opened + 1, left + 1);
                if (row == len - 1 && isFull(row, col - 1)) {
                    uf.union(bottom, opened + 1);
                }
            }
            if (col + 1 <= len - 1 && isOpen(row, col + 1)) {
                right = xyTo1D(row, col + 1);
                uf.union(opened + 1, right + 1);
                if (row == len - 1 && isFull(row, col + 1)) {
                    uf.union(bottom, opened + 1);
                }
            }
            // union (same column)
            if (row - 1 >= 0 && isOpen(row - 1, col)) {
                up = xyTo1D(row - 1, col);
                uf.union(opened + 1, up + 1);
                if (row == len - 1 && isFull(row - 1, col)) {
                    uf.union(bottom, opened + 1);
                }
            }
            if (row + 1 <= len - 1 && isOpen(row + 1, col)) {
                down = xyTo1D(row + 1, col);
                uf.union(opened + 1, down + 1);
            }
        }
    }

    // 2D array to 1D
    public int xyTo1D(int r, int c) {
        return len * r + c;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || row > len - 1 || col < 0 || col > len - 1) {
            throw new IndexOutOfBoundsException();
        }
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || row > len - 1 || col < 0 || col > len - 1) {
            throw new IndexOutOfBoundsException();
        }
        int to1D = xyTo1D(row, col) + 1;
        return uf.connected(top, to1D);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOfOpened;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    // use for unit testing (not required)
    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        p.open(1, 2);
        p.open(0, 1);
        System.out.println(p.isOpen(1, 1));
        System.out.println(p.isOpen(1, 2));
        System.out.println(p.isFull(1, 1));
        System.out.println(p.isFull(1, 2));
        System.out.println(p.numberOfOpenSites());
        System.out.println(p.percolates());
        p.open(2, 0);
        System.out.println(p.percolates());
        p.open(2, 1);
        System.out.println(p.percolates());
        System.out.println(p.numberOfOpenSites());
    }
}
