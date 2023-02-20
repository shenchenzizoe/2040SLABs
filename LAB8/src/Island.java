import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Island {
  public static int r;
  public static int c;
  public static char[][] matrix;
  public static boolean[][] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] strArr = str.split(" ");
    r = Integer.parseInt(strArr[0]);
    c = Integer.parseInt(strArr[1]);
    matrix = new char[r][c];

    for (int i = 0; i < r; i++) {
      String str1 = br.readLine();
      //System.out.println(str1);
      String[] strArr1 = str1.split("");
      for (int j = 0; j < c; j++) {
        matrix[i][j] = strArr1[j].charAt(0);
      }
    }

    br.close();

    visit = new boolean[r][c];
    int count = 0;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (!visit[i][j] && matrix[i][j] == 'L') {
          count++;
          Island.search(i, j);
        }
      }
    }
    System.out.println(count);
  }

  static void search(int i, int j) {
    if (!visit[i][j]) {
      visit[i][j] = true;
      if (matrix[i][j] == 'L' || matrix[i][j] == 'C') {
        if (i > 0) { search( i-1, j ); }
        if (i+1 < r) { search( i+1, j ); }
        if (j > 0) { search( i, j-1 ); }
        if (j+1 < c) { search( i, j+1 ); }
      }
    }
  }
}