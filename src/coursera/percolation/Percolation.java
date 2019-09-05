import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
  Percolation class.
  */
public class Percolation {

  private final WeightedQuickUnionUF uf;
  private final WeightedQuickUnionUF uf2;
  private boolean[] sites;
  private int openSites;
  private final int size;
  private final int lastIndex;

  // creates n - by - n grid, with all sites initially blocked
  public Percolation(final int n) {
    if (n < 1) {
      throw new IllegalArgumentException();
    }
    size = n;
    int numberOfSquares = n * n + 2;
    uf = new WeightedQuickUnionUF(numberOfSquares);
    uf2 = new WeightedQuickUnionUF(numberOfSquares);
    sites = new boolean[numberOfSquares];
    lastIndex = numberOfSquares - 1;
    openSites = 0;
  }

  private void checkInput(final int n) {
    if (n < 1 || n > size) {
      throw new IllegalArgumentException();
    }
  }

  private int getIndex(final int row, final int col) {
    checkInput(col);
    checkInput(row);
    int index = (row - 1) * size + col;
    return index;
  }

  // opens the site (row, col) if it is not open already
  public void open(final int row, final int col) {
    int index = getIndex(row, col);
    if (!sites[index]) {
      sites[index] = true;
      openSites++;
      if (col > 1 && isOpen(row, col - 1)) {
        uf.union(getIndex(row, col - 1), index);
        uf2.union(getIndex(row, col - 1), index);
      } 
      if (col < size  && isOpen(row, col + 1)) {
        uf.union(index, getIndex(row, col + 1));
        uf2.union(index, getIndex(row, col + 1));
      } 
      if (row > 1 && isOpen(row - 1, col)) {
        uf.union(getIndex(row - 1, col), index);
        uf2.union(getIndex(row - 1, col), index);
      } 
      if (row < size  && isOpen(row + 1, col)) {
        uf.union(getIndex(row + 1, col), index);
        uf2.union(getIndex(row + 1, col), index);
      } 
      if (row == 1) {
        uf.union(0, index);
        uf2.union(0, index);
      }
      if (row == size) {
        uf.union(lastIndex, index);
      }
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(final int row, final int col) {
    int index = getIndex(row, col);
    return sites[index];
  }
  // is the site (row, col) full?
  public boolean isFull(final int row, final int col) {
    int index = getIndex(row, col);
    return uf2.connected(index, 0);
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    return openSites;
  }

  // does the system percolate?
  public boolean percolates() {
    return uf.connected(0, lastIndex);
  }

  // test client (optional)
  public static void main(String[] args) {
    int s = StdIn.readInt();
    Percolation p = new Percolation(s);
    int x;
    int y;
    while (StdIn.hasNextChar()) {
      x = StdIn.readInt();
      if (StdIn.hasNextChar()) {
        y = StdIn.readInt();
        p.open(x, y);
      }
      StdOut.printf("%s\n", p.percolates() ? "true" : "false");
    }
  }
}
