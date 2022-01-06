import java.util.*;
public class SelfDivisor2 {
    public static void main(String[] args) {
        firstNumSelfDivisors(10,10);
    }
    public static boolean isSelfDivisor(int number) {
        int pch = number;
        while(number > 0) {
            int digit = number % 10;
            if(digit == 0 || pch % digit != 0) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
    public static void firstNumSelfDivisors(int start, int num) {
        int[] arr = new int[num];
        int count = 0;
        for(int i = start; count < num; i++) {
            if(isSelfDivisor(i)) {
                arr[count] = i;
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}