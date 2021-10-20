import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        System.out.print("what is your first name: ");
        Scanner sc = new Scanner(System.in);
        String fname = sc.nextLine();
        
        System.out.print("what is your last name: ");
        String lname = sc.nextLine();

        System.out.print("enter birthday in mm/dd/yyyy format: ");
        String bday = sc.nextLine();

        String username ="";
        username += fname.substring(0,1);
        username += lname.substring(lname.length()-2);
        username += bday.substring(0,2);
        username += bday.substring(8);
        username += "@";
        //domain??
        System.out.println(username);
    }
}