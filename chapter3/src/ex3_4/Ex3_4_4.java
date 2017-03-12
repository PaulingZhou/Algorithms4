package ex3_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhou on 2017/3/12.
 */
public class Ex3_4_4 {

    private static int hash(char c, int a, int M) {
        return (a * c) % M;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        String s = "SEARCHXMPL";
        int M = s.length();
        int a;
        boolean searchSuccess = false;
        while (true) {
            for(a = 1; a < M; a++) {
                set.clear();
                boolean noCollision = true;
                for(char c : s.toCharArray()) {
                    int hash = hash(c, a, M);
                    noCollision = set.add(hash);
                    if(!noCollision) break;
                }
                if(noCollision){
                    searchSuccess = true;
                    break;
                }
            }
            if(searchSuccess) break;
            M++;
        }
        StdOut.printf("the min M is %d, a is %d.\n", M, a);
    }

}
