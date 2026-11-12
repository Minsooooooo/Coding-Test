
import java.util.*;

public class Solution {
	
	static int[] parent;
	static int n,m;
	static List<int[]> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			parent = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				parent[i] = i;
			}
			
			list = new ArrayList<>();
			
			System.out.print("#"+t+" ");
			
			for(int i=0; i<m; i++) {
				int check = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(check == 0) union(a, b);
				else {
					int root_a = find(a);
					int root_b = find(b);
					
					if(root_a == root_b) System.out.print("1");
					else System.out.print("0");
				}
			}
			
			System.out.println();
			
			
			
			
		}
	}
	
	public static int find(int x) {
		
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int a, int b) {
		
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		
		parent[rootB] = rootA;
		return true;
	}

}

/*
n개의 정점 m개의 간선

*/