package speedtest;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SpeedTest {
    public static void main(String[] args)
    { // Solve dynamic connectivity problem on StdIn.
        int N = StdIn.readInt(); // Read number of sites.
        UFQuickUnion ufQuickUnion = new UFQuickUnion(N); // Initialize N components.
        UFQuickFind ufQuickFind = new UFQuickFind(N); // Initialize N components.
        WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(N); // Initialize N components.
        System.out.println("QuickFind: ");
        while (true)
        {
            int p = StdIn.readInt();
            if(p==100000)
                break;
            int q = StdIn.readInt(); // Read pair to connect.
            if (ufQuickFind.connected(p, q)) continue; // Ignore if connected.
            ufQuickFind.union(p, q); // Combine components
            StdOut.println(p + " " + q); // and print connection.
        }
        StdOut.println(ufQuickFind.count() + " components");

        System.out.println("QuickUnion: ");
        while (true)
        {
            int p = StdIn.readInt();
            if(p==100000)
                break;
            int q = StdIn.readInt(); // Read pair to connect.
            if (ufQuickUnion.connected(p, q)) continue; // Ignore if connected.
            ufQuickUnion.union(p, q); // Combine components
            StdOut.println(p + " " + q); // and print connection.

        }
        StdOut.println(ufQuickUnion.count() + " components");

        System.out.println("WeightedQuickUnionUF: ");
        while (true)
        {
            int p = StdIn.readInt();
            if(p==100000)
                break;
            int q = StdIn.readInt(); // Read pair to connect.
            if (weightedQuickUnionUF.connected(p, q)) continue; // Ignore if connected.
            weightedQuickUnionUF.union(p, q); // Combine components
            StdOut.println(p + " " + q); // and print connection.
        }
        StdOut.println(weightedQuickUnionUF.count() + " components");
    }
}
