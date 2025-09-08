package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Integer>[] computerList;
    static boolean isVisted[];
    static int answer;

    static void dfs(int pointer) {
        isVisted[pointer] = true;
        for(int i = 0; i < computerList[pointer].size(); i++) {
            int value = computerList[pointer].get(i);
            if(isVisted[value]) continue;
            answer++;
            dfs(value);
        }
    }

    static void init() throws Exception{ // 초기 설정
        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());
        computerList = new ArrayList[N + 1]; // index : 0 은 사용하지 않음
        isVisted = new boolean[N + 1];
        for(int i = 1; i < N + 1; i++) computerList[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            computerList[index].add(value);
            computerList[value].add(index);
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        dfs(1); // 바이러스 감염은 1번 컴퓨터로 고정
        System.out.println(answer);
    }
}
