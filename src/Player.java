import java.util.*;

public class Player {
	String hand;
	ArrayList<Card> player = new ArrayList<>();
	
	
	public Player (String hand1, ArrayList<Card> player1) {
		hand = hand1;
		player = player1;
		
	}
	
	ArrayList<Card> deal() {
		for (int x = 0; x < 8; x++) {
			player.add(d.deal());
		}
		return player;
		
	}
	
	String getHand() {
		for (int x = 0; x < player.size(); x++) {
			
		}
	return hand;
	}
	

}
