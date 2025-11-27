import java.io.*;

public class Main_Study {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T, K;
    static int[][] alphaInfo;
    static int[] alphaCount;
    static char[] W;

    private static void searchWord() {
        int[] answer = {10001, -1};
        for(int i = 0; i < W.length; i++) {
            int pointer = W[i] - 97;
            alphaCount[pointer]++;
            int alphaC = alphaCount[pointer];
            alphaInfo[pointer][(alphaC - 1) % K] = i;
            if(alphaC < K) continue;
            int temp = alphaInfo[pointer][(alphaC - 1) % K] - alphaInfo[pointer][(alphaC % K)] + 1;
            answer[0] = Math.min(answer[0], temp);
            answer[1] = Math.max(answer[1], temp);
        }
        if(answer[0] == 10001 || answer[1] == -1) sb.append(-1).append("\n");
        else sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
    }

    private static void init() throws Exception {
        W = br.readLine().trim().toCharArray();
        K = Integer.parseInt(br.readLine().trim());
        alphaInfo = new int[26][K];
        alphaCount = new int[26];
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine().trim());
        for(int tc = 0; tc < T; tc++) {
            init();
            searchWord();
        }
        System.out.print(sb.toString());
    }
}