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
            int m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }

            for(int i=0; i<m; i++){
                b[i] = sc.nextInt();
            }

            int j=0;
            boolean bl = false;
            for(int i=0; i<m; i++){


                while(n>j){

                    if(b[i] == a[j]) {
                        if(i==m-1){
                            bl = true;
                        }
                        j++;
                        break;
                    }
                    j++;
                }
            }
            if(bl) System.out.println("#"+test_case+" YES");
            else System.out.println("#"+test_case+" NO");

		}
	}
}