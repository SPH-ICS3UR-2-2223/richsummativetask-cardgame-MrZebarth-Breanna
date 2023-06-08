import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int round = 1;

		System.out.println("Welcome to crazy 8s");
		System.out.println("how many rounds would you like to play?");
		int rouNum = in.nextInt();
		in.nextLine();

		if (round <= rouNum) {
			System.out.println("round " + rouNum + "");

			Deck d = new Deck();
			d.shuffle();
			ArrayList<Card> P1 = new ArrayList<>();
			ArrayList<Card> P2 = new ArrayList<>();
			ArrayList<Card> P3 = new ArrayList<>();
			ArrayList<Card> P4 = new ArrayList<>();
			ArrayList<Card> discard = new ArrayList<>();

			int turn = 1;
			int newSuitC = 1;

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

			System.out.println("the cards have been shuffled");
			discard.add(d.deal());

			while (!(P1.size() == 0) && !(P2.size() == 0) && !(P3.size() == 0) && !(P4.size() == 0)) {

				while (turn == 1) {

					System.out.println("it is your turn");

					System.out.println("the top card is " + discard.get(discard.size() - 1).getName() + "");

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
							System.out.println("You skipped");
							turn++;
							correct = false;

						} else if (P1.get(carChoice).getNumber() == 8) {
							System.out.println("You put a CRAZY 8! What would you like to change the suit to?");
							String newSuit = in.nextLine();
							newSuit.toUpperCase();

							if (newSuit.startsWith("S")) {
								P1.get(carChoice).setSuit("Spades");
								System.out.println("The new suit is Spades");

							} else if (newSuit.startsWith("C")) {
								P1.get(carChoice).setSuit("Clubs");
								System.out.println("The new suit is Clubs");

							} else if (newSuit.startsWith("D")) {
								P1.get(carChoice).setSuit("Diamonds");
								System.out.println("The new suit is Diamonds");

							} else if (newSuit.startsWith("H")) {
								P1.get(carChoice).setSuit("Hearts");
								System.out.println("The new suit is Hearts");

							}

							discard.add(P1.get(carChoice));
							P1.remove(carChoice);
							turn++;
							correct = false;

						} else {

							if (P1.get(carChoice).getSuit() == discard.get(discard.size() - 1).getSuit()
									|| P1.get(carChoice).getNumber() == discard.get(discard.size() - 1).getNumber()) {

								discard.add(P1.get(carChoice));
								P1.remove(carChoice);

								System.out.println("You put " + discard.get(discard.size() - 1) + "");

								turn++;
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

							if (P2.get(x).getNumber() == 8) {
								System.out.println("P2 played " + P2.get(x) + "");

								if (newSuitC == 1) {
									P2.get(x).setSuit("Spades");
									System.out.println("The new suit is Spades");
									newSuitC++;

								} else if (newSuitC == 2) {
									P2.get(x).setSuit("Clubs");
									System.out.println("The new suit is Clubs");
									newSuitC++;

								} else if (newSuitC == 3) {
									P2.get(x).setSuit("Diamonds");
									System.out.println("The new suit is Diamonds");
									newSuitC++;

								} else if (newSuitC == 4) {
									P2.get(x).setSuit("Hearts");
									System.out.println("The new suit is Hearts");
									newSuitC = 1;

								}

								discard.add(P2.get(x));
								P2.remove(x);

								break;

							} else {

								System.out.println("P2 played " + P2.get(x) + "");
								discard.add(P2.get(x));
								P2.remove(x);

								break;

							}

						} else if (x == P2.size() - 1) {
							P2.add(d.deal());
							System.out.println("P2 skipped");
							break;

						}

					}

					for (int x = 0; x < P3.size(); x++) {

						if (P3.get(x).getSuit() == discard.get(discard.size() - 1).getSuit()
								|| P3.get(x).getNumber() == discard.get(discard.size() - 1).getNumber()) {

							if (P3.get(x).getNumber() == 8) {
								System.out.println("P3 played " + P3.get(x) + "");

								if (newSuitC == 1) {
									P3.get(x).setSuit("Spades");
									System.out.println("The new suit is Spades");
									newSuitC++;

								} else if (newSuitC == 2) {
									P3.get(x).setSuit("Clubs");
									System.out.println("The new suit is Clubs");
									newSuitC++;

								} else if (newSuitC == 3) {
									P3.get(x).setSuit("Diamonds");
									System.out.println("The new suit is Diamonds");
									newSuitC++;

								} else if (newSuitC == 4) {
									P3.get(x).setSuit("Hearts");
									System.out.println("The new suit is Hearts");
									newSuitC = 1;

								}

								discard.add(P3.get(x));
								P3.remove(x);

								break;

							} else {

								System.out.println("P3 played " + P3.get(x) + "");
								discard.add(P3.get(x));
								P3.remove(x);

								break;

							}
						} else if (x == P3.size() - 1) {
							P3.add(d.deal());
							System.out.println("P3 skipped");
							break;

						}
					}

					for (int x = 0; x < P4.size(); x++) {

						if (P4.get(x).getSuit() == discard.get(discard.size() - 1).getSuit()
								|| P4.get(x).getNumber() == discard.get(discard.size() - 1).getNumber()) {

							if (P4.get(x).getNumber() == 8) {
								System.out.println("P4 played " + P4.get(x) + "");

								if (newSuitC == 1) {
									P4.get(x).setSuit("Spades");
									System.out.println("The new suit is Spades");
									newSuitC++;

								} else if (newSuitC == 2) {
									P4.get(x).setSuit("Clubs");
									System.out.println("The new suit is Clubs");
									newSuitC++;

								} else if (newSuitC == 3) {
									P4.get(x).setSuit("Diamonds");
									System.out.println("The new suit is Diamonds");
									newSuitC++;

								} else if (newSuitC == 4) {
									P4.get(x).setSuit("Hearts");
									System.out.println("The new suit is Hearts");
									newSuitC = 1;

								}

								discard.add(P4.get(x));
								P4.remove(x);

								break;

							} else {

								System.out.println("P4 played " + P4.get(x) + "");
								discard.add(P4.get(x));
								P4.remove(x);

								break;

							}

						} else if (x == P4.size() - 1) {
							P4.add(d.deal());
							System.out.println("P4 skipped");
							break;

						}
					}

					turn = 1;
				}

			}
			
			if (P1.size() == 0) {
				System.out.println("P1 Won");

			} else if (P2.size() == 0) {
				System.out.println("P2 Won");

			} else if (P3.size() == 0) {
				System.out.println("P3 Won");
				
			} else if (P2.size() == 0) {
				System.out.println("P4 Won");
				
			}

		} else if (round > rouNum) {
			System.out.println("Thank you for playing!");
		}
	}

}
