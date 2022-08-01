public enum CardSuit {
    Pique("Pi"),
    Carreau("Ca"),
    Coeur("Co"),
    Trefle("Tr");

    private final String str;

    CardSuit(String str){ this.str = str; }

    /**
     * @return A string that describes a card's flush
     */
    public String getStr() { return str; }
}
