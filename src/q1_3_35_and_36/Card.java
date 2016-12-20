package q1_3_35_and_36;

public class Card {
	private String color;
	private int number;
	
	public Card(String color, int number) {
		this.color = color;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return color + number;
	}
}
