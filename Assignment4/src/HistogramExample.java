

/**
 * This program simulates rolling two 6-sided dice ten million times, then
 * prints a histogram of the results.
 *
 * @author Sam
 */
public class HistogramExample {

    public static void main(String[] args) {
        int[] histogram = new int[13]; // final index = 12: max number you can roll

        for (int i = 0; i < 10_000_000; i++) {
            int die1 = (int) (Math.random() * 6 + 1);
            int die2 = (int) (Math.random() * 6 + 1);
            int sum = die1 + die2;
            histogram[sum]++;
        }

        for (int i = 2; i < 13; i++) {
            if (i<10)
                System.out.print(" ");
            System.out.println(i + ": " + histogram[i]);
        }
    }
}
