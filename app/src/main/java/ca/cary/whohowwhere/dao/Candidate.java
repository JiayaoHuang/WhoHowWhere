package ca.cary.whohowwhere.dao;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class Candidate {

    private static int numCardsLeft = 0;

    private String name;
    private int numCardsAtStart;

    public Candidate(String name, int numCardsAtStart) {
        this.name = name;
        this.numCardsAtStart = numCardsAtStart;
    }

    public static int getNumCardsLeft() {
        return numCardsLeft;
    }

    public static void setNumCardsLeft(int numCardsLeft) {
        Candidate.numCardsLeft = numCardsLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumCardsAtStart() {
        return numCardsAtStart;
    }

    public void setNumCardsAtStart(int numCardsAtStart) {
        this.numCardsAtStart = numCardsAtStart;
    }

}
