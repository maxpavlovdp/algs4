package edu.princeton.cs.algs4;

/**
 * Created by Maksym Pavlov on 3/2/17.
 */
public class PercolationStats {
    private int n;
    private int t;
    private int[] openSitesWhenPercolates = null;
    private double mean;
    private double stddev;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        this.n = n;
        this.t = trials;
    }

    // sample mean of percolation threshold
    public double mean() {
        if (openSitesWhenPercolates == null) openSitesWhenPercolates = openSitesWhenPercolates();

        this.mean = StdStats.mean(openSitesWhenPercolates) / (n * n);
        return mean;
    }

    private int[] openSitesWhenPercolates() {
        int[] openSitesWhenPercolates = new int[t];
        Percolation perc;
        for (int i = 0; i < t; i++) {
            perc = new Percolation(n);
            while (!perc.percolates()) {
                int[] siteCoord = {StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1)};
                if (!perc.isOpen(siteCoord[0], siteCoord[1])) perc.open(siteCoord[0], siteCoord[1]);
            }
            openSitesWhenPercolates[i] = perc.numberOfOpenSites();
        }
        return openSitesWhenPercolates;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (openSitesWhenPercolates == null) openSitesWhenPercolates = openSitesWhenPercolates();
        this.stddev = StdStats.stddev(openSitesWhenPercolates) / (n * n);

        return this.stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        if (stddev == 0.0) stddev();
        if (mean == 0.0) mean();

        return mean - confidencePart();

    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        if (stddev == 0.0) stddev();
        if (mean == 0.0) mean();

        return mean + confidencePart();
    }

    private double confidencePart() {
        return 1.96 * stddev / Math.sqrt(t);
    }

    // test client (described below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        System.out.println("N: " + n + ", T: " + t);

        PercolationStats ps = new PercolationStats(n, t);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stdev                   = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
