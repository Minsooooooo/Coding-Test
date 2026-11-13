import java.util.*;

public class Solution {
	static int min;
	static int n;
	static int[][] arr;
	
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			min =	 Integer.MAX_VALUE;
			
			n = sc.nextInt();
			
			visited = new boolean[n];
			
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			dfs(0,0);
			
			System.out.println("#"+t+" "+min);
			
			
			
			
		}
	
		
		
	}
	
	public static void dfs(int start, int count) {
		
		if(count==n/2) {
			calcul();
			return;
		}
		
		for(int i=start; i<n; i++) {
			
			visited[i] = true;
			dfs(i+1, count+1);
			visited[i] = false;
		}
	}
	
	public static void calcul() {
		
		int sum_a=0;
		int sum_b=0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				if(visited[i] && visited[j]) {
					sum_a += (arr[i][j] + arr[j][i]);
				}else if(!visited[i] && !visited[j]) {
					sum_b += (arr[i][j] + arr[j][i]);
				}
			}
		}
		
		int sum = Math.abs(sum_a-sum_b);
		
		min = Math.min(min, sum);
	}

}

/*
n개의 식재료

식재료를 n/2 개씩 나눠 두개의 a,b요리를 하려함

맛의차이가 최소가 되도록 재료 분배

음식의 맛은 식재료의 조합에 따라 점수가 올라감



*/