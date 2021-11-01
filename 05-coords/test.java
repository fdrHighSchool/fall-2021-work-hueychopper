import java.lang.Math;

public class Test {
    public static void main(String[] args) {
        double dist = distance(1, 0, 4, 4);
        System.out.println(dist);
    }
    public static double distance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        // System.out.println(distance);
        return distance;
    }
}