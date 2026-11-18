import java.util.*;

public class Solution {
	static int max;
	static int n,l;
	static int[][] food;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			n = sc.nextInt();
			l = sc.nextInt();
			food = new int[n][2];
			
			max = Integer.MIN_VALUE;
			
			for(int i=0; i<n; i++) {
				food[i][0] = sc.nextInt();
				food[i][1] = sc.nextInt();
			}
			
			
			
			dfs(0, 0, 0);
			
			System.out.println("#"+t+" "+max);
			
		}

	}
	
	public static void dfs(int idx, int score, int cal) {
		if(cal>l) {
			return;
		}
		
		if(idx == n) {
			max = Math.max(max, score);
			return;
		}
		
		dfs(idx+1, score+food[idx][0], cal+food[idx][1]);
		dfs(idx+1, score, cal);
	}

}
