package algorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 치즈 {
    static int n,m;
    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};



    public static void main(String[] args) throws IOException {

        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        int day = 0;
        while(true){

            boolean bl = false;
            boolean[][] visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if (arr[i][j] == 1) {
                        bl = true;
                        break;
                    }
                }
            }

            if(bl){
                count = dfs(0, 0, visited);
                day++;
            }


            if(!bl){
                break;
            }



        }

        System.out.println(day);
        System.out.println(count);





    }

    public static int dfs(int x, int y, boolean[][] visited){

        int count = 0;

        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]){

                if(arr[nx][ny]==1){
                    count++;
                    arr[nx][ny] = 0;
                    visited[nx][ny] = true;
                }else{
                    visited[nx][ny] = true;
                    count += dfs(nx,ny,visited);
                }
            }


        }


        return count;
    }
}


/*

n, m 격자크기의 판

0 = 치즈없는칸
1 = 치즈있는칸

1시간마다 0(공기)와 닿은 1(치즈)가 녹아 없어짐

- 치즈 안에는 0(공기)가 있는칸이 있는데 이 부분은 바깥 공기와 닿으면 동작

전부 녹기 한시간 전 남아있는 치즈 개수를 구해라
 */
