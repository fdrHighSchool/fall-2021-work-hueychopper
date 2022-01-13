import java.util.ArrayList;

public class Multiples {
    public static void main(String[] args) {
        int m1 = 3;
        int m2 = 5;
        int num = 10;
        int total = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i < num; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                total += i;
            } else if(i % 3 == 0) {
                total += i;
            } else if(i % 5 == 0) {
                total += i;
            }
        }
        System.out.println(total);
    }
}