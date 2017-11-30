package ca.cary.whohowwhere.model;

import ca.cary.whohowwhere.data.CardType;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Card {

    private String name;
    private CardType cardType;

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Card)) {
            return false;
        }

        Card card = (Card) object;

        return (name == null) ? (card.name == null) : name.equals(card.name);
    }

    @Override
    public int hashCode() {
        return (name == null) ? 0 : name.hashCode();
    }

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
