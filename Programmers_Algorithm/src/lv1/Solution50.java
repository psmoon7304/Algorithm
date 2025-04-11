package lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution50 {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(!(list.contains(numbers[i] + numbers[j]))) list.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray(); // i->i = Integer::intValue
        Arrays.sort(answer);
        return answer;
    }
}
