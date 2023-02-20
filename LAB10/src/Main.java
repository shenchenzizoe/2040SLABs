import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] arg) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    ArrayList<Vertices> edgeList = new ArrayList<>();
    UnionFind ufds = new UnionFind(num + 1);

    // For loop to parse information
    for (int i = 1; i < num + 1; i++) {
      String weights[] = br.readLine().split(" ");
      for (int j = i - 1; j < num; j++) {
        Vertices curVertex = new Vertices(i, j + 1, Integer.parseInt(weights[j]));
        edgeList.add(curVertex);
      }
    }
    br.close();
    Collections.sort(edgeList);

    for (Vertices v: edgeList) {
      if (!ufds.isSameSet(v.start, v.end)) {
        ufds.unionSet(v.start, v.end);
        System.out.println(v.start + " " + v.end);
      }
    }
  }
}
