package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] stack;
    static int stackSize, pointer;

    private static void stackPush(int value) {
        stack[++pointer] = value;
    }

    private static int stackPop() {
        return stackEmpty() == 1 ? -1 : stack[pointer--];
    }

    private static int stackSize() {
        return pointer + 1;
    }

    private static int stackEmpty() {
        return pointer == -1 ? 1 : 0;
    }

    private static int stackTop() {
        return stackEmpty() == 1 ? -1 : stack[pointer];
    }

    public static void main(String[] args) throws Exception {
        stackSize = Integer.parseInt(br.readLine().trim());
        stack = new int[stackSize];
        pointer = -1;

        for(int tc = 0; tc < stackSize; tc++) {
            st = new StringTokenizer(br.readLine().trim());
            String act = st.nextToken();
            switch(act) {
                case "push":
                    stackPush(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stackPop()).append("\n");
                    break;
                case "size":
                    sb.append(stackSize()).append("\n");
                    break;
                case "empty":
                    sb.append(stackEmpty()).append("\n");
                    break;
                case "top":
                    sb.append(stackTop()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
