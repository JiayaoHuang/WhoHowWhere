package ca.cary.whohowwhere.model;

import android.util.Log;

import java.util.HashSet;

/**
 * Created by jiayaohuang on 2017-11-29.
 */

public class UnclearPossess {

    private final Combo combo;
    private final HashSet<Player> possessors;

    public UnclearPossess(HashSet<Possibility> possibilities) {
        HashSet<Combo> comboHashSet = new HashSet<>();
        HashSet<Player> playerHashSet = new HashSet<>();
        for (Possibility possibility : possibilities) {
            comboHashSet.add(possibility.getCombo());
            playerHashSet.add(possibility.getPlayer());
        }

        if (comboHashSet.size() != 1) {
            combo = null;
            possessors = null;
            Log.e("ERROR", "Possibility Set Does Not Have A Same Combo!");
        } else if (playerHashSet.size() <= 1) {
            combo = null;
            possessors = null;
            Log.e("ERROR", "Possibility Set Have Less Than One Player!");
        } else {
            combo = (Combo) (comboHashSet.toArray()[0]);
            possessors = playerHashSet;
        }
    }

    public Combo getCombo() {
        return combo;
    }

    public HashSet<Player> getPossessors() {
        return possessors;
    }

}
