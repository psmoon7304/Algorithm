package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_14510 {
    static int testCase, N;
    static int highTree;
    static int[] treeList;
    static int[] diffHeights;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testCase; i++) {
            N = Integer.parseInt(br.readLine());
            treeList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int odd = 0, even = 0, sum = 0, answer = 0;
            diffHeights = new int[N];
            Arrays.sort(treeList);
            highTree = treeList[treeList.length - 1];

            for(int j = 0; j < N; j++) {
                diffHeights[j] = highTree - treeList[j];
                if(diffHeights[j] % 2 == 1) {
                    odd++;
                }
                even += diffHeights[j] / 2;
                sum += diffHeights[j];
            }
            if(odd>even) {
                answer = (odd) * 2 - 1;
            } else {
                answer = (sum/3) * 2 + sum % 3;
            }
            System.out.println("#" + i + " " + answer);
        }
    }
}
