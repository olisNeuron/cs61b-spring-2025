package lec15;

public class QuickFindDS implements Disjointsets{
    int[] id;

    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i+=1) {
            id[i] = -1;
        }
    }

    @Override
    public void connect(int q, int p) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i+=1) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnected(int q, int p) {
        return id[q] == id[p];
    }
}
