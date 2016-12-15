package q1_3_11;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix
{
    public static void main(String[] args)
    {
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            
            if      (s.equals("(") ||
                     s.equals(")")) ;
            else if (s.equals("+") ||
                     s.equals("-") ||
                     s.equals("*") ||
                     s.equals("/") ||
                     s.equals("sqrt"))
            {
                double v = vals.pop();
                
                if      (s.equals("+"))    v = vals.pop() + v;
                else if (s.equals("-"))    v = vals.pop() - v;
                else if (s.equals("*"))    v = vals.pop() * v;
                else if (s.equals("/"))    v = vals.pop() / v;
                else if (s.equals("sqrt")) v = Math.sqrt(v);
                
                vals.push(v);                
            }
            else
                vals.push(Double.parseDouble(s));
        }
        
        StdOut.println(vals.pop());
    }
}
