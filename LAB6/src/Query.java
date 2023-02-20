public class Query {
  private int energy;
  private int reward;
  private int count;

  public Query(int energy, int reward, int count) {
    this.reward = reward;
    this.energy = energy;
    this.count = count;
  }

  public int getEnergy() {
    return energy;
  }

  public int getReward() {
    return reward;
  }

  public int getCount() {
    return count;
  }
}
