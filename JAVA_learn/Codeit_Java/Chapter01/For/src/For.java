public class For {
    public static void main(String args[]){
        int[] array;
        int n = 5;
        array = new int[n];

        array[0] = 1;
        System.out.println(array[0]);

        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.println(i + " * " + j + " = " + (i*j));
            }
        }
    }
}
