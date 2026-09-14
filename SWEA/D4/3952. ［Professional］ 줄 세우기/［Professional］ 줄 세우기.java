
import java.util.*;

public class Solution {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();

        for(int T=1; T<=test_case; T++){

            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Integer>[] list = new ArrayList[n+1];

            for(int i=0; i<n; i++){
                list[i+1] = new ArrayList<>();
            }

            for(int i=0; i<m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                list[b].add(a);
            }


            List<Integer> answer = new ArrayList<>();
            boolean[] bl = new boolean[n+1];
            while(true){

                for(int i=1; i<=n; i++){

                    if(!bl[i]){
                        if(list[i].isEmpty()){
                            answer.add(i);
                            bl[i] = true;
                        }else{
                            list[i].removeIf(num -> bl[num]);
                        }
                    }
                }

                if(answer.size() == n) break;
            }

            System.out.print("#" + T + " ");

            for(int num : answer){
                System.out.print(num+" ");
            }
            
            System.out.println();


        }



    }
}

/*
N 명의 아이 (1~N번 까지)
M개의 순서 a b면 b는 a뒤에 있어야함

1. 테스트케이스
2. N M
3. M개의 줄만큼 순서
 */
