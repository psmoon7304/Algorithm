package lv3;

import java.util.ArrayList;

public class Solution1 {
    static ArrayList<Integer>[] road;
    static int[] tree;
    static boolean[] isVisited;

    static void searchLeaf(int pointer) {
        ArrayList<Integer> treeInfo = road[pointer];
        isVisited[pointer] = true;

        for(Integer i : treeInfo) {
            if(isVisited[i]) continue;
            searchLeaf(i);
        }
        if(tree[pointer] == 1) return;
        if(treeInfo.size() == 1) {
            tree[treeInfo.get(0)] = 1;
            return;
        }
        for(Integer i : treeInfo) {
            if(tree[i] == 1) continue;
            tree[i] = 1;
        }
    }

    static void init(int n, int[][] input) {
        isVisited = new boolean[n + 1];
        road = new ArrayList[n + 1];
        tree = new int[n + 1];
        for(int i = 1; i <= n; i++) road[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; i++) {
            int tempA = input[i][0];
            int tempB = input[i][1];
            road[tempA].add(tempB);
            road[tempB].add(tempA);
        }
    }

    static int getAnswer(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) answer += tree[i] == 1? 1 : 0;
        return answer;
    }
    public int solution(int n, int[][] input) {
        init(n, input);
        searchLeaf(1);
        return getAnswer(n);
    }
}
