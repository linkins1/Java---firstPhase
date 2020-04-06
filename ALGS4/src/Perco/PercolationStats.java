package Perco;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private static double[] exe;
    private static double MEAN = 0;
    private static double DEV = 0;
    private static double LO = 0;
    private static double HI = 0;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        exe = new double[trials];

    }

    // sample mean of percolation threshold
    public double mean() {

        return MEAN;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {

        return DEV;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return LO;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return HI;
    }

    // test client (see below)
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int exeTimes = Integer.parseInt(args[1]);
        PercolationStats p = new PercolationStats(N, exeTimes);
        Percolation[] percolation = new Percolation[exeTimes];
        for (int i = 0; i < exeTimes; i++) {
            percolation[i]=new Percolation(N);
            boolean b = true;
            double elapseTime;
            Stopwatch stopwatch = new Stopwatch();
            while (b) {
                int row1 = StdRandom.uniform(1, N + 1);
                int col1 = StdRandom.uniform(1, N + 1);
                percolation[i].open(row1, col1);

                if (percolation[i].percolates()) {
                    b = false;
                    int pNum = percolation[i].numberOfOpenSites();
                    exe[i] = (double) pNum / (double) (N * N);
                    elapseTime = stopwatch.elapsedTime();
                    System.out.println(elapseTime);
                }
            }
        }
        MEAN = StdStats.mean(exe);
        DEV = StdStats.stddev(exe);
        LO=MEAN - 1.96 * Math.sqrt(DEV / exe.length);
        HI=MEAN + 1.96 * Math.sqrt(DEV / exe.length);
        System.out.println("mean                                     = " + p.mean());
        System.out.println("stddev                                   = " + p.stddev());
        System.out.println("95% confidence interval                  = " + "[" + p.confidenceLo() + ", " + p.confidenceHi() + "]");
    }
}
