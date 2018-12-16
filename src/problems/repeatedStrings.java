package problems;

public class repeatedStrings {
	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		s.toLowerCase();
		int s_len = s.length();
		long no_a = 0;
		for(int i=0; i<s_len;i++) {
			if(s.charAt(i) =='a') {
				no_a++;
			}
		}
		no_a *= n/s_len;
		if(n%s_len!=0) {
			for(int j=0; j<n%s_len;j++) {
				if(s.charAt(j) =='a') {
					no_a++;
				}
			}
			
		}

		return no_a;
	}

	public static void main(String[] args) {

		long result = repeatedString("aba", 10);
		System.out.println(result);

	}
}
