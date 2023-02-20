public class Vertices implements Comparable<Vertices> {
  public int start;
  public int end;
  public int weight;

  Vertices(int start, int end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  @Override
  public int compareTo(Vertices v) {
    if ( this.weight != v.weight) {
      return this.weight - v.weight;
    }
    else if ((this.start != v.start)) {
      return this.start - v.start;
    } else {
      return this.end - v.end;
    }
  }
}
