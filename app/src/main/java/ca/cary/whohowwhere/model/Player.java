package ca.cary.whohowwhere.model;

import android.util.Log;

import java.util.HashSet;
import java.util.List;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Player {

    private final int id;
    private final String name;
    private final int numCardsInHand;

    private HashSet<Card> cardsInHand;
    private List<UnclearPossess> unclearPossesses;
    private HashSet<Card> cardsNotInHand;
    private List<Possibility> possibilities;

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Player)) {
            return false;
        }

        Player player = (Player) object;

        return id == player.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Player(int id, String name, int numCardsInHand) {
        this.id = id;
        this.name = name;
        this.numCardsInHand = numCardsInHand;

        cardsInHand = new HashSet<>();
        unclearPossesses = null;
        cardsNotInHand = new HashSet<>();
        possibilities = null;
    }

    void addCardsInHand(final Card card) {
        if (cardsNotInHand.contains(card)) {
            Log.e("ERROR", "Player: \"" + id + "/" + name + "\" already defined not owning Card: \"" + card.getName() + "\"");
            return;
        } else if (cardsInHand.contains(card)) {
            Log.i("INFO", "Player: \"" + id + "/" + name + "\" already defined owning Card: \"" + card.getName() + "\"");
            return;
        } else if (cardsInHand.size() >= numCardsInHand) {
            Log.e("ERROR", "Player: \"" + id + "/" + name + "\" Card Limit exceeded");
            return;
        }

        cardsInHand.add(card);
    }

    void setUnclearPossesses(final List<UnclearPossess> unclearPossesses) {
        if (cardsInHand.size() >= numCardsInHand) {
            Log.e("ERROR", "Player: \"" + id + "/" + name + "\" Card Limit exceeded");
            return;
        }

        this.unclearPossesses = unclearPossesses;
    }

    void addCardsNotInHand(final Card card) {
        if (cardsInHand.contains(card)) {
            Log.e("ERROR", "Player: \"" + id + "/" + name + "\" already defined owning Card: \"" + card.getName() + "\"");
            return;
        } else if (cardsNotInHand.contains(card)) {
            Log.i("INFO", "Player: \"" + id + "/" + name + "\" already defined not owning Card: \"" + card.getName() + "\"");
            return;
        }

        cardsNotInHand.add(card);
    }

    void setPossibilities(final List<Possibility> possibilities) {
        if (cardsInHand.size() >= numCardsInHand) {
            Log.e("ERROR", "Player: \"" + id + "/" + name + "\" Card Limit exceeded");
            return;
        }

        this.possibilities = possibilities;
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

    public HashSet<Card> getCardsInHand() {
        return cardsInHand;
    }

    public List<UnclearPossess> getUnclearPossesses() {
        return unclearPossesses;
    }

    public HashSet<Card> getCardsNotInHand() {
        return cardsNotInHand;
    }

    public List<Possibility> getPossibilities() {
        return possibilities;
    }

}
