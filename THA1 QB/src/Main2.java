import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Main2 {
    public static Map < Long, Integer > countFrequencies(ArrayList<Long> list) {
        // hashmap to store the frequency of element
        Map < Long, Integer > hm = new HashMap<>();
        for (Long i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        return hm;
    }
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

        Map < Long, Integer > countMap = countFrequencies(cardList);
        //Set st = (Set) countMap.entrySet();
        //Iterator it = st.iterator();

/*
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            System.out.print(entry.getKey() + " : " + entry.getValue());
        }
*/

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

        for (int i = 1; i <= typeNum; i++) {
            String str2 = br.readLine();
            String[] strArr2 = str2.split(" ");
            int cardCount;
            long opCost = 0;
            long buyPrice = Long.parseLong(strArr2[0]);
            long sellPrice = Long.parseLong(strArr2[1]);
            if (!countMap.containsKey((long)i)) {
                countMap.put((long)i, 0);
            }
                cardCount = countMap.get((long)i);

                if (cardCount == 2) {
                    opCost = 2 * sellPrice;
                }
                else{
                    if (cardCount == 1) {
                        opCost = sellPrice + buyPrice;
                    } else {
                        opCost = 2 * buyPrice;
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
        for(CardType c: typeList){
            // System.out.println("count" + c.getCardCount());
            //System.out.println("buyPrice" + c.getBuyPrice());
           // System.out.println("sellPrice" + c.getSellPrice());
            //System.out.println("opCost" + c.getOpCost());
            profit += (c.getSellPrice() * c.getCardCount());
        }

         for (int m = 0; m < comNum; m++) {
            CardType curType = typeList.get(m);
            long curCount = curType.getCardCount();
                if (curCount == (long)0) {
                    profit -= 2 * curType.getBuyPrice();
                }
                else {
                    if (curCount == (long)1) {

                        profit -= (curType.getBuyPrice() + curType.getSellPrice());
                    }
                    else {
                        profit -= curType.getSellPrice() * 2;
                    }
                }
        }

        System.out.println(profit);
    }
}
