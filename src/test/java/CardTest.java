import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CardTest {

    Card card = new Card(CardValue.As, CardSuit.Coeur);
    Card card2 = new Card(CardValue.As, CardSuit.Coeur);
    Card card3 = new Card(CardValue.Roi, CardSuit.Coeur);
    Card card4 = new Card(CardValue.As, CardSuit.Pique);


    @Test
    public void getValue_shouldReturnValue(){
        assertEquals(card.getValue(),CardValue.As);
    }

    @Test
    public void getSuit_shouldReturnSuit(){
        assertEquals(card.getSuit(), CardSuit.Coeur);
    }

    @Test
    public void shouldBeEqual(){
        assertEquals(card, card2);
        assertNotEquals(card, card3);
        assertNotEquals(card, card4);
    }
}
