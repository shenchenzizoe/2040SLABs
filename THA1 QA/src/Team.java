import java.util.ArrayList;

public class Team implements Comparable<Team> {
    private ArrayList<Runner> team;
    private double totalTime;
    public Team(ArrayList<Runner> team){
        this.team = team;
        this.totalTime = team.get(0).getTime1();
        for(int i = 1; i < 4; i++) {
           this.totalTime += team.get(i).getTime2();
        }
    }
    public double getTotalTime(){
        return this.totalTime;
    }
    @Override
    public int compareTo(Team team){
        if(this.totalTime > team.totalTime){
            return 1;
        }
        if(this.totalTime < team.totalTime){
            return -1;
        }
        else {
            return 0;
        }
    }
    public Runner getRunner(int i){
        return team.get(i);
    }
}
