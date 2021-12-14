import java.util.*;

public class Mode {
    public static void main(String[] args) {
        int[] data = new int[] {100,95,90,95};
        int len = data.length;
        int f = mostFrequent(data, len);
        System.out.println("final answer mode is: "+f);
    }
    public static int mostFrequent(int arr[], int n){
        // Arrays.sort(arr);
        int max = 0;
        int cn = arr[0];
        
        int[] freq = new int[find(arr)+1];
        try {
            for(int i = 0; i < n; i++) {
                freq[arr[i]]++;
                System.out.println(Arrays.toString(freq));
                if(max < freq[arr[i]]) {
                    max = freq[arr[i]];
                    cn = arr[i];
                }
            }
        } catch(Exception e) {System.out.println();}
        return cn;
    }
    public static int find(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}