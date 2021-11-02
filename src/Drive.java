public class Drive {
    public static void main(String[] args) {
        int [][][] data = main.andData;
        double[] weights = main.INITIAL_WEIGHTS;
        Drive drive = new Drive();
        main main = new main();
        int epochNumber = 0;
        boolean errorFlag = true;
        double error = 0;
        double[] adjustedWeights = null;
        while (errorFlag){
        drive.printHeading(epochNumber++);
        errorFlag = false;
        for (int x = 0; x < data.length;x++){
            double weightedSum = main.calculateWeightedSum(data[x][0],weights);
            int result = main.applyActivationFunction(weightedSum);
            error = data[x][1][0] - result;
            if (error != 0) errorFlag = true;
            adjustedWeights = main.adjustWeights(data[x][0], weights,error);
            drive.printVector(data[x],weights,result,error,weightedSum,adjustedWeights);
            weights = adjustedWeights;
        }
        }
    }
    public void printHeading(int epochNumber){
        System.out.println("\n===========Epoch #"+epochNumber+"================");
        System.out.println("  w1  |  w2  |  x1  |  x2  | Target Result  | Result  |  error  |  Weighted Sum  |  adjusted w1  |  adjusted w2");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }
    public void printVector (int [][] data,double [] weights ,int result, double error, double weightedSum, double[] adjustedWeights){
        System.out.println(" " + String.format("%.2f",weights[0])+" | "+String.format("%.2f",weights[1])+" | "+ data[0][0]+"    | "+data[0][1]+"    | "+data[1][0]+"              |     "+result+"   |  "+error+"    |   "+String.format("%.2f",weightedSum)+"         |  "+String.format("%.2f",adjustedWeights[0])+"         |  "+String.format("%.2f",adjustedWeights[1]));
    }
}
