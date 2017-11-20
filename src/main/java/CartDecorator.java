import java.util.Arrays;

public class CartDecorator extends Cart {
    Cart cart;

    CartDecorator(Cart cart) {
        this.cart = cart;
    }

    @Override
    boolean ship() {
        return true;
    }

    @Override
    double computeTotalPrice() {
        double price = 0;
        for (ComputerGame game : this.cart.games) {
            price += game.getProperties().getPrice();
        }
        return price;
    }

    @Override
    public Cart addGames(ComputerGame... games){
        this.cart.games.addAll(Arrays.asList(games));
        return this;
    }

    @Override
    public PaymentStrategy getPaymentStrategy() {
        return this.cart.getPaymentStrategy();
    }

    @Override
    public Cart setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.cart.setPaymentStrategy(paymentStrategy);
        return this;
    }

    @Override
    public DeliveryStrategy getDeliveryStrategy() {
        return this.cart.getDeliveryStrategy();
    }

    @Override
    public Cart setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.cart.setDeliveryStrategy(deliveryStrategy);
        return this;
    }
}
