import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    Card[] arrayCard;
    int[][] tableauFrq;
    HandValue handValue;

    public Hand(Card... card) {
        this.arrayCard = card;
        this.tableauFrq = analyzeHand();
        this.handValue = setHandValue();
    }

    HandValue setHandValue() {
        if (quinteFlush()) return HandValue.QUINTE_FLUSH;
        else if (couleur()) return HandValue.COULEUR;
        else if (suite()) return HandValue.SUITE;
        if (carre()) return HandValue.CARRE;
        else if (full()) return HandValue.FULL;
        else if (brelan()) return HandValue.BRELAN;
        else if (doublePaire()) return HandValue.DOUBLE_PAIRE;
        else if (paire()) return HandValue.PAIRE;
        else return HandValue.CARTE_HAUTE;
    }

    boolean paire() {
        return (tableauFrq[0][1] == 2);
    }

    boolean doublePaire() {
        return ((tableauFrq[0][1] == 2) && (tableauFrq[1][1] == 2));
    }

    boolean brelan() {
        return (tableauFrq[0][1] == 3);
    }

    boolean full() {
        return ((tableauFrq[0][1] == 3) && (tableauFrq[1][1] == 2));
    }

    //Vérifier si c'est la combinaison est une SUITE ou pas
    boolean suite() {
        if (tableauFrq.length != 5) return false;
        for (int i = 0; i < tableauFrq.length - 1; i++)
            if (!(tableauFrq[i][0] + 1 == tableauFrq[i + 1][0])) return false;
        return true;
    }

    boolean couleur() {
        return Arrays.stream(arrayCard).map(Card::getSuit).allMatch(suit -> suit.equals(arrayCard[0].getSuit()));
    }

    /**
     * detect if there is square among the cards
     * @return True if the hand contains a square
     * @author Eliel WOTOBE
     */
    boolean carre() {
        return tableauFrq[0][1] == 4;
    }

    boolean quinteFlush() {
        return couleur() && suite();
    }

    @Override
    public int compareTo(Hand hand) {
        if (this.handValue.ordinal() < hand.handValue.ordinal())
            return -1;// La seconde main gagne
        else if (this.handValue.ordinal() > hand.handValue.ordinal())
            return 1; //La première main gagne ;
        else {
            for (int j = 0; j < tableauFrq.length; j++) {
                if (this.tableauFrq[j][0] < hand.tableauFrq[j][0])
                    return 1;
                else if (this.tableauFrq[j][0] > hand.tableauFrq[j][0])
                    return -1;
            }
        }
        return 0;
    }

    // Creer un tableau de frequence qui indiquer combien de fois une carte apparaît
    int[][] analyzeHand() {
        int[][] res = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        List<CardValue> liste = new ArrayList<>();
        for (Card carte : arrayCard) {
            liste.add(carte.getValue());
        }
        Collections.sort(liste);
        List<CardValue> deja_test = new ArrayList<>();
        for (CardValue elem : liste) {
            if (!deja_test.contains(elem)) {
                deja_test.add(elem);
                for (int i = 0; i < liste.size(); i++) {
                    if (Collections.frequency(liste, elem) > res[i][1]) {
                        for (int j = 4; j > i; j--) {
                            res[j][0] = res[j - 1][0];
                            res[j][1] = res[j - 1][1];
                        }
                        res[i][1] = Collections.frequency(liste, elem);
                        res[i][0] = elem.ordinal();
                        break;
                    }
                }
            }
        }
        int k;
        for (k = 0; k < res.length; k++) {
            if (res[k][1] == 0)
                break;
        }
        return Arrays.copyOfRange(res, 0, k);
    }
}

