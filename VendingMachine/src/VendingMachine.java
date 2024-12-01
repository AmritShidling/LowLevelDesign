import org.w3c.dom.Node;

import javax.xml.datatype.Duration;

public class VendingMachine implements VendingMachineState{
    private VendingMachineState vendingMachineState;
    Inventory inventory;

    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    private Product selectedProduct;
    private double totalPayment;

    private static VendingMachine vendingMachine;
    private VendingMachine() {

        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public static synchronized VendingMachine getVendingMachine(){
        if(vendingMachine == null) vendingMachine = new VendingMachine();
        return vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    @Override
    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    @Override
    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    @Override
    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    @Override
    public void returnChange() {
        currentState.returnChange();
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }


    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void resetSelectedProduct(){
        this.selectedProduct = null;
    }
    public void resetPayment(){
        this.totalPayment = 0.0;
    }

    public void  addCoin(Coin coin){
        this.totalPayment += coin.getValue();
    }
    public void addNote(Note note){
        this.totalPayment += note.getValue();
    }
}
