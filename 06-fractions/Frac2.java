import java.util.*;
import java.lang.Math;

public class Fraction {
    public static void main(String[] args) {
        mainThreadLoop();
    }
    public static void mainThreadLoop() {
        while(true) {
            System.out.print("prompt::[entire]$ ");
            Scanner sc = new Scanner(System.in);
            String fractions = " "+sc.nextLine()+" ";
            if(fractions.equals(" quit ")) {
                System.out.println("exiting...");
                sc.close();
                System.exit(0);
            } else {
                reqReturns(fractions, " +");
            }
        }
    }
    public static void reqReturns(String fraction, String fgFind) {
        //cut fraction, get all seperate fraction
        ArrayList<String> fractions = new ArrayList<String>();
        ArrayList<Integer> space = new ArrayList<Integer>();
        for(int i = 0; i < fraction.length(); i++) {
            if(fraction.charAt(i) == ' ') {
                space.add(i);
            }
        }
        for(int j = 0; j < space.size(); j++) {
            try {
                String newFrac = fraction.substring(space.get(j)+1, space.get(j+1));
                fractions.add(newFrac);
            } catch(Exception e) {
                System.out.println("");
            }
        }
        cutFraction(fractions);
    }
    public static void cutFraction(ArrayList<String> freshFractions) {
        //corresponding numerators and denominators
        //undecided whole numbers\
        ArrayList<Integer> wholes = new ArrayList<Integer>();
        ArrayList<Integer> numers = new ArrayList<Integer>();
        ArrayList<Integer> denoms = new ArrayList<Integer>();
        ArrayList<String> ops = new ArrayList<String>();
        for(int i = 0; i < freshFractions.size(); i++) {
            if(freshFractions.get(i).contains("+") || freshFractions.get(i).contains("-")) {
                ops.add(freshFractions.get(i));
                freshFractions.remove(i);
                // System.out.println(freshFractions);
            }
        }
        for(int s = 0; s < freshFractions.size(); s++) {
            int f_s = freshFractions.get(s).indexOf("/");
            int u = freshFractions.get(s).indexOf("_");
            int num, den, whole;
            if(u != -1) {
                whole = getWhole(freshFractions.get(s), u);
                num = getNumer(freshFractions.get(s), f_s, u);
                den = getDenom(freshFractions.get(s), f_s);
            } else {
                if(f_s != -1) {
                    whole = 0;
                    num = getNumer(freshFractions.get(s), f_s, u);
                    den = getDenom(freshFractions.get(s), f_s);
                } else {
                    whole = 0;
                    num = Integer.parseInt(freshFractions.get(s).substring(0));
                    den = 1;
                }
            }
            wholes.add(whole);
            numers.add(num);
            denoms.add(den);
            evalFractions(freshFractions, ops, numers, denoms, wholes);
        }
    }
    public static int getDenom(String pt, int cf) {
        int denom = Integer.parseInt(pt.substring(cf + 1));
        System.out.println("denomerator: "+Integer.toString(denom));
        return denom;
    }
    public static int getNumer(String pt, int cf, int ix) {
        int numerator = Integer.parseInt(pt.substring(ix + 1, cf));
        System.out.println("numerator: "+Integer.toString(numerator));
        return numerator;
    }
    public static int getWhole(String pt, int index) {
        int wholeNum = Integer.parseInt(pt.substring(0, index));
        System.out.println("whole: "+Integer.toString(wholeNum));
        return wholeNum;
    }

    public static void evalFractions(
        ArrayList<String> fracton,
        ArrayList<String> ops, 
        ArrayList<Integer> nums, 
        ArrayList<Integer> dens, ArrayList<Integer> whole) {
            for(int i = 0; i < whole.size(); i++) {
                String impFrac = convertToIrregular(whole.get(i), nums.get(i), dens.get(i));
                if(whole.get(i) != 0) {
                    whole.set(i, 0);
                    nums.set(i, getNumer(impFrac, impFrac.indexOf("/"), impFrac.indexOf("_")));
                }
            }
    }
    public static void checkOps(
        ArrayList<String> ops,
        ArrayList<Integer> nums,
        ArrayList<Integer> dens
    ) {
        System.out.println("check ops pass");
    }
    public static String convertToIrregular(int whole, int num, int den) {
        int nN = (den * whole) + num;
        System.out.println("conversion[m:i]: "+Integer.toString(nN)+"/"+Integer.toString(den));
        return Integer.toString(nN)+"/"+Integer.toString(den);
    }


    public static int greatestCommonDivisor(int a, int b) { //numerator, denominator
        //euclidean algorithm
        int gcd;
        if(a == 0) {
            gcd = b; //if a is 0 then b is the GCF
            return gcd;
        } else if(b == 0) {
            gcd = a; //if b is 0 then a is the GCF
            return gcd;
        } else if(a != 0 && b != 0) {
            while(a != 0 || b != 0) { 
                int q = a / b;
                int r = a % b; 
                if(b * q + r == a) { 
                    a = b;
                    b = r; 
                    if(a == 0 && b != 0 || b == 0 && a != 0) {
                        if(a != 0) { //b is 0
                            gcd = a;
                            return a;
                        } else if(b != 0) { //a is 0
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
//TODO: verbose output