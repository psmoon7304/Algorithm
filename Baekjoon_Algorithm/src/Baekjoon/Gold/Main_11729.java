package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, answer;

    static void recursive(int from, int middle, int to, int target) {
        if(target == 0) {
            return;
        }
        recursive(from, to, middle, target - 1);
        sb.append(from).append(" ").append(to).append("\n");
        recursive(middle, from, to, target - 1);
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        sb.append((1<<N) - 1).append("\n");
    }

    public static void main(String[] args) throws Exception {
        init();
        recursive(1, 2, 3, N);
        System.out.print(sb.toString());
    }
}
