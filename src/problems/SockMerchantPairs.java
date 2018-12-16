package problems;

import java.util.HashMap;

public class SockMerchantPairs {

	public static void main(String[] args) {
		
		int[] yourArray = {10, 20 ,20, 10, 10, 30, 50, 10, 20};
		int result = pairValues(9, yourArray);
    	
        System.out.println(result);

	}
	
	public static int pairValues(int n, int[] ar) {
		
		HashMap<Integer, Integer> sockColors = new HashMap<Integer, Integer> ();
		int pairs=0;
		
	    for(int i=0;i<n;i++){
	    	if(!sockColors.containsKey(ar[i]))
	             sockColors.put(ar[i], 1);
	    	else {
	    		sockColors.put(ar[i], (sockColors.get(ar[i])+1));
	    		if(sockColors.get(ar[i])%2 ==0)
	    		pairs +=  1;
	    	}
	    }
		return pairs;
	    
		}

}
