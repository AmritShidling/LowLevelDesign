import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Product, Integer> products;
    public Inventory(){
        this.products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity){
        this.products.put(product, quantity);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public void updateProduct(Product product, int quantity){
        this.products.put(product, quantity);
    }

    public int getQuantity(Product product){
        return this.products.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product){
        return this.getQuantity(product) > 0;
    }
}
