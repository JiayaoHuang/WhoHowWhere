package ca.cary.whohowwhere.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.cary.whohowwhere.data.Deck;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Game {

    private static Game game;

    private final List<Player> players;
    private List<Guess> guesses;
    private HashMap<String, CardState> cardStates;

    private Game(List<Player> players) {
        this.players = players;
    }

    public static void newGame(List<Player> players) {
        game = new Game(players);
        game.guesses = new ArrayList<>();
        game.cardStates = new HashMap<>();

        for (Card card : Deck.getInstance().getCards()) {
            game.cardStates.put(card.getName(), new CardState(card));
        }

        CardState.setNumPlayers(players.size());

        Log.d("INFO", "New Game starts");
    }

    public static Game getGame() {
        if (game == null) {
            Log.e("ERROR", "Game hasn't started yet");
        }

        return game;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Guess> getGuesses() {
        return guesses;
    }

    public HashMap<String, CardState> getCardStates() {
        return cardStates;
    }

}
