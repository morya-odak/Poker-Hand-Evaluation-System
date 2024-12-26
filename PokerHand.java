package model;

import java.util.ArrayList;
import java.util.Collections;

/*
 * @Author: Rick Mercer and Morya Odak
 */
public class PokerHand implements Comparable<PokerHand> {

	ArrayList<Card> cards;

	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);

		Collections.sort(cards);
	}

	public boolean isStraightFlush() {
		return this.isStraight() && this.isFlush();
	}

	public boolean isRoyalFlush() {
		return this.isBroadway() && this.isFlush();
	}

	public boolean isQuads() {
		for (int i = 0; i < 2; i++) {
			if (cards.get(i).compareTo(cards.get(i + 1)) == 0 && cards.get(i).compareTo(cards.get(i + 2)) == 0
					&& cards.get(i).compareTo(cards.get(i + 3)) == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isFullHouse() {
		if (cards.get(0).compareTo(cards.get(1)) == 0 && cards.get(4).compareTo(cards.get(3)) == 0) {
			if (cards.get(2).compareTo(cards.get(1)) == 0 || cards.get(2).compareTo(cards.get(3)) == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isFlush() {
		Suit s = cards.get(0).getSuit();
		for (int i = 0; i < this.cards.size(); i++) {
			if (cards.get(i).getSuit() != s) {
				return false;
			}
		}
		return true;
	}

	public boolean isBroadway() {
		if (cards.get(0).getRank() != Rank.TEN) {
			return false;
		}
		for (int i = 0; i < this.cards.size() - 1; i++) {
			if (cards.get(i).compareTo(cards.get(i + 1)) != -1) {
				return false;
			}
		}
		return true;
	}

	public boolean isStraight() {

		for (int i = 0; i < this.cards.size() - 1; i++) {
			if (cards.get(i).compareTo(cards.get(i + 1)) != -1) {
				return false;
			}
		}
		return true;
	}

	// precondition: the hand is not a full house or quads.
	public boolean isTrips() {
		if (this.isQuads()) {
			return false;
		}
		for (int i = 0; i < cards.size() - 2; i++) {
			if (cards.get(i).compareTo(cards.get(i + 1)) == 0 && cards.get(i).compareTo(cards.get(i + 2)) == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isTwoPair() {
		if (this.isFullHouse()) {
			return false;
		}
		boolean pairFound = false;
		int i = 0;
		while (i < 4 && pairFound == false) {
			if (cards.get(i).compareTo(cards.get(i + 1)) == 0) {
				pairFound = true;
				i++;
			}
			i++;
		}
		if (pairFound) {
			while (i < 4) {
				if (cards.get(i).compareTo(cards.get(i + 1)) == 0) {
					return true;
				}
				i++;
			}
		}
		return false;

	}

	public boolean isPair() {
		if (this.isTrips()) {
			return false;
		}
		for (int i = 0; i < 4; i++) {
			if (cards.get(i).compareTo(cards.get(i + 1)) == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isBetterThanQuads() {
		return this.isStraightFlush() || this.isRoyalFlush();
	}

	public boolean isBetterThanFullHouse() {
		return this.isBetterThanQuads() || this.isQuads();
	}

	public boolean isBetterThanFlush() {
		return this.isBetterThanFullHouse() || this.isFullHouse();
	}

	public boolean isBetterThanStraight() {
		return this.isBetterThanFlush() || this.isFlush();
	}

	public boolean isBetterThanTrips() {
		return this.isBetterThanStraight() || this.isStraight();
	}

	public boolean isBetterThanTwoPair() {
		return this.isBetterThanTrips() || this.isTrips();
	}

	public boolean isBetterThanPair() {
		return this.isBetterThanTwoPair() || this.isTwoPair();
	}

	public boolean isBetterThanHighCard() {
		return this.isBetterThanPair() || this.isPair();
	}

	public int compareHighCard(PokerHand o) {
		for (int i = 4; i >= 0; i--) {
			int difference = this.cards.get(i).compareTo(o.cards.get(i));
			if (difference > 0) {
				return 1;
			} else if (difference < 0) {
				return -1;
			}
		}
		return 0;

	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < cards.size(); i++) {
			result += cards.get(i).toString() + " ";
		}
		return result;
	}

	@Override
	public int compareTo(PokerHand o) {
		ArrayList<PokerHand> handList = new ArrayList<>();
		handList.add(this);
		handList.add(o);
		if (this.isRoyalFlush() && !o.isRoyalFlush()) {
			return 1;
		} else if (!this.isRoyalFlush() && o.isRoyalFlush()) {
			return -1;
		} else if (this.isStraightFlush() && (!o.isRoyalFlush() && !o.isStraightFlush())) {
			return 1;
		} else if (o.isStraightFlush() && !this.isRoyalFlush() && !this.isStraightFlush()) {
			return -1;
		} else if (this.isQuads() && !o.isBetterThanFullHouse()) {
			return 1;
		} else if (o.isQuads() && !this.isBetterThanFullHouse()) {
			return -1;
		} else if (this.isFullHouse() && !o.isBetterThanFlush()) {
			return 1;
		} else if (o.isFullHouse() && !this.isBetterThanFlush()) {
			return -1;
		} else if (this.isFlush() && !o.isBetterThanStraight()) {
			return 1;
		} else if (o.isFlush() && !this.isBetterThanStraight()) {
			return -1;
		} else if (this.isStraight() && !o.isBetterThanTrips()) {
			return 1;
		} else if (o.isStraight() && !this.isBetterThanTrips()) {
			return -1;
		} else if (this.isTrips() && !o.isBetterThanTwoPair()) {
			return 1;
		} else if (o.isTrips() && !this.isBetterThanTwoPair()) {
			return -1;
		} else if (this.isTwoPair() && !o.isBetterThanPair()) {
			return 1;
		} else if (o.isTwoPair() && !this.isBetterThanPair()) {
			return -1;
		} else if (this.isPair() && !o.isBetterThanHighCard()) {
			return 1;
		} else if (o.isPair() && !this.isBetterThanHighCard()) {
			return -1;
		}

		if (this.isRoyalFlush()) {
			return 0;
		} else if (this.isStraightFlush() || this.isFlush() || this.isStraight()) {
			return this.compareHighCard(o);
		} else if (this.isQuads()) {
			int difference = this.cards.get(1).compareTo(o.cards.get(1));
			if (difference > 0) {
				return 1;
			} else if (difference < 0) {
				return -1;
			} else {
				Card kickerOne;
				Card kickerTwo;
				if (this.cards.get(1).compareTo(this.cards.get(0)) != 0) {
					kickerOne = this.cards.get(0);
				} else {
					kickerOne = this.cards.get(4);
				}
				if (o.cards.get(1).compareTo(o.cards.get(0)) != 0) {
					kickerTwo = o.cards.get(0);
				} else {
					kickerTwo = o.cards.get(4);
				}
				if (kickerOne.compareTo(kickerTwo) != 0) {
					return kickerOne.compareTo(kickerTwo);
				} else {
					return 0;
				}
			}
		} else if (this.isFullHouse()) {
			int difference = this.cards.get(2).compareTo(o.cards.get(2));
			if (difference > 0) {
				return 1;
			} else if (difference < 0) {
				return -1;
			} else {
				Card pairCardOne;
				Card pairCardTwo;
				if (this.cards.get(2).compareTo(this.cards.get(3)) != 0) {
					pairCardOne = this.cards.get(3);
				} else {
					pairCardOne = this.cards.get(1);
				}
				if (o.cards.get(2).compareTo(o.cards.get(3)) != 0) {
					pairCardTwo = o.cards.get(3);
				} else {
					pairCardTwo = o.cards.get(1);
				}
				return pairCardOne.compareTo(pairCardTwo);
			}
		} else if (this.isTrips()) {
			int difference = this.cards.get(2).compareTo(o.cards.get(2));
			if (difference > 0) {
				return 1;
			} else if (difference < 0) {
				return -1;
			} else {
				Card highKickerOne;
				Card lowKickerOne;
				Card highKickerTwo;
				Card lowKickerTwo;
				if (this.cards.get(2).compareTo(this.cards.get(3)) != 0) {
					highKickerOne = this.cards.get(4);
					lowKickerOne = this.cards.get(3);
				} else {
					highKickerOne = this.cards.get(1);
					lowKickerOne = this.cards.get(0);
				}
				if (o.cards.get(2).compareTo(o.cards.get(3)) != 0) {
					highKickerTwo = o.cards.get(4);
					lowKickerTwo = o.cards.get(3);
				} else {
					highKickerTwo = o.cards.get(1);
					lowKickerTwo = o.cards.get(0);
				}
				int highKickerDifference = highKickerOne.compareTo(highKickerTwo);
				if (highKickerDifference > 0) {
					return 1;
				} else if (highKickerDifference < 0) {
					return -1;
				} else {
					return lowKickerOne.compareTo(lowKickerTwo);
				}
			}
		} else if (this.isTwoPair()) {
			Card highPairOne = this.cards.get(3);
			Card highPairTwo = o.cards.get(3);
			if (highPairOne.compareTo(highPairTwo) != 0) {
				return highPairOne.compareTo(highPairTwo);
			} else {
				Card lowPairOne = this.cards.get(1);
				Card lowPairTwo = o.cards.get(1);
				if (lowPairOne.compareTo(lowPairTwo) != 0) {
					return lowPairOne.compareTo(lowPairTwo);
				} else {
					int highPair = highPairOne.getValue();
					int lowPair = lowPairOne.getValue();
					Card kickerOne = this.cards.get(0);
					Card kickerTwo = o.cards.get(0);
					for (int i = 1; i < 5; i++) {

						if (this.cards.get(i).getValue() != highPair && this.cards.get(i).getValue() != lowPair) {
							kickerOne = this.cards.get(i);
						}
						if (o.cards.get(i).getValue() != highPair && o.cards.get(i).getValue() != lowPair) {
							kickerTwo = o.cards.get(i);
						}
					}
					return kickerOne.compareTo(kickerTwo);
				}
			}
		} else if (this.isPair()) {
			Card pairOne = this.cards.get(0);
			Card pairTwo = o.cards.get(0);
			for (int i = 0; i < 4; i++) {
				if (this.cards.get(i).compareTo(this.cards.get(i + 1)) == 0) {
					pairOne = this.cards.get(i);
				}
				if (o.cards.get(i).compareTo(o.cards.get(i + 1)) == 0) {
					pairTwo = o.cards.get(i);
				}
			}
			if (pairOne.compareTo(pairTwo) != 0) {
				return pairOne.compareTo(pairTwo);
			} else {
				ArrayList<Card> kickersOne = new ArrayList<>();
				ArrayList<Card> kickersTwo = new ArrayList<>();
				for (int i = 0; i < 5; i++) {
					if (this.cards.get(i) != pairOne) {
						kickersOne.add(this.cards.get(i));
					}
					if (o.cards.get(i) != pairTwo) {
						kickersTwo.add(o.cards.get(i));
					}
				}
				for (int i = 2; i > -1; i--) {
					if (kickersOne.get(i).compareTo(kickersTwo.get(i)) != 0) {
						return kickersOne.get(i).compareTo(kickersTwo.get(i));
					}
				}
				return 0;
			}
		} else {
			return this.compareHighCard(o);
		}
	}
}