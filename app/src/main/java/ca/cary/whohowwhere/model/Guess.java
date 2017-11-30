package ca.cary.whohowwhere.model;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Guess {

    private final Combo combo;
    private final Player suggest;
    private Player shown;
    private boolean solved;

    public Guess(Combo combo, Player suggest) {
        this.combo = combo;
        this.suggest = suggest;
        this.solved = false;
    }

    public void setShown(Player player) {
        shown = player;
    }

    public void setSolved() {
        solved = true;
    }

    public Combo getCombo() {
        return combo;
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
