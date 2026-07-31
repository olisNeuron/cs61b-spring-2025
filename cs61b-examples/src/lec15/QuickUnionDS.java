package lec15;

public class QuickUnionDS implements Disjointsets{
    private int[] parent;

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i+=1) {
            parent[i] = -1;
        }
    }

    public int find(int p) {
        int r = p;
        while (parent[r] >= 0) {
            r = parent[r];
        }
        return r;
    }

    @Override
    public void connect(int q, int p) {
        int i = find(q);
        int j = find(p);

    }

    @Override
    public boolean isConnected(int q, int p) {
        return false;
    }
}
