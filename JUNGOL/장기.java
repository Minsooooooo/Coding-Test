import java.util.*;

public class Main {

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int n,m,r,c,s,k;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        r = sc.nextInt()-1;
        c = sc.nextInt()-1;

        s = sc.nextInt()-1;
        k = sc.nextInt()-1;

        int min = bfs();

        System.out.println(min);

    }

    public static int bfs(){
        if (r == s && c == k) return 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, r, c});

        boolean[][] visited = new boolean[n][m];
        visited[r][c] = true;


        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int leng = cur[0];
            int x=cur[1], y=cur[2];

            for(int i=0; i<8; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]){

                    visited[nx][ny] = true;

                    if(nx==s && ny==k){
                        return leng+1;
                    }
                    queue.add(new int[]{leng+1, nx, ny});

                }
            }
        }
        return -1;
    }
}

/*
첫줄 장기판 n, m 행과 열
말의 위치 r,c / 졸의 위치 s,k

말이 최소이동횟수로 졸을 잡으려함
최소이동횟수를 구해라
 */
