import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int runnerNum = sc.nextInt();
        sc.nextLine();
        ArrayList<Runner> runnerList = new ArrayList<>();
        for(int i = 0; i < runnerNum; i++){
            String name = sc.next();
            double time1 = sc.nextDouble();
            double time2 = sc.nextDouble();
            sc.nextLine();
            Runner runner = new Runner(name,time1,time2);
            runnerList.add(runner);
        }
        Collections.sort(runnerList);
        ArrayList<Team> TeamList = new ArrayList<>();
        for (Runner r: runnerList){
           ArrayList<Runner> curList = new ArrayList<>();
           curList.add(r);
            for(int i = 0; i < 3; i++) {
                Runner curRunner = runnerList.get(i);
                if(curRunner.equals(r)){
                    curList.add(runnerList.get(3));
                }
                else {
                    curList.add(runnerList.get(i));
                }
            }
            Team curTeam = new Team(curList);
            TeamList.add(curTeam);
        }
        Collections.sort(TeamList);
        Team firstTeam = TeamList.get(0);
        double totalTime = firstTeam.getTotalTime();
        System.out.println(totalTime);
        for (int i = 0; i < 4; i++) {
            System.out.println(firstTeam.getRunner(i).toString());
        }
    }
}
