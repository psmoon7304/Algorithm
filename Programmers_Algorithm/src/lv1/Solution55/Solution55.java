package lv1.Solution55;

public class Solution55 {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int lowNum = arr[0], pointer = 0;
        if(arr.length == 1) return new int[]{-1};
        for(int i = 1; i < arr.length; i++) if(arr[i] < lowNum) lowNum = arr[i];
        for(int i : arr) if(i != lowNum) answer[pointer++] = i;
        return answer;
    }
}
