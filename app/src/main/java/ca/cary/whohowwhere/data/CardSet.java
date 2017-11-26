package ca.cary.whohowwhere.data;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class CardSet {

    private static final String[] suspects = {
            "Green",
            "Mustard",
            "Orchid",
            "Peacock",
            "Plum",
            "Scarlett"
    };

    private static final String[] tools = {
            "Candlestick",
            "Dagger",
            "Lead Pipe",
            "Revolver",
            "Rope",
            "Wrench"
    };

    private static final String[] locations = {
            "Ballroom",
            "Billiard Room",
            "Conservatory",
            "Dining Room",
            "Hall",
            "Kitchen",
            "Library",
            "Lounge",
            "Study"
    };

    public static String[] getSuspects() {
        return suspects;
    }

    public static String[] getTools() {
        return tools;
    }

    public static String[] getLocations() {
        return locations;
    }

}
