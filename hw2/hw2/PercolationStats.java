package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    int len;
    int exp;
    Percolation percolation;
    int[] percolatedArray;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        len = N;
        exp = 1;
        percolation = pf.make(N);
        percolatedArray = new int[T];

        while (exp <= T) {
            int numOfExp = StdRandom.uniform(N * N);
            for (int i = 0; i < numOfExp; i++) {
                percolation.open(StdRandom.uniform(len), StdRandom.uniform(len));
            }
            if (percolation.percolates()) {
                percolatedArray[exp - 1] = percolation.numberOfOpenSites();
            }
            percolatedArray[exp - 1] = 0;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percolatedArray);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0.0;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return 0.0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return 0.0;
    }
}
