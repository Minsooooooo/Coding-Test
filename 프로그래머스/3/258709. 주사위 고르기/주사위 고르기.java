import java.util.*;

class Solution {

    int[][] dice;
    int n;
    int half;

    int[] selected;
    int[] answer;

    long maxWin = -1;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        n = dice.length;
        half = n / 2;

        selected = new int[half];
        answer = new int[half];

        selectDice(0, 0);

        return answer;
    }

    void selectDice(int start, int depth) {

        if (depth == half) {

            boolean[] check = new boolean[n];

            for (int idx : selected) {
                check[idx] = true;
            }

            int[] a = new int[half];
            int[] b = new int[half];

            int aIdx = 0;
            int bIdx = 0;

            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    a[aIdx++] = i;
                } else {
                    b[bIdx++] = i;
                }
            }

            List<Integer> aSums = new ArrayList<>();
            List<Integer> bSums = new ArrayList<>();

            totalSum(a, 0, 0, aSums);
            totalSum(b, 0, 0, bSums);

            Collections.sort(bSums);

            long win = 0;

            for (int aSum : aSums) {
                win += lowerBound(bSums, aSum);
            }

            if (win > maxWin) {
                maxWin = win;

                for (int i = 0; i < half; i++) {
                    answer[i] = selected[i] + 1;
                }
            }

            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = i;
            selectDice(i + 1, depth + 1);
        }
    }

    void totalSum(int[] dices, int depth, int sum, List<Integer> sums) {

        if (depth == dices.length) {
            sums.add(sum);
            return;
        }

        int diceIndex = dices[depth];

        for (int i = 0; i < 6; i++) {
        	totalSum(
                dices,
                depth + 1,
                sum + dice[diceIndex][i],
                sums
            );
        }
    }

    int lowerBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/*
 
 a, b가 n개의 주사위로 승부
 
 점수가 큰 쪽이 승리, 같으면 무승부
 
 a는 자신이 승리할 확률이 가장 높아지도록 주사위를 가져가려함
 
  
  
 */
 