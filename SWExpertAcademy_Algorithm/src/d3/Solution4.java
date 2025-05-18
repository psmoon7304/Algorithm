package d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println("#" + i + " " + n*n);
        }
    }
}
