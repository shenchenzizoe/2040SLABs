import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static java.lang.Math.pow;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read first line, with cardNum, typeNum, and comNum
        String str = br.readLine();
        String[] strArr = str.split(" ");
        int froshNum = Integer.parseInt(strArr[0]);
        HashMap<Long, Integer> hm = new HashMap<>();
        for(int i = 0; i < froshNum; i++){
            String str1 = br.readLine();
            String[] strArr1 = str1.split(" ");
            Long combination = Long.valueOf(0);
            int[] comArray = new int[strArr1.length];
            for(int j = 0; j < strArr1.length; j++) {
                int curNum = Integer.parseInt(strArr1[j]);
                comArray[j] = curNum;
            }
            Arrays.sort(comArray);
            /*
            for(int a = 0; a < comArray.length; a++) {
                System.out.println(comArray[a]);
            }
             */
            for(int k = 0; k < comArray.length; k++) {
                int tempNum = comArray[k];
                combination += tempNum;
                combination *= 1000;
            }
            //System.out.println(combination);
                if(hm.containsKey(combination)) {
                    hm.put(combination, hm.get(combination) + 1);
                }
                else {
                    hm.put(combination,1);
                }
            }
        //System.out.println("end");
        br.close();
        int size = hm.size();
        int[] valueArray = new int[size];
        int l = 0;
        for(Long key : hm.keySet()) {
            valueArray[l] = hm.get(key);
            l++;
        }
        Arrays.sort(valueArray);
        //for(int a:valueArray) {
        //System.out.println(a);
        //}

        int largest = valueArray[valueArray.length - 1];
        int sum = 0;
        for(int r = valueArray.length - 1; r >= 0; r--){
            if(valueArray[r] == largest) {
                sum += valueArray[r];
            }
            else {
                break;
            }
        }
        System.out.println(sum);
    }
}
