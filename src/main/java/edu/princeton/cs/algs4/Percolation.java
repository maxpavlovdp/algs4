package edu.princeton.cs.algs4;

public class Percolation {
    private int[] openSites;
    private WeightedQuickUnionUF ufSites;
    private int gridSize;
    private int siteCount;

    // create gridSize-by-gridSize ufSites, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.gridSize = n;
        this.siteCount = n * n + 2;

        this.ufSites = new WeightedQuickUnionUF(siteCount);
        this.openSites = new int[siteCount];
        for (int i = 0; i < siteCount; i++) {
            openSites[i] = 0;
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
//        System.out.println("row: " + row + ",col: " + col);
        int currentSitePos = currentSite(row, col);
        validate(currentSitePos);

        if (openSites[currentSitePos] == 1) {
            return;
        }

        openSites[currentSitePos] = 1;
        if (row == 1) {
            connectWithTop(currentSitePos);
        } else if (row < gridSize) {
            connectWithSiblings(row, col);
        } else if (row == gridSize) {
            connectWithBottom(currentSitePos);
        }
    }

    private void connectWithSiblings(int row, int col) {
        if (col == 1) {
            openFirstSiteInRow(row, col);
        } else if (col > 1 && col < gridSize) {
            openNextSiteInRow(row, col);
        } else if (col == gridSize) {
            openLastSiteInARow(row, col);
        }
    }

    private void openLastSiteInARow(int row, int col) {
        int leftSite = leftSite(row, col);
        if (openSites[leftSite] == 1) ufSites.union(currentSite(row, col), leftSite);

        int upSite = upSite(row, col);
        if (openSites[upSite] == 1) ufSites.union(currentSite(row, col), upSite);

        int bottomSite = bottomSight(row, col);
        if (openSites[bottomSite] == 1) ufSites.union(currentSite(row, col), bottomSite);
    }

    private void openNextSiteInRow(int row, int col) {
        int leftSite = leftSite(row, col);
        if (openSites[leftSite] == 1) ufSites.union(currentSite(row, col), leftSite);

        int upSite = upSite(row, col);
        if (openSites[upSite] == 1) ufSites.union(currentSite(row, col), upSite);

        int rightSite = rightSite(row, col);
        if (openSites[rightSite] == 1) ufSites.union(currentSite(row, col), rightSite);

        int bottomSite = bottomSight(row, col);
        if (openSites[bottomSite] == 1) ufSites.union(currentSite(row, col), bottomSite);
    }

    private void openFirstSiteInRow(int row, int col) {
        int upSite = upSite(row, col);
        if (openSites[upSite] == 1) ufSites.union(currentSite(row, col), upSite);

        int rightSite = rightSite(row, col);
        if (openSites[rightSite] == 1) ufSites.union(currentSite(row, col), rightSite);

        int bottomSite = bottomSight(row, col);
        if (openSites[bottomSite] == 1) ufSites.union(currentSite(row, col), bottomSite);
    }

    private int currentSite(int row, int col) {
        return twoDtoOneD(row, col);
    }

    private int leftSite(int row, int col) {
        return twoDtoOneD(row, col - 1);
    }

    private int bottomSight(int row, int col) {
        return twoDtoOneD(row + 1, col);
    }

    private int rightSite(int row, int col) {
        return twoDtoOneD(row, col + 1);
    }

    private int upSite(int row, int col) {
        return twoDtoOneD(row - 1, col);
    }

    private void connectWithTop(int pos) {
        ufSites.union(0, pos);
        if (openSites[pos + gridSize] == 1) ufSites.union(pos, pos + 2);
    }

    private void connectWithBottom(int pos) {
        ufSites.union(pos, siteCount - 1);
        if (openSites[pos - gridSize] == 1) ufSites.union(pos, pos - gridSize);
    }

    private void validate(int pos) {
        if (pos < 0 || pos >= siteCount) throw new IndexOutOfBoundsException("pos is: " + pos);
    }

    /**
     * 1,2 is 2
     * 1,3 is 3
     * 2,2 is 5
     *
     * @param row
     * @param col
     * @return array id
     */
    private int twoDtoOneD(int row, int col) {
        return (row - 1) * gridSize + col;
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        return openSites[currentSite(row, col)] == 1;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return ufSites.connected(0, currentSite(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        int sum = 0;
        for (int i = 0; i < openSites.length; i++) {
            if (openSites[i] == 1) sum++;
        }
        return sum;
    }

    // does the system percolate?
    public boolean percolates() {
        return ufSites.connected(0, siteCount - 1);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation perc = new Percolation(3);

        System.out.println(perc.isFull(2, 2));
        perc.open(1, 1);
        perc.open(2, 1);
        perc.open(2, 2);
        perc.open(3, 2);
        System.out.println(perc.isFull(2, 2));
        System.out.println(perc.isFull(3, 2));
        System.out.println(perc.percolates());
    }
}