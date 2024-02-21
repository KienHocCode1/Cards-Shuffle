package assignment4_000356049;

import java.util.Scanner;

/**
 * This assignment is about learning Array. You will have 3 classes: Main, DeckOfCards, and Card.
 * Then you will repeatedly shuffle and deal hands, and create a histogram of the results.
 *
 * @author TRUNG KIEN, BUI
 */
public class Main {
    /**
     * A method to test the object. To view class, display the program and take inputs from user.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many rank: ");
        int rank = input.nextInt();

        System.out.print("How many suit: ");
        int suit = input.nextInt();

        DeckOfCards deck = new DeckOfCards(rank, suit);
        System.out.print(deck);        // display Size, MinValue, MaxValue, and TopCard
        System.out.println("");
        System.out.println("Cards in deck:");
        deck.print();         // display cards in the deck in order

        boolean Flag = true;
        while (Flag) {
            System.out.println("");
            System.out.println("1=shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit");

            int choice = input.nextInt();
            if (choice == 1) {
                deck.shuffle();        // call shuffle method
                System.out.println(deck);
                System.out.println("Cards order after shuffled: ");
                deck.print();          // display cards order after being shuffled

            } else if (choice == 2) {
                System.out.println("How many cards? ");
                int deal1HandCards = input.nextInt();
                deck.dealTopCards(deal1HandCards);       // call dealTopCards method to print first top cards depends on user input

            } else if (choice == 3) {
                System.out.println("How many cards? ");
                int shuffle100000 = input.nextInt();
                deck.histogram(shuffle100000);    //call shuffle100.000 method and display result

            } else {
                System.out.println("Bye!");
                Flag = false;      // end program
            }
        }
    }
}