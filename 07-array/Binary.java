import java.util.*;
import java.lang.*;
public class Binary {
    public static void main(String[] args) {
        convert(111001001);
    }
    public static void convert(int bin) {
        String binary = Integer.toString(bin);
        int[] binContainer = new int[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            char fbin = binary.charAt(i); //ASC11 charachters?
            String f2bin = Integer.toString(fbin);
            binContainer[i] = Integer.parseInt(f2bin)-48;
        }
        ArrayList<Integer> reversed = new ArrayList<Integer>();
        System.out.println(Arrays.toString(binContainer));
        for(int i = binary.length()-1; i > -1; i--) { //3,2,1,0
            reversed.add(binContainer[i]);
        }
        int total = 0;
        for(int x = 0; x < reversed.size(); x++) {
            if(reversed.get(x) != 0) {
                int power = (int)Math.pow(2,x);
                total += power;
            }
        }
        System.out.println(total);
    }
}