package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> deque;
    static int N;

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        deque = new LinkedList<>();
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            String type = st.nextToken();
            int value = 0;
            if(type.equals("push_front")) {
                value = Integer.parseInt(st.nextToken());
                deque.addFirst(value);
            } else if(type.equals("push_back")) {
                value = Integer.parseInt(st.nextToken());
                deque.offer(value);
            } else if(type.equals("pop_front")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.poll()).append("\n");
            } else if(type.equals("pop_back")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollLast()).append("\n");
            } else if(type.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if(type.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if(type.equals("front")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peek()).append("\n");
            } else {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
