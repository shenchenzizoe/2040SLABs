import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    Vertex cur = new Vertex(io.getDouble(), io.getDouble(), 0);
    Vertex dest = new Vertex(io.getDouble(), io.getDouble(), 1);
    ArrayList<Vertex> vertices = new ArrayList<>();
    vertices.add(cur);
    vertices.add(dest);
    ArrayList<Edge> edges = new ArrayList<>();
    edges.add(new Edge(cur, dest));
    edges.add(new Edge(dest, cur));
    int cannonNum = io.getInt();
    double[] tList = new double[cannonNum + 2];
    tList[0] = 0;
    final double INF = 1000000000;
    tList[1] = INF;
    for (int i = 0 ; i < cannonNum; i++) {
      tList[i+2] = INF;
      double cur1 = io.getDouble();
      double dest1 = io.getDouble();
      Vertex curCannon = new Vertex(cur1, dest1, i+2);
      curCannon.setCanJump();
      for (Vertex cur2 : vertices) {
        edges.add(new Edge(cur2, curCannon));
        edges.add(new Edge(curCannon, cur2));
      }
      vertices.add(curCannon);
    }
    for (int i = 0 ; i < cannonNum + 1; i++) {
      for (Edge edge : edges) {
        int curIndex = edge.cur.index;
        int destIndex = edge.dest.index;
        double time = edge.time();
        if (tList[destIndex] > tList[curIndex] + time) {
          tList[destIndex] = tList[curIndex] + time;
        }
      }
    }
    double minTime = tList[1];
    io.println(minTime);
    io.close();
  }
}

