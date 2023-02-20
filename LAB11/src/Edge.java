public class Edge {
  Vertex cur;
  Vertex dest;
  public Edge(Vertex cur, Vertex dest) {
    this.cur = cur;
    this.dest = dest;
  }
  public double time() {
    double dist = Math.sqrt((cur.x-dest.x)*(cur.x-dest.x) +
        (cur.y-dest.y)*(cur.y-dest.y));
    if (cur.canJump) {
      return Math.min(Math.abs(dist-50)/5 + 2, dist/5);
    }
    else {
      return dist/5;
    }
  }
}
