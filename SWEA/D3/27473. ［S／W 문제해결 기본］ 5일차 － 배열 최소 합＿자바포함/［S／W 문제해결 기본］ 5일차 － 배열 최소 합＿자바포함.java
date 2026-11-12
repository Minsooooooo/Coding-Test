

import java.util.*;

public class Solution {
    static int n;
    static int[][] arr;
    static boolean[] visited;

    static int min;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int t=1; t<=test_case; t++){

            n = sc.nextInt();
            arr = new int[n][n];
            visited = new boolean[n];

            min = Integer.MAX_VALUE;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            dfs(0,0);

            System.out.println("#"+t+" "+min);

        }
    }

    public static void dfs(int count, int sum){

        if(sum>=min) return;

        if(count==n){
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<n; i++){

            if(visited[i]) continue;

            visited[i] = true;
            dfs(count+1, sum+arr[count][i]);
            visited[i] = false;
        }
    }
}
