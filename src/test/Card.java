package test;

public class Card implements Comparable<Card> {

    String suit;
    String numString;
    int index;

    public Card(String suit, String numString) {
        this.suit = suit;
        this.numString = numString;
    }

    @Override
    public String toString() {
        return "(" + suit + "\t" + numString + ")";
    }

    @Override
    public int compareTo(Card o) {
        return this.numString.charAt(0) - o.numString.charAt(0);
    }
}
