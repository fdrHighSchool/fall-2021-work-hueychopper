public class Average {
    public static void main(String[] args) {
        double[] nums = new double[100];
        for(int i = 0; i < 100; i++) {
            double randomNums = (double)Math.round(Math.random()*100);
            nums[i] = randomNums;
        }
        double total = 0.0;
        for(int l = 0; l < nums.length; l++) {
            total += nums[l];
        }
        double average = total / nums.length;
        System.out.println(average);
    }
}