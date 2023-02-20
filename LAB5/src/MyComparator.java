import java.util.Comparator;

public class MyComparator implements Comparator<ComparableArray> {
    @Override
    public int compare(ComparableArray o1, ComparableArray o2) {
        if(o1.totalTime() > o2.totalTime()) {
            return 1;
        }
        if (o1.totalTime() < o2.totalTime()) {
            return -1;
        }
        else  {
                return 0;
            }

        }
    }

