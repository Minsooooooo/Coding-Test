

import java.util.*;

public class Solution {

    static int n;
    static int[][] arr;
    static List<int[]> stair;
    static List<int[]> person;
    static int min;

    static int[] select;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int t=1; t<=test_case; t++){

            n = sc.nextInt();
            arr = new int[n][n];
            stair = new ArrayList<>();
            person = new ArrayList<>();

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();

                    if(arr[i][j]==1){
                        person.add(new int[]{i, j});
                    }else if(arr[i][j] >= 2){
                        stair.add(new int[]{i, j});
                    }
                }
            }

            select = new int[person.size()];

            min = Integer.MAX_VALUE;

            dfs(0);

            System.out.println("#"+t+" "+min);


        }
    }

    public static void dfs(int number){

        if(number == person.size()){
            int sec = simul();
            min = Math.min(min, sec);
            return;
        }

        select[number] = 0;
        dfs(number+1);

        select[number] = 1;
        dfs(number+1);

    }

    public static int simul(){

        int[] first_stair = stair.get(0);
        int first_x = first_stair[0];
        int first_y = first_stair[1];
        int[] second_stair = stair.get(1);
        int second_x = second_stair[0];
        int second_y = second_stair[1];

        List<Integer> one_arrive = new ArrayList<>();
        List<Integer> two_arrive = new ArrayList<>();

        //도착 시간계산
        for(int i=0; i<select.length; i++){
            int[] ps = person.get(i);
            int x = ps[0];
            int y = ps[1];

            if(select[i]==0){
                int time = Math.abs((x-first_x)) + Math.abs((y-first_y));
                one_arrive.add(time);
            }else{
                int time = Math.abs((x-second_x)) + Math.abs((y-second_y));
                two_arrive.add(time);
            }
        }

        Collections.sort(one_arrive);
        Collections.sort(two_arrive);

        int one_time = arrive(one_arrive, arr[first_x][first_y]);
        int two_time = arrive(two_arrive, arr[second_x][second_y]);

        return Math.max(one_time, two_time);

    }

    public static int arrive(List<Integer> arrive, int stairTime){
        int size = arrive.size();

        if(size == 0) return 0;

        int[] finish = new int[size];

        for(int i = 0; i < size; i++){

            if(i < 3){
                finish[i] = arrive.get(i) + 1 + stairTime;
            }else{
                finish[i] = Math.max(
                        arrive.get(i) + 1,
                        finish[i - 3]
                ) + stairTime;
            }
        }

        return finish[size - 1];
    }

}
