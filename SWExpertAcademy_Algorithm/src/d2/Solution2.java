package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            int arraySize = Integer.parseInt(br.readLine());
            int[][] square = new int[arraySize][arraySize];

            for(int i = 0; i < arraySize; i++) square[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println("#" + tc);
            for(int i = 0; i < arraySize; i++) {
                for(int j = 0; j < arraySize; j++) {
                    System.out.print(square[arraySize - (j + 1)][i]);
                }
                System.out.print(" ");
                for(int j = 0; j < arraySize; j++) {
                    System.out.print(square[arraySize - (i + 1)][arraySize - (j + 1)]);
                }
                System.out.print(" ");
                for(int j = 0; j < arraySize; j++) {
                    System.out.print(square[j][arraySize - (i + 1)]);
                }
                System.out.println(" ");
            }

        }
    }

}
