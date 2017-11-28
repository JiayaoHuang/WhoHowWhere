package ca.cary.whohowwhere.model;

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
        cardsMayInHand = new HashMap<>();
        cardsNotInHand = new HashMap<>();
    }

    void addCardsInHand(Card card) {
        if (cardsNotInHand.containsKey(card.getName())) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined not having by this player: \"" + id + "/" + name + "\"");
            return;
        } else if (cardsInHand.containsKey(card.getName())) {
            Log.i("INFO", "Card: \"" + card.getName() + "\" already defined having by this player: \"" + id + "/" + name + "\"");
            return;
        } else if (cardsInHand.keySet().size() >= numCardsInHand) {
            Log.e("ERROR", "Card limit exceeded for this player: \"" + id + "/" + name + "\"");
            return;
        }

        cardsInHand.put(card.getName(), card);

        if (cardsMayInHand.containsKey(card.getName())) {
            cardsMayInHand.remove(card.getName());
        }
    }

    void addCardsMayInHand(Card card) {
        if (cardsNotInHand.containsKey(card.getName())) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined not having by this player: \"" + id + "/" + name + "\"");
            return;
        } else if (cardsInHand.containsKey(card.getName())) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined having by this player: \"" + id + "/" + name + "\"");
            return;
        }

        if (!cardsMayInHand.containsKey(card.getName())) {
            cardsMayInHand.put(card.getName(), card);
        }
    }

    void addCardsNotInHand(final Card card) {
        if (cardsInHand.containsKey(card.getName())) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined having by this player: \"" + id + "/" + name + "\"");
            return;
        }

        if (!cardsNotInHand.containsKey(card.getName())) {
            cardsNotInHand.put(card.getName(), card);
        }

        if (cardsMayInHand.containsKey(card.getName())) {
            cardsMayInHand.remove(card.getName());
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
