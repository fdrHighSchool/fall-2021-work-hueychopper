import java.util.*;
import java.lang.Math;

public class Fraction {
    public static void main(String[] args) {
        boolean done = false;

        promptSend();
    }
    public static void promptSend() {
        ArrayList<Integer> createStore = new ArrayList<Integer>();

        System.out.print("prompt :[entire]$ ");
        Scanner sc = new Scanner(System.in);
        String fractions = sc.nextLine();
        System.out.println(fractions);

        cutString(fractions, " ");
    }
    public static void cutString(String fraction, String fgFind) {
        int index = fraction.indexOf(fgFind);
        String f_1 = fraction.substring(0, index);
        int space2 = fraction.indexOf(fgFind, index + 1);
        String f_2 = fraction.substring(space2 + 1);
        String operator = fraction.substring(index, space2);
        System.out.println(operator);
        System.out.println(f_2);

        System.out.println("fraction 1: ");
        cutFraction(f_1);
        // System.out.println("fraction 2: ");
        // cutFraction(f_2);
    }
    public static void cutFraction(String fractionToCut) {
        int f_s = fractionToCut.indexOf("/");
        int u = fractionToCut.indexOf("_");
        if(u != -1) {
            int wholeNum = Integer.parseInt(fractionToCut.substring(0, u));
            System.out.println("whole: " + Integer.toString(wholeNum));
            int numerator = Integer.parseInt(fractionToCut.substring(u + 1, f_s));
            System.out.println("numerator: " + Integer.toString(numerator));
            int denom = Integer.parseInt(fractionToCut.substring(f_s + 1));
            System.out.println("denominator: "+ Integer.toString(denom)+"\n");

            // greatestCommonDivisor(numerator, denom);
            // leastCommonMulitple(numerator, denom);
        } else {
            int numerator = Integer.parseInt(fractionToCut.substring(0, f_s));
            int denom = Integer.parseInt(fractionToCut.substring(f_s+1));
            System.out.println("numerator: " + Integer.toString(numerator));
            System.out.println("denominator: "+ Integer.toString(denom)+"\n");
            int gcdfrac1 = greatestCommonDivisor(numerator, denom);
            int lcmfrac1 = leastCommonMulitple(numerator, denom);
            System.out.println("GCD and LCM: " + Integer.toString(gcdfrac1) + "," + Integer.toString(lcmfrac1));
        }
    }

    public static int greatestCommonDivisor(int a, int b) {
        //euclidean algorithm
        //formula: a = b * quotient + remainder
        int gcd;
        if(a == 0) {
            gcd = b;
            return gcd;
        } else if(b == 0) {
            gcd = a;
            return gcd;
        } else if(a != 0 && b != 0) {
            while(a != 0 || b != 0) {
                int q = a / b; 
                int r = a % b; 
                if(b * q + r == a) {
                    a = b; 
                    b = r;
                    if(a == 0 && b != 0 || b == 0 && a != 0) {
                        if(a != 0) {
                            gcd = a;
                            System.out.println(gcd);
                            return a;
                        } else if(b != 0) {
                            gcd = b;
                            System.out.println(gcd);
                            return b;
                        } else {
                            break;
                        }
                    }
                }
            }
            return 0;
        } else {
            System.exit(0);
            return 0;
        }
    }
    public static int leastCommonMulitple(int a, int b) {
        int gcd = greatestCommonDivisor(a, b);
        int lcm = Math.abs(a * b) / gcd;
        System.out.println(lcm);
        return lcm;
    }

}

//num1 * den2 + num2 / num1
//num1 / num2
//num1/den2 / den1 * num2