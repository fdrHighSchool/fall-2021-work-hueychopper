import java.util.*;
public class Median {
    public static void main(String[] args) {
        int[] data = new int[]{7,8,5,1,2,1,10};
        int median;
        Arrays.sort(data);
        if(data.length % 2 == 0) {
            int sys1 = data[data.length/2];
            int sys2 = data[(data.length/2)-1];
            double med = (sys1+sys2)/2.0;
            System.out.println("median: "+med);
        } else {
            median = data[data.length/2];
            System.out.println("median: "+median); 
        }
    }
}