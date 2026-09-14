
import java.util.*;
public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int T=1; T<=test_case; T++){

            int n = sc.nextInt();

            int[] trees = new int[n];

            int max = Integer.MIN_VALUE;

            for(int i=0; i<n; i++){
                trees[i] = sc.nextInt();
                if(trees[i] > max) max = trees[i];
            }

            int one = 0;
            int two = 0;

            for(int i=0; i<n; i++){
                int num = max - trees[i];

                two += num/2;
                one += num%2;
            }

            while(two>one+1){
                two--;
                one +=2;
            }

            int day = 0;

            if(one > two){
                day = one*2 - 1;
            }else{
                day = two*2;
            }
            
            System.out.println("#" + T +" " + day);


        }
    }
}


/*
N개의 나무가 있다. 초기의 각 나무의 키가 주어진다. 하루에 한 나무에 물을 줄 수 있다. 첫 날은 물을 준 나무의 키가 1 자라고, 둘째 날은 물을 준 나무의 키가 2 자라고,
셋째 날은 물을 준 나무의 키가 1 자라는 식으로, 홀수 번째 날은 키가 1 자라고 짝수 번째 날은 키가 2 자란다. 모든 나무의 키가 처음에 가장 키가 컸던 나무와 같아지도록 할 수 있는 최소 날짜 수를 계산하라. 어떤 날에는 물을 주는 것을 하지 않을 수도 있다.

예를 들어 나무가 2그루이고 각각의 높이가 4와 2라고 하자. 첫째 날에 물을 주게 되면,
나무의 높이를 모두 4로 만들기 위해서는 3일째까지 물을 주어야 한다. 둘째 날은 아무 일도 안 하게 된다.
하지만, 첫째 날을 쉬고 둘째 날에 물을 주면 2일 만에 나무의 높이가 모두 4가 된다.



케이스 수 30, N 제한 100, 나무 높이 최대 120



[제약사항]

나무의 개수 N은 2 이상 100 이하이다. (2 ≤ N ≤ 100)
주어지는 나무의 초기 높이는 1 이상 120 이하이다.
 */