package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player {

    String name;
    private List<Card> cardList;    // 숨겨진 목록
    private List<Card> publicList;  // 공개 목록

    public Player(String name) {
        this.name = name;
        cardList = new ArrayList<>();
        publicList = new ArrayList<>();
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getCardCount() {
        return cardList.size();
    }

    public List<Card> getPublicList() {
        return publicList;
    }

    public void printCardList() {
        System.out.println("[" + name + "]");
        System.out.println("공개한 카드: " + publicList.size() + " 장");
        for (int i = 0; i < publicList.size(); i++) {
            System.out.print(publicList.get(i));
            if (i > 0 && i % 13 == 0) System.out.println();
        }
        System.out.println();

        System.out.println("가지고 있는 카드: " + cardList.size() + " 장");
        for (int i = 0; i < cardList.size(); i++) {
            System.out.print("[" + i + "]" + cardList.get(i));
            if (i > 0 && i % 13 == 0) System.out.println();
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    public void removeDupl() {
        Collections.sort(cardList);

        String temp = "";
        int cnt = 0;

        for (int i = 0; i < cardList.size(); i++) {
            Card curr = cardList.get(i);
            if (!temp.equals(curr.numString)) {
                temp = curr.numString;
                cnt = 1;
            } else {
                cnt++;
                if (cnt == 2) {
                    publicList.add(cardList.get(i));
                    publicList.add(cardList.get(i - 1));
                    cardList.remove(i);
                    cardList.remove(i - 1);
                    i -= 2;
                }
            }
        }
    }

    public Card randomCard() {
        Random random = new Random();
        int index = random.nextInt(cardList.size());
        Card card = cardList.get(index);
        card.index = index;
        cardList.remove(index);

        return card;
    }

}
