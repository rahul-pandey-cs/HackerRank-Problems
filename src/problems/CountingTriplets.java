package problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .

For example, . If , we have  and  at indices  and .

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given  as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio. 
The next line contains  space-seperated integers .

Constraints

Output Format

Return the count of triplets that form a geometric progression.

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
Explanation 0

There are  triplets in satisfying our criteria, whose indices are  and 

Sample Input 1

6 3
1 3 9 9 27 81
Sample Output 1

6
Explanation 1

The triplets satisfying are index , , , ,  and */

public class CountingTriplets {

	static long countTriplets(List<Long> arr, long r) {
		int count = 0;
		Long start = arr.get(0);
		HashMap<Long, Integer> gp_Array = new HashMap<Long, Integer>();
		for (Long listVal : arr) {
			if (gp_Array.containsKey(listVal.longValue()) && listVal.intValue() % r == 0) {
				gp_Array.put(listVal.longValue(), gp_Array.get(listVal.longValue()) + 1);
			} else if (listVal.intValue() % r == 0 || !(gp_Array.containsKey(listVal.longValue()))) {
				gp_Array.put(listVal.longValue(), 1);
			} else if (listVal.intValue() == 1) {
				gp_Array.put(listVal.longValue(), gp_Array.get(listVal.longValue()) + 1);
			}
		}

		Long cr = r;
		while (gp_Array.containsKey(start)) {
			if (gp_Array.containsKey(start) && gp_Array.containsKey(start * cr)
					&& gp_Array.containsKey(start * cr * cr)) {
				count += gp_Array.get(start) * gp_Array.get(start * cr) * gp_Array.get(start * cr * cr);
				start = start * r;
			} else
				start = start * r;
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		//
		// String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		//
		// int n = Integer.parseInt(nr[0]);
		//
		// long r = Long.parseLong(nr[1]);

		List<Long> arr = new ArrayList<Long>();
		// Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("
		// ")).map(Long::parseLong)
		// .collect(toList());
		arr.add((long) 1);
		arr.add((long) 3);
		arr.add((long) 9);
		arr.add((long) 9);
		arr.add((long) 27);
		arr.add((long) 81);

		long ans = countTriplets(arr, 3);
		System.out.println(ans);
		// bufferedWriter.write(String.valueOf(ans));
		// bufferedWriter.newLine();
		//
		// bufferedReader.close();
		// bufferedWriter.close();
	}

}
