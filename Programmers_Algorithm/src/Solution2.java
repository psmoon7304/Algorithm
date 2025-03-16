import java.util.Map;
import java.util.HashMap;

public class Solution2 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playersRank = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            playersRank.put(players[i], i);
        }
        for(String callingName : callings) {
            int rank = playersRank.get(callingName);
            String tempPlayer = players[rank-1];
            players[rank-1] = players[rank];
            players[rank] = tempPlayer;
            playersRank.put(callingName, rank-1);
            playersRank.put(tempPlayer, rank);
        }
        return players;
    }
}


/* 초기 작성 코드
public class Solution {
    public String[] solution(String[] players, String[] callings) {
        String tempName;
        for(String callingName : callings) {
            for(int i = 0; i < players.length; i++) {
                if(players[i].equals(callingName)) {
                    tempName = players[i];
                    players[i] = players[i-1];
                    players[i-1] = tempName;
                    break;
                }
            }
        }
        return players;
    }
}
 */
