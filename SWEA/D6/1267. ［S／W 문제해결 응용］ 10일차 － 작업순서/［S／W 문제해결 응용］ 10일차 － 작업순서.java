
import java.util.*;

public class Solution {

	static int v,e;
	static List<Integer>[] list;
	static int[] indegree;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			
			v = sc.nextInt();
			e = sc.nextInt();
			
			list = new ArrayList[v+1];
			indegree = new int[v+1];
			
			for(int i=1; i<=v; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0; i<e; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				list[from].add(to);
				
				indegree[to]++;
			}
			
			Queue<Integer> que = new ArrayDeque<>();
			
			for(int i=1; i<=v; i++) {
				if(indegree[i] == 0) {
					que.offer(i);
				}
			}
			
			System.out.print("#" +t+ " ");
			while(!que.isEmpty()) {
				
				int now = que.poll();
				
				System.out.print(now + " ");
				
				for(int next : list[now]) {
					
					indegree[next]--;
					
					if(indegree[next] == 0) {
						que.offer(next);
					}
				}
				
			}
			
			System.out.println();
		}
	}

}

/*
 v = 정점의 개수
 e = 간선의 개수
 

*/