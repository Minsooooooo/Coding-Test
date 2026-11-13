import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int n;
	static int[] operator;
	static int[] arr;
	static boolean[] visited;
	
	static int min,max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			n = sc.nextInt();
			
			operator = new int[4];
			arr = new int[n];

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			for(int i=0; i<4; i++) {
				operator[i] = sc.nextInt();
			}
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			dfs(1,arr[0]);
			
			System.out.println("#"+t+" "+ (max-min));
			
			
			
		}

	}
	
	public static void dfs(int idx, int result) {
		
		if(idx==n) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			
			if(operator[i]==0) continue;
			
			
			if(i==0) {
				operator[i]--;
				dfs(idx+1, result+arr[idx]);
				operator[i]++;
			}else if(i==1) {
				operator[i]--;
				dfs(idx+1, result-arr[idx]);
				operator[i]++;
			}else if(i==2) {
				operator[i]--;
				dfs(idx+1, result*arr[idx]);
				operator[i]++;
			}else if(i==3) {
				operator[i]--;
				dfs(idx+1, result/arr[idx]);
				operator[i]++;
			}
			
			
		}
		
		
	}

}

/*

N개의 숫자와

n-1개의 연산자

+ - * /
순열
*/