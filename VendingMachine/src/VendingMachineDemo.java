public class VendingMachineDemo {

    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getVendingMachine();
        Product coke = new Product("Coke", 1.5);
        Product pepsi = new Product("Pepsi", 1.5);
        Product water = new Product("Water", 1.0);

        vendingMachine.inventory.addProduct(coke, 5);
        vendingMachine.inventory.addProduct(pepsi,3);
        vendingMachine.inventory.addProduct(water, 2);

        vendingMachine.selectProduct(coke);

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertNote(Note.FIVE);

        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();


    }
}
