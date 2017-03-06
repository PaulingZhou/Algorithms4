package ex2_5;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zhou on 2017/3/6.
 * 获得字符串数列中的组合词
 */
public class Ex2_5_2 {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        while (true) {
            String in = StdIn.readLine();
            if (in.equals("")) break;
            else queue.enqueue(in);
        }
        String[] sArr = new String[queue.size()];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = queue.dequeue();
        }
        Quick.sort(sArr);
        for (int i = 0; i < sArr.length - 1; i++) {
            for (int j = i + 1; j < sArr.length; j++) {
                if (sArr[i].length() < sArr[j].length()) {
                    String concat = String.copyValueOf(sArr[j].toCharArray(), 0, sArr[i].length());
                    if (concat.compareTo(sArr[i]) != 0) break;
                    else {
                        String remain = String.copyValueOf(sArr[j].toCharArray(), sArr[i].length(), sArr[j].length() - sArr[i].length());
                        for (String s : sArr) {
                            if (s.compareTo(remain) == 0) StdOut.println(sArr[j]);
                            else if (s.compareTo(remain) > 0) break;
                        }

                    }
                }
            }
        }
    }

}
