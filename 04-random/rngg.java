import java.util.Scanner;
import java.util.ArrayList;

class Rngg {
    public static void main(String[] args) {
        System.out.println("use ctrl+c to exit");
        try {
            if(args[0].equals("easy") || args[0].equals("medium") || args[0].equals("hard")) {
                gameMode(args[0]);
            } 
        } catch(Exception except) {
            System.out.println("none chosen. exiting");
            System.exit(0);
        } //use java try-except block to make it stop giving threading error
        //it will now exit program w/o error
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
        // replay();
    }
    public static void Easy(String modeInherit) {
        int correctNum = (int)(Math.random()*9+1);
        mainLoop(correctNum, modeInherit);
        replay(correctNum, modeInherit);
    }
    public static void Med(String modeInherit) {
        int correctNum = (int)(Math.random()*14+1);
        mainLoop(correctNum, modeInherit);
        replay(correctNum, modeInherit);
    }
    public static void Hard(String modeInherit) {
        int correctNum = (int)(Math.random()*24+1);
        mainLoop(correctNum, modeInherit);
        replay(correctNum, modeInherit);
    }
    public static void replay(int getNum, String getMode) {
        System.out.println("good guess. thats the correct number");
        //replay
        System.out.print("would you like to play again? [y/n]: ");
        Scanner rp = new Scanner(System.in);
        if(rp.nextLine().equals("y")) {
            System.out.println("ok. replaying");
            mainLoop(getNum, getMode);
        } else {
            System.exit(0);
        }
    }
}