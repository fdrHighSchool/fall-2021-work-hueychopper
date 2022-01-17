import java.util.*;

public class Connect {
    public static void main(String[] args) {
        System.out.println("input format: (char),(column)");
        String[][] board = new String[6][7];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = "[ ]";
            }
        }
        formatBoard(board);

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("player1: ");
            inputHandle(board, sc.nextLine(), cols);
            System.out.print("player2: ");
            inputHandle(board, sc.nextLine(), cols);
        }
        //sc.close();
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
    public static void inputHandle(String[][] bd, String coords) {
        int com = coords.indexOf(",");
        String uchar = coords.substring(0,com);
        int colNum = Integer.parseInt(coords.substring(com+1));
        
        
        for(int row = bd.length-1; row > 0; row--) {
            if(bd[row][colNum] == "[ ]") {
                bd[row][colNum] = "["+uchar+"]";
                formatBoard(bd);
                break;
            }
        }
    }
}