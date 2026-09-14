

import java.util.*;

public class Solution {
    static int[][] map;
    static boolean[][] visited;

    static int answer;

    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        

        for(int t=1; t<=10; t++){
            
            int test_case = sc.nextInt();
            

            map = new int[16][16];
            visited = new boolean[16][16];

            for(int i=0; i<16; i++){
                String str = sc.next();
                for(int j=0; j<16; j++){
                    map[i][j] = str.charAt(j) - '0';
                }
            }


            answer = 0;

            dfs(1, 1);

            System.out.println("#" + t + " " + answer);



        }

    }

    public static void dfs(int x, int y){
        if(map[x][y] == 3){
            answer = 1;
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<16 && ny>=0 && ny<16 && !visited[nx][ny] && map[nx][ny]!=1){
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}

/*
16*16의 맵이 있고
미로의 시작점은 1,1(2) 도착점은 13,13(3)

맵에서 0이 갈수있는길 1이 갈수없는길
도달할수있는지 없는지 판단
 */