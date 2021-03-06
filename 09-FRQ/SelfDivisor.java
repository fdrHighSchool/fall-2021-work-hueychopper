import java.util.Arrays;

public class SelfDivisor {
    public static void main(String[] args) {
        firstNumSelfDivisors(10, 4);
    }
    public static boolean isSelfDivisor(int number) {
        int pch = number;
        while(number > 0) {
            int digit = number % 10;
            if(digit == 0 || pch % digit != 0) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }
    public static void firstNumSelfDivisors(int start, int num) {
        int counter = 0;
        int base = start;
        if(start > 0 && num > 0) {
            int[] arr = new int[num];
            for(int i = 0; i < num; i++) {
                while(true) {
                    counter++;
                    if(counter > base) {
                        if(isSelfDivisor(counter)) {
                            arr[i] = counter;
                            base = counter;
                            System.out.println("c: "+counter);
                            break;
                        } else {
                            System.out.println("error: "+counter);
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}