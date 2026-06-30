package lec2;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public double distanceTo(Point other) {
        return Math.sqrt(
                Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2)
        );
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(3, 4);
        System.out.println(a.distanceTo(b));
        a.translate(2, 2);
        System.out.println(a);
    }
}
