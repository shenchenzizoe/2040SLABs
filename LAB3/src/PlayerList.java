import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Hand> list;
    private int handNum;
    public static int Flag = 0;

    public PlayerList(int playerNum){
        this.handNum = playerNum * 2;
        this.list = new ArrayList<>();
        for(int i = 0; i < playerNum; i++){
            Hand hand1 = new Hand(i + 1);
            Hand hand2 = new Hand(i + 1);
            this.list.add(hand1);
            this.list.add(hand2);
        }
    }

    public void decreaseHandNum() {
        this.handNum--;
    }

    public int updateList(int rhyme){
        while (list.size() > 1) {
            int index = Flag % handNum;
            for(int i = 0; i < rhyme - 1; i ++) {
                if(list.get(index).getStatus()== 0){
                    Flag++;
                }
                   Flag++;
                    index = Flag % handNum;
            }
            System.out.println("index begin" + index);
            System.out.println("flag begin" + Flag);
            Hand lastHand = list.get(index);
            /*if the hand is folded, expand the hand array to two fist hands, put the flag at the first fist hand,
            if the hand is fist, change it to palm down, move flag to the next hand
            if it's a palm down, change it to behind, and check if the other hand of the player is behind
	        if so, move flag to the hand of the next player, then delete this player from the list
	        if not, move flag to the next hand as usual, and delete that hand*/
            if(lastHand.getStatus()==0){
                Hand nextOfLast = list.get(index + 1);
                lastHand.setFist();
                nextOfLast.setFist();
                //Flag--;
            }
            else {
                if (lastHand.getStatus() == 1){
                    lastHand.setPalmDown();
                    Flag++;
                    }
                else  {
                        list.remove(lastHand);
                        decreaseHandNum();
                        Flag--;
                    }

                    }
            System.out.println("index end at" + index);
            System.out.println("Flag end at" + Flag);
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).getPlayerID() + "the status" + list.get(i).getStatus());
            }
                }
        return list.get(0).getPlayerID();

            }

        }

