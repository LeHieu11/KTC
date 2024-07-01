import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products;

    public Cart(){
        products = new ArrayList<>();
    }

    public void addToCart(Product p){
        this.products.add(p);
    }

    public double totalPrice(){
        double ans = 0.0;

        for (Product product : products) {
            ans += product.price;
        }

        return ans;
    }
}
