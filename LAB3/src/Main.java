import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split(" ");
        int rhyme = Integer.parseInt(strArr[0]);
        int playerNum = Integer.parseInt(strArr[1]);
        PlayerList playerList = new PlayerList(playerNum);
        int winnerID = playerList.updateList(rhyme);
        System.out.println(winnerID);
    }
}
