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
                reqReturns(fractions);
            }
        }
    }
    public static void reqReturns(String fraction) {
        //cut fraction, get all seperate fraction
        ArrayList<String> fractionOrigin = new ArrayList<String>();
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
                fractionOrigin.add(newFrac);
                fractions.add(newFrac);
            } catch(Exception e) {
                System.out.println("");
            }
        }
        cutFraction(fractions, fractionOrigin);
    }
    public static void cutFraction(ArrayList<String> freshFractions, ArrayList<String> originals) {
        ArrayList<Integer> wholes = new ArrayList<Integer>();
        ArrayList<Integer> numers = new ArrayList<Integer>();
        ArrayList<Integer> denoms = new ArrayList<Integer>();
        ArrayList<String> ops = new ArrayList<String>();
        for(int i = 0; i < freshFractions.size(); i++) {
            if(freshFractions.get(i).contains("+") || freshFractions.get(i).contains("-") || 
            freshFractions.get(i).contains("*")) {
                ops.add(freshFractions.get(i));
                freshFractions.remove(i);
            }
        }
        System.out.println(freshFractions);
        for(int s = 0; s < freshFractions.size(); s++) {
            int f_s = freshFractions.get(s).indexOf("/");
            int u = freshFractions.get(s).indexOf("_");
            int num,den,whole;
            // int num = 0; int den = 0; int whole = 0;
            if(u != -1) {
                whole = getWhole(freshFractions.get(s), u);
                num = getNumer(freshFractions.get(s), f_s, u);
                den = getDenom(freshFractions.get(s), f_s);
            } else {
                if(f_s != -1) {
                    whole = 0;
                    num = getNumer(freshFractions.get(s), f_s, u);
                    den = getDenom(freshFractions.get(s), f_s);
                    // num = numc; den = denc; whole = wholec;
                } else {
                    whole = 0;
                    num = Integer.parseInt(freshFractions.get(s).substring(0));
                    System.out.println(num);
                    den = 1;
                }
            }
            wholes.add(whole);
            numers.add(num);
            denoms.add(den);
        }
        System.out.println(wholes);
        System.out.println(numers);
        System.out.println(denoms);
        evalFractions(freshFractions, ops, numers, denoms, wholes, originals);
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
        ArrayList<String> fraction,
        ArrayList<String> ops, 
        ArrayList<Integer> nums, 
        ArrayList<Integer> dens, ArrayList<Integer> whole, ArrayList<String> origins) {
            for(int i = 0; i < whole.size(); i++) {
                String impFrac = convertToIrregular(whole.get(i), nums.get(i), dens.get(i));
                if(whole.get(i) != 0) {
                    whole.set(i, 0);
                    nums.set(i, getNumer(impFrac, impFrac.indexOf("/"), impFrac.indexOf("_")));
                }
            }
            int lcm = leastCommonMulitple(dens);
            if(ops.size() == 1) {
                checkOps(fraction,ops, nums, dens, lcm, 0, origins);
            } else if(ops.size() >= 2) {
                for(int i = 0; i < ops.size(); i++) {
                    checkOps(fraction,ops, nums, dens, lcm, i, origins);
                }
            }
    }
    public static void checkOps(ArrayList<String> fraction, ArrayList<String> ops,
    ArrayList<Integer> nums,ArrayList<Integer> dens,int lcm,int specialIndex,ArrayList<String> origins) {
        ArrayList<Integer> newNumVals = new ArrayList<Integer>();
        ArrayList<Integer> newDenVals = new ArrayList<Integer>();
        int total = 0;
        if(nums.size() == dens.size()) {
            for(int i = 0; i < nums.size(); i++) {
                int lcd = lcm / dens.get(i);
                int nN = lcd * nums.get(i); newNumVals.add(nN);
                int nD = lcd * dens.get(i); newDenVals.add(nD);
            }
            if(ops.get(specialIndex).equals("+")) {
                for(int num : newNumVals) {
                    System.out.println("true");
                    total += num;
                    System.out.println(mkReduce(total, lcm, greatestCommonDivisor(total, lcm)));
                }
            } else if(ops.get(specialIndex).equals("-")) {
                if(ops.size() == 1) {
                    int nn =  (nums.get(specialIndex) * dens.get(specialIndex+1)) - (nums.get(specialIndex+1) * dens.get(specialIndex));
                    int nd = (dens.get(specialIndex) * dens.get(specialIndex+1));
                    System.out.println(mkReduce(nn, nd, greatestCommonDivisor(nn, nd)));
                } else {
                    for(int x = 0; x < newNumVals.size(); x++) {
                        try {
                            total = newNumVals.get(x)-newNumVals.get(x+1);
                            System.out.println("fraction: "+Integer.toString(total)+"/"+Integer.toString(lcm));
                            System.out.println(mkReduce(total, lcm, greatestCommonDivisor(total, lcm)));
                        } catch(Exception e) {
                            System.out.println();
                        }
                    }
                }
            } else if(ops.get(specialIndex).equals("*")) {
                int nn = (nums.get(specialIndex) * nums.get(specialIndex+1));
                int nd = (dens.get(specialIndex) * dens.get(specialIndex+1));
                System.out.println(mkReduce(nn, nd, greatestCommonDivisor(nn, nd)));
            } else {
                int nn = (nums.get(specialIndex) * dens.get(specialIndex+1));
                int nd = (nums.get(specialIndex+1) * dens.get(specialIndex));
                System.out.println(mkReduce(nn, nd, greatestCommonDivisor(nn, nd)));
            }
            //startup of different operations in multi-fraction calculations
            //int nn1, int nn2;
            // nn1 = newNumVals.get(0) + newNumVals.get(1);
            // nn2 = nn1 - newNumVals.get(2);
            // System.out.println("answer: "+Integer.toString(nn2)+"/"+Integer.toString(lcm));
        }
    }
    public static String convertToIrregular(int whole, int num, int den) {
        int nN = (den * whole) + num;
        System.out.println("conversion[m:i]: "+Integer.toString(nN)+"/"+Integer.toString(den));
        return Integer.toString(nN)+"/"+Integer.toString(den);
    }
    public static String mkReduce(int num, int den, int gcd) {
        int nN = num / gcd; int nD = den / gcd;
        return Integer.toString(nN)+"/"+Integer.toString(nD);
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
    public static int leastCommonMulitple(ArrayList<Integer> dens) {
        int lcm = 0;
        for(int i = 0; i < dens.size(); i++) {
            int lcmP = 0;
            try {
                if(dens.size() <= 2) {
                    int gcd = greatestCommonDivisor(dens.get(i), dens.get(i+1));
                    int lcmi = Math.abs(dens.get(i) * dens.get(i+1)) / gcd;
                    lcmP = lcmi; lcm = lcmP;
                } else {
                    int gcd = greatestCommonDivisor(dens.get(i), dens.get(i+1));
                    int lcmi = Math.abs(dens.get(i) * dens.get(i+1)) / gcd;
                    int gcdu = greatestCommonDivisor(lcmi, dens.get(i+2));
                    int lcmf = Math.abs(dens.get(i+2) * lcmi) / gcdu;
                    lcmP = lcmf; lcm = lcmP;
                }
            } catch(Exception e) {
                System.out.println();
            }
        }
        System.out.println("lcm: "+Integer.toString(lcm));
        return lcm;
    }
}
//TODO: verbose output