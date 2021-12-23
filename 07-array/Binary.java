import java.util.*;
public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        convert(sc.nextLine());
        sc.close();
    }
    public static void convert(String bin) {
        int[] binContainer = new int[bin.length()];
        for (int i = 0; i < bin.length(); i++) {
            char fbin = bin.charAt(i); 
            String f2bin = Integer.toString(fbin);//ASC11 charachters?
            binContainer[i] = Integer.parseInt(f2bin)-48;
        }
        ArrayList<Integer> reversed = new ArrayList<Integer>();
        System.out.println(Arrays.toString(binContainer));
        for(int i = bin.length()-1; i > -1; i--) { reversed.add(binContainer[i]);}
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