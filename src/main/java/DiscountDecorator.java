public class DiscountDecorator extends CartDecorator {
    DiscountDecorator(Cart cart) {
        super(cart);
    }

    double computeTotalPrice() {
        return cart.computeTotalPrice();
    }
}
