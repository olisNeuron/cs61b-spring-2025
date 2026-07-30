package lec15;

public interface Disjointsets {
    public void connect(int q, int p);
    public boolean isConnected(int q, int p);
}
