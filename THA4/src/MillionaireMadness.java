import java.util.*;

public class MillionaireMadness {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int row = io.getInt();
    int column = io.getInt();

    Position[][] grid = new Position[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        grid[i][j] = new Position(i, j, io.getInt());
      }
    }

    PriorityQueue<WeightedPosition> positions = new PriorityQueue<>();
    WeightedPosition start = new WeightedPosition(0, grid[0][0]);
    positions.add(start);

    int[][] step = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    ArrayList<WeightedPosition> temp = new ArrayList<>();

    while (!positions.isEmpty()) {
      WeightedPosition wp = positions.poll();
      Position curPosition = wp.p;

      if (curPosition.equals(grid[row - 1][column - 1])) {
        temp.add(wp);
        break;
      }

      if (!curPosition.visit) {
        curPosition.visit();
        temp.add(wp);

        for (int i = 0; i < 4; i++) {
          int r = curPosition.row + step[i][0];
          int c = curPosition.col + step[i][1];

          if (r >= 0 && r < row && c >= 0 && c < column) {
            Position next = grid[r][c];
            int weight = Math.max(next.height - curPosition.height, 0);
            positions.add(new WeightedPosition(weight, next));
          }
        }
      }
    }

    int maxHeight = 0;
    for(WeightedPosition wp: temp) {
      if(wp.weight > maxHeight) {
        maxHeight = wp.weight;
      }
    }

    io.print(maxHeight);
    io.flush();
  }
}

