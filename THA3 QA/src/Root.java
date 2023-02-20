import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Root {
  private Root root;
  private int rank;
  private int size;
  private long sum;

  public Root(int size, int sum, int rank) {
    this.size = size;
    this.rank = rank;
    this.sum = sum;
    this.root = null;
  }

  public Root searchRoot() {
    Root r = this;
    while (r.root != null) {
      r = r.root;
    }
    return r;
  }

  public static void combine(int first, int second, Root[] list) {
    //System.out.println("first " + first + " second " + second );
    Root firstRoot = list[first].searchRoot();
    Root secondRoot = list[second].searchRoot();
    int rank1 = firstRoot.rank;
    int rank2 = secondRoot.rank;
    if(rank1 >= rank2) {
      secondRoot.root = firstRoot;
      firstRoot.sum += secondRoot.sum;
      firstRoot.size += secondRoot.size;
    }
    else {
      firstRoot.root = secondRoot;
      secondRoot.sum += firstRoot.sum;
      secondRoot.sum += firstRoot.sum;
    }
    //System.out.println("successful combine");
  }

  public static void move(int from, int to, Root[] list) {
    if (!list[from].searchRoot().equals(list[to].searchRoot())) {
      list[from].searchRoot().sum -= from;
      list[from].searchRoot().size -= 1;
      list[from] = list[to].searchRoot();
      list[to].searchRoot().sum += from;
      list[to].searchRoot().size += 1;
    }
  }

  public static void print(int cur, Root[] list) {
    System.out.println(list[cur].searchRoot().size + " " + list[cur].searchRoot().sum);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] strArr = str.split(" ");
    int num = Integer.parseInt(strArr[0]);
    int command = Integer.parseInt(strArr[1]);
    Root[] list = new Root[num + 1];
    list[0] = null;
    for(int i = 1; i < num + 1; i++) {
      list[i] = new Root(1, i, 0);
    }
    for (int j = 0; j < command; j++) {
      String str1 = br.readLine();
      String[] strArr1 = str1.split(" ");
      int instruction = Integer.parseInt(strArr1[0]);
      int p = Integer.parseInt(strArr1[1]);
      if(instruction == 1) {
        int q = Integer.parseInt(strArr1[2]);
        combine(p,q,list);
      }
      else if(instruction == 2) {
        int q = Integer.parseInt(strArr1[2]);
        move(p,q,list);
      }
      else {
        print(p,list);
      }
    }
    br.close();
  }
}
