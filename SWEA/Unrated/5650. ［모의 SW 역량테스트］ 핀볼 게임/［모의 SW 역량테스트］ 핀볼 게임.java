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
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int[][] arr;
    static int max;

    static HashMap<Integer, List<Warm>> warm;
    static class Warm{
        int x;
        int y;

        public Warm(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T;
		T=Integer.parseInt(st.nextToken());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            
            max = Integer.MIN_VALUE;
		
			

            st = new StringTokenizer(br.readLine().trim());

            n = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            //웜홀위치저장 map
            warm = new HashMap<>();
            for(int i=6; i<=10; i++){
                warm.put(i, new ArrayList<>());
            }

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    //웜홀 위치 넣기
                    if(warm.containsKey(arr[i][j])){
                        warm.get(arr[i][j]).add(new Warm(i, j));
                    }

                }
            }





            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[i].length; j++){
                    if(arr[i][j] != 0) continue;
                    dfs(i, j);
                }
            }

            System.out.println("#" +test_case+" "+max);

		}
	}
    public static void dfs(int x, int y){

        for(int i=0; i<4; i++){
            int sum = 0;

            //방향 설정
            int way_x = dx[i];
            int way_y = dy[i];

            int current_x = x;
            int current_y = y;

            while(true){

                //방향만큼 한칸이동
                int nx = current_x + way_x;
                int ny = current_y + way_y;

                //시작점으로 도착하면 종료
                if(nx==x && ny==y){
                    break;
                }

                //벽 닿았을때 변경
                if(nx<0 || nx>=n || ny<0 || ny>=n){
                    if(way_x == dx[0] && way_y == dy[0]){//상
                        way_x = dx[1];
                        way_y = dy[1];
                    }else if(way_x == dx[1] && way_y == dy[1]){//하
                        way_x = dx[0];
                        way_y = dy[0];
                    }else if(way_x == dx[2] && way_y == dy[2]){//좌
                        way_x = dx[3];
                        way_y = dy[3];
                    }else{//우
                        way_x = dx[2];
                        way_y = dy[2];
                    }

                    current_x = nx;
                    current_y = ny;

                    sum++;
                    continue;
                }



                if(arr[nx][ny]!=0) {
                    int num = arr[nx][ny];

                    //블랙홀이면 종료
                    if (num == -1) {
                        break;
                    }



                    //블럭이면
                    if(num >= 1 && num <= 5){
                        switch(num){
                            case 1: {
                                if(way_x == dx[0] && way_y == dy[0]){//상
                                    way_x = dx[1];
                                    way_y = dy[1];
                                }else if(way_x == dx[1] && way_y == dy[1]){//하
                                    way_x = dx[3];
                                    way_y = dy[3];
 
                                }else if(way_x == dx[2] && way_y == dy[2]){//좌
                                    way_x = dx[0];
                                    way_y = dy[0];
                                }else{//우
                                    way_x = dx[2];
                                    way_y = dy[2];
                                }

                                sum++;
                                current_x = nx;
                                current_y = ny;
                                continue;
                            }case 2: {
                                if(way_x == dx[0] && way_y == dy[0]){//상
                                    way_x = dx[3];
                                    way_y = dy[3];
                                }else if(way_x == dx[1] && way_y == dy[1]){//하
                                    way_x = dx[0];
                                    way_y = dy[0];
                                }else if(way_x == dx[2] && way_y == dy[2]){//좌
                                    way_x = dx[1];
                                    way_y = dy[1];
                                }else{//우
                                    way_x = dx[2];
                                    way_y = dy[2];
                                }
                                sum++;
                                current_x = nx;
                                current_y = ny;
                                continue;
                            }case 3: {
                                if(way_x == dx[0] && way_y == dy[0]){//상
                                    way_x = dx[2];
                                    way_y = dy[2];
                                }else if(way_x == dx[1] && way_y == dy[1]){//하
                                    way_x = dx[0];
                                    way_y = dy[0];
                                }else if(way_x == dx[2] && way_y == dy[2]){//좌
                                    way_x = dx[3];
                                    way_y = dy[3];
                                }else{//우
                                    way_x = dx[1];
                                    way_y = dy[1];
                                }
                                sum++;
                                current_x = nx;
                                current_y = ny;
                                continue;
                            }case 4: {
                                if(way_x == dx[0] && way_y == dy[0]){//상
                                    way_x = dx[1];
                                    way_y = dy[1];
                                }else if(way_x == dx[1] && way_y == dy[1]){//하
                                    way_x = dx[2];
                                    way_y = dy[2];
                                }else if(way_x == dx[2] && way_y == dy[2]){//좌
                                    way_x = dx[3];
                                    way_y = dy[3];
                                }else{//우
                                    way_x = dx[0];
                                    way_y = dy[0];
                                }
                                sum++;
                                current_x = nx;
                                current_y = ny;
                                continue;
                            }case 5: {
                                if(way_x == dx[0] && way_y == dy[0]){//상
                                    way_x = dx[1];
                                    way_y = dy[1];
                                }else if(way_x == dx[1] && way_y == dy[1]){//하
                                    way_x = dx[0];
                                    way_y = dy[0];
                                }else if(way_x == dx[2] && way_y == dy[2]){//좌
                                    way_x = dx[3];
                                    way_y = dy[3];
                                }else{//우
                                    way_x = dx[2];
                                    way_y = dy[2];
                                }
                                sum++;
                                current_x = nx;
                                current_y = ny;
                                continue;
                            }
                        }
                    }



                    // 웜홀 이동
                    if(num >= 6){
                        for(Warm w : warm.get(num)){
                            if(w.x != nx || w.y != ny){
                                current_x = w.x;
                                current_y = w.y;
                                break;
                            }
                        }
                        continue;
                    }


                }

                current_x = nx;
                current_y = ny;


            }


            max = Math.max(max, sum);
        }


    }
}