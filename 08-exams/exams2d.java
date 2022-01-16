import java.util.*;
import java.lang.Math;

public class Exams2d {
    public static void main(String[] args) {
        int[][] arr = new int[15][5];
        for(int row = 0; row < arr.length; row++) {
            int random = (int)(Math.random()*46)+55;
            for(int col = 0; col < arr[row].length; col++) {
                arr[row][col] = (int)(Math.random()*random)+1;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        valedictorian(arr);
        // System.out.println(arr[arr.length-1][arr[arr.length-1].length-1]); //last row, last element
    }
    public static void valedictorian(int[][] arr) {
        ArrayList<Integer> totals = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            int ctotal = 0;
            for(int j = 0; j < arr[i].length; j++) {
                ctotal += arr[i][j];
            }
            totals.add(ctotal);
        }
        System.out.println(totals);
        int max = totals.get(0);
        for(int grade : totals) {
            if(grade > max) {
                max = grade;
            }
        }
        System.out.println("Congratulations to index: "+totals.indexOf(max)+"; you are veldictorian!");
    }
}