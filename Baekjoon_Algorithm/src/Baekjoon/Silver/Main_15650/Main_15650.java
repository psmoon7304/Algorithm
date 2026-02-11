package Baekjoon.Silver.Main_15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static int[] numbers;
    static boolean[] isVisited;

    static void Combi(int cnt, int start) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) System.out.print(numbers[i] + " ");
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            numbers[cnt] = i;
            Combi(cnt + 1, i + 1);
            isVisited[i] = false;
        }

    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];
        isVisited = new boolean[N + 1];

        Combi(0, 1);
    }
}
