package d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            String[] n = br.readLine().split(" ");
            int[] nums = new int[Integer.parseInt(n[0])];
            for(int j = 1; j <= Integer.parseInt(n[1]); j++) {
                String[] range = br.readLine().split(" ");
                for(int k = Integer.parseInt(range[0]) - 1; k <= Integer.parseInt(range[1]) - 1; k++) {
                    nums[k] = j;
                }
            }
            System.out.print("#" + i + " ");
            for(int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
    }
}
