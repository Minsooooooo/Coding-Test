import java.util.*;

class Solution {

    public String solution(int n, int k, String[] cmd) {

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] bl = new boolean[n];

        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            bl[i] = true;
        }

        next[n - 1] = -1;

        Stack<Integer> stack = new Stack<>();

        int current = k;

        for(int i = 0; i < cmd.length; i++) {

            String str = cmd[i];

            switch(str.charAt(0)) {

                case 'U':

                    int up = Integer.parseInt(str.substring(2));

                    for(int j = 0; j < up; j++) {
                        current = prev[current];
                    }

                    break;

                case 'D':

                    int down = Integer.parseInt(str.substring(2));

                    for(int j = 0; j < down; j++) {
                        current = next[current];
                    }

                    break;

                case 'C':

                    stack.push(current);

                    bl[current] = false;

                    int p = prev[current];
                    int nx = next[current];

                    if(p != -1) {
                        next[p] = nx;
                    }

                    if(nx != -1) {
                        prev[nx] = p;
                    }

                    if(nx != -1) {
                        current = nx;
                    } else {
                        current = p;
                    }

                    break;

                case 'Z':

                    int restore = stack.pop();

                    bl[restore] = true;

                    int rp = prev[restore];
                    int rn = next[restore];

                    if(rp != -1) {
                        next[rp] = restore;
                    }

                    if(rn != -1) {
                        prev[rn] = restore;
                    }

                    break;
            }
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < n; i++) {

            if(bl[i]) {
                answer.append("O");
            } else {
                answer.append("X");
            }
        }

        return answer.toString();
    }
}