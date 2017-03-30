import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Maksym Pavlov on 3/29/17.
 */
public class Permutation {
    public static void main(String[] args) {
//        System.out.println(args.length);
        String[] input = StdIn.readAllStrings();
        RandomizedQueue<String> rQueue = new RandomizedQueue<>();
        for (String e : input) {
            rQueue.enqueue(e);
        }

        for (int i = 0; i < Integer.valueOf(args[0]); i++) {
            StdOut.println(rQueue.dequeue());
        }
    }
}
