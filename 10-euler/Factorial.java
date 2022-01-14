import java.lang.Math;
import java.math.BigInteger;
public class Factorial {
    public static void main(String[] args) {
        long factorial = 100;
        numSplitC(factorial(factorial));
    }
    public static BigInteger factorial(long fact) {
        BigInteger result = BigInteger.ONE;
        for(long i = fact; i > 0; i--) {
            System.out.println(i);
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public static void numSplitC(BigInteger number) {
        BigInteger pch = number;
        BigInteger t = new BigInteger("10");
        int total = 0;
        while(!number.equals(BigInteger.ZERO)) {
            int d = number.mod(t).intValue();
            total += d;
            number = number.divide(t);
        }
        System.out.println(total);
    }
}
