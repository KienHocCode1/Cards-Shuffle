package assignment4_000356049;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * This assignment is about learning Array. You will have 3 classes: Main, DeckOfCards, and Card.
 * Then you will repeatedly shuffle and deal hands, and create a histogram of the results.
 *
 * @author TRUNG KIEN, BUI
 */
public class DeckOfCards {
    /**
     * Declare cards (is deck of card) which holds every card
     **/
    private Card[] cards;
    /**
     * Declare the size of the deck
     **/
    private int sizeOfTheDeck;
    /**
     * Declare how many ranks will be
     */
    private final int rankMax;
    /**
     * Declare how many suits will be
     */
    private final int suitNumber;

    /**
     * Constructor for the deck of card. Based on user input
     *
     * @param rankMax
     * @param suitNumber
     */
    public DeckOfCards(int rankMax, int suitNumber) {
        this.rankMax = rankMax;
        this.suitNumber = suitNumber;
        this.sizeOfTheDeck = rankMax * suitNumber; // Calculate size
        this.cards = new Card[sizeOfTheDeck]; // Set array length for cards' array

        int insertCards = 0;   // Keep track of the index at which the next card will be inserted in the "cards" array
        for (int i = 1; i <= rankMax; i++) { // The outer loop runs over the ranks from 1 to rankMax
            for (int x = 1; x <= suitNumber; x++) { // The inner loop runs over the suits from 1 to suitNumber
                cards[insertCards] = new Card(x, i); // Create "Card" object with current x and i and assign it to the "insertCards" index of the "cards" array
                insertCards++; // increase insertCards variable to prepare for the next card
            }
        }
    }

    /**
     * @return size of the deck to display in toString()
     */
    public int getSizeOfTheDeck() {
        return rankMax * suitNumber;
    }

    /**
     * @return minimum value of the deck to display in toString()
     */
    public int getMinValue() {
        return 1;
    }

    /**
     * @return max value of the deck by taking max rank* max suit from user input
     */
    public int getMaxValue() {
        return rankMax * suitNumber;
    }

    /**
     * shuffle method will swap cards index
     */
    public void shuffle() {
        Random random = new Random();

        //for loop starting at last index going backward to first index
        for (int i = sizeOfTheDeck - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap cards[i] and cards[j]
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    /**
     * Take the numbers of cards from user input and print how many cards they want
     *
     * @param cardsAmount the number of cards to display
     * @return array contains how many cards that taken from user input and PRINT
     */
    public Card[] dealTopCards(int cardsAmount) {
        Card[] hand = new Card[cardsAmount];  // set array length for hand, save orders of cards[i] to hand[i] and print out
        for (int i = 0; i < cardsAmount; i++) {
            hand[i] = cards[i];
        }
        for (int i = 0; i < hand.length; i++) {
            System.out.print(hand[i] + " ");
        }
        return hand;
    }

    /**
     * Take numbers of cards from user input BUT DON'T PRINT IT, so it won't mess up histogram Method
     *
     * @param cardsAmount number of cards to display
     * @return array contains how many cards that taken from user input but don't PRINT
     */
    public Card[] dealCardsForHistogram(int cardsAmount) {
        Card[] newDeckOfCards = new Card[cardsAmount]; // set array length for newDeckOfCards, and save
        for (int i = 0; i < cardsAmount; i++) {        // orders of cards[i] to newDeckOfCards[i] and print out
            newDeckOfCards[i] = cards[i];
        }
        return newDeckOfCards;
    }

    /**
     * Method display cards at index 0
     *
     * @return cards index 0
     */
    public Card getTopCard() {
        return cards[0];
    }

    /**
     * Histogram method to display how many times the value of a number has been randomly generated from the range
     * of value of (top*amount of cards from user) - value of (low*amount of cards from user)
     *
     * @param cardsAmount
     * @return
     */
    public int[] histogram(int cardsAmount) {
        int largest = 0;  // initialize the largest number to get total value of (user input cards)
        int smallest = 0;  // initialize the smallest number to get total value of (user input cards)

        // Sort the cards in ascending order based on their values, so we can target first and last numbers
        // based on user input
        Arrays.sort(cards, Comparator.comparingInt(Card::getValue));

        // Add the values of the three smallest cards to variable smallest
        for (int i = 0; i < cardsAmount; i++) {
            smallest += cards[i].getValue();
        }

        // Add the values of the three biggest cards to variable largest
        for (int i = sizeOfTheDeck - 1; i >= sizeOfTheDeck - cardsAmount; i--) {
            largest += cards[i].getValue();
        }
        int range = largest - smallest;    // getting range to display by taking the largest number - smallest
        int[] histogramArray = new int[range + 1];    // setting array length by passing value from int range

        for (int i = 0; i < 100000; i++) {      // loop that runs 100,000 times
            shuffle();                          // shuffle method called in for loop that runs 100,000 times
            Card[] hand = dealCardsForHistogram(cardsAmount); // call deal method to deal (user input cards) randomly generated after being shuffled
            int handValue = 0;    // initialize int handValue to save total value of (user input cards) cards to it
            for (Card card : hand) {
                handValue += card.getValue(); // get the total value of (user input cards) and save it to handValue
            }
            if (handValue >= smallest && handValue <= largest) { // if condition check and print if values are within range
                histogramArray[handValue - smallest]++;          // largest and smallest times (user input cards)
            }
        }
        for (int i = smallest; i <= largest; i++) { // printing for loop within range
            if (i < 10)
                System.out.print(" "); // make sure numbers from 1-9 will line up with 11+ numbers
            System.out.println(i + ": " + histogramArray[i - smallest]); // display i and how many times i is randomly generated
        }
        return histogramArray;
    }

    /**
     * Print method I use to display deck of card. For readability purpose.
     */
    public void print() {
        for (Card card : cards) {
            System.out.print(card + " ");
        }
    }

    /**
     * toString function that returns a full report
     **/
    @Override
    public String toString() {
        return String.format("Size %d MinValue %d MaxValue %d TopCard %s", getSizeOfTheDeck(), getMinValue(), getMaxValue(), getTopCard());
    }

}
