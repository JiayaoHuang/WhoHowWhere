package ca.cary.whohowwhere.dao;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Guess {

    private Card suspectCard;
    private Card toolCard;
    private Card locationCard;
    private Player suggest;
    private Player shown;
    private boolean solved;

    public Guess(Card suspectCard, Card toolCard, Card locationCard, Player suggest) {
        this.suspectCard = suspectCard;
        this.toolCard = toolCard;
        this.locationCard = locationCard;
        this.suggest = suggest;
        this.solved = false;
    }

    public void setShown(Player player) {
        shown = player;
    }

    public void setSolved() {
        solved = true;
    }

    public Card getSuspectCard() {
        return suspectCard;
    }

    public Card getToolCard() {
        return toolCard;
    }

    public Card getLocationCard() {
        return locationCard;
    }

    public Player getSuggest() {
        return suggest;
    }

    public Player getShown() {
        return shown;
    }

    public boolean isSolved() {
        return solved;
    }

}
