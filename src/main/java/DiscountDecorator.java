public class DiscountDecorator extends CartDecorator {
    DiscountDecorator(Cart cart) {
        super(cart);
    }

    @Override
    double computeTotalPrice() {
        return this.cart.computeTotalPrice() * 0.8d;
    }
}
