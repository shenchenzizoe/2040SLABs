import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] strArr = str.split(" ");
    int n = Integer.parseInt(strArr[0]);

    while(n != -1){
      ArrayList<Integer>[] all = new ArrayList[n];
      for (int i = 0; i < n; i++) {
        ArrayList<Integer> vertex = new ArrayList<>();
        String str2 = br.readLine();
        String[] strArr2 = str2.split(" ");
        //System.out.println("current n " + n);
        //System.out.println("arrLength " + strArr2.length);
        for (int j = 0; j < n; j++) {
          int curNum = Integer.parseInt(strArr2[j]);
          if(curNum == 1){
            vertex.add(j);
          }
        }
        all[i] = vertex;
      }
      int[] triangle = new int[n];
      for (int i = 0; i < n; i++) {
        for (Integer p : all[i]) {
          for(Integer q : all[p]){
            if( all[i].contains(q)){
              triangle[i] = 1;
              break;
            }
          }
          if(triangle[i] == 1){
            break;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        if(triangle[i] == 0){
          System.out.print(i + " ");
        }
      }
      System.out.println();
      String str1 = br.readLine();
      String[] strArr1 = str1.split(" ");
      n = Integer.parseInt(strArr1[0]);
    }
    br.close();
  }
}

