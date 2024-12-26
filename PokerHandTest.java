package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the CardHand class, last modified Sep 2015, June 2017, July 23, August 23
 * 
 * I think this a pretty good unit test, if you add any other test cases 
 * please send them to me!
 * 
 * I am providing all 52 possible Cars to save you time writing @Tests
 * 
 * @author Rick Mercer and Morya Odak
 */


public class PokerHandTest {
  
  //  This file contains all 52 cards to save you time with names like 
  //  C2 for the two of clubs
  //  AS for the ace of spades
  
  // Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
  private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
  private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
  private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
  private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
  private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
  private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
  private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
  private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
  private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
  private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
  private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
  private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
  private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

  private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
  private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
  private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
  private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
  private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
  private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
  private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
  private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
  private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
  private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
  private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
  private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
  private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

  private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
  private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
  private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
  private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
  private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
  private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
  private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
  private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
  private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
  private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
  private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
  private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
  private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

  private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
  private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
  private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
  private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
  private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
  private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
  private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
  private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
  private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
  private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
  private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
  private final static Card SK = new Card(Rank.KING, Suit.SPADES);
  private final static Card SA = new Card(Rank.ACE, Suit.SPADES);
  
  @Test
  public void test() {
	  PokerHand a = new PokerHand(H2, H3, H4, H5, H6);
	  PokerHand f = new PokerHand(S3, S4, S5, S6, S7);
	  PokerHand b = new PokerHand(H3, S3, D3, H4, H5);
	  PokerHand c = new PokerHand(S3, S2, D3, S2, S5);
	  PokerHand d = new PokerHand(S3, H3, D3, S7, H7);
	  PokerHand e = new PokerHand(H3, S3, DQ, CK, H2);
	  PokerHand g = new PokerHand(S2, D5, D5, DK, DK);
	  PokerHand h = new PokerHand(S3, H3, D8, D8, S8);
	  PokerHand i = new PokerHand(HK, SK, D8, S8, C8);
	  assertTrue(a.isFlush());
	  assertTrue(a.isStraight());
	  assertTrue(a.isStraightFlush());
	  assertTrue(b.isTrips());
	  assertTrue(c.isTwoPair());
	  assertTrue(d.isFullHouse());
	  assertTrue(e.isPair());
	  assertTrue(e.compareTo(a) < 0);
	  assertTrue(a.compareTo(f)<0);
	  assertTrue(g.isTwoPair());
	  assertTrue(h.compareTo(i) < 0);
	  assertTrue(h.toString().equals("3♠ 3♥ 8♦ 8♦ 8♠ "));
  }
  
  @Test
  public void testTrips() {
	  PokerHand a = new PokerHand(H3, S3, D3, C6, D6);
	  PokerHand b = new PokerHand(H3, S3, D3, C6, D5);
	  assertTrue(a.compareTo(b) > 0);
  }
  
  @Test
  public void testTwoPair() {
	  PokerHand a = new PokerHand(H3, S3, H2, S2, SA);
	  PokerHand b = new PokerHand(H3, S3, H2, S2, SK);
	  assertTrue(a.compareTo(b) > 0);
  }
  
  @Test
  public void testPair() {
	  PokerHand a= new PokerHand(H6, S6, D2, C8, H9);
	  PokerHand b= new PokerHand(H6, S6, D3, C8, H9);
	  assertTrue(a.compareTo(b) < 0);
  }
  @Test
  public void testHighCard1() {
    PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
    PokerHand b = new PokerHand(C2, C5, C7, DQ, DK);
    assertTrue(a.compareTo(b) > 0);
  } 
  
  @Test
  public void testICA13() {
      // Question 1
      PokerHand hand1 = new PokerHand(H2, D2, S4, C4, H9);
      PokerHand hand2 = new PokerHand(S2, C2, H3, D3, CA);
      assertTrue(hand1.compareTo(hand2) > 0);
      
      // Question 2
      PokerHand hand3 = new PokerHand(D3, D6, D7, DJ, SK);
      PokerHand hand4 = new PokerHand(C3, C5, C7, CJ, DK);
      assertTrue(hand3.compareTo(hand4) > 0);
      
      // Question 3
      PokerHand hand5 = new PokerHand(H2, D2, S5, C5, H5);
      PokerHand hand6 = new PokerHand(S4, C4, H4, HA, CA);
      assertTrue(hand5.compareTo(hand6) > 0);
      
      // Question 4
      PokerHand hand7 = new PokerHand(H2, D2, S4, C4, H9);
      PokerHand hand8 = new PokerHand(S2, C2, H3, D3, CA);
      assertTrue(hand7.compareTo(hand8) > 0);
      
      // Question 5
      PokerHand hand9 = new PokerHand(CQ, HQ, CK, DK, HK);
      PokerHand hand10 = new PokerHand(H2, D2, CA, DA, HA);
      assertTrue(hand9.compareTo(hand10) < 0);
      
      // Question 6
      PokerHand hand11 = new PokerHand(D2, H2, DQ, HK, SA);
      PokerHand hand12 = new PokerHand(C3, H3, H4, H5, S6);
      assertTrue(hand11.compareTo(hand12) < 0);
      
      // Question 7
      PokerHand hand13 = new PokerHand(D2, H2, C2, HK, SA);
      PokerHand hand14 = new PokerHand(C3, H3, D3, H4, S5);
      assertTrue(hand13.compareTo(hand14) < 0);
      
      // Question 8
      PokerHand hand15 = new PokerHand(D3, D6, D7, DJ, DK);
      PokerHand hand16 = new PokerHand(C2, C6, C7, CJ, CK);
      assertTrue(hand15.compareTo(hand16) > 0);
      
      // Question 9
      PokerHand hand17 = new PokerHand(D2, D6, C7, DJ, DK);
      PokerHand hand18 = new PokerHand(C2, C6, D7, CJ, CK);
      assertTrue(hand17.compareTo(hand18) == 0);
      
      // Question 10
      PokerHand hand19 = new PokerHand(D3, D6, C6, DJ, CJ);
      PokerHand hand20 = new PokerHand(C3, H6, S6, HJ, SJ);
      assertTrue(hand19.compareTo(hand20) == 0);
      
      // Question 11
      PokerHand hand21 = new PokerHand(D3, D4, D5, D6, D7);
      PokerHand hand22 = new PokerHand(CA, SA, DA, H7, C7);
      assertTrue(hand21.compareTo(hand22) > 0);
      
      // Question 12
      PokerHand hand23 = new PokerHand(H2, H5, H7, HJ, HA);
      PokerHand hand24 = new PokerHand(S10, CJ, HQ, HK, CA);
      assertTrue(hand23.compareTo(hand24) > 0);
      
      // Question 13
      PokerHand hand25 = new PokerHand(S2, C3, H5, S5, D5);
      PokerHand hand26 = new PokerHand(H2, C4, H4, H6, H6);
      assertTrue(hand25.compareTo(hand26) > 0);
      
      // Question 14
      PokerHand hand27 = new PokerHand(H2, D2, S4, C4, HA);
      PokerHand hand28 = new PokerHand(S2, C3, C3, D3, C4);
      assertTrue(hand27.compareTo(hand28) < 0);
      
  }
  
  @Test
  public void testsToMeetCoverage() {
	 PokerHand a = new PokerHand(SA, SK, SQ, SJ, S10);
	 PokerHand b = new PokerHand(S2, D6, HK, SK, D5);
	 assertTrue(a.compareTo(b)> 0);
	 assertTrue(b.compareTo(a)<0);
	 PokerHand c= new PokerHand(S2, D2, H2, C2, DA);
	 assertTrue(c.compareTo(b)>0);
	 assertTrue(b.compareTo(c)<0);
	 
     // 1
     PokerHand worseThanFullHouse = new PokerHand(H2, D2, S6, C3, H3);
     PokerHand fullHouse = new PokerHand(HA, DA, SA, CK, HK);
     assertTrue(worseThanFullHouse.compareTo(fullHouse) < 0);
     assertTrue(fullHouse.compareTo(worseThanFullHouse)>0);

     // 2
     PokerHand flush = new PokerHand(S2, S4, S6, S8, S10);
     PokerHand worseThanStraight = new PokerHand(H3, D5, C7, H9, SJ);
     assertTrue(worseThanStraight.compareTo(flush) < 0);

     // 3
     PokerHand straight = new PokerHand(H2, D3, S4, C5, H6);
     PokerHand worseThanStraight2 = new PokerHand(SA, H2, D4, C6, H8);
     assertTrue(worseThanStraight2.compareTo(straight) < 0);
     assertTrue(straight.compareTo(worseThanStraight2)>0);

     // 4
     PokerHand worseThanStraight3 = new PokerHand(HA, D2, S3, C4, H6);
     PokerHand straight2 = new PokerHand(S2, C3, H4, D5, C6);
     assertTrue(worseThanStraight3.compareTo(straight2) < 0);

     // 5
     PokerHand twoPair = new PokerHand(H2, D2, S4, C4, H8);
     PokerHand worseThanTwoPair = new PokerHand(SA, DA, S2, C3, HK);
     assertTrue(worseThanTwoPair.compareTo(twoPair) < 0);
     assertTrue(twoPair.compareTo(worseThanTwoPair) > 0);

     // 6
     PokerHand worseThanTwoPair2 = new PokerHand(HA, DA, S2, C6, HK);
     PokerHand pair = new PokerHand(S2, C3, H3, D6, C6);
     assertTrue(worseThanTwoPair2.compareTo(pair) < 0);

     // 7
     PokerHand aPair = new PokerHand(H2, D2, S5, C7, H9);
     PokerHand highCard = new PokerHand(SA, H3, D4, C8, H10);
     assertTrue(aPair.compareTo(highCard) > 0);

     // 8
     PokerHand highCard2 = new PokerHand(HA, D3, S4, C8, H10);
     PokerHand bPair = new PokerHand(S2, C3, H4, D6, C6);
     assertTrue(highCard2.compareTo(bPair) < 0);

     // 9
     PokerHand royalFlushA = new PokerHand(S10, SJ, SQ, SK, SA);
     PokerHand royalFlushB = new PokerHand(C10, CJ, CQ, CK, CA);
     assertTrue(royalFlushA.compareTo(royalFlushB) == 0);

     // 10
     PokerHand higherQuads = new PokerHand(D5, H5, C5, S5, HA);
     PokerHand quads = new PokerHand(C2, D2, H2, S2, H4);
     assertTrue(quads.compareTo(higherQuads) < 0);
     assertTrue(higherQuads.compareTo(quads)>0);

     // 11
     PokerHand betterKicker = new PokerHand(S5, C5, H5, D5, HA);
     PokerHand sameQuads = new PokerHand(C5, D5, H5, S5, HK);
     assertTrue(sameQuads.compareTo(betterKicker) < 0);
    
     //12
     PokerHand quadsLowKicker = new PokerHand(S5, C5, H5, D5, S2);
     PokerHand quadsHighKicker = new PokerHand(S5, C5, H5, D5, S4);
     assertTrue(quadsLowKicker.compareTo(quadsHighKicker)<0);
     assertTrue(quadsHighKicker.compareTo(quadsLowKicker)>0);
     
     //13
     PokerHand fullHouseLowPair = new PokerHand(S6, H6, D6, S2, H2);
     PokerHand fullHouseHighPair = new PokerHand(S6, H6, D6, SJ, HJ);
     assertTrue(fullHouseHighPair.compareTo(fullHouseLowPair)>0);
     
     //14
     PokerHand onePairOne = new PokerHand(S6, H6, D2, C4, HK);
     PokerHand onePairTwo = new PokerHand(S6, H6, D2, C4, HK);
     assertTrue(onePairOne.compareTo(onePairTwo)==0);
     
     //15 
     PokerHand tripsLowKickers = new PokerHand(S10, H10, D10, S2, H5);
     PokerHand tripsHighKickers = new PokerHand(S10, H10, D10, S3, H6);
     assertTrue(tripsLowKickers.compareTo(tripsHighKickers)<0);
     assertTrue(tripsHighKickers.compareTo(tripsLowKickers)>0);
     
     //16
     PokerHand tripsLowKickers2 = new PokerHand(S9, H9, D9, SJ, HQ);
     PokerHand tripsHighKickers2 = new PokerHand(S10, H10, D10, SQ, HK);
     assertTrue(tripsLowKickers2.compareTo(tripsHighKickers2)<0);
     assertTrue(tripsHighKickers2.compareTo(tripsLowKickers2)>0);
     
     PokerHand trips1 = new PokerHand(S7, H7, D7, S10, DJ);
     PokerHand trips2 = new PokerHand(S7, H7, D7, S10, DQ);
     assertTrue(trips1.compareTo(trips2)<0);
     assertTrue(trips2.compareTo(trips1)>0);
     
     PokerHand trips3 = new PokerHand(S7, H7, D7, S10, D9);
     PokerHand trips4 = new PokerHand(S7, H7, D7, S10, D8);
     assertTrue(trips3.compareTo(trips4)>0);
     
     PokerHand twoPairOne = new PokerHand(S7, H7, D6, S6, D5);
     PokerHand twoPairTwo = new PokerHand(S7, H7, D5, S5, CA);
     assertTrue(twoPairOne.compareTo(twoPairTwo)>0);
     
     PokerHand quadsOne = new PokerHand(S10, D10, H10, C10, S5);
     assertTrue(quadsOne.compareTo(quadsOne)==0);
     
	 
  }
  
}