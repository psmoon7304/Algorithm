package Baekjoon.Silver.Main_28292ver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_28292ver2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int num = Integer.parseInt(br.readLine().trim());
        if(num <= 2) System.out.print(1);
        else if(num <= 5) System.out.print(2);
        else System.out.print(3);
    }
}
