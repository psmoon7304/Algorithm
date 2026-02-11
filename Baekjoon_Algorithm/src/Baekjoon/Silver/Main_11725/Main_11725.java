package Baekjoon.Silver.Main_11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static ArrayList<Integer>[] list;
    static int[] answer;
    static boolean[] isVisited;

    static void dfs(int depth) {
        isVisited[depth] = true;
        for(int i = 0; i < list[depth].size(); i++) {
            int temp = list[depth].get(i);
            if(!isVisited[temp]) {
                answer[temp] = depth;
                dfs(temp);
            }
        }
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        list = new ArrayList[N + 1]; // index 0은 사용 x
        answer = new int[N + 1];
        isVisited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int firstValue = Integer.parseInt(st.nextToken());
            int secondValue = Integer.parseInt(st.nextToken());
            list[firstValue].add(secondValue);
            list[secondValue].add(firstValue);
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        dfs(1);
        for(int i = 2; i <= N; i++) System.out.println(answer[i]);
    }
}
