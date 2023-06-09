import java.util.*;
public class Deck {
	private ArrayList<Card> cards;
	
	public Deck() {
		String[] colours= {"Red","Black"};
		String[] suits= {"Hearts","Diamonds","Spades","Clubs"};
		cards=new ArrayList<>();
		//Loop through colours
		for (int colourCtr=0;colourCtr<2;colourCtr++) {
			//Loop through suits
			for (int suitCtr = 2*colourCtr;suitCtr<2*colourCtr+2;suitCtr++) {
				//Loop through numbers
				for (int numCtr=1;numCtr<=13;numCtr++) {
					//Create card and add it to the deck
					cards.add(new Card(numCtr, suits[suitCtr], colours[colourCtr]));
				}
				
			}
		}	
	}
	
	public void shuffle() {
		Random rnd=new Random();
		//Loop through the cards
		for (int x=0;x<cards.size();x++) {
			//pick a random position
			int pos=rnd.nextInt(cards.size());
			//swap the cards
			Card temp=cards.get(x);
			cards.set(x, cards.get(pos));
			cards.set(pos, temp);
		}
	}
	
	/**
	 * gets the name and the position of the card
	 * @param pos
	 * @return
	 */
	public String getName(int pos) {
		return cards.get(pos).getName();
	}
	
	/**
	 * deals a card from the deck
	 * @return
	 */
	public Card deal() {
		return cards.remove(0);
	}
}
