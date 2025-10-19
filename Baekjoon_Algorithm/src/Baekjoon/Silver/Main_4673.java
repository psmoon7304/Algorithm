package Baekjoon.Silver;

public class Main_4673 {
    static StringBuilder sb = new StringBuilder();

    static int[] nums;

    private static void init() {
        nums = new int[10001];
        for(int i = 1; i <= 10000; i++) nums[i] = i;
    }

    private static void getResult() {
        for(int i = 1; i <= 10000; i++) {
            if(nums[i] == 0) continue;
            sb.append(nums[i]).append("\n");
        }
    }

    private static int div(int num) {
        if(num / 10 == 0) return num;
        return (num % 10) + div(num / 10);
    }

    public static void main(String[] args) {
        init();
        for(int i = 1; i <= 10000; i++) {
            int value = i + div(i);
            if(value > 10000) continue;
            nums[value] = 0;
        }
        getResult();
        System.out.println(sb.toString());
    }
}

