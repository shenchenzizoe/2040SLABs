import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read first line, with cardNum, typeNum, and comNum
        String str = br.readLine();
        String[] strArr = str.split(" ");
        long cardNum = Long.parseLong(strArr[0]);
        long typeNum = Long.parseLong(strArr[1]);
        long comNum = Long.parseLong(strArr[2]);
        //move to the next line
        //read the line and put all the integers into an arrayList
        String str1 = br.readLine();
        String[] strArr1 = str1.split(" ");
        ArrayList<Long> cardList = new ArrayList<>();
        for (int i = 0; i < cardNum; i++) {
            long card = Long.parseLong(strArr1[i]);
            cardList.add(card);
        }
        ArrayList<Long> shortList = (ArrayList<Long>) cardList.clone();
        for (int k = 0; k < cardNum - 1; k++) {
            if (shortList.get(k) == shortList.get(k + 1)) {
                shortList.remove(k);
            }
        }
        /*for 0 <= i < typeNUm
        read next line();
        new a Type Object, with the CardInt, the sell price, buy price, and the opportunity cost of that card
        (get CardInt(arrayList(i)) and the total number of the card(Collections.frequency)
         from the arrayList)
         (calculate the opportunity cost by reading the buy and sell price of the card
         and the number of the card)
         add the Type Object to another arrayList and sort them by the opportunity cost
         */
        ArrayList<CardType> typeList = new ArrayList<>();
        for (int j = 0; j < typeNum; j++) {
            String str2 = br.readLine();
            String[] strArr2 = str2.split(" ");
            long cardCount;
            long opCost = 0;
            long buyPrice = Long.parseLong(strArr2[0]);
            long sellPrice = Long.parseLong(strArr2[1]);
            if (j >= cardNum) {
                cardCount = 0;
                opCost = 2 * buyPrice;
            } else {
                long card = shortList.get(j);
                cardCount = Collections.frequency(cardList, card);
                if (cardCount == 2) {
                    opCost = 2 * sellPrice;
                }
                if (cardCount == 1) {
                    opCost = sellPrice + buyPrice;
                }
            }
            CardType cur = new CardType(opCost, buyPrice, sellPrice,cardCount);
            typeList.add(cur);
        }
        br.close();
        //sort the List of the Type Objects and use a for loop to get the first
        // comNum of Types, calculate the cost of buying them and the gain of selling the rest
        //calculates the total profit
        Collections.sort(typeList);
        long profit = 0;
        for (int m = 0; m < typeNum; m++) {
            CardType curType = typeList.get(m);
            long curCount = curType.getCardCount();
            if (m < comNum) {
                if (curCount == 0) {
                    profit -= 2 * curType.getBuyPrice();
                }
                else if (curCount == 1) {
                    profit -= curType.getBuyPrice();
                }
            } else {
                profit += curType.getSellPrice() * curCount;
            }
        }
        System.out.println(profit);
    }
}
