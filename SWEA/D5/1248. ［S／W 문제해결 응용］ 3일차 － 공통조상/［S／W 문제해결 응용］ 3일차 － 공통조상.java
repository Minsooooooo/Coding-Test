
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static List<List<Integer>> list;
    static int V,E,child_A,child_B;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      	StringTokenizer st = new StringTokenizer(br.readLine());
        
        int test_case = Integer.parseInt(st.nextToken());
        
        for(int t=0; t<test_case; t++){
            
            list = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());
            
            

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            child_A = Integer.parseInt(st.nextToken());
            child_B = Integer.parseInt(st.nextToken());

            V += 1; //편하게 1번부터 시작하기위해

            for(int i=0; i<V; i++){
                list.add(new ArrayList<>());
            }


            st = new StringTokenizer(br.readLine());

            for(int i=0; i<E; i++){
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                add_tree(list, p, c);
            }

            parent = new int[V];
            depth = new int[V];

            dfs(1, 0);

            int parent = findParent(child_A, child_B);

            int size = getTreeSize(parent);

            System.out.println("#"+(t+1)+" "+parent +" "+size);
            
        }

        






    }


    public static void add_tree(List<List<Integer>> list, int parent, int child){
        list.get(parent).add(child);
    }

    static int[] parent;
    static int[] depth;

    public static void dfs(int node, int de){
        depth[node] = de;

        for(int child : list.get(node)){
            parent[child] = node;
            dfs(child, de+1);
        }

    }

    public static int findParent(int a, int b){

        while(depth[a] != depth[b]){
            if(depth[a] > depth[b]) a = parent[a];
            else b = parent[b];
        }

        while(a!=b){
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static int getTreeSize(int start){

        int sub_tree = 1;

        for(int child : list.get(start)){
            sub_tree+=getTreeSize(child);
        }

        return sub_tree;
    }

}

/*
인접리스트

이진트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고,
그 정점을 루트로하는 서브트리의 크기를 알아내라

입력
1. 정점의 개수 V, 간선의 개수 E, 공통 조상을 찾는 두개의 정점번호
2. E개의 간선이 나열 (항상 부모, 자식 순서로 나열)
 */