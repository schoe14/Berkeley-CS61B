package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    int len;
    int exp;
    Percolation percolation;
    double[] percolatedArray;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        len = N;
        exp = T;
        percolatedArray = new double[T];

        for (int i = 0; i < T; i++) {
            percolation = pf.make(N);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(len), StdRandom.uniform(len));
            }
            percolatedArray[i] = percolation.numberOfOpenSites();
            System.out.println("numberOfOpenSites: " + percolation.numberOfOpenSites());
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percolatedArray);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (exp == 1) {
            return Double.NaN;
        }
        return StdStats.stddev(percolatedArray);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - 1.960 * (stddev() / Math.sqrt(exp));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.960 * (stddev() / Math.sqrt(exp));
    }

    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats ps = new PercolationStats(20, 30, pf);
        System.out.println("mean: " + ps.mean());
        System.out.println("stddev: " + ps.stddev());
        System.out.println("95% conf low: " + ps.confidenceLow());
        System.out.println("95% conf high: " + ps.confidenceHigh());
    }
}
