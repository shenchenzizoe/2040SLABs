/*
new a scanner sc to receive the input
use hasNextInt to check if we have run through all of the cases,
if so, return
if not
for each case, we use a for loop
int i = 0; i < n；i++
read the next line, and also read the ASCII value of its first and second letter
for each line,
create an instance of a new class Name that extends Comparable,
with fields: first letter ASCII, second letter ASCII
 rewrite the compareTo method so that it compares the first letter ASCII first,
return 1 if greater than, -1 if not, 0 if equal
also rewrite the toString method to let them return the line they read in
put all of them into a java.List
call List.sort(）method
use for loop to print out all of the object inside the sorted list. (call toString method of Name)
print(\n\n) after each case done

 */
import javax.naming.InvalidNameException;
import javax.naming.Name;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        } else {
            while (sc.hasNextInt()) {
                List<stuName> stuNameList = new ArrayList<>();
                int num = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < num; i++) {
                    String input = sc.nextLine();
                    String[] strArray = input.split("");
                    int first = (strArray[0].charAt(0));
                    int second = (strArray[1].charAt(0));
                    stuName name = new stuName(input, first, second);
                    stuNameList.add(name);
                }
                Collections.sort(stuNameList);
                for (stuName s : stuNameList) {
                    System.out.println(s.toString());
                }
                System.out.println("\n");
            }

        }
    }
}

