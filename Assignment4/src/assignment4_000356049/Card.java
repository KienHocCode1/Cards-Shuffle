package assignment4_000356049;

/**
 * This assignment is about learning Array. You will have 3 classes: Main, DeckOfCards, and Card.
 * Then you will repeatedly shuffle and deal hands, and create a histogram of the results.
 *
 * @author TRUNG KIEN, BUI
 */
public class Card {
    /**
     * Declare number of ranks
     */
    private int rank;
    /**
     * Declare number of suits
     */
    private int suit;

    /**
     * Constructor for card
     *
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Get rank method
     *
     * @return rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Get suit method
     *
     * @return suit
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Get value method for histogram purpose
     *
     * @return value of the card you target
     */
    public int getValue() {
        return rank * suit;
    }

    /**
     * toString function that returns a full report for a card
     **/
    @Override
    public String toString() {
        return String.format("S%dR%d", suit, rank);
    }
}
