import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read first line, with cardNum, typeNum, and comNum
        String str = br.readLine();
        String[] strArr = str.split(" ");
        int researchNum = Integer.parseInt(strArr[0]);
        int time = Integer.parseInt(strArr[1]);
        ArrayList<ComparableArray> events = new ArrayList<>();
        for (int i = 0; i < researchNum; i++) {
            String str1 = br.readLine();
            String[] strArr1 = str1.split(" ");
            int[] intArray = new int[2];
            for (int j = 0; j < 2; j++) {
                int curNum = Integer.parseInt(strArr1[j]);
                intArray[j] = curNum;
            }
            ComparableArray event = new ComparableArray(intArray);
            events.add(event);
        }
        br.close();
        Collections.sort(events);
        PriorityQueue<ComparableArray> queue = new PriorityQueue<>(new MyComparator());
        queue.add(events.get(0));
        int curIndex = 1;
        int count = 0;
        while (curIndex < researchNum) {
            //System.out.println(queue.peek().getFirst() + " " + queue.peek().getSecond());
                ComparableArray curArray = events.get(curIndex);
                //System.out.println("totalTime" + queue.peek().totalTime());
                //System.out.println("this arrive time" + curArray.getFirst());
            while ((!queue.isEmpty()) &&! (queue.peek().totalTime() + time >= curArray.getFirst())) {
                //System.out.println("did go");
                queue.poll();
            }
            if(queue.isEmpty()){
                    queue.add(curArray);
            }
            else if (curArray.getFirst() < queue.peek().totalTime()) {
                    queue.add(curArray);
            }
            else if (queue.peek().totalTime() + time >= curArray.getFirst()) {
                count++;
                queue.poll();
                queue.add(curArray);
            }
            curIndex++;
        }
        System.out.println(count);
    }
}
