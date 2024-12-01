public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected!");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already made!");
    }

    @Override
    public void insertNote(Note node) {
        System.out.println("Payment already made!");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateProduct(product, vendingMachine.inventory.getQuantity(product)-1);
        System.out.println("Product dispensed: "+ product.getName());
        vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect the product first");
    }
}
