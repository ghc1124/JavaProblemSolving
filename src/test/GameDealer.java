package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameDealer {

    private String[] suit = { "♣", "♠", "◆", "♥" };
    private String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private String joker = "Joker";

    private List<Card> cardList = new ArrayList<>();

    private Player computer, human;

    public GameDealer() {
        int suitLen = suit.length;
        int numberLen = number.length;

        computer = new Player("Computer");
        human = new Player("Human");

        System.out.println("<< 카드 생성 >>");

        for (int i = 0; i < suitLen; i++) {
            for (int j = 0; j < numberLen; j++) {
                Card card = new Card(suit[i], number[j]);
                cardList.add(card);
                System.out.print(card);
            }
            System.out.println();
        }

        cardList.add(new Card("🃏", joker));
        System.out.println(cardList.get(cardList.size() - 1));
        System.out.println();
        System.out.println("<< 처음 딜러가 나누어 준 카드>>");
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public void deal() {
        shuffle();

        List<Card> computerCard = new ArrayList<>();
        List<Card> humanCard = new ArrayList<>();

        for (int i = 0; i < 27; i++) {
            computerCard.add(cardList.remove(0));
        }

        for (int i = 0; i < 26; i++) {
            humanCard.add(cardList.remove(0));
        }

        computer.setCardList(computerCard);
        human.setCardList(humanCard);

        computer.printCardList();
        human.printCardList();
        Scanner scanner = new Scanner(System.in);

        int cnt = 1;

        while (computer.getCardCount() > 0 && human.getCardCount() > 0) {
            if (cnt > 1) {
                System.out.println("다음 단계 게임 진행을 위해 Enter 키를 누르세요!");
                scanner.nextLine();
            }

            System.out.println("<< " + cnt++ + " 단계 >>");
            System.out.println();

            if (cnt > 2) {
                System.out.println("상대방의 카드를 선택하세요 (Random)");
                System.out.println("===================================");
                Card hCard = human.randomCard();
                Card cCard = computer.randomCard();
                System.out.println("Computer 선택: [" + hCard.index + "]" + hCard + " 가져옴");
                System.out.println("Human 선택: [" + cCard.index + "]" + cCard + " 가져옴");

                // 상대방 카드 가져오기
                computer.getCardList().add(hCard);
                human.getCardList().add(cCard);

                computer.printCardList();
                human.printCardList();
            }
            // 중복 제거 및 리스트 이동 -> 카드 갖고 와서 한번 더 실행
            computer.removeDupl();
            human.removeDupl();

            System.out.println("일치하는 숫자를 가진 카드 공개(2장씩 허용)");
            computer.printCardList();
            human.printCardList();
        }

        System.out.println("경기 종료: " + (computer.getCardCount() != 0 ? computer.name : human.name) + " 가 " + joker + " 를 가지고 있음");
    }

}
