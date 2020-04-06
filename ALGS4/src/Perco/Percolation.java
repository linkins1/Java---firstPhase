package Perco;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] a;
    private WeightedQuickUnionUF quickFindUF1;
    private WeightedQuickUnionUF quickFindUF2;
    private int count;
    // creates n-by-n grid, with all sites initially blocked

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        quickFindUF1 = new WeightedQuickUnionUF(n * n + 2);
        quickFindUF2 = new WeightedQuickUnionUF(n * n + 2);
        a = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = false;
            }
        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > a.length || row <= 0 || col > a.length || col <= 0)
            throw new IllegalArgumentException();

        if (!a[row - 1][col - 1]) {
            a[row - 1][col - 1] = true;
            count++;
            if (row == 1) {
                quickFindUF1.union(0, col - 1);
                quickFindUF2.union(0, col - 1);
            }

            int row1_1 = row - 2;
            int col1_1 = col - 2;
            if (row1_1 >= 0)
                if (a[row1_1][col - 1]) {
                    quickFindUF1.union((row - 1) * a.length + (col - 1), row1_1 * a.length + (col - 1));
                    quickFindUF2.union((row - 1) * a.length + (col - 1), row1_1 * a.length + (col - 1));
                }

            if (col1_1 >= 0)
                if (a[row - 1][col1_1]) {
                    quickFindUF1.union((row - 1) * a.length + (col - 1), (row - 1) * a.length + col1_1);
                    quickFindUF2.union((row - 1) * a.length + (col - 1), (row - 1) * a.length + col1_1);
                }

            if (col < a.length)
                if (a[row - 1][col]) {
                    quickFindUF1.union((row - 1) * a.length + (col - 1), (row - 1) * a.length + col);
                    quickFindUF2.union((row - 1) * a.length + (col - 1), (row - 1) * a.length + col);
                }
            if (row < a.length)
                if (a[row][col - 1]) {
                    quickFindUF1.union((row - 1) * a.length + (col - 1), row * a.length + (col - 1));
                    quickFindUF2.union((row - 1) * a.length + (col - 1), row * a.length + (col - 1));

                }
            if (row == a.length)
                quickFindUF1.union((row - 1) * a.length + (col - 1), a.length * a.length + 1);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row > a.length || row <= 0 || col > a.length || col <= 0)
            throw new IllegalArgumentException();
        return a[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > a.length || row <= 0 || col > a.length || col <= 0)
            throw new IllegalArgumentException();
        if(isOpen(row,col))
        return (quickFindUF2.find(0) == quickFindUF2.find((row - 1) * a.length + col - 1));
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return (quickFindUF1.find(0) == quickFindUF1.find(a.length * a.length + 1));
    }

}
