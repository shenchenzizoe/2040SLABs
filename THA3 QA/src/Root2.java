import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Root2 {
  public int[] arr;
  public HashSet<Integer>[] hsArr;
  public long[] sum;
  public int[] size;

  @SuppressWarnings("unchecked")
  Root2(int n) {
    arr = new int[n];
    hsArr = new HashSet[n];
    sum = new long[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i;
      hsArr[i] = new HashSet<Integer>();
      sum[i] = i;
      size[i] = 1;
    }
}

  public int searchRoot(int i) {
    if (arr[i] == i) {
      return i;
    }
      return searchRoot(arr[i]);
    }

  public void combine(int first, int second) {
    if (searchRoot(first) != searchRoot(second)) {
      int from = searchRoot(first);
      int to = searchRoot(second);
      hsArr[second].add(from);
      arr[from] = second;
      size[to] += size[from];
      sum[to] += sum[from];
    }
  }

  public void moveSet(int first, int second) {
    if (searchRoot(first) != searchRoot(second)) {
      if (first == searchRoot(second)) {
        int to = searchRoot(second);
        sum[to] += first;
        size[to] += 1;
        hsArr[second].add(first);
        if (!hsArr[first].isEmpty()) {
          Integer[] temp = hsArr[first].toArray(new Integer[hsArr[first].size()]);
          int newTo = temp[0];
          sum[newTo] = sum[first]-first;
          sum[first] = first;
          size[newTo] = size[first] - 1;
          size[first] = 1;
          for (Integer integer : temp) {
            arr[integer] = newTo;
            if (newTo != integer) {
              hsArr[newTo].add(integer);
            }
          }
        }
        hsArr[first] = new HashSet<Integer>();
        arr[first] = second;
      } else {
        int newFrom = searchRoot(first);
        int newTo = searchRoot(second);
        int cur = arr[first];
        hsArr[cur].remove(first);
        sum[newFrom] -= first;
        size[newFrom] -= 1;
        for (Integer integer: hsArr[first]) {
          arr[integer] = cur;
          hsArr[cur].add(integer);
        }
        hsArr[first] = new HashSet<Integer>();
        hsArr[second].add(first);
        arr[first] = second;
        sum[newTo] += first;
        size[newTo] += 1;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] strArr = str.split(" ");
    int num = Integer.parseInt(strArr[0]);
    int command = Integer.parseInt(strArr[1]);
    Root2 root = new Root2(num + 1);
    for (int i = 0; i < command; i++) {
      String str1 = br.readLine();
      String[] strArr1 = str1.split(" ");
      int instruction = Integer.parseInt(strArr1[0]);
      int p = Integer.parseInt(strArr1[1]);
      if(instruction == 1) {
        int q = Integer.parseInt(strArr1[2]);
        root.combine(p,q);
      }
      else if(instruction == 2) {
        int q = Integer.parseInt(strArr1[2]);
        root.moveSet(p,q);
      }
      else {
        int size = root.size[root.searchRoot(p)];
        long sum = root.sum[root.searchRoot(p)];
        System.out.println(size + " " + sum);
      }
    }
    br.close();
  }
}
