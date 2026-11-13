
import java.util.*;

public class Solution {

	static int n,b;
	static int[] h;
	
	static int min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++){
			
			n = sc.nextInt();
			b = sc.nextInt();
			
			h = new int[n];
			
			min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				h[i] = sc.nextInt();
			}
			
			
			dfs(0,0);
			
			System.out.println("#" + t + " " + (min-b));
			
			
			
		}

	}
	
	public static void dfs(int idx, int sum) {

		if(idx == n) {
			if(sum >= b) {
				min = Math.min(min, sum);
			}
			return;
			
		}

		
		dfs(idx+1, sum+h[idx]);
		
		dfs(idx+1, sum);
		
		
	}

}

/*

높이가 b인 선반

n명의 직원

각 점원의 키는 h[]
점원의 키를 합쳐 b이상인 것중에 가장 낮은탑

부분집합

*/
