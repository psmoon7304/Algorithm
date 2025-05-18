package d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution9 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            double answer = 0;
            String[] nums = br.readLine().split(" ");
            for(int j = 0; j < Integer.parseInt(nums[2]); j++) {
                answer += Integer.parseInt(nums[0]) * (1 + j * (Integer.parseInt(nums[1]) / 100.0));
            }
            System.out.println("#" + i + " " + (long)answer);
        }
    }
}
