public class ReadyState implements VendingMachineState{

    private final VendingMachine vendingMachine;
    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected. Please make payment!");
    }

    private void checkPaymentStatus(){
        if(this.vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()){
            this.vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }
    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: "+ coin.getValue());
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: "+ note.getValue());
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make this payment first");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make this payment first");
    }
}
