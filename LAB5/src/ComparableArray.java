import java.lang.reflect.Array;

public class ComparableArray implements Comparable<ComparableArray> {
    int[] arr;
    int first;
    int second;

    public ComparableArray(int[] arr) {
        this.arr = arr;
        this.first = arr[0];
        this.second = arr[1];
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int totalTime() {
        return first + second;
    }

    @Override
    public int compareTo(ComparableArray o) {
        if(this.first > o.first) {
            return 1;
        }
        if (this.first < o.first) {
            return -1;
        }
        else  {
            if (this.second > o.second) {
                return 1;
            }
            if (this.second < o.second) {
                return -1;
            }
            else {
                return 0;
            }
        }

    }
}

