package Baekjoon.Silver.Main_1316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Character> alpha;
    static int N, answer;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            int check = 0;
            char lastChar = ' ';
            alpha = new ArrayList<>();
            char[] chr = br.readLine().toCharArray();
            for(int j = 0; j < chr.length; j++) {
                char value = chr[j];
                if(alpha.contains(value) && lastChar != value) {
                    check = 1;
                    break;
                }
                alpha.add(value);
                lastChar = value;
            }
            if(check != 1) answer++;
        }
        System.out.println(answer);
    }
}
