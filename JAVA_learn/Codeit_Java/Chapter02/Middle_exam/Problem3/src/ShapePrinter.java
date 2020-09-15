public class ShapePrinter {
    public void printTriangle(int height){
        for(int i=0;i<height;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
