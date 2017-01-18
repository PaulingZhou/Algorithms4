package meal;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DetermineCantin {

	String name;
	double weight;
	
	public DetermineCantin(String name, Double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	static String determineRestaurant() {
		String[] restaurants = new In("src/meal/restaurants.txt").readAllStrings();
		int length = restaurants.length;
		int luckNumRest = StdRandom.uniform(length - 1);
		String result = restaurants[luckNumRest];
		restaurants[luckNumRest] = restaurants[length-1];
		restaurants[length-1] = result;
		Out os = new Out("src/meal/restaurants.txt");
		for(String s : restaurants) os.println(s);
		return result;
	}
	
	public static void main(String[] args) {
		int oppo = 0;
		String[] msg = new In("src/meal/cantins.txt").readAllStrings();
		int n = msg.length;
		DetermineCantin[] cantins = new DetermineCantin[n-1];
		int sum = 0;
		for(int i = 0; i < n-1; i++) {
			cantins[i] = new DetermineCantin(msg[i].split(";")[0], Double.parseDouble(msg[i].split(";")[1]));
			sum += cantins[i].weight;
		}
		int sel = -1;
		while(oppo++ < 2) {
			StdOut.printf("opportunity %d/2:\n", oppo);
			int luckNum = StdRandom.uniform(sum);
			for(int i = 0; i < n-1; i++) {
				luckNum -= cantins[i].weight;
				if(luckNum < 0) {
					sel = i;
					break;
				}
			}
			String output = cantins[sel].name;
			if(output.equals("饭店")) {
				output = determineRestaurant();
			}
			StdOut.println(output);
			if(oppo == 1) {
				StdOut.println("another chance? Y/N");
				String ans = StdIn.readString();
				if(ans.equals("y") || ans.equals("Y")) continue;
				else break;
			}
		}
		String temp = msg[sel];
		msg[sel] = msg[n-1];
		msg[n-1] = temp;
		Out os = new Out("src/meal/cantins.txt");
		for(String s : msg) os.println(s);
	}
}
