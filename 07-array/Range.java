public class Range {
    public static void main(String[] args) {
        int[] data = new int[] {5,7,9,1,1,2};
        int cn = 0;
        for(int x = 0; x < data.length; x++) {
            for(int i = 0; i < data.length-1; i++) {
                if(data[i] > data[i+1]) {
                    cn = data[i];
                    data[i] = data[i+1];
                    data[i+1] = cn; 
                }
            }
        }
        int max = data[data.length - 1];
        int min = data[0];
        System.out.println("max: "+max+" - min: "+min+"\n is "+(max - min));
    }
}