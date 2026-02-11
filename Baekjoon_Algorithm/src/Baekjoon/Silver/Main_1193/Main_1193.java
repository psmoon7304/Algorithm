package Baekjoon.Silver.Main_1193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] prefixSum;

    public static void main(String[] args) throws Exception {
            sb.setLength(0);
            int target = Integer.parseInt(br.readLine().trim());
            prefixSum = new int[10000001];

            for (int i = 1; i <= 10000000; i++) {
                prefixSum[i] = prefixSum[i - 1] + i;
                if (prefixSum[i] >= target) {
                    if (prefixSum[i] == target) {
                        if (i % 2 != 0) sb.append(1).append("/").append(i);
                        else sb.append(i).append("/").append(1);
                    } else {
                        if ((i - 1) % 2 != 0)
                            sb.append(1 + (target - (prefixSum[i - 1] + 1))).append("/").append(i - (target - (prefixSum[i - 1] + 1)));
                        else
                            sb.append(i - (target - (prefixSum[i - 1] + 1))).append("/").append(1 + (target - (prefixSum[i - 1] + 1)));
                    }
                    break;
                }
            }
            System.out.println(sb.toString());

    }
}
