import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int round = 1;

		System.out.println("Welcome to crazy 8s");
		System.out.println("how many rounds would you like to play?");
		int rouNum = in.nextInt();
		in.nextLine();

		//round starts
		//if the selected number of rounds is less than or equal to the number of rounds it continues
		
		if (round <= rouNum) {
			System.out.println("round " + round + "");
			
			//setting up the deck and players
			Deck d = new Deck();
			d.shuffle();
			ArrayList<Card> P1 = new ArrayList<>();
			ArrayList<Card> P2 = new ArrayList<>();
			ArrayList<Card> P3 = new ArrayList<>();
			ArrayList<Card> P4 = new ArrayList<>();
			ArrayList<Card> discard = new ArrayList<>();

			int turn = 1;
			int newSuitC = 1;
			
			// deals 8 cards to the players
			for (int x = 0; x < 8; x++) {
				P1.add(d.deal());
				P2.add(d.deal());
				P3.add(d.deal());
				P4.add(d.deal());

			}
			

			System.out.println("the cards have been shuffled");
			
			// deals the first card
			discard.add(d.deal());
			
			// checking to see if any of the players run out of cards
			// if they do the round ends
			while (!(P1.size() == 0) && !(P2.size() == 0) && !(P3.size() == 0) && !(P4.size() == 0)) {
				
				// the first players turn starts
				while (turn == 1) {
					
					System.out.println("it is your turn");
					
					System.out.println("the top card is " + discard.get(discard.size() - 1).getName() + "");

					System.out.println("you have " + P1 + " in your hand");
					boolean correct = true;
					 
					//lets the player pick their card
					while (correct) {
						
						// asks the player which card they would like
						System.out.println(
								"What card would you like to play? (please select the number position of your card or 0 to pick up)");
						int carChoice = in.nextInt();
						in.nextLine();

						carChoice = carChoice - 1;
						
						// if they choose to skip (pick 0) they get dealt a card
						if (carChoice == -1) {
							P1.add(d.deal());
							System.out.println("You skipped");
							
							// the turn ends
							turn++;
							correct = false;
						
						// if they pick an 8 they choose which suit they want to change to
						} else if (P1.get(carChoice).getNumber() == 8) {
							System.out.println("You put a CRAZY 8! What would you like to change the suit to?");
							String newSuit = in.nextLine();
							newSuit = newSuit.toUpperCase();
							
							// changes the suit depending on their choice
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
							
							// discards the card
							discard.add(P1.get(carChoice));
							P1.remove(carChoice);
							
							// the turn ends
							turn++;
							correct = false;

							// if the card they choose was not an 8 it checks to see if it can be used
						} else {
							
							// if the card's suit or number matches the last discarded card, it gets discarded
							if (P1.get(carChoice).getSuit() == discard.get(discard.size() - 1).getSuit()
									|| P1.get(carChoice).getNumber() == discard.get(discard.size() - 1).getNumber()) {

								discard.add(P1.get(carChoice));
								P1.remove(carChoice);

								System.out.println("You put " + discard.get(discard.size() - 1) + "");

								turn++;
								correct = false;
								
								// if not, the player gets asked again until they discard a appropriate card or skip
							} else {
								System.out.println("you can't put that card pick another");

							}

						}
					}
				}

				// the computers' turns
				while (turn > 1) {
					
					// the hand of P2 gets checked for usable cards
					for (int x = 0; x < P2.size(); x++) {
						
						// if there is a card with a matching number or suit, it is discarded
						if (P2.get(x).getSuit() == discard.get(discard.size() - 1).getSuit()
								|| P2.get(x).getNumber() == discard.get(discard.size() - 1).getNumber()) {
							
							// if the card is an 8 the suit gets changed
							// between the three computers the new suit changes each time an 8 is played
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
								
								// the card is discarded and the turn ends
								discard.add(P2.get(x));
								P2.remove(x);
								break;

							} else {
								
								// if it is not an 8, the card is discarded
								System.out.println("P2 played " + P2.get(x) + "");
								discard.add(P2.get(x));
								P2.remove(x);
								
								// the turn ends
								break;

							}
							
						// if there is no playable cards then P2 skips
						} else if (x == P2.size() - 1) {
							P2.add(d.deal());
							System.out.println("P2 skipped");
							break;

						}

					}
					
					//checks the cards in P2's hand
					for (int x = 0; x < P3.size(); x++) {
						
						// checks to see if the card matches the suit or number of the last card
						if (P3.get(x).getSuit() == discard.get(discard.size() - 1).getSuit()
								|| P3.get(x).getNumber() == discard.get(discard.size() - 1).getNumber()) {
							
							// if the playable card is an 8 the suit is changed
							if (P3.get(x).getNumber() == 8) {
								System.out.println("P3 played " + P3.get(x) + "");
								
								// the new suit is changed ever time a computer gets an 8
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
								
								// the card is discarded
								discard.add(P3.get(x));
								P3.remove(x);
								
								// the turn ends
								break;

							} else {
								
								// if the card is not an 8 it is discarded
								System.out.println("P3 played " + P3.get(x) + "");
								discard.add(P3.get(x));
								P3.remove(x);
								
								// the turn ends
								break;

							}
							
						// if the card is not an 8 it is discarded
						} else if (x == P3.size() - 1) {
							P3.add(d.deal());
							System.out.println("P3 skipped");
							
							// the turn ends
							break;

						}
					}
					
					// checks the cards of P4's hand
					for (int x = 0; x < P4.size(); x++) {
						
						// checks to see if the suit / number of the card matches the last played card
						if (P4.get(x).getSuit() == discard.get(discard.size() - 1).getSuit()
								|| P4.get(x).getNumber() == discard.get(discard.size() - 1).getNumber()) {
							
							// if the card is an 8 the suit changes
							if (P4.get(x).getNumber() == 8) {
								System.out.println("P4 played " + P4.get(x) + "");
								
								// the chosen suit changes every time a computer plays an 8
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
								
								// the card is discarded
								discard.add(P4.get(x));
								P4.remove(x);
								
								// the turn ends
								break;

							} else {
								
								// if the card is not an 8 it is discarded
								System.out.println("P4 played " + P4.get(x) + "");
								discard.add(P4.get(x));
								P4.remove(x);
								
								// the turn ends
								break;

							}
							
						// if there is no playable cards then it skips and they pick up a card
						} else if (x == P4.size() - 1) {
							P4.add(d.deal());
							System.out.println("P4 skipped");
							
							// the turn ends
							break;

						}
					}
					
					// the turns reset again
					turn = 1;
				}

			}
			
			// once someone runs out of cards it checks to see who won
			if (P1.size() == 0) {
				System.out.println("P1 Won");

			} else if (P2.size() == 0) {
				System.out.println("P2 Won");

			} else if (P3.size() == 0) {
				System.out.println("P3 Won");
				
			} else if (P2.size() == 0) {
				System.out.println("P4 Won");
				
			}
			
			// going to the next round
			round ++; 
			
		// if the final round is finished then the game ends	
		} else if (round > rouNum) {
			System.out.println("Thank you for playing!");
		}
	}

}
