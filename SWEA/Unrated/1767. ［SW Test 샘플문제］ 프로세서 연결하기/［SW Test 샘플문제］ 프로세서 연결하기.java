import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int n;
	static int[][] arr;
	static List<int[]> list;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int max_core;
	static int wire_count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			
			n = sc.nextInt();
			
			arr = new int[n][n];
			
			list = new ArrayList<>();
			
			max_core = 0;
			wire_count = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
					
					if(arr[i][j] == 1) {
						if(i==0 || j==0 || i==n-1 || j==n-1) continue;
						list.add(new int[] {i, j});
					}
				}
			}
			
			dfs(0, 0, 0);
			
			
			System.out.println("#" + t + " " + wire_count);
			
		}

	}
	
	public static void dfs(int idx, int connection, int wire_length) {
		
		if(idx == list.size()) {
			if(max_core < connection) {
				max_core = connection;
				wire_count = wire_length;
			}else if(max_core == connection) {
				if(wire_count > wire_length) wire_count = wire_length;
			}
			return;
		}
		
		int[] info = list.get(idx);
		int x = info[0];
		int y = info[1];
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			boolean bl = true;
			while(nx>=0 && nx<n && ny>=0 && ny<n) {
				
				if(arr[nx][ny] != 0) {
					bl = false;
					break;
				}
				
				nx += dx[i];
				ny += dy[i];
			}
			
			nx = x + dx[i];
			ny = y + dy[i];
			if(bl) {
				int count = 0;
				while(nx>=0 && nx<n && ny>=0 && ny<n) {
					arr[nx][ny] = 2;
					count ++;
					
					nx+= dx[i];
					ny+= dy[i];
				}
				
				dfs(idx+1, connection+1, wire_length+count);
				
				nx = x + dx[i];
				ny = y + dy[i];
				while(nx>=0 && nx<n && ny>=0 && ny<n) {
					arr[nx][ny] = 0;
					
					nx+= dx[i];
					ny+= dy[i];
				}
			}
			
		}
		dfs(idx+1, connection, wire_length);
		
	}

}
