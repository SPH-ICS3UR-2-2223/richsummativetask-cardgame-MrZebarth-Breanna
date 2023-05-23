import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deck d= new Deck();
		d.shuffle();
		ArrayList<Card> P1=new ArrayList<>();
		ArrayList<Card> P2=new ArrayList<>();
		ArrayList<Card> P3=new ArrayList<>();
		ArrayList<Card> P4=new ArrayList<>();
		
		for (int x=0;x<8;x++) {
			P1.add(d.deal());
			P2.add(d.deal());
			P3.add(d.deal());
			P4.add(d.deal());

		}
		System.out.println();
	}

}
