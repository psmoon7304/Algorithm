package d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            int[][] nums = new int[n][n];
            for(int j = 0; j < n; j++) {
                String[] tempNums = br.readLine().split(" ");
                for(int k = 0; k < n; k++) {
                    nums[j][k] = Integer.parseInt(tempNums[k]);
                }
            }
            for(int j = n - 1; j > 0; j--) {
                if(nums[0][j] !=  j + 1) {
                    for(int k = j; k > 0; k--) {
                        int temp = nums[0][k];
                        nums[0][k] = nums[k][0];
                        nums[k][0] = temp;
                    }
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}

