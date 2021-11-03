//take in 2 input points format: (x1, y1) (x2, y2)
//2 methods: crowDistance(int x1, int x2, int y1, int y2) and taxicabDistance(int x1, int x2, int y1, int y2)
//crowdistance math : sqrt((y2-y1)**2 + (x2-x1)**2)
//taxicabdistance math : absolute value: abs(); abs(y2-y1) + abs(x2-x1)
//substring method
//indexOf
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
        crowDistance(x1, y1, x2, y2); //0,0 are temporary placeholders for testing
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
            //System.out.println(x1);

            return x1;
        } else if(pointQuery.equals("y1") && getYVal == true) {
            int bp = points.indexOf(")");
            String yInd = points.substring(space+1, bp);
            int y1 = Integer.parseInt(yInd);
            //System.out.println(yInd);
            return y1;
        } else {
            if(moveTo2 == true || pointQuery.equals("x2")) {
                int indexSpace = points.indexOf(" ", points.indexOf(" ") + 1);
                String cut = points.substring(indexSpace+1);
                String indx2 = points.substring(cut.indexOf("(")+1, cut.indexOf(","));
                // System.out.println(indx2);
                int indX2 = Integer.parseInt(indx2);
                // System.out.println(indX2);
                return indX2;
            } else if(moveTo2 == true && getYVal == true || pointQuery.equals("y2")) {
                String indy2 = points.substring(cut.indexOf(","));
                int indY2 = Integer.parseInt(indy2);
                // System.out.print("y: ");
                // System.out.println(indY2);
                return indY2;
            } else {
                return 0;
            }
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