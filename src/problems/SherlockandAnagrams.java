package problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries. 
Each of the next  lines contains a string  to analyze.

Constraints



String  contains only lowercase letters  ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Explanation 0

The list of all anagrammatic pairs is and at positions and respectively.

No anagrammatic pairs exist in the second query as no character repeats.

Sample Input 1

2
ifailuhkqq
kkkk
Sample Output 1

3
10*/

public class SherlockandAnagrams {
	static HashMap<String, Integer> stringCount = new HashMap<String, Integer>();
	// Complete the sherlockAndAnagrams function below.

	static int sherlockAndAnagrams(String s) {
		int count = 0; 
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (anagram(s.substring(i, j)))
					count++;
			}
		}
		return count;
	}

	static boolean anagram(String check) {
		List<String> returnPermute = new ArrayList<String>();
		System.out.println("Checking for : " + check);
		int i = 0;
		permute(check, 0, check.length() - 1, returnPermute);
		System.out.println("Possible permutations for " + check + ":" + returnPermute.toString());
		while (i < returnPermute.size()) {
			if (stringCount.containsKey(returnPermute.get(i))) {
				System.out.println(check + "," + returnPermute.get(i));
				i++;
				stringCount.put(check, stringCount.containsKey(check) ? stringCount.get(check) + 1 : 1);
				return true;
			} else
				i++;
		}
		stringCount.put(check, stringCount.containsKey(check) ? stringCount.get(check) + 1 : 1);
		return false;
	}

	static void permute(String input, int l, int r, List<String> returnPermute) {
		if (l == r && !returnPermute.contains(input)) {	
			returnPermute.add(input);
		} else {
			for (int i = l; i <= r; i++) {
				input = swap(input, l, i);
				permute(input, l + 1, r, returnPermute);
				input = swap(input, l, i);
			}
		}
	}

	static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		//
		// int q = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		// for (int qItr = 0; qItr < q; qItr++) {
		// String s = scanner.nextLine();
		String s = "cdcd";
		int result = sherlockAndAnagrams(s);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();
		// }
		//
		// bufferedWriter.close();
		//
		// scanner.close();
	}

}
