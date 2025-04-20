package lv1;

public class Solution72 {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int check = 0;
                    int num = nums[i] + nums[j] + nums[k];
                    if(num % 2 == 0) continue;
                    for(int m = 3; m * m <= num; m++) {
                        if(num % m == 0) {
                            check = 1;
                            break;
                        }
                    }
                    if(check == 0) answer += 1;
                }
            }
        }
        return answer;
    }
}
