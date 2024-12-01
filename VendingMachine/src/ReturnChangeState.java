import java.util.HashMap;
import java.util.Map;

public class ReturnChangeState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change!");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect the change!");
    }

    @Override
    public void insertNote(Note node) {
        System.out.println("Please collect the change!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please collect the change!");
    }

    @Override
    public void returnChange() {
        double returnChange = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if(returnChange > 0){
            System.out.println("Please collect change: "+ returnChange);
            vendingMachine.resetPayment();
        }
        else {
            System.out.println("No change returned");
        }
        vendingMachine.resetSelectedProduct();
        vendingMachine.setCurrentState(vendingMachine.getIdleState());

    }
}
