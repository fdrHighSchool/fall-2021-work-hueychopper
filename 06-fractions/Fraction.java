import java.util.*;
import java.lang.Math;

public class Fraction {
    public static void main(String[] args) {
        boolean done = false;
        while(true) {
            System.out.print("prompt :[entire]$ ");
            Scanner sc = new Scanner(System.in);
            String fractions = sc.nextLine();
            if(fractions.equals("quit")) {
                System.out.println("exiting...");
                sc.close();
                System.exit(0);
            } else {
                reqReturns(fractions, " ");
            }
        }
    }
    public static void reqReturns(String fraction, String fgFind) {
        boolean isMixed;
        int index = fraction.indexOf(fgFind);//" "
        String f_1 = fraction.substring(0, index);//fraction 1
        int space2 = fraction.indexOf(fgFind, index + 1); //space behind operator
        String f_2 = fraction.substring(space2 + 1); //fraction 2
        String operator = fraction.substring(index+1, space2); //operator
        
        int den1 = cutFraction(f_1, "den");
        int den2 = cutFraction(f_2, "den");
        int num1 = cutFraction(f_1, "num");
        int num2 = cutFraction(f_2, "num");
        int whole1 = cutFraction(f_1, "whole");
        int whole2 = cutFraction(f_2, "whole");
        int lcm_1 = leastCommonMulitple(den1, den2);

        if(f_1.indexOf("_") != -1 || f_2.indexOf("_") != -1) {
            evalFractions(true, operator, lcm_1, den1, den2, num1, num2, whole1, whole2);
        } else {
            evalFractions(false, operator, lcm_1, den1, den2, num1, num2, whole1, whole2);
        }
    }
    public static int cutFraction(String fractionToCut, String selector) {
        int f_s = fractionToCut.indexOf("/");
        int u = fractionToCut.indexOf("_");
        if(u != -1) {
            int whole = getWhole(fractionToCut, u);
            int num = getNumer(fractionToCut, f_s, u);
            int den = getDenom(fractionToCut, f_s);
            if(selector.equals("den")) { //.equals()
                return den;
            } else if(selector.equals("num")) {
                return num;
            } else {return whole;}
        } else {
            int num;
            int den;
            if(f_s != -1) {
                num = getNumer(fractionToCut, f_s, u);
                den = getDenom(fractionToCut, f_s);
            } else {
                num = Integer.parseInt(fractionToCut.substring(0));
                den = 1;
            }
            if(selector.equals("den")) {
                return den;
            } else if(selector.equals("num")) {
                return num;
            } else {
                return 0;
            }
        }
    }
    public static int getDenom(String pt, int cf) {
        int denom = Integer.parseInt(pt.substring(cf + 1));
        // System.out.println("denominator: "+ Integer.toString(denom)+"\n");
        return denom;
    }
    public static int getNumer(String pt, int cf, int ix) {
        int numerator = Integer.parseInt(pt.substring(ix + 1, cf));
        // System.out.println("numerator: " + Integer.toString(numerator));
        return numerator;
    }
    public static int getWhole(String pt, int index) {
        int wholeNum = Integer.parseInt(pt.substring(0, index));
        // System.out.println("whole: " + Integer.toString(wholeNum));
        return wholeNum;
    }

    public static void evalFractions(boolean hasWhole, String operator, int lcm, int den1, int den2, int num1, int num2, int whole1, int whole2) {
        if(hasWhole == false) {
            checkOperations(operator, lcm, num1, num2, den1, den2);
        } else {
            System.out.println("true");
            String frac1 = convertToIrregular(whole1, num1, den1);
            String frac2 = convertToIrregular(whole2, num2, den2);
            System.out.println(frac1);
            System.out.println(frac2);
            if(frac1.equals(Integer.toString(num1)+"/"+Integer.toString(den1))) {
                System.out.println("[*] fraction1 is irregular.");
                num2 = cutFraction(frac2, "num");
                den2 = cutFraction(frac2, "den");
                checkOperations(operator, lcm, num1, num2, den1, den2);
            } else if(frac2.equals(Integer.toString(num2)+"/"+Integer.toString(den2))) {
                System.out.println("[*] fraction2 is irregular");
                num1 = cutFraction(frac1, "num");
                den1 = cutFraction(frac1, "den");
                checkOperations(operator, lcm, num1, num2, den1, den2);
            } else {
                num1 = cutFraction(frac1, "num");
                den1 = cutFraction(frac1, "den");
                num2 = cutFraction(frac2, "num");
                den2 = cutFraction(frac2, "den");
                checkOperations(operator, lcm, num1, num2, den1, den2);
            }
        }
    }
    public static void checkOperations(String operator, int lcm, int num1, int num2, int den1, int den2) {
        int lcd1 = lcm / den1;
        int lcd2 = lcm / den2;
        int nN = lcd1 * num1;
        int nD = lcd2 * num2;
        if(operator.equals("+")) {
            int fn = nN + nD;
            System.out.println("No reduce: "+Integer.toString(fn)+"/"+Integer.toString(lcm));
            int gcd = greatestCommonDivisor(fn, lcm);
            String finalF = mkReduceNW(gcd, fn, lcm);
            convertToMixed(cutFraction(finalF, "num"), cutFraction(finalF, "den"));
        } else if(operator.equals("-")) {
            int fn = nN - nD;
            System.out.println("No reduce: "+Integer.toString(fn)+"/"+Integer.toString(lcm));
            int gcd = greatestCommonDivisor(fn, lcm);
            String finalF = mkReduceNW(gcd, fn, lcm);
            convertToMixed(cutFraction(finalF, "num"), cutFraction(finalF, "den"));
        } else if(operator.equals("*")) {
            int nN_t = num1 * num2;
            int nD_t = den1 * den2;
            System.out.println("No reduce: "+Integer.toString(nN_t)+"/"+Integer.toString(nD_t));
            int gcd = greatestCommonDivisor(nN_t, nD_t);
            String finalF = mkReduceNW(gcd, nN_t, nD_t);
            convertToMixed(cutFraction(finalF, "num"), cutFraction(finalF, "den"));
        } else if(operator.equals("/")) {
            int nN_t = num1 * den2;
            int nD_t = den1 * num2;
            System.out.println("No reduce: "+Integer.toString(nN_t)+"/"+Integer.toString(nD_t));
            int gcd = greatestCommonDivisor(nN_t, nD_t);
            String finalF = mkReduceNW(gcd, nN_t, nD_t);
            convertToMixed(cutFraction(finalF, "num"), cutFraction(finalF, "den"));
        }
    }
    public static String convertToIrregular(int whole, int num, int den) {
        int nN = (den * whole) + num;
        System.out.println("conversion[m:i] "+Integer.toString(nN)+"/"+Integer.toString(den));
        return Integer.toString(nN)+"/"+Integer.toString(den);
    }
    public static void convertToMixed(int num, int den) {
        int nW = num / den;
        int r = num % den;
        System.out.println("conversion[i:m] "+Integer.toString(nW)+"_"+Integer.toString(r)+"/"+Integer.toString(den));
    }
    public static String mkReduceNW(int gcd, int num, int den) {
        int nN = num / gcd;
        int nD = den / gcd;
        System.out.println("Reduced: " + Integer.toString(nN)+"/"+Integer.toString(nD));
        return Integer.toString(nN)+"/"+Integer.toString(nD);
    }
    public static int greatestCommonDivisor(int a, int b) {
        //euclidean algorithm
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
                            return a;
                        } else if(b != 0) {
                            gcd = b;
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
        return lcm;
    }
}