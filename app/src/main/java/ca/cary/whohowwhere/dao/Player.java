package ca.cary.whohowwhere.dao;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Player {

    private final int id;
    private final String name;
    private final int numCardsInHand;

    private HashMap<String, Card> cardsInHand;
    private HashMap<String, Card> cardsMayInHand;
    private HashMap<String, Card> cardsNotInHand;

    public Player(int id, String name, int numCardsInHand) {
        this.id = id;
        this.name = name;
        this.numCardsInHand = numCardsInHand;

        cardsInHand = new HashMap<>();
        cardsMayInHand = new HashMap<>(Deck.getInstance().getCardHashMap());
        cardsNotInHand = new HashMap<>();
    }

    public void setCardsInHand(Card card) {
        if (cardsInHand.containsKey(card.getName())) {
            Log.d("INFO", "Already have card: " + card.getName() + " in cardsInHand map");
            return;
        }

        if (cardsMayInHand.containsKey(card.getName())) {
            cardsMayInHand.remove(card.getName());
            cardsInHand.put(card.getName(), card);
        } else {
            Log.e("ERROR", "Don't contain card: " + card.getName() + " in cardsMayInHand map");
        }
    }

    public void setCardsNotInHand(Card card) {
        if (cardsNotInHand.containsKey(card.getName())) {
            Log.d("INFO", "Already have card: " + card.getName() + " in cardsNotInHand map");
            return;
        }

        if (cardsMayInHand.containsKey(card.getName())) {
            cardsMayInHand.remove(card.getName());
            cardsNotInHand.put(card.getName(), card);
        } else {
            Log.e("ERROR", "Don't contain card: " + card.getName() + " in cardsMayInHand map");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumCardsInHand() {
        return numCardsInHand;
    }

    public HashMap<String, Card> getCardsInHand() {
        return cardsInHand;
    }

    public HashMap<String, Card> getCardsMayInHand() {
        return cardsMayInHand;
    }

    public HashMap<String, Card> getCardsNotInHand() {
        return cardsNotInHand;
    }

}
