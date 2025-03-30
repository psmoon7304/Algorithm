package lv1;

import java.util.HashMap;
import java.util.Map;

public class Solution24 {
    public int solution(int[] nums) {
        Map<Integer, Integer> monster = new HashMap<>();
        for(int num : nums) {
            monster.put(num, monster.getOrDefault(num, 0) + 1);
        }
        if(nums.length / 2 < monster.size()) return nums.length / 2;
        else return monster.size();
    }
}

// HashKey를 이용하여 put 대신 add 사용해도 좋음
