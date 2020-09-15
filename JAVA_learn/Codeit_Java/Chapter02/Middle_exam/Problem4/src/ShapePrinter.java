public class ShapePrinter {
    public void printPyramid(int height){
        for(int i=0;i<height;i++){
            for(int j=0;j<height - i - 1;j++)
                System.out.print(" ");
            for(int j=0;j<1 + (i*2);j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
