package problems;

public class JumpingOnClouds {

	public static void main(String[] args) {
//		int[] yourArray = {0, 0, 0, 1, 0, 0};
//		int[] yourArray = {0, 0, 1, 0, 0, 1, 0};
		int[] yourArray = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0};
		int result = jumpingOnClouds(yourArray);
		System.out.println(result);
	}

	static int jumpingOnClouds(int[] c) {

		  int min_cloud = 1; // Including last cloud
	        boolean start = true; // To denote starting position, which can be both 1st or second cloud
	        for (int i = 0; i < c.length-2;) {
	            if(c[i+2]==0 && start){ 
	            	i=i+3;
	                start=false;
	                if(c.length>3) {
	                min_cloud++;     
	                }
	                continue;
	            } if(c[i+1]==0 && start){ 
	                i=i+2;
	                start=false;
	                min_cloud++;
	                continue;
	            } else if (c[i] == 0 && c[i+2]==0) {
	                i=i+2;
	                min_cloud++;
	                continue;
	            } else if (c[i] == 0 || (c[i+1] == 0 && i==c.length-2)) {
	                i=i+1;
	                min_cloud++; 
	                continue;
	            }else if(c[i] == 1 && (c[i+1] == 0 && i==c.length-3)) {
	            	i++;
	            	min_cloud++;
	            	continue;
	            }else if(c[i] == 1) {i++;
	            continue;}
	        }
	        return (min_cloud);
	}
}
