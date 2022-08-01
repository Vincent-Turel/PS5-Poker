import java.util.Arrays;
import java.util.Scanner;

public class UserInteraction {



    /**
     * Asks the user which hand he wants to compare and processes them.
     * @param cardArray A tab of cards to fill up.
     * @return True if the input has correctly been read. False otherwise.
     */
    static boolean readInput(Card[] cardArray) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Main 1:  ");
        String input = sc.nextLine();
        System.out.print("Main 2:  ");
        input += " " + sc.nextLine();
        String[] cards = input.split("\\s+");
        return convertStringToCard(cards, cardArray);
    }

    /**
     *
     * @param cards An array of String which contains the 10 cards.
     * @param cardArray An array of cards ready to be fill up.
     * @return True if the input has correctly been read. False otherwise.
     */
    static boolean convertStringToCard(String[] cards, Card[] cardArray){
        Arrays.fill(cardArray, null);
        if (cards.length != 10) return ProcessProblem.toDo(new RuntimeException("Incorrect amount of cards"));
        for(int i = 0; i < 10; i++) {
            CardValue x = null;
            CardSuit y = null;
            for (CardValue elem : CardValue.values())
                if (cards[i].startsWith(elem.getStr1())) {
                    x = elem;
                    break;
                }
            if (x == null) return ProcessProblem.toDo(new RuntimeException("Incorrect value format"));
            for (CardSuit elem : CardSuit.values()) {
                if (cards[i].substring(x.getStr1().length()).equals(elem.getStr())) {
                    y = elem;
                    break;
                }
            }
            if (y == null) return ProcessProblem.toDo(new RuntimeException("Incorrect suit format"));
            Card card = new Card (x, y);
            if (Arrays.asList(cardArray).contains(card))
                return ProcessProblem.toDo(new RuntimeException("Twice the same card"));
            cardArray[i] = card;
        }
        return true;
    }

    /**
     * Gives the results to the user.
     * @param res The result of the comparison between 2 hands
     * @param hand1 The first hand
     * @param hand2 The second hand
     */
    static void printOutput(int res, Hand hand1, Hand hand2){
        CardValue[] chartValues = CardValue.values();

        if(res == 1){
            //Vérification de la présence d'une quinte flush ou une couleur ou une suite
            if(hand1.handValue.ordinal() == 4 || hand1.handValue.ordinal() == 5 || hand1.handValue.ordinal() == 8){
                System.out.println("La main 1 gagne avec "+hand1.handValue.getStr());
            }
            //Vérification des cas de paire, double paire, brelan, carre et full
            else {
                System.out.println("La main 1 gagne avec "+hand1.handValue.getStr()+chartValues[hand1.tableauFrq[0][0]].getStr2());
            }
        }

        else if (res == -1) {

            //Vérification de la présence d'une quinte flush ou une couleur ou une suite
            if(hand2.handValue.ordinal() == 4 || hand2.handValue.ordinal() == 5 || hand2.handValue.ordinal() == 8){
                System.out.println("La main 2 gagne avec "+hand2.handValue.getStr());
            }
            //Vérification des cas de paire, double paire, brelan, carre et full
            else {
                System.out.println("La main 2 gagne avec "+hand2.handValue.getStr()+chartValues[hand2.tableauFrq[0][0]].getStr2());
            }
        }
        else
            System.out.println("Egalité");
    }
}
