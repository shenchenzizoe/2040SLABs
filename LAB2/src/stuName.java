public class stuName implements Comparable<stuName> {
    private String input;
    private int first;
    private int second;

    public stuName(String input, int first, int second) {
        this.input = input;
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(stuName name) {
        if (this.first > name.first) {
            return 1;
        }
        if (this.first < name.first) {
            return -1;
        } else {
            if (this.second > name.second) {
                return 1;
            }
            if (this.second < name.second) {
                return -1;
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.input;
    }
}
