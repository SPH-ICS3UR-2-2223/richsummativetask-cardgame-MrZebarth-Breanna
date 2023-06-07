
public class Card {
	/* FIELDS */
	private int number;
	private String suit;
	private String colour;
	private String name;
	private int value;

	/* CONSTRUCTORS */

	public Card(int n, String s, String c) {
		this.number = n;

		this.value = (n == 1 ? 14 : n);
		this.suit = s;
		this.colour = c;
		switch (this.number) {
		case 1:
			this.name = "Ace of " + s;
			break;
		case 11:
			this.name = "Jack of " + s;
			break;
		case 12:
			this.name = "Queen of " + s;
			break;
		case 13:
			this.name = "King of " + s;
			break;

		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			this.name = n + " of " + s;
			break;

		}

	}

	@Override
	public String toString() {
		return "" + name + "";
	}

	public int getNumber() {
		return number;
	}
	
//	public void setSuit(String suit) {
//	this.suit = suit;
//}

public String getName() {
	return name;
}


//	public void setSuit(String suit) {
//	this.suit = suit;
//}

	public void setSuit(String suit) {
		this.suit = suit;
	}

//
//	public void setNumber(int number) {
//		this.number = number;
//	}

	public String getSuit() {
		return suit;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

}
