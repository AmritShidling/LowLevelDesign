public class Product {

    private final String name;
    private final double price;
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public boolean equals(Product product){
        return this.name.equals(product.name);
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

}
