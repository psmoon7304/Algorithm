package d1;

import java.util.Scanner;
//import java.io.FileInputStream;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int testCase = 1; testCase <= n; testCase++) {
            String[] nums = sc.nextLine().split(" ");
            double answer = 0;
            for(int i = 0; i < nums.length; i++) answer += Integer.parseInt(nums[i]);
            answer = Math.round(answer / nums.length);
            System.out.println("#" + testCase + " " + (int)answer);
        }
    }
}
