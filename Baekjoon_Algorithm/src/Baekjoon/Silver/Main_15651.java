package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] numbers;

    static void perm(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) sb.append(numbers[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i < N + 1; i++) {
            numbers[cnt] = i;
            perm(cnt + 1);
        }
    }
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        perm(0);
        System.out.print(sb.toString());
    }
}
