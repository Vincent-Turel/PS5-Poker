import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserInteractionTest {
    @Test
    public void convertStringToCardTest(){
        Card[] cardArray = new Card[10];

        String[] strArray = new String[]{"2Tr", "6Ca", "7Ca", "8Tr", "APi", "3Tr", "5Ca", "9Ca", "DCo", "RCo"};
        String[] strArray2 = new String[]{"2Tr", "6Ca", "7Ca", "8Tr", "APi","3Tr", "5Ca", "9Ca", "DCo"};
        String[] strArray3 = new String[]{"10Ta", "6Ca", "7Ca", "8Tr", "APi","3Tr", "5Ca", "9Ca", "DCo", "RCo"};
        String[] strArray4 = new String[]{"Pco", "6Ca", "7Ca", "8Tr", "APi","3Tr", "5Ca", "9Ca", "2Tr", "RCo"};
        String[] strArray5 = new String[]{"2Tr", "2Tr", "7Ca", "8Tr", "APi","3Tr", "5Ca", "9Ca", "7Co", "RCo"};

        assertFalse(UserInteraction.convertStringToCard(strArray2, cardArray));
        Arrays.fill(cardArray, null);
        assertFalse(UserInteraction.convertStringToCard(strArray3, cardArray));
        Arrays.fill(cardArray, null);
        assertFalse(UserInteraction.convertStringToCard(strArray4, cardArray));
        Arrays.fill(cardArray, null);
        assertFalse(UserInteraction.convertStringToCard(strArray5, cardArray));
        Arrays.fill(cardArray, null);
        assertTrue(UserInteraction.convertStringToCard(strArray, cardArray));
        assertEquals(CardValue.Roi, cardArray[9].getValue());
        assertEquals(CardSuit.Coeur, cardArray[9].getSuit());
        assertEquals(CardValue.Dame, cardArray[8].getValue());
        assertEquals(CardSuit.Coeur, cardArray[8].getSuit());
        assertEquals(CardValue.Neuf, cardArray[7].getValue());
        assertEquals(CardSuit.Carreau, cardArray[7].getSuit());
        assertEquals(CardValue.Cinq, cardArray[6].getValue());
        assertEquals(CardSuit.Carreau, cardArray[6].getSuit());
        assertEquals(CardValue.Trois, cardArray[5].getValue());
        assertEquals(CardSuit.Trefle, cardArray[5].getSuit());
        assertEquals(CardValue.As, cardArray[4].getValue());
        assertEquals(CardSuit.Pique, cardArray[4].getSuit());
        assertEquals(CardValue.Huit, cardArray[3].getValue());
        assertEquals(CardSuit.Trefle, cardArray[3].getSuit());
        assertEquals(CardValue.Sept, cardArray[2].getValue());
        assertEquals(CardSuit.Carreau, cardArray[2].getSuit());
        assertEquals(CardValue.Six, cardArray[1].getValue());
        assertEquals(CardSuit.Carreau, cardArray[1].getSuit());
        assertEquals(CardValue.Deux, cardArray[0].getValue());
        assertEquals(CardSuit.Trefle, cardArray[0].getSuit());
    }
}
