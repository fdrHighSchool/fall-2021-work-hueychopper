import java.util.Scanner;
import java.util.ArrayList;
public class Decimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        convert(sc.nextInt());
        sc.close();
    }
    public static void convert(int num) {
        //divideby2 algorithm
        ArrayList<String> bits = new ArrayList<String>();
        while(num > 0) {
            int a = num % 2;
            bits.add(Integer.toString(a));
            num = num / 2;
        }
        String binary = "";
        for(int i = bits.size()-1; i > -1; i--) {
            binary += bits.get(i);
        }
        System.out.println(binary);
    }
}