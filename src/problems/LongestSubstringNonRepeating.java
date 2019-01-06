package problems;

import java.util.HashMap;

public class LongestSubstringNonRepeating {

    public int lengthOfLongestSubstring(String s) {
        int max_length = 0, length = s.length(), substrLength =0;
        String substr;
        for( int i=0; i< length ; i++){
            for(int j = i+1 ; j <= length; j++){
                substr = s.substring(i,j);
                substrLength = substr.length();
                if(isNonRepeating(substr)){
                    if(substrLength > max_length)
                        max_length = substrLength;
                }
            }
        }
        return max_length;
    }

    public boolean isNonRepeating(String s){
        HashMap<Character,Character> characterMap = new HashMap<Character,Character>();
        for(int i = 0; i < s.length() ; i++){
            if(characterMap.containsKey(s.charAt(i))){
                return false;
            }else
                characterMap.put(s.charAt(i), s.charAt(i));
        }
        return true;
    }
}
