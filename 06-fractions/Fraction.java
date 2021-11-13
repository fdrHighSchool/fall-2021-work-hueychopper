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
        System.out.println("fraction 2: ");
        cutFraction(f_2);
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
            System.out.println("denominator: "+ Integer.toString(denom));

            // greatestCommonDivisor(numerator, denom);
            // leastCommonMulitple(numerator, denom);
        } else {
            int numerator = Integer.parseInt(fractionToCut.substring(0, f_s));
            int denom = Integer.parseInt(fractionToCut.substring(f_s+1));
            System.out.println("numerator: " + Integer.toString(numerator));
            System.out.println("denominator: "+ Integer.toString(denom));
            // greatestCommonDivisor(numerator, denom);
            // leastCommonMulitple(numerator, denom);
        }
    }
    // public static void evaluateFractions(int whole, int num1, int den1, int num2, int den2) {
    //     if(!wholeNum) {
    //         System.out.println("no whole!");
    //     } else {
    //         //
    //     }
    // }

    // public static int greatestCommonDivisor(int a, int b) {}
    // public static int leastCommonMulitple(int a, int b) {}

}

//num1 * den2 + num2 / num1
//num1 / num2
//num1/den2 / den1 * num2