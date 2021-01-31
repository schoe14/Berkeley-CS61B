package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int len;
    private int top = 0;
    private int bottom;
    private WeightedQuickUnionUF uf;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        len = N;
        grid = new boolean[N][N];
        bottom = N * N + 1;
        uf = new WeightedQuickUnionUF(N * N + 2);
        int i = 1;
        while (i <= N) {
            uf.union(top, i);
            uf.union(bottom, bottom - i);
            i++;
        }
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row > len - 1 || col < 0 || col > len - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (!isOpen(row, col)) {
            grid[row][col] = true;
        }
        // need to work on it
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
        return uf.find(to1D) == top;
    }

    // number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // use for unit testing (not required)
    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        System.out.println(p.isOpen(0,2));
        System.out.println(p.isFull(1,1));
    }
}
