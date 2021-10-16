import java.util.Scanner;
import java.util.ArrayList;

public class RandomGroup {
    public static void main(String[] args) {
        ArrayList<Integer> numArray = new ArrayList<Integer>();

        while(true) {
            System.out.print("add number(int) here: ");
            Scanner sc = new Scanner(System.in); //input

            int randomNum = (int)(Math.random()*sc.nextInt()+1);
            numArray.add(randomNum);

            System.out.println(randomNum);
            System.out.println(numArray);

            for(int i = 0; i < numArray.length; i++) {
                if(numArray[i] == randomNum) {
                    System.out.println("duplicate found!");
                }
            }
        }

    }// end main method
}// end class