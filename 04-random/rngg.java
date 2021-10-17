import java.util.Scanner;
import java.util.ArrayList;

class Rngg {
    public static void main(String[] args) {
        ArrayList<Integer> numbersGuessed = new ArrayList<Integer>();
        System.out.println("use ctrl+c to exit");

        int correctNum = 5;
        boolean guessed = false;
        

        while(guessed == false) {
            System.out.print("enter number: ");
            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();
            numbersGuessed.add(sc.nextInt());
            System.out.println(numbersGuessed);

            if(userInput == correctNum) {
                guessed = true;
                System.out.println("thats the number");
                break;
            } else if(userInput < correctNum && userInput > 3) {
                System.out.println("Close. A little more");
            } else if(userInput > correctNum && userInput < 7) {
                System.out.println("Close. A little less");
            } 
        }
    }
}