package ca.cary.whohowwhere.dao;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Card {

    private String name;

    private CardType cardType;

    public Card(String name, CardType cardType) {
        this.name = name;
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public CardType getCardType() {
        return cardType;
    }

}
