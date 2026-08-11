package algorism;

import java.util.*;

public class 저글링 {

    static int n,m;
    static int[][] arr;
    static int start_x,start_y;

    static int[][] sec; //오염된 초

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        start_y = sc.nextInt()-1;
        start_x = sc.nextInt()-1;

        int time = bfs(start_x, start_y) + 3;

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1) count++;
            }
        }

        System.out.println(time);
        System.out.println(count);

    }

    public static int bfs(int x, int y){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, x, y});
        arr[x][y] = -1;

        int max = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int time = cur[0];
            int cx = cur[1], cy = cur[2];


            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny] == 1){

                    queue.add(new int[]{time+1, nx, ny});
                    arr[nx][ny] = -1;

                    max = Math.max(max, time+1);

                }
            }
        }

        return max;
    }
}

/*
1초마다 이웃 저글링오염
오염된 저글링은 3초뒤에 죽음

0 = 저글링 없는곳
1 = 저글링 있는곳

마지막줄엔 방사능 오염 시작 위치
 */
