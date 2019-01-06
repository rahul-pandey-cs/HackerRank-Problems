package problems;



//Accepted dynamic problem solution

public class LongestPalindrome {

    public String longestPalindrome(String s) {

        int n = s.length();   // get length of input string
        if (n == 0)
            return "";

        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && s.charAt(i) ==
                        s.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}



// Time complexity: O(n^3)
/*
public class LongestPalindrome {
        int start =0;
        HashMap<String,Boolean> cacheMap = new HashMap<String,Boolean>();

        public String longestPalindrome(String s) {
            int maxLength = 0, substrLen = 0;
            String substr, maxLenPalindrome="";
            for(int i=0; i < s.length(); i++){
                for(int j=i+1; j <= s.length(); j++){
                    substr = s.substring(i,j);
                    substrLen = substr.length();
                    if(substrLen > maxLength){
                        if(checkPalindrome(substr, 0, substrLen - 1) ){
                            if( substrLen > maxLength) {
                                maxLength = substrLen;
                                maxLenPalindrome = substr;
                            }
                        }
                    }
                }
            }
            return maxLenPalindrome;
        }

        public boolean checkPalindrome(String input, int start, int end) {
            if(start == end)
                return true;

            if(input.charAt(start) != input.charAt(end))
                return false;

            if(end - start !=1){
                if(cacheMap.containsKey(input.substring(start + 1, end)))
                    return cacheMap.get(input.substring(start + 1, end));
                else{
                    cacheMap.put(input.substring(start + 1, end), checkPalindrome(input, start + 1, end - 1));
                    return cacheMap.get(input.substring(start + 1, end));
                }
            }
            return true;
        }
    }
*/

    //        for (int i = 0; i < s.length() / 2; i++) {
    //            if (s.charAt(i) == s.charAt(s.length() - i - 1))
    //                continue;
    //            else
    //                return false;
    //        }
    //        return true;





