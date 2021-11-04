//take in 2 input points format: (x1, y1) (x2, y2)
import java.util.*;
import java.lang.Math;

public class CoordinatePlane {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: ");
            System.out.println("for distance:  java CoordinatePlane.java distance");
            System.out.println("for area:      java CoordinatePlane.java area");
            System.exit(0);
        }

        if(args[0].equals("area")) {
            startProgram(false, null);
            area();
        } else {
            startProgram(true, args[0]);
        }
        
    }
    public static void startProgram(boolean allowRun, String checkArgs) {
        if(allowRun == true) {
            System.out.println("[!] Input format: (x1, y1) (x2, y2)");
            System.out.print("Write out you 2 points in correct format: ");
            Scanner sc = new Scanner(System.in);
            String points = sc.nextLine();

            int x1 = getPoints(points, false, false, "x1");
            int y1 = getPoints(points, false, true, "y1");
            int x2 = getPoints(points, true, false, "x2");
            int y2 = getPoints(points, true, true, "y2");

            if(checkArgs.equals("distance")) {
                System.out.println("crow distance: ");
                crowDistance(x1, y1, x2, y2);
                System.out.println("taxi distance: ");
                taxicabDistance(x1, y1, x2, y2);
                System.out.println("slope distance: ");
                slope(x1, y1, x2, y2);
            } else {
                System.exit(0);
            }
        }
    }
    public static int getPoints(String points, boolean moveTo2, boolean getYVal, String pointQuery) {
        int space = points.indexOf(" ");
        String mks = points.substring(space, space+1);

        int indicateCom = points.indexOf(",");

        if(pointQuery.equals("x1")) {
            String cutX1 = points.substring(1, indicateCom);
            int x1 = Integer.parseInt(cutX1);
            return x1;
        } else if(pointQuery.equals("y1") && getYVal == true) {
            int bp = points.indexOf(")");
            String yInd = points.substring(space+1, bp);
            int y1 = Integer.parseInt(yInd);
            return y1;
        } 

        if(moveTo2 == true) {
            int indexSpace = points.indexOf(" ", points.indexOf(" ") + 1);
            String cut = points.substring(indexSpace+1);
            if(moveTo2 == true || pointQuery.equals("x2")) {
                String indx2 = cut.substring(cut.indexOf("(")+1, cut.indexOf(","));
                int indX2 = Integer.parseInt(indx2);
                return indX2;
            } 
            if(moveTo2 == true && getYVal == true && pointQuery.equals("y2")) {
                String indy2 = points.substring(cut.indexOf(",")+1);
                int indY2 = Integer.parseInt(indy2);
                return indY2;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
        
    }

    public static double crowDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));
        System.out.println(distance);
        return distance;
    } 
    public static double taxicabDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.abs(y2 - y1) + Math.abs(x2 - x1);
        System.out.println(distance);
        return distance;
    }

    public static void area() {
        ArrayList<Integer> storeXPoints = new ArrayList<Integer>(4);
        ArrayList<Integer> storeYPoints = new ArrayList<Integer>(4);
        System.out.println("shape options: ");
        System.out.println("[1] square");
        System.out.println("[2] circle");

        System.out.print("what shape: ");
        Scanner sc = new Scanner(System.in);

        int userResponse = sc.nextInt();
        if(userResponse == 1) {
            System.out.println("format: x, y");
            for(int i = 0; i < 4; i++) {
                System.out.print("input point in format(only 1!): ");
                Scanner sPt = new Scanner(System.in);
                String stty1 = sPt.nextLine();
                String nL = stty1.substring(stty1.indexOf(",")+2);
                String nl_x = stty1.substring(0, stty1.indexOf(","));
                int p_x = Integer.parseInt(nl_x);
                int n_l = Integer.parseInt(nL);
                storeXPoints.add(p_x);
                storeYPoints.add(n_l);
                System.out.println(storeXPoints);
                System.out.println(storeYPoints);
            }
            int x1 = storeXPoints.get(0);
            int x2 = storeXPoints.get(1);

            int y1 = storeYPoints.get(0);
            int y2 = storeYPoints.get(1);
        }
    }
    public static double slope(double x1, double y1, double x2, double y2) {
        if((x2 - x1) == 0) {
            System.out.println("x2 - x1 cannot equal 0. exiting.");
            System.exit(0);
        } else {
            double slope = (y2 - y1) / (x2 - x1);
            System.out.println(slope);
            return slope;
        }
        return 0.0;
    }
}

//TODO: check if square
//for loop to get points
//calulate area
//draw square