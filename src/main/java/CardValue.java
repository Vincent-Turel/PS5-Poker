public enum CardValue {As("A","As"), Roi("R", "Roi"), Dame("D","Dame"), Valet("V", "Valet"),  Dix("10", "10"), Neuf("9", "9"),
    Huit("8", "8"), Sept("7", "7"), Six("6", "6"), Cinq("5", "5"), Quatre("4", "4"), Trois("3", "3"), Deux("2", "2");

    private final String str1;
    private final String str2;

    CardValue(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    /**
     * @return A string that describes a card's value
     */
    public String getStr1() { return str1; }

    /**
     * @return A String (the long description of a card's value) used in order to print the results.
     */
    public String getStr2() { return str2; }
}
