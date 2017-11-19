public class CartDecorator extends Cart{
    Cart cart;

    CartDecorator(Cart cart) {
        this.cart = cart;
    }
}
