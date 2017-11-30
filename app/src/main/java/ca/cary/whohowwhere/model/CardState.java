package ca.cary.whohowwhere.model;

import android.util.Log;

import java.util.HashSet;
import java.util.List;

/**
 * Created by jiayaohuang on 2017-11-27.
 */

public class CardState {

    private static int numPlayers = 0;

    private final Card card;

    private Player owned;
    private List<UnclearPossess> unclearPossesses;
    private HashSet<Player> notOwnPlayers;
    private List<Possibility> possibilities;

    CardState(Card card) {
        this.card = card;

        this.owned = null;
        unclearPossesses = null;
        notOwnPlayers = new HashSet<>();
        possibilities = null;
    }

    static void setNumPlayers(int numPlayers) {
        CardState.numPlayers = numPlayers;
    }

    public void setOwned(final Player owner) {
        if (owned != null) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined owning by Player: \"" + owned.getId() + "/" + owned.getName() + "\"");
            return;
        } else if (notOwnPlayers.contains(owner)) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined not owning by Player: \"" + owner.getId() + "/" + owner.getName()  + "\"");
            return;
        }

        owned = owner;
        owner.addCardsInHand(card);

        unclearPossesses = null;
        possibilities = null;

        List<Player> players = Game.getGame().getPlayers();
        for (Player player : players) {
            if (!player.equals(owner) && !notOwnPlayers.contains(player)) {
                notOwnPlayers.add(player);
                player.addCardsNotInHand(card);
            }
        }
    }

    public void setUnclearPossesses(List<UnclearPossess> unclearPossesses) {
        if (owned != null) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined owning by Player: \"" + owned.getId() + "/" + owned.getName() + "\"");
            return;
        } else if (notOwnPlayers.size() >= numPlayers) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined not owning by any Player in Game");
            return;
        }

        this.unclearPossesses = unclearPossesses;
    }
    
    public void addNotOwnPlayers(List<Player> players) {
        if (owned != null) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined owning by Player: \"" + owned.getId() + "/" + owned.getName() + "\"");
            return;
        }

        for (Player player : players) {
            if (!notOwnPlayers.contains(player)) {
                notOwnPlayers.add(player);
                player.addCardsNotInHand(card);
            }
        }
    }

    public void setPossibilities(List<Possibility> possibilities) {
        if (owned != null) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined owning by Player: \"" + owned.getId() + "/" + owned.getName() + "\"");
            return;
        } else if (notOwnPlayers.size() >= numPlayers) {
            Log.e("ERROR", "Card: \"" + card.getName() + "\" already defined not owning by any Player in Game");
            return;
        }

        this.possibilities = possibilities;
    }

    public boolean isOwned() {
        return owned != null;
    }

    public boolean isTarget() {
        return notOwnPlayers.size() >= numPlayers;
    }

    public Card getCard() {
        return card;
    }

    public Player getOwned() {
        return owned;
    }

    public List<UnclearPossess> getUnclearPossesses() {
        return unclearPossesses;
    }

    public HashSet<Player> getNotOwnPlayers() {
        return notOwnPlayers;
    }

    public List<Possibility> getPossibilities() {
        return possibilities;
    }

}
