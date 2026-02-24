package Baekjoon.Platinum.Main_15678;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15678 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, D, pos, firstPointer, lastPointer;
    static int[] numList;
    static int[] indexList;
    static boolean[] isVisited;

    private static Long getAnswer() throws Exception {
        Long answer = 0L;
        Long realAnswer = Long.MIN_VALUE;
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            numList[i] = value;
            if(value >= 0) {
                pos = i;
                answer += value;
                realAnswer = Math.max(answer ,realAnswer);
            } else {
                while(firstPointer < lastPointer && numList[indexList[lastPointer - 1]] <= numList[i]) {
                    lastPointer--;
                }
                indexList[lastPointer++] = i;
                if(pos <= i - D) {
                    pos = indexList[firstPointer];
                    answer += numList[indexList[firstPointer++]];
                    realAnswer = Math.max(answer ,realAnswer);
                }
            }
        }
        return realAnswer;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        numList = new int[N + 1];
        indexList = new int[N + 1];
        isVisited = new boolean[N + 1];
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(getAnswer());
    }
}
