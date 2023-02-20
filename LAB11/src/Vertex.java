public class Vertex {
  double x;
  double y;
  int index;
  boolean canJump;
  public Vertex(double x , double y, int index) {
    this.x = x;
    this.y = y;
    this.index = index;
    this.canJump = false;
  }

  public void setCanJump() {
    this.canJump = true;
  }
}
