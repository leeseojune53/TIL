public class ShapePrinter {
    public void printFloydsPyramid(int height) {
        int standard = height * (1+height) / 2;
        int value = 0;
        int space = -1;
        int count = 10;
        for(int i=standard;i>0;i/=10)
            ++space;
        for(int i=0;i<height;i++){
            for(int k=0;k<space;k++) System.out.print(" ");
            for(int j=0;j<i+1;j++){
                System.out.print(++value);
                if((value+1)/count>0){
                    count*=10;
                    space--;
                }
                for(int k=0;k<space + 1;k++) System.out.print(" ");
            }
            System.out.println();

        }
    }
}