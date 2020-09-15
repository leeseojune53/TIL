public class GreatestDifferenceFinder {
    int greatestDifference(int[] intArray){
        int maxDiff = 0;
        if(intArray.length < 2)
            return 0;
        for(int i=0;i< intArray.length - 1;i++){
            for(int j = i+1; j< intArray.length; j++){
                if(Math.abs((intArray[i] - intArray[j])) > maxDiff)
                    maxDiff = Math.abs((intArray[i] - intArray[j]));
            }
        }
        return maxDiff;
    }
}
