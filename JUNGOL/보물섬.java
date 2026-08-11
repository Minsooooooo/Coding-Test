package algorism;

import java.util.*;
public class 보물섬 {

    static int max;
    static int r,c;
    static char[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        arr = new char[r][c];

        for(int i=0; i<r; i++){
            String str = sc.nextLine();
            for(int j=0; j<c; j++){
                arr[i][j] = str.charAt(j);
            }
        }



        int max = Integer.MIN_VALUE;


        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(arr[i][j] == 'L'){
                    max = Math.max(max, bfs(i,j));
                }
            }
        }

        System.out.println(max);









    }

    public static int bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, x, y});

        int max = 0;
        boolean[][] visited = new boolean[r][c];
        visited[x][y] = true;

        while (!queue.isEmpty()){



            int[] cur = queue.poll();
            int leng = cur[0];
            int cx = cur[1], cy = cur[2];


            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx>=0 && nx<r && ny>=0 && ny<c && arr[nx][ny] == 'L' && !visited[nx][ny]){

                    queue.add(new int[]{leng+1, nx, ny});

                    visited[nx][ny] = true;
                    max = Math.max(max, leng);
                }
            }



        }


        return max;
    }
}
/*

R=세로의 크기
C=가로의 크기

상하좌우 이동, 한칸이동시 1시간 소요
가장 긴 시간이 걸리는 육지 두곳에 나뉘어 묻혀있음

L=육지
W=바다
 */
