import java.util.Scanner;
import java.util.ArrayList;

class Rngg {
    public static void main(String[] args) {
        //TODO: replay, check: difficulty = {"easy", "medium", "hard"}, 
        System.out.println("use ctrl+c to exit");
        try {
            if(args[0].equals("easy") || args[0].equals("medium") || args[0].equals("hard")) {
                gameMode(args[0]);
            } 
        } catch(Exception except) {
            System.out.println("none chosen. exiting");
            System.exit(0);
        }
        System.out.println("that is the correct number");
        
        
    }
    public static void gameMode(String mode) {
        System.out.println(mode);
        if(mode.equals("easy")) {
            Easy(mode);
        } else if(mode.equals("medium")) {
            Med(mode);
        } else {
            Hard(mode);
        }
    }
    public static void mainLoop(int correctNum, String mode) {
        ArrayList<Integer> numbersGuessed = new ArrayList<Integer>();
        boolean guessed = false;

        System.out.println(correctNum);
        System.out.println(mode);

        while(guessed == false) {
            System.out.print("enter number: ");
            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();
            numbersGuessed.add(sc.nextInt());
            // System.out.println(numbersGuessed);
            if(userInput > correctNum && userInput <= (correctNum+2)) {
                System.out.println("close. A little less");
            } 
            if(userInput > 1) {
                if(userInput < correctNum && userInput >= (correctNum-2)) {
                    System.out.println("close. a little more");
                }
            }

            if(userInput == correctNum) {
                guessed = true;
                break;
            }
        }
    }
    public static void Easy(String modeInherit) {
        int correctNum = (int)(Math.random()*9+1);
        // System.out.println(correctNum);
        mainLoop(correctNum, modeInherit);
    }
    public static void Med(String modeInherit) {
        System.out.println("med");
    }
    public static void Hard(String modeInherit) {
        System.out.println("hard");
    }
}