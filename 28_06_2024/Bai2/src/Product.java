import java.util.Random;

/**
 * Product
 */
public class Product {
    int productId;
    String productName;
    double price;
    static final String storeName = "ABC Store";

    public Product(String name, double price){
        this.productId = new Random().nextInt(100);
        this.productName = name;
        this.price = price;
    }
    
}