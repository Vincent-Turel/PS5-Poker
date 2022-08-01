import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    public void analyzeHandTest() {
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card4 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card5 = new Card(CardValue.As, CardSuit.Carreau);

        Card card10 = new Card(CardValue.Dame, CardSuit.Trefle);
        Card card20 = new Card(CardValue.Dame, CardSuit.Carreau);
        Card card30 = new Card(CardValue.Neuf, CardSuit.Carreau);
        Card card40 = new Card(CardValue.Dame, CardSuit.Coeur);
        Card card50 = new Card(CardValue.Dame, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card2, card3, card4, card5);
        Hand hand2 = new Hand(card10,card20,card30,card40,card50);

        int[][] analyzedArray = new int[][] {{0,2},{10,1},{11,1},{12,1}};
        int[][] analyzedArray2 = new int[][] {{2,4},{5,1}};

        assert(Arrays.deepEquals(hand1.analyzeHand(), analyzedArray));
        assert(Arrays.deepEquals(hand2.analyzeHand(), analyzedArray2));
    }

    @Test
    public void suiteTest() {
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card4 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card5 = new Card(CardValue.Cinq, CardSuit.Carreau);
        Card card6 = new Card(CardValue.Six, CardSuit.Pique);

        Hand hand1 = new Hand(card6, card5, card4, card3, card2);
        Hand hand2 = new Hand(card6, card5, card1, card3, card2);

        assertFalse(hand2.suite());
        assertTrue(hand1.suite());
    }

    @Test
    public void flushTest() {
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.Deux, CardSuit.Pique);
        Card card3 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card4 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card5 = new Card(CardValue.Cinq, CardSuit.Carreau);
        Card card6 = new Card(CardValue.Six, CardSuit.Pique);

        Hand hand1 = new Hand(card6, card1, card4, card3, card2);
        Hand hand2 = new Hand(card6, card5, card1, card3, card2);

        assertFalse(hand2.couleur());
        assertTrue(hand1.couleur());
    }

    @Test
    public void quinteFlushTest(){
        Card card0 = new Card(CardValue.As, CardSuit.Pique);
        Card card1 = new Card(CardValue.Deux, CardSuit.Coeur);
        Card card2 = new Card(CardValue.Deux, CardSuit.Pique);
        Card card3 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card4 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card5 = new Card(CardValue.Cinq, CardSuit.Pique);
        Card card6 = new Card(CardValue.Six, CardSuit.Pique);

        Hand hand1 = new Hand(card5, card0, card4, card3, card2);
        Hand hand3 = new Hand(card5, card1, card4, card3, card2);
        Hand hand2 = new Hand(card6, card5, card4, card3, card2);

        assertFalse(hand3.quinteFlush());
        assertFalse(hand1.quinteFlush());
        assertTrue(hand2.quinteFlush());
    }

    @Test
    public void carre() {
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.As, CardSuit.Carreau);
        Card card3 = new Card(CardValue.As, CardSuit.Pique);
        Card card4 = new Card(CardValue.As, CardSuit.Pique);
        Card card5 = new Card(CardValue.Cinq, CardSuit.Carreau);
        Card card6 = new Card(CardValue.Six, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card5, card4, card3, card2);
        Hand hand2 = new Hand(card6, card5, card1, card6, card2);

        assertFalse(hand2.carre());
        assertTrue(hand1.carre());
    }

    @Test
    public void PairTest() {
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card4 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card5 = new Card(CardValue.As, CardSuit.Carreau);
        Card card6 = new Card(CardValue.Cinq, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card2, card3, card4, card5);
        Hand hand2 = new Hand(card1, card2, card3, card4, card6);

        assertTrue(hand1.paire());
        assertFalse(hand2.paire());
    }

    @Test
    public void DoublePairTest(){
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card4 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card5 = new Card(CardValue.As, CardSuit.Carreau);
        Card card6 = new Card(CardValue.Cinq, CardSuit.Pique);
        Card card7 = new Card(CardValue.Deux, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card2, card3, card4, card5);
        Hand hand2 = new Hand(card1, card2, card3, card4, card6);
        Hand hand3 = new Hand(card1, card2, card3, card5, card7);

        assertFalse(hand2.doublePaire());
        assertFalse(hand1.doublePaire());
        assertTrue(hand3.doublePaire());
    }

    @Test
    public void BrelanTest(){
        Card card1 = new Card(CardValue.As, CardSuit.Coeur);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card4 = new Card(CardValue.As, CardSuit.Pique);
        Card card5 = new Card(CardValue.As, CardSuit.Carreau);
        Card card6 = new Card(CardValue.Deux, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card2, card3, card4, card5);
        Hand hand2 = new Hand(card1, card2, card3, card4, card6);

        assertFalse(hand2.brelan());
        assertTrue(hand1.brelan());
    }

    @Test
    public void FullTest(){
        Card card1 = new Card(CardValue.As, CardSuit.Coeur);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card4 = new Card(CardValue.As, CardSuit.Pique);
        Card card5 = new Card(CardValue.As, CardSuit.Carreau);
        Card card6 = new Card(CardValue.Deux, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card2, card3, card4, card5);
        Hand hand2 = new Hand(card1, card2, card5, card4, card6);

        assertTrue(hand2.full());
        assertFalse(hand1.full());

    }

    @Test
    public void setHandValueTest() {
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card4 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card5 = new Card(CardValue.As, CardSuit.Carreau);

        Card card10 = new Card(CardValue.Dame, CardSuit.Trefle);
        Card card20 = new Card(CardValue.Dame, CardSuit.Carreau);
        Card card30 = new Card(CardValue.Neuf, CardSuit.Carreau);
        Card card40 = new Card(CardValue.Dame, CardSuit.Coeur);
        Card card50 = new Card(CardValue.Dame, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card2, card3, card4, card5);
        Hand hand2 = new Hand(card10,card20,card30,card40,card50);

        assertEquals(hand1.setHandValue(), HandValue.PAIRE);
        assertEquals(hand2.setHandValue(), HandValue.CARRE);
    }

    @Test
    public void compareToTest() {
        Card card1 = new Card(CardValue.As, CardSuit.Pique);
        Card card2 = new Card(CardValue.Deux, CardSuit.Carreau);
        Card card3 = new Card(CardValue.Quatre, CardSuit.Pique);
        Card card4 = new Card(CardValue.Trois, CardSuit.Pique);
        Card card5 = new Card(CardValue.As, CardSuit.Carreau);

        Card card10 = new Card(CardValue.Dame, CardSuit.Trefle);
        Card card20 = new Card(CardValue.Dame, CardSuit.Carreau);
        Card card30 = new Card(CardValue.Neuf, CardSuit.Carreau);
        Card card40 = new Card(CardValue.Dame, CardSuit.Coeur);
        Card card50 = new Card(CardValue.Dame, CardSuit.Pique);

        Hand hand1 = new Hand(card1, card2, card3, card4, card5);
        Hand hand2 = new Hand(card1, card2, card3, card4, card5);
        Hand hand3 = new Hand(card10,card20,card30,card40,card50);

        assertEquals(hand1.compareTo(hand2), 0);
        assertEquals(hand3.compareTo(hand1), 1);
        assertEquals(hand1.compareTo(hand3), -1);
    }
}

