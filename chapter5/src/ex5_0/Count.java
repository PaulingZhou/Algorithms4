package ex5_0;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zhou on 2017/3/17.
 */
public class Count {

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet(args[0]);
        int R = alphabet.radix();
        int[] count = new int[R];

        String s = StdIn.readLine();
        int N = s.length();
        for(int i = 0; i < N; i++) {
            count[alphabet.toIndex(s.charAt(i))]++;
        }
        for(int c = 0; c < R; c++) {
            StdOut.println(alphabet.toChar(c) + " " + count[c]);
        }
    }
}
