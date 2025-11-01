package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] map;
    static int[] minArray;
    static int[] maxArray;

    private static void getResult() throws Exception{
        int[] tempMin = new int[] {0, 0, 0}, tempMax = new int[] {0, 0, 0};
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < 3; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            minArray[i] = maxArray[i] = map[i];
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 3; j++) map[j] = Integer.parseInt(st.nextToken());
            tempMin[0] = map[0] + Math.min(minArray[0], minArray[1]);
            tempMin[1] = map[1] + Math.min(Math.min(minArray[0], minArray[1]),minArray[2]);
            tempMin[2] = map[2] + Math.min(minArray[1], minArray[2]);

            tempMax[0] = map[0] + Math.max(maxArray[0],maxArray[1]);
            tempMax[1] = map[1] + Math.max(Math.max(maxArray[0], maxArray[1]), maxArray[2]);
            tempMax[2] = map[2]+ Math.max(maxArray[1], maxArray[2]);

            for(int j = 0; j < 3; j++) {
                minArray[j] = tempMin[j];
                maxArray[j] = tempMax[j];
            }
        }
    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        map = new int[3];
        minArray = new int[3];
        maxArray = new int[3];
    }

    public static void main(String[] args) throws Exception {
        init();
        getResult();
        sb.append(Math.max(Math.max(maxArray[0], maxArray[1]),maxArray[2])).append(" ").append(Math.min(Math.min(minArray[0], minArray[1]),minArray[2]));
        System.out.println(sb.toString());
    }
}