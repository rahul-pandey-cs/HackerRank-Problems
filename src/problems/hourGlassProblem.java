package problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class hourGlassProblem {
	 // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    int max_sum = Integer.MIN_VALUE;
    int sum = Integer.MIN_VALUE;
    for(int i=0;i<4;i++){
        for(int j=0; j<4;j++){
          sum = sumHourGlass(arr, i, j);
          System.out.println("the sum is:"+sum);
        if(sum>max_sum){
            max_sum = sum;
        }
        }

    }
    return max_sum;
    }

    static int sumHourGlass(int[][] arr, int start_i, int start_j){
        int ret_sum=0;
        for(int i=start_i; i<start_i+3; i++){
           for(int j=start_j; j<start_j+3; j++){
               if(i==start_i+1 && (j ==start_j || j==start_j+2) ){
               continue;}
               else
               ret_sum+=arr[i][j];
           }
        }
        return ret_sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
