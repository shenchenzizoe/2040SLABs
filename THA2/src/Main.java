import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("");
        int stringNum = Integer.parseInt(strArr[0]);
        MyList[] arr = new MyList[stringNum];
        for(int i = 0; i < stringNum; i++) {
            String curWord = br.readLine();
            arr[i] = new MyList(curWord);
        }
        MyList a = null;
        MyList b = null;
        int first = 1;
        int second = 1;
        for(int j = 0; j < stringNum - 1; j++){
            String str1 = br.readLine();
            String[] strArr1 = str1.split(" ");
            first = Integer.parseInt(strArr1[0]);
            second = Integer.parseInt(strArr1[1]);
            a = arr[first - 1];
            b = arr[second - 1];
            if(a.head == null) {
                a.tail = b;
            }
            else {
                a.head.tail = b;
            }

            if(b.tail == null) {
                a.head = b;
            }
            else {
                a.head = b.head;
            }
        }

        br.close();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for(a = arr[first - 1]; a.tail != null; a = a.tail){
                pw.print(a.curWord);
        }

        pw.print(a.curWord);
        pw.close();
    }
}
