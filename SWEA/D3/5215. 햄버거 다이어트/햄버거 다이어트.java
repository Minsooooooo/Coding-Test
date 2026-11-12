
import java.util.*;

public class Solution {

	static int n,l;
	static int[][] arr;
	
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			n = sc.nextInt();
			l = sc.nextInt();
			
			arr = new int[n][2];
			
			for(int i=0; i<n; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			max = Integer.MIN_VALUE;
			
			dfs(0,0,0);
			
			System.out.println("#" + t + " " + max);
			
			
		}

	}
	
	public static void dfs(int start, int score, int cal) {
		
		if(cal > l) {
			return;
		}
		
		if(start == n) {
			max = Math.max(max, score);
			return;
		}
		
		int sc = arr[start][0];
		int calo = arr[start][1];
		dfs(start+1, score+sc, cal+calo);
		
		dfs(start+1, score, cal);

		
		
	}

}
/*

재료에 대한 점수, 재료에 대한 칼로리

l = 제한칼로리
n = 재료 수

맛 점수, 칼로리

정해진 칼로리 이하의 조합중 만기가 가장 선호하는 햄버거를 조합해주자

*/