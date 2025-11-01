package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] cost;

    private static int getResult() throws Exception{
        int[] tempCost = new int[] {0, 0, 0};
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 3; j++) {
                tempCost[j] = Integer.parseInt(st.nextToken());
                if(j == 0) tempCost[j] = tempCost[j] + Math.min(cost[1], cost[2]);
                else if(j == 1) tempCost[j] = tempCost[j] + Math.min(cost[0], cost[2]);
                else tempCost[j] = tempCost[j] + Math.min(cost[0], cost[1]);
            }
            for(int j = 0; j < 3; j++) cost[j] = tempCost[j];
        }
        return Math.min(Math.min(cost[0], cost[1]), cost[2]);
    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        cost = new int[3];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < 3; i++) cost[i] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(getResult());
    }
}
