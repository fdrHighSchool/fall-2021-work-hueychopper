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
        ArrayList<Integer> cols = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) cols.add(-1);

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("player1: ");
            inputHandle(board, sc.nextLine(), cols);
            System.out.print("player2: ");
            inputHandle(board, sc.nextLine(), cols);
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
    public static void inputHandle(String[][] bd, String coords, ArrayList<Integer> backup) {
        int com = coords.indexOf(",");
        String uchar = coords.substring(0,com);
        int colNum = Integer.parseInt(coords.substring(com+1));
        
        for(int row = bd.length-1; row > 0; row--) {
            bd[row][colNum] = "["+uchar+"]";
            formatBoard(bd);
            System.out.println(backup);
            for(int i = 0; i < backup.size(); i++) {
                if(backup.get(i) != colNum) {
                    backup.set(colNum, colNum);
                } else {
                    System.out.println("you already entered that");
                }
            }
            
            if(bd[row][colNum] != "[ ]") {
                int arrIndex = Arrays.asList(bd).indexOf(bd[row]);
                
            }
            break;
        }
    }

}