import java.util.Comparator;

public class QueryComparator implements Comparator<Query> {
  @Override
  public int compare(Query q1, Query q2) {
      if(q1.getEnergy() < q2.getEnergy()) {
        return -1;
      } else if(q1.getEnergy() > q2.getEnergy()) {
        return 1;
      } else {
        if(q1.getReward() < q2.getReward()) {
          return -1;
        } else if(q1.getReward() > q2.getReward()) {
          return 1;
        } else {
          if(q1.getCount() < q2.getCount()) {
            return -1;
          } else if(q1.getCount() > q2.getCount()) {
            return 1;
          } else {
            return 0;
          }
        }
      }
    }
  }

