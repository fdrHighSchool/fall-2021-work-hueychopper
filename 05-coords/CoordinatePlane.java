//take in 2 input points format: (x1, y1) (x2, y2)
import java.util.*;
import java.lang.Math;

public class CoordinatePlane {
    public static void main(String[] args) {
        //Integer.parseInt("12"); //outputs 12 as int
        if(args.length == 0) {
            System.out.println("Usage: ");
            System.out.println("for crow distance:  java CoordinatePlane.java crow");
            System.out.println("for taxi distance:  java CoordinatePlane.java taxi");
            System.exit(0);
        }
        System.out.println("[!]Input format: (x1, y1) (x2, y2)");
        System.out.print("Write out you 2 points in correct format: ");
        Scanner sc = new Scanner(System.in);
        String points = sc.nextLine();

        int x1 = getPoints(points, false, false, "x1");
        int y1 = getPoints(points, false, true, "y1");
        int x2 = getPoints(points, true, false, "x2");
        int y2 = getPoints(points, true, true, "y2");

        if(args[0].equals("crow")) {
            System.out.println("crow distance: ");
            crowDistance(x1, y1, x2, y2);
        } else if(args[0].equals("taxi")) {
            taxicabDistance(x1, y1, x2, y2);
        } else {
            System.exit(0);
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
        ArrayList storePoints = new ArrayList<Integer>();
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

            }
        }
    }
}

//TODO: check if square
//for loop to get points
//calulate area
//draw square