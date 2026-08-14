/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int n;
    static int[] company, home;
    static int[][] customer;

    static boolean[] visited;
    static int[] seq;

    static int min;
    
	public static void dfs(int count){
        if(count==n){
            int distance = cal_distance();
            min = Math.min(min, distance);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                seq[count] = i;
                dfs(count+1);
                visited[i] = false;
            }
        }

    }




    public static int cal_distance(){
        int current_x = company[0];
        int current_y = company[1];

        int sum = 0;
        for(int i=0; i<n; i++){
            int num = seq[i];

            sum += Math.abs(current_x-customer[num][0]) + Math.abs(current_y-customer[num][1]);
            current_x = customer[num][0];
            current_y = customer[num][1];

        }
        sum += Math.abs(current_x - home[0])+Math.abs(current_y - home[1]);

        return sum;
    }
    
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int T;
		T=Integer.parseInt(st.nextToken());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
            

            //고객 수 입력
            n = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine());

            company = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            home = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            customer = new int[n][2];

            for(int i=0; i<n; i++){
                for(int j=0; j<2; j++){
                    customer[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            visited = new boolean[n];
            seq = new int[n];

            dfs(0);

            System.out.println("#" +test_case+ " " + min);

		}
	}
}