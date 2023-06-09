
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

	/**
	 * gets the name of the card
	 */
	@Override
	public String toString() {
		return "" + name + "";
	}

	/**
	 * returns the number of the card
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * returns the name of the card
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the suit of the card
	 * @param suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	/**
	 * returns the suit of the card
	 * @return
	 */
	public String getSuit() {
		return suit;
	}

}
