package ca.cary.whohowwhere.model;

import android.util.Log;

import ca.cary.whohowwhere.data.CardType;

/**
 * Created by jiayaohuang on 2017-11-29.
 */

public class Combo {

    private final Card suspectCard;
    private final Card toolCard;
    private final Card locationCard;

    public Combo(Card suspectCard, Card toolCard, Card locationCard) {
        if (suspectCard.getCardType() != CardType.SUSPECT || toolCard.getCardType() != CardType.TOOL || locationCard.getCardType() != CardType.LOCATION) {
            this.suspectCard = null;
            this.toolCard = null;
            this.locationCard = null;

            Log.e("ERROR", "Wrong Card Type For Combo: " + suspectCard.getCardType().toString() + "/" + toolCard.getCardType().toString() + "/" + locationCard.getCardType().toString());
        } else {
            this.suspectCard = suspectCard;
            this.toolCard = toolCard;
            this.locationCard = locationCard;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Combo)) {
            return false;
        }

        Combo combo = (Combo) object;

        return ((suspectCard == null) ? combo.suspectCard == null : suspectCard.equals(combo.suspectCard))
                && ((toolCard == null) ? combo.toolCard == null : toolCard.equals(combo.toolCard))
                && ((locationCard == null) ? combo.locationCard == null : locationCard.equals(combo.locationCard));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suspectCard == null) ? 0 : suspectCard.hashCode());
        result = prime * result + ((toolCard == null) ? 0 : toolCard.hashCode());
        result = prime * result + ((locationCard == null) ? 0 : locationCard.hashCode());

        return result;
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

}
