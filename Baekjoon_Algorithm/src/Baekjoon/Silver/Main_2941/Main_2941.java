package Baekjoon.Silver.Main_2941;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int answer;
    static char[] alpha;
    static ArrayList<String> alphaList = new ArrayList<>(Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));

    public static void main(String[] args) throws Exception {
        alpha = br.readLine().trim().toCharArray();
        for(int i = 0; i < alpha.length; i++) {
            sb.append(alpha[i]);
            if(sb.length() < 2) continue;
            if(alphaList.contains(sb.toString())) {
                answer++;
                sb.setLength(0);
                continue;
            } else if("dz".contentEquals(sb.toString())) continue;
            answer += sb.length() - 1;
            sb.delete(0,sb.length() - 1);
        }
        answer += sb.length();
        System.out.print(answer);
    }
}
