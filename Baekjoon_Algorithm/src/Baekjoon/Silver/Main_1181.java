package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String>[] word;
    static int N;

    private static void getResult() {
        for(int i = 1; i < 51; i++) {
            if(word[i].isEmpty()) continue;
            if(word[i].size() == 1) {
                sb.append(word[i].get(0)).append("\n");
                continue;
            }
            word[i].sort(null);
            for(String value : word[i]) sb.append(value).append("\n");
        }
    }

    private static void addWord() throws Exception {
        for(int i = 0; i < N; i++) {
            String value = br.readLine().trim();
            if(word[value.length()].contains(value)) continue;
            word[value.length()].add(value);
        }
    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        word = new ArrayList[51];
        for(int i = 1; i < 51; i++) word[i] = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        init();
        addWord();
        getResult();
        System.out.println(sb.toString());
    }
}
