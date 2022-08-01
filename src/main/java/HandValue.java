public enum HandValue {
    CARTE_HAUTE("une carte haute : "),
    PAIRE("une paire de "),
    DOUBLE_PAIRE("une double paire de "),
    BRELAN("un brelan de"),
    SUITE("une suite."),
    COULEUR("une couleur."),
    FULL("un full de "),
    CARRE("un carré de "),
    QUINTE_FLUSH("une quinte flush !!!");

    private final String str;

    HandValue(String str) {
        this.str = str;
    }

    /**
     * @return A string (used in order to print the results).
     */
    String getStr() { return str; }
}
