//Shen Chenzi_A0244112X_LAB1
import java.util.Scanner;
public class peasoup {
    public static String peasoup = "pea soup";
    public static String pancakes = "pancakes";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resNum = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < resNum; i++) {
            int itemNum = Integer.parseInt(sc.nextLine());
            String resName = sc.nextLine();
            int peasoupFlag = 0;
            int pancakesFlag = 0;
            for (int j = 0; j < itemNum; j++) {
                String currItem = sc.nextLine();
                if (currItem.equals(peasoup)) {
                    peasoupFlag++;
                }
                if (currItem.equals(pancakes)) {
                    pancakesFlag++;
                }
                if (peasoupFlag == 1 && pancakesFlag == 1) {
                    System.out.println(resName);
                    return;
                }
            }
        }
            System.out.println("Anywhere is fine I guess");
    }
}


