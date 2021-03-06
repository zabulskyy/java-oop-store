import java.util.ArrayList;
import java.util.Arrays;

public class Cart extends Observable{
    ArrayList<ComputerGame> games;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;

    Cart() {
        this.games = new ArrayList<>();
    }

    boolean ship() {
        return true;
    }

    double computeTotalPrice() {
        double price = 0;
        for (ComputerGame game : this.games) {
            price += game.getProperties().getPrice();
        }
        return price;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public Cart setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        return this;
    }

    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

    public Cart setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
        return this;
    }


    public Cart addGames(ComputerGame... games) {
        this.games.addAll(Arrays.asList(games));
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cart)) return false;
        Cart newobj = (Cart) obj;
        return (newobj.games == this.games
                && newobj.getDeliveryStrategy() == this.getDeliveryStrategy()
                && newobj.getPaymentStrategy() == this.getPaymentStrategy());
    }
}
