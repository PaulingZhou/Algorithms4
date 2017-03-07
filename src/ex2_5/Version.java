package ex2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zhou on 2017/3/6.
 */
public class Version implements Comparable<Version>{

    private final String[] versions;

    public Version(String version) {
        versions = version.split("\\.");
    }

    @Override
    public int compareTo(Version that) {
        for(int i = 0; i < versions.length; i++) {
            if(this.versions[i].compareTo(that.versions[i]) < 0) return -1;
            else if(this.versions[i].compareTo(that.versions[i]) > 0) return +1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Version v1 = new Version("1.3.2");
        Version v2 = new Version("1.30.2");
        StdOut.println(v1.compareTo(v2));
    }
}
