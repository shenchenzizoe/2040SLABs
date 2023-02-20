public class Position {
  final int row;
  final int col;
  final int height;
  boolean visit = false;

  public Position(int row, int col, int height) {
    this.row = row;
    this.col = col;
    this.height = height;
  }

  public void visit() {
    this.visit = true;
  }
  }

