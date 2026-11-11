import java.util.*;


public class Solution {

	static int n,w,h;
	static int[][] arr;
	
	static int min;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			n = sc.nextInt(); //최대폭탄횟수
			w = sc.nextInt(); //가로
			h = sc.nextInt(); //높이
			
			arr = new int[h][w];
			
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			dfs(0);
			
			System.out.println("#"+t+" "+(min == Integer.MAX_VALUE ? 0 : min) );
			
			
		}

	}
	
	public static void dfs(int count) {
		
		int remain = check();
		
		if(count == n) {
			min = Math.min(min, remain);
			return;
		}
		
		int[][] copy = new int[h][w];
		for(int i=0; i<w; i++) {
			
			//배열복사
			for(int j=0; j<arr.length; j++) {
				copy[j] = arr[j].clone();
			}
			
			int row=0;
			while(row<h) {
				
				if(arr[row][i] == 0) {
					row++;
					continue;
				}else if(arr[row][i] == 1) {
					arr[row][i] = 0;
					dfs(count+1);
					arr[row][i] = 1;
					break;
				}else {
					boom(row, i);
					gravity();
					dfs(count+1);
					
					for(int j=0; j<arr.length; j++) {
						arr[j] = copy[j].clone();
					}
					break;
				}
			}
			
		}
		
		
		
	}
	
	public static void boom(int x, int y) {
		
		int num = arr[x][y];
		arr[x][y] = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			for(int j=1; j<num; j++) {
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
				    break;
				}
				if(arr[nx][ny] <= 1) {
					arr[nx][ny] = 0;
				}else if(arr[nx][ny] > 1) {
					boom(nx, ny);
				}
				nx+= dx[i];
				ny+= dy[i];
				continue;
			}
			
			
		}
	}
	
	public static int check() {
		
		int count = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(arr[i][j]!=0) count++;
			}
		}
		
		return count;
	}
	
	public static void gravity() {

	    for (int col = 0; col < w; col++) {

	        int bottom = h - 1;

	        for (int row = h - 1; row >= 0; row--) {

	            if (arr[row][col] != 0) {

	                arr[bottom][col] = arr[row][col];

	                if (bottom != row) {
	                    arr[row][col] = 0;
	                }

	                bottom--;
	            }
	        }

	        while (bottom >= 0) {
	            arr[bottom][col] = 0;
	            bottom--;
	        }
	    }
	}
	

}
