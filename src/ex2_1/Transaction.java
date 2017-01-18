package ex2_1;

public class Transaction implements Comparable<Transaction>{

	private double amount;
	
	@Override
	public int compareTo(Transaction that) {
		if(this.amount > that.amount) return 1;
		else if(this.amount < that.amount) return -1;
		else return 0;
	}

}
