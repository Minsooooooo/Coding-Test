import java.util.*;
public class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int[] ddx = {-1, -1, 1, 1};
	static int[] ddy = {-1, 1, 1, -1};
	
	static int max;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[n][n];
			
			
			max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int sum = arr[i][j];
					int x_sum = arr[i][j];
					for(int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						for(int l=0; l<m-1; l++) {
							if(nx>=0 && nx<n && ny>=0 && ny<n) {
								sum+= arr[nx][ny];
								nx+=dx[k];
								ny+=dy[k];
							}else {
								break;
							}
						}
						
					}
					max = Math.max(max, sum);
					
					for(int k=0; k<4; k++) {
						int nx = i+ddx[k];
						int ny = j+ddy[k];
						for(int l=0; l<m-1; l++) {
							if(nx>=0 && nx<n && ny>=0 && ny<n) {
								x_sum+= arr[nx][ny];
								nx+=ddx[k];
								ny+=ddy[k];
							}else {
								break;
							}
						}
						
						
					}
					max = Math.max(max, x_sum);
				}
			}
			
			System.out.println("#"+t+" "+max);
			
		}
		
	}

}
