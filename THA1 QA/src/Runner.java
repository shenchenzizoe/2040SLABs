public class Runner implements Comparable<Runner> {
    private String name;
    private double time1;
    private double time2;
    Runner(String name, double time1,double time2){
        this.name = name;
        this.time1 = time1;
        this.time2 = time2;
    }
    public String toString(){
        return this.name;
    }
    public double getTime1(){
        return this.time1;
    }
    public double getTime2(){
        return time2;
    }

    @Override
    public int compareTo(Runner runner){
            if(this.time2 > runner.time2){
                return 1;
            }
            if(this.time2 < runner.time2){
                return -1;
            }
            else {
                return 0;
            }
        }
    }

