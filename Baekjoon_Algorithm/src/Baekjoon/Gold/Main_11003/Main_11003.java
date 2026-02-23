package Baekjoon.Gold.Main_11003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, L, firstPointer = 0, lastPointer;
    static int[] numList;
    static int[] indexList;

    private static void getAnswer() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
            while(firstPointer < lastPointer && numList[indexList[lastPointer - 1]] >= numList[i]) {
                lastPointer--;
            }

            indexList[lastPointer++] = i;
            if(indexList[firstPointer] <= i - L) firstPointer++;

            sb.append(numList[indexList[firstPointer]]).append(" ");
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        numList = new int[N];
        indexList = new int[N];
    }

    public static void main(String[] args) throws Exception {
        init();
        getAnswer();
        System.out.print(sb.toString());
    }
}
