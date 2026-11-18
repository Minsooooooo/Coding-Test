import java.util.*;
public class Solution {

	static int n,k;
	
	static int count;
	
	static int[] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			n = sc.nextInt();
			k = sc.nextInt();
			
			count = 0;
			
			arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			dfs(0,0);
			
			System.out.println("#" + t + " " + count);
			
			
		}
	}
	
	public static void dfs(int idx, int sum) {
		if(k==sum) {
			count++;
			return;
		}
		
		if(idx==n) {
			return;
		}
		
		dfs(idx+1, sum+arr[idx]);
		dfs(idx+1, sum);
	}

}
