import java.util.Scanner;
import java.util.ArrayList;

class Rngg {
    public static void main(String[] args) {
        System.out.println("use ctrl+c to exit");
        try {
            if(args[0].equals("easy") || args[0].equals("medium") || args[0].equals("hard")) { //check command arguments e.g java rngg.java easy
                gameMode(args[0]); //pass to game mode handler function
            } 
        } catch(Exception except) { 
            System.out.println("none chosen. exiting");
            System.exit(0); //exit program
        } //use java try-except block to make it stop giving threading error
        //it will now exit program w/o error
    }
    public static void gameMode(String mode) {
        // System.out.println(mode);
        if(mode.equals("easy")) { //string compare
            Easy(mode); //call to init easy function
        } else if(mode.equals("medium")) {
            Med(mode);
        } else {
            Hard(mode);
        }
    }
    public static void mainLoop(int correctNum, String mode) {
        ArrayList<Integer> numbersGuessed = new ArrayList<Integer>(); //array for guesses
        boolean guessed = false; //determine when game will end sort of.

        // System.out.println(correctNum); //uncomment to get the number
        // System.out.println(mode);

        while(guessed == false) {
            System.out.print("enter number: ");
            Scanner sc = new Scanner(System.in); //input for number
            int userInput = sc.nextInt(); //get value
            if(numbersGuessed.contains(userInput)) {
                System.out.println("repeated a number");
            } else {
                numbersGuessed.add(userInput); //append to array
                System.out.println(numbersGuessed);
            }
            if(userInput > correctNum && userInput <= (correctNum+2)) { //check closeness by smaller num
                System.out.println("close. A little less");
            } 
            if(userInput > 1) { //dont want 0 or negatives
                if(userInput < correctNum && userInput >= (correctNum-2)) { //check closeness by greater num
                    System.out.println("close. a little more");
                }
            }

            if(userInput == correctNum) {
                guessed = true;
                break;
            }
        }
    }
    public static void Easy(String modeInherit) { //pass the mode to mode define as prop
        int correctNum = (int)(Math.random()*9+1); //range of random number
        mainLoop(correctNum, modeInherit); //first time playing loop
        replay(correctNum, modeInherit); //recalls this function in itself. unnecessarily complex?
    }
    public static void Med(String modeInherit) {
        int correctNum = (int)(Math.random()*14+1);//extend range for a different mode
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
            gameMode(getMode);
        } else {
            System.exit(0);
        }
    }
}