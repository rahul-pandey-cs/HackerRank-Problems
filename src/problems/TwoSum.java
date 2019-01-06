package problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] retArray = null;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i + 1; j < nums.length; j++)
				sum = nums[i] + nums[j];
			if (sum == target) {
				//retArray =
			}
		}
		return retArray;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = "hello"; //twoSum(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}

}
