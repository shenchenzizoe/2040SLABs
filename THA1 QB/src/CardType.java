public class CardType implements Comparable<CardType> {
    private long opCost;
    private long buyPrice;
    private long sellPrice;
    private long cardCount;
    public CardType(long opCost, long buyPrice, long sellPrice, long cardCount){
        this.opCost = opCost;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.cardCount = cardCount;
    }


    public long getCardCount() {
        return cardCount;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public long getOpCost() {
        return opCost;
    }

    @Override
    public int compareTo(CardType ct){
        if(this.opCost > ct.opCost){
            return 1;
        }
        if(this.opCost < ct.opCost){
            return -1;
        }
        else {
            return 0;
        }
    }
}
