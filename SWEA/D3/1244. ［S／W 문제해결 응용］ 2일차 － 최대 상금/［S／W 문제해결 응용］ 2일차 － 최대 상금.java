

import java.util.*;

public class Solution {

    static int[] arr;
    static int m;

    static Set<String> set;

    static int max;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int t=1; t<=test_case; t++){

            String str = sc.next();
            m = sc.nextInt();

            max = Integer.MIN_VALUE;

            arr = new int[str.length()];

            set = new HashSet<>();

            for(int i=0; i<str.length(); i++){
                arr[i] = str.charAt(i) - '0';
            }


            dfs(0);

            System.out.println("#"+t+" "+max);



        }
    }

    public static void dfs(int count){

        if(set.contains(Arrays.toString(arr)+":"+count)){
            return;
        }
        set.add(Arrays.toString(arr)+":"+count);

        if(count == m){
            StringBuilder sb = new StringBuilder();

            for(int num : arr){
                sb.append(num);
            }

            String str = sb.toString();
            max = Math.max(max, Integer.parseInt(str));
            return;
        }

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){

                int num = arr[i];
                arr[i] = arr[j];
                arr[j] = num;


                dfs(count+1);

                num = arr[i];
                arr[i] = arr[j];
                arr[j] = num;
            }
        }
    }

}
