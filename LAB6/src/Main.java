import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] strArr = str.split(" ");
    int commandNum = Integer.parseInt(strArr[0]);
    TreeMap<Query, Integer> tm = new TreeMap<>(new QueryComparator());
    int count = 0;
    for (int i = 0; i < commandNum; i++) {
      //System.out.println("enter for loop");
      String str1 = br.readLine();
      //System.out.println("read success");
      String[] strArr1 = str1.split(" ");
      //System.out.println("split success");
      //for(String s: strArr1) {
      //  System.out.println(s);
      //}
      if (strArr1[0].equals("add")) {
        //System.out.println("added");
        int energy = Integer.parseInt(strArr1[1]);
        int reward = Integer.parseInt(strArr1[2]);
        Query curQuery = new Query(energy, reward,count);
        tm.put(curQuery, count);
        count++;
      } else {
        int energyConsume = Integer.parseInt(strArr1[1]);
        long sumReward = 0;
        Query predecessor = tm.floorKey(new Query(energyConsume, 100000, 200000));
        Query curPredecessor = predecessor;
        //System.out.println(curPredecessor.getEnergy());
        //System.out.println(curPredecessor.getReward());
        //System.out.println("okhere");
        while (curPredecessor != null && curPredecessor.getEnergy() <= energyConsume) {
          //System.out.println(curPredecessor.getEnergy());
          //System.out.println(curPredecessor.getReward());
          energyConsume -= curPredecessor.getEnergy();
          sumReward += curPredecessor.getReward();
          tm.remove(curPredecessor);
          curPredecessor = tm.floorKey(new Query(energyConsume, 100000, 200000));
        }
        //System.out.println("query done here");
        System.out.println(sumReward);
      }
    }
    br.close();
  }
}
