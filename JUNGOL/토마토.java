package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n,m;

    static int[][] arr;

    static int day;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        boolean ssalmuk = true;
        boolean noway = false;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j]==0) ssalmuk = false;
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] > max) max = arr[i][j];

                if(arr[i][j]==0) noway = true;
            }
        }

        if(ssalmuk) System.out.println("0");
        else if(noway) System.out.println("-1");
        else System.out.println(max-1);




    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==0){
                    arr[nx][ny] = arr[x][y]+1;

                    queue.add(new int[]{nx, ny});
                }
            }

        }

    }
}

/*
n = 세로 m = 가로
0 = 익지않은 도메이도
1 = 익은 도메이도

모든 토마토가 익는 최소날짜 출력


처음부터 모든 토마토가 익어있는상태면 0을 출력하고
모두 익지못하는상황이면 -1을 출력
 */
