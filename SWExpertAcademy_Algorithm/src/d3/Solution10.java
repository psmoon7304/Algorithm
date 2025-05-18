package d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution10 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int c = 1; c <= T; c++) {
            String[] info = br.readLine().split(" ");
            int answer = 0;
            int value = Integer.parseInt(info[1]);
            int[] nums = new int[Integer.parseInt(info[0])];
            String[] tempNums = br.readLine().split(" ");
            for(int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(tempNums[i]);
            }
            Arrays.sort(nums);

            for(int i = 0; i < nums.length - 1; i++) {
                int tempAnswer = nums[i], count = 1;
                if(tempAnswer == value) {
                    answer += count;
                    continue;
                }
                for(int j = i + 1; j < nums.length; j++) {
                    tempAnswer += nums[j];
                    count++;
                    if(tempAnswer == value) {
                        answer += count;
                        break;
                    } else if(tempAnswer > value) {
                        break;
                    }
                }
            }
            System.out.println("#" + c + " " + answer);
        }
    }
}
