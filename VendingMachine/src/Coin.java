public enum Coin {
    PENNY(0.01),
    NICKLE(0.05),
    DIME(0.1),
    QUARTER(0.25)
    ;

    private final double value;

    Coin(double v) {
        this.value  = v;
    }

    public double getValue(){
        return this.value;
    }
}
