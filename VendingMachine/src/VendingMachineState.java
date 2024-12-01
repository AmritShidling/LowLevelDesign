public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note node);
    void dispenseProduct();
    void returnChange();
}
