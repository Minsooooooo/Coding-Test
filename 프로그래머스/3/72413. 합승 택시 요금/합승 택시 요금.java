import java.util.*;

class Solution {

    static ArrayList<int[]>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        // 1. 그래프 초기화
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 양방향 그래프 생성
        for (int i = 0; i < fares.length; i++) {

            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];

            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }

        // 3. 다익스트라 3번 실행
        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);

        int answer = INF;

        // 4. 모든 합승 종료 지점 확인
        for (int i = 1; i <= n; i++) {

            if (distS[i] == INF ||
                distA[i] == INF ||
                distB[i] == INF) {
                continue;
            }

            int total = distS[i] + distA[i] + distB[i];

            answer = Math.min(answer, total);
        }

        return answer;
    }

    // 다익스트라 알고리즘
    static int[] dijkstra(int n, int start) {

        int[] dist = new int[n + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        // {현재 위치, 시작점부터의 누적 비용}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1[1], o2[1])
        );

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int now = current[0];
            int cost = current[1];

            // 이미 더 짧은 경로가 있다면 무시
            if (cost > dist[now]) {
                continue;
            }

            // 현재 위치와 연결된 지점 확인
            for (int i = 0; i < graph[now].size(); i++) {

                int[] next = graph[now].get(i);

                int nextNode = next[0];
                int nextCost = next[1];

                int newCost = cost + nextCost;

                // 더 저렴한 경로 발견
                if (newCost < dist[nextNode]) {

                    dist[nextNode] = newCost;

                    pq.offer(new int[]{
                        nextNode, newCost
                    });
                }
            }
        }

        return dist;
    }
}