package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] important;
    static int[] que;
    static int fileSize;
    static int filePointer;

    private static int getResult() {
        int i = 0, count = 1;
        while(true) {
            int pointer = getImportant();
            if(i >= fileSize) i = 0;
            if(que[i] >= pointer) {
                if(i == filePointer) return count;
                que[i] = -1;
                important[pointer]--;
                count++;
            }
            i++;
        }
    }

    private static int getImportant() {
        for(int i = 9; i > 0; i--) if(important[i] != 0) return i;
        return 0;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        fileSize = Integer.parseInt(st.nextToken());
        filePointer = Integer.parseInt(st.nextToken());

        important = new int[10];
        que = new int[fileSize];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < fileSize; i++) {
            int temp = Integer.parseInt(st.nextToken());
            important[temp]++;
            que[i] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        int TC = Integer.parseInt(br.readLine().trim());
        for(int T = 0; T < TC; T++) {
            init();
            sb.append(getResult()).append("\n");
        }
        System.out.print(sb.toString());
    }

}
