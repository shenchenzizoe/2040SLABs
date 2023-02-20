import java.util.*;
import java.io.*;

public class Dominos {
  public static void main(String[] args) throws Exception {
    Kattio io = new Kattio(System.in, System.out);

    int num =io.getInt();
    for (int i = 0; i < num; i++) {
      int domNum = io.getInt();
      int lineNum = io.getInt();
      Combine[] combine = new Combine[domNum + 1];
      for (int j = 1; j < domNum + 1; j++) {
        combine[j] = new Combine();
      }
      for (int j = 0; j < lineNum; j++) {
        combine[io.getInt()].add(io.getInt());
      }
      boolean[] track =new boolean[domNum + 1];
      ArrayList<Integer> curList = new ArrayList<>();
      for (int j = 1; j < domNum+1 ; j++) {
        if (!track[j]) {
          update(track, curList, j, combine);
        }
      }
      Arrays.fill(track, false);
      int result =0;
      while (!curList.isEmpty()) {
        int length = curList.size();
        int j = curList.get(length - 1);
        curList.remove(length - 1);
        if(!track[j]){
          result += 1;
          DFS(combine,j,track);
        }
      }
      io.println(result);
    }
    io.flush();
  }

  public static void update(boolean[] track, ArrayList<Integer> list,
                            int dom, Combine[] combines){
    track[dom]=true;
    for(int i : combines[dom]) {
      boolean curVisit = track[i];
      if (!curVisit) {
        update(track,list,i, combines);
      }
    }
    list.add(dom);
  }

  public static void DFS(Combine[] combines, int dom, boolean[] track){
    track[dom] = true;
    for(int i : combines[dom]){
      if(!track[i]){
        DFS(combines, i, track);
      }
    }
  }
}