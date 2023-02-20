/*
Create an Arraylist with all players inside
each player element has her/his own id, and with an array of one folded hand object
while there's more than 1 player inside the player Arraylist, update the array
else, return the player id

updating array function:
with a flag indicating the next hand position
start with the hand of flag index
set 4 status of the hands: folded&fist&palm down&behind

 */
public class Hand {
    private int status;
    private int playerID;

    public Hand(int playerID) {
        this.status = 0;
        this.playerID = playerID;
    }
    public int getStatus() {
        return status;
    }

    /*
        folded = 0;
        fist = 1;
        palm down = 2
        behind = 3
         */
    public void setFist() {
        this.status = 1;
    }

    public void setPalmDown() {
        this.status = 2;
    }

    public int getPlayerID() {
        return playerID;
    }
}
