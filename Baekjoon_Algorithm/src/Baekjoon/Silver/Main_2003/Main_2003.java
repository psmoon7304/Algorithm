package Baekjoon.Silver.Main_2003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, answer;
    static int[] prefix;

    private static int getResult() {
        int start =1;
        for(int end = 1; end <= N; end++) {
            while(M <= (prefix[end] - prefix[start - 1])) {
                if(M == (prefix[end] - prefix[start - 1])) answer++;
                start++;
            }
        }
        return answer;
    }

    private static void prefixSum() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= N; i++) prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefix = new int[N + 1];
    }

    public static void main(String[] args) throws Exception {
        init();
        prefixSum();
        System.out.println(getResult());
    }
}
