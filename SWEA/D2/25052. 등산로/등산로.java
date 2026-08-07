import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int n = sc.nextInt();
		
            int[][] arr = new int[n][n];

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    int len = 1; //현재 시작점에서의 길이

                    int current_x = i;
                    int current_y = j;
                    while(true) {
                        int min = Integer.MAX_VALUE;
                        int min_x = 0;
                        int min_y = 0;
                        boolean bl = false;
                        for(int k=0; k<4; k++) {
                            int nx = current_x+dx[k];
                            int ny = current_y+dy[k];

                            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                                if(arr[current_x][current_y]>arr[nx][ny]) {
                                    bl = true;
                                    if(min>arr[nx][ny]) {
                                        min = arr[nx][ny];
                                        min_x = nx;
                                        min_y = ny;
                                    }
                                }
                            }
                        }

                        if(bl) {
                            len++;
                            current_x = min_x;
                            current_y = min_y;
                        }
                        else break;
                    }
                    if(max<len) max = len;
                }
            }
            System.out.println("#"+test_case+" "+max);
		}
	}
}