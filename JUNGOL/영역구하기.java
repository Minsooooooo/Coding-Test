import java.util.*;

public class Main {
    static int n,m,k;

    static int[][] arr;
    static int[][] xyxy;

    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[m][n];

        xyxy = new int[k][4];

        visited = new boolean[m][n];

        // 직사각형 갯수만큼 좌표받기
        for(int i=0; i<k; i++){
            for(int j=0; j<xyxy[i].length; j++){
                xyxy[i][j] = sc.nextInt();
            }
        }


        // 직사각형 채우기
        for(int a=0; a<k; a++){
            int x1 = xyxy[a][0];
            int x2 = xyxy[a][2];

            int y1 = xyxy[a][1];
            int y2 = xyxy[a][3];

            for(int i=y1; i<y2; i++){
                for(int j=x1; j<x2; j++){
                    arr[i][j] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    list.add(dfs(i, j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int a : list){
            System.out.print(a+" ");
        }










    }

    public static int dfs(int x, int y){
        int count = 1;
        visited[x][y] = true;
        arr[x][y] = 1;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<m && ny>=0 && ny<n && arr[nx][ny]==0){
                visited[nx][ny] = true;
                arr[nx][ny] = 1;
                count += dfs(nx, ny);
            }
        }



        return count;
    }

}

/*
MxN의 크기의 모눈종이
K개의 직사각형

k 만큼의
왼쪽아래꼭짓점과 오른쪽위꼭짓점 좌표
x,y,x,y


 */
