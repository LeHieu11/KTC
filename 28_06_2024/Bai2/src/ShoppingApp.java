public class ShoppingApp {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product("p1", 10.3);
        Product product2 = new Product("p2", 11.2);
        Product product3 = new Product("p3", 15.5);

        Cart myCart = new Cart();
        myCart.addToCart(product1);
        myCart.addToCart(product2);
        myCart.addToCart(product3);

        for (Product p : myCart.products) {
            System.out.println(p.productId + "\t" +
            p.productName + "\t" +
            p.price + "\t" +
            Product.storeName);
        }

        System.out.println("Tong gia tri gio hang: " + myCart.totalPrice());
    }
}
