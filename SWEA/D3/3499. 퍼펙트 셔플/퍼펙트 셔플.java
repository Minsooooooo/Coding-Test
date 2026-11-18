import java.util.*;
public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1; t<=test_case; t++) {
			
			int n = sc.nextInt();
			Queue<String> que = new LinkedList<>();
			
			for(int i=0; i<n; i++) {
				que.add(sc.next());
			}
			
			String[] arr = new String[n];
			
			for(int i=0; i<n+(n%2); i+=2) {
				arr[i] = que.poll();
			}
			for(int i=1; i<n; i+=2) {
				arr[i] = que.poll();
			}
			

			System.out.print("#"+t+" ");
			for(String s : arr) {
				System.out.print(s+" ");
			}
			System.out.println();
			
		}

	}

}

/*
 n개의 카드가 있는 덱
 n이 홀수이면 교대로 놓을때 먼저놓는쪽이 한장 더 들어감
*/
