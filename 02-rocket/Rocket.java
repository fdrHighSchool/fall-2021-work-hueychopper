// class Rocket { public static void main(String[] args) { System.out.println("   /\\\n  /  \\\n /    \\\n+------+\n|      |\n|      |\n+------+\n|United|\n|States|\n+------+\n|      |\n|      |\n+------+\n   /\\\n  /  \\\n /    \\\n");}}
public class Rocket {
    public static void TB() {
        System.out.println("   /\\\n  /  \\\n /    \\");
    } 
    public static void Box() {
        // cn = cn || null;
        String divider = "+------+";
        String space = "      ";
        System.out.println(divider);
        for(int i = 0; i < 2; i++) {
            System.out.println("|"+space+"|");
        }
        System.out.println(divider);
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