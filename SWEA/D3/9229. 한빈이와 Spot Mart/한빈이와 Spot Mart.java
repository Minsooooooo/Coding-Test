import java.util.*;
public class Solution {
	
	static int n,m;
	static int[] weight;
	
	static int max;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			weight = new int[n];
			
			for(int i=0; i<n; i++) {
				weight[i] = sc.nextInt();
			}
			
			max = -1;
			
			dfs(0,0,0);
			
			System.out.println("#"+t+" "+max);
		}
	}
	
	public static void dfs(int start, int count, int w) {
		if(w > m) {
			return;
		}
		if(count == 2) {
			max = Math.max(w, max);
			return;
		}
		
		for(int i=start; i<n; i++) {
			
			dfs(i+1,count+1, w+weight[i]);

		}
	}
}

/*
n개의 과자봉지 (각 과자봉지는 a그램의 무게를 가짐]

한빈이는 최대한 무거운 과자봉지를 고르고싶지만, 두봉지 무게가 M을 초과하면 과자를 들 수 없다.

최대 무게 합을 출력

*/