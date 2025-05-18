package d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            String[] nums = new String[2];
            nums = br.readLine().split(" ");
            int answer = (Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])) % 24;
            System.out.println("#" + i + " " + answer);
        }
    }
}
