import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

  private static final double CONFIDENCE_95 = 1.96;
  private final double[] thresholds;
  private final int size;
  private final double mean;
  private final double stddev;

  // perform independent trials on an n-by-n grid
  public PercolationStats(int n, int trials) {
    if (n < 1 || trials < 1) {
      throw new IllegalArgumentException();
    }
    size = n;
    thresholds = new double[trials];
    Percolation p;
    for (int i = 0; i < trials; i++) {
    p = new Percolation(n);
      thresholds[i] = runTrial(p);
    }
    mean = StdStats.mean(thresholds);
    stddev = StdStats.stddev(thresholds);
  }

  private double runTrial(Percolation p) {
    int x;
    int y;
    int iterations = 0;
    while (!p.percolates()) {
      x = StdRandom.uniform(1, size+1);
      y = StdRandom.uniform(1, size+1);
      if (!p.isOpen(x, y)) {
        p.open(x, y);
        iterations++;
      }
    }
    double val = iterations / (double) (size * size);
    return val;
  }


  // sample mean of percolation threshold
  public double mean() {
    return mean;
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return stddev;
  }

  // low endpoint of 95% confidence interval
  public double confidenceLo() {
    double lo = mean - CONFIDENCE_95 * stddev / Math.sqrt(thresholds.length);
    return lo;
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    double hi = mean + CONFIDENCE_95 * stddev / Math.sqrt(thresholds.length);
    return hi;
  }

  // test client (see below)
  public static void main(String[] args) {
    PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

    StdOut.printf("Mean:\t\t\t%f\n", ps.mean());
    StdOut.printf("Stddev:\t\t\t%f\n", ps.stddev());
    StdOut.printf("Ci:\t\t\t[%f, %f]\n", ps.confidenceLo(), ps.confidenceHi());
  }
}
