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

        reqReturns(fractions, " ");
    }
    public static void reqReturns(String fraction, String fgFind) {
        int index = fraction.indexOf(fgFind);
        String f_1 = fraction.substring(0, index);
        int space2 = fraction.indexOf(fgFind, index + 1);
        String f_2 = fraction.substring(space2 + 1);
        String operator = fraction.substring(index+1, space2);
        System.out.println(operator); //+, *, -, /
        System.out.println(f_2);

        int den1 = cutFraction(f_1, "den");
        int den2 = cutFraction(f_2, "den");
        int num1 = cutFraction(f_1, "num");
        int num2 = cutFraction(f_2, "num");
        // int whole = cutFraction(f_1, "whole");
        // int whole = cutFraction(f_2, "whole");
        // int gcd_1
        int lcm_1 = leastCommonMulitple(den1, den2);
        evalFractions(false, 0, operator, lcm_1, den1, den2, num1, num2);
    }
    public static int cutFraction(String fractionToCut, String selector) {
        int f_s = fractionToCut.indexOf("/");
        int u = fractionToCut.indexOf("_");
        if(u != -1) {
            int whole = getWhole(fractionToCut, u);
            int num = getNumer(fractionToCut, f_s, u);
            int den = getDenom(fractionToCut, f_s);
            if(selector == "den") { //.equals()
                return den;
            } else if(selector == "num") {
                return num;
            } else {return whole;}
        } else {
            int num = getNumer(fractionToCut, f_s, u);
            int den = getDenom(fractionToCut, f_s);
            if(selector == "den") {
                return den;
            } else if(selector == "num") {
                return num;
            } else {
                return 0;
            }
        }
    }
    public static int getDenom(String pt, int cf) {
        int denom = Integer.parseInt(pt.substring(cf + 1));
        System.out.println("denominator: "+ Integer.toString(denom)+"\n");
        return denom;
    }
    public static int getNumer(String pt, int cf, int ix) {
        int numerator = Integer.parseInt(pt.substring(ix + 1, cf));
        System.out.println("numerator: " + Integer.toString(numerator));
        return numerator;
    }
    public static int getWhole(String pt, int index) {
        int wholeNum = Integer.parseInt(pt.substring(0, index));
        System.out.println("whole: " + Integer.toString(wholeNum));
        return wholeNum;
    }

    public static void evalFractions(boolean hasWhole, int whole, String operator, int lcm, int den1, int den2, int num1, int num2) {
        int lcd_frac1 = lcm / den1;
        int lcd_frac2 = lcm / den2;
        if(operator.equals("+")) {
            int f_nr = createNewNumers(lcd_frac1, num1) + createNewNumers(lcd_frac2, num2);
            System.out.println("No reduce: "+Integer.toString(f_nr) + "/" + Integer.toString(lcm));
        } else if(operator.equals("-")) {
            int f_nr = createNewNumers(lcd_frac1, num1) - createNewNumers(lcd_frac2, num2);
            System.out.println("No reduce: "+Integer.toString(f_nr) + "/" + Integer.toString(lcm));
        }
    }
    public static int createNewNumers(int lcd, int num) {
        int spawnNewNumer = lcd * num;
        return spawnNewNumer;
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
    public static int leastCommonMulitple(int a, int b) { //den1, den2
        int gcd = greatestCommonDivisor(a, b);
        int lcm = Math.abs(a * b) / gcd;
        System.out.println(lcm);
        return lcm;
    }
}

//num1 * den2 + num2 / num1
//num1 / num2
//num1/den2 / den1 * num2

//irregular to mixed: num / den <--whole number only; remainder over den; e.g 17/3 == 5_2/3
//mixed to irregular: (den * whole) + numerator over den; e.g 6_4/5 == 34/5