package Baekjoon.Silver.Main_15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
    static int N, R;
    static int[] numbers;
    static boolean[] isVisted;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        numbers = new int[R];
        isVisted = new boolean[N + 1];
        perm(0);
        System.out.print(sb.toString());
    }

    static void perm(int cnt) {
        if(cnt == R) {
            for(int i : numbers) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(isVisted[i]) continue;
            numbers[cnt] = i;
            isVisted[i] = true;
            perm(cnt + 1);
            isVisted[i] = false;
        }
    }
}
