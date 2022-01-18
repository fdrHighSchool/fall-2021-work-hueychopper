import java.util.*;

public class Connect {
    public static void main(String[] args) {
        boolean win = false;
        System.out.println("input format: (char),(column)");
        String[][] board = new String[6][7];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = "[ ]";
            }
        }
        formatBoard(board);

        while(!win) {
            Scanner sc = new Scanner(System.in);
            System.out.print("player1: ");
            String p1 = inputHandle(board, sc.nextLine());
            System.out.println(p1);
            System.out.print("player2: ");
            String p2 = inputHandle(board, sc.nextLine());
            if(p1 == "player1" || p2 == "player2") {
                win = true;
                sc.close();
                break;
            }
        }
    }
    public static void formatBoard(String[][] bd) {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        for(int row = 0; row < bd.length; row++) {
            for(int col = 0; col < bd[row].length; col++) {
                System.out.print(bd[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static String inputHandle(String[][] bd, String coords) {
        int com = coords.indexOf(",");
        String uchar = coords.substring(0,com);
        int colNum = Integer.parseInt(coords.substring(com+1));
        
        String winner = "";
        for(int row = bd.length-1; row > -1; row--) {
            if(bd[row][colNum] == "[ ]") {
                bd[row][colNum] = "["+uchar+"]";
                formatBoard(bd);
                winner = checkWinner(bd);
                break;
            }
            // System.out.print();
            System.out.println("\033[0;32m"+winner);
        }
        return winner;
        
    }

    public static String checkWinner(String[][] bd) {
        for(int row = 0; row < bd.length; row++) {
            int rowCountX = 0; 
            int rowCountO = 0;
            for(int col = 0; col < bd[row].length; col++) {
                
                if(bd[row][col].equals("[x]")) {
                    rowCountX++;
                } else {
                    rowCountX = 0;
                }
                


                if(rowCountX == 4) {
                    return "player1";
                }
            }
        }
        return "0";
    }
}