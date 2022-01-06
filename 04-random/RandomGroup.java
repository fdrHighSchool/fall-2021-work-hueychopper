import java.util.Scanner;
import java.util.ArrayList;

public class RandomGroup {
    public static void main(String[] args) {
        ArrayList<Integer> numArray = new ArrayList<Integer>();

        while(true) {
            System.out.print("add number(int) here: ");
            Scanner sc = new Scanner(System.in); //input
            int userInput = sc.nextInt();

            int randomNum = (int)(Math.random()*userInput+1);
            numArray.add(randomNum);

            System.out.println(randomNum);
            System.out.println(numArray);
        }

    }// end main method
}// end class