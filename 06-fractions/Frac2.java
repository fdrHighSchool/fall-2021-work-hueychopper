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
        if(fractions.contains("+")) {
            fractions.remove(fractions.indexOf("+"));
            System.out.println(fractions);
        }
    }
    public static int getDenom(String pt, int cf) {
        int denom = Integer.parseInt(pt.substring(cf + 1));
        return denom;
    }
    public static int getNumer(String pt, int cf, int ix) {
        int numerator = Integer.parseInt(pt.substring(ix + 1, cf));
        return numerator;
    }
    public static int getWhole(String pt, int index) {
        int wholeNum = Integer.parseInt(pt.substring(0, index));
        return wholeNum;
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
        } else if(a != 0 && b != 0) { //if none are 0 we must solve for the GCF
            while(a != 0 || b != 0) { //loop until a or b is 0 in which case, the other that isn't 0 is the GCF
                int q = a / b; //get quotient of these two params
                int r = a % b; //get remainder with modulo
                if(b * q + r == a) { //accroding to the formula a has to be equal to b*q+r in order to find GCF
                    a = b; //reduce a to b
                    b = r; //set b to remainder so next loop a will get former r and b will be new r
                    if(a == 0 && b != 0 || b == 0 && a != 0) { //check if loop has reduced a or b to 0
                        if(a != 0) { //b is 0
                            gcd = a;
                            return a;
                        } else if(b != 0) { //a is 0
                            gcd = b;
                            return b;
                        } else {
                            break; //exit loop return nothing
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
