import java.util.Arrays;
/**
 * @author Basile
 * @author Eliel Wotobe
 * @author Jinjin Wang
 * @author Vincent Turel
 */


public class Main {

    public static void main(String[] args) {
        Card[] cardArray = new Card[10];

        while (!UserInteraction.readInput(cardArray));

        Hand hand1 = new Hand((Arrays.copyOfRange(cardArray, 0, 5)));
        Hand hand2 = new Hand((Arrays.copyOfRange(cardArray, 5, 10)));

        UserInteraction.printOutput(hand1.compareTo(hand2), hand1, hand2);
    }
}

