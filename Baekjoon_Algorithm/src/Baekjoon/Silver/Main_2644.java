package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, start, end, answer;
    static ArrayList<Integer>[] peopleList;
    static boolean[] isVisited;

    static void dfs(int pointer, int depth) {
        isVisited[pointer] = true;
        if(pointer == end) {
            answer = depth;
            return;
        }
        for(int i = 0; i < peopleList[pointer].size(); i++) {
            int temp = peopleList[pointer].get(i);
            if(isVisited[temp]) continue;
            dfs(temp, depth + 1);
        }
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine().trim());

        answer = -1;
        isVisited = new boolean[N + 1];
        peopleList = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) peopleList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int tempA = Integer.parseInt(st.nextToken());
            int tempB = Integer.parseInt(st.nextToken());
            peopleList[tempA].add(tempB);
            peopleList[tempB].add(tempA);
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        dfs(start, 0);
        System.out.println(answer);
    }
}
