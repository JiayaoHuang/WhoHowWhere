package ca.cary.whohowwhere.dao;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Game {

    private static Game game;

    private List<Player> players;
    private List<Guess> guesses;
    private HashMap<String, Card> cardsKnown;
    private HashMap<String, Card> cardsUnknown;

    private Game(List<Player> players) {
        this.players = players;
    }

    public static void newGame(List<Player> players) {
        game = new Game(players);
        game.cardsKnown = new HashMap<>(Deck.getInstance().getCardHashMap());

        Log.d("INFO", "New Game starts");
    }

    public static Game getGame() {
        if (game == null) {
            Log.e("ERROR", "Game hasn't started yet");
        }

        return game;
    }

    public void setCardsKnown(List<Card> cards) {
        if (cards == null) {
            return;
        }

        for (Card card : cards) {
            if (cardsKnown.containsKey(card.getName())) {
                Log.d("INFO", "Card already known: " + card.getName());
            }

            if (cardsUnknown.containsKey(card.getName())) {
                cardsUnknown.remove(card.getName());
                cardsKnown.put(card.getName(), card);
            } else {
                Log.e("ERROR", "Don't contain card: " + card.getName() + " in cardsUnknown map");
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Guess> getGuesses() {
        return guesses;
    }

    public HashMap<String, Card> getCardsKnown() {
        return cardsKnown;
    }

    public HashMap<String, Card> getCardsUnknown() {
        return cardsUnknown;
    }

}
