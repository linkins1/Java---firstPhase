package speedtest;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFQuickUnion {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components
    public UFQuickUnion(int N)
    { // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    public int count()
    { return count; }
    public boolean connected(int p, int q)
    { return find(p) == find(q); }
    private int find(int p)
    { // Find component name.
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q)
    { // Give p and q the same root.
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
    // See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
}
