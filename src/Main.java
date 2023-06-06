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
		int turns = 0;

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
		in.nextLine();

		if (round <= rouNum) {
		
		while (turns<9) {

			System.out.println("the cards have been shuffled");

			System.out.println("You go first");

			while (turn == 1) {
				System.out.println("the top card is " + d.getName(pos) + "");
				discard.add(d.deal());
				System.out.println("you have " + P1 + " in your hand");
				boolean correct = true;

				while (correct) {
					System.out.println(
							"What card would you like to play? (please select the number position of your card or 0 to pick up)");
					int carChoice = in.nextInt();
					in.nextLine();
					
					carChoice = carChoice - 1;

					if (carChoice == -1) {
						P1.add(d.deal());
						turn = turn + 1;
						correct = false;
						
					} else if (P1.get(carChoice).getNumber() == 8){
						System.out.println("You put a CRAZY 8! What would you like to change the suit to?");
						String newSuit = in.nextLine();
						newSuit.toUpperCase();

						if (newSuit.startsWith("S")){
							
						} else if (newSuit.startsWith("C")) {
							P1.get(carChoice).getSuit();
							
						} else if (newSuit.startsWith("D")) {
							
							
						} else if (newSuit.startsWith("H")) {
							
							
						}
							
						
						discard.add(P1.get(carChoice));
						
					} else {

						if (P1.get(carChoice).getSuit() == discard.get(discard.size() - 1).getSuit()
								|| P1.get(carChoice).getNumber() == discard.get(discard.size() - 1).getNumber()) {

							discard.add(P1.get(carChoice));

							System.out.println("You put " + discard.get(discard.size() - 1) + "");

							turn = turn + 1;
							correct = false;
						} else {
							System.out.println("you can't put that card pick another");

						}

					}
				}
			}

			while (turn > 1) {
				
				for (int x = 0; x < P2.size(); x++) {
					
					if (P2.get(x).getSuit() == discard.get(discard.size() - 1).getSuit()
								|| P2.get(x).getNumber() == discard.get(discard.size() - 1).getNumber()) {
						
						System.out.println("P" + player + " played");
						break;
						
					} else {
						P2.add(d.deal());
						System.out.println("P" + player + " skipped");
					}
				}

				if (turn < 4) {
					turn++;
					player++;
				} else {
					turn = 1;
					player = 2;
				}

			}

			round++;
			
		}

		} else if (round > rouNum) {
			System.out.println("Thank you for playing!");
		}
	}

}
