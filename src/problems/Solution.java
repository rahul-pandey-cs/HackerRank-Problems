package problems;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result{
	public static String rearrangeWord(String word) {

		boolean flag = false;
		char letter = word.charAt(0);
		String returnVal = "";
		for (int i = 0; i < word.length(); i++) {
			// check for all characters being same
			if (word.charAt(i) == letter) {
				continue;
			} else
				flag = true;
		}

		if (flag) {
				if (word.length() == 2) {
					if (word.charAt(1) > word.charAt(0)) {
						returnVal = word.valueOf(word.charAt(1)) + word.valueOf(word.charAt(0));
					} else
						returnVal = "no answer";

				} else {
					char[] charArray = word.toCharArray();
					Arrays.sort(charArray, 1, word.length() - 1);
					for (int k = 0; k < charArray.length - 2; k++) {
						
						returnVal += charArray[k];
					}
       					returnVal += charArray[charArray.length-1] ;
       					returnVal += charArray[charArray.length-2];
				}
			
		} else
			returnVal = "no answer";
		return returnVal;

	}
}

	public class Solution {
	    public static void main(String[] args) throws IOException {
	       
	       String result = Result.rearrangeWord("hegf");
	    	
	        System.out.println(result);

	       	    }
	}