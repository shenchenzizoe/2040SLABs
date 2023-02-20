class WeightedPosition implements Comparable<WeightedPosition> {
  final int weight;
  final Position p;

  public WeightedPosition(int weight, Position p) {
    this.weight = weight;
    this.p = p;
  }

  @Override
  public int compareTo(WeightedPosition p) {
    return this.weight - p.weight;
  }
}
