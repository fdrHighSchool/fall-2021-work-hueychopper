import java.lang.*;
import java.util.*;
public class Median {
    public static void main(String[] args) {
        int[] data = new int[]{7,8,5,1,2,1,9,10};
        int median;
        Arrays.sort(data);
        if(data.length % 2 != 0) {
            median = data[(int)Math.floor(data.length/2)];
            System.out.println("median: "+median);
        } else {
            int sys1 = data[(int)Math.floor(data.length/2)];
            int sys2 = data[findIndex(data, sys1)-1];
            double med = (sys1+sys2);
            System.out.println("median: "+med/2);
        }
    }
    public static int findIndex(int[] dataf, int num) {
        for(int i = 0; i < dataf.length; i++) {
            if(dataf[i] == num) {
                return i;
            }
        }
        return -1;
    }
}