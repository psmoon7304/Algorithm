package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12915 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] num = new int[5];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < 5; i++) num[i] = Integer.parseInt(st.nextToken());
        if(num[0] + num[1] == 0 || num[3] + num[4] == 0) {
            System.out.print(0);
            return;
        }
        while(num[1] != 0 || num[3] != 0) {
            if(num[1] >= num[3] && num[1] != 0) {
                num[1]--;
                if(num[0] > num[2]) num[2]++;
                else num[0]++;
            } else if(num[1] <= num[3] && num[3] != 0) {
                num[3]--;
                if(num[4] > num[2]) num[2]++;
                else num[4]++;
            } else break;
        }
        int temp = Math.min(num[0], num[2]);
        System.out.print(Math.min(temp, num[4]));
    }
}
