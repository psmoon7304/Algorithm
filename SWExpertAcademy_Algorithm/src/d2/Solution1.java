package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            int answer = 0;
            int[] arraySize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] aArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] bArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int temp, maxArray = Math.max(arraySize[0], arraySize[1]), minArray = Math.min(arraySize[0],arraySize[1]);

            for(int i = 0; i <= maxArray - minArray; i++) {
                temp = 0;
                for(int j = 0; j < minArray; j++) {
                    if(maxArray == bArray.length) {
                        temp += aArray[j] * bArray[j + i];
                    } else {
                        temp += aArray[j + i] * bArray[j];
                    }
                }
                answer = Math.max(answer, temp);
            }
            System.out.println("#" + tc + " " + answer);
        }

    }
}

//