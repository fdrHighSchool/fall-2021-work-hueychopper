//take in 2 input points format: (x1, y1) (x2, y2)
import java.util.*;
import java.lang.Math;

public class CoordinatePlane {
    public static void main(String[] args) {
        //Integer.parseInt("12"); //outputs 12 as int
        System.out.println("[!]Input format: (x1, y1) (x2, y2)");
        ArrayList storePoints = new ArrayList<Integer>();
        System.out.print("Write out you 2 points in correct format: ");
        Scanner sc = new Scanner(System.in);
        String points = sc.nextLine();

        int x1 = getPoints(points, false, false, "x1");
        int y1 = getPoints(points, false, true, "y1");
        int x2 = getPoints(points, true, false, "x2");
        int y2 = getPoints(points, true, true, "y2");

        System.out.println("crow: ");
        crowDistance(x1, y1, x2, y2);
        System.out.println("taxi: ");
        taxicabDistance(x1, y1, x2, y2);
        
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
            //System.out.println(indexSpace);
            String cut = points.substring(indexSpace+1);
            if(moveTo2 == true || pointQuery.equals("x2")) {
                String indx2 = cut.substring(cut.indexOf("(")+1, cut.indexOf(","));
                System.out.println(indx2);
                int indX2 = Integer.parseInt(indx2);
                return indX2;
            } 
            if(moveTo2 == true && getYVal == true && pointQuery.equals("y2")) {
                String indy2 = points.substring(cut.indexOf(",")+1);
                System.out.println(indy2);
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
        int ptArray[] = new int[4];
        ptArray[0] = x1;
        ptArray[1] = y1;
        ptArray[2] = x2;
        ptArray[3] = y2;

        double distance = Math.sqrt(Math.pow((ptArray[2] - ptArray[0]), 2) + Math.pow((ptArray[3] - ptArray[1]), 2));
        // System.out.println(ptArray[0]);
        System.out.println(distance);
        return distance;
    } 
    public static double taxicabDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.abs(y2 - y1) + Math.abs(x2 - x1);
        System.out.println(distance);
        return distance;
    }
}
