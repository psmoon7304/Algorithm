package d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            int n = Integer.parseInt(br.readLine());
            String[] tempNums = br.readLine().split(" ");
            int[] nums = new int[tempNums.length];

            for(int j = 0; j < tempNums.length; j++) {
                nums[j] = Integer.parseInt(tempNums[j]);
            }
            Arrays.sort(nums);
            for(int j = 0; j < n; j++) {
                str.insert(nums[j] + j,"-");
            }
            System.out.println("#" + i + " " + str.toString());
        }
    }
}
