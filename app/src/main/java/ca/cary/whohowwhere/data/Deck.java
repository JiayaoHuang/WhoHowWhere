package ca.cary.whohowwhere.data;

import java.util.ArrayList;
import java.util.List;

import ca.cary.whohowwhere.model.Card;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Deck {

    private static Deck deck;

    private List<Card> cards;
    private List<Card> suspectCards;
    private List<Card> toolCards;
    private List<Card> locationCards;

    private Deck() {}

    private void generateDeck() {
        cards = new ArrayList<>();
        suspectCards = new ArrayList<>();
        toolCards = new ArrayList<>();
        locationCards = new ArrayList<>();

        // Suspects
        for (String suspect : CardSet.getSuspects()) {
            Card card = new Card(suspect, CardType.SUSPECT);
            cards.add(card);
            suspectCards.add(card);
        }

        // Tools
        for (String tool : CardSet.getTools()) {
            Card card = new Card(tool, CardType.TOOL);
            cards.add(card);
            toolCards.add(card);
        }

        // Locations
        for (String location : CardSet.getLocations()) {
            Card card = new Card(location, CardType.LOCATION);
            cards.add(card);
            locationCards.add(card);
        }
    }

    public static Deck getInstance() {
        if (deck == null) {
            deck = new Deck();
            deck.generateDeck();
        }

        return deck;
    }

    public int getNumCardsInDeck() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getSuspectCards() {
        return suspectCards;
    }

    public List<Card> getToolCards() {
        return toolCards;
    }

    public List<Card> getLocationCards() {
        return locationCards;
    }

}
