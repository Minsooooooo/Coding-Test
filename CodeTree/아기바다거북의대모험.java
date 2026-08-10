package algorism;

import java.util.*;

public class 아기거북응애 {

    //우(→), 하(↓), 좌(←), 상(↑)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int n,m,k;

    static int[][] arr;
    static int[][] pressure_arr;
    static int[][] turtle;
    static int[][] volcano;

    static int[][] complete;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();   //격자크기
        m = sc.nextInt();   //거북이 수
        k = sc.nextInt();   //해저화산 수

        arr = new int[n][n];
        pressure_arr = new int[n][n];

        //격자 정보 입력
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        turtle = new int[m][2]; // 거북이 정보(start_x, start_y)
        // 거북이 정보 입력
        for(int i=0; i<m; i++){
            turtle[i][0] = sc.nextInt();
            turtle[i][1] = sc.nextInt();
        }

        volcano = new int[k][3];    //화산 정보
        for(int i=0; i<k; i++){
            volcano[i][0] = sc.nextInt();
            volcano[i][1] = sc.nextInt();
            volcano[i][2] = sc.nextInt();
        }

        //도착
        complete = new int[m][1]; //도착 턴

        int turn = 1;
        int[] pressure = new int[k]; //압력 누적

        while(turn <= 100){

            //거북이 1마리씩 이동
            for(int i=0; i<m; i++){
                bfs(i);

                if(turtle[i][0]==n-1 && turtle[i][1]==n-1){
                    turtle[i][0] = -1;
                    turtle[i][1] = -1;
                    complete[i][0] = turn;

                }
            }

            //화산
            for(int i=0; i<k; i++) {
                pressure[i] += 10;
            }

            boolean[] isBoomed = new boolean[k];
            boolean newBoom = true;

            while(newBoom){
                newBoom = false;

                for(int i=0; i<k; i++){
                    if(!isBoomed[i]){
                        if(volcano[i][2] <= pressure[i] + pressure_arr[volcano[i][0]][volcano[i][1]]){
                            dfs(i, volcano[i][2]);
                            pressure[i] = 0;
                            isBoomed[i] = true;
                            newBoom = true;
                        }
                    }
                }
            }



            //거북이 화산범위 확인
            for(int i=0; i<m; i++){
                int x = turtle[i][0];
                int y = turtle[i][1];

                if(x<0 || y<0) continue;
                if(pressure_arr[x][y] >= 20){
                    turtle[i][0] = -2;
                    turtle[i][1] = -2;
                    arr[x][y] = 2;
                }
            }




            //초기화
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    pressure_arr[i][j] = 0;
                }
            }




            turn++;

        }


        //출력
        for(int i=0; i<m; i++){
            if(complete[i][0] != 0){
                System.out.println(complete[i][0]);
            }else{
                System.out.println("-1");
            }
        }


    }

    public static void bfs(int id){
        if(turtle[id][0] <= -1) return; // 도착한 거북이를 -1-1좌표로 함, 화석 = -2

        Queue<int[]> queue = new LinkedList<>();

        int start_x = turtle[id][0], start_y = turtle[id][1];
        queue.add(new int[]{start_x, start_y, -1, -1});
        boolean[][] visited = new boolean[n][n];

        while (!queue.isEmpty()){

            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int first_x = cur[2], first_y = cur[3];
            visited[x][y] = true;

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]==0){
                    if(visited[nx][ny]) continue; // 방문한 곳이면 ㅌㅌ

                    if(isTurtle(id, nx, ny)) continue; // 다른거북이가 있으면 ㅌㅌ



                    visited[nx][ny] = true;

                    int first_nx = first_x;
                    int first_ny = first_y;

                    if(first_x == -1 && first_y == -1){
                        first_nx = nx;
                        first_ny = ny;
                    }

                    if(nx==n-1 && ny==n-1){
                        turtle[id][0] = first_nx;
                        turtle[id][1] = first_ny;


                        return;
                    }

                    queue.add(new int[]{nx, ny, first_nx, first_ny});


                }
            }

        }
    }



    public static boolean isTurtle(int current_id, int x, int y){

        for(int i=0; i<m; i++){

            if(current_id == i) continue;

            if(x==turtle[i][0] && y==turtle[i][1]){
                return true;
            }
        }

        return false;
    }


    public static void dfs(int id, int p){


        pressure_arr[volcano[id][0]][volcano[id][1]] += p;

        for(int i=0; i<4; i++){
            int current_p = p;
            int nx = volcano[id][0] + dx[i];
            int ny = volcano[id][1] + dy[i];
            while(true){
                if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] != 1){
                    current_p /= 2;
                    if(current_p <= 0) break;

                    pressure_arr[nx][ny] += current_p;

                    nx += dx[i];
                    ny += dy[i];


                }else break;

            }
        }
    }
}



/*





1. 격자크기 N, 거북 수 M, 해저화산 수 K
2. (N개의 줄만큼)0 = 빈 공간 1 = 산호초
3. (M개의 줄만큼)각 바다거북의 초기위치 r, c
4. (K줄 만큼)각 화산의 위치 r.c와 분출임계치 p

안식처 = N-1, N-1

바다거북은 1~M번까지 한마리씩 이동 (최단경로로)

턴 마다 화산의 압력 + 10
분출임계치가 넘으면 곧바로 상하좌우로 열기 분출
한 턴 이동마다 열기/2

거북이가 위치한칸이 열기 합 20이 넘으면 거북이화석됨


방해요소 = 산호초, 다른 바다거북, 화석
최단 경로가 여러 개라면 우(→), 하(↓), 좌(←), 상(↑) 순서로 우선순위를 두어 첫 이동 방향을 결정합니다.
최단 경로가 존재하지 않는다면 이동하지 않고 제자리에 머뭅니다.


턴이 지날때마다 분출된 화산의 열기와 압력 초기화, 분출되지않은 화산 압력은 유지




 */
