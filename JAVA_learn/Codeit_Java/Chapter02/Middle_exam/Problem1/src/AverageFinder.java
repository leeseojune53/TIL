public class AverageFinder {
    double computeAverage(int[] intArray) {
        int sum=0;
        for(int i:intArray){
            sum+=i;
        }
        return (double)sum/intArray.length;
    }
}