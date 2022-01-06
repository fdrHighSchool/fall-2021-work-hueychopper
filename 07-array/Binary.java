import java.util.*;
public class Binary {
    public static void main(String[] args) {
        boolean a = true;
        Scanner sc = new Scanner(System.in);
        while(a) {
            System.out.print("enter binary: ");
            convert(sc.nextLine());
        } 
        sc.close();
    }
    public static void convert(String bin) {
        int[] binContainer = new int[bin.length()];
        int current = 0;
        int total = 0;
        for (int i = binContainer.length-1; i > -1; i--) {
            binContainer[i] = Character.getNumericValue(bin.charAt(current++)); //reverse input, char to int;
            if(binContainer[i] != 0) {
                int power = (int)Math.pow(2,i);
                total += power;
            }
        }
        System.out.println(total);
    }
}
