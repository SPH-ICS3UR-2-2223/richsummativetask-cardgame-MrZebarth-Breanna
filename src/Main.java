import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deck d = new Deck();
		d.shuffle();
		ArrayList<Card> P1 = new ArrayList<>();
		ArrayList<Card> P2 = new ArrayList<>();
		ArrayList<Card> P3 = new ArrayList<>();
		ArrayList<Card> P4 = new ArrayList<>();
		ArrayList<Card> discard = new ArrayList<>();

		int turn = 1;
		int round = 1;
		int player = 2;
		int pos = 0;

		for (int x = 0; x < 8; x++) {
			P1.add(d.deal());
			P2.add(d.deal());
			P3.add(d.deal());
			P4.add(d.deal());

		}

		for (int x = 0; x < 8; x++) {
			P1.get(x).getName();
			P2.get(x).getName();
			P3.get(x).getName();
			P4.get(x).getName();
		}

		System.out.println("Welcome to crazy 8s");
		System.out.println("how many rounds would you like to play?");
		int rouNum = in.nextInt();

		if (round <= rouNum) {

			System.out.println("the cards have been shuffled");

			discard.add(d.deal());

			System.out.println("the top card has been flipped to reveal " + d.getName(pos) + "");
			System.out.println("You go first");

			if (turn > 1) {
				

				System.out.println("P" + player + " played... ");
				if (turn < 4) {
					turn++;
					player++;
				} else {
					turn = 1;
					player = 2;
				}

			} else if (turn == 1) {
				System.out.println("you have " + P1 + " in your hand");
				boolean correct = true;

				while (correct) {
					System.out.println(
							"What card would you like to play? (please select the number position of your card)");
					int carChoice = in.nextInt();
					carChoice--;

					if (P1.get(carChoice).getSuit() == discard.get(0).getSuit() || P1.get(carChoice).getNumber() == discard.get(0).getNumber()) {
						
						discard.add(P1.get(carChoice));
						
						System.out.println("You put " + discard.get(discard) + "");

						turn++;
						correct = false;
					} else {
						System.out.println("you can't put that card pick another");

					}

				}
			}

			round++;

		} else if (round > rouNum) {
			System.out.println("Thank you for playing!");
		}
	}

}
