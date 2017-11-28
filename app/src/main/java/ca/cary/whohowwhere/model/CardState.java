package ca.cary.whohowwhere.model;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jiayaohuang on 2017-11-27.
 */

public class CardState {

    private static int numPlayers = 0;

    private final Card card;

    private Player owned;
    private HashMap<Integer, Player> mayOwnPlayers;
    private HashMap<Integer, Player> notOwnPlayers;

    public CardState(Card card) {
        this.card = card;

        this.owned = null;
        mayOwnPlayers = new HashMap<>();
        notOwnPlayers = new HashMap<>();
    }

    public static void setNumPlayers(int numPlayers) {
        CardState.numPlayers = numPlayers;
    }

    public void setOwned(int ownId, List<Player> players) {
        if (owned != null) {
            Log.e("ERROR", "Player: \"" + owned.getId() + "/" + owned.getName() + "\" already defined owning this card: \"" + card.getName() + "\"");
            return;
        } else if (notOwnPlayers.containsKey(ownId)) {
            Log.e("ERROR", "Player: \"" + ownId + "/" + notOwnPlayers.get(ownId).getName() + "\" already defined not owning this card: \"" + card.getName() + "\"");
            return;
        }

        mayOwnPlayers.clear();

        for (Player player : players) {
            if (player.getId() == ownId) {
                owned = player;

                player.addCardsInHand(card);
            } else if (!notOwnPlayers.containsKey(player.getId())) {
                notOwnPlayers.put(player.getId(), player);

                player.addCardsNotInHand(card);
            }
        }
    }

    public void addMayOwnPlayer(Player player) {
        if (owned != null) {
            Log.e("ERROR", "Player: \"" + owned.getId() + "/" + owned.getName() + "\" already defined owning this card: \"" + card.getName() + "\"");
            return;
        } else if (notOwnPlayers.containsKey(player.getId())) {
            Log.e("ERROR", "Player: \"" + player.getId() + "/" + player.getName() + "\" already defined not having this card: \"" + card.getName() + "\"");
            return;
        }

        if (!mayOwnPlayers.containsKey(player.getId())) {
            mayOwnPlayers.put(player.getId(), player);

            player.addCardsMayInHand(card);
        }
    }
    
    public void addNotOwnPlayers(List<Player> players) {
        if (owned != null) {
            Log.e("ERROR", "Player: \"" + owned.getId() + "/" + owned.getName() + "\" already defined owning this card: \"" + card.getName() + "\"");
            return;
        }

        for (Player player : players) {
            if (!notOwnPlayers.containsKey(player.getId())) {
                notOwnPlayers.put(player.getId(), player);

                player.addCardsNotInHand(card);
            }

            if (mayOwnPlayers.containsKey(player.getId())) {
                mayOwnPlayers.remove(player.getId());
            }
        }
    }

    public boolean isOwned() {
        return owned != null;
    }

    public boolean isTarget() {
        return notOwnPlayers.keySet().size() == numPlayers;
    }

    public Card getCard() {
        return card;
    }

    public Player getOwned() {
        return owned;
    }

    public HashMap<Integer, Player> getMayOwnPlayers() {
        return mayOwnPlayers;
    }

    public HashMap<Integer, Player> getNotOwnPlayers() {
        return notOwnPlayers;
    }

}
