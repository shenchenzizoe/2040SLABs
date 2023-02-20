public class Player {
    private int playerID;
    private Hand[] hands;
    private static int count = 1;
    private int handFlag;

    public Player(){
        this.playerID = count;
        count++;
        this.hands = new Hand[1];
        this.hands[0] = new Hand(playerID);
        this.handFlag = 0;
    }

    public Hand[] getHands() {
        return hands;
    }

    public Hand getCurHand() {
        return hands[handFlag];
    }

    public boolean pass(){
        return hands.length == 1 || (hands.length == 2 && handFlag == 0);
    }

    public void moveHandFlag(){
        this.handFlag ++;
    }

    public void resetHandFlag() {
        this.handFlag = 0;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void deleteCurHand(){
        Hand copyHand;
        if(handFlag == 0) {
            copyHand = hands[1];
        }
        else {
            copyHand = hands[0];
        }
        Hand[] temp = new Hand[1];
        temp[0] = copyHand;
        this.hands = temp;
    }

    public void split(){
        Hand[] temp = new Hand[2];
        this.hands[0].setFist();
        temp[0] = this.hands[0];
        Hand hand2 = new Hand(playerID);
        hand2.setFist();
        temp[1] = hand2;
    }

    public int getHandFlag() {
        return handFlag;
    }
}
