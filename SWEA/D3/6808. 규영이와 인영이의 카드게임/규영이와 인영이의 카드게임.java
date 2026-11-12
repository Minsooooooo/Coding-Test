

import java.util.*;

public class Solution {

    static int[] gyu, in;

    static int lose;
    static int win;

    static boolean[] visited;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int t=1; t<=test_case; t++){

            gyu = new int[9];
            in = new int[9];
            boolean[] bl = new boolean[19];

            win = 0;
            lose = 0;

            //규영 카드입력
            for(int i=0; i<9; i++){
                int num = sc.nextInt();
                gyu[i] = num;

                bl[num] = true;
            }

            visited = new boolean[9];
            //인영카드입력
            int count = 0;
            for(int i=1; i<=18; i++){
                if(!bl[i]){
                    in[count] = i;
                    count++;
                }
            }

            dfs(0,0,0);

            System.out.println("#" + t + " " + win + " " + lose);


        }

    }

    public static void dfs(int index, int gyu_score, int in_score){
        if(index==9){
            if(gyu_score>in_score){
                win++;
                return;
            }else if(gyu_score == in_score) return;
            else{
                lose++;
                return;
            }
        }

        for(int i=0; i<9; i++){

            if(visited[i]) continue;

            visited[i] = true;
            int gyu_num = gyu[index];
            int in_num = in[i];
            int sum = gyu_num+in_num;
            if(gyu_num>in_num){
                dfs(index+1, gyu_score+sum, in_score);
            }else {
                dfs(index+1, gyu_score, in_score+sum);
            }

            visited[i] = false;

        }

    }
}

/*
1에서 18까지 수가 적힌 18장 카드
한번의 게임에 9장씩 카드를 나눔

한장씩 카드를 내서 비교하고
높은수가 적힌 카드를 낸 사람은 두 카드의 합만큼 점수 +
낮은 수가 적힌 카드를 낸 사람은 아무 점수 x


총점이 높은사람이 승자
총점이 같으면 무승부

규영이가 이기는 경우와 지는 경우가 총 몇가지인지 구해라
 */