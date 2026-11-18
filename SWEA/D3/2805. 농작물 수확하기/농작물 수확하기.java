import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			
			int start = n/2;
			int end = n/2;
			for(int i=0; i<n; i++) {
				for(int j=start; j<=end; j++) {
					sum += arr[i][j];
				}
				
				if(i<n/2) {
					start-=1;
					end+=1;
				}else {
					start+=1;
					end-=1;
				}
			}
			
			System.out.println("#"+t+" " + sum);
			
		}
	}

}
