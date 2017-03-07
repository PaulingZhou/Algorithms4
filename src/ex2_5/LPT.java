package ex2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.PriorityQueue;

/**
 * Created by zhou on 2017/3/6.
 */
public class LPT implements Comparable<LPT>{

    private String name;
    private int duration;

    public LPT(String info) {
        String[] infos = info.split(" ");
        name = infos[0];
        duration += Integer.parseInt(infos[1]);
    }

    public void addTask(String info) {
        String[] infos = info.split(" ");
        name = name + " " + infos[0];
        duration += Integer.parseInt(infos[1]);
    }

    @Override
    public String toString() {
        return name + " " + duration;
    }

    @Override
    public int compareTo(LPT that) {
        return this.duration-that.duration;
    }

    public static void main(String[] args) {
        int serverNum = Integer.parseInt(StdIn.readLine());
        PriorityQueue<LPT> pq = new PriorityQueue<>(serverNum);
        while(true) {
            String serverInfo = StdIn.readLine();
            if(serverInfo.equals("")) break;
            if(pq.size() < serverNum) pq.add(new LPT(serverInfo));
            else {
                LPT schdule = pq.remove();
                schdule.addTask(serverInfo);
                pq.add(schdule);
            }
        }
        for(LPT lpt : pq) {
            StdOut.println(lpt);
        }
    }
}
