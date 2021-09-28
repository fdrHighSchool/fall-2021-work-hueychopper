import java.util.Scanner;

public class Rocket {
    public static void TB() {
        System.out.println("   /\\\n  /  \\\n /    \\");
    } 
    public static void Box() {
        String divider = "+------+";
        String space = "      ";
        System.out.println(divider);
        for(int i = 0; i < 2; i++) {
            System.out.println("|"+space+"|");
        }
        System.out.println(divider);
    }
    public static void label(String cn1, String cn2) {
        if(cn1 == null && cn2 == null) {
            String defaultCn = "|United|\n|States|";
            System.out.println(defaultCn);
        } else {
            if(cn1.length() < 6 && cn2.length() < 6) {
                switch(cn1.length()) {
                    case 5:
                        System.out.println("|"+cn1+" |");
                        break;  
                    case 4:
                        System.out.println("|"+cn1+"  |");
                    
                    case 3:
                        System.out.println("|"+cn1+"   |");
                        break;
                }
                switch(cn2.length()) {
                    case 5:
                        System.out.println("|"+cn2+" |");
                        break;
                    
                    case 4:
                        System.out.println("|"+cn2+"  |");
                    
                    case 3:
                        System.out.println("|"+cn2+"   |");
                        break;
                }
            } else {
                System.out.println("|"+cn1+"|\n|"+cn2+"|");
            }
        }
    }
    public static void main(String[] args) {
        Scanner cn1 = new Scanner(System.in);
        System.out.print("Enter country name(make sure to put an enter key in between words): ");
        System.out.println("");
        Scanner cn2 = new Scanner(System.in);
        String input = new String(cn1.nextLine());
        String input_0 = new String(cn2.nextLine());

        if(input.length() <= 6 && input_0.length() <= 6) {
            TB();
            Box();
            label(input, input_0);
            Box();
            TB();
        } else {
            System.out.println("country name is too long!!");
        }
    }
    public static void label() {
        System.out.println("|United|\n|States|");
    }
    public static void main(String[] args) {
        TB();
        Box();
        label();
        Box();
        TB();
    }
}