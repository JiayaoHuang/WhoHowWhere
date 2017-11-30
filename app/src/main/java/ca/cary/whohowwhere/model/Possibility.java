package ca.cary.whohowwhere.model;

/**
 * Created by jiayaohuang on 2017-11-28.
 */

public class Possibility {

    private final Combo combo;
    private final Player player;

    public Possibility(Combo combo, Player player) {
        this.combo = combo;
        this.player = player;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Possibility)) {
            return false;
        }

        Possibility possibility = (Possibility) object;

        return ((combo == null) ? (possibility.combo == null) : combo.equals(possibility.combo))
                && ((player == null) ? (possibility.player == null) : player.equals(possibility.player));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((combo == null) ? 0 : combo.hashCode());
        result = prime * result + ((player == null) ? 0 : player.hashCode());

        return result;
    }

    public Combo getCombo() {
        return combo;
    }

    public Player getPlayer() {
        return player;
    }

}
