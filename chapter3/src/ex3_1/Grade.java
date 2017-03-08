package ex3_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by zhou on 2017/3/8.
 * 字母成绩与数值分数符号表
 * A+ -> 4.33
 * A  -> 4.00
 * A- -> 3.67
 * B+ -> 3.33
 * B  -> 3.00
 * B- -> 2.67
 * C+ -> 2.33
 * C  -> 2.00
 * C- -> 1.67
 * D  -> 1.00
 * F  -> 0.00
 */
public class Grade<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public Grade(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public int rank(Key key) {
        int lo = 0, hi = N-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        if(keys.length == N) {
            StdOut.println("index out of array length");
            return;
        }
        for(int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    private static class Rank implements Comparable<Rank> {

        private String rank;

        public Rank(String rank) {
            this.rank = rank;
        }

        @Override
        public int compareTo(Rank that) {
            int firstCmp = this.rank.charAt(0) - that.rank.charAt(0);
            if(firstCmp != 0) return firstCmp;
            else {
                char thisNext = getNextChar(this);
                char thatNext = getNextChar(that);
                return thisNext - thatNext;
            }
        }

        private char getNextChar(Rank rank) {
            if(rank.rank.length() == 1) return ',';
            else return rank.rank.charAt(1);
        }
    }

    public static void main(String[] args) {
        Grade<Rank, Double> grade = new Grade<>(13);
        grade.put(new Rank("A+"), 4.33);
        grade.put(new Rank("A"), 4.00);
        grade.put(new Rank("A-"), 3.67);
        grade.put(new Rank("B+"), 3.33);
        grade.put(new Rank("B"), 3.00);
        grade.put(new Rank("B-"), 2.67);
        grade.put(new Rank("C+"), 2.33);
        grade.put(new Rank("C"), 2.00);
        grade.put(new Rank("C-"), 1.67);
        grade.put(new Rank("D"), 1.00);
        grade.put(new Rank("F"), 0.00);
        int count = 0;
        double gradeSum = 0.00;
        while(true) {
            String rank = StdIn.readLine();
            if(rank.equals("")) break;
            gradeSum += grade.get(new Rank(rank));
            count++;
        }
        StdOut.printf("共有%d门课，总绩点为%.2f，平均绩点为%.2f", count, gradeSum, gradeSum/count);
    }
}
