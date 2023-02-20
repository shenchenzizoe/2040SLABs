import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
read the size of matrix n, if -1 stops, else:
	instantiate an adjList, add n arrayList<Integer> into the adjList.
	go through the following n lines, when encounter 1, save its row and column number into the adList
	by adjList.get(r).add(c)
check elements of index 1 to n in the arrayList.
	For each index,
	if the index and cur integer are saved in the hashmap already, go to the next integer
	if the index and the integer are not saved in the hashmap already
	(check the index, integer as value, key and also as key, value)
	go to the Arraylist indexed as the integer,
	and check if it has the same integer element as the index Array
	save the index and the integer into the hashmap
	if so, go to the next index
	if not,
	go to the next integer
	at the end of the ArrayList<Integer>, if don't find a triangle, then print (the index)

 **/
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] strArr = str.split(" ");
    int n = Integer.parseInt(strArr[0]);
    while (n != -1) {
      if(n == 0) {
        String str4 = br.readLine();
        String[] strArr4 = str.split(" ");
        n = Integer.parseInt(strArr4[0]);
      }
      ArrayList<ArrayList<Integer>> adjLst = new ArrayList<>();
      //System.out.println("matrix iteration");
      //System.out.println("total rows " + n);
      for (int i = 0; i < n; i++) {
        adjLst.add(new ArrayList<>());
        String str1 = br.readLine();
        String[] strArr1 = str1.split(" ");
        //System.out.println("add row to adList");
        boolean rowInitialized = false;
        for (int j = 0; j < n; j++) {
          int curNum = Integer.parseInt(strArr1[j]);
          //System.out.println("current column num" + curNum);
          if (curNum == 1) {
            adjLst.get(i).add(j);
            rowInitialized = true;
            //System.out.println("add column to the adList");
          }
        }
        /*if(!rowInitialized) {
          adjLst.get(0).add(-1);
        }

         */
      }
      //System.out.println("adList successful");
      //System.out.println("size check " + adjLst.get(0).size());

      HashMap<Integer, Integer> hm = new HashMap<>();
      for (int i = 0; i < n; i++) {
        if(adjLst.get(i).size() == 0) {
          System.out.print(i + " ");
          continue;
        }
        boolean find = false;
        for (int j = 0; j < adjLst.get(i).size(); j++) {
          if ((hm.containsKey(i) && hm.get(i) == j)
              || (hm.containsKey(j) && hm.get(j) == i)) {
            //do nothing
            continue;
          } else {
            ArrayList<Integer> arr1 = adjLst.get(i);
            int index2 = arr1.get(j);
            //System.out.println("index 2 here" + index2);
            ArrayList<Integer> arr2 = adjLst.get(index2);
            hm.put(i, index2);
            for (int k = 0; k < arr1.size(); k++) {
              int cur1 = arr1.get(k);
              for (int m = 0; m < arr2.size(); m++) {
                int cur2 = arr2.get(m);
                if (cur1 == cur2 && cur2 != i && cur2 != index2) {
                  //for the ith row, each vertex ith vertex is connected to
                  //is noted as j
                  //at this point we ensure there is the third vertex connected to
                  //both i and j
                  //so i and j are in the triangle, go to the next i iteration.
                  find = true;
                  break;
                }
              }
              if (find) {
                break;
              }
            }
          }
          if (find) {
            break;
          }
        }
        //System.out.println("reach end of each row");
        //System.out.println(find);
        //if reach here, then for ith vertex, there is no vertex
        // shares common vertex with it
        if (!find) {
          System.out.print(i + " ");
        }
      }

      System.out.println();
      String str2 = br.readLine();
      String[] strArr2 = str2.split(" ");
      n = Integer.parseInt(strArr2[0]);
    }
    br.close();
  }
}
