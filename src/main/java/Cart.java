import java.util.ArrayList;

public class Cart {
    private ArrayList<ComputerGame> games = new ArrayList<>();
    PaymentStrategy paymentStrategy;
    DeliveryStrategy deliveryStrategy;

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

    void addGamesToCart(ArrayList<ComputerGame> games) {
        this.games.addAll(games);
    }


}
