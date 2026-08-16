import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n;
    static int[][] company = new int[1][2], home = new int[1][2];
    static int[][] customer;
    static boolean[] visited;

    static int[] order; //방문순서
    static int min;

    public static void main(String[] args) throws IOException {
        
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int test_case = Integer.parseInt(st.nextToken());
        
        for(int t=0; t<test_case; t++){
            
            min = Integer.MAX_VALUE;
            



            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            company[0][0] = Integer.parseInt(st.nextToken());
            company[0][1] = Integer.parseInt(st.nextToken());

            home[0][0] = Integer.parseInt(st.nextToken());
            home[0][1] = Integer.parseInt(st.nextToken());

            customer = new int[n][2];

            for(int i=0; i<n; i++){
                for(int j=0; j<2; j++){
                    customer[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            visited = new boolean[n];
            order = new int[n];

            dfs(0);

            System.out.println("#" + (t+1) + " " + min);

        }



    }

    public static void dfs(int count){
        if(count==n){
            min = Math.min(min, cal_distance());
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                order[count] = i;
                dfs(count+1);
                visited[i] = false;
            }
        }
    }

    public static int cal_distance(){

        int current_x = company[0][0];
        int current_y = company[0][1];

        int sum = 0;

        for(int i=0; i<n; i++){
            int num = order[i];
            sum += Math.abs(current_x-customer[num][0]) + Math.abs(current_y - customer[num][1]);

            current_x = customer[num][0];
            current_y = customer[num][1];
        }

        sum += Math.abs(current_x-home[0][0]) + Math.abs(current_y - home[0][1]);

        return sum;
    }
}


/*
N명의 고객을 방문하고 돌아가려함 (회사에서 출발 -> N명의 고객 방문 -> 집 도착)

회사, 집, 고객 위치 = x,y

두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.
여기서 |x|는 x의 절대값을 의미하며 |3| = |-3| = 3이다. 회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다르다

(회사에서 출발 -> N명의 고객 방문 -> 집 도착)에서 가장 잛은 경로를 찾으려함


입력
1. N (고객의 수)
2. 회사좌표(x, y) 집 좌표(x,y) 고객수만큼 좌표 (x, y)

 */