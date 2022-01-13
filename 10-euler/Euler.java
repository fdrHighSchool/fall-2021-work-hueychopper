public class Euler {
    public static void main(String[] args) {
        int target = 1000; //no change
        //a+b+c=1000
        //c=1000-a-b
        for(int a = 1; a < target/2; a++) {
            for(int b = a; b < target/2; b++) {
                int c = target - a - b;
                if(a*a + b*b == c*c) {
                    System.out.println("a: "+a+"\nb: "+b+"\nc: "+c+"\nis 1000");
                    System.out.println("product is: "+(a*b*c));
                }
            }
        }
    }
}