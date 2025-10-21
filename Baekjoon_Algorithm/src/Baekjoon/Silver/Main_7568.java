package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, rank;
    static int[] answer;
    static int[][] userInfo;

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        answer = new int[N];
        userInfo = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            userInfo[i][0] = Integer.parseInt(st.nextToken());
            userInfo[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < N; i++) {
            rank = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(userInfo[i][0] < userInfo[j][0] && userInfo[i][1] < userInfo[j][1]) rank++;
            }
            answer[i] = rank;
        }
        for(int i : answer) sb.append(i).append(" ");
        System.out.print(sb.toString());
    }
}
