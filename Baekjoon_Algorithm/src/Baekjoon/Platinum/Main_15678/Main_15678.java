package Baekjoon.Platinum.Main_15678;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15678 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, D, firstPointer, lastPointer;
    static int[] numList;
    static int[] indexList;
    static boolean[] isVisited;

    private static Long getAnswer() throws Exception {
        Long answer = 0L;
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i <= N; i++) {
            if(i != 0) {
                int value = Integer.parseInt(st.nextToken());
                numList[i] = value;
            }
            while(firstPointer < lastPointer && numList[indexList[lastPointer - 1]] <= numList[i]) {
                lastPointer--;
            }
            indexList[lastPointer++] = i;
            if(indexList[firstPointer] <= i - D) {
                firstPointer++;
            }
            if(!isVisited[indexList[firstPointer]]) {
                isVisited[indexList[firstPointer]] = true;
                System.out.println(numList[indexList[firstPointer]]);
                answer += numList[indexList[firstPointer]];
            }
        }
        return answer;
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
