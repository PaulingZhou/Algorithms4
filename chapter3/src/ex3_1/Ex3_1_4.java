package ex3_1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zhou on 2017/3/9.
 */
public class Ex3_1_4 {

    public static void main(String[] args) {
        ST<Time, Event> st = new ST<>();
        st.put(new Time("09:00:00"), new Event("Chicago"));
        st.put(new Time("09:00:03"), new Event("Houston"));
        st.put(new Time("09:00:13"), new Event("Phoenix"));
        st.put(new Time("09:00:59"), new Event("Seattle"));
        st.put(new Time("09:00:15"), new Event("Washington"));
        for(Time t : st) {
            Event e = st.get(t);
            StdOut.println(t.toString() + " " + e.toString());
        }
    }

    private static class Time implements Comparable<Time>{

        private int hour, min, sec;

        public Time(String time) {
            String[] times = time.split(":");
            hour = Integer.parseInt(times[0]);
            min = Integer.parseInt(times[1]);
            sec = Integer.parseInt(times[2]);
        }

        @Override
        public int compareTo(Time that) {
            if(this.hour != that.hour) return this.hour-that.hour;
            else {
                if(this.min != that.min) return this.min-that.min;
                else {
                    if(this.sec != that.sec) return this.sec-that.sec;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            String hourString = hour < 10 ? "0"+hour : ""+hour;
            String minString = min < 10 ? "0"+min : ""+min;
            String secString = sec < 10 ? "0"+sec : ""+sec;
            return hourString + ":" + minString + ":" + secString;
        }
    }

    private static class Event {

        private String event;

        public Event(String event) {
            this.event = event;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "event='" + event + '\'' +
                    '}';
        }
    }
}
