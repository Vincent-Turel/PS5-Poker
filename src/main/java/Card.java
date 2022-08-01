// JINJIN
// Class pour le carte
public class Card {
    CardValue value;
    CardSuit suit;
    public Card(CardValue valueInput, CardSuit suitInput){
        this.value = valueInput;
        this.suit = suitInput;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                '}';
    }

    public CardValue getValue(){
        return value;
    }

    public CardSuit getSuit() { return suit; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getValue() == card.getValue() &&
                getSuit() == card.getSuit();
    }
}
